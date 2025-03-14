import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

class ATM {
    private BankAccount account;
    private JFrame frame;
    private JTextField amountField;
    private JLabel balanceLabel;

    public ATM(BankAccount account) {
        this.account = account;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("ATM Machine");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        balanceLabel = new JLabel("Balance: $" + account.getBalance(), SwingConstants.CENTER);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");

        amountField = new JTextField();

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performWithdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performDeposit();
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBalance();
            }
        });

        frame.add(balanceLabel);
        frame.add(amountField);
        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(checkBalanceButton);

        frame.setVisible(true);
    }

    private void performWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdraw(amount)) {
                JOptionPane.showMessageDialog(frame, "Withdrawal Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Insufficient funds or invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            updateBalance();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                account.deposit(amount);
                JOptionPane.showMessageDialog(frame, "Deposit Successful!");
                updateBalance();
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        new ATM(account);
    }
}
