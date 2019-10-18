ALTER TABLE `prosecutor`
MODIFY `age` int(3) CHECK (`age`>18),
        `sex` varchar(10) CHECK(`sex` in ('Male', 'Female'));