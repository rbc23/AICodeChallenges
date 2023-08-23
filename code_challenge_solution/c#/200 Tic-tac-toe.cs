using System;

namespace TicTacToe
{
    class Program
    {
        static char[] board = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        static int player = 1; // Player 1 will start the game
        static int choice; // Position chosen by the current player

        // Check if the current player has won the game
        static int CheckWin()
        {
            #region Horzontal Winning Condtion

            // Winning Condition For First Row
            if (board[0] == board[1] && board[1] == board[2] && board[0] != ' ')
                return 1;
            // Winning Condition For Second Row
            else if (board[3] == board[4] && board[4] == board[5] && board[3] != ' ')
                return 1;
            // Winning Condition For Third Row
            else if (board[6] == board[7] && board[7] == board[8] && board[6] != ' ')
                return 1;

            #endregion

            #region Vertical Winning Condtion

            // Winning Condition For First Column
            else if (board[0] == board[3] && board[3] == board[6] && board[0] != ' ')
                return 1;
            // Winning Condition For Second Column
            else if (board[1] == board[4] && board[4] == board[7] && board[1] != ' ')
                return 1;
            // Winning Condition For Third Column
            else if (board[2] == board[5] && board[5] == board[8] && board[2] != ' ')
                return 1;

            #endregion

            #region Diagonal Winning Condition

            // Winning Condition For First Diagonal
            else if (board[0] == board[4] && board[4] == board[8] && board[0] != ' ')
                return 1;
            // Winning Condition For Second Diagonal
            else if (board[2] == board[4] && board[4] == board[6] && board[2] != ' ')
                return 1;

            #endregion

            #region Checking For Draw

            // If all the positions on the board are filled
            else if (board[0] != ' ' && board[1] != ' ' && board[2] != ' ' &&
                     board[3] != ' ' && board[4] != ' ' && board[5] != ' ' &&
                     board[6] != ' ' && board[7] != ' ' && board[8] != ' ')
                return -1;

            #endregion

            else
                return 0;
        }

        // Print the current state of the board
        static void PrintBoard()
        {
            Console.WriteLine("     |     |      ");
            Console.WriteLine("  {0}  |  {1}  |  {2}", board[0], board[1], board[2]);
            Console.WriteLine("_____|_____|_____ ");
            Console.WriteLine("     |     |      ");
            Console.WriteLine("  {0}  |  {1}  |  {2}", board[3], board[4], board[5]);
            Console.WriteLine("_____|_____|_____ ");
            Console.WriteLine("     |     |      ");
            Console.WriteLine("  {0}  |  {1}  |  {2}", board[6], board[7], board[8]);
            Console.WriteLine("     |     |      ");
        }

        // Main method
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Tic Tac Toe!");

            do
            {
                // Clear the console
                Console.Clear();

                Console.WriteLine("Player 1: X and Player 2: O");
                Console.WriteLine("\n");

                if (player % 2 == 0)
                {
                    Console.WriteLine("Player 2's turn");
                }
                else
                {
                    Console.WriteLine("Player 1's turn");
                }

                Console.WriteLine("\n");

                PrintBoard();

                // Check if the chosen position is already marked or not
                bool validInput = false;
                while (!validInput)
                {
                    validInput = true;
                    Console.WriteLine("Choose your position (1-9): ");
                    choice = Convert.ToInt32(Console.ReadLine());

                    if (board[choice - 1] != ' ')
                    {
                        Console.WriteLine("Sorry, the row {0} is already marked with {1}.", choice, board[choice - 1]);
                        validInput = false;
                    }
                }

                // Set the chosen position with 'X' or 'O' based on the current player
                if (player % 2 == 0)
                {
                    board[choice - 1] = 'O';
                    player++;
                }
                else
                {
                    board[choice - 1] = 'X';
                    player++;
                }

                // Check if the current player has won the game
                int winner = CheckWin();

                Console.Clear();

            } while (CheckWin() != 1 && CheckWin() != -1);

            PrintBoard();

            // Print the result of the game
            if (CheckWin() == 1)
            {
                Console.WriteLine("Player {0} has won!", (player % 2) + 1);
            }
            else
            {
                Console.WriteLine("It's a draw!");
            }

