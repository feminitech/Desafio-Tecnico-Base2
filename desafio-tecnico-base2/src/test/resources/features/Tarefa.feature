Feature: Criação de Tarefas no Mantis

  Scenario: Criar uma nova tarefa no Mantis
    Given que estou logado no Mantis
    When clicar no botão "Criar Tarefa"
    Then a página de reporte de bug deve ser aberta
    When preencher os campos obrigatórios:
      | Resumo             | Descrição da Tarefa         
      | Nova Tarefa 1      | Descrição detalhada da tarefa 
    And clicar no botão "Criar Nova Tarefa"
    And devo ser redirecionado para a página da tarefa criada

  Scenario: Tentativa de criar uma tarefa sem preencher campos obrigatórios
    Given que estou logado no Mantis
    When clicar no botão "Criar Tarefa"
    Then a página de reporte de bug deve ser aberta
    And clicar no botão "Criar Nova Tarefa" sem preencher os campos obrigatórios
    Then deve ser exibido um pop-up com a mensagem "Preencha este campo."
