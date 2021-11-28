<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20211117225844 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE user CHANGE password password VARCHAR(8) NOT NULL');
        $this->addSql('ALTER TABLE user_fake ADD roles JSON NOT NULL, ADD password VARCHAR(255) NOT NULL, DROP Nom, DROP Prenom, DROP datenaissance, DROP role, CHANGE email email VARCHAR(180) NOT NULL');
        $this->addSql('CREATE UNIQUE INDEX UNIQ_B74CBDA6E7927C74 ON user_fake (email)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE user CHANGE password password VARCHAR(20) CHARACTER SET latin1 NOT NULL COLLATE `latin1_swedish_ci`');
        $this->addSql('DROP INDEX UNIQ_B74CBDA6E7927C74 ON user_fake');
        $this->addSql('ALTER TABLE user_fake ADD Nom VARCHAR(70) CHARACTER SET latin1 NOT NULL COLLATE `latin1_swedish_ci`, ADD Prenom VARCHAR(70) CHARACTER SET latin1 NOT NULL COLLATE `latin1_swedish_ci`, ADD datenaissance VARCHAR(20) CHARACTER SET latin1 NOT NULL COLLATE `latin1_swedish_ci`, ADD role VARCHAR(30) CHARACTER SET latin1 NOT NULL COLLATE `latin1_swedish_ci`, DROP roles, DROP password, CHANGE email email VARCHAR(100) CHARACTER SET latin1 NOT NULL COLLATE `latin1_swedish_ci`');
    }
}
