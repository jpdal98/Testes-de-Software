package br.ufc.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufc.tests.AssertTests;
import br.ufc.tests.LocacaoServiceTests;

//suite de testes serve para eu definir a ordem de execução para as classes de testes
@RunWith(Suite.class)
@SuiteClasses({
	AssertTests.class,
	LocacaoServiceTests.class
})
public class SuiteExecucao {

}
