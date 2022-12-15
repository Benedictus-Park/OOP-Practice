package homework; // 교수님... 난이도가...ㅠㅠㅠㅠ

import java.util.Random;
import java.util.Scanner;

class Point {
    /*
     * # 본 프로그램에서의 좌표 설명 (x, y), 구현의 편의를 위함.
     * - 화면 맨 왼쪽 상단의 좌표를 (0, 0)으로 둔다.
     * - 오른쪽으로 한 칸 이동시마다 x 좌표는 1씩 증가한다.
     * - 왼쪽으로 한 칸 이동시마다 x 좌표는 1씩 감소한다.
     * - 아래쪽으로 한 칸 이동시마다 y 좌표는 1씩 증가한다.
     * - 위쪽으로 한 칸 이동시마다 y 좌표는 1씩 감소한다.
     */
    private int x, y; // 객체의 x 좌표와 y 좌표를 저장할 클래스.

    // 최초 좌표 설정.
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // x-Coordinate Getter.
    public int getX(){
        return x;
    }

    // y-Coordinate Getter.
    public int getY(){
        return y;
    }

    // x 좌표 일정량만큼 이동.
    public void moveX(int amount){
        x += amount;
    }

    // y 좌표 일정량만큼 이동.
    public void moveY(int amount){
        y += amount;
    }

    // 두 좌표가 동일한지 비교하는 정적 메서드.
    public static boolean isEqual(Point a, Point b){
        if(a.x == b.x && a.y == b.y) {
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }

    public static Point getRandomPoint(int x_start, int x_end, int y_start, int y_end){
        /*
         * # 임의의 좌표를 가진 점(Point) 객체를 생성 및 반환.
         * 임의의 좌표 (x, y)에서,
         * x 값은 x_start 이상 x_end 미만.
         * y 값은 y_start 이상 y_end 미만.
         */
        int x;
        int y;
        Random rand = new Random();

        x = rand.nextInt(x_start, x_end);
        y = rand.nextInt(y_start, y_end);

        return new Point(x, y);
    }
}

abstract class Entity{
    /*
     * - 게임 내 모든 엔티티(플레이어, 몬스터)가 공통으로 가지는 속성을 추상 클래스로 정의.
     * - 속성: 좌표, 왼쪽으로 이동 가능, 위로 이동 가능, 아래로 이동 가능, 오른쪽으로 이동 가능.
     */
    protected Point position; // 엔티티의 현 위치.

    public Entity(Point position){
        // 엔티티는 생성시부터 위치값을 가져야 함.
        this.position = position;
    }

    abstract public void moveLeft(); // 엔티티는 왼쪽으로 이동 가능해야 함.
    abstract public void moveUp(); // 엔티티는 위로 이동 가능해야 함.
    abstract public void moveDown(); // 엔티티는 아래로 이동 가능해야 함.
    abstract public void moveRight(); // 엔티티는 오른쪽으로 이동 가능해야 함.
    abstract public Point getPosition(); // 엔티티는 현재 위치를 getPosition() 메서드로 내놓아야 함.
}

class Gammer extends Entity{
    public Gammer(Point position){
        // 부모 추상 클래스와 마찬가지로 Gammer 엔티티 역시 생성시부터 위치값을 가져야 함.
        super(position);
    }

    // 엔티티를 한 칸 왼쪽으로 이동시킴.(x 좌표 변경)
    public void moveLeft() {
        position.moveX(-1);
    }

    // 엔티티를 한 칸 위로 이동시킴. (y 좌표 변경, 위로 가는데 y 값에 -1을 더하는 이유는 최상단 주석 참조.)
    public void moveUp(){
        position.moveY(-1);
    }

    // 엔티티를 한 칸 아래로 이동시킴. (y 좌표 변경, 아래로 가는데 y 값에 1을 더하는 이유는 최상단 주석 참조.)
    public void moveDown(){
        position.moveY(1);
    }

    // 엔티티를 한 칸 오른쪽으로 이동시킴. (x 좌표 변경)
    public void moveRight() {
        position.moveX(1);
    }

    // 현재 위치 내놓기.
    public Point getPosition(){
        return position;
    }
}

class Monster extends Entity{
    public Monster(Point position){
        // 부모 추상 클래스와 마찬가지로 Monster 엔티티 역시 생성시부터 위치값을 가져야 함.
        super(position);
    }

    // 엔티티를 한 칸 왼쪽으로 이동시킴.(x 좌표 변경)
    public void moveLeft() {
        position.moveX(-1);
    }

    // 엔티티를 한 칸 위로 이동시킴. (y 좌표 변경, 위로 가는데 y 값에 -1을 더하는 이유는 최상단 주석 참조.)
    public void moveUp(){
        position.moveY(-1);
    }

