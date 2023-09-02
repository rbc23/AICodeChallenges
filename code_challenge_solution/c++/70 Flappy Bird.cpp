```cpp
#include <iostream>
#include <conio.h>

using namespace std;

const int WIDTH = 30;
const int HEIGHT = 20;
int birdX, birdY;
int pipeX[3], pipeY[3];
int score;

bool isGameOver;

void setup()
{
    birdX = WIDTH / 3;
    birdY = HEIGHT / 2;

    pipeX[0] = WIDTH;
    pipeY[0] = 0;
    pipeX[1] = WIDTH + WIDTH / 2;
    pipeY[1] = 0;
    pipeX[2] = WIDTH + WIDTH;
    pipeY[2] = 0;

    score = 0;
    isGameOver = false;
}

void draw()
{
    system("cls");

    for (int i = 0; i < HEIGHT; i++)
    {
        for (int j = 0; j < WIDTH; j++)
        {
            if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1)
                cout << "#";
            else if (i == birdY && j == birdX)
                cout << "V";
            else if ((j == pipeX[0] || j == pipeX[1] || j == pipeX[2]) && (i < pipeY[0] || i > pipeY[0] + HEIGHT / 3))
                cout << "#";
            else
                cout << " ";
        }
        cout << endl;
    }

    cout << "Score: " << score << endl;

    if (isGameOver)
        cout << "Game Over!" << endl;
}

void input()
{
    if (_kbhit())
    {
        switch (_getch())
        {
        case ' ':
            birdY--;
            break;
        case 'q':
            isGameOver = true;
            break;
        }
    }
}

void update()
{
    birdY++;

    if (birdY == HEIGHT - 1 || birdY == 0)
        isGameOver = true;

    for (int i = 0; i < 3; i++)
    {
        if (pipeX[i] == birdX)
        {
            score++;
            break;
        }
    }

    for (int i = 0; i < 3; i++)
    {
        pipeX[i]--;
        if (pipeX[i] < 0)
        {
            pipeX[i] = WIDTH - 1;
            pipeY[i] = rand() % (HEIGHT / 3);
        }
    }
}

int main()
{
    setup();

    while (!isGameOver)
    {
        draw();
        input();
        update();
    }

    return 0;
}
```