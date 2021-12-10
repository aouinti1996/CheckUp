<?php

namespace App\Entity;
use Doctrine\Orm\Mapping as ORM;

/**
 * @ORM\Entity (repositoryClass="App\Repository\PropertySearchRepository")
 */
class PropertySearch
{
    /**
     * @ORM\Id()
     * @ORM\GeneratedValue()
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\Column (type="string",length="255")
     */
    private $Adresse;


    public function getAdresse(): ?string
    {
        return $this->Adresse;
    }

    public function setAdresse(string $Adresse): self
    {
        $this-> Adresse = $Adresse;

        return $this;
    }
    public function getId(): ?int
    {
        return $this->id;
    }
    public function setId(string $id): self
    {
        $this-> id = $id;

        return $this;
    }








}