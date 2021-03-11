This project is about "Airport reservation system". 
What is "Airport reservation system application"? This is a simple console application that helps the user to register a person in the database.
It application stores information about person, tickets, place, from-to place. 
In our project, we have following classes:
1) Unique class - this is an abstract class that inherits from business, economy, first class.
2) Person class - this is an important class that contains all the information about a person.
3) Flight class - here is the fact that a person flies where and from where.
4) Business class - here is the seat on the plane, the id and the price.
5) Economy class - it's just like in business class, but it adds baggage.
6) First class - and here the food menu is added.
7) Vip_person class - here the level of privileges of the person is determined.
Also, as I mentioned before, my project is connected with the database, so I've created a database with following tables:
--
-- База данных: `end`
--

-- --------------------------------------------------------

--
-- Структура таблицы `flight`
--

CREATE TABLE `flight` (
  `flight_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `from_place` varchar(30) NOT NULL,
  `to_place` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE `person` (
  `person_id` int(11) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  `vip_level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`person_id`, `fullname`, `age`, `vip_level`) VALUES
(1, 'Test Test', 21, NULL),
(2, 'Hello', 19, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `baggage` int(11) DEFAULT NULL,
  `menu` varchar(100) DEFAULT NULL,
  `person_id` int(11) NOT NULL,
  `class` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `flight_id`, `place`, `price`, `baggage`, `menu`, `person_id`, `class`) VALUES
(1, 1, 13, 12000, NULL, 'ZAKUSKA', 2, 'f');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flight_id`);

--
-- Индексы таблицы `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_id`);

--
-- Индексы таблицы `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `flight`
--
ALTER TABLE `flight`
  MODIFY `flight_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `person`
--
ALTER TABLE `person`
  MODIFY `person_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

