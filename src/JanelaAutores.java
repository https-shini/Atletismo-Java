import javax.swing.*;
import java.awt.*;

public class JanelaAutores extends JFrame {

    public JanelaAutores(String[] nomes, String[] rgms, ImageIcon[] imagens) {
        setTitle("Autores");
        setSize(1250, 850);

        // Cria um painel para organizar os componentes
        JPanel panel = new JPanel(new GridLayout(2, 1)); // 2 linhas, 1 coluna

        // Adiciona os autores na linha superior
        JPanel autoresSuperiorPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 linha, 3 colunas
        for (int i = 0; i < 3; i++) {
            JPanel autorPanel = criarPainelAutor(nomes[i], rgms[i], imagens[i]);
            autoresSuperiorPanel.add(autorPanel);
        }
        panel.add(autoresSuperiorPanel);

        // Adiciona os autores na linha inferior
        JPanel autoresInferiorPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 linha, 2 colunas
        for (int i = 3; i < nomes.length; i++) {
            JPanel autorPanel = criarPainelAutor(nomes[i], rgms[i], imagens[i]);
            autoresInferiorPanel.add(autorPanel);
        }
        panel.add(autoresInferiorPanel);

        // Adiciona o painel à janela
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true); // Torna a janela visível
    }

    // Método para criar o painel de cada autor
    private JPanel criarPainelAutor(String nome, String rgm, ImageIcon imagem) {
        JPanel autorPanel = new JPanel(new BorderLayout());
        autorPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Adiciona uma borda ao redor do painel

        // Cria um JLabel para exibir a imagem
        JLabel imagemLabel = new JLabel(imagem);
        imagemLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza a imagem
        autorPanel.add(imagemLabel, BorderLayout.CENTER);

        // Cria um JPanel para o texto dos autores
        JPanel textoPanel = new JPanel(new GridLayout(2, 1)); // 2 linhas, 1 coluna
        textoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Adiciona um espaçamento interno ao redor do texto

        // Adiciona o nome do autor
        JLabel nomeLabel = new JLabel(nome);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Define a fonte para negrito
        nomeLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto
        textoPanel.add(nomeLabel);

        // Adiciona o RGM do autor
        JLabel rgmLabel = new JLabel("RGM: " + rgm);
        rgmLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Define a fonte para normal
        rgmLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto
        textoPanel.add(rgmLabel);

        autorPanel.add(textoPanel, BorderLayout.SOUTH);

        return autorPanel;
    }
}
