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
import com.bydan.erp.contabilidad.util.*;//PlantillaFacturaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PlantillaFacturaDataAccess extends  PlantillaFacturaDataAccessAdditional{ //PlantillaFacturaDataAccessAdditional,DataAccessHelper<PlantillaFactura>
	//static Logger logger = Logger.getLogger(PlantillaFacturaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="plantilla_factura";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,descripcion,es_proveedor,id_cuenta_contable_aplicada,id_cuenta_contable_credito_bien,id_cuenta_contable_credito_servicio,id_tipo_retencion_fuente_bien,id_tipo_retencion_fuente_servicio,id_tipo_retencion_iva_bien,id_tipo_retencion_iva_servicio,id_cuenta_contable_gasto)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,descripcion=?,es_proveedor=?,id_cuenta_contable_aplicada=?,id_cuenta_contable_credito_bien=?,id_cuenta_contable_credito_servicio=?,id_tipo_retencion_fuente_bien=?,id_tipo_retencion_fuente_servicio=?,id_tipo_retencion_iva_bien=?,id_tipo_retencion_iva_servicio=?,id_cuenta_contable_gasto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select plantillafactura from "+PlantillaFacturaConstantesFunciones.SPERSISTENCENAME+" plantillafactura";
	public static String QUERYSELECTNATIVE="select "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".version_row,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_empresa,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".codigo,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".nombre,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".descripcion,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".es_proveedor,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_aplicada,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_bien,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_servicio,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente_bien,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente_servicio,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_bien,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_servicio,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto from "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME;//+" as "+PlantillaFacturaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".id,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".version_row,"+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+".codigo from "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME;//+" as "+PlantillaFacturaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PlantillaFacturaConstantesFunciones.SCHEMA+"."+PlantillaFacturaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,descripcion=?,es_proveedor=?,id_cuenta_contable_aplicada=?,id_cuenta_contable_credito_bien=?,id_cuenta_contable_credito_servicio=?,id_tipo_retencion_fuente_bien=?,id_tipo_retencion_fuente_servicio=?,id_tipo_retencion_iva_bien=?,id_tipo_retencion_iva_servicio=?,id_cuenta_contable_gasto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PLANTILLAFACTURA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PLANTILLAFACTURA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PLANTILLAFACTURA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PLANTILLAFACTURA_SELECT(?,?)";
	
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
	
	
	protected PlantillaFacturaDataAccessAdditional plantillafacturaDataAccessAdditional=null;
	
	public PlantillaFacturaDataAccessAdditional getPlantillaFacturaDataAccessAdditional() {
		return this.plantillafacturaDataAccessAdditional;
	}
	
	public void setPlantillaFacturaDataAccessAdditional(PlantillaFacturaDataAccessAdditional plantillafacturaDataAccessAdditional) {
		try {
			this.plantillafacturaDataAccessAdditional=plantillafacturaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PlantillaFacturaDataAccess() {
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
		PlantillaFacturaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PlantillaFacturaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PlantillaFacturaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPlantillaFacturaOriginal(PlantillaFactura plantillafactura)throws Exception  {
		plantillafactura.setPlantillaFacturaOriginal((PlantillaFactura)plantillafactura.clone());		
	}
	
	public void setPlantillaFacturasOriginal(List<PlantillaFactura> plantillafacturas)throws Exception  {
		
		for(PlantillaFactura plantillafactura:plantillafacturas){
			plantillafactura.setPlantillaFacturaOriginal((PlantillaFactura)plantillafactura.clone());
		}
	}
	
	public static void setPlantillaFacturaOriginalStatic(PlantillaFactura plantillafactura)throws Exception  {
		plantillafactura.setPlantillaFacturaOriginal((PlantillaFactura)plantillafactura.clone());		
	}
	
	public static void setPlantillaFacturasOriginalStatic(List<PlantillaFactura> plantillafacturas)throws Exception  {
		
		for(PlantillaFactura plantillafactura:plantillafacturas){
			plantillafactura.setPlantillaFacturaOriginal((PlantillaFactura)plantillafactura.clone());
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
	
	public  PlantillaFactura getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PlantillaFactura entity = new PlantillaFactura();		
		
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
	
	public  PlantillaFactura getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PlantillaFactura entity = new PlantillaFactura();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PlantillaFactura.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPlantillaFacturaOriginal(new PlantillaFactura());
      	    	entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlantillaFactura("",entity,resultSet); 
				
				//entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePlantillaFactura(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PlantillaFactura getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlantillaFactura entity = new PlantillaFactura();
				
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
	
	public  PlantillaFactura getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlantillaFactura entity = new PlantillaFactura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlantillaFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PlantillaFactura.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPlantillaFacturaOriginal(new PlantillaFactura());
      	    	entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlantillaFactura("",entity,resultSet);    
				
				//entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePlantillaFactura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PlantillaFactura
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PlantillaFactura entity = new PlantillaFactura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlantillaFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PlantillaFactura.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePlantillaFactura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PlantillaFactura> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		
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
	
	public  List<PlantillaFactura> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlantillaFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlantillaFactura();
      	    	entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlantillaFactura("",entity,resultSet);
      	    	
				//entity.setPlantillaFacturaOriginal( new PlantillaFactura());
      	    	//entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlantillaFacturas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlantillaFactura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlantillaFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
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
	
	public  List<PlantillaFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlantillaFactura();
				
				if(conMapGenerico) {
					entity.inicializarMapPlantillaFactura();
					//entity.setMapPlantillaFactura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPlantillaFacturaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlantillaFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         		
					entity=PlantillaFacturaDataAccess.getEntityPlantillaFactura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlantillaFacturaOriginal( new PlantillaFactura());
					////entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlantillaFacturas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlantillaFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PlantillaFactura getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlantillaFactura entity = new PlantillaFactura();		  
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
	
	public  PlantillaFactura getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlantillaFactura();
				
				if(conMapGenerico) {
					entity.inicializarMapPlantillaFactura();
					//entity.setMapPlantillaFactura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPlantillaFacturaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlantillaFactura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         		
					entity=PlantillaFacturaDataAccess.getEntityPlantillaFactura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlantillaFacturaOriginal( new PlantillaFactura());
					////entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
					////entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePlantillaFactura(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlantillaFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PlantillaFactura getEntityPlantillaFactura(String strPrefijo,PlantillaFactura entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PlantillaFactura.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PlantillaFactura.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PlantillaFacturaDataAccess.setFieldReflectionPlantillaFactura(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPlantillaFactura=PlantillaFacturaConstantesFunciones.getTodosTiposColumnasPlantillaFactura();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPlantillaFactura) {
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
							field = PlantillaFactura.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PlantillaFactura.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PlantillaFacturaDataAccess.setFieldReflectionPlantillaFactura(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPlantillaFactura(Field field,String strPrefijo,String sColumn,PlantillaFactura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PlantillaFacturaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.ESPROVEEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlantillaFactura>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlantillaFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PlantillaFactura();
					entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPlantillaFactura("",entity,resultSet);
					
					//entity.setPlantillaFacturaOriginal( new PlantillaFactura());
					//entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
					//entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePlantillaFacturas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlantillaFactura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlantillaFactura>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlantillaFacturaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlantillaFacturaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PlantillaFactura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
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
	
	public  List<PlantillaFactura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlantillaFactura();
      	    	entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlantillaFactura("",entity,resultSet);
      	    	
				//entity.setPlantillaFacturaOriginal( new PlantillaFactura());
      	    	//entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePlantillaFacturas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlantillaFactura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlantillaFactura> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
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
	
	public  List<PlantillaFactura> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlantillaFactura> entities = new  ArrayList<PlantillaFactura>();
		PlantillaFactura entity = new PlantillaFactura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlantillaFactura();
      	    	entity=super.getEntity("",entity,resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlantillaFactura("",entity,resultSet);
      	    	
				//entity.setPlantillaFacturaOriginal( new PlantillaFactura());
      	    	//entity.setPlantillaFacturaOriginal(super.getEntity("",entity.getPlantillaFacturaOriginal(),resultSet,PlantillaFacturaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlantillaFacturaOriginal(this.getEntityPlantillaFactura("",entity.getPlantillaFacturaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlantillaFacturas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PlantillaFactura getEntityPlantillaFactura(String strPrefijo,PlantillaFactura entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+PlantillaFacturaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+PlantillaFacturaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+PlantillaFacturaConstantesFunciones.DESCRIPCION));
				entity.setes_proveedor(resultSet.getBoolean(strPrefijo+PlantillaFacturaConstantesFunciones.ESPROVEEDOR));
				entity.setid_cuenta_contable_aplicada(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEAPLICADA));if(resultSet.wasNull()) {entity.setid_cuenta_contable_aplicada(null); }
				entity.setid_cuenta_contable_credito_bien(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOBIEN));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito_bien(null); }
				entity.setid_cuenta_contable_credito_servicio(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDCUENTACONTABLECREDITOSERVICIO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito_servicio(null); }
				entity.setid_tipo_retencion_fuente_bien(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTEBIEN));if(resultSet.wasNull()) {entity.setid_tipo_retencion_fuente_bien(null); }
				entity.setid_tipo_retencion_fuente_servicio(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDTIPORETENCIONFUENTESERVICIO));if(resultSet.wasNull()) {entity.setid_tipo_retencion_fuente_servicio(null); }
				entity.setid_tipo_retencion_iva_bien(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVABIEN));if(resultSet.wasNull()) {entity.setid_tipo_retencion_iva_bien(null); }
				entity.setid_tipo_retencion_iva_servicio(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDTIPORETENCIONIVASERVICIO));if(resultSet.wasNull()) {entity.setid_tipo_retencion_iva_servicio(null); }
				entity.setid_cuenta_contable_gasto(resultSet.getLong(strPrefijo+PlantillaFacturaConstantesFunciones.IDCUENTACONTABLEGASTO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_gasto(null); }
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PlantillaFacturaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPlantillaFactura(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PlantillaFactura entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PlantillaFacturaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PlantillaFacturaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PlantillaFacturaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PlantillaFacturaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PlantillaFacturaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PlantillaFacturaDataAccess.TABLENAME,PlantillaFacturaDataAccess.ISWITHSTOREPROCEDURES);
			
			PlantillaFacturaDataAccess.setPlantillaFacturaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relplantillafactura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContableAplicada(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relplantillafactura.getid_cuenta_contable_aplicada());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCreditoBien(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relplantillafactura.getid_cuenta_contable_credito_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCreditoServicio(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relplantillafactura.getid_cuenta_contable_credito_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoRetencion getTipoRetencionFuenteBien(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relplantillafactura.getid_tipo_retencion_fuente_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionFuenteServicio(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relplantillafactura.getid_tipo_retencion_fuente_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIvaBien(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relplantillafactura.getid_tipo_retencion_iva_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIvaServicio(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relplantillafactura.getid_tipo_retencion_iva_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public CuentaContable getCuentaContableGasto(Connexion connexion,PlantillaFactura relplantillafactura)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relplantillafactura.getid_cuenta_contable_gasto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,PlantillaFactura plantillafactura)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PlantillaFacturaConstantesFunciones.SCHEMA+".plantilla_factura ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_plantilla_factura="+PlantillaFacturaConstantesFunciones.SCHEMA+".plantilla_factura.id WHERE "+PlantillaFacturaConstantesFunciones.SCHEMA+".plantilla_factura.id="+String.valueOf(plantillafactura.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.PlantillaFactura WHERE facturaproveedor.PlantillaFactura.id="+String.valueOf(plantillafactura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PlantillaFactura plantillafactura) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!plantillafactura.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(plantillafactura.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(plantillafactura.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(plantillafactura.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(plantillafactura.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_proveedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_proveedor.setValue(plantillafactura.getes_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_aplicada=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_aplicada.setValue(plantillafactura.getid_cuenta_contable_aplicada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_aplicada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_bien.setValue(plantillafactura.getid_cuenta_contable_credito_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_servicio.setValue(plantillafactura.getid_cuenta_contable_credito_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_fuente_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_fuente_bien.setValue(plantillafactura.getid_tipo_retencion_fuente_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_fuente_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_fuente_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_fuente_servicio.setValue(plantillafactura.getid_tipo_retencion_fuente_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_fuente_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva_bien.setValue(plantillafactura.getid_tipo_retencion_iva_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva_servicio.setValue(plantillafactura.getid_tipo_retencion_iva_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_gasto=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_gasto.setValue(plantillafactura.getid_cuenta_contable_gasto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_gasto);
					parametersTemp.add(parameterMaintenance);
					
						if(!plantillafactura.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(plantillafactura.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(plantillafactura.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(plantillafactura.getId());
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
	
	public void setIsNewIsChangedFalsePlantillaFactura(PlantillaFactura plantillafactura)throws Exception  {		
		plantillafactura.setIsNew(false);
		plantillafactura.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePlantillaFacturas(List<PlantillaFactura> plantillafacturas)throws Exception  {				
		for(PlantillaFactura plantillafactura:plantillafacturas) {
			plantillafactura.setIsNew(false);
			plantillafactura.setIsChanged(false);
		}
	}
	
	public void generarExportarPlantillaFactura(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
