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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//DetaNotaCreditoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetaNotaCreditoDataAccess extends  DetaNotaCreditoDataAccessAdditional{ //DetaNotaCreditoDataAccessAdditional,DataAccessHelper<DetaNotaCredito>
	//static Logger logger = Logger.getLogger(DetaNotaCreditoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="deta_nota_credito";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_nota_credito,id_bodega,id_producto,id_unidad,id_tipo_deta_nota_credito,id_tipo_devolucion_empresa,descripcion,cantidad,precio,monto,costo,descuento,descuento2,impuesto,porcen_iva,porcen_descuen,porcen_ice,sub_total,total,id_centro_costo,id_empaque,incluye_impuesto,fecha_emision,codigo_lote,numero_caja)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_nota_credito=?,id_bodega=?,id_producto=?,id_unidad=?,id_tipo_deta_nota_credito=?,id_tipo_devolucion_empresa=?,descripcion=?,cantidad=?,precio=?,monto=?,costo=?,descuento=?,descuento2=?,impuesto=?,porcen_iva=?,porcen_descuen=?,porcen_ice=?,sub_total=?,total=?,id_centro_costo=?,id_empaque=?,incluye_impuesto=?,fecha_emision=?,codigo_lote=?,numero_caja=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detanotacredito from "+DetaNotaCreditoConstantesFunciones.SPERSISTENCENAME+" detanotacredito";
	public static String QUERYSELECTNATIVE="select "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_sucursal,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_periodo,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_anio,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_mes,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_nota_credito,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_bodega,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_producto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_unidad,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_tipo_deta_nota_credito,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_tipo_devolucion_empresa,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".descripcion,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".cantidad,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".precio,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".monto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".costo,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".descuento,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".descuento2,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".impuesto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".porcen_iva,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".porcen_descuen,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".porcen_ice,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".sub_total,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".total,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_centro_costo,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id_empaque,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".incluye_impuesto,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".fecha_emision,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".codigo_lote,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".numero_caja from "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME;//+" as "+DetaNotaCreditoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".id,"+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+".version_row from "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME;//+" as "+DetaNotaCreditoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetaNotaCreditoConstantesFunciones.SCHEMA+"."+DetaNotaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_nota_credito=?,id_bodega=?,id_producto=?,id_unidad=?,id_tipo_deta_nota_credito=?,id_tipo_devolucion_empresa=?,descripcion=?,cantidad=?,precio=?,monto=?,costo=?,descuento=?,descuento2=?,impuesto=?,porcen_iva=?,porcen_descuen=?,porcen_ice=?,sub_total=?,total=?,id_centro_costo=?,id_empaque=?,incluye_impuesto=?,fecha_emision=?,codigo_lote=?,numero_caja=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETANOTACREDITO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETANOTACREDITO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETANOTACREDITO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETANOTACREDITO_SELECT(?,?)";
	
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
	
	
	protected DetaNotaCreditoDataAccessAdditional detanotacreditoDataAccessAdditional=null;
	
	public DetaNotaCreditoDataAccessAdditional getDetaNotaCreditoDataAccessAdditional() {
		return this.detanotacreditoDataAccessAdditional;
	}
	
	public void setDetaNotaCreditoDataAccessAdditional(DetaNotaCreditoDataAccessAdditional detanotacreditoDataAccessAdditional) {
		try {
			this.detanotacreditoDataAccessAdditional=detanotacreditoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetaNotaCreditoDataAccess() {
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
		DetaNotaCreditoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetaNotaCreditoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetaNotaCreditoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetaNotaCreditoOriginal(DetaNotaCredito detanotacredito)throws Exception  {
		detanotacredito.setDetaNotaCreditoOriginal((DetaNotaCredito)detanotacredito.clone());		
	}
	
	public void setDetaNotaCreditosOriginal(List<DetaNotaCredito> detanotacreditos)throws Exception  {
		
		for(DetaNotaCredito detanotacredito:detanotacreditos){
			detanotacredito.setDetaNotaCreditoOriginal((DetaNotaCredito)detanotacredito.clone());
		}
	}
	
	public static void setDetaNotaCreditoOriginalStatic(DetaNotaCredito detanotacredito)throws Exception  {
		detanotacredito.setDetaNotaCreditoOriginal((DetaNotaCredito)detanotacredito.clone());		
	}
	
	public static void setDetaNotaCreditosOriginalStatic(List<DetaNotaCredito> detanotacreditos)throws Exception  {
		
		for(DetaNotaCredito detanotacredito:detanotacreditos){
			detanotacredito.setDetaNotaCreditoOriginal((DetaNotaCredito)detanotacredito.clone());
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
	
	public  DetaNotaCredito getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetaNotaCredito entity = new DetaNotaCredito();		
		
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
	
	public  DetaNotaCredito getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetaNotaCredito entity = new DetaNotaCredito();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetaNotaCredito.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetaNotaCreditoOriginal(new DetaNotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaNotaCredito("",entity,resultSet); 
				
				//entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaNotaCredito(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetaNotaCredito getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaNotaCredito entity = new DetaNotaCredito();
				
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
	
	public  DetaNotaCredito getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaNotaCredito entity = new DetaNotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaNotaCredito.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetaNotaCreditoOriginal(new DetaNotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaNotaCredito("",entity,resultSet);    
				
				//entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetaNotaCredito
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetaNotaCredito entity = new DetaNotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaNotaCredito.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetaNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetaNotaCredito> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		
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
	
	public  List<DetaNotaCredito> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaNotaCredito("",entity,resultSet);
      	    	
				//entity.setDetaNotaCreditoOriginal( new DetaNotaCredito());
      	    	//entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaNotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
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
	
	public  List<DetaNotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaNotaCredito();
					//entity.setMapDetaNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetaNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=DetaNotaCreditoDataAccess.getEntityDetaNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaNotaCreditoOriginal( new DetaNotaCredito());
					////entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetaNotaCredito getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaNotaCredito entity = new DetaNotaCredito();		  
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
	
	public  DetaNotaCredito getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaNotaCredito();
					//entity.setMapDetaNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetaNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=DetaNotaCreditoDataAccess.getEntityDetaNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaNotaCreditoOriginal( new DetaNotaCredito());
					////entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetaNotaCredito(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetaNotaCredito getEntityDetaNotaCredito(String strPrefijo,DetaNotaCredito entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetaNotaCredito.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetaNotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetaNotaCreditoDataAccess.setFieldReflectionDetaNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetaNotaCredito=DetaNotaCreditoConstantesFunciones.getTodosTiposColumnasDetaNotaCredito();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetaNotaCredito) {
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
							field = DetaNotaCredito.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetaNotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetaNotaCreditoDataAccess.setFieldReflectionDetaNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetaNotaCredito(Field field,String strPrefijo,String sColumn,DetaNotaCredito entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetaNotaCreditoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDNOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.PORCENIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.PORCENDESCUEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.PORCENICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.IDEMPAQUE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetaNotaCreditoConstantesFunciones.CODIGOLOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoConstantesFunciones.NUMEROCAJA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaNotaCredito>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetaNotaCredito();
					entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetaNotaCredito("",entity,resultSet);
					
					//entity.setDetaNotaCreditoOriginal( new DetaNotaCredito());
					//entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetaNotaCreditos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaNotaCredito>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetaNotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
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
	
	public  List<DetaNotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaNotaCredito("",entity,resultSet);
      	    	
				//entity.setDetaNotaCreditoOriginal( new DetaNotaCredito());
      	    	//entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetaNotaCreditos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaNotaCredito> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
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
	
	public  List<DetaNotaCredito> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCredito> entities = new  ArrayList<DetaNotaCredito>();
		DetaNotaCredito entity = new DetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaNotaCredito("",entity,resultSet);
      	    	
				//entity.setDetaNotaCreditoOriginal( new DetaNotaCredito());
      	    	//entity.setDetaNotaCreditoOriginal(super.getEntity("",entity.getDetaNotaCreditoOriginal(),resultSet,DetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoOriginal(this.getEntityDetaNotaCredito("",entity.getDetaNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetaNotaCredito getEntityDetaNotaCredito(String strPrefijo,DetaNotaCredito entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_nota_credito(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDNOTACREDITO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDUNIDAD));
				entity.setid_tipo_deta_nota_credito(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO));
				entity.setid_tipo_devolucion_empresa(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetaNotaCreditoConstantesFunciones.DESCRIPCION));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetaNotaCreditoConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.PRECIO));
				entity.setmonto(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.MONTO));
				entity.setcosto(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.COSTO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.DESCUENTO));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.DESCUENTO2));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.IMPUESTO));
				entity.setporcen_iva(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.PORCENIVA));
				entity.setporcen_descuen(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.PORCENDESCUEN));
				entity.setporcen_ice(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.PORCENICE));
				entity.setsub_total(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+DetaNotaCreditoConstantesFunciones.TOTAL));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_empaque(resultSet.getLong(strPrefijo+DetaNotaCreditoConstantesFunciones.IDEMPAQUE));if(resultSet.wasNull()) {entity.setid_empaque(null); }
				entity.setincluye_impuesto(resultSet.getBoolean(strPrefijo+DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DetaNotaCreditoConstantesFunciones.FECHAEMISION).getTime()));
				entity.setcodigo_lote(resultSet.getString(strPrefijo+DetaNotaCreditoConstantesFunciones.CODIGOLOTE));
				entity.setnumero_caja(resultSet.getString(strPrefijo+DetaNotaCreditoConstantesFunciones.NUMEROCAJA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetaNotaCredito(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetaNotaCredito entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetaNotaCreditoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetaNotaCreditoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetaNotaCreditoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetaNotaCreditoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetaNotaCreditoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetaNotaCreditoDataAccess.TABLENAME,DetaNotaCreditoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetaNotaCreditoDataAccess.setDetaNotaCreditoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetanotacredito.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetanotacredito.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetanotacredito.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetanotacredito.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetanotacredito.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetanotacredito.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public NotaCredito getNotaCredito(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		NotaCredito notacredito= new NotaCredito();

		try {
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);

			notacredito=notacreditoDataAccess.getEntity(connexion,reldetanotacredito.getid_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacredito;

	}

	public Bodega getBodega(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetanotacredito.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetanotacredito.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetanotacredito.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public TipoDetaNotaCredito getTipoDetaNotaCredito(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		TipoDetaNotaCredito tipodetanotacredito= new TipoDetaNotaCredito();

		try {
			TipoDetaNotaCreditoDataAccess tipodetanotacreditoDataAccess=new TipoDetaNotaCreditoDataAccess();

			tipodetanotacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodetanotacreditoDataAccess.setConnexionType(this.connexionType);
			tipodetanotacreditoDataAccess.setParameterDbType(this.parameterDbType);

			tipodetanotacredito=tipodetanotacreditoDataAccess.getEntity(connexion,reldetanotacredito.getid_tipo_deta_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodetanotacredito;

	}

	public TipoDevolucionEmpresa getTipoDevolucionEmpresa(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		TipoDevolucionEmpresa tipodevolucionempresa= new TipoDevolucionEmpresa();

		try {
			TipoDevolucionEmpresaDataAccess tipodevolucionempresaDataAccess=new TipoDevolucionEmpresaDataAccess();

			tipodevolucionempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodevolucionempresaDataAccess.setConnexionType(this.connexionType);
			tipodevolucionempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion,reldetanotacredito.getid_tipo_devolucion_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodevolucionempresa;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetanotacredito.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Empaque getEmpaque(Connexion connexion,DetaNotaCredito reldetanotacredito)throws SQLException,Exception {

		Empaque empaque= new Empaque();

		try {
			EmpaqueDataAccess empaqueDataAccess=new EmpaqueDataAccess();

			empaqueDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empaqueDataAccess.setConnexionType(this.connexionType);
			empaqueDataAccess.setParameterDbType(this.parameterDbType);

			empaque=empaqueDataAccess.getEntity(connexion,reldetanotacredito.getid_empaque());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empaque;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetaNotaCredito detanotacredito) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detanotacredito.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detanotacredito.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detanotacredito.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detanotacredito.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detanotacredito.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detanotacredito.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detanotacredito.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_nota_credito.setValue(detanotacredito.getid_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detanotacredito.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detanotacredito.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detanotacredito.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_deta_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_deta_nota_credito.setValue(detanotacredito.getid_tipo_deta_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_deta_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_devolucion_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_devolucion_empresa.setValue(detanotacredito.getid_tipo_devolucion_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_devolucion_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detanotacredito.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detanotacredito.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detanotacredito.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto=new ParameterValue<Double>();
					parameterMaintenanceValuemonto.setValue(detanotacredito.getmonto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(detanotacredito.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detanotacredito.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(detanotacredito.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(detanotacredito.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_iva=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_iva.setValue(detanotacredito.getporcen_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_descuen=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_descuen.setValue(detanotacredito.getporcen_descuen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_descuen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_ice=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_ice.setValue(detanotacredito.getporcen_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(detanotacredito.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detanotacredito.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detanotacredito.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empaque=new ParameterValue<Long>();
					parameterMaintenanceValueid_empaque.setValue(detanotacredito.getid_empaque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empaque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueincluye_impuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValueincluye_impuesto.setValue(detanotacredito.getincluye_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueincluye_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(detanotacredito.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_lote=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_lote.setValue(detanotacredito.getcodigo_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_caja=new ParameterValue<String>();
					parameterMaintenanceValuenumero_caja.setValue(detanotacredito.getnumero_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_caja);
					parametersTemp.add(parameterMaintenance);
					
						if(!detanotacredito.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detanotacredito.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detanotacredito.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detanotacredito.getId());
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
	
	public void setIsNewIsChangedFalseDetaNotaCredito(DetaNotaCredito detanotacredito)throws Exception  {		
		detanotacredito.setIsNew(false);
		detanotacredito.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetaNotaCreditos(List<DetaNotaCredito> detanotacreditos)throws Exception  {				
		for(DetaNotaCredito detanotacredito:detanotacreditos) {
			detanotacredito.setIsNew(false);
			detanotacredito.setIsChanged(false);
		}
	}
	
	public void generarExportarDetaNotaCredito(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
