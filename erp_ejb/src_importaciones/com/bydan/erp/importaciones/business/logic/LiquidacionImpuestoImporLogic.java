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
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.LiquidacionImpuestoImpor;
import com.bydan.erp.importaciones.business.logic.LiquidacionImpuestoImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class LiquidacionImpuestoImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LiquidacionImpuestoImporLogic.class);
	
	protected LiquidacionImpuestoImporDataAccess liquidacionimpuestoimporDataAccess; 	
	protected LiquidacionImpuestoImpor liquidacionimpuestoimpor;
	protected List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors;
	protected Object liquidacionimpuestoimporObject;	
	protected List<Object> liquidacionimpuestoimporsObject;
	
	public static ClassValidator<LiquidacionImpuestoImpor> liquidacionimpuestoimporValidator = new ClassValidator<LiquidacionImpuestoImpor>(LiquidacionImpuestoImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LiquidacionImpuestoImporLogicAdditional liquidacionimpuestoimporLogicAdditional=null;
	
	public LiquidacionImpuestoImporLogicAdditional getLiquidacionImpuestoImporLogicAdditional() {
		return this.liquidacionimpuestoimporLogicAdditional;
	}
	
	public void setLiquidacionImpuestoImporLogicAdditional(LiquidacionImpuestoImporLogicAdditional liquidacionimpuestoimporLogicAdditional) {
		try {
			this.liquidacionimpuestoimporLogicAdditional=liquidacionimpuestoimporLogicAdditional;
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
	
	
	
	
	public  LiquidacionImpuestoImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.liquidacionimpuestoimporDataAccess = new LiquidacionImpuestoImporDataAccess();
			
			this.liquidacionimpuestoimpors= new ArrayList<LiquidacionImpuestoImpor>();
			this.liquidacionimpuestoimpor= new LiquidacionImpuestoImpor();
			
			this.liquidacionimpuestoimporObject=new Object();
			this.liquidacionimpuestoimporsObject=new ArrayList<Object>();
				
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
			
			this.liquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			this.liquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LiquidacionImpuestoImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.liquidacionimpuestoimporDataAccess = new LiquidacionImpuestoImporDataAccess();
			this.liquidacionimpuestoimpors= new ArrayList<LiquidacionImpuestoImpor>();
			this.liquidacionimpuestoimpor= new LiquidacionImpuestoImpor();
			this.liquidacionimpuestoimporObject=new Object();
			this.liquidacionimpuestoimporsObject=new ArrayList<Object>();
			
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
			
			this.liquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			this.liquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LiquidacionImpuestoImpor getLiquidacionImpuestoImpor() throws Exception {	
		LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToGet(liquidacionimpuestoimpor,this.datosCliente,this.arrDatoGeneral);
		LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToGet(liquidacionimpuestoimpor,this.arrDatoGeneral);
		
		return liquidacionimpuestoimpor;
	}
		
	public void setLiquidacionImpuestoImpor(LiquidacionImpuestoImpor newLiquidacionImpuestoImpor) {
		this.liquidacionimpuestoimpor = newLiquidacionImpuestoImpor;
	}
	
	public LiquidacionImpuestoImporDataAccess getLiquidacionImpuestoImporDataAccess() {
		return liquidacionimpuestoimporDataAccess;
	}
	
	public void setLiquidacionImpuestoImporDataAccess(LiquidacionImpuestoImporDataAccess newliquidacionimpuestoimporDataAccess) {
		this.liquidacionimpuestoimporDataAccess = newliquidacionimpuestoimporDataAccess;
	}
	
	public List<LiquidacionImpuestoImpor> getLiquidacionImpuestoImpors() throws Exception {		
		this.quitarLiquidacionImpuestoImporsNulos();
		
		LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToGets(liquidacionimpuestoimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (LiquidacionImpuestoImpor liquidacionimpuestoimporLocal: liquidacionimpuestoimpors ) {
			LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToGet(liquidacionimpuestoimporLocal,this.arrDatoGeneral);
		}
		
		return liquidacionimpuestoimpors;
	}
	
	public void setLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> newLiquidacionImpuestoImpors) {
		this.liquidacionimpuestoimpors = newLiquidacionImpuestoImpors;
	}
	
	public Object getLiquidacionImpuestoImporObject() {	
		this.liquidacionimpuestoimporObject=this.liquidacionimpuestoimporDataAccess.getEntityObject();
		return this.liquidacionimpuestoimporObject;
	}
		
	public void setLiquidacionImpuestoImporObject(Object newLiquidacionImpuestoImporObject) {
		this.liquidacionimpuestoimporObject = newLiquidacionImpuestoImporObject;
	}
	
	public List<Object> getLiquidacionImpuestoImporsObject() {		
		this.liquidacionimpuestoimporsObject=this.liquidacionimpuestoimporDataAccess.getEntitiesObject();
		return this.liquidacionimpuestoimporsObject;
	}
		
	public void setLiquidacionImpuestoImporsObject(List<Object> newLiquidacionImpuestoImporsObject) {
		this.liquidacionimpuestoimporsObject = newLiquidacionImpuestoImporsObject;
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
		
		if(this.liquidacionimpuestoimporDataAccess!=null) {
			this.liquidacionimpuestoimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			liquidacionimpuestoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			liquidacionimpuestoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  		  
        try {
			
			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  		  
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  		  
        try {
			
			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  		  
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =liquidacionimpuestoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=liquidacionimpuestoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =liquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=liquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =liquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=liquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
        try {			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
        try {
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
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
		liquidacionimpuestoimpor = new  LiquidacionImpuestoImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		  		  
        try {
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosLiquidacionImpuestoImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getTodosLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
	
	public  void  getTodosLiquidacionImpuestoImpors(String sFinalQuery,Pagination pagination)throws Exception {
		liquidacionimpuestoimpors = new  ArrayList<LiquidacionImpuestoImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(liquidacionimpuestoimpor.getIsNew() || liquidacionimpuestoimpor.getIsChanged()) { 
			this.invalidValues = liquidacionimpuestoimporValidator.getInvalidValues(liquidacionimpuestoimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(liquidacionimpuestoimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> LiquidacionImpuestoImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimporLocal:liquidacionimpuestoimpors) {				
			estaValidadoObjeto=this.validarGuardarLiquidacionImpuestoImpor(liquidacionimpuestoimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLiquidacionImpuestoImpor(List<LiquidacionImpuestoImpor> LiquidacionImpuestoImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLiquidacionImpuestoImpor(liquidacionimpuestoimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLiquidacionImpuestoImpor(LiquidacionImpuestoImpor LiquidacionImpuestoImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLiquidacionImpuestoImpor(liquidacionimpuestoimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LiquidacionImpuestoImpor liquidacionimpuestoimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+liquidacionimpuestoimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LiquidacionImpuestoImporConstantesFunciones.getLiquidacionImpuestoImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"liquidacionimpuestoimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LiquidacionImpuestoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LiquidacionImpuestoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLiquidacionImpuestoImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-saveLiquidacionImpuestoImporWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSave(this.liquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToSave(this.liquidacionimpuestoimpor,this.arrDatoGeneral);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.liquidacionimpuestoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLiquidacionImpuestoImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor)) {
				LiquidacionImpuestoImporDataAccess.save(this.liquidacionimpuestoimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.liquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSaveAfter(this.liquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLiquidacionImpuestoImpor();
			
			connexion.commit();			
			
			if(this.liquidacionimpuestoimpor.getIsDeleted()) {
				this.liquidacionimpuestoimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLiquidacionImpuestoImpor()throws Exception {	
		try {	
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSave(this.liquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToSave(this.liquidacionimpuestoimpor,this.arrDatoGeneral);
			
			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.liquidacionimpuestoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor)) {			
				LiquidacionImpuestoImporDataAccess.save(this.liquidacionimpuestoimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.liquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSaveAfter(this.liquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.liquidacionimpuestoimpor.getIsDeleted()) {
				this.liquidacionimpuestoimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLiquidacionImpuestoImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-saveLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSaves(liquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLiquidacionImpuestoImpors();
			
			Boolean validadoTodosLiquidacionImpuestoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LiquidacionImpuestoImpor liquidacionimpuestoimporLocal:liquidacionimpuestoimpors) {		
				if(liquidacionimpuestoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToSave(liquidacionimpuestoimporLocal,this.arrDatoGeneral);
	        	
				LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),liquidacionimpuestoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLiquidacionImpuestoImpor(liquidacionimpuestoimporLocal)) {
					LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimporLocal, connexion);				
				} else {
					validadoTodosLiquidacionImpuestoImpor=false;
				}
			}
			
			if(!validadoTodosLiquidacionImpuestoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSavesAfter(liquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLiquidacionImpuestoImpors();
			
			connexion.commit();		
			
			this.quitarLiquidacionImpuestoImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLiquidacionImpuestoImpors()throws Exception {				
		 try {	
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSaves(liquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLiquidacionImpuestoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LiquidacionImpuestoImpor liquidacionimpuestoimporLocal:liquidacionimpuestoimpors) {				
				if(liquidacionimpuestoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToSave(liquidacionimpuestoimporLocal,this.arrDatoGeneral);
	        	
				LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),liquidacionimpuestoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLiquidacionImpuestoImpor(liquidacionimpuestoimporLocal)) {				
					LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimporLocal, connexion);				
				} else {
					validadoTodosLiquidacionImpuestoImpor=false;
				}
			}
			
			if(!validadoTodosLiquidacionImpuestoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LiquidacionImpuestoImporLogicAdditional.checkLiquidacionImpuestoImporToSavesAfter(liquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLiquidacionImpuestoImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LiquidacionImpuestoImporParameterReturnGeneral procesarAccionLiquidacionImpuestoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporParameterGeneral)throws Exception {
		 try {	
			LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporReturnGeneral=new LiquidacionImpuestoImporParameterReturnGeneral();
	
			LiquidacionImpuestoImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,liquidacionimpuestoimpors,liquidacionimpuestoimporParameterGeneral,liquidacionimpuestoimporReturnGeneral);
			
			return liquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LiquidacionImpuestoImporParameterReturnGeneral procesarAccionLiquidacionImpuestoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-procesarAccionLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporReturnGeneral=new LiquidacionImpuestoImporParameterReturnGeneral();
	
			LiquidacionImpuestoImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,liquidacionimpuestoimpors,liquidacionimpuestoimporParameterGeneral,liquidacionimpuestoimporReturnGeneral);
			
			this.connexion.commit();
			
			return liquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LiquidacionImpuestoImporParameterReturnGeneral procesarEventosLiquidacionImpuestoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImpor liquidacionimpuestoimpor,LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporParameterGeneral,Boolean isEsNuevoLiquidacionImpuestoImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporReturnGeneral=new LiquidacionImpuestoImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				liquidacionimpuestoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LiquidacionImpuestoImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,liquidacionimpuestoimpors,liquidacionimpuestoimpor,liquidacionimpuestoimporParameterGeneral,liquidacionimpuestoimporReturnGeneral,isEsNuevoLiquidacionImpuestoImpor,clases);
			
			return liquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LiquidacionImpuestoImporParameterReturnGeneral procesarEventosLiquidacionImpuestoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,LiquidacionImpuestoImpor liquidacionimpuestoimpor,LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporParameterGeneral,Boolean isEsNuevoLiquidacionImpuestoImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-procesarEventosLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporReturnGeneral=new LiquidacionImpuestoImporParameterReturnGeneral();
	
			liquidacionimpuestoimporReturnGeneral.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				liquidacionimpuestoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LiquidacionImpuestoImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,liquidacionimpuestoimpors,liquidacionimpuestoimpor,liquidacionimpuestoimporParameterGeneral,liquidacionimpuestoimporReturnGeneral,isEsNuevoLiquidacionImpuestoImpor,clases);
			
			this.connexion.commit();
			
			return liquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LiquidacionImpuestoImporParameterReturnGeneral procesarImportacionLiquidacionImpuestoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-procesarImportacionLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			LiquidacionImpuestoImporParameterReturnGeneral liquidacionimpuestoimporReturnGeneral=new LiquidacionImpuestoImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.liquidacionimpuestoimpors=new ArrayList<LiquidacionImpuestoImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.liquidacionimpuestoimpor=new LiquidacionImpuestoImpor();
				
				
				if(conColumnasBase) {this.liquidacionimpuestoimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.liquidacionimpuestoimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.liquidacionimpuestoimpor.setnumero_comprobante(arrColumnas[iColumn++]);
				this.liquidacionimpuestoimpor.setnumero_dui(arrColumnas[iColumn++]);
				this.liquidacionimpuestoimpor.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setfecha_pago(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setfob(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setseguro(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setporcentaje_fodi(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setporcentaje_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.settasa_control(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setcfr(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.setcif(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpuestoimpor.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.liquidacionimpuestoimpors.add(this.liquidacionimpuestoimpor);
			}
			
			this.saveLiquidacionImpuestoImpors();
			
			this.connexion.commit();
			
			liquidacionimpuestoimporReturnGeneral.setConRetornoEstaProcesado(true);
			liquidacionimpuestoimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return liquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLiquidacionImpuestoImporsEliminados() throws Exception {				
		
		List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsAux= new ArrayList<LiquidacionImpuestoImpor>();
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors) {
			if(!liquidacionimpuestoimpor.getIsDeleted()) {
				liquidacionimpuestoimporsAux.add(liquidacionimpuestoimpor);
			}
		}
		
		liquidacionimpuestoimpors=liquidacionimpuestoimporsAux;
	}
	
	public void quitarLiquidacionImpuestoImporsNulos() throws Exception {				
		
		List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsAux= new ArrayList<LiquidacionImpuestoImpor>();
		
		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor : this.liquidacionimpuestoimpors) {
			if(liquidacionimpuestoimpor==null) {
				liquidacionimpuestoimporsAux.add(liquidacionimpuestoimpor);
			}
		}
		
		//this.liquidacionimpuestoimpors=liquidacionimpuestoimporsAux;
		
		this.liquidacionimpuestoimpors.removeAll(liquidacionimpuestoimporsAux);
	}
	
	public void getSetVersionRowLiquidacionImpuestoImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(liquidacionimpuestoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((liquidacionimpuestoimpor.getIsDeleted() || (liquidacionimpuestoimpor.getIsChanged()&&!liquidacionimpuestoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=liquidacionimpuestoimporDataAccess.getSetVersionRowLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimpor.getId());
				
				if(!liquidacionimpuestoimpor.getVersionRow().equals(timestamp)) {	
					liquidacionimpuestoimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				liquidacionimpuestoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLiquidacionImpuestoImpor()throws Exception {	
		
		if(liquidacionimpuestoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((liquidacionimpuestoimpor.getIsDeleted() || (liquidacionimpuestoimpor.getIsChanged()&&!liquidacionimpuestoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=liquidacionimpuestoimporDataAccess.getSetVersionRowLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimpor.getId());
			
			try {							
				if(!liquidacionimpuestoimpor.getVersionRow().equals(timestamp)) {	
					liquidacionimpuestoimpor.setVersionRow(timestamp);
				}
				
				liquidacionimpuestoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLiquidacionImpuestoImporsWithConnection()throws Exception {	
		if(liquidacionimpuestoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LiquidacionImpuestoImpor liquidacionimpuestoimporAux:liquidacionimpuestoimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(liquidacionimpuestoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(liquidacionimpuestoimporAux.getIsDeleted() || (liquidacionimpuestoimporAux.getIsChanged()&&!liquidacionimpuestoimporAux.getIsNew())) {
						
						timestamp=liquidacionimpuestoimporDataAccess.getSetVersionRowLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimporAux.getId());
						
						if(!liquidacionimpuestoimpor.getVersionRow().equals(timestamp)) {	
							liquidacionimpuestoimporAux.setVersionRow(timestamp);
						}
								
						liquidacionimpuestoimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLiquidacionImpuestoImpors()throws Exception {	
		if(liquidacionimpuestoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LiquidacionImpuestoImpor liquidacionimpuestoimporAux:liquidacionimpuestoimpors) {
					if(liquidacionimpuestoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(liquidacionimpuestoimporAux.getIsDeleted() || (liquidacionimpuestoimporAux.getIsChanged()&&!liquidacionimpuestoimporAux.getIsNew())) {
						
						timestamp=liquidacionimpuestoimporDataAccess.getSetVersionRowLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimporAux.getId());
						
						if(!liquidacionimpuestoimporAux.getVersionRow().equals(timestamp)) {	
							liquidacionimpuestoimporAux.setVersionRow(timestamp);
						}
						
													
						liquidacionimpuestoimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LiquidacionImpuestoImporParameterReturnGeneral cargarCombosLoteForeignKeyLiquidacionImpuestoImporWithConnection(String finalQueryGlobalPedidoCompraImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalFactura) throws Exception {
		LiquidacionImpuestoImporParameterReturnGeneral  liquidacionimpuestoimporReturnGeneral =new LiquidacionImpuestoImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyLiquidacionImpuestoImporWithConnection");connexion.begin();
			
			liquidacionimpuestoimporReturnGeneral =new LiquidacionImpuestoImporParameterReturnGeneral();
			
			

			List<PedidoCompraImpor> pedidocompraimporsForeignKey=new ArrayList<PedidoCompraImpor>();
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			pedidocompraimporLogic.setConnexion(this.connexion);
			pedidocompraimporLogic.getPedidoCompraImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompraImpor.equals("NONE")) {
				pedidocompraimporLogic.getTodosPedidoCompraImpors(finalQueryGlobalPedidoCompraImpor,new Pagination());
				pedidocompraimporsForeignKey=pedidocompraimporLogic.getPedidoCompraImpors();
			}

			liquidacionimpuestoimporReturnGeneral.setpedidocompraimporsForeignKey(pedidocompraimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			liquidacionimpuestoimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			liquidacionimpuestoimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			liquidacionimpuestoimporReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			liquidacionimpuestoimporReturnGeneral.setfacturasForeignKey(facturasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return liquidacionimpuestoimporReturnGeneral;
	}
	
	public LiquidacionImpuestoImporParameterReturnGeneral cargarCombosLoteForeignKeyLiquidacionImpuestoImpor(String finalQueryGlobalPedidoCompraImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalFactura) throws Exception {
		LiquidacionImpuestoImporParameterReturnGeneral  liquidacionimpuestoimporReturnGeneral =new LiquidacionImpuestoImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			liquidacionimpuestoimporReturnGeneral =new LiquidacionImpuestoImporParameterReturnGeneral();
			
			

			List<PedidoCompraImpor> pedidocompraimporsForeignKey=new ArrayList<PedidoCompraImpor>();
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			pedidocompraimporLogic.setConnexion(this.connexion);
			pedidocompraimporLogic.getPedidoCompraImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompraImpor.equals("NONE")) {
				pedidocompraimporLogic.getTodosPedidoCompraImpors(finalQueryGlobalPedidoCompraImpor,new Pagination());
				pedidocompraimporsForeignKey=pedidocompraimporLogic.getPedidoCompraImpors();
			}

			liquidacionimpuestoimporReturnGeneral.setpedidocompraimporsForeignKey(pedidocompraimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			liquidacionimpuestoimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			liquidacionimpuestoimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			liquidacionimpuestoimporReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			liquidacionimpuestoimporReturnGeneral.setfacturasForeignKey(facturasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return liquidacionimpuestoimporReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyLiquidacionImpuestoImporWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic=new DetalleLiquidacionImpuestoImporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyLiquidacionImpuestoImporWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleLiquidacionImpuestoImpor.class));
											
			

			detalleliquidacionimpuestoimporLogic.setConnexion(this.getConnexion());
			detalleliquidacionimpuestoimporLogic.setDatosCliente(this.datosCliente);
			detalleliquidacionimpuestoimporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:this.liquidacionimpuestoimpors) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleLiquidacionImpuestoImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpuestoImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleliquidacionimpuestoimporLogic.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimpor.detalleliquidacionimpuestoimpors);
				detalleliquidacionimpuestoimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(LiquidacionImpuestoImpor liquidacionimpuestoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToGet(liquidacionimpuestoimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		liquidacionimpuestoimpor.setPedidoCompraImpor(liquidacionimpuestoimporDataAccess.getPedidoCompraImpor(connexion,liquidacionimpuestoimpor));
		liquidacionimpuestoimpor.setEmpresa(liquidacionimpuestoimporDataAccess.getEmpresa(connexion,liquidacionimpuestoimpor));
		liquidacionimpuestoimpor.setSucursal(liquidacionimpuestoimporDataAccess.getSucursal(connexion,liquidacionimpuestoimpor));
		liquidacionimpuestoimpor.setCliente(liquidacionimpuestoimporDataAccess.getCliente(connexion,liquidacionimpuestoimpor));
		liquidacionimpuestoimpor.setFactura(liquidacionimpuestoimporDataAccess.getFactura(connexion,liquidacionimpuestoimpor));
		liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimporDataAccess.getDetalleLiquidacionImpuestoImpors(connexion,liquidacionimpuestoimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				liquidacionimpuestoimpor.setPedidoCompraImpor(liquidacionimpuestoimporDataAccess.getPedidoCompraImpor(connexion,liquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				liquidacionimpuestoimpor.setEmpresa(liquidacionimpuestoimporDataAccess.getEmpresa(connexion,liquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				liquidacionimpuestoimpor.setSucursal(liquidacionimpuestoimporDataAccess.getSucursal(connexion,liquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				liquidacionimpuestoimpor.setCliente(liquidacionimpuestoimporDataAccess.getCliente(connexion,liquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				liquidacionimpuestoimpor.setFactura(liquidacionimpuestoimporDataAccess.getFactura(connexion,liquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimporDataAccess.getDetalleLiquidacionImpuestoImpors(connexion,liquidacionimpuestoimpor));

				if(this.isConDeep) {
					DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic= new DetalleLiquidacionImpuestoImporLogic(this.connexion);
					detalleliquidacionimpuestoimporLogic.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors());
					ArrayList<Classe> classesLocal=DetalleLiquidacionImpuestoImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpuestoImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleliquidacionimpuestoimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporLogic.getDetalleLiquidacionImpuestoImpors());
					liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(detalleliquidacionimpuestoimporLogic.getDetalleLiquidacionImpuestoImpors());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setPedidoCompraImpor(liquidacionimpuestoimporDataAccess.getPedidoCompraImpor(connexion,liquidacionimpuestoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setEmpresa(liquidacionimpuestoimporDataAccess.getEmpresa(connexion,liquidacionimpuestoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setSucursal(liquidacionimpuestoimporDataAccess.getSucursal(connexion,liquidacionimpuestoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setCliente(liquidacionimpuestoimporDataAccess.getCliente(connexion,liquidacionimpuestoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setFactura(liquidacionimpuestoimporDataAccess.getFactura(connexion,liquidacionimpuestoimpor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpuestoImpor.class));
			liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimporDataAccess.getDetalleLiquidacionImpuestoImpors(connexion,liquidacionimpuestoimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		liquidacionimpuestoimpor.setPedidoCompraImpor(liquidacionimpuestoimporDataAccess.getPedidoCompraImpor(connexion,liquidacionimpuestoimpor));
		PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
		pedidocompraimporLogic.deepLoad(liquidacionimpuestoimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);
				
		liquidacionimpuestoimpor.setEmpresa(liquidacionimpuestoimporDataAccess.getEmpresa(connexion,liquidacionimpuestoimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(liquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		liquidacionimpuestoimpor.setSucursal(liquidacionimpuestoimporDataAccess.getSucursal(connexion,liquidacionimpuestoimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(liquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		liquidacionimpuestoimpor.setCliente(liquidacionimpuestoimporDataAccess.getCliente(connexion,liquidacionimpuestoimpor));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(liquidacionimpuestoimpor.getCliente(),isDeep,deepLoadType,clases);
				
		liquidacionimpuestoimpor.setFactura(liquidacionimpuestoimporDataAccess.getFactura(connexion,liquidacionimpuestoimpor));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(liquidacionimpuestoimpor.getFactura(),isDeep,deepLoadType,clases);
				

		liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimporDataAccess.getDetalleLiquidacionImpuestoImpors(connexion,liquidacionimpuestoimpor));

		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
			DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic= new DetalleLiquidacionImpuestoImporLogic(connexion);
			detalleliquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				liquidacionimpuestoimpor.setPedidoCompraImpor(liquidacionimpuestoimporDataAccess.getPedidoCompraImpor(connexion,liquidacionimpuestoimpor));
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepLoad(liquidacionimpuestoimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				liquidacionimpuestoimpor.setEmpresa(liquidacionimpuestoimporDataAccess.getEmpresa(connexion,liquidacionimpuestoimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(liquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				liquidacionimpuestoimpor.setSucursal(liquidacionimpuestoimporDataAccess.getSucursal(connexion,liquidacionimpuestoimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(liquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				liquidacionimpuestoimpor.setCliente(liquidacionimpuestoimporDataAccess.getCliente(connexion,liquidacionimpuestoimpor));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(liquidacionimpuestoimpor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				liquidacionimpuestoimpor.setFactura(liquidacionimpuestoimporDataAccess.getFactura(connexion,liquidacionimpuestoimpor));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(liquidacionimpuestoimpor.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimporDataAccess.getDetalleLiquidacionImpuestoImpors(connexion,liquidacionimpuestoimpor));

				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
					DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic= new DetalleLiquidacionImpuestoImporLogic(connexion);
					detalleliquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setPedidoCompraImpor(liquidacionimpuestoimporDataAccess.getPedidoCompraImpor(connexion,liquidacionimpuestoimpor));
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimporLogic.deepLoad(liquidacionimpuestoimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setEmpresa(liquidacionimpuestoimporDataAccess.getEmpresa(connexion,liquidacionimpuestoimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(liquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setSucursal(liquidacionimpuestoimporDataAccess.getSucursal(connexion,liquidacionimpuestoimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(liquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setCliente(liquidacionimpuestoimporDataAccess.getCliente(connexion,liquidacionimpuestoimpor));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(liquidacionimpuestoimpor.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpuestoimpor.setFactura(liquidacionimpuestoimporDataAccess.getFactura(connexion,liquidacionimpuestoimpor));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(liquidacionimpuestoimpor.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpuestoImpor.class));
			liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimporDataAccess.getDetalleLiquidacionImpuestoImpors(connexion,liquidacionimpuestoimpor));

			for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
				DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic= new DetalleLiquidacionImpuestoImporLogic(connexion);
				detalleliquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LiquidacionImpuestoImpor liquidacionimpuestoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			LiquidacionImpuestoImporLogicAdditional.updateLiquidacionImpuestoImporToSave(liquidacionimpuestoimpor,this.arrDatoGeneral);
			
LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoCompraImporDataAccess.save(liquidacionimpuestoimpor.getPedidoCompraImpor(),connexion);

		EmpresaDataAccess.save(liquidacionimpuestoimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(liquidacionimpuestoimpor.getSucursal(),connexion);

		ClienteDataAccess.save(liquidacionimpuestoimpor.getCliente(),connexion);

		FacturaDataAccess.save(liquidacionimpuestoimpor.getFactura(),connexion);

		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
			detalleliquidacionimpuestoimpor.setid_liquidacion_impuesto_impor(liquidacionimpuestoimpor.getId());
			DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				PedidoCompraImporDataAccess.save(liquidacionimpuestoimpor.getPedidoCompraImpor(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(liquidacionimpuestoimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(liquidacionimpuestoimpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(liquidacionimpuestoimpor.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(liquidacionimpuestoimpor.getFactura(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
					detalleliquidacionimpuestoimpor.setid_liquidacion_impuesto_impor(liquidacionimpuestoimpor.getId());
					DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoCompraImporDataAccess.save(liquidacionimpuestoimpor.getPedidoCompraImpor(),connexion);
		PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
		pedidocompraimporLogic.deepLoad(liquidacionimpuestoimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(liquidacionimpuestoimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(liquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(liquidacionimpuestoimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(liquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(liquidacionimpuestoimpor.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(liquidacionimpuestoimpor.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(liquidacionimpuestoimpor.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(liquidacionimpuestoimpor.getFactura(),isDeep,deepLoadType,clases);
				

		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
			DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic= new DetalleLiquidacionImpuestoImporLogic(connexion);
			detalleliquidacionimpuestoimpor.setid_liquidacion_impuesto_impor(liquidacionimpuestoimpor.getId());
			DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor,connexion);
			detalleliquidacionimpuestoimporLogic.deepSave(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				PedidoCompraImporDataAccess.save(liquidacionimpuestoimpor.getPedidoCompraImpor(),connexion);
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepSave(liquidacionimpuestoimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(liquidacionimpuestoimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(liquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(liquidacionimpuestoimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(liquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(liquidacionimpuestoimpor.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(liquidacionimpuestoimpor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(liquidacionimpuestoimpor.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(liquidacionimpuestoimpor.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleLiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:liquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImpors()) {
					DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic= new DetalleLiquidacionImpuestoImporLogic(connexion);
					detalleliquidacionimpuestoimpor.setid_liquidacion_impuesto_impor(liquidacionimpuestoimpor.getId());
					DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor,connexion);
					detalleliquidacionimpuestoimporLogic.deepSave(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(LiquidacionImpuestoImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(liquidacionimpuestoimpor);
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
			this.deepLoad(this.liquidacionimpuestoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LiquidacionImpuestoImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(liquidacionimpuestoimpors!=null) {
				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors) {
					this.deepLoad(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
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
			if(liquidacionimpuestoimpors!=null) {
				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors) {
					this.deepLoad(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(liquidacionimpuestoimpors);
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
			this.getNewConnexionToDeep(LiquidacionImpuestoImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(LiquidacionImpuestoImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(liquidacionimpuestoimpors!=null) {
				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors) {
					this.deepSave(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
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
			if(liquidacionimpuestoimpors!=null) {
				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:liquidacionimpuestoimpors) {
					this.deepSave(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getLiquidacionImpuestoImporsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,LiquidacionImpuestoImporConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,LiquidacionImpuestoImporConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdPedidoCompraImporWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_compra_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompraImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompraImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra_impor,LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompraImpor);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompraImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdPedidoCompraImpor(String sFinalQuery,Pagination pagination,Long id_pedido_compra_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompraImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompraImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra_impor,LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompraImpor);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompraImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImpuestoImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			LiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(this.liquidacionimpuestoimpors);
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
			if(LiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImpuestoImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LiquidacionImpuestoImpor liquidacionimpuestoimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIA) {
				if(liquidacionimpuestoimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImpuestoImporDataAccess.TABLENAME, liquidacionimpuestoimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LiquidacionImpuestoImporLogic.registrarAuditoriaDetallesLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(liquidacionimpuestoimpor.getIsDeleted()) {
					/*if(!liquidacionimpuestoimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LiquidacionImpuestoImporDataAccess.TABLENAME, liquidacionimpuestoimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LiquidacionImpuestoImporLogic.registrarAuditoriaDetallesLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImpuestoImporDataAccess.TABLENAME, liquidacionimpuestoimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(liquidacionimpuestoimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImpuestoImporDataAccess.TABLENAME, liquidacionimpuestoimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LiquidacionImpuestoImporLogic.registrarAuditoriaDetallesLiquidacionImpuestoImpor(connexion,liquidacionimpuestoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLiquidacionImpuestoImpor(Connexion connexion,LiquidacionImpuestoImpor liquidacionimpuestoimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getid_pedido_compra_impor().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_pedido_compra_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_pedido_compra_impor()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_pedido_compra_impor().toString();
				}
				if(liquidacionimpuestoimpor.getid_pedido_compra_impor()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getid_pedido_compra_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getid_empresa().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_empresa()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_empresa().toString();
				}
				if(liquidacionimpuestoimpor.getid_empresa()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getid_sucursal().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_sucursal().toString();
				}
				if(liquidacionimpuestoimpor.getid_sucursal()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getid_cliente().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_cliente()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_cliente().toString();
				}
				if(liquidacionimpuestoimpor.getid_cliente()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getid_factura().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_factura()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getid_factura().toString();
				}
				if(liquidacionimpuestoimpor.getid_factura()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getnumero_comprobante().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getnumero_comprobante();
				}
				if(liquidacionimpuestoimpor.getnumero_comprobante()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getnumero_dui().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getnumero_dui()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getnumero_dui()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getnumero_dui();
				}
				if(liquidacionimpuestoimpor.getnumero_dui()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getnumero_dui() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.NUMERODUI,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getfecha().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfecha()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfecha().toString();
				}
				if(liquidacionimpuestoimpor.getfecha()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getfecha_pago().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfecha_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfecha_pago()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfecha_pago().toString();
				}
				if(liquidacionimpuestoimpor.getfecha_pago()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getfecha_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.FECHAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getfob().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfob()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfob()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getfob().toString();
				}
				if(liquidacionimpuestoimpor.getfob()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getfob().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.FOB,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getseguro().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getseguro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getseguro()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getseguro().toString();
				}
				if(liquidacionimpuestoimpor.getseguro()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getseguro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.SEGURO,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getflete().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getflete()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getflete().toString();
				}
				if(liquidacionimpuestoimpor.getflete()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getporcentaje_fodi().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getporcentaje_fodi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getporcentaje_fodi()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getporcentaje_fodi().toString();
				}
				if(liquidacionimpuestoimpor.getporcentaje_fodi()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getporcentaje_fodi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getporcentaje_iva().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getporcentaje_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getporcentaje_iva()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getporcentaje_iva().toString();
				}
				if(liquidacionimpuestoimpor.getporcentaje_iva()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getporcentaje_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.gettasa_control().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().gettasa_control()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().gettasa_control()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().gettasa_control().toString();
				}
				if(liquidacionimpuestoimpor.gettasa_control()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.gettasa_control().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.TASACONTROL,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getcfr().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getcfr()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getcfr()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getcfr().toString();
				}
				if(liquidacionimpuestoimpor.getcfr()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getcfr().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.CFR,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.getcif().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getcif()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getcif()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().getcif().toString();
				}
				if(liquidacionimpuestoimpor.getcif()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.getcif().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.CIF,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpuestoimpor.getIsNew()||!liquidacionimpuestoimpor.gettotal().equals(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().gettotal()!=null)
				{
					strValorActual=liquidacionimpuestoimpor.getLiquidacionImpuestoImporOriginal().gettotal().toString();
				}
				if(liquidacionimpuestoimpor.gettotal()!=null)
				{
					strValorNuevo=liquidacionimpuestoimpor.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImpuestoImporConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveLiquidacionImpuestoImporRelacionesWithConnection(LiquidacionImpuestoImpor liquidacionimpuestoimpor,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors) throws Exception {

		if(!liquidacionimpuestoimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLiquidacionImpuestoImporRelacionesBase(liquidacionimpuestoimpor,detalleliquidacionimpuestoimpors,true);
		}
	}

	public void saveLiquidacionImpuestoImporRelaciones(LiquidacionImpuestoImpor liquidacionimpuestoimpor,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors)throws Exception {

		if(!liquidacionimpuestoimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLiquidacionImpuestoImporRelacionesBase(liquidacionimpuestoimpor,detalleliquidacionimpuestoimpors,false);
		}
	}

	public void saveLiquidacionImpuestoImporRelacionesBase(LiquidacionImpuestoImpor liquidacionimpuestoimpor,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("LiquidacionImpuestoImpor-saveRelacionesWithConnection");}
	
			liquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImpors(detalleliquidacionimpuestoimpors);

			this.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor);

			if(LiquidacionImpuestoImporLogicAdditional.validarSaveRelaciones(liquidacionimpuestoimpor,this)) {

				LiquidacionImpuestoImporLogicAdditional.updateRelacionesToSave(liquidacionimpuestoimpor,this);

				if((liquidacionimpuestoimpor.getIsNew()||liquidacionimpuestoimpor.getIsChanged())&&!liquidacionimpuestoimpor.getIsDeleted()) {
					this.saveLiquidacionImpuestoImpor();
					this.saveLiquidacionImpuestoImporRelacionesDetalles(detalleliquidacionimpuestoimpors);

				} else if(liquidacionimpuestoimpor.getIsDeleted()) {
					this.saveLiquidacionImpuestoImporRelacionesDetalles(detalleliquidacionimpuestoimpors);
					this.saveLiquidacionImpuestoImpor();
				}

				LiquidacionImpuestoImporLogicAdditional.updateRelacionesToSaveAfter(liquidacionimpuestoimpor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleLiquidacionImpuestoImporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpuestoImpors(detalleliquidacionimpuestoimpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveLiquidacionImpuestoImporRelacionesDetalles(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors)throws Exception {
		try {
	

			Long idLiquidacionImpuestoImporActual=this.getLiquidacionImpuestoImpor().getId();

			DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor=new DetalleLiquidacionImpuestoImporLogic();
			detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDetalleLiquidacionImpuestoImpors(detalleliquidacionimpuestoimpors);

			detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setConnexion(this.getConnexion());
			detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDatosCliente(this.datosCliente);

			for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor:detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.getDetalleLiquidacionImpuestoImpors()) {
				detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor.setid_liquidacion_impuesto_impor(idLiquidacionImpuestoImporActual);
			}

			detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.saveDetalleLiquidacionImpuestoImpors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LiquidacionImpuestoImporConstantesFunciones.getClassesForeignKeysOfLiquidacionImpuestoImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LiquidacionImpuestoImporConstantesFunciones.getClassesRelationshipsOfLiquidacionImpuestoImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
