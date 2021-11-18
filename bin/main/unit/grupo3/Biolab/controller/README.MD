
# REST API Biolab

  

--------

  

# Administrator

  

## Cadastrar um administrador

`POST /administrator`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"email" = "",

"password" = "",

"active" = true or false

}

  

## Obter o administrador

  

`GET /administrator?email=""&password=""`

  

## Obter nome, email e status do Administrador

  

`GET /administrator/{email}`

  

## Atualizar um administrador

  

`PATCH /administrator/{email}`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"email" = "",

"password" = "",

"active" = true or false

}

## Deletar um administrador

  

`DELETE /administrator/{email}`

  

___

# Comissão de Analista

  

## Cadastrar uma comissão

  

`POST /analystcommision`

  

É necessário passar um body com essa estrutura:

  

{

"protocolId" = "",

"seemDate" = "",

"firstAnalystId" = "",

"secondAnalystId" = "",

"thirdAnalystId" = ""

}

## Obter uma comissão de analista

`GET /analystcommision/{protocolId}`

  

## Deletar uma comissão de analista

  

`DELETE /analystcommision/{protocolId}`

  

## Atualizar uma comissão de analista

  

`PATCH /analystcommision`

  

É necessário passar um body com essa estrutura:

  

{

"protocolId" = "",

"seemDate" = "",

"firstAnalystId" = "",

"secondAnalystId" = "",

"thirdAnalystId" = ""

}

______

  

# Área de Interesse

  

## Criar uma Área de Interesse

  

`POST /areaofinterest`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"description" = ""

}

## Obter uma Área de Interesse

  

`GET /areaofinterest/{name}`

  

## Obter todas as Áreas de Interesse

  

`GET /areaofinterest`

  

## Atualizar uma Área de Interesse

  

`PATCH /areaofinterest`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"description" = ""

}

## Deletar uma Área de Interesse

  

`DELETE /areaofinterest/{name}`

  

_________

  

# Presidente

  

## Criar um novo presidente

  

`POST /president`

  

É necessário passar um body com essa estrutura:

  

{

"researcherId" = "",

"managementStart" = "",

"managementEnd" = "",

"active" = true or false,

}

## Obter um presidente

  

`GET /president?researcherId=""`

  

## Deletar um presidente

  

`DELETE /president/{researcherId}`

  

## Atualizar um presidente

  

`PATCH /president`

  

É necessário passar um body com essa estrutura:

  

{

"researcherId" = "",

"managementStart" = "",

"managementEnd" = "",

"active" = true or false,

}

  

______

  

# Protocolos

  

## Criar um novo protocolo

  

`POST /protocols`

  

É necessário passar um body com essa estrutura:

  

{

"title" = "",

"matriculation" = "",

"status" = "",

"review" = "",

"seemComission" = "",

"seemPresident" = "",

"seemDate" = "",

"speciesId" = "",

"quantitySpecies" = "",

"firstSeem" = "",

"secondSeem" = "",

"thirdSeem" = "",

"areaId" = "",

}

## Obter todos os protocolos

`GET /protocols/`

## Obter um protocolo:

  

`GET /protocols/{id}`

  
  

## Deletar um protocolo:

  

`DELETE /protocols/{id}`

  
## Pegar os protocolos pelos status

`GET /protocols/status/{int}`

  `int é um número inteiro de 0 a 3: PENDING(0), ANALYSING(1), APPROVED(2), REPROVED(3)`


## Pegar os protocolos dos pesquisadores pela matricula

`GET /protocols/matriculation/{matriculation}`

______

  

# Pesquisador

  

## Criar um novo pesquisador

  

`POST /researchers`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"email" = "",

"password" = "",

"matriculation" = "",

"areaOfInterest" = "",

"curriculumLink" = "",

"active" = true or false,

"isPresident" = true or false

}

## Obter os pesquisadores ativos

  

`GET /researchers/actives`

  

## Obter um pesquisador

  

`GET /researchers?email=""&password=""`

  

## Obter dados do pesquisador pela matricula

  

`GET /researchers/{matriculation}`

  

## Atualizar os dados de um pesquisador

  

`PATCH /researchers/{matriculation}`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"email" = "",

"password" = "",

"matriculation" = "",

"areaOfInterest" = "",

"curriculumLink" = "",

"active" = true or false,

"isPresident" = true or false

}

## Deletar um pesquisador

  

`DELETE /researchers/{matriculation}`


## Saber se existe um email cadastrado

`GET /reseachers/email/{email}`
______

  

# Secretaria

  

## Criar uma nova secretaria

  

`POST /secretarys`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"email" ="",

"password" ="",

"active" = true or false

}

## Obter uma secretaria

  

`GET /secretarys?email=""&password=""`

  

## Obter dados de uma secretaria pelo email

  

`GET /secretarys/{email}`

  

## Atualizar dados de uma secretaria

  

`PATCH /secretarys`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"email" = "",

"password" = "",

"active" = true or false

}

  

## Deletar uma secretaria

  

`DELETE /secretarys/{email}`

____

  

# Species

  

## Criar uma nova especie

  

`POST /species`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"avaliableQuantity" = ""

}

## Obter todas as especies existente

  

`GET /species`

  

## Obter uma especie especifica

  

`GET /species/{name}`

  

## Atualizar uma especie

  

`PATCH /species`

  

É necessário passar um body com essa estrutura:

  

{

"name" = "",

"avaliableQuantity" = ""

}