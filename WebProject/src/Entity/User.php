<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;


/**
 * User
 *
 * @ORM\Table(name="user")
 * @ORM\Entity
 */
class User
{
    /**
     * @var int
     *
     * @ORM\Column(name="ID", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom", type="string", length=20, nullable=false)
     * @Assert\NotBlank(message="Get Nom!")
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom", type="string", length=20, nullable=false)
     * @Assert\NotBlank(message="Get Prenom!")
     */
    private $prenom;

    /**
     * @var Assert\Date
     *
     * @ORM\Column(name="datenaissance", type="date")
     * @Assert\Date
     * @Assert\LessThan("today")

     */
    private $datenaissance;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Get Email!")
     * @Assert\Email(message = "The email '{{ value }}' is not a valid email.")
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="password", type="string", length=8, nullable=false)
     * @Assert\NotBlank(message="Get Password!")
     * @Assert\Length(min = 5,max = 8,minMessage = "Your password must be at least {{ limit }} characters long",maxMessage = "Your password cannot be longer than {{ limit }} characters")
     */
    private $password;

    /**
     * @var string
     *
     * @ORM\Column(name="numerotelephone", type="string", length=50, nullable=false)
     * @Assert\NotBlank(message="Get Telephone!")
     */
    private $numerotelephone;

    /**
     * @var string
     *
     * @ORM\Column(name="adresse", type="string", length=20, nullable=false)
     * @Assert\NotBlank(message="Get Address!")
     */
    private $adresse;

    /**
     * @var string|null
     *
     * @ORM\Column(name="specialite", type="string", length=30, nullable=true)
     */
    private $specialite;

    /**
     * @var string
     *
     * @ORM\Column(name="role", type="string", length=30, nullable=false)
     * @Assert\NotBlank(message="Get Role!")
     */
    private $role;

    /**
     * @ORM\Column(type="boolean")
     */
    private $isVerified = false;

    /**
     * @return int
     *
     */
    public function getId(): int
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId(int $id): void
    {
        $this->id = $id;
    }

    /**
     * @return string|null
     */
    public function getNom(): ?string
    {
        return $this->nom;
    }

    /**
     * @param string|null $nom
     */
    public function setNom(?string $nom): void
    {
        $this->nom = $nom;
    }

    /**
     * @return string|null
     */
    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    /**
     * @param string|null $prenom
     */
    public function setPrenom(?string $prenom): void
    {
        $this->prenom = $prenom;
    }

    /**
     * @return \DateTime|null
     */
    public function getDatenaissance(): ?\DateTime
    {
        return $this->datenaissance;
    }

    /**
     * @param \DateTime|null $datenaissance
     */
    public function setDatenaissance(?\DateTime $datenaissance): void
    {
        $this->datenaissance = $datenaissance;
    }

    /**
     * @return string|null
     */
    public function getEmail(): ?string
    {
        return $this->email;
    }

    /**
     * @param string|null $email
     */
    public function setEmail(?string $email): void
    {
        $this->email = $email;
    }

    /**
     * @return string|null
     */
    public function getPassword(): ?string
    {
        return $this->password;
    }

    /**
     * @param string|null $password
     */
    public function setPassword(?string $password): void
    {
        $this->password = $password;
    }

    /**
     * @return string|null
     */
    public function getNumerotelephone(): ?string
    {
        return $this->numerotelephone;
    }

    /**
     * @param string|null $numerotelephone
     */
    public function setNumerotelephone(?string $numerotelephone): void
    {
        $this->numerotelephone = $numerotelephone;
    }

    /**
     * @return string|null
     */
    public function getAdresse(): ?string
    {
        return $this->adresse;
    }

    /**
     * @param string|null $adresse
     */
    public function setAdresse(?string $adresse): void
    {
        $this->adresse = $adresse;
    }

    /**
     * @return string|null
     */
    public function getSpecialite(): ?string
    {
        return $this->specialite;
    }

    /**
     * @param string|null $specialite
     */
    public function setSpecialite(?string $specialite): void
    {
        $this->specialite = $specialite;
    }

    /**
     * @return string|null
     */
    public function getRole(): ?string
    {
        return $this->role;
    }

    /**
     * @param string|null $role
     */
    public function setRole(?string $role): void
    {
        $this->role = $role;
    }

    /**
     * @return bool
     */
    public function isVerified(): bool
    {
        return $this->isVerified;
    }

    /**
     * @param bool $isVerified
     */
    public function setIsVerified(bool $isVerified): void
    {
        $this->isVerified = $isVerified;
    }


}
