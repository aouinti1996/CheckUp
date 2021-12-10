<?php

namespace App\Entity;

use App\Repository\EnligneRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=EnligneRepository::class)
 */
class Enligne
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $emailmed;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $emailpat;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $lien;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEmailmed(): ?string
    {
        return $this->emailmed;
    }

    public function setEmailmed(string $emailmed): self
    {
        $this->emailmed = $emailmed;

        return $this;
    }

    public function getEmailpat(): ?string
    {
        return $this->emailpat;
    }

    public function setEmailpat(string $emailpat): self
    {
        $this->emailpat = $emailpat;

        return $this;
    }

    public function getLien(): ?string
    {
        return $this->lien;
    }

    public function setLien(string $lien): self
    {
        $this->lien = $lien;

        return $this;
    }
}
