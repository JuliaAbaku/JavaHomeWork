package Wave;
//Семинар 5
//    Задача: Реализовать алгоритм волновой
public class Main {

    // Тут карта
    static int[][] getMap() {
        return new int[][] {
                { 00, 00, 00, 00, 00, 00, 00, 00 },
                { 00, 00, -1, 00, 00, 00, 00, 00 },
                { 00, 00, -1, 00, -1, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, -1, -1, -1, -1, -1, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, 00, 00 }
        };
    }

    // Тут распечатываем карту и помечаем стены, вход, выход
    static void pprint(int[][] m) {
        int rows = m.length;
        int colums = m[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (m[i][j] == -1)
                    System.out.printf("%s", " @ ");
                else if (m[i][j] == 1)
                    System.out.printf("%s", " # ");
                else if (m[i][j] == -3)
                    System.out.printf("%s", " $ ");
                else
                    System.out.printf("%s", "░░░");
            }
            System.out.println();
        }
    }
    // Тут задаем старт
    static void start(int[][] map, int x, int y) {
        map[x][y] = 1;
    }
    // Тут задаем финиш
    static void finish(int[][] map, int x, int y) {
        map[x][y] = -3;
    }

    // Тут все запускается
    public static void main(String[] args) {
        int[][] map = getMap();
        start(map, 7, 4);
        finish(map, 10, 7);
        pprint(map);
        WavePropagation(map);
    }
    static boolean WavePropagation(int[][] m){
        int rows = m.length;
        int colums = m[0].length;
        int step = 1;
        boolean finished = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (m[i][j] == 1) {
                    if (i != rows - 1) {
                        if (m[i + 1][j] != -1) {
                            m[i + 1][j] = step + 1;
                        }
                    }

                    if (j != colums - 1) {
                        if (m[i][j + 1] != -1) {
                            m[i][j + 1] = step + 1;
                        }
                    }

                    if (i != 0) {
                        if (m[i - 1][j] != -1) {
                            m[i - 1][j] = step + 1;
                        }
                    }

                    if (j != 0) {
                        if (m[i][j - 1] != -1) {
                            m[i][j - 1] = step + 1;
                        }
                    }

                    if (i < rows - 1) {
                        if (m[i + 1][j] == -3) {
                            finished = true;
                        }
                    }

                    if (j < colums - 1) {
                        if (m[i][j + 1] == -3) {
                            finished = true;
                        }
                    }

                    if (i > 0) {
                        if (m[i - 1][j] == -3) {
                            finished = true;
                        }
                    }

                    if (j > 0) {
                        if (m[i][j - 1] == -3) {
                            finished = true;
                        }
                    }
                }
            }
            step++;
        }

    }
}
