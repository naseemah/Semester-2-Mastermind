package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void checkCode(String input){
        int correctDigits = 0;
        int correctPos = 0;
        for (int i = 0; i < 4; i++){
            if (input.charAt(i) == code.charAt(i)){
                correctPos++;
            }else if (code.indexOf(input.charAt(i))!= -1){
                correctDigits++;
            }
        }
        System.out.println("Number of correct digits in correct place:"+ correctPos);
        System.out.println("Number of correct digits not in correct place:"+ correctDigits);
    }

    public void runGame() {
        //TODO: implement the main run loop logic
        //System.out.println(this.code);
        //player.getGuess();
        boolean gameLoop = true;
        String input = null;

        while (gameLoop ){
            input = player.getGuess();
            checkCode(input);
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit") ||
                    input.equalsIgnoreCase(code) || player.getGuesses() == 1){
                gameLoop = false;
                if (player.getGuesses()== 1){
                    System.out.println("No more turns left");
                }
            }else {
                player.setGuesses(player.getGuesses()-1);
                System.out.println("Turns left: " + player.getGuesses());
            }
        }
        if (code.equalsIgnoreCase(input)){
            System.out.println("Congratulations! You are a codebreaker!");
        }
        System.out.println("The code was: " +code);
    }

    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
