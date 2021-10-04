package br.ufc.Mocks.ServicosRepositorio;

import br.ufc.JDBC.ConnectionFactory;
import br.ufc.controllers.ClienteController;
import br.ufc.controllers.ServiçoController;
import br.ufc.entities.Cliente;
import br.ufc.entities.Serviços;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddServicosRepositorioMock {

    @Mock
    private ConnectionFactory factory = Mockito.mock(ConnectionFactory.class);

    @Mock
    private Connection conn = Mockito.mock(Connection.class);

    @Mock
    private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);

    @Mock
    private ResultSet rs = Mockito.mock(ResultSet.class);

    private Serviços serviçosSetup = new Serviços("Roberto", 10.1);
    private ClienteController clienteController = new ClienteController(factory);


    @Before
    public void setUp() throws SQLException {

        MockitoAnnotations.initMocks(this);

        Mockito.when(factory.getConnection()).thenReturn(conn);

        Mockito.when(conn.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);

        Mockito.when(stmt.executeUpdate()).thenReturn(1);

        Mockito.when(stmt.executeQuery()).thenReturn(rs);

        Mockito.doNothing().when(stmt).close();

        Mockito.when(conn.prepareStatement(Mockito.startsWith("Select"))).thenReturn(stmt);

        Mockito.when(rs.getString("nomeServicos")).thenReturn(serviçosSetup.getNomeServiço());

        Mockito.when(rs.getDouble("precoServico")).thenReturn(serviçosSetup.getPreço());


    }
    @Test
    public void addServico() throws SQLException {
        ServiçoController serviçoController = new ServiçoController(factory);
        Serviços serviços = new Serviços(serviçosSetup.getNomeServiço(), serviçosSetup.getPreço());
        assertTrue(serviçoController.criarServiço(serviços));
        Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void addServicoNomeInvalido() throws SQLException {
        ServiçoController serviçoController = new ServiçoController(factory);
        Serviços serviços = new Serviços("12334123", serviçosSetup.getPreço());
        assertFalse(serviçoController.criarServiço(serviços));
        Mockito.verifyZeroInteractions(stmt);
    }

    @Test
    public void addServicoNomeVazio() throws SQLException {
        ServiçoController serviçoController = new ServiçoController(factory);
        Serviços serviços = new Serviços("", serviçosSetup.getPreço());
        assertFalse(serviçoController.criarServiço(serviços));
        Mockito.verifyZeroInteractions(stmt);
    }
}
