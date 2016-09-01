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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//DepreciacionActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DepreciacionActivoFijoDataAccess extends  DepreciacionActivoFijoDataAccessAdditional{ //DepreciacionActivoFijoDataAccessAdditional,DataAccessHelper<DepreciacionActivoFijo>
	//static Logger logger = Logger.getLogger(DepreciacionActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="depreciacion_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_activo_fijo,id_tipo_depreciacion_empresa,id_estado_depre_acti,id_anio,id_mes,fecha_compra,fecha_depre_acti,porcentaje,costo,valor_acumulado,valor_total,valor_gasto,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_tipo_depreciacion_empresa=?,id_estado_depre_acti=?,id_anio=?,id_mes=?,fecha_compra=?,fecha_depre_acti=?,porcentaje=?,costo=?,valor_acumulado=?,valor_total=?,valor_gasto=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select depreciacionactivofijo from "+DepreciacionActivoFijoConstantesFunciones.SPERSISTENCENAME+" depreciacionactivofijo";
	public static String QUERYSELECTNATIVE="select "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_tipo_depreciacion_empresa,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_estado_depre_acti,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_anio,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_mes,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".fecha_compra,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".fecha_depre_acti,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".porcentaje,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".costo,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".valor_acumulado,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".valor_total,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".valor_gasto,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".fecha from "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME;//+" as "+DepreciacionActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".version_row from "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME;//+" as "+DepreciacionActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_tipo_depreciacion_empresa=?,id_estado_depre_acti=?,id_anio=?,id_mes=?,fecha_compra=?,fecha_depre_acti=?,porcentaje=?,costo=?,valor_acumulado=?,valor_total=?,valor_gasto=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DEPRECIACIONACTIVOFIJO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DEPRECIACIONACTIVOFIJO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DEPRECIACIONACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DEPRECIACIONACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected DepreciacionActivoFijoDataAccessAdditional depreciacionactivofijoDataAccessAdditional=null;
	
	public DepreciacionActivoFijoDataAccessAdditional getDepreciacionActivoFijoDataAccessAdditional() {
		return this.depreciacionactivofijoDataAccessAdditional;
	}
	
	public void setDepreciacionActivoFijoDataAccessAdditional(DepreciacionActivoFijoDataAccessAdditional depreciacionactivofijoDataAccessAdditional) {
		try {
			this.depreciacionactivofijoDataAccessAdditional=depreciacionactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DepreciacionActivoFijoDataAccess() {
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
		DepreciacionActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DepreciacionActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DepreciacionActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDepreciacionActivoFijoOriginal(DepreciacionActivoFijo depreciacionactivofijo)throws Exception  {
		depreciacionactivofijo.setDepreciacionActivoFijoOriginal((DepreciacionActivoFijo)depreciacionactivofijo.clone());		
	}
	
	public void setDepreciacionActivoFijosOriginal(List<DepreciacionActivoFijo> depreciacionactivofijos)throws Exception  {
		
		for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos){
			depreciacionactivofijo.setDepreciacionActivoFijoOriginal((DepreciacionActivoFijo)depreciacionactivofijo.clone());
		}
	}
	
	public static void setDepreciacionActivoFijoOriginalStatic(DepreciacionActivoFijo depreciacionactivofijo)throws Exception  {
		depreciacionactivofijo.setDepreciacionActivoFijoOriginal((DepreciacionActivoFijo)depreciacionactivofijo.clone());		
	}
	
	public static void setDepreciacionActivoFijosOriginalStatic(List<DepreciacionActivoFijo> depreciacionactivofijos)throws Exception  {
		
		for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos){
			depreciacionactivofijo.setDepreciacionActivoFijoOriginal((DepreciacionActivoFijo)depreciacionactivofijo.clone());
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
	
	public  DepreciacionActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		
		
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
	
	public  DepreciacionActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.DepreciacionActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDepreciacionActivoFijoOriginal(new DepreciacionActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDepreciacionActivoFijo("",entity,resultSet); 
				
				//entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDepreciacionActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DepreciacionActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();
				
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
	
	public  DepreciacionActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DepreciacionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.DepreciacionActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDepreciacionActivoFijoOriginal(new DepreciacionActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDepreciacionActivoFijo("",entity,resultSet);    
				
				//entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDepreciacionActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DepreciacionActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DepreciacionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.DepreciacionActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDepreciacionActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DepreciacionActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		
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
	
	public  List<DepreciacionActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DepreciacionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DepreciacionActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDepreciacionActivoFijo("",entity,resultSet);
      	    	
				//entity.setDepreciacionActivoFijoOriginal( new DepreciacionActivoFijo());
      	    	//entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDepreciacionActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDepreciacionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DepreciacionActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
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
	
	public  List<DepreciacionActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DepreciacionActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapDepreciacionActivoFijo();
					//entity.setMapDepreciacionActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDepreciacionActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDepreciacionActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=DepreciacionActivoFijoDataAccess.getEntityDepreciacionActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDepreciacionActivoFijoOriginal( new DepreciacionActivoFijo());
					////entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDepreciacionActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDepreciacionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DepreciacionActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
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
	
	public  DepreciacionActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DepreciacionActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapDepreciacionActivoFijo();
					//entity.setMapDepreciacionActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDepreciacionActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDepreciacionActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=DepreciacionActivoFijoDataAccess.getEntityDepreciacionActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDepreciacionActivoFijoOriginal( new DepreciacionActivoFijo());
					////entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDepreciacionActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDepreciacionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DepreciacionActivoFijo getEntityDepreciacionActivoFijo(String strPrefijo,DepreciacionActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DepreciacionActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DepreciacionActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DepreciacionActivoFijoDataAccess.setFieldReflectionDepreciacionActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDepreciacionActivoFijo=DepreciacionActivoFijoConstantesFunciones.getTodosTiposColumnasDepreciacionActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDepreciacionActivoFijo) {
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
							field = DepreciacionActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DepreciacionActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DepreciacionActivoFijoDataAccess.setFieldReflectionDepreciacionActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDepreciacionActivoFijo(Field field,String strPrefijo,String sColumn,DepreciacionActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DepreciacionActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.VALORTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.VALORGASTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DepreciacionActivoFijoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DepreciacionActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DepreciacionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DepreciacionActivoFijo();
					entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDepreciacionActivoFijo("",entity,resultSet);
					
					//entity.setDepreciacionActivoFijoOriginal( new DepreciacionActivoFijo());
					//entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDepreciacionActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDepreciacionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DepreciacionActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DepreciacionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DepreciacionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DepreciacionActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
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
	
	public  List<DepreciacionActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DepreciacionActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDepreciacionActivoFijo("",entity,resultSet);
      	    	
				//entity.setDepreciacionActivoFijoOriginal( new DepreciacionActivoFijo());
      	    	//entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDepreciacionActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDepreciacionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DepreciacionActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
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
	
	public  List<DepreciacionActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DepreciacionActivoFijo> entities = new  ArrayList<DepreciacionActivoFijo>();
		DepreciacionActivoFijo entity = new DepreciacionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DepreciacionActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDepreciacionActivoFijo("",entity,resultSet);
      	    	
				//entity.setDepreciacionActivoFijoOriginal( new DepreciacionActivoFijo());
      	    	//entity.setDepreciacionActivoFijoOriginal(super.getEntity("",entity.getDepreciacionActivoFijoOriginal(),resultSet,DepreciacionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDepreciacionActivoFijoOriginal(this.getEntityDepreciacionActivoFijo("",entity.getDepreciacionActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDepreciacionActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DepreciacionActivoFijo getEntityDepreciacionActivoFijo(String strPrefijo,DepreciacionActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setid_tipo_depreciacion_empresa(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA));
				entity.setid_estado_depre_acti(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI));
				entity.setid_anio(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DepreciacionActivoFijoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA).getTime()));
				entity.setfecha_depre_acti(new Date(resultSet.getDate(strPrefijo+DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+DepreciacionActivoFijoConstantesFunciones.PORCENTAJE));
				entity.setcosto(resultSet.getDouble(strPrefijo+DepreciacionActivoFijoConstantesFunciones.COSTO));
				entity.setvalor_acumulado(resultSet.getDouble(strPrefijo+DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO));
				entity.setvalor_total(resultSet.getDouble(strPrefijo+DepreciacionActivoFijoConstantesFunciones.VALORTOTAL));
				entity.setvalor_gasto(resultSet.getDouble(strPrefijo+DepreciacionActivoFijoConstantesFunciones.VALORGASTO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DepreciacionActivoFijoConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDepreciacionActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DepreciacionActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DepreciacionActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DepreciacionActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DepreciacionActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DepreciacionActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DepreciacionActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DepreciacionActivoFijoDataAccess.TABLENAME,DepreciacionActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			DepreciacionActivoFijoDataAccess.setDepreciacionActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public TipoDepreciacionEmpresa getTipoDepreciacionEmpresa(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		TipoDepreciacionEmpresa tipodepreciacionempresa= new TipoDepreciacionEmpresa();

		try {
			TipoDepreciacionEmpresaDataAccess tipodepreciacionempresaDataAccess=new TipoDepreciacionEmpresaDataAccess();

			tipodepreciacionempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodepreciacionempresaDataAccess.setConnexionType(this.connexionType);
			tipodepreciacionempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_tipo_depreciacion_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodepreciacionempresa;

	}

	public EstadoDepreActi getEstadoDepreActi(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		EstadoDepreActi estadodepreacti= new EstadoDepreActi();

		try {
			EstadoDepreActiDataAccess estadodepreactiDataAccess=new EstadoDepreActiDataAccess();

			estadodepreactiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodepreactiDataAccess.setConnexionType(this.connexionType);
			estadodepreactiDataAccess.setParameterDbType(this.parameterDbType);

			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_estado_depre_acti());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodepreacti;

	}

	public Anio getAnio(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DepreciacionActivoFijo reldepreciacionactivofijo)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldepreciacionactivofijo.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DepreciacionActivoFijo depreciacionactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!depreciacionactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(depreciacionactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(depreciacionactivofijo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(depreciacionactivofijo.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_depreciacion_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_depreciacion_empresa.setValue(depreciacionactivofijo.getid_tipo_depreciacion_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_depreciacion_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_depre_acti=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_depre_acti.setValue(depreciacionactivofijo.getid_estado_depre_acti());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_depre_acti);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(depreciacionactivofijo.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(depreciacionactivofijo.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_compra=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_compra.setValue(depreciacionactivofijo.getfecha_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_depre_acti=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_depre_acti.setValue(depreciacionactivofijo.getfecha_depre_acti());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_depre_acti);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(depreciacionactivofijo.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(depreciacionactivofijo.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_acumulado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_acumulado.setValue(depreciacionactivofijo.getvalor_acumulado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_acumulado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_total=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_total.setValue(depreciacionactivofijo.getvalor_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_gasto=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_gasto.setValue(depreciacionactivofijo.getvalor_gasto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_gasto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(depreciacionactivofijo.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!depreciacionactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(depreciacionactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(depreciacionactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(depreciacionactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo)throws Exception  {		
		depreciacionactivofijo.setIsNew(false);
		depreciacionactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos)throws Exception  {				
		for(DepreciacionActivoFijo depreciacionactivofijo:depreciacionactivofijos) {
			depreciacionactivofijo.setIsNew(false);
			depreciacionactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarDepreciacionActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
