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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//TransferenciaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class TransferenciaDataAccess extends  TransferenciaDataAccessAdditional{ //TransferenciaDataAccessAdditional,DataAccessHelper<Transferencia>
	//static Logger logger = Logger.getLogger(TransferenciaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transferencia";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,fecha_emision,fecha_entrega,numero_secuencial,id_moneda,id_tipo_cambio,id_estado_inventario,id_formato,id_transportista,id_empleado,descripcion,porcentaje_descuento,suman,ice,valor_descuento,total_descuento,iva,stock,sub_total,total_otro,ultimo_costo,numero_items,retencion,total,flete,impuesto,id_tipo_transaccion_modulo,id_asiento_contable,numero_comprobante,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_inventario=?,id_formato=?,id_transportista=?,id_empleado=?,descripcion=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_asiento_contable=?,numero_comprobante=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transferencia from "+TransferenciaConstantesFunciones.SPERSISTENCENAME+" transferencia";
	public static String QUERYSELECTNATIVE="select "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".version_row,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_empresa,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_sucursal,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_modulo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_periodo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_anio,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_mes,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_usuario,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".fecha_emision,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".fecha_entrega,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".numero_secuencial,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_moneda,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_tipo_cambio,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_estado_inventario,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_formato,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_transportista,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_empleado,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".descripcion,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".porcentaje_descuento,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".suman,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".ice,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".valor_descuento,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".total_descuento,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".iva,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".stock,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".sub_total,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".total_otro,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".ultimo_costo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".numero_items,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".retencion,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".total,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".flete,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".impuesto,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_asiento_contable,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".numero_comprobante,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".fecha from "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME;//+" as "+TransferenciaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".version_row from "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME;//+" as "+TransferenciaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_inventario=?,id_formato=?,id_transportista=?,id_empleado=?,descripcion=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_asiento_contable=?,numero_comprobante=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSFERENCIA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSFERENCIA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSFERENCIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSFERENCIA_SELECT(?,?)";
	
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
	
	
	protected TransferenciaDataAccessAdditional transferenciaDataAccessAdditional=null;
	
	public TransferenciaDataAccessAdditional getTransferenciaDataAccessAdditional() {
		return this.transferenciaDataAccessAdditional;
	}
	
	public void setTransferenciaDataAccessAdditional(TransferenciaDataAccessAdditional transferenciaDataAccessAdditional) {
		try {
			this.transferenciaDataAccessAdditional=transferenciaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransferenciaDataAccess() {
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
		TransferenciaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransferenciaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransferenciaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransferenciaOriginal(Transferencia transferencia)throws Exception  {
		transferencia.setTransferenciaOriginal((Transferencia)transferencia.clone());		
	}
	
	public void setTransferenciasOriginal(List<Transferencia> transferencias)throws Exception  {
		
		for(Transferencia transferencia:transferencias){
			transferencia.setTransferenciaOriginal((Transferencia)transferencia.clone());
		}
	}
	
	public static void setTransferenciaOriginalStatic(Transferencia transferencia)throws Exception  {
		transferencia.setTransferenciaOriginal((Transferencia)transferencia.clone());		
	}
	
	public static void setTransferenciasOriginalStatic(List<Transferencia> transferencias)throws Exception  {
		
		for(Transferencia transferencia:transferencias){
			transferencia.setTransferenciaOriginal((Transferencia)transferencia.clone());
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
	
	public  Transferencia getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Transferencia entity = new Transferencia();		
		
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
	
	public  Transferencia getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Transferencia entity = new Transferencia();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Transferencia.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransferenciaOriginal(new Transferencia());
      	    	entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransferencia("",entity,resultSet); 
				
				//entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransferencia(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Transferencia getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transferencia entity = new Transferencia();
				
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
	
	public  Transferencia getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transferencia entity = new Transferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Transferencia.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransferenciaOriginal(new Transferencia());
      	    	entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransferencia("",entity,resultSet);    
				
				//entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Transferencia
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Transferencia entity = new Transferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Transferencia.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Transferencia> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		
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
	
	public  List<Transferencia> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transferencia();
      	    	entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransferencia("",entity,resultSet);
      	    	
				//entity.setTransferenciaOriginal( new Transferencia());
      	    	//entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransferencias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
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
	
	public  List<Transferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapTransferencia();
					//entity.setMapTransferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=TransferenciaDataAccess.getEntityTransferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransferenciaOriginal( new Transferencia());
					////entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransferencias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Transferencia getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transferencia entity = new Transferencia();		  
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
	
	public  Transferencia getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transferencia entity = new Transferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapTransferencia();
					//entity.setMapTransferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=TransferenciaDataAccess.getEntityTransferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransferenciaOriginal( new Transferencia());
					////entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransferencia(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Transferencia getEntityTransferencia(String strPrefijo,Transferencia entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Transferencia.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Transferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransferenciaDataAccess.setFieldReflectionTransferencia(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransferencia=TransferenciaConstantesFunciones.getTodosTiposColumnasTransferencia();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransferencia) {
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
							field = Transferencia.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Transferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransferenciaDataAccess.setFieldReflectionTransferencia(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransferencia(Field field,String strPrefijo,String sColumn,Transferencia entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransferenciaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TransferenciaConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TransferenciaConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDESTADOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.VALORDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.STOCK:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.NUMEROITEMS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransferenciaConstantesFunciones.FECHA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transferencia>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Transferencia();
					entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransferencia("",entity,resultSet);
					
					//entity.setTransferenciaOriginal( new Transferencia());
					//entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
					//entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransferencias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transferencia>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Transferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
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
	
	public  List<Transferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transferencia();
      	    	entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransferencia("",entity,resultSet);
      	    	
				//entity.setTransferenciaOriginal( new Transferencia());
      	    	//entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransferencias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transferencia> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
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
	
	public  List<Transferencia> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transferencia> entities = new  ArrayList<Transferencia>();
		Transferencia entity = new Transferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transferencia();
      	    	entity=super.getEntity("",entity,resultSet,TransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransferencia("",entity,resultSet);
      	    	
				//entity.setTransferenciaOriginal( new Transferencia());
      	    	//entity.setTransferenciaOriginal(super.getEntity("",entity.getTransferenciaOriginal(),resultSet,TransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransferenciaOriginal(this.getEntityTransferencia("",entity.getTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransferencias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Transferencia getEntityTransferencia(String strPrefijo,Transferencia entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDUSUARIO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+TransferenciaConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+TransferenciaConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+TransferenciaConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_moneda(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDMONEDA));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_estado_inventario(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDESTADOINVENTARIO));
				entity.setid_formato(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDFORMATO));
				entity.setid_transportista(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setid_empleado(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDEMPLEADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+TransferenciaConstantesFunciones.DESCRIPCION));
				entity.setporcentaje_descuento(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO));
				entity.setsuman(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.SUMAN));
				entity.setice(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.ICE));
				entity.setvalor_descuento(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.VALORDESCUENTO));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.TOTALDESCUENTO));
				entity.setiva(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.IVA));
				entity.setstock(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.STOCK));
				entity.setsub_total(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.SUBTOTAL));
				entity.settotal_otro(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.TOTALOTRO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.ULTIMOCOSTO));
				entity.setnumero_items(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.NUMEROITEMS));
				entity.setretencion(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.RETENCION));
				entity.settotal(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.TOTAL));
				entity.setflete(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.FLETE));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+TransferenciaConstantesFunciones.IMPUESTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+TransferenciaConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+TransferenciaConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+TransferenciaConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransferencia(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Transferencia entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransferenciaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransferenciaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransferenciaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransferenciaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransferenciaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TransferenciaDataAccess.TABLENAME,TransferenciaDataAccess.ISWITHSTOREPROCEDURES);
			
			TransferenciaDataAccess.setTransferenciaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltransferencia.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltransferencia.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltransferencia.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reltransferencia.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reltransferencia.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reltransferencia.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reltransferencia.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,reltransferencia.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,reltransferencia.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoCambio getTipoCambio(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,reltransferencia.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public EstadoInventario getEstadoInventario(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		EstadoInventario estadoinventario= new EstadoInventario();

		try {
			EstadoInventarioDataAccess estadoinventarioDataAccess=new EstadoInventarioDataAccess();

			estadoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoinventarioDataAccess.setConnexionType(this.connexionType);
			estadoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			estadoinventario=estadoinventarioDataAccess.getEntity(connexion,reltransferencia.getid_estado_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoinventario;

	}

	public Formato getFormato(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,reltransferencia.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Transportista getTransportista(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,reltransferencia.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public Empleado getEmpleado(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,reltransferencia.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reltransferencia.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,Transferencia reltransferencia)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reltransferencia.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
		public List<DetalleTransferencia> getDetalleTransferencias(Connexion connexion,Transferencia transferencia)throws SQLException,Exception {

		List<DetalleTransferencia> detalletransferencias= new ArrayList<DetalleTransferencia>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransferenciaConstantesFunciones.SCHEMA+".transferencia ON "+DetalleTransferenciaConstantesFunciones.SCHEMA+".detalle_transferencia.id_transferencia="+TransferenciaConstantesFunciones.SCHEMA+".transferencia.id WHERE "+TransferenciaConstantesFunciones.SCHEMA+".transferencia.id="+String.valueOf(transferencia.getId());
			} else {
				sQuery=" INNER JOIN detalletransferencia.Transferencia WHERE detalletransferencia.Transferencia.id="+String.valueOf(transferencia.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleTransferenciaDataAccess detalletransferenciaDataAccess=new DetalleTransferenciaDataAccess();

			detalletransferenciaDataAccess.setConnexionType(this.connexionType);
			detalletransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalletransferencias;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Transferencia transferencia) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transferencia.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(transferencia.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(transferencia.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(transferencia.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(transferencia.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(transferencia.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(transferencia.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(transferencia.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(transferencia.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(transferencia.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(transferencia.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(transferencia.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(transferencia.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(transferencia.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_inventario.setValue(transferencia.getid_estado_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(transferencia.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(transferencia.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(transferencia.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(transferencia.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_descuento=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_descuento.setValue(transferencia.getporcentaje_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(transferencia.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(transferencia.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_descuento.setValue(transferencia.getvalor_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(transferencia.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(transferencia.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock=new ParameterValue<Double>();
					parameterMaintenanceValuestock.setValue(transferencia.getstock());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(transferencia.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_otro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_otro.setValue(transferencia.gettotal_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(transferencia.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_items=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_items.setValue(transferencia.getnumero_items());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_items);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(transferencia.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(transferencia.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(transferencia.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(transferencia.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(transferencia.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(transferencia.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(transferencia.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(transferencia.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!transferencia.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transferencia.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transferencia.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transferencia.getId());
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
	
	public void setIsNewIsChangedFalseTransferencia(Transferencia transferencia)throws Exception  {		
		transferencia.setIsNew(false);
		transferencia.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransferencias(List<Transferencia> transferencias)throws Exception  {				
		for(Transferencia transferencia:transferencias) {
			transferencia.setIsNew(false);
			transferencia.setIsChanged(false);
		}
	}
	
	public void generarExportarTransferencia(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
