<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Medecin
 *
 * @ORM\Table(name="medecin")
 * @ORM\Entity(repositoryClass="App\Repository\MedecinRepository")
 */
class Medecin
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_medecin", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idMedecin;

    /**
     * @var string
     *
     * @ORM\Column(name="specialite_medecin", type="string", length=20, nullable=false)
     */
    private $specialiteMedecin;

    public function getIdMedecin(): ?int
    {
        return $this->idMedecin;
    }

    public function getSpecialiteMedecin(): ?string
    {
        return $this->specialiteMedecin;
    }

    public function setSpecialiteMedecin(string $specialiteMedecin): self
    {
        $this->specialiteMedecin = $specialiteMedecin;

        return $this;
    }


}