            Console.ReadLine();
        }
    }
}
|![[MGV_ALL_CAPTURED_SQL]]|Visualização de dados com informações sobre consultas SQL.|
|![[MGV_ALL_CATALOGS]]|View MGV_ALL_CATALOGS armazena informações sobre catálogos.|
|![[MGV_ALL_CATALOG_DETAILS]]|View para armazenar informações sobre objetos, esquemas, catálogos e conexões.|
|![[MGV_ALL_COLUMNDT_DETAILS]]|View MGV_ALL_COLUMNDT_DETAILS armazena detalhes colunas objetos não definidos.|
|![[MGV_ALL_COLUMN_DETAILS]]|View MGV_ALL_COLUMN_DETAILS: informações detalhadas sobre colunas.|
|![[MGV_ALL_CONNECTIONS]]|View MGV_ALL_CONNECTIONS armazena informações sobre todas as conexões.|
|![[MGV_ALL_CONSTRAINTS_DETAILS]]|View para detalhes de restrições de objeto não especificado.|
|![[MGV_ALL_DETAILS]]|Visualização de dados com informações sobre objetos.|
|![[MGV_ALL_INDEX_DETAILS]]|View MGV_ALL_INDEX_DETAILS armazena informações sobre índices.|
|![[MGV_ALL_PARTITIONS_DETAILS]]|View MGV_ALL_PARTITIONS_DETAILS: detalhes de partições de objetos.|
|![[MGV_ALL_PROGRAMS_DETAILS]]|Visualização com informações sobre programas, tipo, nome, ID, objeto principal, esquema, catálogo, conexão, projeto e captura/conversão.|
|![[MGV_ALL_SCHEMA]]|View MGV_ALL_SCHEMA exibe informações sobre esquemas.|
|![[MGV_ALL_SCHEMA_DETAILS]]|View MGV_ALL_SCHEMA_DETAILS exibe detalhes indefinidos de esquemas, objetos e conexões.|
|![[MGV_ALL_STORED_PROGRAMS]]|View MGV_ALL_STORED_PROGRAMS lista programas armazenados com informações.|
|![[MGV_ALL_TABLES]]|View que armazena informações sobre todas as tabelas.|
|![[MGV_ALL_TABLES_DETAILS]]|View MGV_ALL_TABLES_DETAILS exibe detalhes de todas as tabelas.|
|![[MGV_ALL_TABLE_TRIGGERS]]|View para listar gatilhos de tabela em projeto específico.|
|![[MGV_ALL_TRIGGER_DETAILS]]|View MGV_ALL_TRIGGER_DETAILS armazena informações sobre gatilhos.|
|![[MGV_ALL_VIEWS]]|Visualização com informações sobre visualizações de projeto específico.|
|![[MGV_ALL_VIEW_DETAILS]]|Visualização com informações indefinidas sobre objetos, esquemas, catálogos, conexões e projetos.|
|![[MGV_ALL_VIEW_TRIGGERS]]|View para armazenar informações sobre gatilhos de visualização.|
|![[MGV_DERIVATIVES]]|Visualização de dados com informações sobre derivativos.|
|![[MGV_DERIVED_DETAILS]]|Armazena informações sobre detalhes derivados de objetos.|
|![[MGV_SCRATCH_DERIVATIVES]]|Visualização de dados com propósito e propriedades indefinidas.|
|![[ST_TRANSACTION_V]]|View ST_TRANSACTION_V armazena informações detalhadas sobre transações.|
|![[VG_AREAS_PRECOS_V]]|View VG_AREAS_PRECOS_V: armazena informações sobre áreas de preços, incluindo localização geográfica, criação e alteração, detalhes sobre preços.|
|![[VG_COMISSAO_EVENTS_V]]|View VG_COMISSAO_EVENTS_V fornece informações detalhadas sobre eventos de comissão.|
|![[VG_COMISSAO_LOJAS]]|View com informações de comissões de lojas.|
|![[VG_DISTRIBUIDORES_V]]|View com informações de distribuidores: ID, endereço, documento, razão social, número, complemento, bairro, UF, município, código e número da CIA.|
|![[VG_DISTRUTOR_V]]|Visualização de informações sobre distribuidores e cobranças.|
|![[VG_MERCADOS]]|Informações sobre mercados e micro mercados.|
|![[VG_PRECO_MAP_V]]|View VG_PRECO_MAP_V: informações preços produtos, localizações.|
|![[VG_PRICE_STORE_V]]|View com informações de lojas, produtos e atendimento.|
|![[VG_REDES_EVENTS_V]]|View VG_REDES_EVENTS_V exibe informações sobre eventos de redes.|
|![[VG_REDE_LOJAS_EVENTS_V]]|View VG_REDE_LOJAS_EVENTS_V exibe informações sobre eventos.|
|![[VG_REQUESTED_VOUCHER_V]]|View VG_REQUESTED_VOUCHER_V exibe informações sobre solicitações de vouchers.|
|![[VG_RESEALE_DELIVERY_ACTUAL_V]]|View com informações de entregas atuais detalhadas.|
|![[VG_RESEALE_DELIVERY_HIST_V]]|Histórico de entregas excluídas com informações detalhadas.|
|![[VG_RESEALE_DELIVERY_V]]|View VG_RESEALE_DELIVERY_V exibe informações sobre entregas reembaladas.|
|![[VG_REVENDAS_V]]|Visualização dos dados de revendas com informações detalhadas.|
|![[VW_AREAS_HUBS]]|Visualização de dados com informações sobre áreas e hubs geográficos.|
|![[VW_AREAS_HUBS_MAPAS_V]]|Visualização de dados com áreas, hubs, mapas e zonas de preço.|
|![[VW_AREAS_HUBS_PRICE_ZONE_V]]|Visualização com informações sobre áreas, hubs e zonas de preço.|
|![[VW_AREAS_HUBS_V]]|Visualização de dados com áreas, hubs e zonas.|
|![[VG_AREAS_PRECOS]]|Armazena informações sobre áreas de preços geográficas.|
|![[VG_REVENDAS]]|Tabela VG_REVENDAS: dados revendas, razão social, código, documento, nome fantasia, endereço, número cliente.|
|![[HTMLDB_PLAN_TABLE]]|Tabela para armazenar informações sobre plano de execução.|
|![[VG_PARAMETROS_SOA]]|Armazena informações de configuração de serviço SOA.|
|![[VG_CLIENTES]]|Tabela VG_CLIENTES contém classificação, documentos, endereços e informações.|
|![[VG_DISTRIBUIDORES_CONFIG]]|Tabela VG_DISTRIBUIDORES_CONFIG: CNPJ, ID organização, flag convênio, ID cabeçalho parâmetros.|
|![[VG_VALES_VALIDOS]]|Tabela VG_VALES_VALIDOS armazena informações sobre vales válidos.|
|![[VG_DISTRIBUIDORES]]|A tabela VG_DISTRIBUIDORES contém informações sobre distribuidores.|
|![[VG_HOTSITE]]|Tabela de banco de dados para hotsite.|
|![[SF_INTENTIONS_LIST]]|Tabela SF_INTENTIONS_LIST: ID, pontuação, nome, datas.|
|![[SF_LUGAR_FAVORITO]]|Tabela SF_LUGAR_FAVORITO: login, latitude, longitude, ID lugar, zoom.|
|![[VG_DISTRIBUIDORES_PRECOS]]|Tabela com informações sobre preços e distribuidores.|
|![[VG_PRODUTOS]]|Tabela VG_PRODUTOS: descrição, imagens, thumbnails, nome, data criação/alteração, detalhes recarga.|
|![[TB_TRANSACTIONS]]|A tabela TB_TRANSACTIONS armazena informações sobre transações.|
|![[GEO]]|Tabela armazena dados geográficos em formato JSON.|
|![[VG_HISTORICO]]|Tabela VG_HISTORICO armazena histórico de ações.|
|![[TB_VOUCHERS_STATUS]]|Tabela com status de vouchers, descrição, ID e nome.|
|![[VG_VOUCHERS]]|Armazena informações de transações de vouchers telefônicos.|
|![[TB_ERROS]]|Tabela TB_ERROS armazena detalhes de erros ocorridos.|
|![[VG_USERS]]|Tabela VG_USERS armazena informações sobre usuários.|
|![[VG_REDE]]|Tabela VG_REDE: lojas, endereço, nome, alteração, cliente, criação, documento.|
|![[VG_ERROS]]|Tabela VG_ERROS armazena informações sobre erros.|
|![[TESTE_LOG]]|Tabela TESTE_LOG com dois campos VARCHAR2.|
|![[VG_IMAGENS]]|Tabela "VG_IMAGENS" armazena informações sobre imagens.|
|![[TB_LOG]]|Tabela TB_LOG armazena registros de log.|
|![[VG_REDE_LOJA]]|Armazena informações sobre endereços, rede, documentos e clientes de lojas.|
|![[VG_DISTRIBUIDOR_PRODUTOS]]|Tabela VG_DISTRIBUIDOR_PRODUTOS: ID cliente, ID produto, ID endereço, valor produto.|
|![[VG_LOG_SOA]]|Tabela VG_LOG_SOA registra informações de log.|
|![[VG_AREAS_PRECOS_PRODUTOS]]|Tabela VG_AREAS_PRECOS_PRODUTOS: ID produto, ID área, data criação, login criação.|
|![[SF_ESTADOS]]|Tabela SF_ESTADOS armazena estados brasileiros com sigla UF.|
|![[VG_FILIAIS]]|Tabela VG_FILIAIS armazena informações sobre filiais.|
|![[SCHEDULER$_PROGRAM_ARG]]|Tabela SCHEDULER$_PROGRAM_ARG armazena informações sobre argumentos.|
|![[SCHEDULER$_JOB_ARG]]|Armazena argumentos de trabalho agendado com detalhes.|
|![[EBA_SPATIAL_AOI]]|Tabela para armazenar informações geoespaciais e proprietário.|
|![[VG_AREAS_PRECOS_HIST]]|Tabela VG_AREAS_PRECOS_HIST: informações históricas sobre áreas de preços.|
|![[TB_MUNICIPIOS]]|Tabela TB_MUNICIPIOS armazena informações geográficas e descritivas.|
|![[EBA_SPATIAL_ADDRESSES]]|Tabela EBA_SPATIAL_ADDRESSES: endereços com localização geográfica.|
|![[VG_AREAS_PRECOS_BKP]]|Tabela VG_AREAS_PRECOS_BKP: informações sobre áreas de preços.|
|![[VG_AREAS_PRECOS_HUB]]|Armazenar informações sobre áreas de preços geográficas.|
|![[UGC_MUNICIPIOS]]|Armazena informações geográficas e descritivas de municípios.|
|![[VG_AREAS_HUBS_BP_V]]|Tabela contém informações sobre áreas, hubs e pontos de venda.|
|![[VG_CONSULTANT]]|Tabela VG_CONSULTANT armazena informações sobre consultores de vendas.|
|![[EBA_DEMO_LOAD_EMP_ERR$]]|Tabela para armazenar erros durante carga de dados.|
|![[VG_PRICE_RULES_EXCEL]]|A tabela VG_PRICE_RULES_EXCEL armazena informações sobre regras de preços.|
|![[VG_EVENTS]]|Tabela VG_EVENTS armazena informações sobre eventos.|
|![[VG_DIST_PRODUCTS]]|Tabela VG_DIST_PRODUCTS: produtos distribuídos, preço, comissão, validade, desconto, criação e alteração.|
|![[VG_MAP_PRICE_LOG]]|Tabela VG_MAP_PRICE_LOG registra informações de preços.|
|![[VG_SETUP_ONG]]|Armazena configuração de canais e documentos ONG.|
|![[VG_CASE_SALESFORCE_HEADER]]|Armazena informações de vendas, pagamentos e detalhes.|
|![[VG_BANK]]|Tabela VG_BANK: ID, nome, código, status, criação e atualização.|
|![[VG_CHANGE_VOUCHER_STATUS_LINES]]|Tabela VG_CHANGE_VOUCHER_STATUS_LINES armazena informações sobre linhas de alteração de status de vouchers.|
|![[VG_CHANGE_VOUCHER_STATUS_HEADER]]|Tabela VG_CHANGE_VOUCHER_STATUS_HEADER armazena informações sobre alteração de status de voucher.|
|![[VG_LOG_PRECO]]|Tabela VG_LOG_PRECO: armazena informações sobre preços.|
|![[VG_PRICE_STORE]]|Tabela VG_PRICE_STORE: ID produto, usuário, pagamento, código loja, ID preço, nome produto, canal venda, preço, ID sessão, data criação.|
|![[VG_IMPORT_HUB_EXCEL]]|A tabela VG_IMPORT_HUB_EXCEL armazena informações de importação do Excel.|
|![[VG_CASE_SALESFORCE_LINES]]|Tabela VG_CASE_SALESFORCE_LINES armazena informações de vendas.|
|![[VG_NOTIFICATION]]|Tabela VG_NOTIFICATION armazena informações sobre notificações.|
|![[VG_REQUEST_VOUCHER]]|Tabela VG_REQUEST_VOUCHER armazena informações de solicitações de vouchers.|
|![[VG_DISTRIBUTOR_BKP]]|Tabela para armazenar informações de distribuidores.|
|![[VG_RESEALE_DELIVERY]]|Tabela VG_RESEALE_DELIVERY armazena informações de entregas reembaladas.|
|![[VG_REDE_LOJAS]]|Tabela VG_REDE_LOJAS armazena informações sobre lojas.|
|![[VG_SENSEDIA_APPS]]|Tabela VG_SENSEDIA_APPS: aplicativos SenseDia, detalhes e status.|
|![[VG_LOAD_SMS_VALE]]|Tabela VG_LOAD_SMS_VALE: motivo, operadora, destinatário, datas, voucher, responsável, processado.|
|![[VG_APP_KEY]]|Tabela VG_APP_KEY armazena informações sobre chaves de aplicativos.|
|![[VG_CONTACT_LEAD]]|Tabela VG_CONTACT_LEAD armazena informações de contato e leads.|
|![[VG_DIST_PRODUCTS_LOG]]|Tabela para registro de informações de produtos distribuídos.|
|![[UGC_ACESSOS]]|Tabela UGC_ACESSOS registra informações de acesso.|
|![[VG_DISTRIBUTOR]]|Tabela VG_DISTRIBUTOR: endereço, cobrança, parceria, CNPJ, recebimento.|
|![[TB_TOKENS]]|Tabela "TB_TOKENS" armazena informações sobre tokens de autenticação.|
|![[UGC_CONFIGURACAO]]|Armazena valores de configuração para aplicações diversas.|
|![[VG_AREAS_CARGA_HUB]]|Tabela VG_AREAS_CARGA_HUB armazena informações sobre áreas de carga.|
|![[VG_PORTAL_APROVADORES]]|Tabela para armazenar informações sobre aprovadores do portal.|
|![[VG_USERS02]]|Tabela VG_USERS02 armazena informações de usuários.|
|![[VG_EMISSAO_VOUCHER]]|A tabela VG_EMISSAO_VOUCHER armazena informações essenciais sobre a emissão de vouchers.|
|![[VG_FUNC_PORTAL]]|Tabela VG_FUNC_PORTAL armazena informações de funcionários.|
|![[VG_PARCEIROS]]|Tabela VG_PARCEIROS armazena informações de pagamento, endereço, contato e descontos.|
|![[VG_VOUCHER_EXP_DATE]]|Tabela VG_VOUCHER_EXP_DATE: vouchers, expiração, status, criação, término, AWS, mensagem, início, ID, validade, atualização, CNPJ, descrição.|
|![[VG_PARAM_DISTRIBUTOR_LOG]]|Tabela para armazenar informações de distribuidor.|
|![[VG_DISTRIBUTOR2]]|Tabela VG_DISTRIBUTOR2: código, endereço, contato, descontos, pagamento, gerenciamento.|
|![[VG_CONSUMER_PAY]]|Tabela VG_CONSUMER_PAY armazena informações de pagamentos.|
|![[VG_GC_SETUP_BATCH_AWS]]|Tabela VG_GC_SETUP_BATCH_AWS armazena configurações integração AWS.|
|![[VG_PRICE_RULES]]|Tabela VG_PRICE_RULES armazena informações sobre regras de preços.|
|![[VG_GENERATED_VOUCHER]]|Tabela VG_GENERATED_VOUCHER armazena informações sobre vouchers.|
|![[VG_TRACE_EMP_VOUCHER_REPORT]]|Tabela VG_TRACE_EMP_VOUCHER_REPORT: rastreia relatórios de vales de empregados.|
|![[VG_EMP_VOUCHER_FAIL_LINES]]|Tabela VG_EMP_VOUCHER_FAIL_LINES: falhas vales-presente funcionários.|
|![[VG_HUB_AREA_PRICE]]|Tabela VG_HUB_AREA_PRICE armazena informações de preços.|
|![[VG_OPEN_CASE_SF]]|Tabela VG_OPEN_CASE_SF armazena informações de casos abertos.|
|![[VG_PARAM_DISTRIBUTOR]]|Armazena informações sobre distribuidor, como limite CPF, condições pagamento, descontos.|
|![[VG_SETUP_EMPLOYEE_VOUCHER]]|Armazena informações sobre vouchers de funcionários.|
|![[VG_DIST_ADDRESS]]|Tabela VG_DIST_ADDRESS armazena informações de endereços.|
|![[VG_RELATORIOS]]|Tabela VG_RELATORIOS armazena informações de relatórios.|
|![[VG_PRODUCTS]]|Tabela VG_PRODUCTS armazena informações sobre produtos.|
|![[VG_STATUS_LEAD]]|Tabela VG_STATUS_LEAD armazena informações sobre status de leads.|
|![[VG_CAMPANHA_DESC]]|Tabela VG_CAMPANHA_DESC armazena informações de campanhas.|
|![[VG_MICRO_MERCADO]]|Tabela VG_MICRO_MERCADO: nome e descrição de micro mercados.|
|![[VG_EMP_VOUCHER_FAIL_HEADER]]|Tabela VG_EMP_VOUCHER_FAIL_HEADER: falhas criação/atualização vouchers empregados.|
|![[VG_PERIOD]]|Tabela VG_PERIOD: código, criação, atualização, início, término.|
|![[VG_INTEGRATION_LOG]]|Tabela VG_INTEGRATION_LOG registra informações de log.|
|![[VG_CUSTOMER2]]|Tabela VG_CUSTOMER2: clientes, endereço, contato, transação.|
|![[VG_TRACE_PRINT_EMPLOYEE_VOUCHER]]|Tabela rastreia criação de vouchers de funcionários.|
|![[VG_CUSTOMER]]|Tabela VG_CUSTOMER armazena informações sobre clientes.|
|![[VG_GC_PRODUCTS]]|Tabela VG_GC_PRODUCTS armazena informações sobre produtos.|
|![[TB_ARQUIVO]]|Tabela TB_ARQUIVO armazena informações sobre arquivos.|
|![[VG_ITEMS]]|Tabela VG_ITEMS armazena informações sobre itens.|
|![[VG_ADDRESS_LAT_LONG]]|Tabela VG_ADDRESS_LAT_LONG armazena informações de endereços.|
|![[VG_VOUCHER_RESEND_SMS]]|Armazena informações sobre reenvio de SMS de vouchers.|
|![[VG_FILIAL]]|Tabela VG_FILIAL armazena informações sobre filiais.|
|![[VG_VALE_ONGS]]|Armazenar informações de transações de vouchers de ONGs.|
|![[EBA_DEMO_DA_EMP]]|Tabela EBA_DEMO_DA_EMP: funcionários, contratação, nome, cargo, salário, empregado, gerente, comissão, departamento.|
|![[VG_IMPORT_HUB]]|Tabela VG_IMPORT_HUB armazena informações de importação.|
|![[VG_HUB_ARE_PRICE_BKP]]|Tabela VG_HUB_ARE_PRICE_BKP armazena informações de clientes.|
|![[VG_APPROVERS_LEADS]]|Tabela VG_APPROVERS_LEADS armazena informações sobre aprovadores.|
|![[VG_ANALISE_PRECO]]|Armazena informações sobre preço, operação, localização e produto.|
|![[VG_HUB_AREA_PRICE_EXCEL]]|Tabela com informações sobre áreas de mercado, preços e clientes.|
|![[VG_HOTSITE_CANAIS]]|Tabela VG_HOTSITE_CANAIS armazena informações sobre canais.|
|![[VG_BANK_BRANCH_SF]]|Tabela VG_BANK_BRANCH_SF: código, ID, data atualização, nome agência.|
|![[VG_REDES]]|Tabela VG_REDES armazena informações detalhadas de clientes.|
|![[VG_AREAS_CARGA_HUB_BKP]]|Tabela VG_AREAS_CARGA_HUB_BKP: CNPJ, importação, preços, micro mercado, nome, identificadores.|
|![[VG_STORE]]|Tabela VG_STORE armazena informações sobre lojas.|
|![[VG_APIS_PLANS]]|Tabela VG_APIS_PLANS armazena informações sobre planos de API.|
|![[VG_REVENDAS_INATIVAS]]|Tabela VG_REVENDAS_INATIVAS: endereço, nome, código, cliente, status.|
|![[EBA_DEMO_DA_DEPT]]|Tabela EBA_DEMO_DA_DEPT: departamento, número, nome, localização.|
|![[VG_CONFIG]]|Tabela VG_CONFIG armazena configurações do banco de dados.|
|![[VG_LEADS]]|A tabela VG_LEADS registra dados-chave de leads de vendas, incluindo revendedores, IDs, nomes, empresas, consultores, vouchers, status e preços.|
|![[VG_LISTAS_HUB]]|Armazena informações sobre listas com descrição, datas, código e tipo.|
|![[VG_SUBSIDIARY_SF]]|Tabela VG_SUBSIDIARY_SF armazena informações sobre subsidiárias.|
|![[VG_API_LIST]]|Tabela VG_API_LIST armazena informações sobre APIs.|
|![[VG_REPROCESS_INTEGRATION]]|Tabela VG_REPROCESS_INTEGRATION armazena informações de integrações.|
|![[VG_LOG_CASE_SF]]|Tabela VG_LOG_CASE_SF registra solicitações e respostas.|
|![[MDRT_1A1ED$]]|Tabela armazena informações binárias relacionadas a nó.|
|![[VG_TERMS]]|Tabela VG_TERMS armazena informações contratuais detalhadas.|
|![[MUL_FILE_ATTACH]]|Tabela MUL_FILE_ATTACH armazena informações sobre arquivos anexados.|
|![[EMP]]|Tabela com informações de funcionários da empresa.|
|![[VG_TEMPLATES]]|Tabela VG_TEMPLATES armazena informações sobre modelos de arquivos.|
|![[VG_STATUS_HISTORY]]|Tabela VG_STATUS_HISTORY registra histórico de status de leads.|
|![[MDRT_1A1DF$]]|Tabela para armazenar informações BLOB com nível e ID do nó.|
|![[VG_STOREKEEPER]]|Tabela VG_STOREKEEPER armazena informações sobre responsáveis pelo estoque.|
|![[VG_AREAS_PRECOS_PRODUTOS_HUB]]|Tabela VG_AREAS_PRECOS_PRODUTOS_HUB: informações preços produtos áreas.|
|![[EBA_SPATIAL_COUNTRIES]]|Armazena informações geográficas sobre países com GCDR.|
|![[DEPT]]|Armazena informações sobre departamentos de uma organização.|
|![[VG_APPS_APIS]]|Tabela VG_APPS_APIS armazena informações sobre APIs.|
|![[VG_RESEALE_DELIVERY_HIST]]|Tabela VG_RESEALE_DELIVERY_HIST: histórico de entregas recondicionadas.|
|![[VG_RECEIPT_METHODS]]|Tabela VG_RECEIPT_METHODS: nome, data criação/alteração, criador/responsável.|
|![[EBA_DEMO_LOAD_DEPT]]|Tabela EBA_DEMO_LOAD_DEPT: armazena informações de departamentos.|
|![[EBA_SPATIAL_DEFAULTS]]|Armazena valores padrão para configurações espaciais.|
|![[VG_COMISSAO]]|Tabela VG_COMISSAO armazena informações sobre comissões.|
|![[VG_VOUCHER_REQUEST_REASON]]|Tabela VG_VOUCHER_REQUEST_REASON armazena motivos de solicitação de vouchers.|
|![[VG_CANCEL_REASON]]|Tabela VG_CANCEL_REASON armazena motivos de cancelamento.|
|![[VG_TIPOS_PARCERIA]]|Tabela VG_TIPOS_PARCERIA armazena informações sobre parcerias.|
|![[EBA_DEMO_LOAD_EMP]]|Tabela EBA_DEMO_LOAD_EMP: funcionários, salário, data, gerente, departamento, comissão, cargo|
|![[VG_VOUCHER_VALID]]|Tabela VG_VOUCHER_VALID armazena informações sobre vouchers.|
|![[VG_CONTROL_API_DIST]]|Tabela VG_CONTROL_API_DIST armazena informações de controle e distribuição de APIs.|
|![[UPDATE_STATE_CITY_REL]]|Tabela "UPDATE_STATE_CITY_REL" armazena informações de atualizações.|
|![[CSTU_VALE_PAPEL_IMP]]|Tabela CSTU_VALE_PAPEL_IMP: vales papel, número, revendedor, tipo processo.|
|![[VG_UC]]|Tabela armazena informações de usuários: código, identificação e nome.|
|![[UGC_PERMISSOES_MANUAIS]]|Tabela UGC_PERMISSOES_MANUAIS armazena permissões de usuários.|
|![[VG_UC_SF]]|Tabela para armazenar informações de usuários: nome, ID, data de atualização e código.|
|![[VG_AREAS_PRECOS_PRODUTOS_HIST]]|Tabela para histórico de preços de produtos.|
|![[VG_HISTORICO_PARAM]]|Tabela VG_HISTORICO_PARAM: histórico de alterações de parâmetros.|
|![[VALES_FAKE]]|Tabela "VALES_FAKE" armazena informações sobre vales fictícios.|
|![[VG_LOAD_CTRL]]|Tabela VG_LOAD_CTRL: controle e rastreamento de cargas de dados.|
|![[VG_BANK_NAME_SF]]|Tabela VG_BANK_NAME_SF armazena informações sobre bancos.|
|![[VG_ESTADOS]]|Tabela VG_ESTADOS: informações sobre estados, nome completo e sigla.|
|![[VG_TESTES_SERVICO]]|Tabela para armazenar informações sobre testes em serviços.|
|![[LOG_AREA_HUB_REQUEST]]|Tabela para armazenar solicitações de hub de área.|
|![[VG_USER_SF]]|Tabela armazena informações sobre usuários e atualizações.|
|![[VG_VOUCHER_VALID_CAN]]|Tabela para armazenar informações sobre validade e tipo de voucher.|
|![[VG_TESTE]]|Tabela VG_TESTE armazena dados de colunas B e A VARCHAR2.|
|![[TESTE]]|Tabela para armazenar dados volumosos e variados.|
|![[AS_READ_XLSX]]|Pacote para ler XLSX e converter em BLOB.|
|![[BLOB_WRAPPER]]|Manipulação de dados binários em banco de dados.|
|![[EBA_SPATIAL_GCDR_PKG]]|Pacotes para processamento, análise e geocodificação de dados espaciais.|
|![[EBA_SPATIAL_SAMPLE]]|Funções para manipulação de geometrias e tabelas.|
|![[LOB2TABLE]]|Funções para conversão de formatos e separação de colunas.|
|![[MD_META]]|Funções para ID, números aleatórios e citações.|
|![[MIGRATION]]|Facilita transferência de dados e configurações entre sistemas.|
|![[MIGRATION_REPORT]]|Funções para obter status de captura e conversão.|
|![[MIGRATION_TRANSFORMER]]|Transformações e verificações em identificadores de migração.|
|![[SS2K5ALLPLATFORM]]|Funções para obter informações e capturar estágios.|
|![[SYB12ALLPLATFORM]]|Ferramentas para descrições, status, substrings e estágios.|
|![[TDALLPLATFORM]]|Funcionalidades para status e captura de estágios.|
|![[VG_API_CONFIG_LOTE_K]]|Pacote com configurações e atualizações para API VG.|
|![[VG_API_DATASETS_K]]|Informações sobre entidades e termos da empresa VG.|
|![[VG_APP_KEY_K]]|Fornecer chaves de autenticação e autorização para aplicativos.|
|![[VG_CHANGE_VOUCHER_STATUS_K]]|Fornecer funções para alterar, bloquear, cancelar vouchers.|
|![[VG_DISTRIBUTOR_K]]|Pacote com procedimentos e funções para distribuição.|
|![[VG_EMPLOYEE_VOUCHER_K]]|Pacotes para gerenciar, tratar, gerar relatórios, chamar API, obter dados, reprocessar e enviar configurações de vouchers de funcionários.|
|![[VG_EVENTS_K]]|Gerencia eventos com criação, atualização e exclusão.|
|![[VG_IMPORT_AREA_PRICE_HUB_K]]|Pacotes para importar, gerenciar e salvar informações.|
|![[VG_IMPORT_PRICE_K]]|Importar preços, corrigir polígonos, excluir dados, atualizar preços em sistema.|
|![[VG_LEAD_K]]|Identificar, rastrear, inserir e atualizar informações de leads.|
|![[VG_OPEN_CASE_SF_K]]|Pacote para abrir caso no Salesforce.|
|![[VG_PORTAL_K]]|Fornecer funcionalidades para aprovação e gerenciamento de funcionários.|
|![[VG_PRICE_RULES_K]]|VG_PRICE_RULES_K: Gerencia regras de preços no sistema.|
|![[VG_REDES_K]]|Funcionalidades de gestão de redes e comissões.|
|![[VG_RELATORIO_K]]|Processar e gerar relatórios com eficiência.|
|![[VG_REQUEST_VOUCHER_K]]|Pacote para gerar, aprovar, reprovar e notificar vouchers.|
|![[VG_RESEALE_K]]|Redefinir chave, excluir registro, visualizar histórico, inserir registro, atualizar registro.|
|![[VG_STOREKEEPER_K]]|Gerenciamento de estoquista e operações de dados.|
|![[VG_UTIL_K]]|Funções e procedimentos para autenticação e manipulação.|
|![[VG_VOUCHER_OPER_K]]|Pacotes para operações, desabilitar, reenviar e enviar vouchers.|
|![[VG_VOUCHER_TRANSACTIONS_K]]|Gerencia transações de vouchers e envia mensagens SMS de retorno de chamada.|
|![[XLSX_WRITER]]|Criação e manipulação de arquivos XLSX (Excel).|
|![[ZIPPER]]|Compacta arquivos em formato ZIP com eficiência.|
|![[ZT_QR]]|Gerador e manipulador de códigos QR versátil.|
