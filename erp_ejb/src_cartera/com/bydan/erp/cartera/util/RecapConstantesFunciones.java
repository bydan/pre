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
package com.bydan.erp.cartera.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.RecapConstantesFunciones;
import com.bydan.erp.cartera.util.RecapParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RecapParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RecapConstantesFunciones extends RecapConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Recap";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Recap"+RecapConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RecapHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RecapHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RecapConstantesFunciones.SCHEMA+"_"+RecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RecapHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RecapConstantesFunciones.SCHEMA+"_"+RecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RecapConstantesFunciones.SCHEMA+"_"+RecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RecapConstantesFunciones.SCHEMA+"_"+RecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RecapHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RecapConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RecapConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RecapConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RecapConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Recapes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Recap";
	public static final String SCLASSWEBTITULO_LOWER="Recap";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Recap";
	public static final String OBJECTNAME="recap";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="recap";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select recap from "+RecapConstantesFunciones.SPERSISTENCENAME+" recap";
	public static String QUERYSELECTNATIVE="select "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".version_row,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id_empresa,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id_sucursal,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".id_ejercicio,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".numero,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".numero_autorizacion,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_inicio,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_final,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_elaboracion,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".fecha_caducidad,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".monto_iva,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".sin_monto_iva,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".iva,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".otro_impuesto,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".valor_propuesto,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".subtotal,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".financiero,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".total,"+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME+".valor_cambio from "+RecapConstantesFunciones.SCHEMA+"."+RecapConstantesFunciones.TABLENAME;//+" as "+RecapConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RecapConstantesFuncionesAdditional recapConstantesFuncionesAdditional=null;
	
	public RecapConstantesFuncionesAdditional getRecapConstantesFuncionesAdditional() {
		return this.recapConstantesFuncionesAdditional;
	}
	
	public void setRecapConstantesFuncionesAdditional(RecapConstantesFuncionesAdditional recapConstantesFuncionesAdditional) {
		try {
			this.recapConstantesFuncionesAdditional=recapConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String NUMERO= "numero";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFINAL= "fecha_final";
    public static final String FECHAELABORACION= "fecha_elaboracion";
    public static final String FECHACADUCIDAD= "fecha_caducidad";
    public static final String MONTOIVA= "monto_iva";
    public static final String SINMONTOIVA= "sin_monto_iva";
    public static final String IVA= "iva";
    public static final String OTROIMPUESTO= "otro_impuesto";
    public static final String VALORPROPUESTO= "valor_propuesto";
    public static final String SUBTOTAL= "subtotal";
    public static final String FINANCIERO= "financiero";
    public static final String TOTAL= "total";
    public static final String VALORCAMBIO= "valor_cambio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NUMEROAUTORIZACION= "Numero Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFINAL= "Fecha Final";
		public static final String LABEL_FECHAFINAL_LOWER= "Fecha Final";
    	public static final String LABEL_FECHAELABORACION= "Fecha Elaboracion";
		public static final String LABEL_FECHAELABORACION_LOWER= "Fecha Elaboracion";
    	public static final String LABEL_FECHACADUCIDAD= "Fecha Caducad";
		public static final String LABEL_FECHACADUCIDAD_LOWER= "Fecha Caducidad";
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_SINMONTOIVA= "Sin Monto Iva";
		public static final String LABEL_SINMONTOIVA_LOWER= "Sin Monto Iva";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_OTROIMPUESTO= "Otro Impuesto";
		public static final String LABEL_OTROIMPUESTO_LOWER= "Otro Impuesto";
    	public static final String LABEL_VALORPROPUESTO= "Valor Propuesto";
		public static final String LABEL_VALORPROPUESTO_LOWER= "Valor Propuesto";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_FINANCIERO= "Financiero";
		public static final String LABEL_FINANCIERO_LOWER= "Financiero";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_VALORCAMBIO= "Valor Cambio";
		public static final String LABEL_VALORCAMBIO_LOWER= "Valor Cambio";
	
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getRecapLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RecapConstantesFunciones.IDEMPRESA)) {sLabelColumna=RecapConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RecapConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RecapConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RecapConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RecapConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RecapConstantesFunciones.NUMERO)) {sLabelColumna=RecapConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(RecapConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=RecapConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(RecapConstantesFunciones.FECHAINICIO)) {sLabelColumna=RecapConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(RecapConstantesFunciones.FECHAFINAL)) {sLabelColumna=RecapConstantesFunciones.LABEL_FECHAFINAL;}
		if(sNombreColumna.equals(RecapConstantesFunciones.FECHAELABORACION)) {sLabelColumna=RecapConstantesFunciones.LABEL_FECHAELABORACION;}
		if(sNombreColumna.equals(RecapConstantesFunciones.FECHACADUCIDAD)) {sLabelColumna=RecapConstantesFunciones.LABEL_FECHACADUCIDAD;}
		if(sNombreColumna.equals(RecapConstantesFunciones.MONTOIVA)) {sLabelColumna=RecapConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(RecapConstantesFunciones.SINMONTOIVA)) {sLabelColumna=RecapConstantesFunciones.LABEL_SINMONTOIVA;}
		if(sNombreColumna.equals(RecapConstantesFunciones.IVA)) {sLabelColumna=RecapConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(RecapConstantesFunciones.OTROIMPUESTO)) {sLabelColumna=RecapConstantesFunciones.LABEL_OTROIMPUESTO;}
		if(sNombreColumna.equals(RecapConstantesFunciones.VALORPROPUESTO)) {sLabelColumna=RecapConstantesFunciones.LABEL_VALORPROPUESTO;}
		if(sNombreColumna.equals(RecapConstantesFunciones.SUBTOTAL)) {sLabelColumna=RecapConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(RecapConstantesFunciones.FINANCIERO)) {sLabelColumna=RecapConstantesFunciones.LABEL_FINANCIERO;}
		if(sNombreColumna.equals(RecapConstantesFunciones.TOTAL)) {sLabelColumna=RecapConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(RecapConstantesFunciones.VALORCAMBIO)) {sLabelColumna=RecapConstantesFunciones.LABEL_VALORCAMBIO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRecapDescripcion(Recap recap) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(recap !=null/* && recap.getId()!=0*/) {
			if(recap.getId()!=null) {
				sDescripcion=recap.getId().toString();
			}//recaprecap.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRecapDescripcionDetallado(Recap recap) {
		String sDescripcion="";
			
		sDescripcion+=RecapConstantesFunciones.ID+"=";
		sDescripcion+=recap.getId().toString()+",";
		sDescripcion+=RecapConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=recap.getVersionRow().toString()+",";
		sDescripcion+=RecapConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=recap.getid_empresa().toString()+",";
		sDescripcion+=RecapConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=recap.getid_sucursal().toString()+",";
		sDescripcion+=RecapConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=recap.getid_ejercicio().toString()+",";
		sDescripcion+=RecapConstantesFunciones.NUMERO+"=";
		sDescripcion+=recap.getnumero()+",";
		sDescripcion+=RecapConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=recap.getnumero_autorizacion()+",";
		sDescripcion+=RecapConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=recap.getfecha_inicio().toString()+",";
		sDescripcion+=RecapConstantesFunciones.FECHAFINAL+"=";
		sDescripcion+=recap.getfecha_final().toString()+",";
		sDescripcion+=RecapConstantesFunciones.FECHAELABORACION+"=";
		sDescripcion+=recap.getfecha_elaboracion().toString()+",";
		sDescripcion+=RecapConstantesFunciones.FECHACADUCIDAD+"=";
		sDescripcion+=recap.getfecha_caducidad().toString()+",";
		sDescripcion+=RecapConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=recap.getmonto_iva().toString()+",";
		sDescripcion+=RecapConstantesFunciones.SINMONTOIVA+"=";
		sDescripcion+=recap.getsin_monto_iva().toString()+",";
		sDescripcion+=RecapConstantesFunciones.IVA+"=";
		sDescripcion+=recap.getiva().toString()+",";
		sDescripcion+=RecapConstantesFunciones.OTROIMPUESTO+"=";
		sDescripcion+=recap.getotro_impuesto().toString()+",";
		sDescripcion+=RecapConstantesFunciones.VALORPROPUESTO+"=";
		sDescripcion+=recap.getvalor_propuesto().toString()+",";
		sDescripcion+=RecapConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=recap.getsubtotal().toString()+",";
		sDescripcion+=RecapConstantesFunciones.FINANCIERO+"=";
		sDescripcion+=recap.getfinanciero().toString()+",";
		sDescripcion+=RecapConstantesFunciones.TOTAL+"=";
		sDescripcion+=recap.gettotal().toString()+",";
		sDescripcion+=RecapConstantesFunciones.VALORCAMBIO+"=";
		sDescripcion+=recap.getvalor_cambio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRecapDescripcion(Recap recap,String sValor) throws Exception {			
		if(recap !=null) {
			//recaprecap.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRecap(Recap recap,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		recap.setnumero(recap.getnumero().trim());
		recap.setnumero_autorizacion(recap.getnumero_autorizacion().trim());
	}
	
	public static void quitarEspaciosRecaps(List<Recap> recaps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Recap recap: recaps) {
			recap.setnumero(recap.getnumero().trim());
			recap.setnumero_autorizacion(recap.getnumero_autorizacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRecap(Recap recap,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && recap.getConCambioAuxiliar()) {
			recap.setIsDeleted(recap.getIsDeletedAuxiliar());	
			recap.setIsNew(recap.getIsNewAuxiliar());	
			recap.setIsChanged(recap.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			recap.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			recap.setIsDeletedAuxiliar(false);	
			recap.setIsNewAuxiliar(false);	
			recap.setIsChangedAuxiliar(false);
			
			recap.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRecaps(List<Recap> recaps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Recap recap : recaps) {
			if(conAsignarBase && recap.getConCambioAuxiliar()) {
				recap.setIsDeleted(recap.getIsDeletedAuxiliar());	
				recap.setIsNew(recap.getIsNewAuxiliar());	
				recap.setIsChanged(recap.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				recap.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				recap.setIsDeletedAuxiliar(false);	
				recap.setIsNewAuxiliar(false);	
				recap.setIsChangedAuxiliar(false);
				
				recap.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRecap(Recap recap,Boolean conEnteros) throws Exception  {
		recap.setmonto_iva(0.0);
		recap.setsin_monto_iva(0.0);
		recap.setiva(0.0);
		recap.setotro_impuesto(0.0);
		recap.setvalor_propuesto(0.0);
		recap.setsubtotal(0.0);
		recap.setfinanciero(0.0);
		recap.settotal(0.0);
		recap.setvalor_cambio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRecaps(List<Recap> recaps,Boolean conEnteros) throws Exception  {
		
		for(Recap recap: recaps) {
			recap.setmonto_iva(0.0);
			recap.setsin_monto_iva(0.0);
			recap.setiva(0.0);
			recap.setotro_impuesto(0.0);
			recap.setvalor_propuesto(0.0);
			recap.setsubtotal(0.0);
			recap.setfinanciero(0.0);
			recap.settotal(0.0);
			recap.setvalor_cambio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRecap(List<Recap> recaps,Recap recapAux) throws Exception  {
		RecapConstantesFunciones.InicializarValoresRecap(recapAux,true);
		
		for(Recap recap: recaps) {
			if(recap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			recapAux.setmonto_iva(recapAux.getmonto_iva()+recap.getmonto_iva());			
			recapAux.setsin_monto_iva(recapAux.getsin_monto_iva()+recap.getsin_monto_iva());			
			recapAux.setiva(recapAux.getiva()+recap.getiva());			
			recapAux.setotro_impuesto(recapAux.getotro_impuesto()+recap.getotro_impuesto());			
			recapAux.setvalor_propuesto(recapAux.getvalor_propuesto()+recap.getvalor_propuesto());			
			recapAux.setsubtotal(recapAux.getsubtotal()+recap.getsubtotal());			
			recapAux.setfinanciero(recapAux.getfinanciero()+recap.getfinanciero());			
			recapAux.settotal(recapAux.gettotal()+recap.gettotal());			
			recapAux.setvalor_cambio(recapAux.getvalor_cambio()+recap.getvalor_cambio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RecapConstantesFunciones.getArrayColumnasGlobalesRecap(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRecap(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RecapConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RecapConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RecapConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RecapConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RecapConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RecapConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Recap> recaps,Recap recap,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Recap recapAux: recaps) {
			if(recapAux!=null && recap!=null) {
				if((recapAux.getId()==null && recap.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(recapAux.getId()!=null && recap.getId()!=null){
					if(recapAux.getId().equals(recap.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRecap(List<Recap> recaps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double monto_ivaTotal=0.0;
		Double sin_monto_ivaTotal=0.0;
		Double ivaTotal=0.0;
		Double otro_impuestoTotal=0.0;
		Double valor_propuestoTotal=0.0;
		Double subtotalTotal=0.0;
		Double financieroTotal=0.0;
		Double totalTotal=0.0;
		Double valor_cambioTotal=0.0;
	
		for(Recap recap: recaps) {			
			if(recap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			monto_ivaTotal+=recap.getmonto_iva();
			sin_monto_ivaTotal+=recap.getsin_monto_iva();
			ivaTotal+=recap.getiva();
			otro_impuestoTotal+=recap.getotro_impuesto();
			valor_propuestoTotal+=recap.getvalor_propuesto();
			subtotalTotal+=recap.getsubtotal();
			financieroTotal+=recap.getfinanciero();
			totalTotal+=recap.gettotal();
			valor_cambioTotal+=recap.getvalor_cambio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.SINMONTOIVA);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_SINMONTOIVA);
		datoGeneral.setdValorDouble(sin_monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.OTROIMPUESTO);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_OTROIMPUESTO);
		datoGeneral.setdValorDouble(otro_impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.VALORPROPUESTO);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_VALORPROPUESTO);
		datoGeneral.setdValorDouble(valor_propuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.FINANCIERO);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_FINANCIERO);
		datoGeneral.setdValorDouble(financieroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RecapConstantesFunciones.VALORCAMBIO);
		datoGeneral.setsDescripcion(RecapConstantesFunciones.LABEL_VALORCAMBIO);
		datoGeneral.setdValorDouble(valor_cambioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRecap() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_ID, RecapConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_VERSIONROW, RecapConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_IDEMPRESA, RecapConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_IDSUCURSAL, RecapConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_IDEJERCICIO, RecapConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_NUMERO, RecapConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_NUMEROAUTORIZACION, RecapConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_FECHAINICIO, RecapConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_FECHAFINAL, RecapConstantesFunciones.FECHAFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_FECHAELABORACION, RecapConstantesFunciones.FECHAELABORACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_FECHACADUCIDAD, RecapConstantesFunciones.FECHACADUCIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_MONTOIVA, RecapConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_SINMONTOIVA, RecapConstantesFunciones.SINMONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_IVA, RecapConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_OTROIMPUESTO, RecapConstantesFunciones.OTROIMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_VALORPROPUESTO, RecapConstantesFunciones.VALORPROPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_SUBTOTAL, RecapConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_FINANCIERO, RecapConstantesFunciones.FINANCIERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_TOTAL, RecapConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecapConstantesFunciones.LABEL_VALORCAMBIO, RecapConstantesFunciones.VALORCAMBIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRecap() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.FECHAFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.FECHAELABORACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.FECHACADUCIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.SINMONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.OTROIMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.VALORPROPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.FINANCIERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecapConstantesFunciones.VALORCAMBIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRecap() throws Exception  {
		return RecapConstantesFunciones.getTiposSeleccionarRecap(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRecap(Boolean conFk) throws Exception  {
		return RecapConstantesFunciones.getTiposSeleccionarRecap(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRecap(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_FECHAFINAL);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_FECHAFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_FECHAELABORACION);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_FECHAELABORACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_FECHACADUCIDAD);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_FECHACADUCIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_SINMONTOIVA);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_SINMONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_OTROIMPUESTO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_OTROIMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_VALORPROPUESTO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_VALORPROPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_FINANCIERO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_FINANCIERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecapConstantesFunciones.LABEL_VALORCAMBIO);
			reporte.setsDescripcion(RecapConstantesFunciones.LABEL_VALORCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRecap(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRecap(Recap recapAux) throws Exception {
		
			recapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(recapAux.getEmpresa()));
			recapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(recapAux.getSucursal()));
			recapAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(recapAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRecap(List<Recap> recapsTemp) throws Exception {
		for(Recap recapAux:recapsTemp) {
			
			recapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(recapAux.getEmpresa()));
			recapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(recapAux.getSucursal()));
			recapAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(recapAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RecapConstantesFunciones.getClassesRelationshipsOfRecap(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleRecap.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleRecap.class)) {
						classes.add(new Classe(DetalleRecap.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RecapConstantesFunciones.getClassesRelationshipsFromStringsOfRecap(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRecap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRecap.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRecap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRecap.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Recap recap,List<Recap> recaps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Recap recapEncontrado=null;
			
			for(Recap recapLocal:recaps) {
				if(recapLocal.getId().equals(recap.getId())) {
					recapEncontrado=recapLocal;
					
					recapLocal.setIsChanged(recap.getIsChanged());
					recapLocal.setIsNew(recap.getIsNew());
					recapLocal.setIsDeleted(recap.getIsDeleted());
					
					recapLocal.setGeneralEntityOriginal(recap.getGeneralEntityOriginal());
					
					recapLocal.setId(recap.getId());	
					recapLocal.setVersionRow(recap.getVersionRow());	
					recapLocal.setid_empresa(recap.getid_empresa());	
					recapLocal.setid_sucursal(recap.getid_sucursal());	
					recapLocal.setid_ejercicio(recap.getid_ejercicio());	
					recapLocal.setnumero(recap.getnumero());	
					recapLocal.setnumero_autorizacion(recap.getnumero_autorizacion());	
					recapLocal.setfecha_inicio(recap.getfecha_inicio());	
					recapLocal.setfecha_final(recap.getfecha_final());	
					recapLocal.setfecha_elaboracion(recap.getfecha_elaboracion());	
					recapLocal.setfecha_caducidad(recap.getfecha_caducidad());	
					recapLocal.setmonto_iva(recap.getmonto_iva());	
					recapLocal.setsin_monto_iva(recap.getsin_monto_iva());	
					recapLocal.setiva(recap.getiva());	
					recapLocal.setotro_impuesto(recap.getotro_impuesto());	
					recapLocal.setvalor_propuesto(recap.getvalor_propuesto());	
					recapLocal.setsubtotal(recap.getsubtotal());	
					recapLocal.setfinanciero(recap.getfinanciero());	
					recapLocal.settotal(recap.gettotal());	
					recapLocal.setvalor_cambio(recap.getvalor_cambio());	
					
					
					recapLocal.setDetalleRecaps(recap.getDetalleRecaps());
					
					existe=true;
					break;
				}
			}
			
			if(!recap.getIsDeleted()) {
				if(!existe) {
					recaps.add(recap);
				}
			} else {
				if(recapEncontrado!=null && permiteQuitar)  {
					recaps.remove(recapEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Recap recap,List<Recap> recaps) throws Exception {
		try	{			
			for(Recap recapLocal:recaps) {
				if(recapLocal.getId().equals(recap.getId())) {
					recapLocal.setIsSelected(recap.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRecap(List<Recap> recapsAux) throws Exception {
		//this.recapsAux=recapsAux;
		
		for(Recap recapAux:recapsAux) {
			if(recapAux.getIsChanged()) {
				recapAux.setIsChanged(false);
			}		
			
			if(recapAux.getIsNew()) {
				recapAux.setIsNew(false);
			}	
			
			if(recapAux.getIsDeleted()) {
				recapAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRecap(Recap recapAux) throws Exception {
		//this.recapAux=recapAux;
		
			if(recapAux.getIsChanged()) {
				recapAux.setIsChanged(false);
			}		
			
			if(recapAux.getIsNew()) {
				recapAux.setIsNew(false);
			}	
			
			if(recapAux.getIsDeleted()) {
				recapAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Recap recapAsignar,Recap recap) throws Exception {
		recapAsignar.setId(recap.getId());	
		recapAsignar.setVersionRow(recap.getVersionRow());	
		recapAsignar.setid_empresa(recap.getid_empresa());
		recapAsignar.setempresa_descripcion(recap.getempresa_descripcion());	
		recapAsignar.setid_sucursal(recap.getid_sucursal());
		recapAsignar.setsucursal_descripcion(recap.getsucursal_descripcion());	
		recapAsignar.setid_ejercicio(recap.getid_ejercicio());
		recapAsignar.setejercicio_descripcion(recap.getejercicio_descripcion());	
		recapAsignar.setnumero(recap.getnumero());	
		recapAsignar.setnumero_autorizacion(recap.getnumero_autorizacion());	
		recapAsignar.setfecha_inicio(recap.getfecha_inicio());	
		recapAsignar.setfecha_final(recap.getfecha_final());	
		recapAsignar.setfecha_elaboracion(recap.getfecha_elaboracion());	
		recapAsignar.setfecha_caducidad(recap.getfecha_caducidad());	
		recapAsignar.setmonto_iva(recap.getmonto_iva());	
		recapAsignar.setsin_monto_iva(recap.getsin_monto_iva());	
		recapAsignar.setiva(recap.getiva());	
		recapAsignar.setotro_impuesto(recap.getotro_impuesto());	
		recapAsignar.setvalor_propuesto(recap.getvalor_propuesto());	
		recapAsignar.setsubtotal(recap.getsubtotal());	
		recapAsignar.setfinanciero(recap.getfinanciero());	
		recapAsignar.settotal(recap.gettotal());	
		recapAsignar.setvalor_cambio(recap.getvalor_cambio());	
	}
	
	public static void inicializarRecap(Recap recap) throws Exception {
		try {
				recap.setId(0L);	
					
				recap.setid_empresa(-1L);	
				recap.setid_sucursal(-1L);	
				recap.setid_ejercicio(-1L);	
				recap.setnumero("");	
				recap.setnumero_autorizacion("");	
				recap.setfecha_inicio(new Date());	
				recap.setfecha_final(new Date());	
				recap.setfecha_elaboracion(new Date());	
				recap.setfecha_caducidad(new Date());	
				recap.setmonto_iva(0.0);	
				recap.setsin_monto_iva(0.0);	
				recap.setiva(0.0);	
				recap.setotro_impuesto(0.0);	
				recap.setvalor_propuesto(0.0);	
				recap.setsubtotal(0.0);	
				recap.setfinanciero(0.0);	
				recap.settotal(0.0);	
				recap.setvalor_cambio(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRecap(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_FECHAFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_FECHAELABORACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_FECHACADUCIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_SINMONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_OTROIMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_VALORPROPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_FINANCIERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecapConstantesFunciones.LABEL_VALORCAMBIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRecap(String sTipo,Row row,Workbook workbook,Recap recap,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getfecha_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getfecha_elaboracion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getfecha_caducidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getsin_monto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getotro_impuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getvalor_propuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getfinanciero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recap.getvalor_cambio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRecap=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRecap() {
		return this.sFinalQueryRecap;
	}
	
	public void setsFinalQueryRecap(String sFinalQueryRecap) {
		this.sFinalQueryRecap= sFinalQueryRecap;
	}
	
	public Border resaltarSeleccionarRecap=null;
	
	public Border setResaltarSeleccionarRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRecap= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRecap() {
		return this.resaltarSeleccionarRecap;
	}
	
	public void setResaltarSeleccionarRecap(Border borderResaltarSeleccionarRecap) {
		this.resaltarSeleccionarRecap= borderResaltarSeleccionarRecap;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRecap=null;
	public Boolean mostraridRecap=true;
	public Boolean activaridRecap=true;

	public Border resaltarid_empresaRecap=null;
	public Boolean mostrarid_empresaRecap=true;
	public Boolean activarid_empresaRecap=true;
	public Boolean cargarid_empresaRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRecap=false;//ConEventDepend=true

	public Border resaltarid_sucursalRecap=null;
	public Boolean mostrarid_sucursalRecap=true;
	public Boolean activarid_sucursalRecap=true;
	public Boolean cargarid_sucursalRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRecap=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRecap=null;
	public Boolean mostrarid_ejercicioRecap=true;
	public Boolean activarid_ejercicioRecap=true;
	public Boolean cargarid_ejercicioRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRecap=false;//ConEventDepend=true

	public Border resaltarnumeroRecap=null;
	public Boolean mostrarnumeroRecap=true;
	public Boolean activarnumeroRecap=true;

	public Border resaltarnumero_autorizacionRecap=null;
	public Boolean mostrarnumero_autorizacionRecap=true;
	public Boolean activarnumero_autorizacionRecap=true;

	public Border resaltarfecha_inicioRecap=null;
	public Boolean mostrarfecha_inicioRecap=true;
	public Boolean activarfecha_inicioRecap=false;

	public Border resaltarfecha_finalRecap=null;
	public Boolean mostrarfecha_finalRecap=true;
	public Boolean activarfecha_finalRecap=false;

	public Border resaltarfecha_elaboracionRecap=null;
	public Boolean mostrarfecha_elaboracionRecap=true;
	public Boolean activarfecha_elaboracionRecap=false;

	public Border resaltarfecha_caducidadRecap=null;
	public Boolean mostrarfecha_caducidadRecap=true;
	public Boolean activarfecha_caducidadRecap=false;

	public Border resaltarmonto_ivaRecap=null;
	public Boolean mostrarmonto_ivaRecap=true;
	public Boolean activarmonto_ivaRecap=true;

	public Border resaltarsin_monto_ivaRecap=null;
	public Boolean mostrarsin_monto_ivaRecap=true;
	public Boolean activarsin_monto_ivaRecap=true;

	public Border resaltarivaRecap=null;
	public Boolean mostrarivaRecap=true;
	public Boolean activarivaRecap=true;

	public Border resaltarotro_impuestoRecap=null;
	public Boolean mostrarotro_impuestoRecap=true;
	public Boolean activarotro_impuestoRecap=true;

	public Border resaltarvalor_propuestoRecap=null;
	public Boolean mostrarvalor_propuestoRecap=true;
	public Boolean activarvalor_propuestoRecap=true;

	public Border resaltarsubtotalRecap=null;
	public Boolean mostrarsubtotalRecap=true;
	public Boolean activarsubtotalRecap=true;

	public Border resaltarfinancieroRecap=null;
	public Boolean mostrarfinancieroRecap=true;
	public Boolean activarfinancieroRecap=true;

	public Border resaltartotalRecap=null;
	public Boolean mostrartotalRecap=true;
	public Boolean activartotalRecap=true;

	public Border resaltarvalor_cambioRecap=null;
	public Boolean mostrarvalor_cambioRecap=true;
	public Boolean activarvalor_cambioRecap=true;

	
	

	public Border setResaltaridRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltaridRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRecap() {
		return this.resaltaridRecap;
	}

	public void setResaltaridRecap(Border borderResaltar) {
		this.resaltaridRecap= borderResaltar;
	}

	public Boolean getMostraridRecap() {
		return this.mostraridRecap;
	}

	public void setMostraridRecap(Boolean mostraridRecap) {
		this.mostraridRecap= mostraridRecap;
	}

	public Boolean getActivaridRecap() {
		return this.activaridRecap;
	}

	public void setActivaridRecap(Boolean activaridRecap) {
		this.activaridRecap= activaridRecap;
	}

	public Border setResaltarid_empresaRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarid_empresaRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRecap() {
		return this.resaltarid_empresaRecap;
	}

	public void setResaltarid_empresaRecap(Border borderResaltar) {
		this.resaltarid_empresaRecap= borderResaltar;
	}

	public Boolean getMostrarid_empresaRecap() {
		return this.mostrarid_empresaRecap;
	}

	public void setMostrarid_empresaRecap(Boolean mostrarid_empresaRecap) {
		this.mostrarid_empresaRecap= mostrarid_empresaRecap;
	}

	public Boolean getActivarid_empresaRecap() {
		return this.activarid_empresaRecap;
	}

	public void setActivarid_empresaRecap(Boolean activarid_empresaRecap) {
		this.activarid_empresaRecap= activarid_empresaRecap;
	}

	public Boolean getCargarid_empresaRecap() {
		return this.cargarid_empresaRecap;
	}

	public void setCargarid_empresaRecap(Boolean cargarid_empresaRecap) {
		this.cargarid_empresaRecap= cargarid_empresaRecap;
	}

	public Border setResaltarid_sucursalRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRecap() {
		return this.resaltarid_sucursalRecap;
	}

	public void setResaltarid_sucursalRecap(Border borderResaltar) {
		this.resaltarid_sucursalRecap= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRecap() {
		return this.mostrarid_sucursalRecap;
	}

	public void setMostrarid_sucursalRecap(Boolean mostrarid_sucursalRecap) {
		this.mostrarid_sucursalRecap= mostrarid_sucursalRecap;
	}

	public Boolean getActivarid_sucursalRecap() {
		return this.activarid_sucursalRecap;
	}

	public void setActivarid_sucursalRecap(Boolean activarid_sucursalRecap) {
		this.activarid_sucursalRecap= activarid_sucursalRecap;
	}

	public Boolean getCargarid_sucursalRecap() {
		return this.cargarid_sucursalRecap;
	}

	public void setCargarid_sucursalRecap(Boolean cargarid_sucursalRecap) {
		this.cargarid_sucursalRecap= cargarid_sucursalRecap;
	}

	public Border setResaltarid_ejercicioRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRecap() {
		return this.resaltarid_ejercicioRecap;
	}

	public void setResaltarid_ejercicioRecap(Border borderResaltar) {
		this.resaltarid_ejercicioRecap= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRecap() {
		return this.mostrarid_ejercicioRecap;
	}

	public void setMostrarid_ejercicioRecap(Boolean mostrarid_ejercicioRecap) {
		this.mostrarid_ejercicioRecap= mostrarid_ejercicioRecap;
	}

	public Boolean getActivarid_ejercicioRecap() {
		return this.activarid_ejercicioRecap;
	}

	public void setActivarid_ejercicioRecap(Boolean activarid_ejercicioRecap) {
		this.activarid_ejercicioRecap= activarid_ejercicioRecap;
	}

	public Boolean getCargarid_ejercicioRecap() {
		return this.cargarid_ejercicioRecap;
	}

	public void setCargarid_ejercicioRecap(Boolean cargarid_ejercicioRecap) {
		this.cargarid_ejercicioRecap= cargarid_ejercicioRecap;
	}

	public Border setResaltarnumeroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarnumeroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroRecap() {
		return this.resaltarnumeroRecap;
	}

	public void setResaltarnumeroRecap(Border borderResaltar) {
		this.resaltarnumeroRecap= borderResaltar;
	}

	public Boolean getMostrarnumeroRecap() {
		return this.mostrarnumeroRecap;
	}

	public void setMostrarnumeroRecap(Boolean mostrarnumeroRecap) {
		this.mostrarnumeroRecap= mostrarnumeroRecap;
	}

	public Boolean getActivarnumeroRecap() {
		return this.activarnumeroRecap;
	}

	public void setActivarnumeroRecap(Boolean activarnumeroRecap) {
		this.activarnumeroRecap= activarnumeroRecap;
	}

	public Border setResaltarnumero_autorizacionRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionRecap() {
		return this.resaltarnumero_autorizacionRecap;
	}

	public void setResaltarnumero_autorizacionRecap(Border borderResaltar) {
		this.resaltarnumero_autorizacionRecap= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionRecap() {
		return this.mostrarnumero_autorizacionRecap;
	}

	public void setMostrarnumero_autorizacionRecap(Boolean mostrarnumero_autorizacionRecap) {
		this.mostrarnumero_autorizacionRecap= mostrarnumero_autorizacionRecap;
	}

	public Boolean getActivarnumero_autorizacionRecap() {
		return this.activarnumero_autorizacionRecap;
	}

	public void setActivarnumero_autorizacionRecap(Boolean activarnumero_autorizacionRecap) {
		this.activarnumero_autorizacionRecap= activarnumero_autorizacionRecap;
	}

	public Border setResaltarfecha_inicioRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioRecap() {
		return this.resaltarfecha_inicioRecap;
	}

	public void setResaltarfecha_inicioRecap(Border borderResaltar) {
		this.resaltarfecha_inicioRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioRecap() {
		return this.mostrarfecha_inicioRecap;
	}

	public void setMostrarfecha_inicioRecap(Boolean mostrarfecha_inicioRecap) {
		this.mostrarfecha_inicioRecap= mostrarfecha_inicioRecap;
	}

	public Boolean getActivarfecha_inicioRecap() {
		return this.activarfecha_inicioRecap;
	}

	public void setActivarfecha_inicioRecap(Boolean activarfecha_inicioRecap) {
		this.activarfecha_inicioRecap= activarfecha_inicioRecap;
	}

	public Border setResaltarfecha_finalRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_finalRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalRecap() {
		return this.resaltarfecha_finalRecap;
	}

	public void setResaltarfecha_finalRecap(Border borderResaltar) {
		this.resaltarfecha_finalRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_finalRecap() {
		return this.mostrarfecha_finalRecap;
	}

	public void setMostrarfecha_finalRecap(Boolean mostrarfecha_finalRecap) {
		this.mostrarfecha_finalRecap= mostrarfecha_finalRecap;
	}

	public Boolean getActivarfecha_finalRecap() {
		return this.activarfecha_finalRecap;
	}

	public void setActivarfecha_finalRecap(Boolean activarfecha_finalRecap) {
		this.activarfecha_finalRecap= activarfecha_finalRecap;
	}

	public Border setResaltarfecha_elaboracionRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_elaboracionRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_elaboracionRecap() {
		return this.resaltarfecha_elaboracionRecap;
	}

	public void setResaltarfecha_elaboracionRecap(Border borderResaltar) {
		this.resaltarfecha_elaboracionRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_elaboracionRecap() {
		return this.mostrarfecha_elaboracionRecap;
	}

	public void setMostrarfecha_elaboracionRecap(Boolean mostrarfecha_elaboracionRecap) {
		this.mostrarfecha_elaboracionRecap= mostrarfecha_elaboracionRecap;
	}

	public Boolean getActivarfecha_elaboracionRecap() {
		return this.activarfecha_elaboracionRecap;
	}

	public void setActivarfecha_elaboracionRecap(Boolean activarfecha_elaboracionRecap) {
		this.activarfecha_elaboracionRecap= activarfecha_elaboracionRecap;
	}

	public Border setResaltarfecha_caducidadRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_caducidadRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidadRecap() {
		return this.resaltarfecha_caducidadRecap;
	}

	public void setResaltarfecha_caducidadRecap(Border borderResaltar) {
		this.resaltarfecha_caducidadRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidadRecap() {
		return this.mostrarfecha_caducidadRecap;
	}

	public void setMostrarfecha_caducidadRecap(Boolean mostrarfecha_caducidadRecap) {
		this.mostrarfecha_caducidadRecap= mostrarfecha_caducidadRecap;
	}

	public Boolean getActivarfecha_caducidadRecap() {
		return this.activarfecha_caducidadRecap;
	}

	public void setActivarfecha_caducidadRecap(Boolean activarfecha_caducidadRecap) {
		this.activarfecha_caducidadRecap= activarfecha_caducidadRecap;
	}

	public Border setResaltarmonto_ivaRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarmonto_ivaRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaRecap() {
		return this.resaltarmonto_ivaRecap;
	}

	public void setResaltarmonto_ivaRecap(Border borderResaltar) {
		this.resaltarmonto_ivaRecap= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaRecap() {
		return this.mostrarmonto_ivaRecap;
	}

	public void setMostrarmonto_ivaRecap(Boolean mostrarmonto_ivaRecap) {
		this.mostrarmonto_ivaRecap= mostrarmonto_ivaRecap;
	}

	public Boolean getActivarmonto_ivaRecap() {
		return this.activarmonto_ivaRecap;
	}

	public void setActivarmonto_ivaRecap(Boolean activarmonto_ivaRecap) {
		this.activarmonto_ivaRecap= activarmonto_ivaRecap;
	}

	public Border setResaltarsin_monto_ivaRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarsin_monto_ivaRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsin_monto_ivaRecap() {
		return this.resaltarsin_monto_ivaRecap;
	}

	public void setResaltarsin_monto_ivaRecap(Border borderResaltar) {
		this.resaltarsin_monto_ivaRecap= borderResaltar;
	}

	public Boolean getMostrarsin_monto_ivaRecap() {
		return this.mostrarsin_monto_ivaRecap;
	}

	public void setMostrarsin_monto_ivaRecap(Boolean mostrarsin_monto_ivaRecap) {
		this.mostrarsin_monto_ivaRecap= mostrarsin_monto_ivaRecap;
	}

	public Boolean getActivarsin_monto_ivaRecap() {
		return this.activarsin_monto_ivaRecap;
	}

	public void setActivarsin_monto_ivaRecap(Boolean activarsin_monto_ivaRecap) {
		this.activarsin_monto_ivaRecap= activarsin_monto_ivaRecap;
	}

	public Border setResaltarivaRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarivaRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaRecap() {
		return this.resaltarivaRecap;
	}

	public void setResaltarivaRecap(Border borderResaltar) {
		this.resaltarivaRecap= borderResaltar;
	}

	public Boolean getMostrarivaRecap() {
		return this.mostrarivaRecap;
	}

	public void setMostrarivaRecap(Boolean mostrarivaRecap) {
		this.mostrarivaRecap= mostrarivaRecap;
	}

	public Boolean getActivarivaRecap() {
		return this.activarivaRecap;
	}

	public void setActivarivaRecap(Boolean activarivaRecap) {
		this.activarivaRecap= activarivaRecap;
	}

	public Border setResaltarotro_impuestoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarotro_impuestoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotro_impuestoRecap() {
		return this.resaltarotro_impuestoRecap;
	}

	public void setResaltarotro_impuestoRecap(Border borderResaltar) {
		this.resaltarotro_impuestoRecap= borderResaltar;
	}

	public Boolean getMostrarotro_impuestoRecap() {
		return this.mostrarotro_impuestoRecap;
	}

	public void setMostrarotro_impuestoRecap(Boolean mostrarotro_impuestoRecap) {
		this.mostrarotro_impuestoRecap= mostrarotro_impuestoRecap;
	}

	public Boolean getActivarotro_impuestoRecap() {
		return this.activarotro_impuestoRecap;
	}

	public void setActivarotro_impuestoRecap(Boolean activarotro_impuestoRecap) {
		this.activarotro_impuestoRecap= activarotro_impuestoRecap;
	}

	public Border setResaltarvalor_propuestoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarvalor_propuestoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_propuestoRecap() {
		return this.resaltarvalor_propuestoRecap;
	}

	public void setResaltarvalor_propuestoRecap(Border borderResaltar) {
		this.resaltarvalor_propuestoRecap= borderResaltar;
	}

	public Boolean getMostrarvalor_propuestoRecap() {
		return this.mostrarvalor_propuestoRecap;
	}

	public void setMostrarvalor_propuestoRecap(Boolean mostrarvalor_propuestoRecap) {
		this.mostrarvalor_propuestoRecap= mostrarvalor_propuestoRecap;
	}

	public Boolean getActivarvalor_propuestoRecap() {
		return this.activarvalor_propuestoRecap;
	}

	public void setActivarvalor_propuestoRecap(Boolean activarvalor_propuestoRecap) {
		this.activarvalor_propuestoRecap= activarvalor_propuestoRecap;
	}

	public Border setResaltarsubtotalRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarsubtotalRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalRecap() {
		return this.resaltarsubtotalRecap;
	}

	public void setResaltarsubtotalRecap(Border borderResaltar) {
		this.resaltarsubtotalRecap= borderResaltar;
	}

	public Boolean getMostrarsubtotalRecap() {
		return this.mostrarsubtotalRecap;
	}

	public void setMostrarsubtotalRecap(Boolean mostrarsubtotalRecap) {
		this.mostrarsubtotalRecap= mostrarsubtotalRecap;
	}

	public Boolean getActivarsubtotalRecap() {
		return this.activarsubtotalRecap;
	}

	public void setActivarsubtotalRecap(Boolean activarsubtotalRecap) {
		this.activarsubtotalRecap= activarsubtotalRecap;
	}

	public Border setResaltarfinancieroRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarfinancieroRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinancieroRecap() {
		return this.resaltarfinancieroRecap;
	}

	public void setResaltarfinancieroRecap(Border borderResaltar) {
		this.resaltarfinancieroRecap= borderResaltar;
	}

	public Boolean getMostrarfinancieroRecap() {
		return this.mostrarfinancieroRecap;
	}

	public void setMostrarfinancieroRecap(Boolean mostrarfinancieroRecap) {
		this.mostrarfinancieroRecap= mostrarfinancieroRecap;
	}

	public Boolean getActivarfinancieroRecap() {
		return this.activarfinancieroRecap;
	}

	public void setActivarfinancieroRecap(Boolean activarfinancieroRecap) {
		this.activarfinancieroRecap= activarfinancieroRecap;
	}

	public Border setResaltartotalRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltartotalRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalRecap() {
		return this.resaltartotalRecap;
	}

	public void setResaltartotalRecap(Border borderResaltar) {
		this.resaltartotalRecap= borderResaltar;
	}

	public Boolean getMostrartotalRecap() {
		return this.mostrartotalRecap;
	}

	public void setMostrartotalRecap(Boolean mostrartotalRecap) {
		this.mostrartotalRecap= mostrartotalRecap;
	}

	public Boolean getActivartotalRecap() {
		return this.activartotalRecap;
	}

	public void setActivartotalRecap(Boolean activartotalRecap) {
		this.activartotalRecap= activartotalRecap;
	}

	public Border setResaltarvalor_cambioRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltar);
		
		this.resaltarvalor_cambioRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_cambioRecap() {
		return this.resaltarvalor_cambioRecap;
	}

	public void setResaltarvalor_cambioRecap(Border borderResaltar) {
		this.resaltarvalor_cambioRecap= borderResaltar;
	}

	public Boolean getMostrarvalor_cambioRecap() {
		return this.mostrarvalor_cambioRecap;
	}

	public void setMostrarvalor_cambioRecap(Boolean mostrarvalor_cambioRecap) {
		this.mostrarvalor_cambioRecap= mostrarvalor_cambioRecap;
	}

	public Boolean getActivarvalor_cambioRecap() {
		return this.activarvalor_cambioRecap;
	}

	public void setActivarvalor_cambioRecap(Boolean activarvalor_cambioRecap) {
		this.activarvalor_cambioRecap= activarvalor_cambioRecap;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridRecap(esInicial);
		this.setMostrarid_empresaRecap(esInicial);
		this.setMostrarid_sucursalRecap(esInicial);
		this.setMostrarid_ejercicioRecap(esInicial);
		this.setMostrarnumeroRecap(esInicial);
		this.setMostrarnumero_autorizacionRecap(esInicial);
		this.setMostrarfecha_inicioRecap(esInicial);
		this.setMostrarfecha_finalRecap(esInicial);
		this.setMostrarfecha_elaboracionRecap(esInicial);
		this.setMostrarfecha_caducidadRecap(esInicial);
		this.setMostrarmonto_ivaRecap(esInicial);
		this.setMostrarsin_monto_ivaRecap(esInicial);
		this.setMostrarivaRecap(esInicial);
		this.setMostrarotro_impuestoRecap(esInicial);
		this.setMostrarvalor_propuestoRecap(esInicial);
		this.setMostrarsubtotalRecap(esInicial);
		this.setMostrarfinancieroRecap(esInicial);
		this.setMostrartotalRecap(esInicial);
		this.setMostrarvalor_cambioRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RecapConstantesFunciones.ID)) {
				this.setMostraridRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAFINAL)) {
				this.setMostrarfecha_finalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAELABORACION)) {
				this.setMostrarfecha_elaboracionRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHACADUCIDAD)) {
				this.setMostrarfecha_caducidadRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.SINMONTOIVA)) {
				this.setMostrarsin_monto_ivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IVA)) {
				this.setMostrarivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.OTROIMPUESTO)) {
				this.setMostrarotro_impuestoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.VALORPROPUESTO)) {
				this.setMostrarvalor_propuestoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FINANCIERO)) {
				this.setMostrarfinancieroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.TOTAL)) {
				this.setMostrartotalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.VALORCAMBIO)) {
				this.setMostrarvalor_cambioRecap(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridRecap(esInicial);
		this.setActivarid_empresaRecap(esInicial);
		this.setActivarid_sucursalRecap(esInicial);
		this.setActivarid_ejercicioRecap(esInicial);
		this.setActivarnumeroRecap(esInicial);
		this.setActivarnumero_autorizacionRecap(esInicial);
		this.setActivarfecha_inicioRecap(esInicial);
		this.setActivarfecha_finalRecap(esInicial);
		this.setActivarfecha_elaboracionRecap(esInicial);
		this.setActivarfecha_caducidadRecap(esInicial);
		this.setActivarmonto_ivaRecap(esInicial);
		this.setActivarsin_monto_ivaRecap(esInicial);
		this.setActivarivaRecap(esInicial);
		this.setActivarotro_impuestoRecap(esInicial);
		this.setActivarvalor_propuestoRecap(esInicial);
		this.setActivarsubtotalRecap(esInicial);
		this.setActivarfinancieroRecap(esInicial);
		this.setActivartotalRecap(esInicial);
		this.setActivarvalor_cambioRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RecapConstantesFunciones.ID)) {
				this.setActivaridRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.NUMERO)) {
				this.setActivarnumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAFINAL)) {
				this.setActivarfecha_finalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAELABORACION)) {
				this.setActivarfecha_elaboracionRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHACADUCIDAD)) {
				this.setActivarfecha_caducidadRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.SINMONTOIVA)) {
				this.setActivarsin_monto_ivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IVA)) {
				this.setActivarivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.OTROIMPUESTO)) {
				this.setActivarotro_impuestoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.VALORPROPUESTO)) {
				this.setActivarvalor_propuestoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FINANCIERO)) {
				this.setActivarfinancieroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.TOTAL)) {
				this.setActivartotalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.VALORCAMBIO)) {
				this.setActivarvalor_cambioRecap(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRecap(esInicial);
		this.setResaltarid_empresaRecap(esInicial);
		this.setResaltarid_sucursalRecap(esInicial);
		this.setResaltarid_ejercicioRecap(esInicial);
		this.setResaltarnumeroRecap(esInicial);
		this.setResaltarnumero_autorizacionRecap(esInicial);
		this.setResaltarfecha_inicioRecap(esInicial);
		this.setResaltarfecha_finalRecap(esInicial);
		this.setResaltarfecha_elaboracionRecap(esInicial);
		this.setResaltarfecha_caducidadRecap(esInicial);
		this.setResaltarmonto_ivaRecap(esInicial);
		this.setResaltarsin_monto_ivaRecap(esInicial);
		this.setResaltarivaRecap(esInicial);
		this.setResaltarotro_impuestoRecap(esInicial);
		this.setResaltarvalor_propuestoRecap(esInicial);
		this.setResaltarsubtotalRecap(esInicial);
		this.setResaltarfinancieroRecap(esInicial);
		this.setResaltartotalRecap(esInicial);
		this.setResaltarvalor_cambioRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RecapConstantesFunciones.ID)) {
				this.setResaltaridRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAFINAL)) {
				this.setResaltarfecha_finalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHAELABORACION)) {
				this.setResaltarfecha_elaboracionRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FECHACADUCIDAD)) {
				this.setResaltarfecha_caducidadRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.SINMONTOIVA)) {
				this.setResaltarsin_monto_ivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.IVA)) {
				this.setResaltarivaRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.OTROIMPUESTO)) {
				this.setResaltarotro_impuestoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.VALORPROPUESTO)) {
				this.setResaltarvalor_propuestoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.FINANCIERO)) {
				this.setResaltarfinancieroRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.TOTAL)) {
				this.setResaltartotalRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecapConstantesFunciones.VALORCAMBIO)) {
				this.setResaltarvalor_cambioRecap(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleRecapRecap=null;

	public Border getResaltarDetalleRecapRecap() {
		return this.resaltarDetalleRecapRecap;
	}

	public void setResaltarDetalleRecapRecap(Border borderResaltarDetalleRecap) {
		if(borderResaltarDetalleRecap!=null) {
			this.resaltarDetalleRecapRecap= borderResaltarDetalleRecap;
		}
	}

	public Border setResaltarDetalleRecapRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleRecap=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//recapBeanSwingJInternalFrame.jTtoolBarRecap.setBorder(borderResaltarDetalleRecap);
			
		this.resaltarDetalleRecapRecap= borderResaltarDetalleRecap;

		 return borderResaltarDetalleRecap;
	}



	public Boolean mostrarDetalleRecapRecap=true;

	public Boolean getMostrarDetalleRecapRecap() {
		return this.mostrarDetalleRecapRecap;
	}

	public void setMostrarDetalleRecapRecap(Boolean visibilidadResaltarDetalleRecap) {
		this.mostrarDetalleRecapRecap= visibilidadResaltarDetalleRecap;
	}



	public Boolean activarDetalleRecapRecap=true;

	public Boolean gethabilitarResaltarDetalleRecapRecap() {
		return this.activarDetalleRecapRecap;
	}

	public void setActivarDetalleRecapRecap(Boolean habilitarResaltarDetalleRecap) {
		this.activarDetalleRecapRecap= habilitarResaltarDetalleRecap;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetalleRecapRecap(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRecap.class)) {
				this.setMostrarDetalleRecapRecap(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetalleRecapRecap(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRecap.class)) {
				this.setActivarDetalleRecapRecap(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleRecapRecap(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRecap.class)) {
				this.setResaltarDetalleRecapRecap(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEjercicioRecap=true;

	public Boolean getMostrarFK_IdEjercicioRecap() {
		return this.mostrarFK_IdEjercicioRecap;
	}

	public void setMostrarFK_IdEjercicioRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRecap=true;

	public Boolean getMostrarFK_IdEmpresaRecap() {
		return this.mostrarFK_IdEmpresaRecap;
	}

	public void setMostrarFK_IdEmpresaRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRecap= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRecap=true;

	public Boolean getMostrarFK_IdSucursalRecap() {
		return this.mostrarFK_IdSucursalRecap;
	}

	public void setMostrarFK_IdSucursalRecap(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRecap= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioRecap=true;

	public Boolean getActivarFK_IdEjercicioRecap() {
		return this.activarFK_IdEjercicioRecap;
	}

	public void setActivarFK_IdEjercicioRecap(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRecap=true;

	public Boolean getActivarFK_IdEmpresaRecap() {
		return this.activarFK_IdEmpresaRecap;
	}

	public void setActivarFK_IdEmpresaRecap(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRecap= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRecap=true;

	public Boolean getActivarFK_IdSucursalRecap() {
		return this.activarFK_IdSucursalRecap;
	}

	public void setActivarFK_IdSucursalRecap(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRecap= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioRecap=null;

	public Border getResaltarFK_IdEjercicioRecap() {
		return this.resaltarFK_IdEjercicioRecap;
	}

	public void setResaltarFK_IdEjercicioRecap(Border borderResaltar) {
		this.resaltarFK_IdEjercicioRecap= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioRecap= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRecap=null;

	public Border getResaltarFK_IdEmpresaRecap() {
		return this.resaltarFK_IdEmpresaRecap;
	}

	public void setResaltarFK_IdEmpresaRecap(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRecap= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRecap= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRecap=null;

	public Border getResaltarFK_IdSucursalRecap() {
		return this.resaltarFK_IdSucursalRecap;
	}

	public void setResaltarFK_IdSucursalRecap(Border borderResaltar) {
		this.resaltarFK_IdSucursalRecap= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRecap(ParametroGeneralUsuario parametroGeneralUsuario/*RecapBeanSwingJInternalFrame recapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRecap= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}