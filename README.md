# ProjetoJavamos
 = Atenção! = 
Uma versão em HTML deste conteúdo está disponível em:
<https://javamos.ecolabore.net>

<h2> Integrantes </h2>

Thaina Bitencourt - https://github.com/Thainahelliza/ProjetoJavamos
Ângelo Beck - https://github.com/angelobeck/rpg
Olavo Neto - https://github.com/olavonettow/Projeto-itau-dot-exemplo-spring-java-main
Junior Faria - https://github.com/jr7f




## Apresentação ##

Conforme a proposta dada, de criar uma API, assim a fizemos.

O sistema possui dois elementos: o banco de dados e a API. Vamos considerar também o usuário, para quem nossa API é destinada.

### Banco de dados ###

Para o banco de dados utilizamos o MySQL, onde, através da linha de comandos do MySQL, criamos duas tabelas e as preenchemos com dados.

Uma das tabelas registra os clientes, incluindo um código para identificar cada cliente. A segunda registra as contas. Nesta última, uma coluna faz referência ao código do cliente detentor da conta.

### API ###

O usuário fará as requisições à nossa API e receberá os dados recuperados do banco de dados no formato JSON.

A API disponibiliza 4 endpoints:

* ``/clientes`` - retorna uma lista com todos os usuários;
* ``/contas`` - retorna uma lista de todas as contas cadastradas;
* ``/clientes/<id>`` - retorna os dados de um usuário especificado pelo seu código de cadastro e todas as contas vinculadas a ele.
* ``/contas/<id>`` - retorna os dados de uma conta específica.

Internamente a API possui 4 blocos principais:

1. A função ``main()``, responsável por dar início ao SpringBoot;

2. Os ``controllers``, responsáveis por atender a cada endpoint;

3. as ``views``, responsáveis por produzir os dados necessários para um determinado endpoint;

4. os ``models``, que servem como modelos para recuperar os dados do banco de dados.

## 1. Iniciando a aplicação ##

A função ``main()``, no arquivo ``src/main/java/com/api/projeto/ProjetoApplication.java``, possui uma única linha, solicitando a inicialização do SpringBoot.

Quando o SpringBoot é iniciado, ele não mais retorna a função ``main()``, permanecendo ativo durante todo o tempo em que permitirmos que o servidor se mantenha ativo.

O SpringBoot passa então a "escutar" uma porta HTTP, aguardando alguma solicitação. Apenas para fins de teste, podemos fazer as solicitações diretamente através da barra de endereços do navegador, tal como ``https://localhost:8080``. Podemos acrescentar ao final deste endereço os endpoints que mensionamos anteriormente.

Felizmente o SpringBoot se encarregará de receber cada solicitação e encaminhá-la para os métodos que criamos em nossos *controllers*, sem que tenhamos que nos preocupar com configurações de porta, abertura de soquetes, com o ciclo de vida da aplicação ou com o gerenciamento de threads. Se você não entendeu o que isso significa fique tranquilo, pois é justamente para que não tenhamos que nos preocupar com estas coisas que utilizamos as ferramentas do SpringBoot!

## 2. Roteando a aplicação ##

Na pasta ``controllers/``, os arquivos ``ClienteController.java``, ``ContaController.java`` e ``HomeController.java`` são responsáveis por configurar os endpoints da API, receber as requisições e solicitar os dados que serão retornados ao cliente.

A configuração dos endpoints é feita através de *annotations*, instruções precedidas por um ``@``, que acrescentam informações extras às classes, métodos e propriedades.

Estas anotações extras serão processadas pelo SpringBoot, permitindo que ele magicamente configure o roteamento das requisições para as funções que criamos.

Noentanto, as funções que criamos em nossos controllers para receber as requisições, irão invocar outras classes para realizar a tarefa de recuperar os dados solicitados pelo usuário.

Iremos apresentá-las a seguir:

## 3. Preparando views ##

São as *Views* responsáveis pelas regras de negócio da nossa aplicação. É nelas que decisões importantes são tomadas, tais como verificar direitos de acesso, receber dados do usuário, inserir, alterar ou remover dados no banco de dados.

Mas as views não são necessariamente complicadas. Algumas são tão simples quanto retornar uma saudação ao usuário, informando sobre a correta utilização do serviço.

Além disso, o trabalho de se comunicar com o banco de dados para inserir, atualizar, recuperar ou remover dados do banco de dados são atribuições de um terceiro grupo de classes, os *models*.


No arquivo ``HomeView.java``, na pasta ``modelView``, temos um exemplo de view que retorna informações sobre a AAPI, úteis quando o usuário chama a raiz da aplicação. Observe que esta view já contém todos os dados que serão retornados para o controller, por isso é chamada de *modelview*, uma mistura de *view* com *model*.



## 4. Modelos ##

Modelos ou *models*, são classes que representam as tabelas existentes no banco de dados. Um modelo adequado deve possuir exatamente uma propriedade para cada coluna da tabela que representa no banco de dados. Esta propriedade também deve ser de um tipo compatível com os dados da coluna que representa, por exemplo ``string``, ``int`` ou ``float``.

Mais uma vez, *annotations* são utilizadas aqui, permitindo que o SpringBoot automatize a geração de propriedades e métodos adequados ao nosso model.

Acrescentamos a nossos models alguns métodos para recuperar informações do banco de dados.

Para cada registro recuperado, criamos um objeto a partir do modelo em questão, e cada propriedade do objeto é então preenchida com os dados correspondentes à coluna do registro recebido.

É importante notar que em nossa API não temos regras de negócio. Em outras palavras, não verificamos se o usuário possui ou não direito a acessar os registros do banco de dados, nem nenhuma outra decisão importante é tomada. Simplesmente solicitamos ao banco de dados que nos retorne um ou mais registros diretamente.

Na vida real isso poderia ser válido para serviços simples que envolvam dados públicos, tais como retornar um endereço a partir de um CEP. Ao retornar dados sensíveis  e críticos, como dados de usuários e de suas respectivas contas, demandaria um trabalho bastante sério em relação à segurança, para garantir que nenhum usuário não autorizado possa obter acesso a tais informações.

Por fim, observe que por não termos regras de negócio, nossos controllers podem chamar os models diretamente, sem a necessidade de outras views.

## Retornando informações ao usuário ##

Após nossos controllers terem executado as views, e estas por sua vez terem retornado os dados dos models, podemos retornar os dados para o usuário. E aqui mais uma vez o SpringBoot nos trás uma solução simples usando *reflection*, para converter o objeto retornado ou a lista de objetos retornados, para o formato Json.

E se você não sabe o que é *reflection*, mais uma vez não se preocupe: apenas relaxe porque o SpringBoot irá receber qualquer coisa que você retornar e irá construir uma representação em JSON para você!

## Conclusão ##

Aprendemos como se programar quase sem programar! Seguindo padrões propostos por *frameworks* como o *SpringBoot*, todo o trabalho complexo exigido por um serviço de API é resolvido sem a nossa intervensão.

Por fim, cabe a nós seguir a metodologia proposta pelo framework, indicando em uma linguagem simplificada quais são as nossas necessidades específicas.

E embora cada framework disponha de soluções e metodologias de trabalho bastante específicas, pudemos perceber que é possível se entregar uma solução de valor apoiando nosso trabalho ao trabalho de muitos que, antes de nós, já ergueram construções sólidas que podem servir de base para nossos projetos.
