Feature: Funcionalidades de Login no Mantis

  Scenario: Login bem-sucedido no Mantis
    Given que estou na página de login do Mantis
    When inserir o nome de usuário "nayara.valadares" e clicar em Entrar
    Then devo ser redirecionado para a página da senha
    And quando digitar a senha "testebase2" e clicar em Entrar
    Then devo ser redirecionado para a página minha visão no Mantis
    And meu nome de usuário deve ser exibido no cabeçalho da página

  Scenario: Tentativa de login com nome de usuário errado
    Given que estou na página de login do Mantis
    When inserir o nome de usuário "usuario.errado" e clicar em Entrar
    Then devo ser redirecionado para a página da senha
    And quando digitar a senha "testebase2" e clicar em Entrar
    Then a mensagem "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos." deve ser exibida

 