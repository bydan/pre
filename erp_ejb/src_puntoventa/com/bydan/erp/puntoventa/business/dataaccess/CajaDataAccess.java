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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//CajaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class CajaDataAccess extends  DataAccessHelper<Caja>{ //CajaDataAccessAdditional,DataAccessHelper<Caja>
	//static Logger logger = Logger.getLogger(CajaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="caja";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,nombre,nombre_equipo,nombre_impresora,secuencial_pedido,secuencial_pedido_formato,punto_emision,establecimiento,fecha_inicio,fecha_final,esta_activo,descripcion,secuencial_factura,secuencial_factura_formato,secuencial_nota_venta,secuencial_nota_venta_formato,secuencia_nota_credito,secuencia_nota_credito_formato,autorizacion_factura,autorizacion_nota_venta,autorizacion_nota_credito,fecha_caduca_factura,fecha_caduca_nota_venta,fecha_caduca_nota_credito,serie_factura,serie_nota_venta,serie_nota_credito,sec_inicial_factura,sec_inicial_nota_venta,sec_inicial_nota_credito,sec_final_factura,sec_final_nota_venta,sec_final_nota_credito,id_pais,id_ciudad,id_zona)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,nombre=?,nombre_equipo=?,nombre_impresora=?,secuencial_pedido=?,secuencial_pedido_formato=?,punto_emision=?,establecimiento=?,fecha_inicio=?,fecha_final=?,esta_activo=?,descripcion=?,secuencial_factura=?,secuencial_factura_formato=?,secuencial_nota_venta=?,secuencial_nota_venta_formato=?,secuencia_nota_credito=?,secuencia_nota_credito_formato=?,autorizacion_factura=?,autorizacion_nota_venta=?,autorizacion_nota_credito=?,fecha_caduca_factura=?,fecha_caduca_nota_venta=?,fecha_caduca_nota_credito=?,serie_factura=?,serie_nota_venta=?,serie_nota_credito=?,sec_inicial_factura=?,sec_inicial_nota_venta=?,sec_inicial_nota_credito=?,sec_final_factura=?,sec_final_nota_venta=?,sec_final_nota_credito=?,id_pais=?,id_ciudad=?,id_zona=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select caja from "+CajaConstantesFunciones.SPERSISTENCENAME+" caja";
	public static String QUERYSELECTNATIVE="select "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".version_row,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_empresa,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_sucursal,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre_equipo,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre_impresora,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_pedido,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_pedido_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".punto_emision,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".establecimiento,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_inicio,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_final,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".esta_activo,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".descripcion,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_factura_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencial_nota_venta_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencia_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".secuencia_nota_credito_formato,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".autorizacion_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".autorizacion_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".autorizacion_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_caduca_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_caduca_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".fecha_caduca_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".serie_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".serie_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".serie_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_inicial_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_inicial_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_inicial_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_final_factura,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_final_nota_venta,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".sec_final_nota_credito,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_pais,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_ciudad,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id_zona from "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME;//+" as "+CajaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".id,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".version_row,"+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+".nombre from "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME;//+" as "+CajaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CajaConstantesFunciones.SCHEMA+"."+CajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,nombre=?,nombre_equipo=?,nombre_impresora=?,secuencial_pedido=?,secuencial_pedido_formato=?,punto_emision=?,establecimiento=?,fecha_inicio=?,fecha_final=?,esta_activo=?,descripcion=?,secuencial_factura=?,secuencial_factura_formato=?,secuencial_nota_venta=?,secuencial_nota_venta_formato=?,secuencia_nota_credito=?,secuencia_nota_credito_formato=?,autorizacion_factura=?,autorizacion_nota_venta=?,autorizacion_nota_credito=?,fecha_caduca_factura=?,fecha_caduca_nota_venta=?,fecha_caduca_nota_credito=?,serie_factura=?,serie_nota_venta=?,serie_nota_credito=?,sec_inicial_factura=?,sec_inicial_nota_venta=?,sec_inicial_nota_credito=?,sec_final_factura=?,sec_final_nota_venta=?,sec_final_nota_credito=?,id_pais=?,id_ciudad=?,id_zona=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CAJA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CAJA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CAJA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CAJA_SELECT(?,?)";
	
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
	
	
	public CajaDataAccess() {
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
		CajaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CajaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CajaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCajaOriginal(Caja caja)throws Exception  {
		caja.setCajaOriginal((Caja)caja.clone());		
	}
	
	public void setCajasOriginal(List<Caja> cajas)throws Exception  {
		
		for(Caja caja:cajas){
			caja.setCajaOriginal((Caja)caja.clone());
		}
	}
	
	public static void setCajaOriginalStatic(Caja caja)throws Exception  {
		caja.setCajaOriginal((Caja)caja.clone());		
	}
	
	public static void setCajasOriginalStatic(List<Caja> cajas)throws Exception  {
		
		for(Caja caja:cajas){
			caja.setCajaOriginal((Caja)caja.clone());
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
	
	public  Caja getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Caja entity = new Caja();		
		
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
	
	public  Caja getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Caja entity = new Caja();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.Caja.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCajaOriginal(new Caja());
      	    	entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCaja("",entity,resultSet); 
				
				//entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCaja(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Caja getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Caja entity = new Caja();
				
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
	
	public  Caja getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Caja entity = new Caja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.Caja.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCajaOriginal(new Caja());
      	    	entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCaja("",entity,resultSet);    
				
				//entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Caja
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Caja entity = new Caja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.Caja.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Caja> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
		
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
	
	public  List<Caja> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Caja();
      	    	entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCaja("",entity,resultSet);
      	    	
				//entity.setCajaOriginal( new Caja());
      	    	//entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Caja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
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
	
	public  List<Caja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Caja();
				
				if(conMapGenerico) {
					entity.inicializarMapCaja();
					//entity.setMapCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         		
					entity=CajaDataAccess.getEntityCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaOriginal( new Caja());
					////entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Caja getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Caja entity = new Caja();		  
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
	
	public  Caja getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Caja entity = new Caja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Caja();
				
				if(conMapGenerico) {
					entity.inicializarMapCaja();
					//entity.setMapCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         		
					entity=CajaDataAccess.getEntityCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaOriginal( new Caja());
					////entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCaja(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Caja getEntityCaja(String strPrefijo,Caja entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Caja.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Caja.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CajaDataAccess.setFieldReflectionCaja(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCaja=CajaConstantesFunciones.getTodosTiposColumnasCaja();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCaja) {
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
							field = Caja.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Caja.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CajaDataAccess.setFieldReflectionCaja(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCaja(Field field,String strPrefijo,String sColumn,Caja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.NOMBREEQUIPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.NOMBREIMPRESORA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIALPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.PUNTOEMISION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.ESTABLECIMIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CajaConstantesFunciones.FECHAFINAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CajaConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CajaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIALFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIALFACTURAFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIALNOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIANOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.AUTORIZACIONFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.AUTORIZACIONNOTAVENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.AUTORIZACIONNOTACREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.FECHACADUCAFACTURA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CajaConstantesFunciones.FECHACADUCANOTAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CajaConstantesFunciones.FECHACADUCANOTACREDITO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CajaConstantesFunciones.SERIEFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SERIENOTAVENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SERIENOTACREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECINICIALFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECINICIALNOTAVENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECINICIALNOTACREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECFINALFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECFINALNOTAVENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.SECFINALNOTACREDITO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaConstantesFunciones.IDZONA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Caja>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Caja();
					entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCaja("",entity,resultSet);
					
					//entity.setCajaOriginal( new Caja());
					//entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
					//entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCajas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Caja>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Caja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
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
	
	public  List<Caja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Caja> entities = new  ArrayList<Caja>();
		Caja entity = new Caja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Caja();
      	    	entity=super.getEntity("",entity,resultSet,CajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCaja("",entity,resultSet);
      	    	
				//entity.setCajaOriginal( new Caja());
      	    	//entity.setCajaOriginal(super.getEntity("",entity.getCajaOriginal(),resultSet,CajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaOriginal(this.getEntityCaja("",entity.getCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCajas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public Caja getEntityCaja(String strPrefijo,Caja entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CajaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CajaConstantesFunciones.IDSUCURSAL));
				entity.setnombre(resultSet.getString(strPrefijo+CajaConstantesFunciones.NOMBRE));
				entity.setnombre_equipo(resultSet.getString(strPrefijo+CajaConstantesFunciones.NOMBREEQUIPO));
				entity.setnombre_impresora(resultSet.getString(strPrefijo+CajaConstantesFunciones.NOMBREIMPRESORA));
				entity.setsecuencial_pedido(resultSet.getLong(strPrefijo+CajaConstantesFunciones.SECUENCIALPEDIDO));
				entity.setsecuencial_pedido_formato(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO));
				entity.setpunto_emision(resultSet.getString(strPrefijo+CajaConstantesFunciones.PUNTOEMISION));
				entity.setestablecimiento(resultSet.getString(strPrefijo+CajaConstantesFunciones.ESTABLECIMIENTO));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+CajaConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_final(new Date(resultSet.getDate(strPrefijo+CajaConstantesFunciones.FECHAFINAL).getTime()));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+CajaConstantesFunciones.ESTAACTIVO));
				entity.setdescripcion(resultSet.getString(strPrefijo+CajaConstantesFunciones.DESCRIPCION));
				entity.setsecuencial_factura(resultSet.getLong(strPrefijo+CajaConstantesFunciones.SECUENCIALFACTURA));
				entity.setsecuencial_factura_formato(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECUENCIALFACTURAFORMATO));
				entity.setsecuencial_nota_venta(resultSet.getLong(strPrefijo+CajaConstantesFunciones.SECUENCIALNOTAVENTA));
				entity.setsecuencial_nota_venta_formato(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO));
				entity.setsecuencia_nota_credito(resultSet.getLong(strPrefijo+CajaConstantesFunciones.SECUENCIANOTACREDITO));
				entity.setsecuencia_nota_credito_formato(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO));
				entity.setautorizacion_factura(resultSet.getString(strPrefijo+CajaConstantesFunciones.AUTORIZACIONFACTURA));
				entity.setautorizacion_nota_venta(resultSet.getString(strPrefijo+CajaConstantesFunciones.AUTORIZACIONNOTAVENTA));
				entity.setautorizacion_nota_credito(resultSet.getString(strPrefijo+CajaConstantesFunciones.AUTORIZACIONNOTACREDITO));
				entity.setfecha_caduca_factura(new Date(resultSet.getDate(strPrefijo+CajaConstantesFunciones.FECHACADUCAFACTURA).getTime()));
				entity.setfecha_caduca_nota_venta(new Date(resultSet.getDate(strPrefijo+CajaConstantesFunciones.FECHACADUCANOTAVENTA).getTime()));
				entity.setfecha_caduca_nota_credito(new Date(resultSet.getDate(strPrefijo+CajaConstantesFunciones.FECHACADUCANOTACREDITO).getTime()));
				entity.setserie_factura(resultSet.getString(strPrefijo+CajaConstantesFunciones.SERIEFACTURA));
				entity.setserie_nota_venta(resultSet.getString(strPrefijo+CajaConstantesFunciones.SERIENOTAVENTA));
				entity.setserie_nota_credito(resultSet.getString(strPrefijo+CajaConstantesFunciones.SERIENOTACREDITO));
				entity.setsec_inicial_factura(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECINICIALFACTURA));
				entity.setsec_inicial_nota_venta(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECINICIALNOTAVENTA));
				entity.setsec_inicial_nota_credito(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECINICIALNOTACREDITO));
				entity.setsec_final_factura(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECFINALFACTURA));
				entity.setsec_final_nota_venta(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECFINALNOTAVENTA));
				entity.setsec_final_nota_credito(resultSet.getString(strPrefijo+CajaConstantesFunciones.SECFINALNOTACREDITO));
				entity.setid_pais(resultSet.getLong(strPrefijo+CajaConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+CajaConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+CajaConstantesFunciones.IDZONA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CajaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCaja(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Caja entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CajaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CajaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CajaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CajaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CajaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CajaDataAccess.TABLENAME,CajaDataAccess.ISWITHSTOREPROCEDURES);
			
			CajaDataAccess.setCajaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Caja relcaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Caja relcaja)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcaja.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Pais getPais(Connexion connexion,Caja relcaja)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relcaja.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,Caja relcaja)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relcaja.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,Caja relcaja)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relcaja.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}


		
		public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<NotaCreditoPuntoVenta> notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN notacreditopuntoventa.Caja WHERE notacreditopuntoventa.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventas;

	}

	public List<CajaCierre> getCajaCierres(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<CajaCierre> cajacierres= new ArrayList<CajaCierre>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+CajaCierreConstantesFunciones.SCHEMA+".caja_cierre.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN cajacierre.Caja WHERE cajacierre.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaCierreDataAccess cajacierreDataAccess=new CajaCierreDataAccess();

			cajacierreDataAccess.setConnexionType(this.connexionType);
			cajacierreDataAccess.setParameterDbType(this.parameterDbType);
			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajacierres;

	}

	public List<FacturaPuntoVenta> getFacturaPuntoVentas(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<FacturaPuntoVenta> facturapuntoventas= new ArrayList<FacturaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN facturapuntoventa.Caja WHERE facturapuntoventa.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventas;

	}

	public List<CajaEgreso> getCajaEgresos(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<CajaEgreso> cajaegresos= new ArrayList<CajaEgreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+CajaEgresoConstantesFunciones.SCHEMA+".caja_egreso.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN cajaegreso.Caja WHERE cajaegreso.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaEgresoDataAccess cajaegresoDataAccess=new CajaEgresoDataAccess();

			cajaegresoDataAccess.setConnexionType(this.connexionType);
			cajaegresoDataAccess.setParameterDbType(this.parameterDbType);
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaegresos;

	}

	public List<CajeroTurno> getCajeroTurnos(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<CajeroTurno> cajeroturnos= new ArrayList<CajeroTurno>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+CajeroTurnoConstantesFunciones.SCHEMA+".cajero_turno.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN cajeroturno.Caja WHERE cajeroturno.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajeroTurnoDataAccess cajeroturnoDataAccess=new CajeroTurnoDataAccess();

			cajeroturnoDataAccess.setConnexionType(this.connexionType);
			cajeroturnoDataAccess.setParameterDbType(this.parameterDbType);
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajeroturnos;

	}

	public List<PresupuestoVentasPunVen> getPresupuestoVentasPunVens(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<PresupuestoVentasPunVen> presupuestoventaspunvens= new ArrayList<PresupuestoVentasPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+".presupuesto_ventas_pun_ven.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN presupuestoventaspunven.Caja WHERE presupuestoventaspunven.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoVentasPunVenDataAccess presupuestoventaspunvenDataAccess=new PresupuestoVentasPunVenDataAccess();

			presupuestoventaspunvenDataAccess.setConnexionType(this.connexionType);
			presupuestoventaspunvenDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoventaspunvens=presupuestoventaspunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoventaspunvens;

	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<PedidoPuntoVenta> pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN pedidopuntoventa.Caja WHERE pedidopuntoventa.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoPuntoVentaDataAccess pedidopuntoventaDataAccess=new PedidoPuntoVentaDataAccess();

			pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidopuntoventas;

	}

	public List<CajaIngreso> getCajaIngresos(Connexion connexion,Caja caja)throws SQLException,Exception {

		List<CajaIngreso> cajaingresos= new ArrayList<CajaIngreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaConstantesFunciones.SCHEMA+".caja ON "+CajaIngresoConstantesFunciones.SCHEMA+".caja_ingreso.id_caja="+CajaConstantesFunciones.SCHEMA+".caja.id WHERE "+CajaConstantesFunciones.SCHEMA+".caja.id="+String.valueOf(caja.getId());
			} else {
				sQuery=" INNER JOIN cajaingreso.Caja WHERE cajaingreso.Caja.id="+String.valueOf(caja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaIngresoDataAccess cajaingresoDataAccess=new CajaIngresoDataAccess();

			cajaingresoDataAccess.setConnexionType(this.connexionType);
			cajaingresoDataAccess.setParameterDbType(this.parameterDbType);
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaingresos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Caja caja) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!caja.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(caja.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(caja.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(caja.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_equipo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_equipo.setValue(caja.getnombre_equipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_equipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_impresora=new ParameterValue<String>();
					parameterMaintenanceValuenombre_impresora.setValue(caja.getnombre_impresora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_impresora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencial_pedido=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencial_pedido.setValue(caja.getsecuencial_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_pedido_formato=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_pedido_formato.setValue(caja.getsecuencial_pedido_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_pedido_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepunto_emision=new ParameterValue<String>();
					parameterMaintenanceValuepunto_emision.setValue(caja.getpunto_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepunto_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueestablecimiento=new ParameterValue<String>();
					parameterMaintenanceValueestablecimiento.setValue(caja.getestablecimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestablecimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(caja.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_final=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_final.setValue(caja.getfecha_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(caja.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(caja.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencial_factura=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencial_factura.setValue(caja.getsecuencial_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_factura_formato=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_factura_formato.setValue(caja.getsecuencial_factura_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_factura_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencial_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencial_nota_venta.setValue(caja.getsecuencial_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_nota_venta_formato=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_nota_venta_formato.setValue(caja.getsecuencial_nota_venta_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_nota_venta_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencia_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencia_nota_credito.setValue(caja.getsecuencia_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencia_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencia_nota_credito_formato=new ParameterValue<String>();
					parameterMaintenanceValuesecuencia_nota_credito_formato.setValue(caja.getsecuencia_nota_credito_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencia_nota_credito_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautorizacion_factura=new ParameterValue<String>();
					parameterMaintenanceValueautorizacion_factura.setValue(caja.getautorizacion_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautorizacion_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautorizacion_nota_venta=new ParameterValue<String>();
					parameterMaintenanceValueautorizacion_nota_venta.setValue(caja.getautorizacion_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautorizacion_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautorizacion_nota_credito=new ParameterValue<String>();
					parameterMaintenanceValueautorizacion_nota_credito.setValue(caja.getautorizacion_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautorizacion_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caduca_factura=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caduca_factura.setValue(caja.getfecha_caduca_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caduca_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caduca_nota_venta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caduca_nota_venta.setValue(caja.getfecha_caduca_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caduca_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caduca_nota_credito=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caduca_nota_credito.setValue(caja.getfecha_caduca_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caduca_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie_factura=new ParameterValue<String>();
					parameterMaintenanceValueserie_factura.setValue(caja.getserie_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie_nota_venta=new ParameterValue<String>();
					parameterMaintenanceValueserie_nota_venta.setValue(caja.getserie_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie_nota_credito=new ParameterValue<String>();
					parameterMaintenanceValueserie_nota_credito.setValue(caja.getserie_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesec_inicial_factura=new ParameterValue<String>();
					parameterMaintenanceValuesec_inicial_factura.setValue(caja.getsec_inicial_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesec_inicial_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesec_inicial_nota_venta=new ParameterValue<String>();
					parameterMaintenanceValuesec_inicial_nota_venta.setValue(caja.getsec_inicial_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesec_inicial_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesec_inicial_nota_credito=new ParameterValue<String>();
					parameterMaintenanceValuesec_inicial_nota_credito.setValue(caja.getsec_inicial_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesec_inicial_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesec_final_factura=new ParameterValue<String>();
					parameterMaintenanceValuesec_final_factura.setValue(caja.getsec_final_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesec_final_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesec_final_nota_venta=new ParameterValue<String>();
					parameterMaintenanceValuesec_final_nota_venta.setValue(caja.getsec_final_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesec_final_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesec_final_nota_credito=new ParameterValue<String>();
					parameterMaintenanceValuesec_final_nota_credito.setValue(caja.getsec_final_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesec_final_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(caja.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(caja.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(caja.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
						if(!caja.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(caja.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(caja.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(caja.getId());
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
	
	public void setIsNewIsChangedFalseCaja(Caja caja)throws Exception  {		
		caja.setIsNew(false);
		caja.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCajas(List<Caja> cajas)throws Exception  {				
		for(Caja caja:cajas) {
			caja.setIsNew(false);
			caja.setIsChanged(false);
		}
	}
	
	public void generarExportarCaja(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
