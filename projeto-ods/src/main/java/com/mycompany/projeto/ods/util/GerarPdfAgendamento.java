package com.mycompany.projeto.ods.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.model.Doador;
import com.mycompany.projeto.ods.model.Hemocentro;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

public class GerarPdfAgendamento {

    public static void gerar(Doador doador, Doacao doacao, Hemocentro hemocentro) {
        // Abre um JFileChooser para o usuário escolher onde salvar
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setDialogTitle("Salvar comprovante de agendamento");
        chooser.setSelectedFile(new File("comprovante_agendamento.pdf"));
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF", "pdf"));

        int resultado = chooser.showSaveDialog(null);
        if (resultado != javax.swing.JFileChooser.APPROVE_OPTION) {
            return; // usuário cancelou
        }

        File arquivo = chooser.getSelectedFile();
        if (!arquivo.getName().endsWith(".pdf")) {
            arquivo = new File(arquivo.getAbsolutePath() + ".pdf");
        }

        try {
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, new FileOutputStream(arquivo));
            doc.open();

            // Fontes
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font fontSubtitulo = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            Font fontLabel = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            Font fontValor = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);

            // Título
            Paragraph titulo = new Paragraph("Comprovante de Agendamento de Doação", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            doc.add(titulo);

            // Linha separadora
            doc.add(new Chunk(new com.itextpdf.text.pdf.draw.LineSeparator()));
            doc.add(Chunk.NEWLINE);

            // Dados do doador
            Paragraph secDoador = new Paragraph("Dados do Doador", fontSubtitulo);
            secDoador.setSpacingAfter(8);
            doc.add(secDoador);

            adicionarCampo(doc, "Nome:", doador.getNome(), fontLabel, fontValor);
            adicionarCampo(doc, "CPF:", doador.getCpf(), fontLabel, fontValor);
            adicionarCampo(doc, "Tipo Sanguíneo:", doador.getTipoSanguineo(), fontLabel, fontValor);
            adicionarCampo(doc, "Data de Nascimento:",
                    doador.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    fontLabel, fontValor);

            doc.add(Chunk.NEWLINE);
            doc.add(new Chunk(new com.itextpdf.text.pdf.draw.LineSeparator()));
            doc.add(Chunk.NEWLINE);

            // Dados do agendamento
            Paragraph secAgendamento = new Paragraph("Dados do Agendamento", fontSubtitulo);
            secAgendamento.setSpacingAfter(8);
            doc.add(secAgendamento);

            adicionarCampo(doc, "Hemocentro:", hemocentro.getNome(), fontLabel, fontValor);
            adicionarCampo(doc, "Endereço:", hemocentro.getEndereco(), fontLabel, fontValor);
            adicionarCampo(doc, "Data:",
                    doacao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    fontLabel, fontValor);
            adicionarCampo(doc, "Horário:",
                    doacao.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")),
                    fontLabel, fontValor);
            adicionarCampo(doc, "Status:", doacao.getStatus(), fontLabel, fontValor);

            doc.add(Chunk.NEWLINE);
            doc.add(new Chunk(new com.itextpdf.text.pdf.draw.LineSeparator()));
            doc.add(Chunk.NEWLINE);

            // Rodapé
            Paragraph rodape = new Paragraph("Obrigado por salvar vidas!", fontValor);
            rodape.setAlignment(Element.ALIGN_CENTER);
            doc.add(rodape);

            doc.close();

            // Abre o PDF automaticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(arquivo);
            }

            javax.swing.JOptionPane.showMessageDialog(null,
                    "Comprovante salvo em:\n" + arquivo.getAbsolutePath(),
                    "PDF Gerado",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Erro ao gerar PDF: " + e.getMessage(),
                    "Erro",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void adicionarCampo(Document doc, String label, String valor,
            Font fontLabel, Font fontValor) throws DocumentException {
        Paragraph p = new Paragraph();
        p.add(new Chunk(label + " ", fontLabel));
        p.add(new Chunk(valor != null ? valor : "—", fontValor));
        p.setSpacingAfter(5);
        doc.add(p);
    }
}