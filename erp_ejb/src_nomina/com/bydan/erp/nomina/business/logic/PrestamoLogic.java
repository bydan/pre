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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.PrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.PrestamoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PrestamoParameterGeneral;
import com.bydan.erp.nomina.business.entity.Prestamo;
import com.bydan.erp.nomina.business.logic.PrestamoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PrestamoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PrestamoLogic.class);
	
	protected PrestamoDataAccess prestamoDataAccess; 	
	protected Prestamo prestamo;
	protected List<Prestamo> prestamos;
	protected Object prestamoObject;	
	protected List<Object> prestamosObject;
	
	public static ClassValidator<Prestamo> prestamoValidator = new ClassValidator<Prestamo>(Prestamo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PrestamoLogicAdditional prestamoLogicAdditional=null;
	
	public PrestamoLogicAdditional getPrestamoLogicAdditional() {
		return this.prestamoLogicAdditional;
	}
	
	public void setPrestamoLogicAdditional(PrestamoLogicAdditional prestamoLogicAdditional) {
		try {
			this.prestamoLogicAdditional=prestamoLogicAdditional;
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
	
	
	
	
	public  PrestamoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.prestamoDataAccess = new PrestamoDataAccess();
			
			this.prestamos= new ArrayList<Prestamo>();
			this.prestamo= new Prestamo();
			
			this.prestamoObject=new Object();
			this.prestamosObject=new ArrayList<Object>();
				
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
			
			this.prestamoDataAccess.setConnexionType(this.connexionType);
			this.prestamoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PrestamoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.prestamoDataAccess = new PrestamoDataAccess();
			this.prestamos= new ArrayList<Prestamo>();
			this.prestamo= new Prestamo();
			this.prestamoObject=new Object();
			this.prestamosObject=new ArrayList<Object>();
			
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
			
			this.prestamoDataAccess.setConnexionType(this.connexionType);
			this.prestamoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Prestamo getPrestamo() throws Exception {	
		PrestamoLogicAdditional.checkPrestamoToGet(prestamo,this.datosCliente,this.arrDatoGeneral);
		PrestamoLogicAdditional.updatePrestamoToGet(prestamo,this.arrDatoGeneral);
		
		return prestamo;
	}
		
	public void setPrestamo(Prestamo newPrestamo) {
		this.prestamo = newPrestamo;
	}
	
	public PrestamoDataAccess getPrestamoDataAccess() {
		return prestamoDataAccess;
	}
	
	public void setPrestamoDataAccess(PrestamoDataAccess newprestamoDataAccess) {
		this.prestamoDataAccess = newprestamoDataAccess;
	}
	
	public List<Prestamo> getPrestamos() throws Exception {		
		this.quitarPrestamosNulos();
		
		PrestamoLogicAdditional.checkPrestamoToGets(prestamos,this.datosCliente,this.arrDatoGeneral);
		
		for (Prestamo prestamoLocal: prestamos ) {
			PrestamoLogicAdditional.updatePrestamoToGet(prestamoLocal,this.arrDatoGeneral);
		}
		
		return prestamos;
	}
	
	public void setPrestamos(List<Prestamo> newPrestamos) {
		this.prestamos = newPrestamos;
	}
	
	public Object getPrestamoObject() {	
		this.prestamoObject=this.prestamoDataAccess.getEntityObject();
		return this.prestamoObject;
	}
		
	public void setPrestamoObject(Object newPrestamoObject) {
		this.prestamoObject = newPrestamoObject;
	}
	
	public List<Object> getPrestamosObject() {		
		this.prestamosObject=this.prestamoDataAccess.getEntitiesObject();
		return this.prestamosObject;
	}
		
	public void setPrestamosObject(List<Object> newPrestamosObject) {
		this.prestamosObject = newPrestamosObject;
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
		
		if(this.prestamoDataAccess!=null) {
			this.prestamoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			prestamoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			prestamoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		prestamo = new  Prestamo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			prestamo=prestamoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
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
		prestamo = new  Prestamo();
		  		  
        try {
			
			prestamo=prestamoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		prestamo = new  Prestamo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			prestamo=prestamoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
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
		prestamo = new  Prestamo();
		  		  
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
		prestamo = new  Prestamo();
		  		  
        try {
			
			prestamo=prestamoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.prestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		prestamo = new  Prestamo();
		  		  
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
		prestamo = new  Prestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =prestamoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		prestamo = new  Prestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=prestamoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		prestamo = new  Prestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =prestamoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		prestamo = new  Prestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=prestamoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		prestamo = new  Prestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =prestamoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		prestamo = new  Prestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=prestamoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		prestamos = new  ArrayList<Prestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
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
		prestamos = new  ArrayList<Prestamo>();
		  		  
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
		prestamos = new  ArrayList<Prestamo>();
		  		  
        try {			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		prestamos = new  ArrayList<Prestamo>();
		  		  
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
		prestamos = new  ArrayList<Prestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
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
		prestamos = new  ArrayList<Prestamo>();
		  		  
        try {
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
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
		prestamos = new  ArrayList<Prestamo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
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
		prestamos = new  ArrayList<Prestamo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		prestamo = new  Prestamo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamo=prestamoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
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
		prestamo = new  Prestamo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamo=prestamoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		prestamos = new  ArrayList<Prestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
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
		prestamos = new  ArrayList<Prestamo>();
		  		  
        try {
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPrestamosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		prestamos = new  ArrayList<Prestamo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getTodosPrestamosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
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
	
	public  void  getTodosPrestamos(String sFinalQuery,Pagination pagination)throws Exception {
		prestamos = new  ArrayList<Prestamo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPrestamo(prestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPrestamo(Prestamo prestamo) throws Exception {
		Boolean estaValidado=false;
		
		if(prestamo.getIsNew() || prestamo.getIsChanged()) { 
			this.invalidValues = prestamoValidator.getInvalidValues(prestamo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(prestamo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPrestamo(List<Prestamo> Prestamos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Prestamo prestamoLocal:prestamos) {				
			estaValidadoObjeto=this.validarGuardarPrestamo(prestamoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPrestamo(List<Prestamo> Prestamos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPrestamo(prestamos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPrestamo(Prestamo Prestamo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPrestamo(prestamo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Prestamo prestamo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+prestamo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PrestamoConstantesFunciones.getPrestamoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"prestamo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PrestamoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PrestamoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePrestamoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-savePrestamoWithConnection");connexion.begin();			
			
			PrestamoLogicAdditional.checkPrestamoToSave(this.prestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PrestamoLogicAdditional.updatePrestamoToSave(this.prestamo,this.arrDatoGeneral);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.prestamo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPrestamo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPrestamo(this.prestamo)) {
				PrestamoDataAccess.save(this.prestamo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.prestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PrestamoLogicAdditional.checkPrestamoToSaveAfter(this.prestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPrestamo();
			
			connexion.commit();			
			
			if(this.prestamo.getIsDeleted()) {
				this.prestamo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePrestamo()throws Exception {	
		try {	
			
			PrestamoLogicAdditional.checkPrestamoToSave(this.prestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PrestamoLogicAdditional.updatePrestamoToSave(this.prestamo,this.arrDatoGeneral);
			
			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.prestamo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPrestamo(this.prestamo)) {			
				PrestamoDataAccess.save(this.prestamo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.prestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PrestamoLogicAdditional.checkPrestamoToSaveAfter(this.prestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.prestamo.getIsDeleted()) {
				this.prestamo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePrestamosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-savePrestamosWithConnection");connexion.begin();			
			
			PrestamoLogicAdditional.checkPrestamoToSaves(prestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPrestamos();
			
			Boolean validadoTodosPrestamo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Prestamo prestamoLocal:prestamos) {		
				if(prestamoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PrestamoLogicAdditional.updatePrestamoToSave(prestamoLocal,this.arrDatoGeneral);
	        	
				PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),prestamoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPrestamo(prestamoLocal)) {
					PrestamoDataAccess.save(prestamoLocal, connexion);				
				} else {
					validadoTodosPrestamo=false;
				}
			}
			
			if(!validadoTodosPrestamo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PrestamoLogicAdditional.checkPrestamoToSavesAfter(prestamos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPrestamos();
			
			connexion.commit();		
			
			this.quitarPrestamosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePrestamos()throws Exception {				
		 try {	
			PrestamoLogicAdditional.checkPrestamoToSaves(prestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPrestamo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Prestamo prestamoLocal:prestamos) {				
				if(prestamoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PrestamoLogicAdditional.updatePrestamoToSave(prestamoLocal,this.arrDatoGeneral);
	        	
				PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),prestamoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPrestamo(prestamoLocal)) {				
					PrestamoDataAccess.save(prestamoLocal, connexion);				
				} else {
					validadoTodosPrestamo=false;
				}
			}
			
			if(!validadoTodosPrestamo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PrestamoLogicAdditional.checkPrestamoToSavesAfter(prestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPrestamosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PrestamoParameterReturnGeneral procesarAccionPrestamos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Prestamo> prestamos,PrestamoParameterReturnGeneral prestamoParameterGeneral)throws Exception {
		 try {	
			PrestamoParameterReturnGeneral prestamoReturnGeneral=new PrestamoParameterReturnGeneral();
	
			PrestamoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,prestamos,prestamoParameterGeneral,prestamoReturnGeneral);
			
			return prestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PrestamoParameterReturnGeneral procesarAccionPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Prestamo> prestamos,PrestamoParameterReturnGeneral prestamoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-procesarAccionPrestamosWithConnection");connexion.begin();			
			
			PrestamoParameterReturnGeneral prestamoReturnGeneral=new PrestamoParameterReturnGeneral();
	
			PrestamoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,prestamos,prestamoParameterGeneral,prestamoReturnGeneral);
			
			this.connexion.commit();
			
			return prestamoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PrestamoParameterReturnGeneral procesarEventosPrestamos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Prestamo> prestamos,Prestamo prestamo,PrestamoParameterReturnGeneral prestamoParameterGeneral,Boolean isEsNuevoPrestamo,ArrayList<Classe> clases)throws Exception {
		 try {	
			PrestamoParameterReturnGeneral prestamoReturnGeneral=new PrestamoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				prestamoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PrestamoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,prestamos,prestamo,prestamoParameterGeneral,prestamoReturnGeneral,isEsNuevoPrestamo,clases);
			
			return prestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PrestamoParameterReturnGeneral procesarEventosPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Prestamo> prestamos,Prestamo prestamo,PrestamoParameterReturnGeneral prestamoParameterGeneral,Boolean isEsNuevoPrestamo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-procesarEventosPrestamosWithConnection");connexion.begin();			
			
			PrestamoParameterReturnGeneral prestamoReturnGeneral=new PrestamoParameterReturnGeneral();
	
			prestamoReturnGeneral.setPrestamo(prestamo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				prestamoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PrestamoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,prestamos,prestamo,prestamoParameterGeneral,prestamoReturnGeneral,isEsNuevoPrestamo,clases);
			
			this.connexion.commit();
			
			return prestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PrestamoParameterReturnGeneral procesarImportacionPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PrestamoParameterReturnGeneral prestamoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-procesarImportacionPrestamosWithConnection");connexion.begin();			
			
			PrestamoParameterReturnGeneral prestamoReturnGeneral=new PrestamoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.prestamos=new ArrayList<Prestamo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.prestamo=new Prestamo();
				
				
				if(conColumnasBase) {this.prestamo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.prestamo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.prestamo.setcodigo(arrColumnas[iColumn++]);
				this.prestamo.setnumero_pre_impreso(arrColumnas[iColumn++]);
				this.prestamo.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.prestamo.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.prestamo.setnumero_cuotas(Integer.parseInt(arrColumnas[iColumn++]));
				this.prestamo.settasa(Double.parseDouble(arrColumnas[iColumn++]));
				this.prestamo.setdescripcion(arrColumnas[iColumn++]);
				
				this.prestamos.add(this.prestamo);
			}
			
			this.savePrestamos();
			
			this.connexion.commit();
			
			prestamoReturnGeneral.setConRetornoEstaProcesado(true);
			prestamoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return prestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPrestamosEliminados() throws Exception {				
		
		List<Prestamo> prestamosAux= new ArrayList<Prestamo>();
		
		for(Prestamo prestamo:prestamos) {
			if(!prestamo.getIsDeleted()) {
				prestamosAux.add(prestamo);
			}
		}
		
		prestamos=prestamosAux;
	}
	
	public void quitarPrestamosNulos() throws Exception {				
		
		List<Prestamo> prestamosAux= new ArrayList<Prestamo>();
		
		for(Prestamo prestamo : this.prestamos) {
			if(prestamo==null) {
				prestamosAux.add(prestamo);
			}
		}
		
		//this.prestamos=prestamosAux;
		
		this.prestamos.removeAll(prestamosAux);
	}
	
	public void getSetVersionRowPrestamoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(prestamo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((prestamo.getIsDeleted() || (prestamo.getIsChanged()&&!prestamo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=prestamoDataAccess.getSetVersionRowPrestamo(connexion,prestamo.getId());
				
				if(!prestamo.getVersionRow().equals(timestamp)) {	
					prestamo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				prestamo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPrestamo()throws Exception {	
		
		if(prestamo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((prestamo.getIsDeleted() || (prestamo.getIsChanged()&&!prestamo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=prestamoDataAccess.getSetVersionRowPrestamo(connexion,prestamo.getId());
			
			try {							
				if(!prestamo.getVersionRow().equals(timestamp)) {	
					prestamo.setVersionRow(timestamp);
				}
				
				prestamo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPrestamosWithConnection()throws Exception {	
		if(prestamos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Prestamo prestamoAux:prestamos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(prestamoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(prestamoAux.getIsDeleted() || (prestamoAux.getIsChanged()&&!prestamoAux.getIsNew())) {
						
						timestamp=prestamoDataAccess.getSetVersionRowPrestamo(connexion,prestamoAux.getId());
						
						if(!prestamo.getVersionRow().equals(timestamp)) {	
							prestamoAux.setVersionRow(timestamp);
						}
								
						prestamoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPrestamos()throws Exception {	
		if(prestamos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Prestamo prestamoAux:prestamos) {
					if(prestamoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(prestamoAux.getIsDeleted() || (prestamoAux.getIsChanged()&&!prestamoAux.getIsNew())) {
						
						timestamp=prestamoDataAccess.getSetVersionRowPrestamo(connexion,prestamoAux.getId());
						
						if(!prestamoAux.getVersionRow().equals(timestamp)) {	
							prestamoAux.setVersionRow(timestamp);
						}
						
													
						prestamoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PrestamoParameterReturnGeneral cargarCombosLoteForeignKeyPrestamoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrestamo,String finalQueryGlobalTipoCuota,String finalQueryGlobalAsientoContable) throws Exception {
		PrestamoParameterReturnGeneral  prestamoReturnGeneral =new PrestamoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-cargarCombosLoteForeignKeyPrestamoWithConnection");connexion.begin();
			
			prestamoReturnGeneral =new PrestamoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			prestamoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			prestamoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrestamo> tipoprestamosForeignKey=new ArrayList<TipoPrestamo>();
			TipoPrestamoLogic tipoprestamoLogic=new TipoPrestamoLogic();
			tipoprestamoLogic.setConnexion(this.connexion);
			tipoprestamoLogic.getTipoPrestamoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrestamo.equals("NONE")) {
				tipoprestamoLogic.getTodosTipoPrestamos(finalQueryGlobalTipoPrestamo,new Pagination());
				tipoprestamosForeignKey=tipoprestamoLogic.getTipoPrestamos();
			}

			prestamoReturnGeneral.settipoprestamosForeignKey(tipoprestamosForeignKey);


			List<TipoCuota> tipocuotasForeignKey=new ArrayList<TipoCuota>();
			TipoCuotaLogic tipocuotaLogic=new TipoCuotaLogic();
			tipocuotaLogic.setConnexion(this.connexion);
			tipocuotaLogic.getTipoCuotaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuota.equals("NONE")) {
				tipocuotaLogic.getTodosTipoCuotas(finalQueryGlobalTipoCuota,new Pagination());
				tipocuotasForeignKey=tipocuotaLogic.getTipoCuotas();
			}

			prestamoReturnGeneral.settipocuotasForeignKey(tipocuotasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			prestamoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return prestamoReturnGeneral;
	}
	
	public PrestamoParameterReturnGeneral cargarCombosLoteForeignKeyPrestamo(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrestamo,String finalQueryGlobalTipoCuota,String finalQueryGlobalAsientoContable) throws Exception {
		PrestamoParameterReturnGeneral  prestamoReturnGeneral =new PrestamoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			prestamoReturnGeneral =new PrestamoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			prestamoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			prestamoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrestamo> tipoprestamosForeignKey=new ArrayList<TipoPrestamo>();
			TipoPrestamoLogic tipoprestamoLogic=new TipoPrestamoLogic();
			tipoprestamoLogic.setConnexion(this.connexion);
			tipoprestamoLogic.getTipoPrestamoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrestamo.equals("NONE")) {
				tipoprestamoLogic.getTodosTipoPrestamos(finalQueryGlobalTipoPrestamo,new Pagination());
				tipoprestamosForeignKey=tipoprestamoLogic.getTipoPrestamos();
			}

			prestamoReturnGeneral.settipoprestamosForeignKey(tipoprestamosForeignKey);


			List<TipoCuota> tipocuotasForeignKey=new ArrayList<TipoCuota>();
			TipoCuotaLogic tipocuotaLogic=new TipoCuotaLogic();
			tipocuotaLogic.setConnexion(this.connexion);
			tipocuotaLogic.getTipoCuotaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuota.equals("NONE")) {
				tipocuotaLogic.getTodosTipoCuotas(finalQueryGlobalTipoCuota,new Pagination());
				tipocuotasForeignKey=tipocuotaLogic.getTipoCuotas();
			}

			prestamoReturnGeneral.settipocuotasForeignKey(tipocuotasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			prestamoReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return prestamoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPrestamoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			AbonoPrestamoLogic abonoprestamoLogic=new AbonoPrestamoLogic();
			CuotaLogic cuotaLogic=new CuotaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPrestamoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(AbonoPrestamo.class));
			classes.add(new Classe(Cuota.class));
											
			

			abonoprestamoLogic.setConnexion(this.getConnexion());
			abonoprestamoLogic.setDatosCliente(this.datosCliente);
			abonoprestamoLogic.setIsConRefrescarForeignKeys(true);

			cuotaLogic.setConnexion(this.getConnexion());
			cuotaLogic.setDatosCliente(this.datosCliente);
			cuotaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Prestamo prestamo:this.prestamos) {
				

				classes=new ArrayList<Classe>();
				classes=AbonoPrestamoConstantesFunciones.getClassesForeignKeysOfAbonoPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);

				abonoprestamoLogic.setAbonoPrestamos(prestamo.abonoprestamos);
				abonoprestamoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuotaLogic.setCuotas(prestamo.cuotas);
				cuotaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Prestamo prestamo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PrestamoLogicAdditional.updatePrestamoToGet(prestamo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		prestamo.setEmpresa(prestamoDataAccess.getEmpresa(connexion,prestamo));
		prestamo.setEmpleado(prestamoDataAccess.getEmpleado(connexion,prestamo));
		prestamo.setTipoPrestamo(prestamoDataAccess.getTipoPrestamo(connexion,prestamo));
		prestamo.setTipoCuota(prestamoDataAccess.getTipoCuota(connexion,prestamo));
		prestamo.setAsientoContable(prestamoDataAccess.getAsientoContable(connexion,prestamo));
		prestamo.setAbonoPrestamos(prestamoDataAccess.getAbonoPrestamos(connexion,prestamo));
		prestamo.setCuotas(prestamoDataAccess.getCuotas(connexion,prestamo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				prestamo.setEmpresa(prestamoDataAccess.getEmpresa(connexion,prestamo));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				prestamo.setEmpleado(prestamoDataAccess.getEmpleado(connexion,prestamo));
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)) {
				prestamo.setTipoPrestamo(prestamoDataAccess.getTipoPrestamo(connexion,prestamo));
				continue;
			}

			if(clas.clas.equals(TipoCuota.class)) {
				prestamo.setTipoCuota(prestamoDataAccess.getTipoCuota(connexion,prestamo));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				prestamo.setAsientoContable(prestamoDataAccess.getAsientoContable(connexion,prestamo));
				continue;
			}

			if(clas.clas.equals(AbonoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				prestamo.setAbonoPrestamos(prestamoDataAccess.getAbonoPrestamos(connexion,prestamo));

				if(this.isConDeep) {
					AbonoPrestamoLogic abonoprestamoLogic= new AbonoPrestamoLogic(this.connexion);
					abonoprestamoLogic.setAbonoPrestamos(prestamo.getAbonoPrestamos());
					ArrayList<Classe> classesLocal=AbonoPrestamoConstantesFunciones.getClassesForeignKeysOfAbonoPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);
					abonoprestamoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(abonoprestamoLogic.getAbonoPrestamos());
					prestamo.setAbonoPrestamos(abonoprestamoLogic.getAbonoPrestamos());
				}

				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				prestamo.setCuotas(prestamoDataAccess.getCuotas(connexion,prestamo));

				if(this.isConDeep) {
					CuotaLogic cuotaLogic= new CuotaLogic(this.connexion);
					cuotaLogic.setCuotas(prestamo.getCuotas());
					ArrayList<Classe> classesLocal=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuotaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(cuotaLogic.getCuotas());
					prestamo.setCuotas(cuotaLogic.getCuotas());
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
			prestamo.setEmpresa(prestamoDataAccess.getEmpresa(connexion,prestamo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setEmpleado(prestamoDataAccess.getEmpleado(connexion,prestamo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setTipoPrestamo(prestamoDataAccess.getTipoPrestamo(connexion,prestamo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuota.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setTipoCuota(prestamoDataAccess.getTipoCuota(connexion,prestamo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setAsientoContable(prestamoDataAccess.getAsientoContable(connexion,prestamo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AbonoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AbonoPrestamo.class));
			prestamo.setAbonoPrestamos(prestamoDataAccess.getAbonoPrestamos(connexion,prestamo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cuota.class));
			prestamo.setCuotas(prestamoDataAccess.getCuotas(connexion,prestamo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		prestamo.setEmpresa(prestamoDataAccess.getEmpresa(connexion,prestamo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(prestamo.getEmpresa(),isDeep,deepLoadType,clases);
				
		prestamo.setEmpleado(prestamoDataAccess.getEmpleado(connexion,prestamo));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(prestamo.getEmpleado(),isDeep,deepLoadType,clases);
				
		prestamo.setTipoPrestamo(prestamoDataAccess.getTipoPrestamo(connexion,prestamo));
		TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
		tipoprestamoLogic.deepLoad(prestamo.getTipoPrestamo(),isDeep,deepLoadType,clases);
				
		prestamo.setTipoCuota(prestamoDataAccess.getTipoCuota(connexion,prestamo));
		TipoCuotaLogic tipocuotaLogic= new TipoCuotaLogic(connexion);
		tipocuotaLogic.deepLoad(prestamo.getTipoCuota(),isDeep,deepLoadType,clases);
				
		prestamo.setAsientoContable(prestamoDataAccess.getAsientoContable(connexion,prestamo));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(prestamo.getAsientoContable(),isDeep,deepLoadType,clases);
				

		prestamo.setAbonoPrestamos(prestamoDataAccess.getAbonoPrestamos(connexion,prestamo));

		for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
			AbonoPrestamoLogic abonoprestamoLogic= new AbonoPrestamoLogic(connexion);
			abonoprestamoLogic.deepLoad(abonoprestamo,isDeep,deepLoadType,clases);
		}

		prestamo.setCuotas(prestamoDataAccess.getCuotas(connexion,prestamo));

		for(Cuota cuota:prestamo.getCuotas()) {
			CuotaLogic cuotaLogic= new CuotaLogic(connexion);
			cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				prestamo.setEmpresa(prestamoDataAccess.getEmpresa(connexion,prestamo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(prestamo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				prestamo.setEmpleado(prestamoDataAccess.getEmpleado(connexion,prestamo));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(prestamo.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)) {
				prestamo.setTipoPrestamo(prestamoDataAccess.getTipoPrestamo(connexion,prestamo));
				TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
				tipoprestamoLogic.deepLoad(prestamo.getTipoPrestamo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuota.class)) {
				prestamo.setTipoCuota(prestamoDataAccess.getTipoCuota(connexion,prestamo));
				TipoCuotaLogic tipocuotaLogic= new TipoCuotaLogic(connexion);
				tipocuotaLogic.deepLoad(prestamo.getTipoCuota(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				prestamo.setAsientoContable(prestamoDataAccess.getAsientoContable(connexion,prestamo));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(prestamo.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AbonoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				prestamo.setAbonoPrestamos(prestamoDataAccess.getAbonoPrestamos(connexion,prestamo));

				for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
					AbonoPrestamoLogic abonoprestamoLogic= new AbonoPrestamoLogic(connexion);
					abonoprestamoLogic.deepLoad(abonoprestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				prestamo.setCuotas(prestamoDataAccess.getCuotas(connexion,prestamo));

				for(Cuota cuota:prestamo.getCuotas()) {
					CuotaLogic cuotaLogic= new CuotaLogic(connexion);
					cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
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
			prestamo.setEmpresa(prestamoDataAccess.getEmpresa(connexion,prestamo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(prestamo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setEmpleado(prestamoDataAccess.getEmpleado(connexion,prestamo));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(prestamo.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setTipoPrestamo(prestamoDataAccess.getTipoPrestamo(connexion,prestamo));
			TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
			tipoprestamoLogic.deepLoad(prestamo.getTipoPrestamo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuota.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setTipoCuota(prestamoDataAccess.getTipoCuota(connexion,prestamo));
			TipoCuotaLogic tipocuotaLogic= new TipoCuotaLogic(connexion);
			tipocuotaLogic.deepLoad(prestamo.getTipoCuota(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			prestamo.setAsientoContable(prestamoDataAccess.getAsientoContable(connexion,prestamo));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(prestamo.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AbonoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AbonoPrestamo.class));
			prestamo.setAbonoPrestamos(prestamoDataAccess.getAbonoPrestamos(connexion,prestamo));

			for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
				AbonoPrestamoLogic abonoprestamoLogic= new AbonoPrestamoLogic(connexion);
				abonoprestamoLogic.deepLoad(abonoprestamo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cuota.class));
			prestamo.setCuotas(prestamoDataAccess.getCuotas(connexion,prestamo));

			for(Cuota cuota:prestamo.getCuotas()) {
				CuotaLogic cuotaLogic= new CuotaLogic(connexion);
				cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Prestamo prestamo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PrestamoLogicAdditional.updatePrestamoToSave(prestamo,this.arrDatoGeneral);
			
PrestamoDataAccess.save(prestamo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(prestamo.getEmpresa(),connexion);

		EmpleadoDataAccess.save(prestamo.getEmpleado(),connexion);

		TipoPrestamoDataAccess.save(prestamo.getTipoPrestamo(),connexion);

		TipoCuotaDataAccess.save(prestamo.getTipoCuota(),connexion);

		AsientoContableDataAccess.save(prestamo.getAsientoContable(),connexion);

		for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
			abonoprestamo.setid_prestamo(prestamo.getId());
			AbonoPrestamoDataAccess.save(abonoprestamo,connexion);
		}

		for(Cuota cuota:prestamo.getCuotas()) {
			cuota.setid_prestamo(prestamo.getId());
			CuotaDataAccess.save(cuota,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(prestamo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(prestamo.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)) {
				TipoPrestamoDataAccess.save(prestamo.getTipoPrestamo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuota.class)) {
				TipoCuotaDataAccess.save(prestamo.getTipoCuota(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(prestamo.getAsientoContable(),connexion);
				continue;
			}


			if(clas.clas.equals(AbonoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
					abonoprestamo.setid_prestamo(prestamo.getId());
					AbonoPrestamoDataAccess.save(abonoprestamo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cuota cuota:prestamo.getCuotas()) {
					cuota.setid_prestamo(prestamo.getId());
					CuotaDataAccess.save(cuota,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(prestamo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(prestamo.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(prestamo.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(prestamo.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoPrestamoDataAccess.save(prestamo.getTipoPrestamo(),connexion);
		TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
		tipoprestamoLogic.deepLoad(prestamo.getTipoPrestamo(),isDeep,deepLoadType,clases);
				

		TipoCuotaDataAccess.save(prestamo.getTipoCuota(),connexion);
		TipoCuotaLogic tipocuotaLogic= new TipoCuotaLogic(connexion);
		tipocuotaLogic.deepLoad(prestamo.getTipoCuota(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(prestamo.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(prestamo.getAsientoContable(),isDeep,deepLoadType,clases);
				

		for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
			AbonoPrestamoLogic abonoprestamoLogic= new AbonoPrestamoLogic(connexion);
			abonoprestamo.setid_prestamo(prestamo.getId());
			AbonoPrestamoDataAccess.save(abonoprestamo,connexion);
			abonoprestamoLogic.deepSave(abonoprestamo,isDeep,deepLoadType,clases);
		}

		for(Cuota cuota:prestamo.getCuotas()) {
			CuotaLogic cuotaLogic= new CuotaLogic(connexion);
			cuota.setid_prestamo(prestamo.getId());
			CuotaDataAccess.save(cuota,connexion);
			cuotaLogic.deepSave(cuota,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(prestamo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(prestamo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(prestamo.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(prestamo.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)) {
				TipoPrestamoDataAccess.save(prestamo.getTipoPrestamo(),connexion);
				TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
				tipoprestamoLogic.deepSave(prestamo.getTipoPrestamo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuota.class)) {
				TipoCuotaDataAccess.save(prestamo.getTipoCuota(),connexion);
				TipoCuotaLogic tipocuotaLogic= new TipoCuotaLogic(connexion);
				tipocuotaLogic.deepSave(prestamo.getTipoCuota(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(prestamo.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(prestamo.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(AbonoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AbonoPrestamo abonoprestamo:prestamo.getAbonoPrestamos()) {
					AbonoPrestamoLogic abonoprestamoLogic= new AbonoPrestamoLogic(connexion);
					abonoprestamo.setid_prestamo(prestamo.getId());
					AbonoPrestamoDataAccess.save(abonoprestamo,connexion);
					abonoprestamoLogic.deepSave(abonoprestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cuota cuota:prestamo.getCuotas()) {
					CuotaLogic cuotaLogic= new CuotaLogic(connexion);
					cuota.setid_prestamo(prestamo.getId());
					CuotaDataAccess.save(cuota,connexion);
					cuotaLogic.deepSave(cuota,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Prestamo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(prestamo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamo);
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
			this.deepLoad(this.prestamo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Prestamo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(prestamos!=null) {
				for(Prestamo prestamo:prestamos) {
					this.deepLoad(prestamo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamos);
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
			if(prestamos!=null) {
				for(Prestamo prestamo:prestamos) {
					this.deepLoad(prestamo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamos);
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
			this.getNewConnexionToDeep(Prestamo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(prestamo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Prestamo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(prestamos!=null) {
				for(Prestamo prestamo:prestamos) {
					this.deepSave(prestamo,isDeep,deepLoadType,clases);
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
			if(prestamos!=null) {
				for(Prestamo prestamo:prestamos) {
					this.deepSave(prestamo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPrestamosFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,PrestamoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrestamosFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,PrestamoConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPrestamosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PrestamoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrestamosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PrestamoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPrestamosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PrestamoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrestamosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PrestamoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPrestamosFK_IdTipoCuotaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuota)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuota= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuota.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuota,PrestamoConstantesFunciones.IDTIPOCUOTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuota);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuota","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrestamosFK_IdTipoCuota(String sFinalQuery,Pagination pagination,Long id_tipo_cuota)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuota= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuota.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuota,PrestamoConstantesFunciones.IDTIPOCUOTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuota);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuota","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPrestamosFK_IdTipoPrestamoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_prestamo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Prestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrestamo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrestamo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prestamo,PrestamoConstantesFunciones.IDTIPOPRESTAMO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrestamo);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPrestamosFK_IdTipoPrestamo(String sFinalQuery,Pagination pagination,Long id_tipo_prestamo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrestamo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrestamo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prestamo,PrestamoConstantesFunciones.IDTIPOPRESTAMO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrestamo);

			PrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(this.prestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PrestamoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PrestamoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Prestamo prestamo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PrestamoConstantesFunciones.ISCONAUDITORIA) {
				if(prestamo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrestamoDataAccess.TABLENAME, prestamo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PrestamoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PrestamoLogic.registrarAuditoriaDetallesPrestamo(connexion,prestamo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(prestamo.getIsDeleted()) {
					/*if(!prestamo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PrestamoDataAccess.TABLENAME, prestamo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PrestamoLogic.registrarAuditoriaDetallesPrestamo(connexion,prestamo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrestamoDataAccess.TABLENAME, prestamo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(prestamo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PrestamoDataAccess.TABLENAME, prestamo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PrestamoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PrestamoLogic.registrarAuditoriaDetallesPrestamo(connexion,prestamo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPrestamo(Connexion connexion,Prestamo prestamo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(prestamo.getIsNew()||!prestamo.getid_empresa().equals(prestamo.getPrestamoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getid_empresa()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getid_empresa().toString();
				}
				if(prestamo.getid_empresa()!=null)
				{
					strValorNuevo=prestamo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getid_empleado().equals(prestamo.getPrestamoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getid_empleado()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getid_empleado().toString();
				}
				if(prestamo.getid_empleado()!=null)
				{
					strValorNuevo=prestamo.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getid_tipo_prestamo().equals(prestamo.getPrestamoOriginal().getid_tipo_prestamo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getid_tipo_prestamo()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getid_tipo_prestamo().toString();
				}
				if(prestamo.getid_tipo_prestamo()!=null)
				{
					strValorNuevo=prestamo.getid_tipo_prestamo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.IDTIPOPRESTAMO,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getid_tipo_cuota().equals(prestamo.getPrestamoOriginal().getid_tipo_cuota()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getid_tipo_cuota()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getid_tipo_cuota().toString();
				}
				if(prestamo.getid_tipo_cuota()!=null)
				{
					strValorNuevo=prestamo.getid_tipo_cuota().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.IDTIPOCUOTA,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getid_asiento_contable().equals(prestamo.getPrestamoOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getid_asiento_contable().toString();
				}
				if(prestamo.getid_asiento_contable()!=null)
				{
					strValorNuevo=prestamo.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getcodigo().equals(prestamo.getPrestamoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getcodigo()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getcodigo();
				}
				if(prestamo.getcodigo()!=null)
				{
					strValorNuevo=prestamo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getnumero_pre_impreso().equals(prestamo.getPrestamoOriginal().getnumero_pre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getnumero_pre_impreso()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getnumero_pre_impreso();
				}
				if(prestamo.getnumero_pre_impreso()!=null)
				{
					strValorNuevo=prestamo.getnumero_pre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getfecha().equals(prestamo.getPrestamoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getfecha()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getfecha().toString();
				}
				if(prestamo.getfecha()!=null)
				{
					strValorNuevo=prestamo.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getmonto().equals(prestamo.getPrestamoOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getmonto()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getmonto().toString();
				}
				if(prestamo.getmonto()!=null)
				{
					strValorNuevo=prestamo.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getnumero_cuotas().equals(prestamo.getPrestamoOriginal().getnumero_cuotas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getnumero_cuotas()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getnumero_cuotas().toString();
				}
				if(prestamo.getnumero_cuotas()!=null)
				{
					strValorNuevo=prestamo.getnumero_cuotas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.NUMEROCUOTAS,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.gettasa().equals(prestamo.getPrestamoOriginal().gettasa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().gettasa()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().gettasa().toString();
				}
				if(prestamo.gettasa()!=null)
				{
					strValorNuevo=prestamo.gettasa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.TASA,strValorActual,strValorNuevo);
			}	
			
			if(prestamo.getIsNew()||!prestamo.getdescripcion().equals(prestamo.getPrestamoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(prestamo.getPrestamoOriginal().getdescripcion()!=null)
				{
					strValorActual=prestamo.getPrestamoOriginal().getdescripcion();
				}
				if(prestamo.getdescripcion()!=null)
				{
					strValorNuevo=prestamo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PrestamoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePrestamoRelacionesWithConnection(Prestamo prestamo,List<AbonoPrestamo> abonoprestamos,List<Cuota> cuotas) throws Exception {

		if(!prestamo.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePrestamoRelacionesBase(prestamo,abonoprestamos,cuotas,true);
		}
	}

	public void savePrestamoRelaciones(Prestamo prestamo,List<AbonoPrestamo> abonoprestamos,List<Cuota> cuotas)throws Exception {

		if(!prestamo.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePrestamoRelacionesBase(prestamo,abonoprestamos,cuotas,false);
		}
	}

	public void savePrestamoRelacionesBase(Prestamo prestamo,List<AbonoPrestamo> abonoprestamos,List<Cuota> cuotas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Prestamo-saveRelacionesWithConnection");}
	
			prestamo.setAbonoPrestamos(abonoprestamos);
			prestamo.setCuotas(cuotas);

			this.setPrestamo(prestamo);

			if(PrestamoLogicAdditional.validarSaveRelaciones(prestamo,this)) {

				PrestamoLogicAdditional.updateRelacionesToSave(prestamo,this);

				if((prestamo.getIsNew()||prestamo.getIsChanged())&&!prestamo.getIsDeleted()) {
					this.savePrestamo();
					this.savePrestamoRelacionesDetalles(abonoprestamos,cuotas);

				} else if(prestamo.getIsDeleted()) {
					this.savePrestamoRelacionesDetalles(abonoprestamos,cuotas);
					this.savePrestamo();
				}

				PrestamoLogicAdditional.updateRelacionesToSaveAfter(prestamo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			AbonoPrestamoConstantesFunciones.InicializarGeneralEntityAuxiliaresAbonoPrestamos(abonoprestamos,true,true);
			CuotaConstantesFunciones.InicializarGeneralEntityAuxiliaresCuotas(cuotas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePrestamoRelacionesDetalles(List<AbonoPrestamo> abonoprestamos,List<Cuota> cuotas)throws Exception {
		try {
	

			Long idPrestamoActual=this.getPrestamo().getId();

			AbonoPrestamoLogic abonoprestamoLogic_Desde_Prestamo=new AbonoPrestamoLogic();
			abonoprestamoLogic_Desde_Prestamo.setAbonoPrestamos(abonoprestamos);

			abonoprestamoLogic_Desde_Prestamo.setConnexion(this.getConnexion());
			abonoprestamoLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

			for(AbonoPrestamo abonoprestamo_Desde_Prestamo:abonoprestamoLogic_Desde_Prestamo.getAbonoPrestamos()) {
				abonoprestamo_Desde_Prestamo.setid_prestamo(idPrestamoActual);
			}

			abonoprestamoLogic_Desde_Prestamo.saveAbonoPrestamos();

			CuotaLogic cuotaLogic_Desde_Prestamo=new CuotaLogic();
			cuotaLogic_Desde_Prestamo.setCuotas(cuotas);

			cuotaLogic_Desde_Prestamo.setConnexion(this.getConnexion());
			cuotaLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

			for(Cuota cuota_Desde_Prestamo:cuotaLogic_Desde_Prestamo.getCuotas()) {
				cuota_Desde_Prestamo.setid_prestamo(idPrestamoActual);
			}

			cuotaLogic_Desde_Prestamo.saveCuotas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PrestamoConstantesFunciones.getClassesRelationshipsOfPrestamo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
