/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.seguridad.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.UsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.UsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UsuarioParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Usuario;
import com.bydan.erp.seguridad.business.logic.UsuarioLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class UsuarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UsuarioLogic.class);
	
	protected UsuarioDataAccess usuarioDataAccess; 	
	protected Usuario usuario;
	protected List<Usuario> usuarios;
	protected Object usuarioObject;	
	protected List<Object> usuariosObject;
	
	public static ClassValidator<Usuario> usuarioValidator = new ClassValidator<Usuario>(Usuario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UsuarioLogicAdditional usuarioLogicAdditional=null;
	
	public UsuarioLogicAdditional getUsuarioLogicAdditional() {
		return this.usuarioLogicAdditional;
	}
	
	public void setUsuarioLogicAdditional(UsuarioLogicAdditional usuarioLogicAdditional) {
		try {
			this.usuarioLogicAdditional=usuarioLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  UsuarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.usuarioDataAccess = new UsuarioDataAccess();
			
			//SE QUITA INICIALIZACION INICIAL, RAPIDEZ PANTALLA
			
			this.usuarioObject=new Object();
			this.usuariosObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.usuarioDataAccess.setConnexionType(this.connexionType);
			this.usuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UsuarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.usuarioDataAccess = new UsuarioDataAccess();
			this.usuarios= new ArrayList<Usuario>();
			this.usuario= new Usuario();
			this.usuarioObject=new Object();
			this.usuariosObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.usuarioDataAccess.setConnexionType(this.connexionType);
			this.usuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Usuario getUsuario() throws Exception {	
		UsuarioLogicAdditional.checkUsuarioToGet(usuario,this.datosCliente,this.arrDatoGeneral);
		UsuarioLogicAdditional.updateUsuarioToGet(usuario,this.arrDatoGeneral);
		
		return usuario;
	}
		
	public void setUsuario(Usuario newUsuario) {
		this.usuario = newUsuario;
	}
	
	public UsuarioDataAccess getUsuarioDataAccess() {
		return usuarioDataAccess;
	}
	
	public void setUsuarioDataAccess(UsuarioDataAccess newusuarioDataAccess) {
		this.usuarioDataAccess = newusuarioDataAccess;
	}
	
	public List<Usuario> getUsuarios() throws Exception {		
		this.quitarUsuariosNulos();
		
		UsuarioLogicAdditional.checkUsuarioToGets(usuarios,this.datosCliente,this.arrDatoGeneral);
		
		for (Usuario usuarioLocal: usuarios ) {
			UsuarioLogicAdditional.updateUsuarioToGet(usuarioLocal,this.arrDatoGeneral);
		}
		
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> newUsuarios) {
		this.usuarios = newUsuarios;
	}
	
	public Object getUsuarioObject() {	
		this.usuarioObject=this.usuarioDataAccess.getEntityObject();
		return this.usuarioObject;
	}
		
	public void setUsuarioObject(Object newUsuarioObject) {
		this.usuarioObject = newUsuarioObject;
	}
	
	public List<Object> getUsuariosObject() {		
		this.usuariosObject=this.usuarioDataAccess.getEntitiesObject();
		return this.usuariosObject;
	}
		
	public void setUsuariosObject(List<Object> newUsuariosObject) {
		this.usuariosObject = newUsuariosObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.usuarioDataAccess!=null) {
			this.usuarioDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			usuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			usuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		usuario = new  Usuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			usuario=usuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		usuario = new  Usuario();
		  		  
        try {
			
			usuario=usuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		usuario = new  Usuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			usuario=usuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		usuario = new  Usuario();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		usuario = new  Usuario();
		  		  
        try {
			
			usuario=usuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		usuario = new  Usuario();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuario = new  Usuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =usuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuario = new  Usuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=usuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuario = new  Usuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =usuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuario = new  Usuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=usuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuario = new  Usuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =usuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuario = new  Usuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=usuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		usuario = new  Usuario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuario=usuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuario(usuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		usuario = new  Usuario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuario=usuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuario(usuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarios = new  ArrayList<Usuario>();
		  		  
        try {
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUsuariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		usuarios = new  ArrayList<Usuario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getTodosUsuariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosUsuarios(String sFinalQuery,Pagination pagination)throws Exception {
		usuarios = new  ArrayList<Usuario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUsuario(usuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUsuario(Usuario usuario) throws Exception {
		Boolean estaValidado=false;
		
		if(usuario.getIsNew() || usuario.getIsChanged()) { 
			this.invalidValues = usuarioValidator.getInvalidValues(usuario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(usuario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUsuario(List<Usuario> Usuarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Usuario usuarioLocal:usuarios) {				
			estaValidadoObjeto=this.validarGuardarUsuario(usuarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUsuario(List<Usuario> Usuarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUsuario(usuarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUsuario(Usuario Usuario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUsuario(usuario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Usuario usuario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+usuario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UsuarioConstantesFunciones.getUsuarioLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"usuario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUsuarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-saveUsuarioWithConnection");connexion.begin();			
			
			UsuarioLogicAdditional.checkUsuarioToSave(this.usuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UsuarioLogicAdditional.updateUsuarioToSave(this.usuario,this.arrDatoGeneral);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.usuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUsuario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUsuario(this.usuario)) {
				UsuarioDataAccess.save(this.usuario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UsuarioLogicAdditional.checkUsuarioToSaveAfter(this.usuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUsuario();
			
			connexion.commit();			
			
			if(this.usuario.getIsDeleted()) {
				this.usuario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUsuario()throws Exception {	
		try {	
			
			UsuarioLogicAdditional.checkUsuarioToSave(this.usuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UsuarioLogicAdditional.updateUsuarioToSave(this.usuario,this.arrDatoGeneral);
			
			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.usuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUsuario(this.usuario)) {			
				UsuarioDataAccess.save(this.usuario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UsuarioLogicAdditional.checkUsuarioToSaveAfter(this.usuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.usuario.getIsDeleted()) {
				this.usuario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUsuariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-saveUsuariosWithConnection");connexion.begin();			
			
			UsuarioLogicAdditional.checkUsuarioToSaves(usuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUsuarios();
			
			Boolean validadoTodosUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Usuario usuarioLocal:usuarios) {		
				if(usuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UsuarioLogicAdditional.updateUsuarioToSave(usuarioLocal,this.arrDatoGeneral);
	        	
				UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),usuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUsuario(usuarioLocal)) {
					UsuarioDataAccess.save(usuarioLocal, connexion);				
				} else {
					validadoTodosUsuario=false;
				}
			}
			
			if(!validadoTodosUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UsuarioLogicAdditional.checkUsuarioToSavesAfter(usuarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUsuarios();
			
			connexion.commit();		
			
			this.quitarUsuariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUsuarios()throws Exception {				
		 try {	
			UsuarioLogicAdditional.checkUsuarioToSaves(usuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Usuario usuarioLocal:usuarios) {				
				if(usuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UsuarioLogicAdditional.updateUsuarioToSave(usuarioLocal,this.arrDatoGeneral);
	        	
				UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),usuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUsuario(usuarioLocal)) {				
					UsuarioDataAccess.save(usuarioLocal, connexion);				
				} else {
					validadoTodosUsuario=false;
				}
			}
			
			if(!validadoTodosUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UsuarioLogicAdditional.checkUsuarioToSavesAfter(usuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUsuariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UsuarioParameterReturnGeneral procesarAccionUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Usuario> usuarios,UsuarioParameterReturnGeneral usuarioParameterGeneral)throws Exception {
		 try {	
			UsuarioParameterReturnGeneral usuarioReturnGeneral=new UsuarioParameterReturnGeneral();
	
			UsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,usuarios,usuarioParameterGeneral,usuarioReturnGeneral);
			
			return usuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UsuarioParameterReturnGeneral procesarAccionUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Usuario> usuarios,UsuarioParameterReturnGeneral usuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-procesarAccionUsuariosWithConnection");connexion.begin();			
			
			UsuarioParameterReturnGeneral usuarioReturnGeneral=new UsuarioParameterReturnGeneral();
	
			UsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,usuarios,usuarioParameterGeneral,usuarioReturnGeneral);
			
			this.connexion.commit();
			
			return usuarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UsuarioParameterReturnGeneral procesarEventosUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Usuario> usuarios,Usuario usuario,UsuarioParameterReturnGeneral usuarioParameterGeneral,Boolean isEsNuevoUsuario,ArrayList<Classe> clases)throws Exception {
		 try {	
			UsuarioParameterReturnGeneral usuarioReturnGeneral=new UsuarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				usuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,usuarios,usuario,usuarioParameterGeneral,usuarioReturnGeneral,isEsNuevoUsuario,clases);
			
			return usuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UsuarioParameterReturnGeneral procesarEventosUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Usuario> usuarios,Usuario usuario,UsuarioParameterReturnGeneral usuarioParameterGeneral,Boolean isEsNuevoUsuario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-procesarEventosUsuariosWithConnection");connexion.begin();			
			
			UsuarioParameterReturnGeneral usuarioReturnGeneral=new UsuarioParameterReturnGeneral();
	
			usuarioReturnGeneral.setUsuario(usuario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				usuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,usuarios,usuario,usuarioParameterGeneral,usuarioReturnGeneral,isEsNuevoUsuario,clases);
			
			this.connexion.commit();
			
			return usuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UsuarioParameterReturnGeneral procesarImportacionUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UsuarioParameterReturnGeneral usuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-procesarImportacionUsuariosWithConnection");connexion.begin();			
			
			UsuarioParameterReturnGeneral usuarioReturnGeneral=new UsuarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.usuarios=new ArrayList<Usuario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.usuario=new Usuario();
				
				
				if(conColumnasBase) {this.usuario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.usuario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.usuario.setuser_name(arrColumnas[iColumn++]);
			this.usuario.setclave(arrColumnas[iColumn++]);
			this.usuario.setconfirmar_clave(arrColumnas[iColumn++]);
				this.usuario.setnombre(arrColumnas[iColumn++]);
				this.usuario.setcodigo_alterno(arrColumnas[iColumn++]);
				this.usuario.settipo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.usuario.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.usuarios.add(this.usuario);
			}
			
			this.saveUsuarios();
			
			this.connexion.commit();
			
			usuarioReturnGeneral.setConRetornoEstaProcesado(true);
			usuarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return usuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUsuariosEliminados() throws Exception {				
		
		List<Usuario> usuariosAux= new ArrayList<Usuario>();
		
		for(Usuario usuario:usuarios) {
			if(!usuario.getIsDeleted()) {
				usuariosAux.add(usuario);
			}
		}
		
		usuarios=usuariosAux;
	}
	
	public void quitarUsuariosNulos() throws Exception {				
		
		List<Usuario> usuariosAux= new ArrayList<Usuario>();
		
		for(Usuario usuario : this.usuarios) {
			if(usuario==null) {
				usuariosAux.add(usuario);
			}
		}
		
		//this.usuarios=usuariosAux;
		
		this.usuarios.removeAll(usuariosAux);
	}
	
	public void getSetVersionRowUsuarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(usuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((usuario.getIsDeleted() || (usuario.getIsChanged()&&!usuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=usuarioDataAccess.getSetVersionRowUsuario(connexion,usuario.getId());
				
				if(!usuario.getVersionRow().equals(timestamp)) {	
					usuario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				usuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUsuario()throws Exception {	
		
		if(usuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((usuario.getIsDeleted() || (usuario.getIsChanged()&&!usuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=usuarioDataAccess.getSetVersionRowUsuario(connexion,usuario.getId());
			
			try {							
				if(!usuario.getVersionRow().equals(timestamp)) {	
					usuario.setVersionRow(timestamp);
				}
				
				usuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUsuariosWithConnection()throws Exception {	
		if(usuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Usuario usuarioAux:usuarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(usuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(usuarioAux.getIsDeleted() || (usuarioAux.getIsChanged()&&!usuarioAux.getIsNew())) {
						
						timestamp=usuarioDataAccess.getSetVersionRowUsuario(connexion,usuarioAux.getId());
						
						if(!usuario.getVersionRow().equals(timestamp)) {	
							usuarioAux.setVersionRow(timestamp);
						}
								
						usuarioAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUsuarios()throws Exception {	
		if(usuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Usuario usuarioAux:usuarios) {
					if(usuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(usuarioAux.getIsDeleted() || (usuarioAux.getIsChanged()&&!usuarioAux.getIsNew())) {
						
						timestamp=usuarioDataAccess.getSetVersionRowUsuario(connexion,usuarioAux.getId());
						
						if(!usuarioAux.getVersionRow().equals(timestamp)) {	
							usuarioAux.setVersionRow(timestamp);
						}
						
													
						usuarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UsuarioParameterReturnGeneral cargarCombosLoteForeignKeyUsuarioWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		UsuarioParameterReturnGeneral  usuarioReturnGeneral =new UsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-cargarCombosLoteForeignKeyUsuarioWithConnection");connexion.begin();
			
			usuarioReturnGeneral =new UsuarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			usuarioReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return usuarioReturnGeneral;
	}
	
	public UsuarioParameterReturnGeneral cargarCombosLoteForeignKeyUsuario(String finalQueryGlobalEmpresa) throws Exception {
		UsuarioParameterReturnGeneral  usuarioReturnGeneral =new UsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			usuarioReturnGeneral =new UsuarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			usuarioReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return usuarioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyUsuarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DepositoBancoLogic depositobancoLogic=new DepositoBancoLogic();
			HistorialCambioClaveLogic historialcambioclaveLogic=new HistorialCambioClaveLogic();
			AutoriRetencionLogic autoriretencionLogic=new AutoriRetencionLogic();
			CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic=new DetalleLiquidacionImporLogic();
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			DescuentoTipoPrecioLogic descuentotipoprecioLogic=new DescuentoTipoPrecioLogic();
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
			GastoEmpleadoLogic gastoempleadoLogic=new GastoEmpleadoLogic();
			SecuencialUsuarioLogic secuencialusuarioLogic=new SecuencialUsuarioLogic();
			MovimientoActivoFijoLogic movimientoactivofijoLogic=new MovimientoActivoFijoLogic();
			UsuarioOpcionLogic usuarioopcionLogic=new UsuarioOpcionLogic();
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			NovedadLogic novedadLogic=new NovedadLogic();
			ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic=new ParametroGeneralUsuarioLogic();
			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic=new AutoriPagoOrdenCompraLogic();
			CierreCajaLogic cierrecajaLogic=new CierreCajaLogic();
			DescuentoMontoLogic descuentomontoLogic=new DescuentoMontoLogic();
			CajaEgresoLogic cajaegresoLogic=new CajaEgresoLogic();
			RequisicionCompraLogic requisicioncompraLogic=new RequisicionCompraLogic();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
			PlaneacionCompraLogic planeacioncompraLogic=new PlaneacionCompraLogic();
			PedidoCompraLogic pedidocompraLogic=new PedidoCompraLogic();
			PerfilUsuarioLogic perfilusuarioLogic=new PerfilUsuarioLogic();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			TransferenciaLogic transferenciaLogic=new TransferenciaLogic();
			DatoGeneralUsuarioLogic datogeneralusuarioLogic=new DatoGeneralUsuarioLogic();
			CajaIngresoLogic cajaingresoLogic=new CajaIngresoLogic();
			ClienteCoaLogic clientecoaLogic=new ClienteCoaLogic();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic=new DetalleMensajeCorreoInvenLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyUsuarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DepositoBanco.class));
			classes.add(new Classe(HistorialCambioClave.class));
			classes.add(new Classe(AutoriRetencion.class));
			classes.add(new Classe(CajeroTurno.class));
			classes.add(new Classe(DetalleLiquidacionImpor.class));
			classes.add(new Classe(NotaCreditoSoli.class));
			classes.add(new Classe(PedidoExpor.class));
			classes.add(new Classe(DescuentoTipoPrecio.class));
			classes.add(new Classe(GuiaRemision.class));
			classes.add(new Classe(PedidoPuntoVenta.class));
			classes.add(new Classe(GastoEmpleado.class));
			classes.add(new Classe(SecuencialUsuario.class));
			classes.add(new Classe(MovimientoActivoFijo.class));
			classes.add(new Classe(UsuarioOpcion.class));
			classes.add(new Classe(PedidoCompraImpor.class));
			classes.add(new Classe(OrdenCompra.class));
			classes.add(new Classe(TurnoPunVen.class));
			classes.add(new Classe(Novedad.class));
			classes.add(new Classe(ParametroGeneralUsuario.class));
			classes.add(new Classe(AutoriPagoOrdenCompra.class));
			classes.add(new Classe(CierreCaja.class));
			classes.add(new Classe(DescuentoMonto.class));
			classes.add(new Classe(CajaEgreso.class));
			classes.add(new Classe(RequisicionCompra.class));
			classes.add(new Classe(NotaCreditoPuntoVenta.class));
			classes.add(new Classe(PlaneacionCompra.class));
			classes.add(new Classe(PedidoCompra.class));
			classes.add(new Classe(PerfilUsuario.class));
			classes.add(new Classe(Consignatario.class));
			classes.add(new Classe(Transferencia.class));
			classes.add(new Classe(DatoGeneralUsuario.class));
			classes.add(new Classe(CajaIngreso.class));
			classes.add(new Classe(ClienteCoa.class));
			classes.add(new Classe(Consignacion.class));
			classes.add(new Classe(DetalleMensajeCorreoInven.class));
											
			

			depositobancoLogic.setConnexion(this.getConnexion());
			depositobancoLogic.setDatosCliente(this.datosCliente);
			depositobancoLogic.setIsConRefrescarForeignKeys(true);

			historialcambioclaveLogic.setConnexion(this.getConnexion());
			historialcambioclaveLogic.setDatosCliente(this.datosCliente);
			historialcambioclaveLogic.setIsConRefrescarForeignKeys(true);

			autoriretencionLogic.setConnexion(this.getConnexion());
			autoriretencionLogic.setDatosCliente(this.datosCliente);
			autoriretencionLogic.setIsConRefrescarForeignKeys(true);

			cajeroturnoLogic.setConnexion(this.getConnexion());
			cajeroturnoLogic.setDatosCliente(this.datosCliente);
			cajeroturnoLogic.setIsConRefrescarForeignKeys(true);

			detalleliquidacionimporLogic.setConnexion(this.getConnexion());
			detalleliquidacionimporLogic.setDatosCliente(this.datosCliente);
			detalleliquidacionimporLogic.setIsConRefrescarForeignKeys(true);

			notacreditosoliLogic.setConnexion(this.getConnexion());
			notacreditosoliLogic.setDatosCliente(this.datosCliente);
			notacreditosoliLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);

			descuentotipoprecioLogic.setConnexion(this.getConnexion());
			descuentotipoprecioLogic.setDatosCliente(this.datosCliente);
			descuentotipoprecioLogic.setIsConRefrescarForeignKeys(true);

			guiaremisionLogic.setConnexion(this.getConnexion());
			guiaremisionLogic.setDatosCliente(this.datosCliente);
			guiaremisionLogic.setIsConRefrescarForeignKeys(true);

			pedidopuntoventaLogic.setConnexion(this.getConnexion());
			pedidopuntoventaLogic.setDatosCliente(this.datosCliente);
			pedidopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			gastoempleadoLogic.setConnexion(this.getConnexion());
			gastoempleadoLogic.setDatosCliente(this.datosCliente);
			gastoempleadoLogic.setIsConRefrescarForeignKeys(true);

			secuencialusuarioLogic.setConnexion(this.getConnexion());
			secuencialusuarioLogic.setDatosCliente(this.datosCliente);
			secuencialusuarioLogic.setIsConRefrescarForeignKeys(true);

			movimientoactivofijoLogic.setConnexion(this.getConnexion());
			movimientoactivofijoLogic.setDatosCliente(this.datosCliente);
			movimientoactivofijoLogic.setIsConRefrescarForeignKeys(true);

			usuarioopcionLogic.setConnexion(this.getConnexion());
			usuarioopcionLogic.setDatosCliente(this.datosCliente);
			usuarioopcionLogic.setIsConRefrescarForeignKeys(true);

			pedidocompraimporLogic.setConnexion(this.getConnexion());
			pedidocompraimporLogic.setDatosCliente(this.datosCliente);
			pedidocompraimporLogic.setIsConRefrescarForeignKeys(true);

			ordencompraLogic.setConnexion(this.getConnexion());
			ordencompraLogic.setDatosCliente(this.datosCliente);
			ordencompraLogic.setIsConRefrescarForeignKeys(true);

			turnopunvenLogic.setConnexion(this.getConnexion());
			turnopunvenLogic.setDatosCliente(this.datosCliente);
			turnopunvenLogic.setIsConRefrescarForeignKeys(true);

			novedadLogic.setConnexion(this.getConnexion());
			novedadLogic.setDatosCliente(this.datosCliente);
			novedadLogic.setIsConRefrescarForeignKeys(true);

			parametrogeneralusuarioLogic.setConnexion(this.getConnexion());
			parametrogeneralusuarioLogic.setDatosCliente(this.datosCliente);
			parametrogeneralusuarioLogic.setIsConRefrescarForeignKeys(true);

			autoripagoordencompraLogic.setConnexion(this.getConnexion());
			autoripagoordencompraLogic.setDatosCliente(this.datosCliente);
			autoripagoordencompraLogic.setIsConRefrescarForeignKeys(true);

			cierrecajaLogic.setConnexion(this.getConnexion());
			cierrecajaLogic.setDatosCliente(this.datosCliente);
			cierrecajaLogic.setIsConRefrescarForeignKeys(true);

			descuentomontoLogic.setConnexion(this.getConnexion());
			descuentomontoLogic.setDatosCliente(this.datosCliente);
			descuentomontoLogic.setIsConRefrescarForeignKeys(true);

			cajaegresoLogic.setConnexion(this.getConnexion());
			cajaegresoLogic.setDatosCliente(this.datosCliente);
			cajaegresoLogic.setIsConRefrescarForeignKeys(true);

			requisicioncompraLogic.setConnexion(this.getConnexion());
			requisicioncompraLogic.setDatosCliente(this.datosCliente);
			requisicioncompraLogic.setIsConRefrescarForeignKeys(true);

			notacreditopuntoventaLogic.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			notacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			planeacioncompraLogic.setConnexion(this.getConnexion());
			planeacioncompraLogic.setDatosCliente(this.datosCliente);
			planeacioncompraLogic.setIsConRefrescarForeignKeys(true);

			pedidocompraLogic.setConnexion(this.getConnexion());
			pedidocompraLogic.setDatosCliente(this.datosCliente);
			pedidocompraLogic.setIsConRefrescarForeignKeys(true);

			perfilusuarioLogic.setConnexion(this.getConnexion());
			perfilusuarioLogic.setDatosCliente(this.datosCliente);
			perfilusuarioLogic.setIsConRefrescarForeignKeys(true);

			consignatarioLogic.setConnexion(this.getConnexion());
			consignatarioLogic.setDatosCliente(this.datosCliente);
			consignatarioLogic.setIsConRefrescarForeignKeys(true);

			transferenciaLogic.setConnexion(this.getConnexion());
			transferenciaLogic.setDatosCliente(this.datosCliente);
			transferenciaLogic.setIsConRefrescarForeignKeys(true);

			datogeneralusuarioLogic.setConnexion(this.getConnexion());
			datogeneralusuarioLogic.setDatosCliente(this.datosCliente);
			datogeneralusuarioLogic.setIsConRefrescarForeignKeys(true);

			cajaingresoLogic.setConnexion(this.getConnexion());
			cajaingresoLogic.setDatosCliente(this.datosCliente);
			cajaingresoLogic.setIsConRefrescarForeignKeys(true);

			clientecoaLogic.setConnexion(this.getConnexion());
			clientecoaLogic.setDatosCliente(this.datosCliente);
			clientecoaLogic.setIsConRefrescarForeignKeys(true);

			consignacionLogic.setConnexion(this.getConnexion());
			consignacionLogic.setDatosCliente(this.datosCliente);
			consignacionLogic.setIsConRefrescarForeignKeys(true);

			detallemensajecorreoinvenLogic.setConnexion(this.getConnexion());
			detallemensajecorreoinvenLogic.setDatosCliente(this.datosCliente);
			detallemensajecorreoinvenLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Usuario usuario:this.usuarios) {
				

				classes=new ArrayList<Classe>();
				classes=DepositoBancoConstantesFunciones.getClassesForeignKeysOfDepositoBanco(new ArrayList<Classe>(),DeepLoadType.NONE);

				depositobancoLogic.setDepositoBancos(usuario.depositobancos);
				depositobancoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=HistorialCambioClaveConstantesFunciones.getClassesForeignKeysOfHistorialCambioClave(new ArrayList<Classe>(),DeepLoadType.NONE);

				historialcambioclaveLogic.setHistorialCambioClaves(usuario.historialcambioclaves);
				historialcambioclaveLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriRetencionConstantesFunciones.getClassesForeignKeysOfAutoriRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoriretencionLogic.setAutoriRetencions(usuario.autoriretencions);
				autoriretencionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajeroturnoLogic.setCajeroTurnos(usuario.cajeroturnos);
				cajeroturnoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleliquidacionimporLogic.setDetalleLiquidacionImpors(usuario.detalleliquidacionimpors);
				detalleliquidacionimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditosoliLogic.setNotaCreditoSolis(usuario.notacreditosolis);
				notacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(usuario.pedidoexpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DescuentoTipoPrecioConstantesFunciones.getClassesForeignKeysOfDescuentoTipoPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);

				descuentotipoprecioLogic.setDescuentoTipoPrecios(usuario.descuentotipoprecios);
				descuentotipoprecioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);

				guiaremisionLogic.setGuiaRemisions(usuario.guiaremisions);
				guiaremisionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidopuntoventaLogic.setPedidoPuntoVentas(usuario.pedidopuntoventas);
				pedidopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				gastoempleadoLogic.setGastoEmpleados(usuario.gastoempleados);
				gastoempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SecuencialUsuarioConstantesFunciones.getClassesForeignKeysOfSecuencialUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);

				secuencialusuarioLogic.setSecuencialUsuarios(usuario.secuencialusuarios);
				secuencialusuarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MovimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMovimientoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				movimientoactivofijoLogic.setMovimientoActivoFijos(usuario.movimientoactivofijos);
				movimientoactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				usuarioopcionLogic.setUsuarioOpcions(usuario.usuarioopcions);
				usuarioopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidocompraimporLogic.setPedidoCompraImpors(usuario.pedidocompraimpors);
				pedidocompraimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=OrdenCompraConstantesFunciones.getClassesForeignKeysOfOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				ordencompraLogic.setOrdenCompras(usuario.ordencompras);
				ordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TurnoPunVenConstantesFunciones.getClassesForeignKeysOfTurnoPunVen(new ArrayList<Classe>(),DeepLoadType.NONE);

				turnopunvenLogic.setTurnoPunVens(usuario.turnopunvens);
				turnopunvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NovedadConstantesFunciones.getClassesForeignKeysOfNovedad(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadLogic.setNovedads(usuario.novedads);
				novedadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroGeneralUsuarioConstantesFunciones.getClassesForeignKeysOfParametroGeneralUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrogeneralusuarioLogic.setParametroGeneralUsuario(usuario.parametrogeneralusuario);
				parametrogeneralusuarioLogic.deepLoad(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriPagoOrdenCompraConstantesFunciones.getClassesForeignKeysOfAutoriPagoOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoripagoordencompraLogic.setAutoriPagoOrdenCompras(usuario.autoripagoordencompras);
				autoripagoordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CierreCajaConstantesFunciones.getClassesForeignKeysOfCierreCaja(new ArrayList<Classe>(),DeepLoadType.NONE);

				cierrecajaLogic.setCierreCajas(usuario.cierrecajas);
				cierrecajaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DescuentoMontoConstantesFunciones.getClassesForeignKeysOfDescuentoMonto(new ArrayList<Classe>(),DeepLoadType.NONE);

				descuentomontoLogic.setDescuentoMontos(usuario.descuentomontos);
				descuentomontoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaegresoLogic.setCajaEgresos(usuario.cajaegresos);
				cajaegresoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RequisicionCompraConstantesFunciones.getClassesForeignKeysOfRequisicionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				requisicioncompraLogic.setRequisicionCompras(usuario.requisicioncompras);
				requisicioncompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(usuario.notacreditopuntoventas);
				notacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PlaneacionCompraConstantesFunciones.getClassesForeignKeysOfPlaneacionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				planeacioncompraLogic.setPlaneacionCompras(usuario.planeacioncompras);
				planeacioncompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoCompraConstantesFunciones.getClassesForeignKeysOfPedidoCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidocompraLogic.setPedidoCompras(usuario.pedidocompras);
				pedidocompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PerfilUsuarioConstantesFunciones.getClassesForeignKeysOfPerfilUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilusuarioLogic.setPerfilUsuarios(usuario.perfilusuarios);
				perfilusuarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignatarioConstantesFunciones.getClassesForeignKeysOfConsignatario(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignatarioLogic.setConsignatarios(usuario.consignatarios);
				consignatarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TransferenciaConstantesFunciones.getClassesForeignKeysOfTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				transferenciaLogic.setTransferencias(usuario.transferencias);
				transferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DatoGeneralUsuarioConstantesFunciones.getClassesForeignKeysOfDatoGeneralUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralusuarioLogic.setDatoGeneralUsuario(usuario.datogeneralusuario);
				datogeneralusuarioLogic.deepLoad(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaingresoLogic.setCajaIngresos(usuario.cajaingresos);
				cajaingresoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteCoaConstantesFunciones.getClassesForeignKeysOfClienteCoa(new ArrayList<Classe>(),DeepLoadType.NONE);

				clientecoaLogic.setClienteCoas(usuario.clientecoas);
				clientecoaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignacionLogic.setConsignacions(usuario.consignacions);
				consignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfDetalleMensajeCorreoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemensajecorreoinvenLogic.setDetalleMensajeCorreoInvens(usuario.detallemensajecorreoinvens);
				detallemensajecorreoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(Usuario usuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UsuarioLogicAdditional.updateUsuarioToGet(usuario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		usuario.setEmpresa(usuarioDataAccess.getEmpresa(connexion,usuario));
		usuario.setDepositoBancos(usuarioDataAccess.getDepositoBancos(connexion,usuario));
		usuario.setHistorialCambioClaves(usuarioDataAccess.getHistorialCambioClaves(connexion,usuario));
		usuario.setAutoriRetencions(usuarioDataAccess.getAutoriRetencions(connexion,usuario));
		usuario.setCajeroTurnos(usuarioDataAccess.getCajeroTurnos(connexion,usuario));
		usuario.setDetalleLiquidacionImpors(usuarioDataAccess.getDetalleLiquidacionImpors(connexion,usuario));
		usuario.setNotaCreditoSolis(usuarioDataAccess.getNotaCreditoSolis(connexion,usuario));
		usuario.setPedidoExpors(usuarioDataAccess.getPedidoExpors(connexion,usuario));
		usuario.setDescuentoTipoPrecios(usuarioDataAccess.getDescuentoTipoPrecios(connexion,usuario));
		usuario.setGuiaRemisions(usuarioDataAccess.getGuiaRemisions(connexion,usuario));
		usuario.setPedidoPuntoVentas(usuarioDataAccess.getPedidoPuntoVentas(connexion,usuario));
		usuario.setGastoEmpleados(usuarioDataAccess.getGastoEmpleados(connexion,usuario));
		usuario.setSecuencialUsuarios(usuarioDataAccess.getSecuencialUsuarios(connexion,usuario));
		usuario.setMovimientoActivoFijos(usuarioDataAccess.getMovimientoActivoFijos(connexion,usuario));
		usuario.setUsuarioOpcions(usuarioDataAccess.getUsuarioOpcions(connexion,usuario));
		usuario.setPedidoCompraImpors(usuarioDataAccess.getPedidoCompraImpors(connexion,usuario));
		usuario.setOrdenCompras(usuarioDataAccess.getOrdenCompras(connexion,usuario));
		usuario.setTurnoPunVens(usuarioDataAccess.getTurnoPunVens(connexion,usuario));
		usuario.setNovedads(usuarioDataAccess.getNovedads(connexion,usuario));
		usuario.setParametroGeneralUsuario(usuarioDataAccess.getParametroGeneralUsuario(connexion,usuario));
		usuario.setAutoriPagoOrdenCompras(usuarioDataAccess.getAutoriPagoOrdenCompras(connexion,usuario));
		usuario.setCierreCajas(usuarioDataAccess.getCierreCajas(connexion,usuario));
		usuario.setDescuentoMontos(usuarioDataAccess.getDescuentoMontos(connexion,usuario));
		usuario.setCajaEgresos(usuarioDataAccess.getCajaEgresos(connexion,usuario));
		usuario.setRequisicionCompras(usuarioDataAccess.getRequisicionCompras(connexion,usuario));
		usuario.setNotaCreditoPuntoVentas(usuarioDataAccess.getNotaCreditoPuntoVentas(connexion,usuario));
		usuario.setPlaneacionCompras(usuarioDataAccess.getPlaneacionCompras(connexion,usuario));
		usuario.setPedidoCompras(usuarioDataAccess.getPedidoCompras(connexion,usuario));
		usuario.setPerfilUsuarios(usuarioDataAccess.getPerfilUsuarios(connexion,usuario));
		usuario.setConsignatarios(usuarioDataAccess.getConsignatarios(connexion,usuario));
		usuario.setTransferencias(usuarioDataAccess.getTransferencias(connexion,usuario));
		usuario.setDatoGeneralUsuario(usuarioDataAccess.getDatoGeneralUsuario(connexion,usuario));
		usuario.setCajaIngresos(usuarioDataAccess.getCajaIngresos(connexion,usuario));
		usuario.setClienteCoas(usuarioDataAccess.getClienteCoas(connexion,usuario));
		usuario.setConsignacions(usuarioDataAccess.getConsignacions(connexion,usuario));
		usuario.setDetalleMensajeCorreoInvens(usuarioDataAccess.getDetalleMensajeCorreoInvens(connexion,usuario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				usuario.setEmpresa(usuarioDataAccess.getEmpresa(connexion,usuario));
				continue;
			}

			if(clas.clas.equals(DepositoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDepositoBancos(usuarioDataAccess.getDepositoBancos(connexion,usuario));

				if(this.isConDeep) {
					DepositoBancoLogic depositobancoLogic= new DepositoBancoLogic(this.connexion);
					depositobancoLogic.setDepositoBancos(usuario.getDepositoBancos());
					ArrayList<Classe> classesLocal=DepositoBancoConstantesFunciones.getClassesForeignKeysOfDepositoBanco(new ArrayList<Classe>(),DeepLoadType.NONE);
					depositobancoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DepositoBancoConstantesFunciones.refrescarForeignKeysDescripcionesDepositoBanco(depositobancoLogic.getDepositoBancos());
					usuario.setDepositoBancos(depositobancoLogic.getDepositoBancos());
				}

				continue;
			}

			if(clas.clas.equals(HistorialCambioClave.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setHistorialCambioClaves(usuarioDataAccess.getHistorialCambioClaves(connexion,usuario));

				if(this.isConDeep) {
					HistorialCambioClaveLogic historialcambioclaveLogic= new HistorialCambioClaveLogic(this.connexion);
					historialcambioclaveLogic.setHistorialCambioClaves(usuario.getHistorialCambioClaves());
					ArrayList<Classe> classesLocal=HistorialCambioClaveConstantesFunciones.getClassesForeignKeysOfHistorialCambioClave(new ArrayList<Classe>(),DeepLoadType.NONE);
					historialcambioclaveLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HistorialCambioClaveConstantesFunciones.refrescarForeignKeysDescripcionesHistorialCambioClave(historialcambioclaveLogic.getHistorialCambioClaves());
					usuario.setHistorialCambioClaves(historialcambioclaveLogic.getHistorialCambioClaves());
				}

				continue;
			}

			if(clas.clas.equals(AutoriRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setAutoriRetencions(usuarioDataAccess.getAutoriRetencions(connexion,usuario));

				if(this.isConDeep) {
					AutoriRetencionLogic autoriretencionLogic= new AutoriRetencionLogic(this.connexion);
					autoriretencionLogic.setAutoriRetencions(usuario.getAutoriRetencions());
					ArrayList<Classe> classesLocal=AutoriRetencionConstantesFunciones.getClassesForeignKeysOfAutoriRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoriretencionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(autoriretencionLogic.getAutoriRetencions());
					usuario.setAutoriRetencions(autoriretencionLogic.getAutoriRetencions());
				}

				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCajeroTurnos(usuarioDataAccess.getCajeroTurnos(connexion,usuario));

				if(this.isConDeep) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(this.connexion);
					cajeroturnoLogic.setCajeroTurnos(usuario.getCajeroTurnos());
					ArrayList<Classe> classesLocal=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajeroturnoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnoLogic.getCajeroTurnos());
					usuario.setCajeroTurnos(cajeroturnoLogic.getCajeroTurnos());
				}

				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDetalleLiquidacionImpors(usuarioDataAccess.getDetalleLiquidacionImpors(connexion,usuario));

				if(this.isConDeep) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(this.connexion);
					detalleliquidacionimporLogic.setDetalleLiquidacionImpors(usuario.getDetalleLiquidacionImpors());
					ArrayList<Classe> classesLocal=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleliquidacionimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(detalleliquidacionimporLogic.getDetalleLiquidacionImpors());
					usuario.setDetalleLiquidacionImpors(detalleliquidacionimporLogic.getDetalleLiquidacionImpors());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setNotaCreditoSolis(usuarioDataAccess.getNotaCreditoSolis(connexion,usuario));

				if(this.isConDeep) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(this.connexion);
					notacreditosoliLogic.setNotaCreditoSolis(usuario.getNotaCreditoSolis());
					ArrayList<Classe> classesLocal=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoliLogic.getNotaCreditoSolis());
					usuario.setNotaCreditoSolis(notacreditosoliLogic.getNotaCreditoSolis());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoExpors(usuarioDataAccess.getPedidoExpors(connexion,usuario));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(usuario.getPedidoExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					usuario.setPedidoExpors(pedidoexporLogic.getPedidoExpors());
				}

				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDescuentoTipoPrecios(usuarioDataAccess.getDescuentoTipoPrecios(connexion,usuario));

				if(this.isConDeep) {
					DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(this.connexion);
					descuentotipoprecioLogic.setDescuentoTipoPrecios(usuario.getDescuentoTipoPrecios());
					ArrayList<Classe> classesLocal=DescuentoTipoPrecioConstantesFunciones.getClassesForeignKeysOfDescuentoTipoPrecio(new ArrayList<Classe>(),DeepLoadType.NONE);
					descuentotipoprecioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(descuentotipoprecioLogic.getDescuentoTipoPrecios());
					usuario.setDescuentoTipoPrecios(descuentotipoprecioLogic.getDescuentoTipoPrecios());
				}

				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setGuiaRemisions(usuarioDataAccess.getGuiaRemisions(connexion,usuario));

				if(this.isConDeep) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(this.connexion);
					guiaremisionLogic.setGuiaRemisions(usuario.getGuiaRemisions());
					ArrayList<Classe> classesLocal=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);
					guiaremisionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremisionLogic.getGuiaRemisions());
					usuario.setGuiaRemisions(guiaremisionLogic.getGuiaRemisions());
				}

				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoPuntoVentas(usuarioDataAccess.getPedidoPuntoVentas(connexion,usuario));

				if(this.isConDeep) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(this.connexion);
					pedidopuntoventaLogic.setPedidoPuntoVentas(usuario.getPedidoPuntoVentas());
					ArrayList<Classe> classesLocal=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventaLogic.getPedidoPuntoVentas());
					usuario.setPedidoPuntoVentas(pedidopuntoventaLogic.getPedidoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setGastoEmpleados(usuarioDataAccess.getGastoEmpleados(connexion,usuario));

				if(this.isConDeep) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(this.connexion);
					gastoempleadoLogic.setGastoEmpleados(usuario.getGastoEmpleados());
					ArrayList<Classe> classesLocal=GastoEmpleadoConstantesFunciones.getClassesForeignKeysOfGastoEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					gastoempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GastoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesGastoEmpleado(gastoempleadoLogic.getGastoEmpleados());
					usuario.setGastoEmpleados(gastoempleadoLogic.getGastoEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(SecuencialUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setSecuencialUsuarios(usuarioDataAccess.getSecuencialUsuarios(connexion,usuario));

				if(this.isConDeep) {
					SecuencialUsuarioLogic secuencialusuarioLogic= new SecuencialUsuarioLogic(this.connexion);
					secuencialusuarioLogic.setSecuencialUsuarios(usuario.getSecuencialUsuarios());
					ArrayList<Classe> classesLocal=SecuencialUsuarioConstantesFunciones.getClassesForeignKeysOfSecuencialUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);
					secuencialusuarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SecuencialUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesSecuencialUsuario(secuencialusuarioLogic.getSecuencialUsuarios());
					usuario.setSecuencialUsuarios(secuencialusuarioLogic.getSecuencialUsuarios());
				}

				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setMovimientoActivoFijos(usuarioDataAccess.getMovimientoActivoFijos(connexion,usuario));

				if(this.isConDeep) {
					MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(this.connexion);
					movimientoactivofijoLogic.setMovimientoActivoFijos(usuario.getMovimientoActivoFijos());
					ArrayList<Classe> classesLocal=MovimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMovimientoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					movimientoactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(movimientoactivofijoLogic.getMovimientoActivoFijos());
					usuario.setMovimientoActivoFijos(movimientoactivofijoLogic.getMovimientoActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setUsuarioOpcions(usuarioDataAccess.getUsuarioOpcions(connexion,usuario));

				if(this.isConDeep) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(this.connexion);
					usuarioopcionLogic.setUsuarioOpcions(usuario.getUsuarioOpcions());
					ArrayList<Classe> classesLocal=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					usuarioopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcionLogic.getUsuarioOpcions());
					usuario.setUsuarioOpcions(usuarioopcionLogic.getUsuarioOpcions());
				}

				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoCompraImpors(usuarioDataAccess.getPedidoCompraImpors(connexion,usuario));

				if(this.isConDeep) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(this.connexion);
					pedidocompraimporLogic.setPedidoCompraImpors(usuario.getPedidoCompraImpors());
					ArrayList<Classe> classesLocal=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidocompraimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(pedidocompraimporLogic.getPedidoCompraImpors());
					usuario.setPedidoCompraImpors(pedidocompraimporLogic.getPedidoCompraImpors());
				}

				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setOrdenCompras(usuarioDataAccess.getOrdenCompras(connexion,usuario));

				if(this.isConDeep) {
					OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(this.connexion);
					ordencompraLogic.setOrdenCompras(usuario.getOrdenCompras());
					ArrayList<Classe> classesLocal=OrdenCompraConstantesFunciones.getClassesForeignKeysOfOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					ordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesOrdenCompra(ordencompraLogic.getOrdenCompras());
					usuario.setOrdenCompras(ordencompraLogic.getOrdenCompras());
				}

				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setTurnoPunVens(usuarioDataAccess.getTurnoPunVens(connexion,usuario));

				if(this.isConDeep) {
					TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(this.connexion);
					turnopunvenLogic.setTurnoPunVens(usuario.getTurnoPunVens());
					ArrayList<Classe> classesLocal=TurnoPunVenConstantesFunciones.getClassesForeignKeysOfTurnoPunVen(new ArrayList<Classe>(),DeepLoadType.NONE);
					turnopunvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TurnoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesTurnoPunVen(turnopunvenLogic.getTurnoPunVens());
					usuario.setTurnoPunVens(turnopunvenLogic.getTurnoPunVens());
				}

				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setNovedads(usuarioDataAccess.getNovedads(connexion,usuario));

				if(this.isConDeep) {
					NovedadLogic novedadLogic= new NovedadLogic(this.connexion);
					novedadLogic.setNovedads(usuario.getNovedads());
					ArrayList<Classe> classesLocal=NovedadConstantesFunciones.getClassesForeignKeysOfNovedad(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadConstantesFunciones.refrescarForeignKeysDescripcionesNovedad(novedadLogic.getNovedads());
					usuario.setNovedads(novedadLogic.getNovedads());
				}

				continue;
			}

			if(clas.clas.equals(ParametroGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setParametroGeneralUsuario(usuarioDataAccess.getParametroGeneralUsuario(connexion,usuario));

				if(this.isConDeep) {
					ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic= new ParametroGeneralUsuarioLogic(this.connexion);
					parametrogeneralusuarioLogic.setParametroGeneralUsuario(usuario.getParametroGeneralUsuario());
					ArrayList<Classe> classesLocal=ParametroGeneralUsuarioConstantesFunciones.getClassesForeignKeysOfParametroGeneralUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrogeneralusuarioLogic.deepLoad(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneralUsuario(parametrogeneralusuarioLogic.getParametroGeneralUsuario());
					usuario.setParametroGeneralUsuario(parametrogeneralusuarioLogic.getParametroGeneralUsuario());
				}

				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setAutoriPagoOrdenCompras(usuarioDataAccess.getAutoriPagoOrdenCompras(connexion,usuario));

				if(this.isConDeep) {
					AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(this.connexion);
					autoripagoordencompraLogic.setAutoriPagoOrdenCompras(usuario.getAutoriPagoOrdenCompras());
					ArrayList<Classe> classesLocal=AutoriPagoOrdenCompraConstantesFunciones.getClassesForeignKeysOfAutoriPagoOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoripagoordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(autoripagoordencompraLogic.getAutoriPagoOrdenCompras());
					usuario.setAutoriPagoOrdenCompras(autoripagoordencompraLogic.getAutoriPagoOrdenCompras());
				}

				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCierreCajas(usuarioDataAccess.getCierreCajas(connexion,usuario));

				if(this.isConDeep) {
					CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(this.connexion);
					cierrecajaLogic.setCierreCajas(usuario.getCierreCajas());
					ArrayList<Classe> classesLocal=CierreCajaConstantesFunciones.getClassesForeignKeysOfCierreCaja(new ArrayList<Classe>(),DeepLoadType.NONE);
					cierrecajaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesCierreCaja(cierrecajaLogic.getCierreCajas());
					usuario.setCierreCajas(cierrecajaLogic.getCierreCajas());
				}

				continue;
			}

			if(clas.clas.equals(DescuentoMonto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDescuentoMontos(usuarioDataAccess.getDescuentoMontos(connexion,usuario));

				if(this.isConDeep) {
					DescuentoMontoLogic descuentomontoLogic= new DescuentoMontoLogic(this.connexion);
					descuentomontoLogic.setDescuentoMontos(usuario.getDescuentoMontos());
					ArrayList<Classe> classesLocal=DescuentoMontoConstantesFunciones.getClassesForeignKeysOfDescuentoMonto(new ArrayList<Classe>(),DeepLoadType.NONE);
					descuentomontoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DescuentoMontoConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoMonto(descuentomontoLogic.getDescuentoMontos());
					usuario.setDescuentoMontos(descuentomontoLogic.getDescuentoMontos());
				}

				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCajaEgresos(usuarioDataAccess.getCajaEgresos(connexion,usuario));

				if(this.isConDeep) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(this.connexion);
					cajaegresoLogic.setCajaEgresos(usuario.getCajaEgresos());
					ArrayList<Classe> classesLocal=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaegresoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(cajaegresoLogic.getCajaEgresos());
					usuario.setCajaEgresos(cajaegresoLogic.getCajaEgresos());
				}

				continue;
			}

			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setRequisicionCompras(usuarioDataAccess.getRequisicionCompras(connexion,usuario));

				if(this.isConDeep) {
					RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(this.connexion);
					requisicioncompraLogic.setRequisicionCompras(usuario.getRequisicionCompras());
					ArrayList<Classe> classesLocal=RequisicionCompraConstantesFunciones.getClassesForeignKeysOfRequisicionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					requisicioncompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(requisicioncompraLogic.getRequisicionCompras());
					usuario.setRequisicionCompras(requisicioncompraLogic.getRequisicionCompras());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setNotaCreditoPuntoVentas(usuarioDataAccess.getNotaCreditoPuntoVentas(connexion,usuario));

				if(this.isConDeep) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(this.connexion);
					notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(usuario.getNotaCreditoPuntoVentas());
					ArrayList<Classe> classesLocal=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
					usuario.setNotaCreditoPuntoVentas(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPlaneacionCompras(usuarioDataAccess.getPlaneacionCompras(connexion,usuario));

				if(this.isConDeep) {
					PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(this.connexion);
					planeacioncompraLogic.setPlaneacionCompras(usuario.getPlaneacionCompras());
					ArrayList<Classe> classesLocal=PlaneacionCompraConstantesFunciones.getClassesForeignKeysOfPlaneacionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					planeacioncompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PlaneacionCompraConstantesFunciones.refrescarForeignKeysDescripcionesPlaneacionCompra(planeacioncompraLogic.getPlaneacionCompras());
					usuario.setPlaneacionCompras(planeacioncompraLogic.getPlaneacionCompras());
				}

				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoCompras(usuarioDataAccess.getPedidoCompras(connexion,usuario));

				if(this.isConDeep) {
					PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(this.connexion);
					pedidocompraLogic.setPedidoCompras(usuario.getPedidoCompras());
					ArrayList<Classe> classesLocal=PedidoCompraConstantesFunciones.getClassesForeignKeysOfPedidoCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidocompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoCompraConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompra(pedidocompraLogic.getPedidoCompras());
					usuario.setPedidoCompras(pedidocompraLogic.getPedidoCompras());
				}

				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPerfilUsuarios(usuarioDataAccess.getPerfilUsuarios(connexion,usuario));

				if(this.isConDeep) {
					PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(this.connexion);
					perfilusuarioLogic.setPerfilUsuarios(usuario.getPerfilUsuarios());
					ArrayList<Classe> classesLocal=PerfilUsuarioConstantesFunciones.getClassesForeignKeysOfPerfilUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilusuarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesPerfilUsuario(perfilusuarioLogic.getPerfilUsuarios());
					usuario.setPerfilUsuarios(perfilusuarioLogic.getPerfilUsuarios());
				}

				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setConsignatarios(usuarioDataAccess.getConsignatarios(connexion,usuario));

				if(this.isConDeep) {
					ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(this.connexion);
					consignatarioLogic.setConsignatarios(usuario.getConsignatarios());
					ArrayList<Classe> classesLocal=ConsignatarioConstantesFunciones.getClassesForeignKeysOfConsignatario(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignatarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(consignatarioLogic.getConsignatarios());
					usuario.setConsignatarios(consignatarioLogic.getConsignatarios());
				}

				continue;
			}

			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setTransferencias(usuarioDataAccess.getTransferencias(connexion,usuario));

				if(this.isConDeep) {
					TransferenciaLogic transferenciaLogic= new TransferenciaLogic(this.connexion);
					transferenciaLogic.setTransferencias(usuario.getTransferencias());
					ArrayList<Classe> classesLocal=TransferenciaConstantesFunciones.getClassesForeignKeysOfTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					transferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTransferencia(transferenciaLogic.getTransferencias());
					usuario.setTransferencias(transferenciaLogic.getTransferencias());
				}

				continue;
			}

			if(clas.clas.equals(DatoGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDatoGeneralUsuario(usuarioDataAccess.getDatoGeneralUsuario(connexion,usuario));

				if(this.isConDeep) {
					DatoGeneralUsuarioLogic datogeneralusuarioLogic= new DatoGeneralUsuarioLogic(this.connexion);
					datogeneralusuarioLogic.setDatoGeneralUsuario(usuario.getDatoGeneralUsuario());
					ArrayList<Classe> classesLocal=DatoGeneralUsuarioConstantesFunciones.getClassesForeignKeysOfDatoGeneralUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralusuarioLogic.deepLoad(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralUsuario(datogeneralusuarioLogic.getDatoGeneralUsuario());
					usuario.setDatoGeneralUsuario(datogeneralusuarioLogic.getDatoGeneralUsuario());
				}

				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCajaIngresos(usuarioDataAccess.getCajaIngresos(connexion,usuario));

				if(this.isConDeep) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(this.connexion);
					cajaingresoLogic.setCajaIngresos(usuario.getCajaIngresos());
					ArrayList<Classe> classesLocal=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaingresoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(cajaingresoLogic.getCajaIngresos());
					usuario.setCajaIngresos(cajaingresoLogic.getCajaIngresos());
				}

				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setClienteCoas(usuarioDataAccess.getClienteCoas(connexion,usuario));

				if(this.isConDeep) {
					ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(this.connexion);
					clientecoaLogic.setClienteCoas(usuario.getClienteCoas());
					ArrayList<Classe> classesLocal=ClienteCoaConstantesFunciones.getClassesForeignKeysOfClienteCoa(new ArrayList<Classe>(),DeepLoadType.NONE);
					clientecoaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(clientecoaLogic.getClienteCoas());
					usuario.setClienteCoas(clientecoaLogic.getClienteCoas());
				}

				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setConsignacions(usuarioDataAccess.getConsignacions(connexion,usuario));

				if(this.isConDeep) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(this.connexion);
					consignacionLogic.setConsignacions(usuario.getConsignacions());
					ArrayList<Classe> classesLocal=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacionLogic.getConsignacions());
					usuario.setConsignacions(consignacionLogic.getConsignacions());
				}

				continue;
			}

			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDetalleMensajeCorreoInvens(usuarioDataAccess.getDetalleMensajeCorreoInvens(connexion,usuario));

				if(this.isConDeep) {
					DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(this.connexion);
					detallemensajecorreoinvenLogic.setDetalleMensajeCorreoInvens(usuario.getDetalleMensajeCorreoInvens());
					ArrayList<Classe> classesLocal=DetalleMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfDetalleMensajeCorreoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemensajecorreoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMensajeCorreoInven(detallemensajecorreoinvenLogic.getDetalleMensajeCorreoInvens());
					usuario.setDetalleMensajeCorreoInvens(detallemensajecorreoinvenLogic.getDetalleMensajeCorreoInvens());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuario.setEmpresa(usuarioDataAccess.getEmpresa(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DepositoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DepositoBanco.class));
			usuario.setDepositoBancos(usuarioDataAccess.getDepositoBancos(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialCambioClave.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialCambioClave.class));
			usuario.setHistorialCambioClaves(usuarioDataAccess.getHistorialCambioClaves(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriRetencion.class));
			usuario.setAutoriRetencions(usuarioDataAccess.getAutoriRetencions(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			usuario.setCajeroTurnos(usuarioDataAccess.getCajeroTurnos(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpor.class));
			usuario.setDetalleLiquidacionImpors(usuarioDataAccess.getDetalleLiquidacionImpors(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			usuario.setNotaCreditoSolis(usuarioDataAccess.getNotaCreditoSolis(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			usuario.setPedidoExpors(usuarioDataAccess.getPedidoExpors(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DescuentoTipoPrecio.class));
			usuario.setDescuentoTipoPrecios(usuarioDataAccess.getDescuentoTipoPrecios(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			usuario.setGuiaRemisions(usuarioDataAccess.getGuiaRemisions(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			usuario.setPedidoPuntoVentas(usuarioDataAccess.getPedidoPuntoVentas(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoEmpleado.class));
			usuario.setGastoEmpleados(usuarioDataAccess.getGastoEmpleados(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SecuencialUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SecuencialUsuario.class));
			usuario.setSecuencialUsuarios(usuarioDataAccess.getSecuencialUsuarios(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MovimientoActivoFijo.class));
			usuario.setMovimientoActivoFijos(usuarioDataAccess.getMovimientoActivoFijos(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UsuarioOpcion.class));
			usuario.setUsuarioOpcions(usuarioDataAccess.getUsuarioOpcions(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompraImpor.class));
			usuario.setPedidoCompraImpors(usuarioDataAccess.getPedidoCompraImpors(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenCompra.class));
			usuario.setOrdenCompras(usuarioDataAccess.getOrdenCompras(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TurnoPunVen.class));
			usuario.setTurnoPunVens(usuarioDataAccess.getTurnoPunVens(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Novedad.class));
			usuario.setNovedads(usuarioDataAccess.getNovedads(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroGeneralUsuario.class));
			usuario.setParametroGeneralUsuario(usuarioDataAccess.getParametroGeneralUsuario(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPagoOrdenCompra.class));
			usuario.setAutoriPagoOrdenCompras(usuarioDataAccess.getAutoriPagoOrdenCompras(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreCaja.class));
			usuario.setCierreCajas(usuarioDataAccess.getCierreCajas(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DescuentoMonto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DescuentoMonto.class));
			usuario.setDescuentoMontos(usuarioDataAccess.getDescuentoMontos(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgreso.class));
			usuario.setCajaEgresos(usuarioDataAccess.getCajaEgresos(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RequisicionCompra.class));
			usuario.setRequisicionCompras(usuarioDataAccess.getRequisicionCompras(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			usuario.setNotaCreditoPuntoVentas(usuarioDataAccess.getNotaCreditoPuntoVentas(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PlaneacionCompra.class));
			usuario.setPlaneacionCompras(usuarioDataAccess.getPlaneacionCompras(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompra.class));
			usuario.setPedidoCompras(usuarioDataAccess.getPedidoCompras(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilUsuario.class));
			usuario.setPerfilUsuarios(usuarioDataAccess.getPerfilUsuarios(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignatario.class));
			usuario.setConsignatarios(usuarioDataAccess.getConsignatarios(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transferencia.class));
			usuario.setTransferencias(usuarioDataAccess.getTransferencias(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralUsuario.class));
			usuario.setDatoGeneralUsuario(usuarioDataAccess.getDatoGeneralUsuario(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngreso.class));
			usuario.setCajaIngresos(usuarioDataAccess.getCajaIngresos(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteCoa.class));
			usuario.setClienteCoas(usuarioDataAccess.getClienteCoas(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			usuario.setConsignacions(usuarioDataAccess.getConsignacions(connexion,usuario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMensajeCorreoInven.class));
			usuario.setDetalleMensajeCorreoInvens(usuarioDataAccess.getDetalleMensajeCorreoInvens(connexion,usuario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		usuario.setEmpresa(usuarioDataAccess.getEmpresa(connexion,usuario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(usuario.getEmpresa(),isDeep,deepLoadType,clases);
				

		usuario.setDepositoBancos(usuarioDataAccess.getDepositoBancos(connexion,usuario));

		for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
			DepositoBancoLogic depositobancoLogic= new DepositoBancoLogic(connexion);
			depositobancoLogic.deepLoad(depositobanco,isDeep,deepLoadType,clases);
		}

		usuario.setHistorialCambioClaves(usuarioDataAccess.getHistorialCambioClaves(connexion,usuario));

		for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
			HistorialCambioClaveLogic historialcambioclaveLogic= new HistorialCambioClaveLogic(connexion);
			historialcambioclaveLogic.deepLoad(historialcambioclave,isDeep,deepLoadType,clases);
		}

		usuario.setAutoriRetencions(usuarioDataAccess.getAutoriRetencions(connexion,usuario));

		for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
			AutoriRetencionLogic autoriretencionLogic= new AutoriRetencionLogic(connexion);
			autoriretencionLogic.deepLoad(autoriretencion,isDeep,deepLoadType,clases);
		}

		usuario.setCajeroTurnos(usuarioDataAccess.getCajeroTurnos(connexion,usuario));

		for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
		}

		usuario.setDetalleLiquidacionImpors(usuarioDataAccess.getDetalleLiquidacionImpors(connexion,usuario));

		for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
			detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
		}

		usuario.setNotaCreditoSolis(usuarioDataAccess.getNotaCreditoSolis(connexion,usuario));

		for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
		}

		usuario.setPedidoExpors(usuarioDataAccess.getPedidoExpors(connexion,usuario));

		for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}

		usuario.setDescuentoTipoPrecios(usuarioDataAccess.getDescuentoTipoPrecios(connexion,usuario));

		for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
			DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
			descuentotipoprecioLogic.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
		}

		usuario.setGuiaRemisions(usuarioDataAccess.getGuiaRemisions(connexion,usuario));

		for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
		}

		usuario.setPedidoPuntoVentas(usuarioDataAccess.getPedidoPuntoVentas(connexion,usuario));

		for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		usuario.setGastoEmpleados(usuarioDataAccess.getGastoEmpleados(connexion,usuario));

		for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
			GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
			gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
		}

		usuario.setSecuencialUsuarios(usuarioDataAccess.getSecuencialUsuarios(connexion,usuario));

		for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
			SecuencialUsuarioLogic secuencialusuarioLogic= new SecuencialUsuarioLogic(connexion);
			secuencialusuarioLogic.deepLoad(secuencialusuario,isDeep,deepLoadType,clases);
		}

		usuario.setMovimientoActivoFijos(usuarioDataAccess.getMovimientoActivoFijos(connexion,usuario));

		for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
			MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
			movimientoactivofijoLogic.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
		}

		usuario.setUsuarioOpcions(usuarioDataAccess.getUsuarioOpcions(connexion,usuario));

		for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
		}

		usuario.setPedidoCompraImpors(usuarioDataAccess.getPedidoCompraImpors(connexion,usuario));

		for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
		}

		usuario.setOrdenCompras(usuarioDataAccess.getOrdenCompras(connexion,usuario));

		for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(ordencompra,isDeep,deepLoadType,clases);
		}

		usuario.setTurnoPunVens(usuarioDataAccess.getTurnoPunVens(connexion,usuario));

		for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
			TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
			turnopunvenLogic.deepLoad(turnopunven,isDeep,deepLoadType,clases);
		}

		usuario.setNovedads(usuarioDataAccess.getNovedads(connexion,usuario));

		for(Novedad novedad:usuario.getNovedads()) {
			NovedadLogic novedadLogic= new NovedadLogic(connexion);
			novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
		}
					usuario.setParametroGeneralUsuario(usuarioDataAccess.getParametroGeneralUsuario(connexion,usuario));

						ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic= new ParametroGeneralUsuarioLogic(connexion);

					parametrogeneralusuarioLogic.deepLoad(usuario.getParametroGeneralUsuario(),isDeep,deepLoadType,clases);

		usuario.setAutoriPagoOrdenCompras(usuarioDataAccess.getAutoriPagoOrdenCompras(connexion,usuario));

		for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
			autoripagoordencompraLogic.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
		}

		usuario.setCierreCajas(usuarioDataAccess.getCierreCajas(connexion,usuario));

		for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
			CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
			cierrecajaLogic.deepLoad(cierrecaja,isDeep,deepLoadType,clases);
		}

		usuario.setDescuentoMontos(usuarioDataAccess.getDescuentoMontos(connexion,usuario));

		for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
			DescuentoMontoLogic descuentomontoLogic= new DescuentoMontoLogic(connexion);
			descuentomontoLogic.deepLoad(descuentomonto,isDeep,deepLoadType,clases);
		}

		usuario.setCajaEgresos(usuarioDataAccess.getCajaEgresos(connexion,usuario));

		for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
			CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
			cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
		}

		usuario.setRequisicionCompras(usuarioDataAccess.getRequisicionCompras(connexion,usuario));

		for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
			RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
			requisicioncompraLogic.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
		}

		usuario.setNotaCreditoPuntoVentas(usuarioDataAccess.getNotaCreditoPuntoVentas(connexion,usuario));

		for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		usuario.setPlaneacionCompras(usuarioDataAccess.getPlaneacionCompras(connexion,usuario));

		for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
			PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
			planeacioncompraLogic.deepLoad(planeacioncompra,isDeep,deepLoadType,clases);
		}

		usuario.setPedidoCompras(usuarioDataAccess.getPedidoCompras(connexion,usuario));

		for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
			PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
			pedidocompraLogic.deepLoad(pedidocompra,isDeep,deepLoadType,clases);
		}

		usuario.setPerfilUsuarios(usuarioDataAccess.getPerfilUsuarios(connexion,usuario));

		for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
			PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
			perfilusuarioLogic.deepLoad(perfilusuario,isDeep,deepLoadType,clases);
		}

		usuario.setConsignatarios(usuarioDataAccess.getConsignatarios(connexion,usuario));

		for(Consignatario consignatario:usuario.getConsignatarios()) {
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatarioLogic.deepLoad(consignatario,isDeep,deepLoadType,clases);
		}

		usuario.setTransferencias(usuarioDataAccess.getTransferencias(connexion,usuario));

		for(Transferencia transferencia:usuario.getTransferencias()) {
			TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
			transferenciaLogic.deepLoad(transferencia,isDeep,deepLoadType,clases);
		}
					usuario.setDatoGeneralUsuario(usuarioDataAccess.getDatoGeneralUsuario(connexion,usuario));

						DatoGeneralUsuarioLogic datogeneralusuarioLogic= new DatoGeneralUsuarioLogic(connexion);

					datogeneralusuarioLogic.deepLoad(usuario.getDatoGeneralUsuario(),isDeep,deepLoadType,clases);

		usuario.setCajaIngresos(usuarioDataAccess.getCajaIngresos(connexion,usuario));

		for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
			CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
			cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
		}

		usuario.setClienteCoas(usuarioDataAccess.getClienteCoas(connexion,usuario));

		for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
			ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
			clientecoaLogic.deepLoad(clientecoa,isDeep,deepLoadType,clases);
		}

		usuario.setConsignacions(usuarioDataAccess.getConsignacions(connexion,usuario));

		for(Consignacion consignacion:usuario.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
		}

		usuario.setDetalleMensajeCorreoInvens(usuarioDataAccess.getDetalleMensajeCorreoInvens(connexion,usuario));

		for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
			detallemensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				usuario.setEmpresa(usuarioDataAccess.getEmpresa(connexion,usuario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(usuario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DepositoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDepositoBancos(usuarioDataAccess.getDepositoBancos(connexion,usuario));

				for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
					DepositoBancoLogic depositobancoLogic= new DepositoBancoLogic(connexion);
					depositobancoLogic.deepLoad(depositobanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialCambioClave.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setHistorialCambioClaves(usuarioDataAccess.getHistorialCambioClaves(connexion,usuario));

				for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
					HistorialCambioClaveLogic historialcambioclaveLogic= new HistorialCambioClaveLogic(connexion);
					historialcambioclaveLogic.deepLoad(historialcambioclave,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setAutoriRetencions(usuarioDataAccess.getAutoriRetencions(connexion,usuario));

				for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
					AutoriRetencionLogic autoriretencionLogic= new AutoriRetencionLogic(connexion);
					autoriretencionLogic.deepLoad(autoriretencion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCajeroTurnos(usuarioDataAccess.getCajeroTurnos(connexion,usuario));

				for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDetalleLiquidacionImpors(usuarioDataAccess.getDetalleLiquidacionImpors(connexion,usuario));

				for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
					detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setNotaCreditoSolis(usuarioDataAccess.getNotaCreditoSolis(connexion,usuario));

				for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoExpors(usuarioDataAccess.getPedidoExpors(connexion,usuario));

				for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDescuentoTipoPrecios(usuarioDataAccess.getDescuentoTipoPrecios(connexion,usuario));

				for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
					DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
					descuentotipoprecioLogic.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setGuiaRemisions(usuarioDataAccess.getGuiaRemisions(connexion,usuario));

				for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoPuntoVentas(usuarioDataAccess.getPedidoPuntoVentas(connexion,usuario));

				for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setGastoEmpleados(usuarioDataAccess.getGastoEmpleados(connexion,usuario));

				for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
					gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SecuencialUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setSecuencialUsuarios(usuarioDataAccess.getSecuencialUsuarios(connexion,usuario));

				for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
					SecuencialUsuarioLogic secuencialusuarioLogic= new SecuencialUsuarioLogic(connexion);
					secuencialusuarioLogic.deepLoad(secuencialusuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setMovimientoActivoFijos(usuarioDataAccess.getMovimientoActivoFijos(connexion,usuario));

				for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
					MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
					movimientoactivofijoLogic.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setUsuarioOpcions(usuarioDataAccess.getUsuarioOpcions(connexion,usuario));

				for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoCompraImpors(usuarioDataAccess.getPedidoCompraImpors(connexion,usuario));

				for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
					pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setOrdenCompras(usuarioDataAccess.getOrdenCompras(connexion,usuario));

				for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
					OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
					ordencompraLogic.deepLoad(ordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setTurnoPunVens(usuarioDataAccess.getTurnoPunVens(connexion,usuario));

				for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
					TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
					turnopunvenLogic.deepLoad(turnopunven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setNovedads(usuarioDataAccess.getNovedads(connexion,usuario));

				for(Novedad novedad:usuario.getNovedads()) {
					NovedadLogic novedadLogic= new NovedadLogic(connexion);
					novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setParametroGeneralUsuario(usuarioDataAccess.getParametroGeneralUsuario(connexion,usuario));

				ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic= new ParametroGeneralUsuarioLogic(connexion);

				parametrogeneralusuarioLogic.deepLoad(usuario.getParametroGeneralUsuario(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setAutoriPagoOrdenCompras(usuarioDataAccess.getAutoriPagoOrdenCompras(connexion,usuario));

				for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
					AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
					autoripagoordencompraLogic.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCierreCajas(usuarioDataAccess.getCierreCajas(connexion,usuario));

				for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
					CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
					cierrecajaLogic.deepLoad(cierrecaja,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoMonto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDescuentoMontos(usuarioDataAccess.getDescuentoMontos(connexion,usuario));

				for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
					DescuentoMontoLogic descuentomontoLogic= new DescuentoMontoLogic(connexion);
					descuentomontoLogic.deepLoad(descuentomonto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCajaEgresos(usuarioDataAccess.getCajaEgresos(connexion,usuario));

				for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
					cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setRequisicionCompras(usuarioDataAccess.getRequisicionCompras(connexion,usuario));

				for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
					RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
					requisicioncompraLogic.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setNotaCreditoPuntoVentas(usuarioDataAccess.getNotaCreditoPuntoVentas(connexion,usuario));

				for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPlaneacionCompras(usuarioDataAccess.getPlaneacionCompras(connexion,usuario));

				for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
					PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
					planeacioncompraLogic.deepLoad(planeacioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPedidoCompras(usuarioDataAccess.getPedidoCompras(connexion,usuario));

				for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
					PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
					pedidocompraLogic.deepLoad(pedidocompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setPerfilUsuarios(usuarioDataAccess.getPerfilUsuarios(connexion,usuario));

				for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
					PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
					perfilusuarioLogic.deepLoad(perfilusuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setConsignatarios(usuarioDataAccess.getConsignatarios(connexion,usuario));

				for(Consignatario consignatario:usuario.getConsignatarios()) {
					ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
					consignatarioLogic.deepLoad(consignatario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setTransferencias(usuarioDataAccess.getTransferencias(connexion,usuario));

				for(Transferencia transferencia:usuario.getTransferencias()) {
					TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
					transferenciaLogic.deepLoad(transferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDatoGeneralUsuario(usuarioDataAccess.getDatoGeneralUsuario(connexion,usuario));

				DatoGeneralUsuarioLogic datogeneralusuarioLogic= new DatoGeneralUsuarioLogic(connexion);

				datogeneralusuarioLogic.deepLoad(usuario.getDatoGeneralUsuario(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setCajaIngresos(usuarioDataAccess.getCajaIngresos(connexion,usuario));

				for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
					cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setClienteCoas(usuarioDataAccess.getClienteCoas(connexion,usuario));

				for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
					ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
					clientecoaLogic.deepLoad(clientecoa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setConsignacions(usuarioDataAccess.getConsignacions(connexion,usuario));

				for(Consignacion consignacion:usuario.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				usuario.setDetalleMensajeCorreoInvens(usuarioDataAccess.getDetalleMensajeCorreoInvens(connexion,usuario));

				for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
					DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
					detallemensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuario.setEmpresa(usuarioDataAccess.getEmpresa(connexion,usuario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(usuario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DepositoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DepositoBanco.class));
			usuario.setDepositoBancos(usuarioDataAccess.getDepositoBancos(connexion,usuario));

			for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
				DepositoBancoLogic depositobancoLogic= new DepositoBancoLogic(connexion);
				depositobancoLogic.deepLoad(depositobanco,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialCambioClave.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialCambioClave.class));
			usuario.setHistorialCambioClaves(usuarioDataAccess.getHistorialCambioClaves(connexion,usuario));

			for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
				HistorialCambioClaveLogic historialcambioclaveLogic= new HistorialCambioClaveLogic(connexion);
				historialcambioclaveLogic.deepLoad(historialcambioclave,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriRetencion.class));
			usuario.setAutoriRetencions(usuarioDataAccess.getAutoriRetencions(connexion,usuario));

			for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
				AutoriRetencionLogic autoriretencionLogic= new AutoriRetencionLogic(connexion);
				autoriretencionLogic.deepLoad(autoriretencion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			usuario.setCajeroTurnos(usuarioDataAccess.getCajeroTurnos(connexion,usuario));

			for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
				CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
				cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpor.class));
			usuario.setDetalleLiquidacionImpors(usuarioDataAccess.getDetalleLiquidacionImpors(connexion,usuario));

			for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
				DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
				detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			usuario.setNotaCreditoSolis(usuarioDataAccess.getNotaCreditoSolis(connexion,usuario));

			for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			usuario.setPedidoExpors(usuarioDataAccess.getPedidoExpors(connexion,usuario));

			for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DescuentoTipoPrecio.class));
			usuario.setDescuentoTipoPrecios(usuarioDataAccess.getDescuentoTipoPrecios(connexion,usuario));

			for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
				DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
				descuentotipoprecioLogic.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			usuario.setGuiaRemisions(usuarioDataAccess.getGuiaRemisions(connexion,usuario));

			for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			usuario.setPedidoPuntoVentas(usuarioDataAccess.getPedidoPuntoVentas(connexion,usuario));

			for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoEmpleado.class));
			usuario.setGastoEmpleados(usuarioDataAccess.getGastoEmpleados(connexion,usuario));

			for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
				GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
				gastoempleadoLogic.deepLoad(gastoempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SecuencialUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SecuencialUsuario.class));
			usuario.setSecuencialUsuarios(usuarioDataAccess.getSecuencialUsuarios(connexion,usuario));

			for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
				SecuencialUsuarioLogic secuencialusuarioLogic= new SecuencialUsuarioLogic(connexion);
				secuencialusuarioLogic.deepLoad(secuencialusuario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MovimientoActivoFijo.class));
			usuario.setMovimientoActivoFijos(usuarioDataAccess.getMovimientoActivoFijos(connexion,usuario));

			for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
				MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
				movimientoactivofijoLogic.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UsuarioOpcion.class));
			usuario.setUsuarioOpcions(usuarioDataAccess.getUsuarioOpcions(connexion,usuario));

			for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
				UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
				usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompraImpor.class));
			usuario.setPedidoCompraImpors(usuarioDataAccess.getPedidoCompraImpors(connexion,usuario));

			for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenCompra.class));
			usuario.setOrdenCompras(usuarioDataAccess.getOrdenCompras(connexion,usuario));

			for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(ordencompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TurnoPunVen.class));
			usuario.setTurnoPunVens(usuarioDataAccess.getTurnoPunVens(connexion,usuario));

			for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepLoad(turnopunven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Novedad.class));
			usuario.setNovedads(usuarioDataAccess.getNovedads(connexion,usuario));

			for(Novedad novedad:usuario.getNovedads()) {
				NovedadLogic novedadLogic= new NovedadLogic(connexion);
				novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
				clases.add(new Classe(ParametroGeneralUsuario.class));
				usuario.setParametroGeneralUsuario(usuarioDataAccess.getParametroGeneralUsuario(connexion,usuario));

					ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic= new ParametroGeneralUsuarioLogic(connexion);

				parametrogeneralusuarioLogic.deepLoad(usuario.getParametroGeneralUsuario(),isDeep,deepLoadType,clases);
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPagoOrdenCompra.class));
			usuario.setAutoriPagoOrdenCompras(usuarioDataAccess.getAutoriPagoOrdenCompras(connexion,usuario));

			for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
				AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
				autoripagoordencompraLogic.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreCaja.class));
			usuario.setCierreCajas(usuarioDataAccess.getCierreCajas(connexion,usuario));

			for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
				CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
				cierrecajaLogic.deepLoad(cierrecaja,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DescuentoMonto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DescuentoMonto.class));
			usuario.setDescuentoMontos(usuarioDataAccess.getDescuentoMontos(connexion,usuario));

			for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
				DescuentoMontoLogic descuentomontoLogic= new DescuentoMontoLogic(connexion);
				descuentomontoLogic.deepLoad(descuentomonto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgreso.class));
			usuario.setCajaEgresos(usuarioDataAccess.getCajaEgresos(connexion,usuario));

			for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
				CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
				cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RequisicionCompra.class));
			usuario.setRequisicionCompras(usuarioDataAccess.getRequisicionCompras(connexion,usuario));

			for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
				RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
				requisicioncompraLogic.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			usuario.setNotaCreditoPuntoVentas(usuarioDataAccess.getNotaCreditoPuntoVentas(connexion,usuario));

			for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PlaneacionCompra.class));
			usuario.setPlaneacionCompras(usuarioDataAccess.getPlaneacionCompras(connexion,usuario));

			for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
				PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
				planeacioncompraLogic.deepLoad(planeacioncompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoCompra.class));
			usuario.setPedidoCompras(usuarioDataAccess.getPedidoCompras(connexion,usuario));

			for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
				PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
				pedidocompraLogic.deepLoad(pedidocompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilUsuario.class));
			usuario.setPerfilUsuarios(usuarioDataAccess.getPerfilUsuarios(connexion,usuario));

			for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
				PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
				perfilusuarioLogic.deepLoad(perfilusuario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignatario.class));
			usuario.setConsignatarios(usuarioDataAccess.getConsignatarios(connexion,usuario));

			for(Consignatario consignatario:usuario.getConsignatarios()) {
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepLoad(consignatario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transferencia.class));
			usuario.setTransferencias(usuarioDataAccess.getTransferencias(connexion,usuario));

			for(Transferencia transferencia:usuario.getTransferencias()) {
				TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
				transferenciaLogic.deepLoad(transferencia,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
				clases.add(new Classe(DatoGeneralUsuario.class));
				usuario.setDatoGeneralUsuario(usuarioDataAccess.getDatoGeneralUsuario(connexion,usuario));

					DatoGeneralUsuarioLogic datogeneralusuarioLogic= new DatoGeneralUsuarioLogic(connexion);

				datogeneralusuarioLogic.deepLoad(usuario.getDatoGeneralUsuario(),isDeep,deepLoadType,clases);
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngreso.class));
			usuario.setCajaIngresos(usuarioDataAccess.getCajaIngresos(connexion,usuario));

			for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
				CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
				cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteCoa.class));
			usuario.setClienteCoas(usuarioDataAccess.getClienteCoas(connexion,usuario));

			for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
				ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
				clientecoaLogic.deepLoad(clientecoa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			usuario.setConsignacions(usuarioDataAccess.getConsignacions(connexion,usuario));

			for(Consignacion consignacion:usuario.getConsignacions()) {
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMensajeCorreoInven.class));
			usuario.setDetalleMensajeCorreoInvens(usuarioDataAccess.getDetalleMensajeCorreoInvens(connexion,usuario));

			for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
				DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
				detallemensajecorreoinvenLogic.deepLoad(detallemensajecorreoinven,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Usuario usuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UsuarioLogicAdditional.updateUsuarioToSave(usuario,this.arrDatoGeneral);
			
UsuarioDataAccess.save(usuario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(usuario.getEmpresa(),connexion);

		for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
			depositobanco.setid_usuario(usuario.getId());
			DepositoBancoDataAccess.save(depositobanco,connexion);
		}

		for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
			historialcambioclave.setid_usuario(usuario.getId());
			HistorialCambioClaveDataAccess.save(historialcambioclave,connexion);
		}

		for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
			autoriretencion.setid_usuario(usuario.getId());
			AutoriRetencionDataAccess.save(autoriretencion,connexion);
		}

		for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
			cajeroturno.setid_usuario(usuario.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
		}

		for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
			detalleliquidacionimpor.setid_usuario(usuario.getId());
			DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
		}

		for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
			notacreditosoli.setid_usuario(usuario.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
		}

		for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
			pedidoexpor.setid_usuario(usuario.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
		}

		for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
			descuentotipoprecio.setid_usuario(usuario.getId());
			DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
		}

		for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
			guiaremision.setid_usuario(usuario.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
		}

		for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
			pedidopuntoventa.setid_usuario(usuario.getId());
			PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
		}

		for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
			gastoempleado.setid_usuario(usuario.getId());
			GastoEmpleadoDataAccess.save(gastoempleado,connexion);
		}

		for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
			secuencialusuario.setid_usuario(usuario.getId());
			SecuencialUsuarioDataAccess.save(secuencialusuario,connexion);
		}

		for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
			movimientoactivofijo.setid_usuario(usuario.getId());
			MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
		}

		for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
			usuarioopcion.setid_usuario(usuario.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
		}

		for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
			pedidocompraimpor.setid_usuario(usuario.getId());
			PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
		}

		for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
			ordencompra.setid_usuario(usuario.getId());
			OrdenCompraDataAccess.save(ordencompra,connexion);
		}

		for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
			turnopunven.setid_usuario(usuario.getId());
			TurnoPunVenDataAccess.save(turnopunven,connexion);
		}

		for(Novedad novedad:usuario.getNovedads()) {
			novedad.setid_usuario(usuario.getId());
			NovedadDataAccess.save(novedad,connexion);
		}

			usuario.getParametroGeneralUsuario().setId(usuario.getId());
		ParametroGeneralUsuarioDataAccess.save(usuario.getParametroGeneralUsuario(),connexion);

		for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
			autoripagoordencompra.setid_usuario(usuario.getId());
			AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
		}

		for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
			cierrecaja.setid_usuario(usuario.getId());
			CierreCajaDataAccess.save(cierrecaja,connexion);
		}

		for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
			descuentomonto.setid_usuario(usuario.getId());
			DescuentoMontoDataAccess.save(descuentomonto,connexion);
		}

		for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
			cajaegreso.setid_usuario(usuario.getId());
			CajaEgresoDataAccess.save(cajaegreso,connexion);
		}

		for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
			requisicioncompra.setid_usuario(usuario.getId());
			RequisicionCompraDataAccess.save(requisicioncompra,connexion);
		}

		for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
			notacreditopuntoventa.setid_usuario(usuario.getId());
			NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
		}

		for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
			planeacioncompra.setid_usuario(usuario.getId());
			PlaneacionCompraDataAccess.save(planeacioncompra,connexion);
		}

		for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
			pedidocompra.setid_usuario(usuario.getId());
			PedidoCompraDataAccess.save(pedidocompra,connexion);
		}

		for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
			perfilusuario.setid_usuario(usuario.getId());
			PerfilUsuarioDataAccess.save(perfilusuario,connexion);
		}

		for(Consignatario consignatario:usuario.getConsignatarios()) {
			consignatario.setid_usuario(usuario.getId());
			ConsignatarioDataAccess.save(consignatario,connexion);
		}

		for(Transferencia transferencia:usuario.getTransferencias()) {
			transferencia.setid_usuario(usuario.getId());
			TransferenciaDataAccess.save(transferencia,connexion);
		}

			usuario.getDatoGeneralUsuario().setId(usuario.getId());
		DatoGeneralUsuarioDataAccess.save(usuario.getDatoGeneralUsuario(),connexion);

		for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
			cajaingreso.setid_usuario(usuario.getId());
			CajaIngresoDataAccess.save(cajaingreso,connexion);
		}

		for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
			clientecoa.setid_usuario(usuario.getId());
			ClienteCoaDataAccess.save(clientecoa,connexion);
		}

		for(Consignacion consignacion:usuario.getConsignacions()) {
			consignacion.setid_usuario(usuario.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
		}

		for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
			detallemensajecorreoinven.setid_usuario(usuario.getId());
			DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(usuario.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DepositoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
					depositobanco.setid_usuario(usuario.getId());
					DepositoBancoDataAccess.save(depositobanco,connexion);
				}
				continue;
			}

			if(clas.clas.equals(HistorialCambioClave.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
					historialcambioclave.setid_usuario(usuario.getId());
					HistorialCambioClaveDataAccess.save(historialcambioclave,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AutoriRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
					autoriretencion.setid_usuario(usuario.getId());
					AutoriRetencionDataAccess.save(autoriretencion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
					cajeroturno.setid_usuario(usuario.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
					detalleliquidacionimpor.setid_usuario(usuario.getId());
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
					notacreditosoli.setid_usuario(usuario.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
					pedidoexpor.setid_usuario(usuario.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
					descuentotipoprecio.setid_usuario(usuario.getId());
					DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
					guiaremision.setid_usuario(usuario.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
					pedidopuntoventa.setid_usuario(usuario.getId());
					PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
					gastoempleado.setid_usuario(usuario.getId());
					GastoEmpleadoDataAccess.save(gastoempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SecuencialUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
					secuencialusuario.setid_usuario(usuario.getId());
					SecuencialUsuarioDataAccess.save(secuencialusuario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
					movimientoactivofijo.setid_usuario(usuario.getId());
					MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
					usuarioopcion.setid_usuario(usuario.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
					pedidocompraimpor.setid_usuario(usuario.getId());
					PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
					ordencompra.setid_usuario(usuario.getId());
					OrdenCompraDataAccess.save(ordencompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
					turnopunven.setid_usuario(usuario.getId());
					TurnoPunVenDataAccess.save(turnopunven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Novedad novedad:usuario.getNovedads()) {
					novedad.setid_usuario(usuario.getId());
					NovedadDataAccess.save(novedad,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				usuario.getParametroGeneralUsuario().setId(usuario.getId());
		ParametroGeneralUsuarioDataAccess.save(usuario.getParametroGeneralUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
					autoripagoordencompra.setid_usuario(usuario.getId());
					AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
					cierrecaja.setid_usuario(usuario.getId());
					CierreCajaDataAccess.save(cierrecaja,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoMonto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
					descuentomonto.setid_usuario(usuario.getId());
					DescuentoMontoDataAccess.save(descuentomonto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
					cajaegreso.setid_usuario(usuario.getId());
					CajaEgresoDataAccess.save(cajaegreso,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
					requisicioncompra.setid_usuario(usuario.getId());
					RequisicionCompraDataAccess.save(requisicioncompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
					notacreditopuntoventa.setid_usuario(usuario.getId());
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
					planeacioncompra.setid_usuario(usuario.getId());
					PlaneacionCompraDataAccess.save(planeacioncompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
					pedidocompra.setid_usuario(usuario.getId());
					PedidoCompraDataAccess.save(pedidocompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
					perfilusuario.setid_usuario(usuario.getId());
					PerfilUsuarioDataAccess.save(perfilusuario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignatario consignatario:usuario.getConsignatarios()) {
					consignatario.setid_usuario(usuario.getId());
					ConsignatarioDataAccess.save(consignatario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Transferencia transferencia:usuario.getTransferencias()) {
					transferencia.setid_usuario(usuario.getId());
					TransferenciaDataAccess.save(transferencia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				usuario.getDatoGeneralUsuario().setId(usuario.getId());
		DatoGeneralUsuarioDataAccess.save(usuario.getDatoGeneralUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
					cajaingreso.setid_usuario(usuario.getId());
					CajaIngresoDataAccess.save(cajaingreso,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
					clientecoa.setid_usuario(usuario.getId());
					ClienteCoaDataAccess.save(clientecoa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:usuario.getConsignacions()) {
					consignacion.setid_usuario(usuario.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
					detallemensajecorreoinven.setid_usuario(usuario.getId());
					DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(usuario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(usuario.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
			DepositoBancoLogic depositobancoLogic= new DepositoBancoLogic(connexion);
			depositobanco.setid_usuario(usuario.getId());
			DepositoBancoDataAccess.save(depositobanco,connexion);
			depositobancoLogic.deepSave(depositobanco,isDeep,deepLoadType,clases);
		}

		for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
			HistorialCambioClaveLogic historialcambioclaveLogic= new HistorialCambioClaveLogic(connexion);
			historialcambioclave.setid_usuario(usuario.getId());
			HistorialCambioClaveDataAccess.save(historialcambioclave,connexion);
			historialcambioclaveLogic.deepSave(historialcambioclave,isDeep,deepLoadType,clases);
		}

		for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
			AutoriRetencionLogic autoriretencionLogic= new AutoriRetencionLogic(connexion);
			autoriretencion.setid_usuario(usuario.getId());
			AutoriRetencionDataAccess.save(autoriretencion,connexion);
			autoriretencionLogic.deepSave(autoriretencion,isDeep,deepLoadType,clases);
		}

		for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturno.setid_usuario(usuario.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
			cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
		}

		for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
			detalleliquidacionimpor.setid_usuario(usuario.getId());
			DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
			detalleliquidacionimporLogic.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
		}

		for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoli.setid_usuario(usuario.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
			notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
		}

		for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexpor.setid_usuario(usuario.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
			pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
		}

		for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
			DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
			descuentotipoprecio.setid_usuario(usuario.getId());
			DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
			descuentotipoprecioLogic.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);
		}

		for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremision.setid_usuario(usuario.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
			guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
		}

		for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventa.setid_usuario(usuario.getId());
			PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
			pedidopuntoventaLogic.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
			GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
			gastoempleado.setid_usuario(usuario.getId());
			GastoEmpleadoDataAccess.save(gastoempleado,connexion);
			gastoempleadoLogic.deepSave(gastoempleado,isDeep,deepLoadType,clases);
		}

		for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
			SecuencialUsuarioLogic secuencialusuarioLogic= new SecuencialUsuarioLogic(connexion);
			secuencialusuario.setid_usuario(usuario.getId());
			SecuencialUsuarioDataAccess.save(secuencialusuario,connexion);
			secuencialusuarioLogic.deepSave(secuencialusuario,isDeep,deepLoadType,clases);
		}

		for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
			MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
			movimientoactivofijo.setid_usuario(usuario.getId());
			MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
			movimientoactivofijoLogic.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);
		}

		for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcion.setid_usuario(usuario.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
			usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
		}

		for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimpor.setid_usuario(usuario.getId());
			PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
			pedidocompraimporLogic.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
		}

		for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompra.setid_usuario(usuario.getId());
			OrdenCompraDataAccess.save(ordencompra,connexion);
			ordencompraLogic.deepSave(ordencompra,isDeep,deepLoadType,clases);
		}

		for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
			TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
			turnopunven.setid_usuario(usuario.getId());
			TurnoPunVenDataAccess.save(turnopunven,connexion);
			turnopunvenLogic.deepSave(turnopunven,isDeep,deepLoadType,clases);
		}

		for(Novedad novedad:usuario.getNovedads()) {
			NovedadLogic novedadLogic= new NovedadLogic(connexion);
			novedad.setid_usuario(usuario.getId());
			NovedadDataAccess.save(novedad,connexion);
			novedadLogic.deepSave(novedad,isDeep,deepLoadType,clases);
		}
					ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic= new ParametroGeneralUsuarioLogic(connexion);

				usuario.getParametroGeneralUsuario().setId(usuario.getId());
					ParametroGeneralUsuarioDataAccess.save(usuario.getParametroGeneralUsuario(),connexion);
					parametrogeneralusuarioLogic.deepSave(usuario.getParametroGeneralUsuario(),isDeep,deepLoadType,clases);

		for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
			autoripagoordencompra.setid_usuario(usuario.getId());
			AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
			autoripagoordencompraLogic.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);
		}

		for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
			CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
			cierrecaja.setid_usuario(usuario.getId());
			CierreCajaDataAccess.save(cierrecaja,connexion);
			cierrecajaLogic.deepSave(cierrecaja,isDeep,deepLoadType,clases);
		}

		for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
			DescuentoMontoLogic descuentomontoLogic= new DescuentoMontoLogic(connexion);
			descuentomonto.setid_usuario(usuario.getId());
			DescuentoMontoDataAccess.save(descuentomonto,connexion);
			descuentomontoLogic.deepSave(descuentomonto,isDeep,deepLoadType,clases);
		}

		for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
			CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
			cajaegreso.setid_usuario(usuario.getId());
			CajaEgresoDataAccess.save(cajaegreso,connexion);
			cajaegresoLogic.deepSave(cajaegreso,isDeep,deepLoadType,clases);
		}

		for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
			RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
			requisicioncompra.setid_usuario(usuario.getId());
			RequisicionCompraDataAccess.save(requisicioncompra,connexion);
			requisicioncompraLogic.deepSave(requisicioncompra,isDeep,deepLoadType,clases);
		}

		for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventa.setid_usuario(usuario.getId());
			NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
			notacreditopuntoventaLogic.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
			PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
			planeacioncompra.setid_usuario(usuario.getId());
			PlaneacionCompraDataAccess.save(planeacioncompra,connexion);
			planeacioncompraLogic.deepSave(planeacioncompra,isDeep,deepLoadType,clases);
		}

		for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
			PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
			pedidocompra.setid_usuario(usuario.getId());
			PedidoCompraDataAccess.save(pedidocompra,connexion);
			pedidocompraLogic.deepSave(pedidocompra,isDeep,deepLoadType,clases);
		}

		for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
			PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
			perfilusuario.setid_usuario(usuario.getId());
			PerfilUsuarioDataAccess.save(perfilusuario,connexion);
			perfilusuarioLogic.deepSave(perfilusuario,isDeep,deepLoadType,clases);
		}

		for(Consignatario consignatario:usuario.getConsignatarios()) {
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatario.setid_usuario(usuario.getId());
			ConsignatarioDataAccess.save(consignatario,connexion);
			consignatarioLogic.deepSave(consignatario,isDeep,deepLoadType,clases);
		}

		for(Transferencia transferencia:usuario.getTransferencias()) {
			TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
			transferencia.setid_usuario(usuario.getId());
			TransferenciaDataAccess.save(transferencia,connexion);
			transferenciaLogic.deepSave(transferencia,isDeep,deepLoadType,clases);
		}
					DatoGeneralUsuarioLogic datogeneralusuarioLogic= new DatoGeneralUsuarioLogic(connexion);

				usuario.getDatoGeneralUsuario().setId(usuario.getId());
					DatoGeneralUsuarioDataAccess.save(usuario.getDatoGeneralUsuario(),connexion);
					datogeneralusuarioLogic.deepSave(usuario.getDatoGeneralUsuario(),isDeep,deepLoadType,clases);

		for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
			CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
			cajaingreso.setid_usuario(usuario.getId());
			CajaIngresoDataAccess.save(cajaingreso,connexion);
			cajaingresoLogic.deepSave(cajaingreso,isDeep,deepLoadType,clases);
		}

		for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
			ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
			clientecoa.setid_usuario(usuario.getId());
			ClienteCoaDataAccess.save(clientecoa,connexion);
			clientecoaLogic.deepSave(clientecoa,isDeep,deepLoadType,clases);
		}

		for(Consignacion consignacion:usuario.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacion.setid_usuario(usuario.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
			consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
		}

		for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
			detallemensajecorreoinven.setid_usuario(usuario.getId());
			DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
			detallemensajecorreoinvenLogic.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(usuario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(usuario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DepositoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DepositoBanco depositobanco:usuario.getDepositoBancos()) {
					DepositoBancoLogic depositobancoLogic= new DepositoBancoLogic(connexion);
					depositobanco.setid_usuario(usuario.getId());
					DepositoBancoDataAccess.save(depositobanco,connexion);
					depositobancoLogic.deepSave(depositobanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialCambioClave.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialCambioClave historialcambioclave:usuario.getHistorialCambioClaves()) {
					HistorialCambioClaveLogic historialcambioclaveLogic= new HistorialCambioClaveLogic(connexion);
					historialcambioclave.setid_usuario(usuario.getId());
					HistorialCambioClaveDataAccess.save(historialcambioclave,connexion);
					historialcambioclaveLogic.deepSave(historialcambioclave,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriRetencion autoriretencion:usuario.getAutoriRetencions()) {
					AutoriRetencionLogic autoriretencionLogic= new AutoriRetencionLogic(connexion);
					autoriretencion.setid_usuario(usuario.getId());
					AutoriRetencionDataAccess.save(autoriretencion,connexion);
					autoriretencionLogic.deepSave(autoriretencion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:usuario.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturno.setid_usuario(usuario.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
					cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpor detalleliquidacionimpor:usuario.getDetalleLiquidacionImpors()) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
					detalleliquidacionimpor.setid_usuario(usuario.getId());
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
					detalleliquidacionimporLogic.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:usuario.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoli.setid_usuario(usuario.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
					notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:usuario.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexpor.setid_usuario(usuario.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
					pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoTipoPrecio.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DescuentoTipoPrecio descuentotipoprecio:usuario.getDescuentoTipoPrecios()) {
					DescuentoTipoPrecioLogic descuentotipoprecioLogic= new DescuentoTipoPrecioLogic(connexion);
					descuentotipoprecio.setid_usuario(usuario.getId());
					DescuentoTipoPrecioDataAccess.save(descuentotipoprecio,connexion);
					descuentotipoprecioLogic.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:usuario.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremision.setid_usuario(usuario.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
					guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoPuntoVenta pedidopuntoventa:usuario.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventa.setid_usuario(usuario.getId());
					PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
					pedidopuntoventaLogic.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoEmpleado gastoempleado:usuario.getGastoEmpleados()) {
					GastoEmpleadoLogic gastoempleadoLogic= new GastoEmpleadoLogic(connexion);
					gastoempleado.setid_usuario(usuario.getId());
					GastoEmpleadoDataAccess.save(gastoempleado,connexion);
					gastoempleadoLogic.deepSave(gastoempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SecuencialUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SecuencialUsuario secuencialusuario:usuario.getSecuencialUsuarios()) {
					SecuencialUsuarioLogic secuencialusuarioLogic= new SecuencialUsuarioLogic(connexion);
					secuencialusuario.setid_usuario(usuario.getId());
					SecuencialUsuarioDataAccess.save(secuencialusuario,connexion);
					secuencialusuarioLogic.deepSave(secuencialusuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MovimientoActivoFijo movimientoactivofijo:usuario.getMovimientoActivoFijos()) {
					MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
					movimientoactivofijo.setid_usuario(usuario.getId());
					MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
					movimientoactivofijoLogic.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:usuario.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcion.setid_usuario(usuario.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
					usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompraImpor pedidocompraimpor:usuario.getPedidoCompraImpors()) {
					PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
					pedidocompraimpor.setid_usuario(usuario.getId());
					PedidoCompraImporDataAccess.save(pedidocompraimpor,connexion);
					pedidocompraimporLogic.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenCompra ordencompra:usuario.getOrdenCompras()) {
					OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
					ordencompra.setid_usuario(usuario.getId());
					OrdenCompraDataAccess.save(ordencompra,connexion);
					ordencompraLogic.deepSave(ordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TurnoPunVen turnopunven:usuario.getTurnoPunVens()) {
					TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
					turnopunven.setid_usuario(usuario.getId());
					TurnoPunVenDataAccess.save(turnopunven,connexion);
					turnopunvenLogic.deepSave(turnopunven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Novedad novedad:usuario.getNovedads()) {
					NovedadLogic novedadLogic= new NovedadLogic(connexion);
					novedad.setid_usuario(usuario.getId());
					NovedadDataAccess.save(novedad,connexion);
					novedadLogic.deepSave(novedad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
					ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic= new ParametroGeneralUsuarioLogic(connexion);

				usuario.getParametroGeneralUsuario().setId(usuario.getId());
					ParametroGeneralUsuarioDataAccess.save(usuario.getParametroGeneralUsuario(),connexion);
					parametrogeneralusuarioLogic.deepSave(usuario.getParametroGeneralUsuario(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPagoOrdenCompra autoripagoordencompra:usuario.getAutoriPagoOrdenCompras()) {
					AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
					autoripagoordencompra.setid_usuario(usuario.getId());
					AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
					autoripagoordencompraLogic.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreCaja cierrecaja:usuario.getCierreCajas()) {
					CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
					cierrecaja.setid_usuario(usuario.getId());
					CierreCajaDataAccess.save(cierrecaja,connexion);
					cierrecajaLogic.deepSave(cierrecaja,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DescuentoMonto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DescuentoMonto descuentomonto:usuario.getDescuentoMontos()) {
					DescuentoMontoLogic descuentomontoLogic= new DescuentoMontoLogic(connexion);
					descuentomonto.setid_usuario(usuario.getId());
					DescuentoMontoDataAccess.save(descuentomonto,connexion);
					descuentomontoLogic.deepSave(descuentomonto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaEgreso cajaegreso:usuario.getCajaEgresos()) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
					cajaegreso.setid_usuario(usuario.getId());
					CajaEgresoDataAccess.save(cajaegreso,connexion);
					cajaegresoLogic.deepSave(cajaegreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RequisicionCompra requisicioncompra:usuario.getRequisicionCompras()) {
					RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
					requisicioncompra.setid_usuario(usuario.getId());
					RequisicionCompraDataAccess.save(requisicioncompra,connexion);
					requisicioncompraLogic.deepSave(requisicioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoPuntoVenta notacreditopuntoventa:usuario.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventa.setid_usuario(usuario.getId());
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
					notacreditopuntoventaLogic.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PlaneacionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PlaneacionCompra planeacioncompra:usuario.getPlaneacionCompras()) {
					PlaneacionCompraLogic planeacioncompraLogic= new PlaneacionCompraLogic(connexion);
					planeacioncompra.setid_usuario(usuario.getId());
					PlaneacionCompraDataAccess.save(planeacioncompra,connexion);
					planeacioncompraLogic.deepSave(planeacioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoCompra pedidocompra:usuario.getPedidoCompras()) {
					PedidoCompraLogic pedidocompraLogic= new PedidoCompraLogic(connexion);
					pedidocompra.setid_usuario(usuario.getId());
					PedidoCompraDataAccess.save(pedidocompra,connexion);
					pedidocompraLogic.deepSave(pedidocompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilUsuario perfilusuario:usuario.getPerfilUsuarios()) {
					PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
					perfilusuario.setid_usuario(usuario.getId());
					PerfilUsuarioDataAccess.save(perfilusuario,connexion);
					perfilusuarioLogic.deepSave(perfilusuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignatario consignatario:usuario.getConsignatarios()) {
					ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
					consignatario.setid_usuario(usuario.getId());
					ConsignatarioDataAccess.save(consignatario,connexion);
					consignatarioLogic.deepSave(consignatario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Transferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Transferencia transferencia:usuario.getTransferencias()) {
					TransferenciaLogic transferenciaLogic= new TransferenciaLogic(connexion);
					transferencia.setid_usuario(usuario.getId());
					TransferenciaDataAccess.save(transferencia,connexion);
					transferenciaLogic.deepSave(transferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
					DatoGeneralUsuarioLogic datogeneralusuarioLogic= new DatoGeneralUsuarioLogic(connexion);

				usuario.getDatoGeneralUsuario().setId(usuario.getId());
					DatoGeneralUsuarioDataAccess.save(usuario.getDatoGeneralUsuario(),connexion);
					datogeneralusuarioLogic.deepSave(usuario.getDatoGeneralUsuario(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajaIngreso cajaingreso:usuario.getCajaIngresos()) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
					cajaingreso.setid_usuario(usuario.getId());
					CajaIngresoDataAccess.save(cajaingreso,connexion);
					cajaingresoLogic.deepSave(cajaingreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteCoa clientecoa:usuario.getClienteCoas()) {
					ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
					clientecoa.setid_usuario(usuario.getId());
					ClienteCoaDataAccess.save(clientecoa,connexion);
					clientecoaLogic.deepSave(clientecoa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:usuario.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacion.setid_usuario(usuario.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
					consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMensajeCorreoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMensajeCorreoInven detallemensajecorreoinven:usuario.getDetalleMensajeCorreoInvens()) {
					DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic= new DetalleMensajeCorreoInvenLogic(connexion);
					detallemensajecorreoinven.setid_usuario(usuario.getId());
					DetalleMensajeCorreoInvenDataAccess.save(detallemensajecorreoinven,connexion);
					detallemensajecorreoinvenLogic.deepSave(detallemensajecorreoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}
		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Usuario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(usuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(usuario);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.usuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Usuario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(usuarios!=null) {
				for(Usuario usuario:usuarios) {
					this.deepLoad(usuario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(usuarios);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(usuarios!=null) {
				for(Usuario usuario:usuarios) {
					this.deepLoad(usuario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(usuarios);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(Usuario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(usuario,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(Usuario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(usuarios!=null) {
				for(Usuario usuario:usuarios) {
					this.deepSave(usuario,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(usuarios!=null) {
				for(Usuario usuario:usuarios) {
					this.deepSave(usuario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUsuariosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",UsuarioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuariosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",UsuarioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuariosBusquedaPorUserNameWithConnection(String sFinalQuery,Pagination pagination,String user_name)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralUserName= new ParameterSelectionGeneral();
			parameterSelectionGeneralUserName.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+user_name+"%",UsuarioConstantesFunciones.USERNAME,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralUserName);

			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorUserName","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuariosBusquedaPorUserName(String sFinalQuery,Pagination pagination,String user_name)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralUserName= new ParameterSelectionGeneral();
			parameterSelectionGeneralUserName.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+user_name+"%",UsuarioConstantesFunciones.USERNAME,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralUserName);

			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorUserName","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UsuarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarios=usuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioPorCodigoAlternoWithConnection(String codigo_alterno)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigoAlterno= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigoAlterno.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo_alterno,UsuarioConstantesFunciones.CODIGOALTERNO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigoAlterno);

			usuario=usuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioPorCodigoAlterno(String codigo_alterno)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigoAlterno= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigoAlterno.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo_alterno,UsuarioConstantesFunciones.CODIGOALTERNO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigoAlterno);

			usuario=usuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioPorUserNameWithConnection(String user_name)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Usuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralUserName= new ParameterSelectionGeneral();
			parameterSelectionGeneralUserName.setParameterSelectionGeneralEqual(ParameterType.STRING,user_name,UsuarioConstantesFunciones.USERNAME,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralUserName);

			usuario=usuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioPorUserName(String user_name)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralUserName= new ParameterSelectionGeneral();
			parameterSelectionGeneralUserName.setParameterSelectionGeneralEqual(ParameterType.STRING,user_name,UsuarioConstantesFunciones.USERNAME,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralUserName);

			usuario=usuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.usuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(this.usuario);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UsuarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Usuario usuario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UsuarioConstantesFunciones.ISCONAUDITORIA) {
				if(usuario.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioDataAccess.TABLENAME, usuario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						//UsuarioLogic.registrarAuditoriaDetallesUsuario(connexion,usuario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(usuario.getIsDeleted()) {
					/*if(!usuario.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UsuarioDataAccess.TABLENAME, usuario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//UsuarioLogic.registrarAuditoriaDetallesUsuario(connexion,usuario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioDataAccess.TABLENAME, usuario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(usuario.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioDataAccess.TABLENAME, usuario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						//UsuarioLogic.registrarAuditoriaDetallesUsuario(connexion,usuario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUsuario(Connexion connexion,Usuario usuario)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(usuario.getIsNew()||!usuario.getid_empresa().equals(usuario.getUsuarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getid_empresa()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getid_empresa().toString();
				}
				if(usuario.getid_empresa()!=null)
				{
					strValorNuevo=usuario.getid_empresa().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.getuser_name().equals(usuario.getUsuarioOriginal().getuser_name()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getuser_name()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getuser_name();
				}
				if(usuario.getuser_name()!=null)
				{
					strValorNuevo=usuario.getuser_name() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.USERNAME,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.getclave().equals(usuario.getUsuarioOriginal().getclave()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getclave()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getclave();
				}
				if(usuario.getclave()!=null)
				{
					strValorNuevo=usuario.getclave() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.CLAVE,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.getconfirmar_clave().equals(usuario.getUsuarioOriginal().getconfirmar_clave()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getconfirmar_clave()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getconfirmar_clave();
				}
				if(usuario.getconfirmar_clave()!=null)
				{
					strValorNuevo=usuario.getconfirmar_clave() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.CONFIRMARCLAVE,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.getnombre().equals(usuario.getUsuarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getnombre()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getnombre();
				}
				if(usuario.getnombre()!=null)
				{
					strValorNuevo=usuario.getnombre() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.getcodigo_alterno().equals(usuario.getUsuarioOriginal().getcodigo_alterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getcodigo_alterno()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getcodigo_alterno();
				}
				if(usuario.getcodigo_alterno()!=null)
				{
					strValorNuevo=usuario.getcodigo_alterno() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.CODIGOALTERNO,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.gettipo().equals(usuario.getUsuarioOriginal().gettipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().gettipo()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().gettipo().toString();
				}
				if(usuario.gettipo()!=null)
				{
					strValorNuevo=usuario.gettipo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.TIPO,strValorActual,strValorNuevo);
			}	
			
			if(usuario.getIsNew()||!usuario.getestado().equals(usuario.getUsuarioOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuario.getUsuarioOriginal().getestado()!=null)
				{
					strValorActual=usuario.getUsuarioOriginal().getestado().toString();
				}
				if(usuario.getestado()!=null)
				{
					strValorNuevo=usuario.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUsuarioRelacionesWithConnection(Usuario usuario,List<DepositoBanco> depositobancos,List<HistorialCambioClave> historialcambioclaves,List<AutoriRetencion> autoriretencions,List<CajeroTurno> cajeroturnos,List<DetalleLiquidacionImpor> detalleliquidacionimpors,List<NotaCreditoSoli> notacreditosolis,List<PedidoExpor> pedidoexpors,List<DescuentoTipoPrecio> descuentotipoprecios,List<GuiaRemision> guiaremisions,List<PedidoPuntoVenta> pedidopuntoventas,List<GastoEmpleado> gastoempleados,List<SecuencialUsuario> secuencialusuarios,List<MovimientoActivoFijo> movimientoactivofijos,List<UsuarioOpcion> usuarioopcions,List<PedidoCompraImpor> pedidocompraimpors,List<OrdenCompra> ordencompras,List<TurnoPunVen> turnopunvens,List<Novedad> novedads,ParametroGeneralUsuario parametrogeneralusuario,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<CierreCaja> cierrecajas,List<DescuentoMonto> descuentomontos,List<CajaEgreso> cajaegresos,List<RequisicionCompra> requisicioncompras,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<PlaneacionCompra> planeacioncompras,List<PedidoCompra> pedidocompras,List<PerfilUsuario> perfilusuarios,List<Consignatario> consignatarios,List<Transferencia> transferencias,DatoGeneralUsuario datogeneralusuario,List<CajaIngreso> cajaingresos,List<ClienteCoa> clientecoas,List<Consignacion> consignacions,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens) throws Exception {

		if(!usuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUsuarioRelacionesBase(usuario,depositobancos,historialcambioclaves,autoriretencions,cajeroturnos,detalleliquidacionimpors,notacreditosolis,pedidoexpors,descuentotipoprecios,guiaremisions,pedidopuntoventas,gastoempleados,secuencialusuarios,movimientoactivofijos,usuarioopcions,pedidocompraimpors,ordencompras,turnopunvens,novedads,parametrogeneralusuario,autoripagoordencompras,cierrecajas,descuentomontos,cajaegresos,requisicioncompras,notacreditopuntoventas,planeacioncompras,pedidocompras,perfilusuarios,consignatarios,transferencias,datogeneralusuario,cajaingresos,clientecoas,consignacions,detallemensajecorreoinvens,true);
		}
	}

	public void saveUsuarioRelaciones(Usuario usuario,List<DepositoBanco> depositobancos,List<HistorialCambioClave> historialcambioclaves,List<AutoriRetencion> autoriretencions,List<CajeroTurno> cajeroturnos,List<DetalleLiquidacionImpor> detalleliquidacionimpors,List<NotaCreditoSoli> notacreditosolis,List<PedidoExpor> pedidoexpors,List<DescuentoTipoPrecio> descuentotipoprecios,List<GuiaRemision> guiaremisions,List<PedidoPuntoVenta> pedidopuntoventas,List<GastoEmpleado> gastoempleados,List<SecuencialUsuario> secuencialusuarios,List<MovimientoActivoFijo> movimientoactivofijos,List<UsuarioOpcion> usuarioopcions,List<PedidoCompraImpor> pedidocompraimpors,List<OrdenCompra> ordencompras,List<TurnoPunVen> turnopunvens,List<Novedad> novedads,ParametroGeneralUsuario parametrogeneralusuario,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<CierreCaja> cierrecajas,List<DescuentoMonto> descuentomontos,List<CajaEgreso> cajaegresos,List<RequisicionCompra> requisicioncompras,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<PlaneacionCompra> planeacioncompras,List<PedidoCompra> pedidocompras,List<PerfilUsuario> perfilusuarios,List<Consignatario> consignatarios,List<Transferencia> transferencias,DatoGeneralUsuario datogeneralusuario,List<CajaIngreso> cajaingresos,List<ClienteCoa> clientecoas,List<Consignacion> consignacions,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens)throws Exception {

		if(!usuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUsuarioRelacionesBase(usuario,depositobancos,historialcambioclaves,autoriretencions,cajeroturnos,detalleliquidacionimpors,notacreditosolis,pedidoexpors,descuentotipoprecios,guiaremisions,pedidopuntoventas,gastoempleados,secuencialusuarios,movimientoactivofijos,usuarioopcions,pedidocompraimpors,ordencompras,turnopunvens,novedads,parametrogeneralusuario,autoripagoordencompras,cierrecajas,descuentomontos,cajaegresos,requisicioncompras,notacreditopuntoventas,planeacioncompras,pedidocompras,perfilusuarios,consignatarios,transferencias,datogeneralusuario,cajaingresos,clientecoas,consignacions,detallemensajecorreoinvens,false);
		}
	}

	public void saveUsuarioRelacionesBase(Usuario usuario,List<DepositoBanco> depositobancos,List<HistorialCambioClave> historialcambioclaves,List<AutoriRetencion> autoriretencions,List<CajeroTurno> cajeroturnos,List<DetalleLiquidacionImpor> detalleliquidacionimpors,List<NotaCreditoSoli> notacreditosolis,List<PedidoExpor> pedidoexpors,List<DescuentoTipoPrecio> descuentotipoprecios,List<GuiaRemision> guiaremisions,List<PedidoPuntoVenta> pedidopuntoventas,List<GastoEmpleado> gastoempleados,List<SecuencialUsuario> secuencialusuarios,List<MovimientoActivoFijo> movimientoactivofijos,List<UsuarioOpcion> usuarioopcions,List<PedidoCompraImpor> pedidocompraimpors,List<OrdenCompra> ordencompras,List<TurnoPunVen> turnopunvens,List<Novedad> novedads,ParametroGeneralUsuario parametrogeneralusuario,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<CierreCaja> cierrecajas,List<DescuentoMonto> descuentomontos,List<CajaEgreso> cajaegresos,List<RequisicionCompra> requisicioncompras,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<PlaneacionCompra> planeacioncompras,List<PedidoCompra> pedidocompras,List<PerfilUsuario> perfilusuarios,List<Consignatario> consignatarios,List<Transferencia> transferencias,DatoGeneralUsuario datogeneralusuario,List<CajaIngreso> cajaingresos,List<ClienteCoa> clientecoas,List<Consignacion> consignacions,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Usuario-saveRelacionesWithConnection");}
	
			usuario.setDepositoBancos(depositobancos);
			usuario.setHistorialCambioClaves(historialcambioclaves);
			usuario.setAutoriRetencions(autoriretencions);
			usuario.setCajeroTurnos(cajeroturnos);
			usuario.setDetalleLiquidacionImpors(detalleliquidacionimpors);
			usuario.setNotaCreditoSolis(notacreditosolis);
			usuario.setPedidoExpors(pedidoexpors);
			usuario.setDescuentoTipoPrecios(descuentotipoprecios);
			usuario.setGuiaRemisions(guiaremisions);
			usuario.setPedidoPuntoVentas(pedidopuntoventas);
			usuario.setGastoEmpleados(gastoempleados);
			usuario.setSecuencialUsuarios(secuencialusuarios);
			usuario.setMovimientoActivoFijos(movimientoactivofijos);
			usuario.setUsuarioOpcions(usuarioopcions);
			usuario.setPedidoCompraImpors(pedidocompraimpors);
			usuario.setOrdenCompras(ordencompras);
			usuario.setTurnoPunVens(turnopunvens);
			usuario.setNovedads(novedads);
			usuario.setParametroGeneralUsuario(parametrogeneralusuario);
			usuario.setAutoriPagoOrdenCompras(autoripagoordencompras);
			usuario.setCierreCajas(cierrecajas);
			usuario.setDescuentoMontos(descuentomontos);
			usuario.setCajaEgresos(cajaegresos);
			usuario.setRequisicionCompras(requisicioncompras);
			usuario.setNotaCreditoPuntoVentas(notacreditopuntoventas);
			usuario.setPlaneacionCompras(planeacioncompras);
			usuario.setPedidoCompras(pedidocompras);
			usuario.setPerfilUsuarios(perfilusuarios);
			usuario.setConsignatarios(consignatarios);
			usuario.setTransferencias(transferencias);
			usuario.setDatoGeneralUsuario(datogeneralusuario);
			usuario.setCajaIngresos(cajaingresos);
			usuario.setClienteCoas(clientecoas);
			usuario.setConsignacions(consignacions);
			usuario.setDetalleMensajeCorreoInvens(detallemensajecorreoinvens);

			this.setUsuario(usuario);

			if(UsuarioLogicAdditional.validarSaveRelaciones(usuario,this)) {

				UsuarioLogicAdditional.updateRelacionesToSave(usuario,this);

				if((usuario.getIsNew()||usuario.getIsChanged())&&!usuario.getIsDeleted()) {
					this.saveUsuario();
					this.saveUsuarioRelacionesDetalles(depositobancos,historialcambioclaves,autoriretencions,cajeroturnos,detalleliquidacionimpors,notacreditosolis,pedidoexpors,descuentotipoprecios,guiaremisions,pedidopuntoventas,gastoempleados,secuencialusuarios,movimientoactivofijos,usuarioopcions,pedidocompraimpors,ordencompras,turnopunvens,novedads,parametrogeneralusuario,autoripagoordencompras,cierrecajas,descuentomontos,cajaegresos,requisicioncompras,notacreditopuntoventas,planeacioncompras,pedidocompras,perfilusuarios,consignatarios,transferencias,datogeneralusuario,cajaingresos,clientecoas,consignacions,detallemensajecorreoinvens);

				} else if(usuario.getIsDeleted()) {
					this.saveUsuarioRelacionesDetalles(depositobancos,historialcambioclaves,autoriretencions,cajeroturnos,detalleliquidacionimpors,notacreditosolis,pedidoexpors,descuentotipoprecios,guiaremisions,pedidopuntoventas,gastoempleados,secuencialusuarios,movimientoactivofijos,usuarioopcions,pedidocompraimpors,ordencompras,turnopunvens,novedads,parametrogeneralusuario,autoripagoordencompras,cierrecajas,descuentomontos,cajaegresos,requisicioncompras,notacreditopuntoventas,planeacioncompras,pedidocompras,perfilusuarios,consignatarios,transferencias,datogeneralusuario,cajaingresos,clientecoas,consignacions,detallemensajecorreoinvens);
					this.saveUsuario();
				}

				UsuarioLogicAdditional.updateRelacionesToSaveAfter(usuario,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DepositoBancoConstantesFunciones.InicializarGeneralEntityAuxiliaresDepositoBancos(depositobancos,true,true);
			HistorialCambioClaveConstantesFunciones.InicializarGeneralEntityAuxiliaresHistorialCambioClaves(historialcambioclaves,true,true);
			AutoriRetencionConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriRetencions(autoriretencions,true,true);
			CajeroTurnoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajeroTurnos(cajeroturnos,true,true);
			DetalleLiquidacionImporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpors(detalleliquidacionimpors,true,true);
			NotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoSolis(notacreditosolis,true,true);
			PedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoExpors(pedidoexpors,true,true);
			DescuentoTipoPrecioConstantesFunciones.InicializarGeneralEntityAuxiliaresDescuentoTipoPrecios(descuentotipoprecios,true,true);
			GuiaRemisionConstantesFunciones.InicializarGeneralEntityAuxiliaresGuiaRemisions(guiaremisions,true,true);
			PedidoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoPuntoVentas(pedidopuntoventas,true,true);
			GastoEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresGastoEmpleados(gastoempleados,true,true);
			SecuencialUsuarioConstantesFunciones.InicializarGeneralEntityAuxiliaresSecuencialUsuarios(secuencialusuarios,true,true);
			MovimientoActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresMovimientoActivoFijos(movimientoactivofijos,true,true);
			UsuarioOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresUsuarioOpcions(usuarioopcions,true,true);
			PedidoCompraImporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoCompraImpors(pedidocompraimpors,true,true);
			OrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresOrdenCompras(ordencompras,true,true);
			TurnoPunVenConstantesFunciones.InicializarGeneralEntityAuxiliaresTurnoPunVens(turnopunvens,true,true);
			NovedadConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedads(novedads,true,true);
		ParametroGeneralUsuarioConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroGeneralUsuario(parametrogeneralusuario,true,true);
			AutoriPagoOrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriPagoOrdenCompras(autoripagoordencompras,true,true);
			CierreCajaConstantesFunciones.InicializarGeneralEntityAuxiliaresCierreCajas(cierrecajas,true,true);
			DescuentoMontoConstantesFunciones.InicializarGeneralEntityAuxiliaresDescuentoMontos(descuentomontos,true,true);
			CajaEgresoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajaEgresos(cajaegresos,true,true);
			RequisicionCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresRequisicionCompras(requisicioncompras,true,true);
			NotaCreditoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoPuntoVentas(notacreditopuntoventas,true,true);
			PlaneacionCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresPlaneacionCompras(planeacioncompras,true,true);
			PedidoCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoCompras(pedidocompras,true,true);
			PerfilUsuarioConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilUsuarios(perfilusuarios,true,true);
			ConsignatarioConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignatarios(consignatarios,true,true);
			TransferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresTransferencias(transferencias,true,true);
		DatoGeneralUsuarioConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralUsuario(datogeneralusuario,true,true);
			CajaIngresoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajaIngresos(cajaingresos,true,true);
			ClienteCoaConstantesFunciones.InicializarGeneralEntityAuxiliaresClienteCoas(clientecoas,true,true);
			ConsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignacions(consignacions,true,true);
			DetalleMensajeCorreoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMensajeCorreoInvens(detallemensajecorreoinvens,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveUsuarioRelacionesDetalles(List<DepositoBanco> depositobancos,List<HistorialCambioClave> historialcambioclaves,List<AutoriRetencion> autoriretencions,List<CajeroTurno> cajeroturnos,List<DetalleLiquidacionImpor> detalleliquidacionimpors,List<NotaCreditoSoli> notacreditosolis,List<PedidoExpor> pedidoexpors,List<DescuentoTipoPrecio> descuentotipoprecios,List<GuiaRemision> guiaremisions,List<PedidoPuntoVenta> pedidopuntoventas,List<GastoEmpleado> gastoempleados,List<SecuencialUsuario> secuencialusuarios,List<MovimientoActivoFijo> movimientoactivofijos,List<UsuarioOpcion> usuarioopcions,List<PedidoCompraImpor> pedidocompraimpors,List<OrdenCompra> ordencompras,List<TurnoPunVen> turnopunvens,List<Novedad> novedads,ParametroGeneralUsuario parametrogeneralusuario,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<CierreCaja> cierrecajas,List<DescuentoMonto> descuentomontos,List<CajaEgreso> cajaegresos,List<RequisicionCompra> requisicioncompras,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<PlaneacionCompra> planeacioncompras,List<PedidoCompra> pedidocompras,List<PerfilUsuario> perfilusuarios,List<Consignatario> consignatarios,List<Transferencia> transferencias,DatoGeneralUsuario datogeneralusuario,List<CajaIngreso> cajaingresos,List<ClienteCoa> clientecoas,List<Consignacion> consignacions,List<DetalleMensajeCorreoInven> detallemensajecorreoinvens)throws Exception {
		try {
	

			Long idUsuarioActual=this.getUsuario().getId();

			DepositoBancoLogic depositobancoLogic_Desde_Usuario=new DepositoBancoLogic();
			depositobancoLogic_Desde_Usuario.setDepositoBancos(depositobancos);

			depositobancoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			depositobancoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(DepositoBanco depositobanco_Desde_Usuario:depositobancoLogic_Desde_Usuario.getDepositoBancos()) {
				depositobanco_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			depositobancoLogic_Desde_Usuario.saveDepositoBancos();

			HistorialCambioClaveLogic historialcambioclaveLogic_Desde_Usuario=new HistorialCambioClaveLogic();
			historialcambioclaveLogic_Desde_Usuario.setHistorialCambioClaves(historialcambioclaves);

			historialcambioclaveLogic_Desde_Usuario.setConnexion(this.getConnexion());
			historialcambioclaveLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(HistorialCambioClave historialcambioclave_Desde_Usuario:historialcambioclaveLogic_Desde_Usuario.getHistorialCambioClaves()) {
				historialcambioclave_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			historialcambioclaveLogic_Desde_Usuario.saveHistorialCambioClaves();

			AutoriRetencionLogic autoriretencionLogic_Desde_Usuario=new AutoriRetencionLogic();
			autoriretencionLogic_Desde_Usuario.setAutoriRetencions(autoriretencions);

			autoriretencionLogic_Desde_Usuario.setConnexion(this.getConnexion());
			autoriretencionLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(AutoriRetencion autoriretencion_Desde_Usuario:autoriretencionLogic_Desde_Usuario.getAutoriRetencions()) {
				autoriretencion_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			autoriretencionLogic_Desde_Usuario.saveAutoriRetencions();

			CajeroTurnoLogic cajeroturnoLogic_Desde_Usuario=new CajeroTurnoLogic();
			cajeroturnoLogic_Desde_Usuario.setCajeroTurnos(cajeroturnos);

			cajeroturnoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			cajeroturnoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(CajeroTurno cajeroturno_Desde_Usuario:cajeroturnoLogic_Desde_Usuario.getCajeroTurnos()) {
				cajeroturno_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			cajeroturnoLogic_Desde_Usuario.saveCajeroTurnos();

			DetalleLiquidacionImporLogic detalleliquidacionimporLogic_Desde_Usuario=new DetalleLiquidacionImporLogic();
			detalleliquidacionimporLogic_Desde_Usuario.setDetalleLiquidacionImpors(detalleliquidacionimpors);

			detalleliquidacionimporLogic_Desde_Usuario.setConnexion(this.getConnexion());
			detalleliquidacionimporLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(DetalleLiquidacionImpor detalleliquidacionimpor_Desde_Usuario:detalleliquidacionimporLogic_Desde_Usuario.getDetalleLiquidacionImpors()) {
				detalleliquidacionimpor_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			detalleliquidacionimporLogic_Desde_Usuario.saveDetalleLiquidacionImpors();

			NotaCreditoSoliLogic notacreditosoliLogic_Desde_Usuario=new NotaCreditoSoliLogic();
			notacreditosoliLogic_Desde_Usuario.setNotaCreditoSolis(notacreditosolis);

			notacreditosoliLogic_Desde_Usuario.setConnexion(this.getConnexion());
			notacreditosoliLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(NotaCreditoSoli notacreditosoli_Desde_Usuario:notacreditosoliLogic_Desde_Usuario.getNotaCreditoSolis()) {
				notacreditosoli_Desde_Usuario.setid_usuario(idUsuarioActual);

				notacreditosoliLogic_Desde_Usuario.setNotaCreditoSoli(notacreditosoli_Desde_Usuario);
				notacreditosoliLogic_Desde_Usuario.saveNotaCreditoSoli();

				Long idNotaCreditoSoliActual=notacreditosoli_Desde_Usuario.getId();

				DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_NotaCreditoSoli=new DetaNotaCreditoSoliLogic();

				if(notacreditosoli_Desde_Usuario.getDetaNotaCreditoSolis()==null){
					notacreditosoli_Desde_Usuario.setDetaNotaCreditoSolis(new ArrayList<DetaNotaCreditoSoli>());
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDetaNotaCreditoSolis(notacreditosoli_Desde_Usuario.getDetaNotaCreditoSolis());

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setConnexion(this.getConnexion());
				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDatosCliente(this.datosCliente);

				for(DetaNotaCreditoSoli detanotacreditosoli_Desde_NotaCreditoSoli:detanotacreditosoliLogic_Desde_NotaCreditoSoli.getDetaNotaCreditoSolis()) {
					detanotacreditosoli_Desde_NotaCreditoSoli.setid_nota_credito_soli(idNotaCreditoSoliActual);
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.saveDetaNotaCreditoSolis();
			}


			PedidoExporLogic pedidoexporLogic_Desde_Usuario=new PedidoExporLogic();
			pedidoexporLogic_Desde_Usuario.setPedidoExpors(pedidoexpors);

			pedidoexporLogic_Desde_Usuario.setConnexion(this.getConnexion());
			pedidoexporLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(PedidoExpor pedidoexpor_Desde_Usuario:pedidoexporLogic_Desde_Usuario.getPedidoExpors()) {
				pedidoexpor_Desde_Usuario.setid_usuario(idUsuarioActual);

				pedidoexporLogic_Desde_Usuario.setPedidoExpor(pedidoexpor_Desde_Usuario);
				pedidoexporLogic_Desde_Usuario.savePedidoExpor();

				Long idPedidoExporActual=pedidoexpor_Desde_Usuario.getId();

				DetallePedidoExporLogic detallepedidoexporLogic_Desde_PedidoExpor=new DetallePedidoExporLogic();

				if(pedidoexpor_Desde_Usuario.getDetallePedidoExpors()==null){
					pedidoexpor_Desde_Usuario.setDetallePedidoExpors(new ArrayList<DetallePedidoExpor>());
				}

				detallepedidoexporLogic_Desde_PedidoExpor.setDetallePedidoExpors(pedidoexpor_Desde_Usuario.getDetallePedidoExpors());

				detallepedidoexporLogic_Desde_PedidoExpor.setConnexion(this.getConnexion());
				detallepedidoexporLogic_Desde_PedidoExpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoExpor detallepedidoexpor_Desde_PedidoExpor:detallepedidoexporLogic_Desde_PedidoExpor.getDetallePedidoExpors()) {
					detallepedidoexpor_Desde_PedidoExpor.setid_pedido_expor(idPedidoExporActual);
				}

				detallepedidoexporLogic_Desde_PedidoExpor.saveDetallePedidoExpors();
			}


			DescuentoTipoPrecioLogic descuentotipoprecioLogic_Desde_Usuario=new DescuentoTipoPrecioLogic();
			descuentotipoprecioLogic_Desde_Usuario.setDescuentoTipoPrecios(descuentotipoprecios);

			descuentotipoprecioLogic_Desde_Usuario.setConnexion(this.getConnexion());
			descuentotipoprecioLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(DescuentoTipoPrecio descuentotipoprecio_Desde_Usuario:descuentotipoprecioLogic_Desde_Usuario.getDescuentoTipoPrecios()) {
				descuentotipoprecio_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			descuentotipoprecioLogic_Desde_Usuario.saveDescuentoTipoPrecios();

			GuiaRemisionLogic guiaremisionLogic_Desde_Usuario=new GuiaRemisionLogic();
			guiaremisionLogic_Desde_Usuario.setGuiaRemisions(guiaremisions);

			guiaremisionLogic_Desde_Usuario.setConnexion(this.getConnexion());
			guiaremisionLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(GuiaRemision guiaremision_Desde_Usuario:guiaremisionLogic_Desde_Usuario.getGuiaRemisions()) {
				guiaremision_Desde_Usuario.setid_usuario(idUsuarioActual);

				guiaremisionLogic_Desde_Usuario.setGuiaRemision(guiaremision_Desde_Usuario);
				guiaremisionLogic_Desde_Usuario.saveGuiaRemision();

				Long idGuiaRemisionActual=guiaremision_Desde_Usuario.getId();

				DetalleGuiaRemisionLogic detalleguiaremisionLogic_Desde_GuiaRemision=new DetalleGuiaRemisionLogic();

				if(guiaremision_Desde_Usuario.getDetalleGuiaRemisions()==null){
					guiaremision_Desde_Usuario.setDetalleGuiaRemisions(new ArrayList<DetalleGuiaRemision>());
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.setDetalleGuiaRemisions(guiaremision_Desde_Usuario.getDetalleGuiaRemisions());

				detalleguiaremisionLogic_Desde_GuiaRemision.setConnexion(this.getConnexion());
				detalleguiaremisionLogic_Desde_GuiaRemision.setDatosCliente(this.datosCliente);

				for(DetalleGuiaRemision detalleguiaremision_Desde_GuiaRemision:detalleguiaremisionLogic_Desde_GuiaRemision.getDetalleGuiaRemisions()) {
					detalleguiaremision_Desde_GuiaRemision.setid_guia_remision(idGuiaRemisionActual);
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.saveDetalleGuiaRemisions();
			}


			PedidoPuntoVentaLogic pedidopuntoventaLogic_Desde_Usuario=new PedidoPuntoVentaLogic();
			pedidopuntoventaLogic_Desde_Usuario.setPedidoPuntoVentas(pedidopuntoventas);

			pedidopuntoventaLogic_Desde_Usuario.setConnexion(this.getConnexion());
			pedidopuntoventaLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(PedidoPuntoVenta pedidopuntoventa_Desde_Usuario:pedidopuntoventaLogic_Desde_Usuario.getPedidoPuntoVentas()) {
				pedidopuntoventa_Desde_Usuario.setid_usuario(idUsuarioActual);

				pedidopuntoventaLogic_Desde_Usuario.setPedidoPuntoVenta(pedidopuntoventa_Desde_Usuario);
				pedidopuntoventaLogic_Desde_Usuario.savePedidoPuntoVenta();

				Long idPedidoPuntoVentaActual=pedidopuntoventa_Desde_Usuario.getId();

				DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta=new DetallePedidoPuntoVentaLogic();

				if(pedidopuntoventa_Desde_Usuario.getDetallePedidoPuntoVentas()==null){
					pedidopuntoventa_Desde_Usuario.setDetallePedidoPuntoVentas(new ArrayList<DetallePedidoPuntoVenta>());
				}

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDetallePedidoPuntoVentas(pedidopuntoventa_Desde_Usuario.getDetallePedidoPuntoVentas());

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setConnexion(this.getConnexion());
				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDatosCliente(this.datosCliente);

				for(DetallePedidoPuntoVenta detallepedidopuntoventa_Desde_PedidoPuntoVenta:detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.getDetallePedidoPuntoVentas()) {
					detallepedidopuntoventa_Desde_PedidoPuntoVenta.setid_pedido_punto_venta(idPedidoPuntoVentaActual);
				}

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.saveDetallePedidoPuntoVentas();
			}


			GastoEmpleadoLogic gastoempleadoLogic_Desde_Usuario=new GastoEmpleadoLogic();
			gastoempleadoLogic_Desde_Usuario.setGastoEmpleados(gastoempleados);

			gastoempleadoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			gastoempleadoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(GastoEmpleado gastoempleado_Desde_Usuario:gastoempleadoLogic_Desde_Usuario.getGastoEmpleados()) {
				gastoempleado_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			gastoempleadoLogic_Desde_Usuario.saveGastoEmpleados();

			SecuencialUsuarioLogic secuencialusuarioLogic_Desde_Usuario=new SecuencialUsuarioLogic();
			secuencialusuarioLogic_Desde_Usuario.setSecuencialUsuarios(secuencialusuarios);

			secuencialusuarioLogic_Desde_Usuario.setConnexion(this.getConnexion());
			secuencialusuarioLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(SecuencialUsuario secuencialusuario_Desde_Usuario:secuencialusuarioLogic_Desde_Usuario.getSecuencialUsuarios()) {
				secuencialusuario_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			secuencialusuarioLogic_Desde_Usuario.saveSecuencialUsuarios();

			MovimientoActivoFijoLogic movimientoactivofijoLogic_Desde_Usuario=new MovimientoActivoFijoLogic();
			movimientoactivofijoLogic_Desde_Usuario.setMovimientoActivoFijos(movimientoactivofijos);

			movimientoactivofijoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			movimientoactivofijoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(MovimientoActivoFijo movimientoactivofijo_Desde_Usuario:movimientoactivofijoLogic_Desde_Usuario.getMovimientoActivoFijos()) {
				movimientoactivofijo_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			movimientoactivofijoLogic_Desde_Usuario.saveMovimientoActivoFijos();

			UsuarioOpcionLogic usuarioopcionLogic_Desde_Usuario=new UsuarioOpcionLogic();
			usuarioopcionLogic_Desde_Usuario.setUsuarioOpcions(usuarioopcions);

			usuarioopcionLogic_Desde_Usuario.setConnexion(this.getConnexion());
			usuarioopcionLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(UsuarioOpcion usuarioopcion_Desde_Usuario:usuarioopcionLogic_Desde_Usuario.getUsuarioOpcions()) {
				usuarioopcion_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			usuarioopcionLogic_Desde_Usuario.saveUsuarioOpcions();

			PedidoCompraImporLogic pedidocompraimporLogic_Desde_Usuario=new PedidoCompraImporLogic();
			pedidocompraimporLogic_Desde_Usuario.setPedidoCompraImpors(pedidocompraimpors);

			pedidocompraimporLogic_Desde_Usuario.setConnexion(this.getConnexion());
			pedidocompraimporLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(PedidoCompraImpor pedidocompraimpor_Desde_Usuario:pedidocompraimporLogic_Desde_Usuario.getPedidoCompraImpors()) {
				pedidocompraimpor_Desde_Usuario.setid_usuario(idUsuarioActual);

				pedidocompraimporLogic_Desde_Usuario.setPedidoCompraImpor(pedidocompraimpor_Desde_Usuario);
				pedidocompraimporLogic_Desde_Usuario.savePedidoCompraImpor();

				Long idPedidoCompraImporActual=pedidocompraimpor_Desde_Usuario.getId();

				DetallePedidoCompraImporLogic detallepedidocompraimporLogic_Desde_PedidoCompraImpor=new DetallePedidoCompraImporLogic();

				if(pedidocompraimpor_Desde_Usuario.getDetallePedidoCompraImpors()==null){
					pedidocompraimpor_Desde_Usuario.setDetallePedidoCompraImpors(new ArrayList<DetallePedidoCompraImpor>());
				}

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDetallePedidoCompraImpors(pedidocompraimpor_Desde_Usuario.getDetallePedidoCompraImpors());

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoCompraImpor detallepedidocompraimpor_Desde_PedidoCompraImpor:detallepedidocompraimporLogic_Desde_PedidoCompraImpor.getDetallePedidoCompraImpors()) {
					detallepedidocompraimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);
				}

				detallepedidocompraimporLogic_Desde_PedidoCompraImpor.saveDetallePedidoCompraImpors();

				LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor=new LiquidacionImpuestoImporLogic();

				if(pedidocompraimpor_Desde_Usuario.getLiquidacionImpuestoImpors()==null){
					pedidocompraimpor_Desde_Usuario.setLiquidacionImpuestoImpors(new ArrayList<LiquidacionImpuestoImpor>());
				}

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpors(pedidocompraimpor_Desde_Usuario.getLiquidacionImpuestoImpors());

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor_Desde_PedidoCompraImpor:liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.getLiquidacionImpuestoImpors()) {
					liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);

					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor_Desde_PedidoCompraImpor);
					liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.saveLiquidacionImpuestoImpor();
				}

			}


			OrdenCompraLogic ordencompraLogic_Desde_Usuario=new OrdenCompraLogic();
			ordencompraLogic_Desde_Usuario.setOrdenCompras(ordencompras);

			ordencompraLogic_Desde_Usuario.setConnexion(this.getConnexion());
			ordencompraLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(OrdenCompra ordencompra_Desde_Usuario:ordencompraLogic_Desde_Usuario.getOrdenCompras()) {
				ordencompra_Desde_Usuario.setid_usuario(idUsuarioActual);

				ordencompraLogic_Desde_Usuario.setOrdenCompra(ordencompra_Desde_Usuario);
				ordencompraLogic_Desde_Usuario.saveOrdenCompra();
			}


			TurnoPunVenLogic turnopunvenLogic_Desde_Usuario=new TurnoPunVenLogic();
			turnopunvenLogic_Desde_Usuario.setTurnoPunVens(turnopunvens);

			turnopunvenLogic_Desde_Usuario.setConnexion(this.getConnexion());
			turnopunvenLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(TurnoPunVen turnopunven_Desde_Usuario:turnopunvenLogic_Desde_Usuario.getTurnoPunVens()) {
				turnopunven_Desde_Usuario.setid_usuario(idUsuarioActual);

				turnopunvenLogic_Desde_Usuario.setTurnoPunVen(turnopunven_Desde_Usuario);
				turnopunvenLogic_Desde_Usuario.saveTurnoPunVen();
			}


			NovedadLogic novedadLogic_Desde_Usuario=new NovedadLogic();
			novedadLogic_Desde_Usuario.setNovedads(novedads);

			novedadLogic_Desde_Usuario.setConnexion(this.getConnexion());
			novedadLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(Novedad novedad_Desde_Usuario:novedadLogic_Desde_Usuario.getNovedads()) {
				novedad_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			novedadLogic_Desde_Usuario.saveNovedads();

			ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic_Desde_Usuario=new ParametroGeneralUsuarioLogic();
			parametrogeneralusuarioLogic_Desde_Usuario.setParametroGeneralUsuario(parametrogeneralusuario);

			if(parametrogeneralusuarioLogic_Desde_Usuario.getParametroGeneralUsuario()!=null) {
			parametrogeneralusuarioLogic_Desde_Usuario.getParametroGeneralUsuario().setId(idUsuarioActual);
			}

			parametrogeneralusuarioLogic_Desde_Usuario.setConnexion(this.getConnexion());
			parametrogeneralusuarioLogic_Desde_Usuario.setDatosCliente(this.datosCliente);
			parametrogeneralusuarioLogic_Desde_Usuario.saveParametroGeneralUsuario();

			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic_Desde_Usuario=new AutoriPagoOrdenCompraLogic();
			autoripagoordencompraLogic_Desde_Usuario.setAutoriPagoOrdenCompras(autoripagoordencompras);

			autoripagoordencompraLogic_Desde_Usuario.setConnexion(this.getConnexion());
			autoripagoordencompraLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(AutoriPagoOrdenCompra autoripagoordencompra_Desde_Usuario:autoripagoordencompraLogic_Desde_Usuario.getAutoriPagoOrdenCompras()) {
				autoripagoordencompra_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			autoripagoordencompraLogic_Desde_Usuario.saveAutoriPagoOrdenCompras();

			CierreCajaLogic cierrecajaLogic_Desde_Usuario=new CierreCajaLogic();
			cierrecajaLogic_Desde_Usuario.setCierreCajas(cierrecajas);

			cierrecajaLogic_Desde_Usuario.setConnexion(this.getConnexion());
			cierrecajaLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(CierreCaja cierrecaja_Desde_Usuario:cierrecajaLogic_Desde_Usuario.getCierreCajas()) {
				cierrecaja_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			cierrecajaLogic_Desde_Usuario.saveCierreCajas();

			DescuentoMontoLogic descuentomontoLogic_Desde_Usuario=new DescuentoMontoLogic();
			descuentomontoLogic_Desde_Usuario.setDescuentoMontos(descuentomontos);

			descuentomontoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			descuentomontoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(DescuentoMonto descuentomonto_Desde_Usuario:descuentomontoLogic_Desde_Usuario.getDescuentoMontos()) {
				descuentomonto_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			descuentomontoLogic_Desde_Usuario.saveDescuentoMontos();

			CajaEgresoLogic cajaegresoLogic_Desde_Usuario=new CajaEgresoLogic();
			cajaegresoLogic_Desde_Usuario.setCajaEgresos(cajaegresos);

			cajaegresoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			cajaegresoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(CajaEgreso cajaegreso_Desde_Usuario:cajaegresoLogic_Desde_Usuario.getCajaEgresos()) {
				cajaegreso_Desde_Usuario.setid_usuario(idUsuarioActual);

				cajaegresoLogic_Desde_Usuario.setCajaEgreso(cajaegreso_Desde_Usuario);
				cajaegresoLogic_Desde_Usuario.saveCajaEgreso();
			}


			RequisicionCompraLogic requisicioncompraLogic_Desde_Usuario=new RequisicionCompraLogic();
			requisicioncompraLogic_Desde_Usuario.setRequisicionCompras(requisicioncompras);

			requisicioncompraLogic_Desde_Usuario.setConnexion(this.getConnexion());
			requisicioncompraLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(RequisicionCompra requisicioncompra_Desde_Usuario:requisicioncompraLogic_Desde_Usuario.getRequisicionCompras()) {
				requisicioncompra_Desde_Usuario.setid_usuario(idUsuarioActual);

				requisicioncompraLogic_Desde_Usuario.setRequisicionCompra(requisicioncompra_Desde_Usuario);
				requisicioncompraLogic_Desde_Usuario.saveRequisicionCompra();
			}


			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic_Desde_Usuario=new NotaCreditoPuntoVentaLogic();
			notacreditopuntoventaLogic_Desde_Usuario.setNotaCreditoPuntoVentas(notacreditopuntoventas);

			notacreditopuntoventaLogic_Desde_Usuario.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(NotaCreditoPuntoVenta notacreditopuntoventa_Desde_Usuario:notacreditopuntoventaLogic_Desde_Usuario.getNotaCreditoPuntoVentas()) {
				notacreditopuntoventa_Desde_Usuario.setid_usuario(idUsuarioActual);

				notacreditopuntoventaLogic_Desde_Usuario.setNotaCreditoPuntoVenta(notacreditopuntoventa_Desde_Usuario);
				notacreditopuntoventaLogic_Desde_Usuario.saveNotaCreditoPuntoVenta();
			}


			PlaneacionCompraLogic planeacioncompraLogic_Desde_Usuario=new PlaneacionCompraLogic();
			planeacioncompraLogic_Desde_Usuario.setPlaneacionCompras(planeacioncompras);

			planeacioncompraLogic_Desde_Usuario.setConnexion(this.getConnexion());
			planeacioncompraLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(PlaneacionCompra planeacioncompra_Desde_Usuario:planeacioncompraLogic_Desde_Usuario.getPlaneacionCompras()) {
				planeacioncompra_Desde_Usuario.setid_usuario(idUsuarioActual);

				planeacioncompraLogic_Desde_Usuario.setPlaneacionCompra(planeacioncompra_Desde_Usuario);
				planeacioncompraLogic_Desde_Usuario.savePlaneacionCompra();
			}


			PedidoCompraLogic pedidocompraLogic_Desde_Usuario=new PedidoCompraLogic();
			pedidocompraLogic_Desde_Usuario.setPedidoCompras(pedidocompras);

			pedidocompraLogic_Desde_Usuario.setConnexion(this.getConnexion());
			pedidocompraLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(PedidoCompra pedidocompra_Desde_Usuario:pedidocompraLogic_Desde_Usuario.getPedidoCompras()) {
				pedidocompra_Desde_Usuario.setid_usuario(idUsuarioActual);

				pedidocompraLogic_Desde_Usuario.setPedidoCompra(pedidocompra_Desde_Usuario);
				pedidocompraLogic_Desde_Usuario.savePedidoCompra();
			}


			PerfilUsuarioLogic perfilusuarioLogic_Desde_Usuario=new PerfilUsuarioLogic();
			perfilusuarioLogic_Desde_Usuario.setPerfilUsuarios(perfilusuarios);

			perfilusuarioLogic_Desde_Usuario.setConnexion(this.getConnexion());
			perfilusuarioLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(PerfilUsuario perfilusuario_Desde_Usuario:perfilusuarioLogic_Desde_Usuario.getPerfilUsuarios()) {
				perfilusuario_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			perfilusuarioLogic_Desde_Usuario.savePerfilUsuarios();

			ConsignatarioLogic consignatarioLogic_Desde_Usuario=new ConsignatarioLogic();
			consignatarioLogic_Desde_Usuario.setConsignatarios(consignatarios);

			consignatarioLogic_Desde_Usuario.setConnexion(this.getConnexion());
			consignatarioLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(Consignatario consignatario_Desde_Usuario:consignatarioLogic_Desde_Usuario.getConsignatarios()) {
				consignatario_Desde_Usuario.setid_usuario(idUsuarioActual);

				consignatarioLogic_Desde_Usuario.setConsignatario(consignatario_Desde_Usuario);
				consignatarioLogic_Desde_Usuario.saveConsignatario();
			}


			TransferenciaLogic transferenciaLogic_Desde_Usuario=new TransferenciaLogic();
			transferenciaLogic_Desde_Usuario.setTransferencias(transferencias);

			transferenciaLogic_Desde_Usuario.setConnexion(this.getConnexion());
			transferenciaLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(Transferencia transferencia_Desde_Usuario:transferenciaLogic_Desde_Usuario.getTransferencias()) {
				transferencia_Desde_Usuario.setid_usuario(idUsuarioActual);

				transferenciaLogic_Desde_Usuario.setTransferencia(transferencia_Desde_Usuario);
				transferenciaLogic_Desde_Usuario.saveTransferencia();
			}


			DatoGeneralUsuarioLogic datogeneralusuarioLogic_Desde_Usuario=new DatoGeneralUsuarioLogic();
			datogeneralusuarioLogic_Desde_Usuario.setDatoGeneralUsuario(datogeneralusuario);

			if(datogeneralusuarioLogic_Desde_Usuario.getDatoGeneralUsuario()!=null) {
			datogeneralusuarioLogic_Desde_Usuario.getDatoGeneralUsuario().setId(idUsuarioActual);
			}

			datogeneralusuarioLogic_Desde_Usuario.setConnexion(this.getConnexion());
			datogeneralusuarioLogic_Desde_Usuario.setDatosCliente(this.datosCliente);
			datogeneralusuarioLogic_Desde_Usuario.saveDatoGeneralUsuario();

			CajaIngresoLogic cajaingresoLogic_Desde_Usuario=new CajaIngresoLogic();
			cajaingresoLogic_Desde_Usuario.setCajaIngresos(cajaingresos);

			cajaingresoLogic_Desde_Usuario.setConnexion(this.getConnexion());
			cajaingresoLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(CajaIngreso cajaingreso_Desde_Usuario:cajaingresoLogic_Desde_Usuario.getCajaIngresos()) {
				cajaingreso_Desde_Usuario.setid_usuario(idUsuarioActual);

				cajaingresoLogic_Desde_Usuario.setCajaIngreso(cajaingreso_Desde_Usuario);
				cajaingresoLogic_Desde_Usuario.saveCajaIngreso();
			}


			ClienteCoaLogic clientecoaLogic_Desde_Usuario=new ClienteCoaLogic();
			clientecoaLogic_Desde_Usuario.setClienteCoas(clientecoas);

			clientecoaLogic_Desde_Usuario.setConnexion(this.getConnexion());
			clientecoaLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(ClienteCoa clientecoa_Desde_Usuario:clientecoaLogic_Desde_Usuario.getClienteCoas()) {
				clientecoa_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			clientecoaLogic_Desde_Usuario.saveClienteCoas();

			ConsignacionLogic consignacionLogic_Desde_Usuario=new ConsignacionLogic();
			consignacionLogic_Desde_Usuario.setConsignacions(consignacions);

			consignacionLogic_Desde_Usuario.setConnexion(this.getConnexion());
			consignacionLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(Consignacion consignacion_Desde_Usuario:consignacionLogic_Desde_Usuario.getConsignacions()) {
				consignacion_Desde_Usuario.setid_usuario(idUsuarioActual);

				consignacionLogic_Desde_Usuario.setConsignacion(consignacion_Desde_Usuario);
				consignacionLogic_Desde_Usuario.saveConsignacion();
			}


			DetalleMensajeCorreoInvenLogic detallemensajecorreoinvenLogic_Desde_Usuario=new DetalleMensajeCorreoInvenLogic();
			detallemensajecorreoinvenLogic_Desde_Usuario.setDetalleMensajeCorreoInvens(detallemensajecorreoinvens);

			detallemensajecorreoinvenLogic_Desde_Usuario.setConnexion(this.getConnexion());
			detallemensajecorreoinvenLogic_Desde_Usuario.setDatosCliente(this.datosCliente);

			for(DetalleMensajeCorreoInven detallemensajecorreoinven_Desde_Usuario:detallemensajecorreoinvenLogic_Desde_Usuario.getDetalleMensajeCorreoInvens()) {
				detallemensajecorreoinven_Desde_Usuario.setid_usuario(idUsuarioActual);
			}

			detallemensajecorreoinvenLogic_Desde_Usuario.saveDetalleMensajeCorreoInvens();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UsuarioConstantesFunciones.getClassesForeignKeysOfUsuario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UsuarioConstantesFunciones.getClassesRelationshipsOfUsuario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
