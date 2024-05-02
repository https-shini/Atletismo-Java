import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private JFrame frame;
    private JPanel panel;
    private JTextField nomeField, paisField, tempoField;
    private JRadioButton masculinoRadioButton, femininoRadioButton;
    private JTextArea resultadoArea;
    private ArrayList<Atleta> atletas = new ArrayList<>();
    private Stack<Atleta> mulheres = new Stack<>();
    private Queue<Atleta> homens = new LinkedList<>();

    public Main() {
        // Adicionar os valores iniciais:
        cadastrarDadosIniciais();

        frame = new JFrame("Campeonato de Atletismo 2024");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 625);

        panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Labels e campos de entrada
        JLabel nomeLabel = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nomeLabel, constraints);

        nomeField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nomeField, constraints);

        JLabel paisLabel = new JLabel("País:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(paisLabel, constraints);

        paisField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(paisField, constraints);

        JLabel tempoLabel = new JLabel("Tempo (s):");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(tempoLabel, constraints);

        tempoField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(tempoField, constraints);

        JLabel sexoLabel = new JLabel("Sexo:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(sexoLabel, constraints);

        masculinoRadioButton = new JRadioButton("Masculino");
        femininoRadioButton = new JRadioButton("Feminino");
        ButtonGroup group = new ButtonGroup();
        group.add(masculinoRadioButton);
        group.add(femininoRadioButton);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(masculinoRadioButton);
        radioPanel.add(femininoRadioButton);
        constraints.gridx = 1;
        panel.add(radioPanel, constraints);

        // Botões
        JButton cadastrarButton = new JButton("Cadastrar");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(cadastrarButton, constraints);

        JButton listarAtletasButton = new JButton("Listar Atletas");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        panel.add(listarAtletasButton, constraints);

        JButton calcularMediaButton = new JButton("Média Geral");
        constraints.gridx = 1;
        panel.add(calcularMediaButton, constraints);

        JButton melhorAtletaFemininaButton = new JButton("Melhor tempo Feminino");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(melhorAtletaFemininaButton, constraints);

        JButton calcularMediaTemposHomensBrasileiros = new JButton("Média Masculina Brasileira");
        constraints.gridx = 1;
        panel.add(calcularMediaTemposHomensBrasileiros, constraints);

        JButton mostrarPilhaButton = new JButton("Mostrar Pilha");
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        panel.add(mostrarPilhaButton, constraints);

        JButton retirarPilhaButton = new JButton("Retirar da Pilha");
        constraints.gridx = 1;
        panel.add(retirarPilhaButton, constraints);

        JButton mostrarFilaButton = new JButton("Mostrar Fila");
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel.add(mostrarFilaButton, constraints);

        JButton retirarFilaButton = new JButton("Retirar da Fila");
        constraints.gridx = 1;
        panel.add(retirarFilaButton, constraints);

        JButton autoresButton = new JButton("Autores");
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        panel.add(autoresButton, constraints);

        // Resultado das operações
        resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        constraints.gridheight = 20;
        panel.add(scrollPane, constraints);

        frame.setVisible(true);

        // Ação do botão Cadastrar
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAtleta();
            }
        });

        // Ação do botão Listar Atletas
        listarAtletasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String listaAtletas = listarAtletas();
                resultadoArea.setText(listaAtletas);
            }
        });

        // Ação do botão Calcular Média
        calcularMediaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });

        // Ação do botão Melhor Atleta Feminina
        melhorAtletaFemininaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encontrarMelhorAtletaFeminina();
            }
        });

        // Ação do botão média de Atleta Masculino brasileiro
        calcularMediaTemposHomensBrasileiros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularMediaTemposHomensBrasileiros();
            }
        });

        // Ação do botão Mostrar Pilha
        mostrarPilhaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPilha();
            }
        });

        // Ação do botão Retirar da Pilha
        retirarPilhaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retirarDaPilha();
            }
        });

        // Ação do botão Mostrar Fila
        mostrarFilaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFila();
            }
        });

        // Ação do botão Retirar da Fila
        retirarFilaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retirarDaFila();
            }
        });

        // Ação do botão Autores
        autoresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirAutores();
            }
        });
    }

    private void cadastrarDadosIniciais() {
        Atleta a1 = new Atleta("Laura Stewart", "F", "USA", 10.65);
        atletas.add(a1);

        Atleta a2 = new Atleta("Francesco Laurentis", "M", "Itália", 10.98);
        atletas.add(a2);

        Atleta a3 = new Atleta("Lívia Alves", "F", "Brasil", 11.32);
        atletas.add(a3);

        Atleta a4 = new Atleta("Marcos Silva", "M", "Brasil", 9.98);
        atletas.add(a4);

        Atleta a5 = new Atleta("Fernando Sotomayor", "M", "Cuba", 11.42);
        atletas.add(a5);

        Atleta a6 = new Atleta("Miley Marley", "F", "Jamaica", 10.58);
        atletas.add(a6);

        Atleta a7 = new Atleta("Pierre Depardiu", "M", "França", 11.78);
        atletas.add(a7);

        Atleta a8 = new Atleta("Renata Medeiros", "F", "Portugal", 12.14);
        atletas.add(a8);

        // Classificar os atletas em listas separadas com base no sexo
        for (Atleta atleta : atletas) {
            if (atleta.getSexo().equals("F")) {
                mulheres.add(atleta);
            } else {
                homens.offer(atleta);
            }
        }
    }

    private void cadastrarAtleta() {
        String nome = nomeField.getText();
        String pais = paisField.getText();
        String tempoStr = tempoField.getText();

        if (tempoStr.isEmpty()) {
            resultadoArea.setText("Erro: Preencha o campo de tempo.");
            return;
        }

        double tempo;

        try {
            tempo = Double.parseDouble(tempoStr);
        } catch (NumberFormatException e) {
            resultadoArea.setText("Erro: Tempo inválido. Insira um número válido.");
            return;
        }

        String sexo;

        if (masculinoRadioButton.isSelected()) {
            sexo = "M";
        } else if (femininoRadioButton.isSelected()) {
            sexo = "F";
        } else {
            resultadoArea.setText("Erro: Selecione o sexo do atleta.");
            return;
        }

        Atleta atleta = new Atleta(nome, sexo, pais, tempo);
        atletas.add(atleta);

        if (sexo == "F") {
            mulheres.push(atleta);
        } else {
            homens.offer(atleta);
        }

        resultadoArea.setText("Atleta cadastrado com sucesso!");
        limparCampos();
    }

    private String listarAtletas() {
        StringBuilder infoAtletas = new StringBuilder();
        infoAtletas.append("Lista de Atletas:\n");

        for (Atleta atleta : atletas) {
            infoAtletas.append("Nome: ").append(atleta.getNome()).append("\n");
            infoAtletas.append("País: ").append(atleta.getPais()).append("\n");
            infoAtletas.append("Tempo: ").append(Double.toString(atleta.getTempo())).append(" segundos\n");
            infoAtletas.append("\n");
        }

        return infoAtletas.toString();
    }

    private void calcularMedia() {
        if (atletas.isEmpty()) {
            resultadoArea.setText("Nenhum atleta cadastrado!");
        } else {
            double somaTempos = 0;
            for (Atleta atleta : atletas) {
                somaTempos += atleta.getTempo();
            }
            double media = somaTempos / atletas.size();
            resultadoArea.setText("Média dos tempos: " + media + " segundos");
        }
    }

    private void encontrarMelhorAtletaFeminina() {
        if (mulheres.isEmpty()) {
            resultadoArea.setText("Não há atletas femininas cadastradas!");
        } else {
            double menorTempo = Double.MAX_VALUE;
            Atleta melhorAtleta = null;

            for (Atleta atleta : mulheres) {
                if (atleta.getTempo() < menorTempo) {
                    menorTempo = atleta.getTempo();
                    melhorAtleta = atleta;
                }
            }

            resultadoArea.setText("Melhor Atleta Feminina:" + melhorAtleta + "\n" + "Tempo:" +melhorAtleta.getTempo());
        }
    }

    private void calcularMediaTemposHomensBrasileiros() {
        int count = 0;
        double somaTempos = 0;

        for (Atleta atleta : atletas) {
            if (atleta.getSexo().equalsIgnoreCase("M") && atleta.getPais().equalsIgnoreCase("Brasil")) {
                count++;
                somaTempos += atleta.getTempo();
            }
        }

        if (count == 0) {
            resultadoArea.setText("Nenhum atleta brasileiro masculino cadastrado.");
        } else {
            double media = somaTempos / count;
            resultadoArea.setText(String.format("Média dos tempos dos atletas brasileiros masculinos: %.2f segundos", media));
        }
    }


    private void mostrarPilha() {
        if (mulheres.isEmpty()) {
            resultadoArea.setText("Pilha de mulheres está vazia!");
        } else {
            resultadoArea.setText("Pilha de mulheres:\n");
            for (Atleta mulher : mulheres) {
                resultadoArea.append(mulher.toString() + "\n");
            }
        }
    }

    private void retirarDaPilha() {
        if (mulheres.isEmpty()) {
            resultadoArea.setText("Pilha de mulheres está vazia!");
        } else {
            Atleta atletaRemovida = mulheres.pop();
            resultadoArea.setText("Atleta removida da pilha:\n" + atletaRemovida.toString());
        }
    }

    private void mostrarFila() {
        if (homens.isEmpty()) {
            resultadoArea.setText("Fila de homens está vazia!");
        } else {
            resultadoArea.setText("Fila de homens:\n");
            for (Atleta homem : homens) {
                resultadoArea.append(homem.toString() + "\n");
            }
        }
    }

    private void retirarDaFila() {
        if (homens.isEmpty()) {
            resultadoArea.setText("Fila de homens está vazia!");
        } else {
            Atleta atletaRemovido = homens.poll();
            resultadoArea.setText("Atleta removido da fila:\n" + atletaRemovido.toString());
        }
    }


    private void limparCampos() {
        nomeField.setText("");
        paisField.setText("");
        tempoField.setText("");
        masculinoRadioButton.setSelected(true);
    }

    private void exibirAutores() {
        String[] nomes = {
                "Flávio Caramit Gomes",
                "Geovanna Domenica Calabro dos Santos",
                "Guilherme de Souza Cruz",
                "Vinicius Ansbach Costa",
                "Vitor Stratikopoulos França"
        };

        String[] rgms = {
                "34637109",
                "33465924",
                "34032207",
                "35566515",
                "35700033"
        };

        ImageIcon[] imagens = {
                new ImageIcon("./src/img/flavio.png"),
                new ImageIcon("./src/img/domenica.png"),
                new ImageIcon("./src/img/icon.png"),
                new ImageIcon("./src/img/vini.png"),
                new ImageIcon("./src/img/vitor.png")
        };

        new JanelaAutores(nomes, rgms, imagens);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
