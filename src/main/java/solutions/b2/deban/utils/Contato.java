package solutions.b2.deban.utils;

import java.util.Objects;

public record Contato(String tipoContato, String nome, String cargo, String telefone, String email) {

    @Override
    public String toString() {
        return "Contato{" +
                "tipoContato='" + tipoContato + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return Objects.equals(tipoContato, contato.tipoContato) &&
                Objects.equals(nome, contato.nome) &&
                Objects.equals(cargo, contato.cargo) &&
                Objects.equals(telefone, contato.telefone) &&
                Objects.equals(email, contato.email);
    }

}

