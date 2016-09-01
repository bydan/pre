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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.MesaConstantesFunciones;
import com.bydan.erp.puntoventa.util.MesaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.MesaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.Mesa;
import com.bydan.erp.puntoventa.business.logic.MesaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class MesaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MesaLogic.class);
	
	protected MesaDataAccess mesaDataAccess; 	
	protected Mesa mesa;
	protected List<Mesa> mesas;
	protected Object mesaObject;	
	protected List<Object> mesasObject;
	
	public static ClassValidator<Mesa> mesaValidator = new ClassValidator<Mesa>(Mesa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MesaLogicAdditional mesaLogicAdditional=null;
	
	public MesaLogicAdditional getMesaLogicAdditional() {
		return this.mesaLogicAdditional;
	}
	
	public void setMesaLogicAdditional(MesaLogicAdditional mesaLogicAdditional) {
		try {
			this.mesaLogicAdditional=mesaLogicAdditional;
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
	
	
	
	
	public  MesaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.mesaDataAccess = new MesaDataAccess();
			
			this.mesas= new ArrayList<Mesa>();
			this.mesa= new Mesa();
			
			this.mesaObject=new Object();
			this.mesasObject=new ArrayList<Object>();
				
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
			
			this.mesaDataAccess.setConnexionType(this.connexionType);
			this.mesaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MesaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.mesaDataAccess = new MesaDataAccess();
			this.mesas= new ArrayList<Mesa>();
			this.mesa= new Mesa();
			this.mesaObject=new Object();
			this.mesasObject=new ArrayList<Object>();
			
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
			
			this.mesaDataAccess.setConnexionType(this.connexionType);
			this.mesaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Mesa getMesa() throws Exception {	
		MesaLogicAdditional.checkMesaToGet(mesa,this.datosCliente,this.arrDatoGeneral);
		MesaLogicAdditional.updateMesaToGet(mesa,this.arrDatoGeneral);
		
		return mesa;
	}
		
	public void setMesa(Mesa newMesa) {
		this.mesa = newMesa;
	}
	
	public MesaDataAccess getMesaDataAccess() {
		return mesaDataAccess;
	}
	
	public void setMesaDataAccess(MesaDataAccess newmesaDataAccess) {
		this.mesaDataAccess = newmesaDataAccess;
	}
	
	public List<Mesa> getMesas() throws Exception {		
		this.quitarMesasNulos();
		
		MesaLogicAdditional.checkMesaToGets(mesas,this.datosCliente,this.arrDatoGeneral);
		
		for (Mesa mesaLocal: mesas ) {
			MesaLogicAdditional.updateMesaToGet(mesaLocal,this.arrDatoGeneral);
		}
		
		return mesas;
	}
	
	public void setMesas(List<Mesa> newMesas) {
		this.mesas = newMesas;
	}
	
	public Object getMesaObject() {	
		this.mesaObject=this.mesaDataAccess.getEntityObject();
		return this.mesaObject;
	}
		
	public void setMesaObject(Object newMesaObject) {
		this.mesaObject = newMesaObject;
	}
	
	public List<Object> getMesasObject() {		
		this.mesasObject=this.mesaDataAccess.getEntitiesObject();
		return this.mesasObject;
	}
		
	public void setMesasObject(List<Object> newMesasObject) {
		this.mesasObject = newMesasObject;
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
		
		if(this.mesaDataAccess!=null) {
			this.mesaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			mesaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			mesaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		mesa = new  Mesa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mesa=mesaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mesa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
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
		mesa = new  Mesa();
		  		  
        try {
			
			mesa=mesaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mesa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		mesa = new  Mesa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mesa=mesaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mesa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
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
		mesa = new  Mesa();
		  		  
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
		mesa = new  Mesa();
		  		  
        try {
			
			mesa=mesaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mesa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		mesa = new  Mesa();
		  		  
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
		mesa = new  Mesa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =mesaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mesa = new  Mesa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=mesaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mesa = new  Mesa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =mesaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mesa = new  Mesa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=mesaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mesa = new  Mesa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =mesaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mesa = new  Mesa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=mesaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mesas = new  ArrayList<Mesa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
		mesas = new  ArrayList<Mesa>();
		  		  
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
		mesas = new  ArrayList<Mesa>();
		  		  
        try {			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		mesas = new  ArrayList<Mesa>();
		  		  
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
		mesas = new  ArrayList<Mesa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
		mesas = new  ArrayList<Mesa>();
		  		  
        try {
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
		mesas = new  ArrayList<Mesa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
		mesas = new  ArrayList<Mesa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mesa = new  Mesa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesa=mesaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMesa(mesa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
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
		mesa = new  Mesa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesa=mesaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMesa(mesa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mesas = new  ArrayList<Mesa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
		mesas = new  ArrayList<Mesa>();
		  		  
        try {
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMesasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		mesas = new  ArrayList<Mesa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getTodosMesasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
	
	public  void  getTodosMesas(String sFinalQuery,Pagination pagination)throws Exception {
		mesas = new  ArrayList<Mesa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mesas=mesaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMesa(mesas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMesa(Mesa mesa) throws Exception {
		Boolean estaValidado=false;
		
		if(mesa.getIsNew() || mesa.getIsChanged()) { 
			this.invalidValues = mesaValidator.getInvalidValues(mesa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(mesa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMesa(List<Mesa> Mesas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Mesa mesaLocal:mesas) {				
			estaValidadoObjeto=this.validarGuardarMesa(mesaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMesa(List<Mesa> Mesas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMesa(mesas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMesa(Mesa Mesa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMesa(mesa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Mesa mesa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+mesa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MesaConstantesFunciones.getMesaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"mesa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MesaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MesaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMesaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-saveMesaWithConnection");connexion.begin();			
			
			MesaLogicAdditional.checkMesaToSave(this.mesa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MesaLogicAdditional.updateMesaToSave(this.mesa,this.arrDatoGeneral);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mesa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMesa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMesa(this.mesa)) {
				MesaDataAccess.save(this.mesa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.mesa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MesaLogicAdditional.checkMesaToSaveAfter(this.mesa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMesa();
			
			connexion.commit();			
			
			if(this.mesa.getIsDeleted()) {
				this.mesa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMesa()throws Exception {	
		try {	
			
			MesaLogicAdditional.checkMesaToSave(this.mesa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MesaLogicAdditional.updateMesaToSave(this.mesa,this.arrDatoGeneral);
			
			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mesa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMesa(this.mesa)) {			
				MesaDataAccess.save(this.mesa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.mesa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MesaLogicAdditional.checkMesaToSaveAfter(this.mesa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.mesa.getIsDeleted()) {
				this.mesa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMesasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-saveMesasWithConnection");connexion.begin();			
			
			MesaLogicAdditional.checkMesaToSaves(mesas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMesas();
			
			Boolean validadoTodosMesa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Mesa mesaLocal:mesas) {		
				if(mesaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MesaLogicAdditional.updateMesaToSave(mesaLocal,this.arrDatoGeneral);
	        	
				MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mesaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMesa(mesaLocal)) {
					MesaDataAccess.save(mesaLocal, connexion);				
				} else {
					validadoTodosMesa=false;
				}
			}
			
			if(!validadoTodosMesa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MesaLogicAdditional.checkMesaToSavesAfter(mesas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMesas();
			
			connexion.commit();		
			
			this.quitarMesasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMesas()throws Exception {				
		 try {	
			MesaLogicAdditional.checkMesaToSaves(mesas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMesa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Mesa mesaLocal:mesas) {				
				if(mesaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MesaLogicAdditional.updateMesaToSave(mesaLocal,this.arrDatoGeneral);
	        	
				MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mesaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMesa(mesaLocal)) {				
					MesaDataAccess.save(mesaLocal, connexion);				
				} else {
					validadoTodosMesa=false;
				}
			}
			
			if(!validadoTodosMesa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MesaLogicAdditional.checkMesaToSavesAfter(mesas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMesasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MesaParameterReturnGeneral procesarAccionMesas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Mesa> mesas,MesaParameterReturnGeneral mesaParameterGeneral)throws Exception {
		 try {	
			MesaParameterReturnGeneral mesaReturnGeneral=new MesaParameterReturnGeneral();
	
			MesaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mesas,mesaParameterGeneral,mesaReturnGeneral);
			
			return mesaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MesaParameterReturnGeneral procesarAccionMesasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Mesa> mesas,MesaParameterReturnGeneral mesaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-procesarAccionMesasWithConnection");connexion.begin();			
			
			MesaParameterReturnGeneral mesaReturnGeneral=new MesaParameterReturnGeneral();
	
			MesaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mesas,mesaParameterGeneral,mesaReturnGeneral);
			
			this.connexion.commit();
			
			return mesaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MesaParameterReturnGeneral procesarEventosMesas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Mesa> mesas,Mesa mesa,MesaParameterReturnGeneral mesaParameterGeneral,Boolean isEsNuevoMesa,ArrayList<Classe> clases)throws Exception {
		 try {	
			MesaParameterReturnGeneral mesaReturnGeneral=new MesaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mesaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MesaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mesas,mesa,mesaParameterGeneral,mesaReturnGeneral,isEsNuevoMesa,clases);
			
			return mesaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MesaParameterReturnGeneral procesarEventosMesasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Mesa> mesas,Mesa mesa,MesaParameterReturnGeneral mesaParameterGeneral,Boolean isEsNuevoMesa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-procesarEventosMesasWithConnection");connexion.begin();			
			
			MesaParameterReturnGeneral mesaReturnGeneral=new MesaParameterReturnGeneral();
	
			mesaReturnGeneral.setMesa(mesa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mesaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MesaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mesas,mesa,mesaParameterGeneral,mesaReturnGeneral,isEsNuevoMesa,clases);
			
			this.connexion.commit();
			
			return mesaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MesaParameterReturnGeneral procesarImportacionMesasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MesaParameterReturnGeneral mesaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-procesarImportacionMesasWithConnection");connexion.begin();			
			
			MesaParameterReturnGeneral mesaReturnGeneral=new MesaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.mesas=new ArrayList<Mesa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.mesa=new Mesa();
				
				
				if(conColumnasBase) {this.mesa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.mesa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.mesa.setnombre(arrColumnas[iColumn++]);
				this.mesa.setnumero(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.mesas.add(this.mesa);
			}
			
			this.saveMesas();
			
			this.connexion.commit();
			
			mesaReturnGeneral.setConRetornoEstaProcesado(true);
			mesaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return mesaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMesasEliminados() throws Exception {				
		
		List<Mesa> mesasAux= new ArrayList<Mesa>();
		
		for(Mesa mesa:mesas) {
			if(!mesa.getIsDeleted()) {
				mesasAux.add(mesa);
			}
		}
		
		mesas=mesasAux;
	}
	
	public void quitarMesasNulos() throws Exception {				
		
		List<Mesa> mesasAux= new ArrayList<Mesa>();
		
		for(Mesa mesa : this.mesas) {
			if(mesa==null) {
				mesasAux.add(mesa);
			}
		}
		
		//this.mesas=mesasAux;
		
		this.mesas.removeAll(mesasAux);
	}
	
	public void getSetVersionRowMesaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(mesa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((mesa.getIsDeleted() || (mesa.getIsChanged()&&!mesa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=mesaDataAccess.getSetVersionRowMesa(connexion,mesa.getId());
				
				if(!mesa.getVersionRow().equals(timestamp)) {	
					mesa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				mesa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMesa()throws Exception {	
		
		if(mesa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((mesa.getIsDeleted() || (mesa.getIsChanged()&&!mesa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=mesaDataAccess.getSetVersionRowMesa(connexion,mesa.getId());
			
			try {							
				if(!mesa.getVersionRow().equals(timestamp)) {	
					mesa.setVersionRow(timestamp);
				}
				
				mesa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMesasWithConnection()throws Exception {	
		if(mesas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Mesa mesaAux:mesas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(mesaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mesaAux.getIsDeleted() || (mesaAux.getIsChanged()&&!mesaAux.getIsNew())) {
						
						timestamp=mesaDataAccess.getSetVersionRowMesa(connexion,mesaAux.getId());
						
						if(!mesa.getVersionRow().equals(timestamp)) {	
							mesaAux.setVersionRow(timestamp);
						}
								
						mesaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMesas()throws Exception {	
		if(mesas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Mesa mesaAux:mesas) {
					if(mesaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mesaAux.getIsDeleted() || (mesaAux.getIsChanged()&&!mesaAux.getIsNew())) {
						
						timestamp=mesaDataAccess.getSetVersionRowMesa(connexion,mesaAux.getId());
						
						if(!mesaAux.getVersionRow().equals(timestamp)) {	
							mesaAux.setVersionRow(timestamp);
						}
						
													
						mesaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MesaParameterReturnGeneral cargarCombosLoteForeignKeyMesaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		MesaParameterReturnGeneral  mesaReturnGeneral =new MesaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-cargarCombosLoteForeignKeyMesaWithConnection");connexion.begin();
			
			mesaReturnGeneral =new MesaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mesaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mesaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return mesaReturnGeneral;
	}
	
	public MesaParameterReturnGeneral cargarCombosLoteForeignKeyMesa(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		MesaParameterReturnGeneral  mesaReturnGeneral =new MesaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			mesaReturnGeneral =new MesaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mesaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mesaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return mesaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyMesaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
			CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyMesaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoPuntoVenta.class));
			classes.add(new Classe(FacturaPuntoVenta.class));
			classes.add(new Classe(NotaCreditoPuntoVenta.class));
			classes.add(new Classe(CajeroTurno.class));
											
			

			pedidopuntoventaLogic.setConnexion(this.getConnexion());
			pedidopuntoventaLogic.setDatosCliente(this.datosCliente);
			pedidopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			facturapuntoventaLogic.setConnexion(this.getConnexion());
			facturapuntoventaLogic.setDatosCliente(this.datosCliente);
			facturapuntoventaLogic.setIsConRefrescarForeignKeys(true);

			notacreditopuntoventaLogic.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			notacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			cajeroturnoLogic.setConnexion(this.getConnexion());
			cajeroturnoLogic.setDatosCliente(this.datosCliente);
			cajeroturnoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Mesa mesa:this.mesas) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidopuntoventaLogic.setPedidoPuntoVentas(mesa.pedidopuntoventas);
				pedidopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturapuntoventaLogic.setFacturaPuntoVentas(mesa.facturapuntoventas);
				facturapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(mesa.notacreditopuntoventas);
				notacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajeroturnoLogic.setCajeroTurnos(mesa.cajeroturnos);
				cajeroturnoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Mesa mesa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MesaLogicAdditional.updateMesaToGet(mesa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mesa.setEmpresa(mesaDataAccess.getEmpresa(connexion,mesa));
		mesa.setSucursal(mesaDataAccess.getSucursal(connexion,mesa));
		mesa.setPedidoPuntoVentas(mesaDataAccess.getPedidoPuntoVentas(connexion,mesa));
		mesa.setFacturaPuntoVentas(mesaDataAccess.getFacturaPuntoVentas(connexion,mesa));
		mesa.setNotaCreditoPuntoVentas(mesaDataAccess.getNotaCreditoPuntoVentas(connexion,mesa));
		mesa.setCajeroTurnos(mesaDataAccess.getCajeroTurnos(connexion,mesa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mesa.setEmpresa(mesaDataAccess.getEmpresa(connexion,mesa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mesa.setSucursal(mesaDataAccess.getSucursal(connexion,mesa));
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setPedidoPuntoVentas(mesaDataAccess.getPedidoPuntoVentas(connexion,mesa));

				if(this.isConDeep) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(this.connexion);
					pedidopuntoventaLogic.setPedidoPuntoVentas(mesa.getPedidoPuntoVentas());
					ArrayList<Classe> classesLocal=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventaLogic.getPedidoPuntoVentas());
					mesa.setPedidoPuntoVentas(pedidopuntoventaLogic.getPedidoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setFacturaPuntoVentas(mesaDataAccess.getFacturaPuntoVentas(connexion,mesa));

				if(this.isConDeep) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(this.connexion);
					facturapuntoventaLogic.setFacturaPuntoVentas(mesa.getFacturaPuntoVentas());
					ArrayList<Classe> classesLocal=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventaLogic.getFacturaPuntoVentas());
					mesa.setFacturaPuntoVentas(facturapuntoventaLogic.getFacturaPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setNotaCreditoPuntoVentas(mesaDataAccess.getNotaCreditoPuntoVentas(connexion,mesa));

				if(this.isConDeep) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(this.connexion);
					notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(mesa.getNotaCreditoPuntoVentas());
					ArrayList<Classe> classesLocal=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
					mesa.setNotaCreditoPuntoVentas(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setCajeroTurnos(mesaDataAccess.getCajeroTurnos(connexion,mesa));

				if(this.isConDeep) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(this.connexion);
					cajeroturnoLogic.setCajeroTurnos(mesa.getCajeroTurnos());
					ArrayList<Classe> classesLocal=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajeroturnoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnoLogic.getCajeroTurnos());
					mesa.setCajeroTurnos(cajeroturnoLogic.getCajeroTurnos());
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
			mesa.setEmpresa(mesaDataAccess.getEmpresa(connexion,mesa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mesa.setSucursal(mesaDataAccess.getSucursal(connexion,mesa));
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
			mesa.setPedidoPuntoVentas(mesaDataAccess.getPedidoPuntoVentas(connexion,mesa));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			mesa.setFacturaPuntoVentas(mesaDataAccess.getFacturaPuntoVentas(connexion,mesa));
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
			mesa.setNotaCreditoPuntoVentas(mesaDataAccess.getNotaCreditoPuntoVentas(connexion,mesa));
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
			mesa.setCajeroTurnos(mesaDataAccess.getCajeroTurnos(connexion,mesa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mesa.setEmpresa(mesaDataAccess.getEmpresa(connexion,mesa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mesa.getEmpresa(),isDeep,deepLoadType,clases);
				
		mesa.setSucursal(mesaDataAccess.getSucursal(connexion,mesa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mesa.getSucursal(),isDeep,deepLoadType,clases);
				

		mesa.setPedidoPuntoVentas(mesaDataAccess.getPedidoPuntoVentas(connexion,mesa));

		for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		mesa.setFacturaPuntoVentas(mesaDataAccess.getFacturaPuntoVentas(connexion,mesa));

		for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
		}

		mesa.setNotaCreditoPuntoVentas(mesaDataAccess.getNotaCreditoPuntoVentas(connexion,mesa));

		for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		mesa.setCajeroTurnos(mesaDataAccess.getCajeroTurnos(connexion,mesa));

		for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mesa.setEmpresa(mesaDataAccess.getEmpresa(connexion,mesa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(mesa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mesa.setSucursal(mesaDataAccess.getSucursal(connexion,mesa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(mesa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setPedidoPuntoVentas(mesaDataAccess.getPedidoPuntoVentas(connexion,mesa));

				for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setFacturaPuntoVentas(mesaDataAccess.getFacturaPuntoVentas(connexion,mesa));

				for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setNotaCreditoPuntoVentas(mesaDataAccess.getNotaCreditoPuntoVentas(connexion,mesa));

				for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				mesa.setCajeroTurnos(mesaDataAccess.getCajeroTurnos(connexion,mesa));

				for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
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
			mesa.setEmpresa(mesaDataAccess.getEmpresa(connexion,mesa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(mesa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mesa.setSucursal(mesaDataAccess.getSucursal(connexion,mesa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(mesa.getSucursal(),isDeep,deepLoadType,clases);
				
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
			mesa.setPedidoPuntoVentas(mesaDataAccess.getPedidoPuntoVentas(connexion,mesa));

			for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			mesa.setFacturaPuntoVentas(mesaDataAccess.getFacturaPuntoVentas(connexion,mesa));

			for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
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
			mesa.setNotaCreditoPuntoVentas(mesaDataAccess.getNotaCreditoPuntoVentas(connexion,mesa));

			for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
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
			mesa.setCajeroTurnos(mesaDataAccess.getCajeroTurnos(connexion,mesa));

			for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
				CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
				cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Mesa mesa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MesaLogicAdditional.updateMesaToSave(mesa,this.arrDatoGeneral);
			
MesaDataAccess.save(mesa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(mesa.getEmpresa(),connexion);

		SucursalDataAccess.save(mesa.getSucursal(),connexion);

		for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
			pedidopuntoventa.setid_mesa(mesa.getId());
			PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
		}

		for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
			facturapuntoventa.setid_mesa(mesa.getId());
			FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
		}

		for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
			notacreditopuntoventa.setid_mesa(mesa.getId());
			NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
		}

		for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
			cajeroturno.setid_mesa(mesa.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mesa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mesa.getSucursal(),connexion);
				continue;
			}


			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
					pedidopuntoventa.setid_mesa(mesa.getId());
					PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
					facturapuntoventa.setid_mesa(mesa.getId());
					FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
					notacreditopuntoventa.setid_mesa(mesa.getId());
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
					cajeroturno.setid_mesa(mesa.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(mesa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mesa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(mesa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mesa.getSucursal(),isDeep,deepLoadType,clases);
				

		for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventa.setid_mesa(mesa.getId());
			PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
			pedidopuntoventaLogic.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventa.setid_mesa(mesa.getId());
			FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
			facturapuntoventaLogic.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);
		}

		for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventa.setid_mesa(mesa.getId());
			NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
			notacreditopuntoventaLogic.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturno.setid_mesa(mesa.getId());
			CajeroTurnoDataAccess.save(cajeroturno,connexion);
			cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mesa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(mesa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mesa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(mesa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoPuntoVenta pedidopuntoventa:mesa.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventa.setid_mesa(mesa.getId());
					PedidoPuntoVentaDataAccess.save(pedidopuntoventa,connexion);
					pedidopuntoventaLogic.deepSave(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaPuntoVenta facturapuntoventa:mesa.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventa.setid_mesa(mesa.getId());
					FacturaPuntoVentaDataAccess.save(facturapuntoventa,connexion);
					facturapuntoventaLogic.deepSave(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoPuntoVenta notacreditopuntoventa:mesa.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventa.setid_mesa(mesa.getId());
					NotaCreditoPuntoVentaDataAccess.save(notacreditopuntoventa,connexion);
					notacreditopuntoventaLogic.deepSave(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CajeroTurno cajeroturno:mesa.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturno.setid_mesa(mesa.getId());
					CajeroTurnoDataAccess.save(cajeroturno,connexion);
					cajeroturnoLogic.deepSave(cajeroturno,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Mesa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(mesa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(mesa);
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
			this.deepLoad(this.mesa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Mesa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(mesas!=null) {
				for(Mesa mesa:mesas) {
					this.deepLoad(mesa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(mesas);
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
			if(mesas!=null) {
				for(Mesa mesa:mesas) {
					this.deepLoad(mesa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(mesas);
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
			this.getNewConnexionToDeep(Mesa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(mesa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Mesa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(mesas!=null) {
				for(Mesa mesa:mesas) {
					this.deepSave(mesa,isDeep,deepLoadType,clases);
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
			if(mesas!=null) {
				for(Mesa mesa:mesas) {
					this.deepSave(mesa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMesasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MesaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mesas=mesaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMesasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MesaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mesas=mesaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMesasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Mesa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MesaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mesas=mesaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMesasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MesaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MesaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mesas=mesaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MesaConstantesFunciones.refrescarForeignKeysDescripcionesMesa(this.mesas);
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
			if(MesaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MesaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Mesa mesa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MesaConstantesFunciones.ISCONAUDITORIA) {
				if(mesa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MesaDataAccess.TABLENAME, mesa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MesaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MesaLogic.registrarAuditoriaDetallesMesa(connexion,mesa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(mesa.getIsDeleted()) {
					/*if(!mesa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MesaDataAccess.TABLENAME, mesa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MesaLogic.registrarAuditoriaDetallesMesa(connexion,mesa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MesaDataAccess.TABLENAME, mesa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(mesa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MesaDataAccess.TABLENAME, mesa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MesaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MesaLogic.registrarAuditoriaDetallesMesa(connexion,mesa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMesa(Connexion connexion,Mesa mesa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(mesa.getIsNew()||!mesa.getid_empresa().equals(mesa.getMesaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mesa.getMesaOriginal().getid_empresa()!=null)
				{
					strValorActual=mesa.getMesaOriginal().getid_empresa().toString();
				}
				if(mesa.getid_empresa()!=null)
				{
					strValorNuevo=mesa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MesaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(mesa.getIsNew()||!mesa.getid_sucursal().equals(mesa.getMesaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mesa.getMesaOriginal().getid_sucursal()!=null)
				{
					strValorActual=mesa.getMesaOriginal().getid_sucursal().toString();
				}
				if(mesa.getid_sucursal()!=null)
				{
					strValorNuevo=mesa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MesaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(mesa.getIsNew()||!mesa.getnombre().equals(mesa.getMesaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mesa.getMesaOriginal().getnombre()!=null)
				{
					strValorActual=mesa.getMesaOriginal().getnombre();
				}
				if(mesa.getnombre()!=null)
				{
					strValorNuevo=mesa.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MesaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(mesa.getIsNew()||!mesa.getnumero().equals(mesa.getMesaOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mesa.getMesaOriginal().getnumero()!=null)
				{
					strValorActual=mesa.getMesaOriginal().getnumero().toString();
				}
				if(mesa.getnumero()!=null)
				{
					strValorNuevo=mesa.getnumero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MesaConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMesaRelacionesWithConnection(Mesa mesa,List<PedidoPuntoVenta> pedidopuntoventas,List<FacturaPuntoVenta> facturapuntoventas,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<CajeroTurno> cajeroturnos) throws Exception {

		if(!mesa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMesaRelacionesBase(mesa,pedidopuntoventas,facturapuntoventas,notacreditopuntoventas,cajeroturnos,true);
		}
	}

	public void saveMesaRelaciones(Mesa mesa,List<PedidoPuntoVenta> pedidopuntoventas,List<FacturaPuntoVenta> facturapuntoventas,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<CajeroTurno> cajeroturnos)throws Exception {

		if(!mesa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMesaRelacionesBase(mesa,pedidopuntoventas,facturapuntoventas,notacreditopuntoventas,cajeroturnos,false);
		}
	}

	public void saveMesaRelacionesBase(Mesa mesa,List<PedidoPuntoVenta> pedidopuntoventas,List<FacturaPuntoVenta> facturapuntoventas,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<CajeroTurno> cajeroturnos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Mesa-saveRelacionesWithConnection");}
	
			mesa.setPedidoPuntoVentas(pedidopuntoventas);
			mesa.setFacturaPuntoVentas(facturapuntoventas);
			mesa.setNotaCreditoPuntoVentas(notacreditopuntoventas);
			mesa.setCajeroTurnos(cajeroturnos);

			this.setMesa(mesa);

			if(MesaLogicAdditional.validarSaveRelaciones(mesa,this)) {

				MesaLogicAdditional.updateRelacionesToSave(mesa,this);

				if((mesa.getIsNew()||mesa.getIsChanged())&&!mesa.getIsDeleted()) {
					this.saveMesa();
					this.saveMesaRelacionesDetalles(pedidopuntoventas,facturapuntoventas,notacreditopuntoventas,cajeroturnos);

				} else if(mesa.getIsDeleted()) {
					this.saveMesaRelacionesDetalles(pedidopuntoventas,facturapuntoventas,notacreditopuntoventas,cajeroturnos);
					this.saveMesa();
				}

				MesaLogicAdditional.updateRelacionesToSaveAfter(mesa,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PedidoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoPuntoVentas(pedidopuntoventas,true,true);
			FacturaPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaPuntoVentas(facturapuntoventas,true,true);
			NotaCreditoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoPuntoVentas(notacreditopuntoventas,true,true);
			CajeroTurnoConstantesFunciones.InicializarGeneralEntityAuxiliaresCajeroTurnos(cajeroturnos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveMesaRelacionesDetalles(List<PedidoPuntoVenta> pedidopuntoventas,List<FacturaPuntoVenta> facturapuntoventas,List<NotaCreditoPuntoVenta> notacreditopuntoventas,List<CajeroTurno> cajeroturnos)throws Exception {
		try {
	

			Long idMesaActual=this.getMesa().getId();

			PedidoPuntoVentaLogic pedidopuntoventaLogic_Desde_Mesa=new PedidoPuntoVentaLogic();
			pedidopuntoventaLogic_Desde_Mesa.setPedidoPuntoVentas(pedidopuntoventas);

			pedidopuntoventaLogic_Desde_Mesa.setConnexion(this.getConnexion());
			pedidopuntoventaLogic_Desde_Mesa.setDatosCliente(this.datosCliente);

			for(PedidoPuntoVenta pedidopuntoventa_Desde_Mesa:pedidopuntoventaLogic_Desde_Mesa.getPedidoPuntoVentas()) {
				pedidopuntoventa_Desde_Mesa.setid_mesa(idMesaActual);

				pedidopuntoventaLogic_Desde_Mesa.setPedidoPuntoVenta(pedidopuntoventa_Desde_Mesa);
				pedidopuntoventaLogic_Desde_Mesa.savePedidoPuntoVenta();

				Long idPedidoPuntoVentaActual=pedidopuntoventa_Desde_Mesa.getId();

				DetallePedidoPuntoVentaLogic detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta=new DetallePedidoPuntoVentaLogic();

				if(pedidopuntoventa_Desde_Mesa.getDetallePedidoPuntoVentas()==null){
					pedidopuntoventa_Desde_Mesa.setDetallePedidoPuntoVentas(new ArrayList<DetallePedidoPuntoVenta>());
				}

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDetallePedidoPuntoVentas(pedidopuntoventa_Desde_Mesa.getDetallePedidoPuntoVentas());

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setConnexion(this.getConnexion());
				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.setDatosCliente(this.datosCliente);

				for(DetallePedidoPuntoVenta detallepedidopuntoventa_Desde_PedidoPuntoVenta:detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.getDetallePedidoPuntoVentas()) {
					detallepedidopuntoventa_Desde_PedidoPuntoVenta.setid_pedido_punto_venta(idPedidoPuntoVentaActual);
				}

				detallepedidopuntoventaLogic_Desde_PedidoPuntoVenta.saveDetallePedidoPuntoVentas();
			}


			FacturaPuntoVentaLogic facturapuntoventaLogic_Desde_Mesa=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic_Desde_Mesa.setFacturaPuntoVentas(facturapuntoventas);

			facturapuntoventaLogic_Desde_Mesa.setConnexion(this.getConnexion());
			facturapuntoventaLogic_Desde_Mesa.setDatosCliente(this.datosCliente);

			for(FacturaPuntoVenta facturapuntoventa_Desde_Mesa:facturapuntoventaLogic_Desde_Mesa.getFacturaPuntoVentas()) {
				facturapuntoventa_Desde_Mesa.setid_mesa(idMesaActual);

				facturapuntoventaLogic_Desde_Mesa.setFacturaPuntoVenta(facturapuntoventa_Desde_Mesa);
				facturapuntoventaLogic_Desde_Mesa.saveFacturaPuntoVenta();

				Long idFacturaPuntoVentaActual=facturapuntoventa_Desde_Mesa.getId();

				FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_FacturaPuntoVenta=new FormaPagoPuntoVentaLogic();

				if(facturapuntoventa_Desde_Mesa.getFormaPagoPuntoVentas()==null){
					facturapuntoventa_Desde_Mesa.setFormaPagoPuntoVentas(new ArrayList<FormaPagoPuntoVenta>());
				}

				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setFormaPagoPuntoVentas(facturapuntoventa_Desde_Mesa.getFormaPagoPuntoVentas());

				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setConnexion(this.getConnexion());
				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.setDatosCliente(this.datosCliente);

				for(FormaPagoPuntoVenta formapagopuntoventa_Desde_FacturaPuntoVenta:formapagopuntoventaLogic_Desde_FacturaPuntoVenta.getFormaPagoPuntoVentas()) {
					formapagopuntoventa_Desde_FacturaPuntoVenta.setid_factura_punto_venta(idFacturaPuntoVentaActual);
				}

				formapagopuntoventaLogic_Desde_FacturaPuntoVenta.saveFormaPagoPuntoVentas();

				DetalleFacturaPuntoVentaLogic detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta=new DetalleFacturaPuntoVentaLogic();

				if(facturapuntoventa_Desde_Mesa.getDetalleFacturaPuntoVentas()==null){
					facturapuntoventa_Desde_Mesa.setDetalleFacturaPuntoVentas(new ArrayList<DetalleFacturaPuntoVenta>());
				}

				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setDetalleFacturaPuntoVentas(facturapuntoventa_Desde_Mesa.getDetalleFacturaPuntoVentas());

				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setConnexion(this.getConnexion());
				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.setDatosCliente(this.datosCliente);

				for(DetalleFacturaPuntoVenta detallefacturapuntoventa_Desde_FacturaPuntoVenta:detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.getDetalleFacturaPuntoVentas()) {
					detallefacturapuntoventa_Desde_FacturaPuntoVenta.setid_factura_punto_venta(idFacturaPuntoVentaActual);
				}

				detallefacturapuntoventaLogic_Desde_FacturaPuntoVenta.saveDetalleFacturaPuntoVentas();
			}


			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic_Desde_Mesa=new NotaCreditoPuntoVentaLogic();
			notacreditopuntoventaLogic_Desde_Mesa.setNotaCreditoPuntoVentas(notacreditopuntoventas);

			notacreditopuntoventaLogic_Desde_Mesa.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic_Desde_Mesa.setDatosCliente(this.datosCliente);

			for(NotaCreditoPuntoVenta notacreditopuntoventa_Desde_Mesa:notacreditopuntoventaLogic_Desde_Mesa.getNotaCreditoPuntoVentas()) {
				notacreditopuntoventa_Desde_Mesa.setid_mesa(idMesaActual);

				notacreditopuntoventaLogic_Desde_Mesa.setNotaCreditoPuntoVenta(notacreditopuntoventa_Desde_Mesa);
				notacreditopuntoventaLogic_Desde_Mesa.saveNotaCreditoPuntoVenta();

				Long idNotaCreditoPuntoVentaActual=notacreditopuntoventa_Desde_Mesa.getId();

				DetalleNotaCreditoPuntoVentaLogic detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta=new DetalleNotaCreditoPuntoVentaLogic();

				if(notacreditopuntoventa_Desde_Mesa.getDetalleNotaCreditoPuntoVentas()==null){
					notacreditopuntoventa_Desde_Mesa.setDetalleNotaCreditoPuntoVentas(new ArrayList<DetalleNotaCreditoPuntoVenta>());
				}

				detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.setDetalleNotaCreditoPuntoVentas(notacreditopuntoventa_Desde_Mesa.getDetalleNotaCreditoPuntoVentas());

				detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.setConnexion(this.getConnexion());
				detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.setDatosCliente(this.datosCliente);

				for(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa_Desde_NotaCreditoPuntoVenta:detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.getDetalleNotaCreditoPuntoVentas()) {
					detallenotacreditopuntoventa_Desde_NotaCreditoPuntoVenta.setid_factura_punto_venta(idNotaCreditoPuntoVentaActual);
				}

				detallenotacreditopuntoventaLogic_Desde_NotaCreditoPuntoVenta.saveDetalleNotaCreditoPuntoVentas();
			}


			CajeroTurnoLogic cajeroturnoLogic_Desde_Mesa=new CajeroTurnoLogic();
			cajeroturnoLogic_Desde_Mesa.setCajeroTurnos(cajeroturnos);

			cajeroturnoLogic_Desde_Mesa.setConnexion(this.getConnexion());
			cajeroturnoLogic_Desde_Mesa.setDatosCliente(this.datosCliente);

			for(CajeroTurno cajeroturno_Desde_Mesa:cajeroturnoLogic_Desde_Mesa.getCajeroTurnos()) {
				cajeroturno_Desde_Mesa.setid_mesa(idMesaActual);
			}

			cajeroturnoLogic_Desde_Mesa.saveCajeroTurnos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMesa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MesaConstantesFunciones.getClassesForeignKeysOfMesa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMesa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MesaConstantesFunciones.getClassesRelationshipsOfMesa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
