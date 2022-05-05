package edu.ufp.inf.aed2.main;

import edu.princeton.cs.algs4.*;

public class MainClass {

    /**
     * Main function
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Exemplo fornecido com AED2");
        exemplo1AED2();
        // exemplo1_BinSearchAED2();
        // exemplo2AED2_Ficheiros();
    }

    public static void exemplo1AED2() {

        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        st.put("Ana", 1);
        st.put("Bruno", 2);
        st.put("Carla", 3);
        st.put("Daniel", 4);
        st.put("Luis", 25);
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }

    public static void exemplo1_BinSearchAED2() {

        BinarySearchST<String, Integer> st = new BinarySearchST();
        st.put("A", 1);
        st.put("Z", 2);
        st.put("C", 3);
        st.put("X", 4);
        st.put("L", 25);
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }

        StdOut.println("Teste da API ordenada da Tabela de Simbolos.");
        StdOut.println("Rank de C = " + st.rank("C"));
        StdOut.println("Chave menor = " + st.min());

        StdOut.println("Listar todas as chaves entre B e P.");
        for (String s : st.keys("B", "P")) {
            StdOut.println(s + " " + st.get(s));
        }

    }

    public static void exemplo2AED2_Ficheiros() {

        In in = new In(".//data//4Kints_1.txt"); // abertura do ficheiro/stream de entrada
        String linha;
        int contar = 0, soma = 0, media;
        while (in.hasNextLine()) {
            linha = in.readLine();
            System.out.println(linha);
            contar++;
            soma = soma + Integer.valueOf(linha);
        }
        media = soma / contar;
        System.out.println("\nMedia=" + media);
    }
}
