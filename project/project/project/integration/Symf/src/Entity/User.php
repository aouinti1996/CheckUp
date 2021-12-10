<?php

namespace App\Entity;

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Exception;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\HttpFoundation\File\File;
use Vich\UploaderBundle\Mapping\Annotation as Vich;
/**
 * User
 * @Vich\Uploadable
 * @ORM\Table(name="user")
 * @ORM\Entity
 */
class User implements UserInterface,\Serializable

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
     * @ORM\Column(name="Nom", type="string", length=20, nullable=false)
     * @Assert\NotBlank(message="Get Nom!")
     *
     */
    private $nom;

    /**
     * @var string
     *@ORM\Column(name="Prenom", type="string", length=20, nullable=true)
     * @Assert\NotBlank(message="Get Prenom!")
     */
    private $prenom;

    /**
     * @var \DateTime|null
     *
     * @ORM\Column(name="datenaissance", type="date", nullable=true)
     */
    private $datenaissance;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=100, nullable=true)
     * @Assert\NotBlank(message="Get Email!")
     * @Assert\Email(message = "The email '{{ value }}' is not a valid email.")
     */
    private $email;

    /**
     * @var string
     * @Assert\NotBlank(message="Get Password!")
     * @Assert\Length(min = 5,max = 8,minMessage = "Your password must be at least {{ limit }} characters long",maxMessage = "Your password cannot be longer than {{ limit }} characters")
     * @ORM\Column(name="password", type="string", length=100, nullable=true)
     */
    private $password;

    /**
     * @var string
     *@Assert\Length(min = 8,max = 8,minMessage = "Your number phone must be at least {{ limit }} characters long",maxMessage = "Your password cannot be longer than {{ limit }} characters")
     * @ORM\Column(name="numerotelephone", type="string", length=50, nullable=true)
     */
    private $numerotelephone;

    /**
     * @var string
     * @ORM\Column(name="adresse", type="string", length=20, nullable=false)
     * @Assert\NotBlank(message="Get Address!")

     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="specialite", type="string", length=30, nullable=false)
     */
    private $specialite;

    /**
     * @var string|null
     *
     * @ORM\Column(name="role", type="string", length=30, nullable=true)
     */
    private $role;
    /**
     * @ORM\Column(type="json")
     */
    private $roles = [];
    /**
     * @ORM\Column(type="string", length=255)
     * @var string
     */
    private $image;

    /**
     * @Vich\UploadableField(mapping="saloons", fileNameProperty="image")
     * @var File
     */
    private $imageFile;

    /**
     * @ORM\Column(type="datetime")
     * @var \DateTime
     */
    private $updatedAt;
    private $captchaCode;

    /**
     * @return int
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

    public function setImageFile($image = null)
    {
        $this->imageFile = $image;

        // VERY IMPORTANT:
        // It is required that at least one field changes if you are using Doctrine,
        // otherwise the event listeners won't be called and the file is lost
        if ($image) {
            // if 'updatedAt' is not defined in your entity, use another property
            $this->updatedAt = new \DateTime('now');
        }
    }

    public function getImageFile()
    {
        return $this->imageFile;
    }

    public function setImage($image)
    {
        $this->image = $image;
    }

    public function getImage()
    {
        return $this->image;
    }

    /**
     * @see UserInterface
     */
    public function getRoles(): array
    {
        $roles = $this->roles;
        // guarantee every user at least has ROLE_USER
        $roles[] = 'ROLE_USER';

        return array_unique($roles);
    }

    public function setRoles(array $roles): self
    {
        $this->roles = $roles;

        return $this;
    }

    public function getSalt()
    {
        return null;
    }




    public function getUsername()
    {
        return $this->email;
    }

    public function eraseCredentials()
    {
        // TODO: Implement eraseCredentials() method.
        // If you store any temporary, sensitive data on the user, clear it here
        // $this->plainPassword = null;
    }

    public function serialize()
    {
        return serialize(array(
            $this->id,
            $this->nom,
            $this->prenom,
            $this->email,
            $this->password,
            $this->specialite,
            $this->datenaissance,
            $this->adresse,
            $this->numerotelephone,
            $this->role,
        ));

    }
    public function getCaptchaCode()
    {
        return $this->captchaCode;
    }

    public function setCaptchaCode($captchaCode)
    {
        $this->captchaCode = $captchaCode;
    }

    public function unserialize($data)
    {
        list (
            $this->id,
            $this->nom,
            $this->prenom,
            $this->email,
            $this->password,
            $this->specialite,
            $this->datenaissance,
            $this->adresse,
            $this->numerotelephone,
            $this->role,
            ) = unserialize($data);
    }
}