    // 엔티티를 한 칸 아래로 이동시킴. (y 좌표 변경, 아래로 가는데 y 값에 1을 더하는 이유는 최상단 주석 참조.)
    public void moveDown(){
        position.moveY(1);
    }

    // 엔티티를 한 칸 오른쪽으로 이동시킴.(x 좌표 변경)
    public void moveRight() {
        position.moveX(1);
    }

    // 현재 위치 내놓기
    public Point getPosition(){
        return position;
    }
}

class Map {
    /*
     * # 게임의 배경이 되는 Map
     * - 너비(width), 높이(height) 지정 가능.
     * - Gammer, Monster Type 객체 모두 Entity형으로 저장함.(코드 가독성 위함.)
     */
    private int width; // 맵 너비.
    private int height; // 맵 높이.
    private Entity gammer; // 플레이어 엔티티 저장.
    private Entity monster; // 몬스터 엔티티 저장.
    final private Point posOfGold; // 황금의 위치 설정. 황금 위치는 불변이므로 final로 선언.

    public Map(int width, int height, Point posOfGold, Gammer gammer, Monster monster) {
        // 맵 구성 요소는 Map 객체를 만들며 한 번에 모두 설정되어야 함.
        // 그렇지 않으면 예외 처리가 너무 복잡해지기 때문.
        this.width = width;
        this.height = height;

        this.posOfGold = posOfGold;
        this.gammer = gammer;
        this.monster = monster;
    }

    // 현재 맵 현황을 콘솔에 시현
    public void drawMap(){
        int i, j;
        Point tmp;

        // 최상단 테두리 그리기.
        for(i = 0; i <= width + 1; i++){
            System.out.print("#");
        }
        System.out.println(); // 줄바꿈.

        // 맵 좌, 우측 테두리와 빈 공간, 그리고 엔티티를 콘솔에 시현.
        // 한 행씩 출력함.
        for(i = 1; i < height + 1; i++) {
            for(j = 0; j <= width + 1; j++){
                tmp = new Point(j, i); // 현재 좌표로 Point 객체를 만듦.

                if(Point.isEqual(gammer.getPosition(), tmp) && Point.isEqual(gammer.getPosition(), monster.getPosition())) {
                    // 현 좌표에서 플레이어와 몬스터가 만났다? -> 펑! -> 현 위치에 *을 출력.
                    System.out.print("*");
                }
                else if(Point.isEqual(posOfGold, tmp) && Point.isEqual(gammer.getPosition(), posOfGold)) {
                    // 현 좌표에서 플레이어와 황금이 만났다? -> 펑! -> 현 위치에 *을 출력.
                    System.out.print("*");
                }
                else if(Point.isEqual(posOfGold, tmp)) {
                    // 황금의 위치에는 G를 놓는다.
                    System.out.print("G");
                }
                else if(Point.isEqual(gammer.getPosition(), tmp)) {
                    // 플레이어의 위치에는 @를 놓는다.
                    System.out.print("@");
                }
                else if(Point.isEqual(monster.getPosition(), tmp)) {
                    // 몬스터의 위치에는 M을 놓는다.
                    System.out.print("M");
                }
                else if(j == 0 || j == width + 1) {
                    // 맵의 맨 왼쪽과 맨 오른쪽에는 #을 놓아 테두리를 만든다.
                    System.out.print("#");
                    if(j == width + 1) {
                        // 만약 방금 맨 오른쪽 테두리를 놓았다면? 줄을 바꾼다.
                        System.out.println();
                    }
                }
                else{
                    // 아무 것도 없는 공간이면 공백 출력.
                    System.out.print(" ");
                }
            }
        }

        // 최하단 테두리 그리기.
        for(i = 0; i <= width + 1; i++) {
            System.out.print("#");
        }
        System.out.println(); // 줄바꿈.
    }

    // 황금의 위치 좌표를 반환.
    public Point getGoldPosition(){
        return posOfGold;
    }

    // 플레이어의 위치 좌표를 반환.
    public Point getGammerPosition(){
        return gammer.getPosition();
    }

    // 몬스터의 위치 좌표를 반환
    public Point getMonsterPosition(){
        return monster.getPosition();
    }
}

public class TextBasedGame {
    // Main 클래스.
    private static final int WIDTH = 17; // 맵 너비를 설정하는 상수.
    private static final int HEIGHT = 8; // 맵 좌표를 설정하는 상수.

    // 코드 가독성을 위해 각 동작마다 다른 값의 상수를 부여.
    private static final int MOVE_LEFT = 1; // 왼쪽으로 이동.
    private static final int MOVE_UP = 2; // 위로 이동.
    private static final int MOVE_DOWN = 3; // 아래로 이동.
    private static final int MOVE_RIGHT = 4; // 오른쪽으로 이동.

