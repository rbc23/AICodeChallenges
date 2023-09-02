Here is the C++ code for a Tetris clone:

```c++
#include <iostream>
#include <conio.h>
#include <windows.h>

using namespace std;

const int WIDTH = 12;
const int HEIGHT = 24;
int field[HEIGHT][WIDTH] = { 0 };

wstring tetromino[7];
int nScreenWidth = 80;
int nScreenHeight = 30;

int Rotate(int px, int py, int r)
{
    int pi = 0;
    switch (r % 4)
    {
        case 0: // 0 degrees			// 0  1  2  3
            pi = py * 4 + px;		// 4  5  6  7
            break;					// 8  9 10 11
                                    //12 13 14 15
			
        case 1: // 90 degrees			//12  8  4  0
            pi = 12 + py - (px * 4);	//13  9  5  1
            break;					//14 10  6  2
                                    //15 11  7  3
			
        case 2: // 180 degrees			//15 14 13 12
            pi = 15 - (py * 4) - px;	//11 10  9  8
            break;					// 7  6  5  4
                                    // 3  2  1  0
			
        case 3: // 270 degrees			// 3  7 11 15
            pi = 3 - py + (px * 4);	// 2  6 10 14
            break;					// 1  5  9 13
    }								// 0  4  8 12

    return pi;
}

bool DoesPieceFit(int nTetromino, int nRotation, int nPosX, int nPosY)
{
    // All Field cells >0 are occupied
    for (int px = 0; px < 4; px++)
        for (int py = 0; py < 4; py++)
        {
            // Get index into piece
            int pi = Rotate(px, py, nRotation);

            // Get index into field
            int fi = (nPosY + py) * WIDTH + (nPosX + px);

            // Check that test is in bounds. Note out of bounds does
            // actually return tiles that are marked as out of bounds
            // for ghost pieces so we'll just ignore them
            if (nPosX + px >= 0 && nPosX + px < WIDTH)
            {
                // In Bounds so do collision check
                if (nPosY + py >= 0 && nPosY + py < HEIGHT)
                {
                    // Does our test collide with the stopping cells
                    if (tetromino[nTetromino][pi] != L'.' && field[fi] != 0)
                        return false;
                }
            }
        }

    return true;
}

int main()
{
    // Create Screen Buffer
    wchar_t* screen = new wchar_t[nScreenWidth * nScreenHeight];
    for (int i = 0; i < nScreenWidth * nScreenHeight; i++) screen[i] = L' ';
    HANDLE hConsole = CreateConsoleScreenBuffer(GENERIC_READ | GENERIC_WRITE, 0, NULL, CONSOLE_TEXTMODE_BUFFER, NULL);
    SetConsoleActiveScreenBuffer(hConsole);
    DWORD dwBytesWritten = 0;

    tetromino[0].append(L"..X...X...X...X."); // Tetronimos 4x4
    tetromino[1].append(L"..X..XX...X.....");
    tetromino[2].append(L".....XX..XX.....");
    tetromino[3].append(L"..X..XX..X......");
    tetromino[4].append(L".X...XX...X.....");
    tetromino[5].append(L".X...X...XX.....");
    tetromino[6].append(L"..X...X..XX.....");

    int nCurrentPiece = 0;
    int nCurrentRotation = 0;
    int nCurrentX = WIDTH / 2;
    int nCurrentY = 0;

    bool bKey[4];
    bool bGameOver = false;
    bool bForceDown = false;
    bool bRotateHold = true;
    bool bPrintPieces[] = { false, false, false, false, false, false, false };

    int nSpeed = 20;
    int nSpeedCounter = 0;
    bool bForceDownTemp = false;

    int nPieceCount = 0;
    int nScore = 0;


    while (!bGameOver) // Main Game Loop
    {
        // Game Timing =====
        this_thread::sleep_for(50ms); // Small Step = 1 Game Tick
        nSpeedCounter++;
        bKey[0] = (0x8000 & GetAsyncKeyState((unsigned char)('\x25'))) != 0; // Left
        bKey[1] = (0x8000 & GetAsyncKeyState((unsigned char)('\x27'))) != 0; // Right
        bKey[2] = (0x8000 & GetAsyncKeyState((unsigned char)('\x28'))) != 0; // Down
        bKey[3] = (0x8000 & GetAsyncKeyState((unsigned char)('\x26'))) != 0; // Rotate

        // Game Logic =====
        if (bKey[0] && DoesPieceFit(nCurrentPiece, nCurrentRotation, nCurrentX - 1, nCurrentY))
            nCurrentX--; // Move left

        if (bKey[1] && DoesPieceFit(nCurrentPiece, nCurrentRotation, nCurrentX + 1, nCurrentY))
            nCurrentX++; // Move right

        if (bKey[2])
        {
            if (DoesPieceFit(nCurrentPiece, nCurrentRotation, nCurrentX, nCurrentY + 1))
            {
                nCurrentY++; // Move down
                bForceDown = false;
                bForceDownTemp = true;

                nSpeedCounter = 0;
            }
            else
                bForceDown = true;
        }

        if (bKey[3])
        {
            if (bRotateHold && DoesPieceFit(nCurrentPiece , nCurrentRotation + 1, nCurrentX, nCurrentY))
            {
                nCurrentRotation++; // Rotate right
                bRotateHold = false;
            }
        }
        else
            bRotateHold = true;

        if (nSpeedCounter == nSpeed)
        {
            if (DoesPieceFit(nCurrentPiece, nCurrentRotation, nCurrentX, nCurrentY + 1))
            {
                nCurrentY++; // Move down
                bForceDown = false;
                bForceDownTemp = true;
            }
            else
                bForceDown = true;

            nSpeedCounter = 0;
        }


        // Collision Detection
        int nPiece = 0;
        int nRotation = 0;
        for (int px = 0; px < 4; px++)
            for (int py = 0; py < 4; py++)
            {
                // Get index into piece
                int pi = Rotate(px, py, nCurrentRotation);

                // Get index into field
                int fi = (nCurrentY + py) * WIDTH + (nCurrentX + px);

                // Check if test grid cell is solid ( > 0 )
                if (nCurrentX + px >= 0 && nCurrentX + px < WIDTH)
                {
                    if (nCurrentY + py >= 0 && nCurrentY + py < HEIGHT)
                    {
                        // CollisionTest = FieldCell && (PieceCell != 0)
                        if (tetromino[nCurrentPiece][pi] != L'.' && field[fi] != 0)
                        {
                            // Game Over
                            bGameOver = true;
                            cout << "Game Over!\n";
                        }
                    }
                }
            }

        // Lock current piece in the field
        if (!bForceDown && bForceDownTemp)
        {
            for (int px = 0; px < 4; px++)
                for (int py = 0; py < 4; py++)
                {
                    // Get index into piece
                    int pi = Rotate(px, py, nCurrentRotation);

                    // Get index into field
                    int fi = (nCurrentY + py) * WIDTH + (nCurrentX + px);

                    // Set field if test is part of current piece
                    if (nCurrentX + px >= 0 && nCurrentX + px < WIDTH)
                    {
                        if (nCurrentY + py >= 0 && nCurrentY + py < HEIGHT)
                        {
                            if (tetromino[nCurrentPiece][pi] != L'.')
                                field[fi] = nCurrentPiece + 1;
                        }
                    }
                }

            nPieceCount++;
            if (nPieceCount % 10 == 0)
                if (nSpeed >= 10)
                    nSpeed--;

            // Check have we got any lines
            for (int py = 0; py < 4; py++)
                if (nCurrentY + py < HEIGHT - 1) // -1 because we also play the 1st hidden row
                {
                    bool bLine = true;
                    for (int px = 1; px < WIDTH - 1; px++) // Don't check edges as they are always solid walls
                        bLine &= (field[(nCurrentY + py) * WIDTH + px]) != 0;

                    if (bLine)
                    {
                        // Remove Line, set to =
                        for (int px = 1; px < WIDTH - 1; px++)
                            field[(nCurrentY + py) * WIDTH + px] = 8;

                        bPrintPieces[nCurrentPiece] = true;
                    }
                }

            nScore += 25;
            if (!bPrintPieces[nCurrentPiece])
                nScore += 100;

            // Choose next piece
            nCurrentX = WIDTH / 2;
            nCurrentY = 0;
            nCurrentRotation = 0;
            nCurrentPiece = rand() % 7;

            // If piece does not fit straight away, game over!
            bGameOver = !DoesPieceFit(nCurrentPiece, nCurrentRotation, nCurrentX, nCurrentY);

            bForceDownTemp = false;
        }

        // Display =====
        // Draw Field
        for (int x = 0; x < WIDTH; x++) // DrawLeftWall
            for (int y = 0; y < HEIGHT; y++) // Draw rest of field
                screen[(y + 2) * nScreenWidth + (x + 2)] = L" ABCDEFG=#"[field[y * WIDTH + x]];

        // Draw CurrentPiece
        for (int px = 0; px < 4; px++)
            for (int py = 0; py < 4; py++)
                if (tetromino[nCurrentPiece][Rotate(px, py, nCurrentRotation)] != L'.') // Draw blocks that make up piece
                    screen[(nCurrentY + py + 2) * nScreenWidth + (nCurrentX + px + 2)] = nCurrentPiece + 65;

        // Draw Score
        swprintf_s(&screen[2 * nScreenWidth + nScreenWidth - 13], 16, L"SCORE: %8d", nScore);

        // Animate Line Completion
        for (int py = 0; py < 4; py++)
            if (bPrintPieces[nCurrentPiece])
                for (int px = 1; px < WIDTH - 1; px++)
                    screen[(nCurrentY + py + 2) * nScreenWidth + (nCurrentX + px + 2)] = 7 + 48;

        // Display Frame
        WriteConsoleOutputCharacter(hConsole, screen, nScreenWidth * nScreenHeight, { 0,0 }, &dwBytesWritten);
    }

    delete[] screen;
    CloseHandle(hConsole);
    cout << "Game Over. Score:" << nScore << endl;
    system("pause");
    return 0;
}
```

This is a simple implementation of Tetris using ASCII characters. You can run this code and start playing the game.