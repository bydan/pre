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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//ParametroGraficoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ParametroGraficoDataAccess extends  ParametroGraficoDataAccessAdditional{ //ParametroGraficoDataAccessAdditional,DataAccessHelper<ParametroGrafico>
	//static Logger logger = Logger.getLogger(ParametroGraficoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_grafico";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cuenta_contable_activo,id_cuenta_contable_pasivo,id_cuenta_contable_inventario,id_cuenta_contable_disponibilidad,id_cuenta_contable_costo_venta,id_cuenta_contable_inventario_ini,id_cuenta_contable_inventario_fin,id_cuenta_contable_cuenta_cobrar,id_cuenta_contable_venta_credito,id_cuenta_contable_activo_total,id_cuenta_contable_pasivo_total,id_cuenta_contable_patrimonio,id_cuenta_contable_patrimonio_total,id_cuenta_contable_venta,inventario_inicial)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cuenta_contable_activo=?,id_cuenta_contable_pasivo=?,id_cuenta_contable_inventario=?,id_cuenta_contable_disponibilidad=?,id_cuenta_contable_costo_venta=?,id_cuenta_contable_inventario_ini=?,id_cuenta_contable_inventario_fin=?,id_cuenta_contable_cuenta_cobrar=?,id_cuenta_contable_venta_credito=?,id_cuenta_contable_activo_total=?,id_cuenta_contable_pasivo_total=?,id_cuenta_contable_patrimonio=?,id_cuenta_contable_patrimonio_total=?,id_cuenta_contable_venta=?,inventario_inicial=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrografico from "+ParametroGraficoConstantesFunciones.SPERSISTENCENAME+" parametrografico";
	public static String QUERYSELECTNATIVE="select "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".version_row,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_activo,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_pasivo,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_disponibilidad,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_venta,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario_ini,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario_fin,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_cuenta_cobrar,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta_credito,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_activo_total,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_pasivo_total,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_patrimonio,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_patrimonio_total,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".inventario_inicial from "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME;//+" as "+ParametroGraficoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".id,"+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+".version_row from "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME;//+" as "+ParametroGraficoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroGraficoConstantesFunciones.SCHEMA+"."+ParametroGraficoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cuenta_contable_activo=?,id_cuenta_contable_pasivo=?,id_cuenta_contable_inventario=?,id_cuenta_contable_disponibilidad=?,id_cuenta_contable_costo_venta=?,id_cuenta_contable_inventario_ini=?,id_cuenta_contable_inventario_fin=?,id_cuenta_contable_cuenta_cobrar=?,id_cuenta_contable_venta_credito=?,id_cuenta_contable_activo_total=?,id_cuenta_contable_pasivo_total=?,id_cuenta_contable_patrimonio=?,id_cuenta_contable_patrimonio_total=?,id_cuenta_contable_venta=?,inventario_inicial=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROGRAFICO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROGRAFICO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROGRAFICO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROGRAFICO_SELECT(?,?)";
	
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
	
	
	protected ParametroGraficoDataAccessAdditional parametrograficoDataAccessAdditional=null;
	
	public ParametroGraficoDataAccessAdditional getParametroGraficoDataAccessAdditional() {
		return this.parametrograficoDataAccessAdditional;
	}
	
	public void setParametroGraficoDataAccessAdditional(ParametroGraficoDataAccessAdditional parametrograficoDataAccessAdditional) {
		try {
			this.parametrograficoDataAccessAdditional=parametrograficoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroGraficoDataAccess() {
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
		ParametroGraficoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroGraficoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroGraficoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroGraficoOriginal(ParametroGrafico parametrografico)throws Exception  {
		parametrografico.setParametroGraficoOriginal((ParametroGrafico)parametrografico.clone());		
	}
	
	public void setParametroGraficosOriginal(List<ParametroGrafico> parametrograficos)throws Exception  {
		
		for(ParametroGrafico parametrografico:parametrograficos){
			parametrografico.setParametroGraficoOriginal((ParametroGrafico)parametrografico.clone());
		}
	}
	
	public static void setParametroGraficoOriginalStatic(ParametroGrafico parametrografico)throws Exception  {
		parametrografico.setParametroGraficoOriginal((ParametroGrafico)parametrografico.clone());		
	}
	
	public static void setParametroGraficosOriginalStatic(List<ParametroGrafico> parametrograficos)throws Exception  {
		
		for(ParametroGrafico parametrografico:parametrograficos){
			parametrografico.setParametroGraficoOriginal((ParametroGrafico)parametrografico.clone());
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
	
	public  ParametroGrafico getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGrafico entity = new ParametroGrafico();		
		
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
	
	public  ParametroGrafico getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGrafico entity = new ParametroGrafico();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ParametroGrafico.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroGraficoOriginal(new ParametroGrafico());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGrafico("",entity,resultSet); 
				
				//entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGrafico(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroGrafico getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGrafico entity = new ParametroGrafico();
				
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
	
	public  ParametroGrafico getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGrafico entity = new ParametroGrafico();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGraficoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroGrafico.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroGraficoOriginal(new ParametroGrafico());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGrafico("",entity,resultSet);    
				
				//entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGrafico(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroGrafico
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroGrafico entity = new ParametroGrafico();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGraficoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroGrafico.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroGrafico(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroGrafico> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		
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
	
	public  List<ParametroGrafico> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGraficoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGrafico();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGrafico("",entity,resultSet);
      	    	
				//entity.setParametroGraficoOriginal( new ParametroGrafico());
      	    	//entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGraficos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGrafico(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGrafico> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
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
	
	public  List<ParametroGrafico> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGrafico();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGrafico();
					//entity.setMapParametroGrafico(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroGraficoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGrafico().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGraficoDataAccess.getEntityParametroGrafico("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGraficoOriginal( new ParametroGrafico());
					////entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGraficos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGrafico(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroGrafico getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGrafico entity = new ParametroGrafico();		  
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
	
	public  ParametroGrafico getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGrafico();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGrafico();
					//entity.setMapParametroGrafico(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroGraficoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGrafico().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGraficoDataAccess.getEntityParametroGrafico("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGraficoOriginal( new ParametroGrafico());
					////entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroGrafico(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGrafico(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroGrafico getEntityParametroGrafico(String strPrefijo,ParametroGrafico entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroGrafico.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroGrafico.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroGraficoDataAccess.setFieldReflectionParametroGrafico(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroGrafico=ParametroGraficoConstantesFunciones.getTodosTiposColumnasParametroGrafico();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroGrafico) {
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
							field = ParametroGrafico.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroGrafico.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroGraficoDataAccess.setFieldReflectionParametroGrafico(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroGrafico(Field field,String strPrefijo,String sColumn,ParametroGrafico entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroGraficoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGraficoConstantesFunciones.INVENTARIOINICIAL:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGrafico>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGraficoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroGrafico();
					entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroGrafico("",entity,resultSet);
					
					//entity.setParametroGraficoOriginal( new ParametroGrafico());
					//entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroGraficos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGrafico(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGrafico>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGraficoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGraficoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroGrafico> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
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
	
	public  List<ParametroGrafico> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGrafico();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGrafico("",entity,resultSet);
      	    	
				//entity.setParametroGraficoOriginal( new ParametroGrafico());
      	    	//entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroGraficos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGrafico(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGrafico> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
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
	
	public  List<ParametroGrafico> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGrafico> entities = new  ArrayList<ParametroGrafico>();
		ParametroGrafico entity = new ParametroGrafico();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGrafico();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGrafico("",entity,resultSet);
      	    	
				//entity.setParametroGraficoOriginal( new ParametroGrafico());
      	    	//entity.setParametroGraficoOriginal(super.getEntity("",entity.getParametroGraficoOriginal(),resultSet,ParametroGraficoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGraficoOriginal(this.getEntityParametroGrafico("",entity.getParametroGraficoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGraficos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroGrafico getEntityParametroGrafico(String strPrefijo,ParametroGrafico entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDEMPRESA));
				entity.setid_cuenta_contable_activo(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVO));
				entity.setid_cuenta_contable_pasivo(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVO));
				entity.setid_cuenta_contable_inventario(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIO));
				entity.setid_cuenta_contable_disponibilidad(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEDISPONIBILIDAD));
				entity.setid_cuenta_contable_costo_venta(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA));
				entity.setid_cuenta_contable_inventario_ini(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOINI));
				entity.setid_cuenta_contable_inventario_fin(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEINVENTARIOFIN));
				entity.setid_cuenta_contable_cuenta_cobrar(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLECUENTASCOBRAR));
				entity.setid_cuenta_contable_venta_credito(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTACREDITO));
				entity.setid_cuenta_contable_activo_total(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEACTIVOTOTAL));
				entity.setid_cuenta_contable_pasivo_total(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPASIVOTOTAL));
				entity.setid_cuenta_contable_patrimonio(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIO));
				entity.setid_cuenta_contable_patrimonio_total(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEPATRIMONIOTOTAL));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+ParametroGraficoConstantesFunciones.IDCUENTACONTABLEVENTA));
				entity.setinventario_inicial(resultSet.getDouble(strPrefijo+ParametroGraficoConstantesFunciones.INVENTARIOINICIAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroGrafico(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroGrafico entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroGraficoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroGraficoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroGraficoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroGraficoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroGraficoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroGraficoDataAccess.TABLENAME,ParametroGraficoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroGraficoDataAccess.setParametroGraficoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrografico.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContableActivo(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_activo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContablePasivo(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_pasivo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableInventario(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDisponibilidad(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_disponibilidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCostoVenta(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_costo_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableInventarioIni(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_inventario_ini());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableInventarioFin(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_inventario_fin());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCuentasCobrar(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_cuenta_cobrar());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVentaCredito(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_venta_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableActivoTotal(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_activo_total());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContablePasivoTotal(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_pasivo_total());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContablePatrimonio(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_patrimonio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContablePatrimonioTotal(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_patrimonio_total());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,ParametroGrafico relparametrografico)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrografico.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroGrafico parametrografico) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrografico.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrografico.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_activo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_activo.setValue(parametrografico.getid_cuenta_contable_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_pasivo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_pasivo.setValue(parametrografico.getid_cuenta_contable_pasivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_pasivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario.setValue(parametrografico.getid_cuenta_contable_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_disponibilidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_disponibilidad.setValue(parametrografico.getid_cuenta_contable_disponibilidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_disponibilidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_venta.setValue(parametrografico.getid_cuenta_contable_costo_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario_ini=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario_ini.setValue(parametrografico.getid_cuenta_contable_inventario_ini());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario_ini);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario_fin=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario_fin.setValue(parametrografico.getid_cuenta_contable_inventario_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_cuenta_cobrar=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_cuenta_cobrar.setValue(parametrografico.getid_cuenta_contable_cuenta_cobrar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_cuenta_cobrar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta_credito.setValue(parametrografico.getid_cuenta_contable_venta_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_activo_total=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_activo_total.setValue(parametrografico.getid_cuenta_contable_activo_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_activo_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_pasivo_total=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_pasivo_total.setValue(parametrografico.getid_cuenta_contable_pasivo_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_pasivo_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_patrimonio=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_patrimonio.setValue(parametrografico.getid_cuenta_contable_patrimonio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_patrimonio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_patrimonio_total=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_patrimonio_total.setValue(parametrografico.getid_cuenta_contable_patrimonio_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_patrimonio_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(parametrografico.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinventario_inicial=new ParameterValue<Double>();
					parameterMaintenanceValueinventario_inicial.setValue(parametrografico.getinventario_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinventario_inicial);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrografico.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrografico.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrografico.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrografico.getId());
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
	
	public void setIsNewIsChangedFalseParametroGrafico(ParametroGrafico parametrografico)throws Exception  {		
		parametrografico.setIsNew(false);
		parametrografico.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroGraficos(List<ParametroGrafico> parametrograficos)throws Exception  {				
		for(ParametroGrafico parametrografico:parametrograficos) {
			parametrografico.setIsNew(false);
			parametrografico.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroGrafico(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