    private static final int DIFFICULTY = 3; // 난이도 설정. 난이도만큼 몬스터가 더 자유롭게 움직임. 세부사항은 proceedGame() 메서드의 주석 참조.

    Random rand = new Random(); // 난수 발생기 생성.

    Gammer gammer; // 플레이어 객체의 참조를 Map도 가지고 있고, 본 클래스에서도 가지고 있음.
    Monster monster; // 몬스터 객체의 참조를 Map도 가지고 있고, 본 클래스에서도 가지고 있음.
    Point positionOfGold; // 황금의 위치 참조 역시 Map, 본 클래스 모두 가짐.
    private Map map; // 맵을 저장. 맵은 게임의 구성 요소.

    // TextBasedGame Class의 인스턴스 생성과 동시에 게임이 초기화됨.
    private TextBasedGame(){
        Point position; // 플레이어의 위치 초기값, 몬스터의 위치 초기값을 설정하기 위한 참조 변수.

        // 최초로 생성된 맵에는 아무 것도 없으므로, 맵 내부 어떤 좌표에 금을 놓더라도 상관이 없다. 따라서 임의의 좌표를 생성하며, 값 검증은 없음.
        positionOfGold = Point.getRandomPoint(1, WIDTH + 1, 1, HEIGHT + 1);

        // 플레이어 엔티티 좌표를 설정한다.
        // 만약 플레이어가 황금의 위치에 생성되면 시작과 동시에 게임이 종료된다.
        while(true){
            // 그러므로 황금의 위치와, 플레이어의 위치가 될 임의의 좌표가 같다면 임의의 좌표를 다시 생성한다.
            position = Point.getRandomPoint(1, WIDTH + 1, 1, HEIGHT + 1);
            if(!Point.isEqual(positionOfGold, position)){
                gammer = new Gammer(position);
                break;
            }
        }

        // 몬스터 엔티티 좌표를 설정한다.
        // 몬스터가 황금 위치에 있으면 안 된다.(문제의 조건은 아니지만...)
        // 또한, 플레이어의 위치에 몬스터가 생성되면 시작과 동시에 게임에서 패배한다.
        while(true){
            // 그러므로 황금의 위치 및 플레이어의 위치가, 몬스터의 위치가 될 임의의 좌표와 같다면 임의의 좌표를 다시 생성한다.
            position = Point.getRandomPoint(1, WIDTH + 1, 1, HEIGHT + 1);
            if(!Point.isEqual(positionOfGold, position) && !Point.isEqual(gammer.getPosition(), position)){
                monster = new Monster(position);
                break;
            }
        }

        // 모든 정보가 정해졌다면 Map 객체를 만든다.(게임을 초기화 한다.)
        map = new Map(WIDTH, HEIGHT, positionOfGold, gammer, monster);
    }

    // 이 메서드는 게임의 현황이 종료 조건을 만족한 상태인지 검증한다.(종료 조건 만족: true, 반대의 경우: false)
    private boolean checkEndCondition(){
        // 게이머가 황금의 위치에 있다면...
        if(Point.isEqual(map.getGammerPosition(), map.getGoldPosition())){
            System.out.println("You Won!"); // 게임 승리!
            return true; // 종료 조건 만족.
        }
        // 게이머가 몬스터랑 만났다면...
        else if(Point.isEqual(map.getGammerPosition(), map.getMonsterPosition())){
            System.out.println("You Lose!"); // 게임 패배!
            return true; // 종료 조건 만족.
        }
        return false; // 둘 다 아니면 아직 종료 조건 만족하지 않음.
    }

    // 플레이어가 이동하려는 방향이 테두리로 막혀있지는 않은지? 검증.
    // 막혀 있다: false 반환, 이동 가능하다: true 반환.
    private boolean validateGammersMove(int direction) {
        boolean possibility = false;

        switch (direction) {
            case MOVE_LEFT: // 플레이어가 왼쪽으로 움직이려면...
                if (gammer.getPosition().getX() > 1) { // 플레이어가 왼쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                    possibility = true;
                }
                break;
            case MOVE_UP: // 플레이어가 위로 움직이려면...
                if (gammer.getPosition().getY() > 1) { // 플레이어가 위쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                    possibility = true;
                }
                break;
            case MOVE_DOWN: // 플레이어가 아래로 움직이려면...
                if (gammer.getPosition().getY() < HEIGHT) { // 플레이어가 아래쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                    possibility = true;
                }
                break;
            case MOVE_RIGHT: // 플레이어가 오른쪽으로 움직이려면...
                if (gammer.getPosition().getX() < WIDTH) { // 플레이어가 오른쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                    possibility = true;
                }
                break;
        }
        return possibility;
    }

