<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20211118190916 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE questionnairee DROP FOREIGN KEY FK_A9B4626E8DACA478');
        $this->addSql('ALTER TABLE questionnairee DROP FOREIGN KEY FK_A9B4626EBA72544A');
        $this->addSql('CREATE TABLE questionss (id INT AUTO_INCREMENT NOT NULL, question1 VARCHAR(255) NOT NULL, question2 VARCHAR(255) NOT NULL, question3 VARCHAR(255) NOT NULL, question4 VARCHAR(255) NOT NULL, question5 VARCHAR(255) NOT NULL, question6 VARCHAR(255) NOT NULL, question7 VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('DROP TABLE questionnairee');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE questionnairee (id INT AUTO_INCREMENT NOT NULL, question1_id INT DEFAULT NULL, question4_id INT DEFAULT NULL, INDEX IDX_A9B4626E8DACA478 (question1_id), INDEX IDX_A9B4626EBA72544A (question4_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8 COLLATE `utf8_unicode_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('ALTER TABLE questionnairee ADD CONSTRAINT FK_A9B4626E8DACA478 FOREIGN KEY (question1_id) REFERENCES questionnairee (id)');
        $this->addSql('ALTER TABLE questionnairee ADD CONSTRAINT FK_A9B4626EBA72544A FOREIGN KEY (question4_id) REFERENCES questionnairee (id)');
        $this->addSql('DROP TABLE questionss');
    }
}
