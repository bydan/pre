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
package com.bydan.erp.tesoreria.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//PresupuestoFlujoCajaTsrConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class PresupuestoFlujoCajaTsrDataAccess extends  PresupuestoFlujoCajaTsrDataAccessAdditional{ //PresupuestoFlujoCajaTsrDataAccessAdditional,DataAccessHelper<PresupuestoFlujoCajaTsr>
	//static Logger logger = Logger.getLogger(PresupuestoFlujoCajaTsrDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presupuesto_flujo_caja_tsr";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_usuario,id_anio,id_mes,id_tipo_movimiento,id_centro_actividad,codigo,nombre,fecha,fecha_presupuesto,valor,id_cuenta_contable,id_centro_costo,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_usuario=?,id_anio=?,id_mes=?,id_tipo_movimiento=?,id_centro_actividad=?,codigo=?,nombre=?,fecha=?,fecha_presupuesto=?,valor=?,id_cuenta_contable=?,id_centro_costo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presupuestoflujocajatsr from "+PresupuestoFlujoCajaTsrConstantesFunciones.SPERSISTENCENAME+" presupuestoflujocajatsr";
	public static String QUERYSELECTNATIVE="select "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".version_row,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_usuario,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_anio,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_mes,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_centro_actividad,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".codigo,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".nombre,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".fecha,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".fecha_presupuesto,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".valor,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id_centro_costo,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".descripcion from "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME;//+" as "+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".id,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".version_row,"+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+".codigo from "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME;//+" as "+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaTsrConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_usuario=?,id_anio=?,id_mes=?,id_tipo_movimiento=?,id_centro_actividad=?,codigo=?,nombre=?,fecha=?,fecha_presupuesto=?,valor=?,id_cuenta_contable=?,id_centro_costo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPUESTOFLUJOCAJATSR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPUESTOFLUJOCAJATSR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPUESTOFLUJOCAJATSR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPUESTOFLUJOCAJATSR_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected PresupuestoFlujoCajaTsrDataAccessAdditional presupuestoflujocajatsrDataAccessAdditional=null;
	
	public PresupuestoFlujoCajaTsrDataAccessAdditional getPresupuestoFlujoCajaTsrDataAccessAdditional() {
		return this.presupuestoflujocajatsrDataAccessAdditional;
	}
	
	public void setPresupuestoFlujoCajaTsrDataAccessAdditional(PresupuestoFlujoCajaTsrDataAccessAdditional presupuestoflujocajatsrDataAccessAdditional) {
		try {
			this.presupuestoflujocajatsrDataAccessAdditional=presupuestoflujocajatsrDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresupuestoFlujoCajaTsrDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		PresupuestoFlujoCajaTsrDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresupuestoFlujoCajaTsrDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresupuestoFlujoCajaTsrDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setPresupuestoFlujoCajaTsrOriginal(PresupuestoFlujoCajaTsr presupuestoflujocajatsr)throws Exception  {
		presupuestoflujocajatsr.setPresupuestoFlujoCajaTsrOriginal((PresupuestoFlujoCajaTsr)presupuestoflujocajatsr.clone());		
	}
	
	public void setPresupuestoFlujoCajaTsrsOriginal(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs)throws Exception  {
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs){
			presupuestoflujocajatsr.setPresupuestoFlujoCajaTsrOriginal((PresupuestoFlujoCajaTsr)presupuestoflujocajatsr.clone());
		}
	}
	
	public static void setPresupuestoFlujoCajaTsrOriginalStatic(PresupuestoFlujoCajaTsr presupuestoflujocajatsr)throws Exception  {
		presupuestoflujocajatsr.setPresupuestoFlujoCajaTsrOriginal((PresupuestoFlujoCajaTsr)presupuestoflujocajatsr.clone());		
	}
	
	public static void setPresupuestoFlujoCajaTsrsOriginalStatic(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs)throws Exception  {
		
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs){
			presupuestoflujocajatsr.setPresupuestoFlujoCajaTsrOriginal((PresupuestoFlujoCajaTsr)presupuestoflujocajatsr.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  PresupuestoFlujoCajaTsr getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  PresupuestoFlujoCajaTsr getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.PresupuestoFlujoCajaTsr.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresupuestoFlujoCajaTsrOriginal(new PresupuestoFlujoCajaTsr());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet); 
				
				//entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsr(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresupuestoFlujoCajaTsr getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PresupuestoFlujoCajaTsr getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaTsrDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.PresupuestoFlujoCajaTsr.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresupuestoFlujoCajaTsrOriginal(new PresupuestoFlujoCajaTsr());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet);    
				
				//entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsr(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresupuestoFlujoCajaTsr
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaTsrDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.PresupuestoFlujoCajaTsr.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsr(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresupuestoFlujoCajaTsr> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoFlujoCajaTsr> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaTsrDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCajaTsr();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet);
      	    	
				//entity.setPresupuestoFlujoCajaTsrOriginal( new PresupuestoFlujoCajaTsr());
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsrs(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCajaTsr(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoFlujoCajaTsr> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoFlujoCajaTsr> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCajaTsr();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoFlujoCajaTsr();
					//entity.setMapPresupuestoFlujoCajaTsr(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresupuestoFlujoCajaTsrValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoFlujoCajaTsr().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoFlujoCajaTsrDataAccess.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoFlujoCajaTsrOriginal( new PresupuestoFlujoCajaTsr());
					////entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsrs(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCajaTsr(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresupuestoFlujoCajaTsr getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PresupuestoFlujoCajaTsr getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCajaTsr();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoFlujoCajaTsr();
					//entity.setMapPresupuestoFlujoCajaTsr(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresupuestoFlujoCajaTsrValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoFlujoCajaTsr().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoFlujoCajaTsrDataAccess.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoFlujoCajaTsrOriginal( new PresupuestoFlujoCajaTsr());
					////entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsr(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCajaTsr(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresupuestoFlujoCajaTsr getEntityPresupuestoFlujoCajaTsr(String strPrefijo,PresupuestoFlujoCajaTsr entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresupuestoFlujoCajaTsr.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresupuestoFlujoCajaTsr.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresupuestoFlujoCajaTsrDataAccess.setFieldReflectionPresupuestoFlujoCajaTsr(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresupuestoFlujoCajaTsr=PresupuestoFlujoCajaTsrConstantesFunciones.getTodosTiposColumnasPresupuestoFlujoCajaTsr();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresupuestoFlujoCajaTsr) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = PresupuestoFlujoCajaTsr.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresupuestoFlujoCajaTsr.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresupuestoFlujoCajaTsrDataAccess.setFieldReflectionPresupuestoFlujoCajaTsr(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresupuestoFlujoCajaTsr(Field field,String strPrefijo,String sColumn,PresupuestoFlujoCajaTsr entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoFlujoCajaTsr>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaTsrDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new PresupuestoFlujoCajaTsr();
					entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet);
					
					//entity.setPresupuestoFlujoCajaTsrOriginal( new PresupuestoFlujoCajaTsr());
					//entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
					//entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsrs(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCajaTsr(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoFlujoCajaTsr>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoFlujoCajaTsrDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaTsrDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<PresupuestoFlujoCajaTsr> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoFlujoCajaTsr> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCajaTsr();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet);
      	    	
				//entity.setPresupuestoFlujoCajaTsrOriginal( new PresupuestoFlujoCajaTsr());
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsrs(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCajaTsr(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoFlujoCajaTsr> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoFlujoCajaTsr> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCajaTsr> entities = new  ArrayList<PresupuestoFlujoCajaTsr>();
		PresupuestoFlujoCajaTsr entity = new PresupuestoFlujoCajaTsr();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCajaTsr();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoFlujoCajaTsr("",entity,resultSet);
      	    	
				//entity.setPresupuestoFlujoCajaTsrOriginal( new PresupuestoFlujoCajaTsr());
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet,PresupuestoFlujoCajaTsrDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaTsrOriginal(this.getEntityPresupuestoFlujoCajaTsr("",entity.getPresupuestoFlujoCajaTsrOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajaTsrs(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresupuestoFlujoCajaTsr getEntityPresupuestoFlujoCajaTsr(String strPrefijo,PresupuestoFlujoCajaTsr entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDPERIODO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDUSUARIO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setid_centro_actividad(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROACTIVIDAD));if(resultSet.wasNull()) {entity.setid_centro_actividad(null); }
				entity.setcodigo(resultSet.getString(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.NOMBRE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.FECHA).getTime()));
				entity.setfecha_presupuesto(new Date(resultSet.getDate(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.FECHAPRESUPUESTO).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.VALOR));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PresupuestoFlujoCajaTsrConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresupuestoFlujoCajaTsr(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresupuestoFlujoCajaTsr entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresupuestoFlujoCajaTsrDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresupuestoFlujoCajaTsrDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresupuestoFlujoCajaTsrDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresupuestoFlujoCajaTsrDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresupuestoFlujoCajaTsrConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresupuestoFlujoCajaTsrDataAccess.TABLENAME,PresupuestoFlujoCajaTsrDataAccess.ISWITHSTOREPROCEDURES);
			
			PresupuestoFlujoCajaTsrDataAccess.setPresupuestoFlujoCajaTsrOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Usuario getUsuario(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Anio getAnio(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public CentroActividad getCentroActividad(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		CentroActividad centroactividad= new CentroActividad();

		try {
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);

			centroactividad=centroactividadDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_centro_actividad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividad;

	}

	public CuentaContable getCuentaContable(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CentroCosto getCentroCosto(Connexion connexion,PresupuestoFlujoCajaTsr relpresupuestoflujocajatsr)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relpresupuestoflujocajatsr.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresupuestoFlujoCajaTsr presupuestoflujocajatsr) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presupuestoflujocajatsr.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presupuestoflujocajatsr.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(presupuestoflujocajatsr.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(presupuestoflujocajatsr.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(presupuestoflujocajatsr.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(presupuestoflujocajatsr.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(presupuestoflujocajatsr.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(presupuestoflujocajatsr.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(presupuestoflujocajatsr.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_actividad=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_actividad.setValue(presupuestoflujocajatsr.getid_centro_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(presupuestoflujocajatsr.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(presupuestoflujocajatsr.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(presupuestoflujocajatsr.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_presupuesto=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_presupuesto.setValue(presupuestoflujocajatsr.getfecha_presupuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_presupuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presupuestoflujocajatsr.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(presupuestoflujocajatsr.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(presupuestoflujocajatsr.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(presupuestoflujocajatsr.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!presupuestoflujocajatsr.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presupuestoflujocajatsr.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presupuestoflujocajatsr.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presupuestoflujocajatsr.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalsePresupuestoFlujoCajaTsr(PresupuestoFlujoCajaTsr presupuestoflujocajatsr)throws Exception  {		
		presupuestoflujocajatsr.setIsNew(false);
		presupuestoflujocajatsr.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresupuestoFlujoCajaTsrs(List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs)throws Exception  {				
		for(PresupuestoFlujoCajaTsr presupuestoflujocajatsr:presupuestoflujocajatsrs) {
			presupuestoflujocajatsr.setIsNew(false);
			presupuestoflujocajatsr.setIsChanged(false);
		}
	}
	
	public void generarExportarPresupuestoFlujoCajaTsr(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
