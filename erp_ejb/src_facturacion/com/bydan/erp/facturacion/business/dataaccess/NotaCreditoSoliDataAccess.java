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
import com.bydan.erp.facturacion.util.*;//NotaCreditoSoliConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class NotaCreditoSoliDataAccess extends  NotaCreditoSoliDataAccessAdditional{ //NotaCreditoSoliDataAccessAdditional,DataAccessHelper<NotaCreditoSoli>
	//static Logger logger = Logger.getLogger(NotaCreditoSoliDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="nota_credito_soli";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,codigo,numero,fecha_emision,numero_dias,fecha_vencimiento,id_moneda,id_empleado,cotizacion,id_formato,id_tipo_precio,id_cliente,id_factura,direccion,telefono,ruc,id_tipo_nota_credito_soli,id_responsable,id_estado_nota_credito,descripcion,penalizado,descuento_porcentaje,total_iva,suman,descuento_valor,total_sin_iva,descuento_general,flete,total,sub_total,otro,iva,financiamiento,otro_valor,retencion,ice,fecha,id_centro_costo,id_vendedor,id_tipo_cambio,id_transporte,id_transportista,fecha_cliente,fecha_autorizacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,codigo=?,numero=?,fecha_emision=?,numero_dias=?,fecha_vencimiento=?,id_moneda=?,id_empleado=?,cotizacion=?,id_formato=?,id_tipo_precio=?,id_cliente=?,id_factura=?,direccion=?,telefono=?,ruc=?,id_tipo_nota_credito_soli=?,id_responsable=?,id_estado_nota_credito=?,descripcion=?,penalizado=?,descuento_porcentaje=?,total_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,descuento_general=?,flete=?,total=?,sub_total=?,otro=?,iva=?,financiamiento=?,otro_valor=?,retencion=?,ice=?,fecha=?,id_centro_costo=?,id_vendedor=?,id_tipo_cambio=?,id_transporte=?,id_transportista=?,fecha_cliente=?,fecha_autorizacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select notacreditosoli from "+NotaCreditoSoliConstantesFunciones.SPERSISTENCENAME+" notacreditosoli";
	public static String QUERYSELECTNATIVE="select "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_empresa,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_sucursal,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_ejercicio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_periodo,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_anio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_mes,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_usuario,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".codigo,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".numero,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_emision,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".numero_dias,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_vencimiento,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_moneda,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_empleado,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".cotizacion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_formato,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_precio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_cliente,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_factura,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".direccion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".telefono,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".ruc,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_nota_credito_soli,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_responsable,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_estado_nota_credito,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descripcion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".penalizado,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descuento_porcentaje,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".total_iva,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".suman,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descuento_valor,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".total_sin_iva,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".descuento_general,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".flete,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".total,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".sub_total,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".otro,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".iva,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".financiamiento,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".otro_valor,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".retencion,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".ice,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_centro_costo,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_vendedor,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_cambio,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_transporte,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id_transportista,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_cliente,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_autorizacion from "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+NotaCreditoSoliConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+".codigo from "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+NotaCreditoSoliConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NotaCreditoSoliConstantesFunciones.SCHEMA+"."+NotaCreditoSoliConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,codigo=?,numero=?,fecha_emision=?,numero_dias=?,fecha_vencimiento=?,id_moneda=?,id_empleado=?,cotizacion=?,id_formato=?,id_tipo_precio=?,id_cliente=?,id_factura=?,direccion=?,telefono=?,ruc=?,id_tipo_nota_credito_soli=?,id_responsable=?,id_estado_nota_credito=?,descripcion=?,penalizado=?,descuento_porcentaje=?,total_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,descuento_general=?,flete=?,total=?,sub_total=?,otro=?,iva=?,financiamiento=?,otro_valor=?,retencion=?,ice=?,fecha=?,id_centro_costo=?,id_vendedor=?,id_tipo_cambio=?,id_transporte=?,id_transportista=?,fecha_cliente=?,fecha_autorizacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NOTACREDITOSOLI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NOTACREDITOSOLI_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NOTACREDITOSOLI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NOTACREDITOSOLI_SELECT(?,?)";
	
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
	
	
	protected NotaCreditoSoliDataAccessAdditional notacreditosoliDataAccessAdditional=null;
	
	public NotaCreditoSoliDataAccessAdditional getNotaCreditoSoliDataAccessAdditional() {
		return this.notacreditosoliDataAccessAdditional;
	}
	
	public void setNotaCreditoSoliDataAccessAdditional(NotaCreditoSoliDataAccessAdditional notacreditosoliDataAccessAdditional) {
		try {
			this.notacreditosoliDataAccessAdditional=notacreditosoliDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NotaCreditoSoliDataAccess() {
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
		NotaCreditoSoliDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NotaCreditoSoliDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NotaCreditoSoliDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNotaCreditoSoliOriginal(NotaCreditoSoli notacreditosoli)throws Exception  {
		notacreditosoli.setNotaCreditoSoliOriginal((NotaCreditoSoli)notacreditosoli.clone());		
	}
	
	public void setNotaCreditoSolisOriginal(List<NotaCreditoSoli> notacreditosolis)throws Exception  {
		
		for(NotaCreditoSoli notacreditosoli:notacreditosolis){
			notacreditosoli.setNotaCreditoSoliOriginal((NotaCreditoSoli)notacreditosoli.clone());
		}
	}
	
	public static void setNotaCreditoSoliOriginalStatic(NotaCreditoSoli notacreditosoli)throws Exception  {
		notacreditosoli.setNotaCreditoSoliOriginal((NotaCreditoSoli)notacreditosoli.clone());		
	}
	
	public static void setNotaCreditoSolisOriginalStatic(List<NotaCreditoSoli> notacreditosolis)throws Exception  {
		
		for(NotaCreditoSoli notacreditosoli:notacreditosolis){
			notacreditosoli.setNotaCreditoSoliOriginal((NotaCreditoSoli)notacreditosoli.clone());
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
	
	public  NotaCreditoSoli getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NotaCreditoSoli entity = new NotaCreditoSoli();		
		
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
	
	public  NotaCreditoSoli getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NotaCreditoSoli entity = new NotaCreditoSoli();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.NotaCreditoSoli.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNotaCreditoSoliOriginal(new NotaCreditoSoli());
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNotaCreditoSoli("",entity,resultSet); 
				
				//entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNotaCreditoSoli(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NotaCreditoSoli getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NotaCreditoSoli entity = new NotaCreditoSoli();
				
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
	
	public  NotaCreditoSoli getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NotaCreditoSoli entity = new NotaCreditoSoli();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.NotaCreditoSoli.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNotaCreditoSoliOriginal(new NotaCreditoSoli());
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNotaCreditoSoli("",entity,resultSet);    
				
				//entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNotaCreditoSoli(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NotaCreditoSoli
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NotaCreditoSoli entity = new NotaCreditoSoli();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.NotaCreditoSoli.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNotaCreditoSoli(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NotaCreditoSoli> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		
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
	
	public  List<NotaCreditoSoli> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setNotaCreditoSoliOriginal( new NotaCreditoSoli());
      	    	//entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditoSolis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NotaCreditoSoli> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
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
	
	public  List<NotaCreditoSoli> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoSoli();
				
				if(conMapGenerico) {
					entity.inicializarMapNotaCreditoSoli();
					//entity.setMapNotaCreditoSoli(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNotaCreditoSoliValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNotaCreditoSoli().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=NotaCreditoSoliDataAccess.getEntityNotaCreditoSoli("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNotaCreditoSoliOriginal( new NotaCreditoSoli());
					////entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					////entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditoSolis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NotaCreditoSoli getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
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
	
	public  NotaCreditoSoli getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoSoli();
				
				if(conMapGenerico) {
					entity.inicializarMapNotaCreditoSoli();
					//entity.setMapNotaCreditoSoli(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNotaCreditoSoliValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNotaCreditoSoli().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=NotaCreditoSoliDataAccess.getEntityNotaCreditoSoli("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNotaCreditoSoliOriginal( new NotaCreditoSoli());
					////entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					////entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNotaCreditoSoli(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NotaCreditoSoli getEntityNotaCreditoSoli(String strPrefijo,NotaCreditoSoli entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NotaCreditoSoli.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NotaCreditoSoli.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NotaCreditoSoliDataAccess.setFieldReflectionNotaCreditoSoli(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNotaCreditoSoli=NotaCreditoSoliConstantesFunciones.getTodosTiposColumnasNotaCreditoSoli();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNotaCreditoSoli) {
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
							field = NotaCreditoSoli.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NotaCreditoSoli.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NotaCreditoSoliDataAccess.setFieldReflectionNotaCreditoSoli(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNotaCreditoSoli(Field field,String strPrefijo,String sColumn,NotaCreditoSoli entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NotaCreditoSoliConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoSoliConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDRESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.PENALIZADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.OTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.OTROVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FECHACLIENTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NotaCreditoSoli>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NotaCreditoSoli();
					entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNotaCreditoSoli("",entity,resultSet);
					
					//entity.setNotaCreditoSoliOriginal( new NotaCreditoSoli());
					//entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					//entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNotaCreditoSolis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NotaCreditoSoli>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NotaCreditoSoli> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
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
	
	public  List<NotaCreditoSoli> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setNotaCreditoSoliOriginal( new NotaCreditoSoli());
      	    	//entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNotaCreditoSolis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NotaCreditoSoli> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
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
	
	public  List<NotaCreditoSoli> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoSoli> entities = new  ArrayList<NotaCreditoSoli>();
		NotaCreditoSoli entity = new NotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setNotaCreditoSoliOriginal( new NotaCreditoSoli());
      	    	//entity.setNotaCreditoSoliOriginal(super.getEntity("",entity.getNotaCreditoSoliOriginal(),resultSet,NotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoSoliOriginal(this.getEntityNotaCreditoSoli("",entity.getNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditoSolis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NotaCreditoSoli getEntityNotaCreditoSoli(String strPrefijo,NotaCreditoSoli entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDUSUARIO));
				entity.setcodigo(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.CODIGO));
				entity.setnumero(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+NotaCreditoSoliConstantesFunciones.FECHAEMISION).getTime()));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+NotaCreditoSoliConstantesFunciones.NUMERODIAS));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDMONEDA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDEMPLEADO));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.COTIZACION));
				entity.setid_formato(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDFACTURA));
				entity.setdireccion(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.TELEFONO));
				entity.setruc(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.RUC));
				entity.setid_tipo_nota_credito_soli(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI));
				entity.setid_responsable(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDRESPONSABLE));if(resultSet.wasNull()) {entity.setid_responsable(null); }
				entity.setid_estado_nota_credito(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI));
				entity.setdescripcion(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.DESCRIPCION));
				entity.setpenalizado(resultSet.getBoolean(strPrefijo+NotaCreditoSoliConstantesFunciones.PENALIZADO));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.TOTALIVA));
				entity.setsuman(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.SUMAN));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.TOTALSINIVA));
				entity.setdescuento_general(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL));
				entity.setflete(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.FLETE));
				entity.settotal(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.TOTAL));
				entity.setsub_total(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.SUBTOTAL));
				entity.setotro(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.OTRO));
				entity.setiva(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.IVA));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO));
				entity.setotro_valor(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.OTROVALOR));
				entity.setretencion(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.RETENCION));
				entity.setice(resultSet.getDouble(strPrefijo+NotaCreditoSoliConstantesFunciones.ICE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+NotaCreditoSoliConstantesFunciones.FECHA).getTime()));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_vendedor(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_transporte(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDTRANSPORTE));if(resultSet.wasNull()) {entity.setid_transporte(null); }
				entity.setid_transportista(resultSet.getLong(strPrefijo+NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setfecha_cliente(new Date(resultSet.getDate(strPrefijo+NotaCreditoSoliConstantesFunciones.FECHACLIENTE).getTime()));
				entity.setfecha_autorizacion(new Date(resultSet.getDate(strPrefijo+NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION).getTime()));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+NotaCreditoSoliConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNotaCreditoSoli(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NotaCreditoSoli entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NotaCreditoSoliDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NotaCreditoSoliDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NotaCreditoSoliDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NotaCreditoSoliDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NotaCreditoSoliConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NotaCreditoSoliDataAccess.TABLENAME,NotaCreditoSoliDataAccess.ISWITHSTOREPROCEDURES);
			
			NotaCreditoSoliDataAccess.setNotaCreditoSoliOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnotacreditosoli.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relnotacreditosoli.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relnotacreditosoli.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relnotacreditosoli.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relnotacreditosoli.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relnotacreditosoli.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relnotacreditosoli.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relnotacreditosoli.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relnotacreditosoli.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relnotacreditosoli.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relnotacreditosoli.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Cliente getCliente(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relnotacreditosoli.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relnotacreditosoli.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public TipoNotaCreditoSoli getTipoNotaCreditoSoli(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		TipoNotaCreditoSoli tiponotacreditosoli= new TipoNotaCreditoSoli();

		try {
			TipoNotaCreditoSoliDataAccess tiponotacreditosoliDataAccess=new TipoNotaCreditoSoliDataAccess();

			tiponotacreditosoliDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiponotacreditosoliDataAccess.setConnexionType(this.connexionType);
			tiponotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);

			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion,relnotacreditosoli.getid_tipo_nota_credito_soli());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiponotacreditosoli;

	}

	public Responsable getResponsable(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Responsable responsable= new Responsable();

		try {
			ResponsableDataAccess responsableDataAccess=new ResponsableDataAccess();

			responsableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			responsableDataAccess.setConnexionType(this.connexionType);
			responsableDataAccess.setParameterDbType(this.parameterDbType);

			responsable=responsableDataAccess.getEntity(connexion,relnotacreditosoli.getid_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsable;

	}

	public EstadoNotaCredito getEstadoNotaCreditoSoli(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		EstadoNotaCredito estadonotacredito= new EstadoNotaCredito();

		try {
			EstadoNotaCreditoDataAccess estadonotacreditoDataAccess=new EstadoNotaCreditoDataAccess();

			estadonotacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadonotacreditoDataAccess.setConnexionType(this.connexionType);
			estadonotacreditoDataAccess.setParameterDbType(this.parameterDbType);

			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,relnotacreditosoli.getid_estado_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadonotacredito;

	}

	public CentroCosto getCentroCosto(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relnotacreditosoli.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Vendedor getVendedor(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relnotacreditosoli.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public TipoCambio getTipoCambio(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relnotacreditosoli.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public Transporte getTransporte(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relnotacreditosoli.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public Transportista getTransportista(Connexion connexion,NotaCreditoSoli relnotacreditosoli)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relnotacreditosoli.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}


		
		public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis(Connexion connexion,NotaCreditoSoli notacreditosoli)throws SQLException,Exception {

		List<DetaNotaCreditoSoli> detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli ON "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+".deta_nota_credito_soli.id_nota_credito_soli="+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id WHERE "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id="+String.valueOf(notacreditosoli.getId());
			} else {
				sQuery=" INNER JOIN detanotacreditosoli.NotaCreditoSoli WHERE detanotacreditosoli.NotaCreditoSoli.id="+String.valueOf(notacreditosoli.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoSoliDataAccess detanotacreditosoliDataAccess=new DetaNotaCreditoSoliDataAccess();

			detanotacreditosoliDataAccess.setConnexionType(this.connexionType);
			detanotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditosolis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NotaCreditoSoli notacreditosoli) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!notacreditosoli.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(notacreditosoli.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(notacreditosoli.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(notacreditosoli.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(notacreditosoli.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(notacreditosoli.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(notacreditosoli.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(notacreditosoli.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(notacreditosoli.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(notacreditosoli.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(notacreditosoli.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(notacreditosoli.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(notacreditosoli.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(notacreditosoli.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(notacreditosoli.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(notacreditosoli.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(notacreditosoli.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(notacreditosoli.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(notacreditosoli.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(notacreditosoli.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(notacreditosoli.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(notacreditosoli.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(notacreditosoli.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_nota_credito_soli=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_nota_credito_soli.setValue(notacreditosoli.getid_tipo_nota_credito_soli());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_nota_credito_soli);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_responsable.setValue(notacreditosoli.getid_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_nota_credito.setValue(notacreditosoli.getid_estado_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(notacreditosoli.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepenalizado=new ParameterValue<Boolean>();
					parameterMaintenanceValuepenalizado.setValue(notacreditosoli.getpenalizado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepenalizado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(notacreditosoli.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(notacreditosoli.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(notacreditosoli.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(notacreditosoli.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(notacreditosoli.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_general=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_general.setValue(notacreditosoli.getdescuento_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(notacreditosoli.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(notacreditosoli.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(notacreditosoli.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro=new ParameterValue<Double>();
					parameterMaintenanceValueotro.setValue(notacreditosoli.getotro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(notacreditosoli.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(notacreditosoli.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro_valor=new ParameterValue<Double>();
					parameterMaintenanceValueotro_valor.setValue(notacreditosoli.getotro_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(notacreditosoli.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(notacreditosoli.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(notacreditosoli.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(notacreditosoli.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(notacreditosoli.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(notacreditosoli.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(notacreditosoli.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(notacreditosoli.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_cliente=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_cliente.setValue(notacreditosoli.getfecha_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_autorizacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_autorizacion.setValue(notacreditosoli.getfecha_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!notacreditosoli.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(notacreditosoli.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(notacreditosoli.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(notacreditosoli.getId());
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
	
	public void setIsNewIsChangedFalseNotaCreditoSoli(NotaCreditoSoli notacreditosoli)throws Exception  {		
		notacreditosoli.setIsNew(false);
		notacreditosoli.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis)throws Exception  {				
		for(NotaCreditoSoli notacreditosoli:notacreditosolis) {
			notacreditosoli.setIsNew(false);
			notacreditosoli.setIsChanged(false);
		}
	}
	
	public void generarExportarNotaCreditoSoli(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
