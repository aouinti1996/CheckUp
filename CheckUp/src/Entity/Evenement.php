<?php

namespace App\Entity;

use App\Repository\EvenementRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;


/**
 * @ORM\Entity(repositoryClass=EvenementRepository::class)
 */
class Evenement
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="il faut donner un titre")
     */
    private $titreeven;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="il faut donne la description ")
     */
    private $descriptioneven;

    /**
     * @ORM\Column(type="date")
     * @Assert\NotBlank(message="il faut donne une date")
     */
    private $dateFin;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="il faut donne un lieu")
     */
    private $lieuEven;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="il faut donne les invitees")
     */
    private $invites;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="il faut donne un responsable")
     */
    private $responsable;

    /**
     * @ORM\Column(type="date")
     * @Assert\NotBlank(message="il faut donne une date")
     */
    private $dateDebut;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitreeven(): ?string
    {
        return $this->titreeven;
    }

    public function setTitreeven(string $titreeven): self
    {
        $this->titreeven = $titreeven;

        return $this;
    }

    public function getDescriptioneven(): ?string
    {
        return $this->descriptioneven;
    }

    public function setDescriptioneven(string $descriptioneven): self
    {
        $this->descriptioneven = $descriptioneven;

        return $this;
    }

    public function getDateFin(): ?\DateTimeInterface
    {
        return $this->dateFin;
    }

    public function setDateFin(\DateTimeInterface $dateFin): self
    {
        $this->dateFin = $dateFin;

        return $this;
    }

    public function getLieuEven(): ?string
    {
        return $this->lieuEven;
    }

    public function setLieuEven(string $lieuEven): self
    {
        $this->lieuEven = $lieuEven;

        return $this;
    }

    public function getInvites(): ?string
    {
        return $this->invites;
    }

    public function setInvites(string $invites): self
    {
        $this->invites = $invites;

        return $this;
    }

    public function getResponsable(): ?string
    {
        return $this->responsable;
    }

    public function setResponsable(string $responsable): self
    {
        $this->responsable = $responsable;

        return $this;
    }

    public function getDateDebut(): ?\DateTimeInterface
    {
        return $this->dateDebut;
    }

    public function setDateDebut(\DateTimeInterface $dateDebut): self
    {
        $this->dateDebut = $dateDebut;

        return $this;
    }
}
