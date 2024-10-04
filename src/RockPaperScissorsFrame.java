import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel selectionPnl;
    JPanel playArea;
    JPanel statsPnl;
    JLabel pWins;
    JLabel compWins;
    JLabel ties;
    int pWinsNum;
    int compWinsNum;
    int tiesNum;
    JLabel title;
    JButton rock;
    JButton paper;
    JButton scissors;
    JButton quit;
    ImageIcon rockImg;
    ImageIcon paperImg;
    ImageIcon scissorImg;
    ImageIcon quitImg;
    JTextArea results;
    JScrollPane resultScroll;

    private String pChoice;
    private String compChoice;


    public RockPaperScissorsFrame(){

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4,1));

        createTop();
        mainPnl.add(title, BorderLayout.NORTH);

        createSelectionSection();
        mainPnl.add(selectionPnl);

        createPlayArea();
        mainPnl.add(playArea);

        createStatsPnl();
        mainPnl.add(statsPnl);

        game();

        add(mainPnl);
        setSize(600,750);
        setLocation(0,0);
        setTitle("Rock Paper Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTop(){
        title = new JLabel("Rock Paper Scissors!", JLabel.CENTER);
        title.setFont(new Font("Impact", Font.PLAIN, 36));
        mainPnl.add(title);
    }

    private void createSelectionSection(){
        selectionPnl = new JPanel();
        selectionPnl.setLayout(new GridLayout(1,4));

        selectionPnl.setBorder(new EtchedBorder());

        //Making buttons
        rock = new JButton();
        paper = new JButton();
        scissors = new JButton();
        quit = new JButton();

        rockImg = new ImageIcon("src/Rock.png");
        paperImg = new ImageIcon("src/Paper.png");
        scissorImg = new ImageIcon("src/Scissors.png");
        quitImg = new ImageIcon("src/Exit.png");
        //Image image = titleImage.getImage().getScaledInstance(350, 100, Image.SCALE_SMOOTH);
        //rockImg = new ImageIcon(image);

        //making scaled images because they're way too big
        Image scaledRockImg = rockImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image scaledPaperImg = paperImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image scaledScissorImg = scissorImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image scaledQuitImg = quitImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        rock.setIcon(new ImageIcon(scaledRockImg));
        paper.setIcon(new ImageIcon(scaledPaperImg));
        scissors.setIcon(new ImageIcon(scaledScissorImg));
        quit.setIcon(new ImageIcon(scaledQuitImg));


        //maybe put in separate function for speed
        //rock.addActionListener((ActionEvent ae) -> {
        //    pChoice = "R";
        //});
        //paper.addActionListener((ActionEvent ae) -> {
        //    pChoice = "P";
        //});
        //scissors.addActionListener((ActionEvent ae) -> {
        //    pChoice = "S";
        //});
        //quit.addActionListener((ActionEvent ae) -> System.exit(0));

        selectionPnl.add(rock);
        selectionPnl.add(paper);
        selectionPnl.add(scissors);
        selectionPnl.add(quit);
    }

    private void createPlayArea(){
        playArea = new JPanel();
        playArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "RESULTS:"));

        results = new JTextArea(8, 40);
        results.setEditable(false);  //makes the text area non-editable

        resultScroll = new JScrollPane(results);
        resultScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  // Ensure the scrollbar always shows


        playArea.add(resultScroll);

    }

    private void createStatsPnl(){
        statsPnl = new JPanel();
        pWins = new JLabel();
        compWins = new JLabel();
        ties = new JLabel();

        pWins.setText("Player Wins: " + pWinsNum);
        compWins.setText("Computer Wins: " + compWinsNum);
        ties.setText("Ties: " + tiesNum);

        statsPnl.add(pWins);
        statsPnl.add(compWins);
        statsPnl.add(ties);


    }

    private String getCompChoice(){
        Random random = new Random();
        int pickRanNum = random.nextInt(3);

        //System.out.println(pickRanNum);

        if(pickRanNum == 0){
            compChoice = "R";
        }
        else if(pickRanNum == 1){
            compChoice = "P";
        }
        else {
            compChoice = "S";
        }
        return this.compChoice;
        //System.out.println(compChoice);
    }

    private void game() {
        rock.addActionListener((ActionEvent ae) -> {
            pChoice = "R";
            compChoice = getCompChoice();
            evaluateGame();
        });
        paper.addActionListener((ActionEvent ae) -> {
            pChoice = "P";
            compChoice = getCompChoice();
            evaluateGame();
        });
        scissors.addActionListener((ActionEvent ae) -> {
            pChoice = "S";
            compChoice = getCompChoice();
            evaluateGame();
        });
        quit.addActionListener((ActionEvent ae) -> System.exit(0));
    }

    private void evaluateGame() {

        if (pChoice.equals(compChoice)) {
            results.append("You chose: " + pChoice + " and computer chose: " + compChoice + ".\nIt's a tie!\n");
            tiesNum++;
            ties.setText("Ties: " + tiesNum);
        }
        else if (pChoice.equals("R") && compChoice.equals("P") ||
                pChoice.equals("P") && compChoice.equals("S") ||
                pChoice.equals("S") && compChoice.equals("R")) {
            results.append("You chose: " + pChoice + " and computer chose: " + compChoice + ".\nComputer Wins!\n");
            compWinsNum++;
            compWins.setText("Computer Wins: " + compWinsNum);
        }
        else {
            results.append("You chose: " + pChoice + " and computer chose: " + compChoice + ".\nPlayer Wins!\n");
            pWinsNum++;
            pWins.setText("Player Wins: " + pWinsNum);
        }
    }


}
