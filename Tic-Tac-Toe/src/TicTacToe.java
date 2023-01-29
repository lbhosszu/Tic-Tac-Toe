import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    private static Random random = new Random();
    private static JFrame frame = new JFrame();
    private static JPanel tPanel = new JPanel();
    private static JPanel bPanel = new JPanel();
    private static JPanel scorePanel = new JPanel();
    private static JLabel textField = new JLabel();
    private static JButton [] buttons = new JButton[9];
    private static JButton resetButton = new JButton("Reset");
    private static JButton exitButton = new JButton("Exit");
    private static JLabel xPlayer = new JLabel("X Player");
    private static JLabel xBox = new JLabel();
    private static JLabel xCount = new JLabel("0");
    private static JLabel oPlayer = new JLabel("O Player");
    private static JLabel oCount = new JLabel("0");
    private static boolean playerTurn;
    private static int xScore = 0;
    private static int oScore = 0;

    Font font = new Font(Font.SERIF, Font.BOLD,75);
    
    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1000);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(255,255,255));
        textField.setFont(font);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("");
        textField.setOpaque(true);

        tPanel.setLayout(new BorderLayout());
        tPanel.setBounds(0,0,1200,100);

        bPanel.setLayout(new GridLayout(3,3));
        //bPanel.setBounds(0,100,800,700);
        bPanel.setBackground(new Color(150,150,150));

        scorePanel.setLayout(new GridLayout(3,2));
        //scorePanel.setBounds(800,100,400,700);
        scorePanel.setBackground(new Color(255,255,255));

        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            bPanel.add(buttons[i]);
            buttons[i].setFont(font);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        scorePanel.add(xPlayer);
        xPlayer.setHorizontalAlignment(JLabel.CENTER);
        xPlayer.setFont(font);
        xPlayer.setForeground(new Color(0,200,255));
        scorePanel.add(xCount);
        xCount.setHorizontalAlignment(JLabel.CENTER);
        xCount.setForeground(new Color(0,200,255));
        xCount.setFont(font);
        scorePanel.add(oPlayer);
        oPlayer.setHorizontalAlignment(JLabel.CENTER);
        oPlayer.setFont(font);
        oPlayer.setForeground(new Color(255,50,50));
        scorePanel.add(oCount);
        oCount.setHorizontalAlignment(JLabel.CENTER);
        oCount.setFont(font);
        oCount.setForeground(new Color(255,50,50));
        scorePanel.add(resetButton);
        resetButton.setFont(font);
        scorePanel.add(exitButton);
        exitButton.setFont(font);

        tPanel.add(textField);
        frame.add(tPanel,BorderLayout.NORTH);
        frame.add(scorePanel,BorderLayout.EAST);
        frame.add(bPanel,BorderLayout.CENTER);
        frame.setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 9; i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(playerTurn)
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0,200,255));
                        buttons[i].setText("X");
                        playerTurn = false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(255,50,50));
                        buttons[i].setText("O");
                        playerTurn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        if(random.nextInt(2) == 0)
        {
            playerTurn = true;
            textField.setText("X turn");
        }
        else
        {
            playerTurn = false;
            textField.setText("O turn");
        }
    }

    public void check()
    {
        if(((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X"))
                || ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")))
        {
            if(buttons[0].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }

        }
        if(((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X"))
                || ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")))
        {
            if(buttons[3].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        if(((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X"))
                || ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")))
        {
            if(buttons[6].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        if(((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X"))
                || ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")))
        {
            if(buttons[0].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        if(((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X"))
                || ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")))
        {
            if(buttons[1].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        if(((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X"))
                || ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")))
        {
            if(buttons[2].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        if(((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X"))
                || ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")))
        {
            if(buttons[0].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        if(((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X"))
                || ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")))
        {
            if(buttons[2].getText() == "X")
            {
                xWins();
            }
            else
            {
                oWins();
            }
        }
        else if((buttons[0].getText() == "X" || buttons[0].getText() == "O")
                && (buttons[1].getText() == "X" || buttons[1].getText() == "O")
                && (buttons[2].getText() == "X" || buttons[2].getText() == "O")
                && (buttons[3].getText() == "X" || buttons[3].getText() == "O")
                && (buttons[4].getText() == "X" || buttons[4].getText() == "O")
                && (buttons[5].getText() == "X" || buttons[5].getText() == "O")
                && (buttons[6].getText() == "X" || buttons[6].getText() == "O")
                && (buttons[7].getText() == "X" || buttons[7].getText() == "O")
                && (buttons[8].getText() == "X" || buttons[8].getText() == "O"))
        {
            draw();
        }
    }

    public void xWins()
    {
        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        xScore++;
        xCount.setText(xScore+"");
        textField.setText("X wins");
    }

    public void oWins()
    {

        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        oScore++;
        oCount.setText(oScore+"");
        textField.setText("O wins");
    }

    public void draw()
    {
        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("Draw");
    }

    public void reset()
    {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 9; i++)
                {
                    buttons[i].setText("");
                    buttons[i].setEnabled(true);
                }
                firstTurn();
            }
        });
    }

    public void exit()
    {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