    // 몬스터가 취할 행동을 임의로 정한다.
    private int choiceMonstersMoveDirection(){
        int direction; // 이동 방향 저장.
        boolean possibility = false; // 이동 가능 여부 판별을 위해 만든 변수.

        while(true){
            // 각 행동 상수에 값을 연속적으로 부여했으므로, 이와 같이 행동을 임의로 정하는 것이 가능함.
            direction = rand.nextInt(MOVE_LEFT, MOVE_RIGHT + 1);

            // 몬스터가 임의로 정해진 행동을 수행해도 게임에 문제가 없는지 검증.
            switch(direction) {
                case MOVE_LEFT: // 몬스터가 왼쪽으로 움직이려면...
                    if (monster.getPosition().getX() > 1){ // 몬스터가 왼쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                        possibility = true;
                    }
                    break;
                case MOVE_UP: // 몬스터가 위로 움직이려면...
                    if (monster.getPosition().getY() > 1){ // 몬스터가 위쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                        possibility = true;
                    }
                    break;
                case MOVE_DOWN: // 몬스터가 아래로 움직이려면...
                    if (monster.getPosition().getY() < HEIGHT){ // 몬스터가 아래쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                        possibility = true;
                    }
                    break;
                case MOVE_RIGHT: // 몬스터가 오른쪽으로 움직이려면...
                    if (monster.getPosition().getX() < WIDTH){ // 몬스터가 오른쪽 테두리로부터 1칸 이상 떨어져 있어야 함.
                        possibility = true;
                    }
                    break;
            }

            if(possibility){
                return direction;
            }
        }
    }

    // 몬스터의 이동을 실질적으로 수행.
    private void proceedMonstersMove(){
        int moving_direction = choiceMonstersMoveDirection();

        switch (moving_direction) {
            case MOVE_LEFT -> monster.moveLeft();
            case MOVE_UP -> monster.moveUp();
            case MOVE_DOWN -> monster.moveDown();
            case MOVE_RIGHT -> monster.moveRight();
        }
    }

    // 플레이어의 이동을 실질적으로 수행.
    private void proceedGammersMove(int moving_direction){
        switch (moving_direction) {
            case MOVE_LEFT -> gammer.moveLeft();
            case MOVE_UP -> gammer.moveUp();
            case MOVE_DOWN -> gammer.moveDown();
            case MOVE_RIGHT -> gammer.moveRight();
        }
    }

    // 이 메서드를 사용하는 것만으로 게임이 한 단계씩 진행됨.
    private void proceedGame(int moving_direction){
        // 난이도 가중치만큼 몬스터가 복잡하게 이동할 확률 증가.
        for(int i = 0; i < DIFFICULTY; i++) {
            proceedMonstersMove();
        }

        // 만약 몬스터의 위치가 황금과 겹쳐 있으면... 마음에 안 드니까...
        if(Point.isEqual(monster.getPosition(), positionOfGold)){
            proceedMonstersMove(); // 몬스터를 한 칸 다른 곳으로 이동시킴.
        }
        proceedGammersMove(moving_direction); // 플레이어가 선택한 움직임을 수행.
        map.drawMap(); // 모든 엔티티의 이동을 처리한 후 맵을 콘솔에 시현.
    }

    public static void main(String[] args){
        String input; // 키보드 입력을 받기 위한 변수.
        int moving_direction = 0;
        Scanner sc = new Scanner(System.in);
        TextBasedGame game = new TextBasedGame();

        game.map.drawMap(); // 갓 초기화된 맵을 시현.
        while(true){
            // 게임의 진행 상황이 종료 조건을 만족했다면?
            if(game.checkEndCondition()){
                return; // 리턴!
            }

            System.out.print("왼쪽(h), 위쪽(j), 아래쪽(k), 오른쪽(l): ");

            while(true) {
                input = sc.next();

                if(input.equals("h")) {
                    moving_direction = MOVE_LEFT;
                }
                else if(input.equals("j")) {
                    moving_direction = MOVE_UP;
                }
                else if(input.equals("k")) {
                    moving_direction = MOVE_DOWN;
                }
                else if(input.equals("l")) {
                    moving_direction = MOVE_RIGHT;
                }

                if(MOVE_LEFT <= moving_direction && moving_direction <= MOVE_RIGHT) { // 플레이어가 움직일 방향을 제대로 입력했고...
                    if(game.validateGammersMove(moving_direction)) { // 그 쪽이 막혀 있지 않으면?
                        break; // inner 무한 루프 빠져나가 게임을 진행!
                    }
                    else { // 막혀 있으면?
                        System.out.println("해당 방향으로는 움직일 수 없습니다."); // 안내문 출력.
                    }
                }
                System.out.print("재입력: "); // 플레이어가 이동 방향을 제대로 입력하지 않았거나, 막혀 있는 쪽으로 이동하려고 시도하는 경우 모두 출력.
            }

            game.proceedGame(moving_direction); // 게임을 한 단계 진행시킴.
        }
    }
}
