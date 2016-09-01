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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarClientesSaldosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarClientesSaldosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesSaldosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



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
final public class CobrarClientesSaldosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CobrarClientesSaldos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarClientesSaldos"+CobrarClientesSaldosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarClientesSaldosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarClientesSaldosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarClientesSaldosConstantesFunciones.SCHEMA+"_"+CobrarClientesSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarClientesSaldosConstantesFunciones.SCHEMA+"_"+CobrarClientesSaldosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarClientesSaldosConstantesFunciones.SCHEMA+"_"+CobrarClientesSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarClientesSaldosConstantesFunciones.SCHEMA+"_"+CobrarClientesSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesSaldosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSaldosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarClientesSaldosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarClientesSaldosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarClientesSaldosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarClientesSaldosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Clientes Saldoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Clientes Saldos";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Clientes Saldos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarClientesSaldos";
	public static final String OBJECTNAME="cobrarclientessaldos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_clientes_saldos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarclientessaldos from "+CobrarClientesSaldosConstantesFunciones.SPERSISTENCENAME+" cobrarclientessaldos";
	public static String QUERYSELECTNATIVE="select "+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".id,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".version_row,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".id_sucursal,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".id_ejercicio,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".codigo,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".nombre_comercial,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".nombre_garantia,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".limite_credito,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".total_pedidos,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".total_saldos,"+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME+".total_cheques from "+CobrarClientesSaldosConstantesFunciones.SCHEMA+"."+CobrarClientesSaldosConstantesFunciones.TABLENAME;//+" as "+CobrarClientesSaldosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBRECOMERCIAL= "nombre_comercial";
    public static final String NOMBREGARANTIA= "nombre_garantia";
    public static final String LIMITECREDITO= "limite_credito";
    public static final String TOTALPEDIDOS= "total_pedidos";
    public static final String TOTALSALDOS= "total_saldos";
    public static final String TOTALCHEQUES= "total_cheques";
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
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBRECOMERCIAL= "Nombre Comercial";
		public static final String LABEL_NOMBRECOMERCIAL_LOWER= "Nombre Comercial";
    	public static final String LABEL_NOMBREGARANTIA= "Nombre Garantia";
		public static final String LABEL_NOMBREGARANTIA_LOWER= "Nombre Garantia";
    	public static final String LABEL_LIMITECREDITO= "Limite Credito";
		public static final String LABEL_LIMITECREDITO_LOWER= "Limite Credito";
    	public static final String LABEL_TOTALPEDIDOS= "Total Pedos";
		public static final String LABEL_TOTALPEDIDOS_LOWER= "Total Pedidos";
    	public static final String LABEL_TOTALSALDOS= "Total Saldos";
		public static final String LABEL_TOTALSALDOS_LOWER= "Total Saldos";
    	public static final String LABEL_TOTALCHEQUES= "Total Cheques";
		public static final String LABEL_TOTALCHEQUES_LOWER= "Total Cheques";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GARANTIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GARANTIA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getCobrarClientesSaldosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMERCIAL;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_NOMBREGARANTIA;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.LIMITECREDITO)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.TOTALSALDOS)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS;}
		if(sNombreColumna.equals(CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES)) {sLabelColumna=CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarClientesSaldosDescripcion(CobrarClientesSaldos cobrarclientessaldos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarclientessaldos !=null/* && cobrarclientessaldos.getId()!=0*/) {
			sDescripcion=cobrarclientessaldos.getcodigo();//cobrarclientessaldoscobrarclientessaldos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarClientesSaldosDescripcionDetallado(CobrarClientesSaldos cobrarclientessaldos) {
		String sDescripcion="";
			
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarclientessaldos.getId().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarclientessaldos.getVersionRow().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarclientessaldos.getid_empresa().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cobrarclientessaldos.getid_sucursal().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=cobrarclientessaldos.getid_ejercicio().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=cobrarclientessaldos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarclientessaldos.getcodigo()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarclientessaldos.getnombre_completo()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL+"=";
		sDescripcion+=cobrarclientessaldos.getnombre_comercial()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA+"=";
		sDescripcion+=cobrarclientessaldos.getnombre_garantia()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.LIMITECREDITO+"=";
		sDescripcion+=cobrarclientessaldos.getlimite_credito().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS+"=";
		sDescripcion+=cobrarclientessaldos.gettotal_pedidos().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.TOTALSALDOS+"=";
		sDescripcion+=cobrarclientessaldos.gettotal_saldos().toString()+",";
		sDescripcion+=CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES+"=";
		sDescripcion+=cobrarclientessaldos.gettotal_cheques().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarClientesSaldosDescripcion(CobrarClientesSaldos cobrarclientessaldos,String sValor) throws Exception {			
		if(cobrarclientessaldos !=null) {
			cobrarclientessaldos.setcodigo(sValor);;//cobrarclientessaldoscobrarclientessaldos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaCobrarClientesSaldos")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Fecha Emision Hasta";
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

	public static String getDetalleIndiceBusquedaCobrarClientesSaldos(Long id_ejercicio,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientessaldos.setcodigo(cobrarclientessaldos.getcodigo().trim());
		cobrarclientessaldos.setnombre_completo(cobrarclientessaldos.getnombre_completo().trim());
		cobrarclientessaldos.setnombre_comercial(cobrarclientessaldos.getnombre_comercial().trim());
		cobrarclientessaldos.setnombre_garantia(cobrarclientessaldos.getnombre_garantia().trim());
	}
	
	public static void quitarEspaciosCobrarClientesSaldoss(List<CobrarClientesSaldos> cobrarclientessaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesSaldos cobrarclientessaldos: cobrarclientessaldoss) {
			cobrarclientessaldos.setcodigo(cobrarclientessaldos.getcodigo().trim());
			cobrarclientessaldos.setnombre_completo(cobrarclientessaldos.getnombre_completo().trim());
			cobrarclientessaldos.setnombre_comercial(cobrarclientessaldos.getnombre_comercial().trim());
			cobrarclientessaldos.setnombre_garantia(cobrarclientessaldos.getnombre_garantia().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarclientessaldos.getConCambioAuxiliar()) {
			cobrarclientessaldos.setIsDeleted(cobrarclientessaldos.getIsDeletedAuxiliar());	
			cobrarclientessaldos.setIsNew(cobrarclientessaldos.getIsNewAuxiliar());	
			cobrarclientessaldos.setIsChanged(cobrarclientessaldos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarclientessaldos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarclientessaldos.setIsDeletedAuxiliar(false);	
			cobrarclientessaldos.setIsNewAuxiliar(false);	
			cobrarclientessaldos.setIsChangedAuxiliar(false);
			
			cobrarclientessaldos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesSaldoss(List<CobrarClientesSaldos> cobrarclientessaldoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarClientesSaldos cobrarclientessaldos : cobrarclientessaldoss) {
			if(conAsignarBase && cobrarclientessaldos.getConCambioAuxiliar()) {
				cobrarclientessaldos.setIsDeleted(cobrarclientessaldos.getIsDeletedAuxiliar());	
				cobrarclientessaldos.setIsNew(cobrarclientessaldos.getIsNewAuxiliar());	
				cobrarclientessaldos.setIsChanged(cobrarclientessaldos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarclientessaldos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarclientessaldos.setIsDeletedAuxiliar(false);	
				cobrarclientessaldos.setIsNewAuxiliar(false);	
				cobrarclientessaldos.setIsChangedAuxiliar(false);
				
				cobrarclientessaldos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldos,Boolean conEnteros) throws Exception  {
		cobrarclientessaldos.setlimite_credito(0.0);
		cobrarclientessaldos.settotal_pedidos(0.0);
		cobrarclientessaldos.settotal_saldos(0.0);
		cobrarclientessaldos.settotal_cheques(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarClientesSaldoss(List<CobrarClientesSaldos> cobrarclientessaldoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarClientesSaldos cobrarclientessaldos: cobrarclientessaldoss) {
			cobrarclientessaldos.setlimite_credito(0.0);
			cobrarclientessaldos.settotal_pedidos(0.0);
			cobrarclientessaldos.settotal_saldos(0.0);
			cobrarclientessaldos.settotal_cheques(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarClientesSaldos(List<CobrarClientesSaldos> cobrarclientessaldoss,CobrarClientesSaldos cobrarclientessaldosAux) throws Exception  {
		CobrarClientesSaldosConstantesFunciones.InicializarValoresCobrarClientesSaldos(cobrarclientessaldosAux,true);
		
		for(CobrarClientesSaldos cobrarclientessaldos: cobrarclientessaldoss) {
			if(cobrarclientessaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarclientessaldosAux.setlimite_credito(cobrarclientessaldosAux.getlimite_credito()+cobrarclientessaldos.getlimite_credito());			
			cobrarclientessaldosAux.settotal_pedidos(cobrarclientessaldosAux.gettotal_pedidos()+cobrarclientessaldos.gettotal_pedidos());			
			cobrarclientessaldosAux.settotal_saldos(cobrarclientessaldosAux.gettotal_saldos()+cobrarclientessaldos.gettotal_saldos());			
			cobrarclientessaldosAux.settotal_cheques(cobrarclientessaldosAux.gettotal_cheques()+cobrarclientessaldos.gettotal_cheques());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarClientesSaldosConstantesFunciones.getArrayColumnasGlobalesCobrarClientesSaldos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesSaldos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesSaldosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesSaldosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarClientesSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesSaldos> cobrarclientessaldoss,CobrarClientesSaldos cobrarclientessaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesSaldos cobrarclientessaldosAux: cobrarclientessaldoss) {
			if(cobrarclientessaldosAux!=null && cobrarclientessaldos!=null) {
				if((cobrarclientessaldosAux.getId()==null && cobrarclientessaldos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarclientessaldosAux.getId()!=null && cobrarclientessaldos.getId()!=null){
					if(cobrarclientessaldosAux.getId().equals(cobrarclientessaldos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesSaldos(List<CobrarClientesSaldos> cobrarclientessaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double limite_creditoTotal=0.0;
		Double total_pedidosTotal=0.0;
		Double total_saldosTotal=0.0;
		Double total_chequesTotal=0.0;
	
		for(CobrarClientesSaldos cobrarclientessaldos: cobrarclientessaldoss) {			
			if(cobrarclientessaldos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			limite_creditoTotal+=cobrarclientessaldos.getlimite_credito();
			total_pedidosTotal+=cobrarclientessaldos.gettotal_pedidos();
			total_saldosTotal+=cobrarclientessaldos.gettotal_saldos();
			total_chequesTotal+=cobrarclientessaldos.gettotal_cheques();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS);
		datoGeneral.setdValorDouble(total_pedidosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.TOTALSALDOS);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS);
		datoGeneral.setdValorDouble(total_saldosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES);
		datoGeneral.setdValorDouble(total_chequesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarClientesSaldos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_ID, CobrarClientesSaldosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_VERSIONROW, CobrarClientesSaldosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_CODIGO, CobrarClientesSaldosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMERCIAL, CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_NOMBREGARANTIA, CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO, CobrarClientesSaldosConstantesFunciones.LIMITECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS, CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS, CobrarClientesSaldosConstantesFunciones.TOTALSALDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES, CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarClientesSaldos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.LIMITECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.TOTALSALDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesSaldos() throws Exception  {
		return CobrarClientesSaldosConstantesFunciones.getTiposSeleccionarCobrarClientesSaldos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesSaldos(Boolean conFk) throws Exception  {
		return CobrarClientesSaldosConstantesFunciones.getTiposSeleccionarCobrarClientesSaldos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesSaldos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMERCIAL);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMERCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBREGARANTIA);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBREGARANTIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES);
			reporte.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarClientesSaldos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldosAux) throws Exception {
		
			cobrarclientessaldosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientessaldosAux.getEmpresa()));
			cobrarclientessaldosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclientessaldosAux.getSucursal()));
			cobrarclientessaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(cobrarclientessaldosAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesSaldos(List<CobrarClientesSaldos> cobrarclientessaldossTemp) throws Exception {
		for(CobrarClientesSaldos cobrarclientessaldosAux:cobrarclientessaldossTemp) {
			
			cobrarclientessaldosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientessaldosAux.getEmpresa()));
			cobrarclientessaldosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclientessaldosAux.getSucursal()));
			cobrarclientessaldosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(cobrarclientessaldosAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarClientesSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarClientesSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesSaldosConstantesFunciones.getClassesRelationshipsOfCobrarClientesSaldos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesSaldos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesSaldosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarClientesSaldos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesSaldos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(CobrarClientesSaldos cobrarclientessaldos,List<CobrarClientesSaldos> cobrarclientessaldoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarClientesSaldos cobrarclientessaldos,List<CobrarClientesSaldos> cobrarclientessaldoss) throws Exception {
		try	{			
			for(CobrarClientesSaldos cobrarclientessaldosLocal:cobrarclientessaldoss) {
				if(cobrarclientessaldosLocal.getId().equals(cobrarclientessaldos.getId())) {
					cobrarclientessaldosLocal.setIsSelected(cobrarclientessaldos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarClientesSaldos(List<CobrarClientesSaldos> cobrarclientessaldossAux) throws Exception {
		//this.cobrarclientessaldossAux=cobrarclientessaldossAux;
		
		for(CobrarClientesSaldos cobrarclientessaldosAux:cobrarclientessaldossAux) {
			if(cobrarclientessaldosAux.getIsChanged()) {
				cobrarclientessaldosAux.setIsChanged(false);
			}		
			
			if(cobrarclientessaldosAux.getIsNew()) {
				cobrarclientessaldosAux.setIsNew(false);
			}	
			
			if(cobrarclientessaldosAux.getIsDeleted()) {
				cobrarclientessaldosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldosAux) throws Exception {
		//this.cobrarclientessaldosAux=cobrarclientessaldosAux;
		
			if(cobrarclientessaldosAux.getIsChanged()) {
				cobrarclientessaldosAux.setIsChanged(false);
			}		
			
			if(cobrarclientessaldosAux.getIsNew()) {
				cobrarclientessaldosAux.setIsNew(false);
			}	
			
			if(cobrarclientessaldosAux.getIsDeleted()) {
				cobrarclientessaldosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarClientesSaldos cobrarclientessaldosAsignar,CobrarClientesSaldos cobrarclientessaldos) throws Exception {
		cobrarclientessaldosAsignar.setId(cobrarclientessaldos.getId());	
		cobrarclientessaldosAsignar.setVersionRow(cobrarclientessaldos.getVersionRow());	
		cobrarclientessaldosAsignar.setcodigo(cobrarclientessaldos.getcodigo());	
		cobrarclientessaldosAsignar.setnombre_completo(cobrarclientessaldos.getnombre_completo());	
		cobrarclientessaldosAsignar.setnombre_comercial(cobrarclientessaldos.getnombre_comercial());	
		cobrarclientessaldosAsignar.setnombre_garantia(cobrarclientessaldos.getnombre_garantia());	
		cobrarclientessaldosAsignar.setlimite_credito(cobrarclientessaldos.getlimite_credito());	
		cobrarclientessaldosAsignar.settotal_pedidos(cobrarclientessaldos.gettotal_pedidos());	
		cobrarclientessaldosAsignar.settotal_saldos(cobrarclientessaldos.gettotal_saldos());	
		cobrarclientessaldosAsignar.settotal_cheques(cobrarclientessaldos.gettotal_cheques());	
	}
	
	public static void inicializarCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldos) throws Exception {
		try {
				cobrarclientessaldos.setId(0L);	
					
				cobrarclientessaldos.setcodigo("");	
				cobrarclientessaldos.setnombre_completo("");	
				cobrarclientessaldos.setnombre_comercial("");	
				cobrarclientessaldos.setnombre_garantia("");	
				cobrarclientessaldos.setlimite_credito(0.0);	
				cobrarclientessaldos.settotal_pedidos(0.0);	
				cobrarclientessaldos.settotal_saldos(0.0);	
				cobrarclientessaldos.settotal_cheques(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarClientesSaldos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBRECOMERCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_NOMBREGARANTIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarClientesSaldos(String sTipo,Row row,Workbook workbook,CobrarClientesSaldos cobrarclientessaldos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getnombre_comercial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getnombre_garantia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.getlimite_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.gettotal_pedidos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.gettotal_saldos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessaldos.gettotal_cheques());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarClientesSaldos="";
	
	public String getsFinalQueryCobrarClientesSaldos() {
		return this.sFinalQueryCobrarClientesSaldos;
	}
	
	public void setsFinalQueryCobrarClientesSaldos(String sFinalQueryCobrarClientesSaldos) {
		this.sFinalQueryCobrarClientesSaldos= sFinalQueryCobrarClientesSaldos;
	}
	
	public Border resaltarSeleccionarCobrarClientesSaldos=null;
	
	public Border setResaltarSeleccionarCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarClientesSaldos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarClientesSaldos() {
		return this.resaltarSeleccionarCobrarClientesSaldos;
	}
	
	public void setResaltarSeleccionarCobrarClientesSaldos(Border borderResaltarSeleccionarCobrarClientesSaldos) {
		this.resaltarSeleccionarCobrarClientesSaldos= borderResaltarSeleccionarCobrarClientesSaldos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarClientesSaldos=null;
	public Boolean mostraridCobrarClientesSaldos=true;
	public Boolean activaridCobrarClientesSaldos=true;

	public Border resaltarid_empresaCobrarClientesSaldos=null;
	public Boolean mostrarid_empresaCobrarClientesSaldos=true;
	public Boolean activarid_empresaCobrarClientesSaldos=true;
	public Boolean cargarid_empresaCobrarClientesSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarClientesSaldos=false;//ConEventDepend=true

	public Border resaltarid_sucursalCobrarClientesSaldos=null;
	public Boolean mostrarid_sucursalCobrarClientesSaldos=true;
	public Boolean activarid_sucursalCobrarClientesSaldos=true;
	public Boolean cargarid_sucursalCobrarClientesSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCobrarClientesSaldos=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCobrarClientesSaldos=null;
	public Boolean mostrarid_ejercicioCobrarClientesSaldos=true;
	public Boolean activarid_ejercicioCobrarClientesSaldos=true;
	public Boolean cargarid_ejercicioCobrarClientesSaldos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCobrarClientesSaldos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_hastaCobrarClientesSaldos=null;
	public Boolean mostrarfecha_emision_hastaCobrarClientesSaldos=true;
	public Boolean activarfecha_emision_hastaCobrarClientesSaldos=true;

	public Border resaltarcodigoCobrarClientesSaldos=null;
	public Boolean mostrarcodigoCobrarClientesSaldos=true;
	public Boolean activarcodigoCobrarClientesSaldos=true;

	public Border resaltarnombre_completoCobrarClientesSaldos=null;
	public Boolean mostrarnombre_completoCobrarClientesSaldos=true;
	public Boolean activarnombre_completoCobrarClientesSaldos=true;

	public Border resaltarnombre_comercialCobrarClientesSaldos=null;
	public Boolean mostrarnombre_comercialCobrarClientesSaldos=true;
	public Boolean activarnombre_comercialCobrarClientesSaldos=true;

	public Border resaltarnombre_garantiaCobrarClientesSaldos=null;
	public Boolean mostrarnombre_garantiaCobrarClientesSaldos=true;
	public Boolean activarnombre_garantiaCobrarClientesSaldos=true;

	public Border resaltarlimite_creditoCobrarClientesSaldos=null;
	public Boolean mostrarlimite_creditoCobrarClientesSaldos=true;
	public Boolean activarlimite_creditoCobrarClientesSaldos=true;

	public Border resaltartotal_pedidosCobrarClientesSaldos=null;
	public Boolean mostrartotal_pedidosCobrarClientesSaldos=true;
	public Boolean activartotal_pedidosCobrarClientesSaldos=true;

	public Border resaltartotal_saldosCobrarClientesSaldos=null;
	public Boolean mostrartotal_saldosCobrarClientesSaldos=true;
	public Boolean activartotal_saldosCobrarClientesSaldos=true;

	public Border resaltartotal_chequesCobrarClientesSaldos=null;
	public Boolean mostrartotal_chequesCobrarClientesSaldos=true;
	public Boolean activartotal_chequesCobrarClientesSaldos=true;

	
	

	public Border setResaltaridCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltaridCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarClientesSaldos() {
		return this.resaltaridCobrarClientesSaldos;
	}

	public void setResaltaridCobrarClientesSaldos(Border borderResaltar) {
		this.resaltaridCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostraridCobrarClientesSaldos() {
		return this.mostraridCobrarClientesSaldos;
	}

	public void setMostraridCobrarClientesSaldos(Boolean mostraridCobrarClientesSaldos) {
		this.mostraridCobrarClientesSaldos= mostraridCobrarClientesSaldos;
	}

	public Boolean getActivaridCobrarClientesSaldos() {
		return this.activaridCobrarClientesSaldos;
	}

	public void setActivaridCobrarClientesSaldos(Boolean activaridCobrarClientesSaldos) {
		this.activaridCobrarClientesSaldos= activaridCobrarClientesSaldos;
	}

	public Border setResaltarid_empresaCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarClientesSaldos() {
		return this.resaltarid_empresaCobrarClientesSaldos;
	}

	public void setResaltarid_empresaCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarid_empresaCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarClientesSaldos() {
		return this.mostrarid_empresaCobrarClientesSaldos;
	}

	public void setMostrarid_empresaCobrarClientesSaldos(Boolean mostrarid_empresaCobrarClientesSaldos) {
		this.mostrarid_empresaCobrarClientesSaldos= mostrarid_empresaCobrarClientesSaldos;
	}

	public Boolean getActivarid_empresaCobrarClientesSaldos() {
		return this.activarid_empresaCobrarClientesSaldos;
	}

	public void setActivarid_empresaCobrarClientesSaldos(Boolean activarid_empresaCobrarClientesSaldos) {
		this.activarid_empresaCobrarClientesSaldos= activarid_empresaCobrarClientesSaldos;
	}

	public Boolean getCargarid_empresaCobrarClientesSaldos() {
		return this.cargarid_empresaCobrarClientesSaldos;
	}

	public void setCargarid_empresaCobrarClientesSaldos(Boolean cargarid_empresaCobrarClientesSaldos) {
		this.cargarid_empresaCobrarClientesSaldos= cargarid_empresaCobrarClientesSaldos;
	}

	public Border setResaltarid_sucursalCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCobrarClientesSaldos() {
		return this.resaltarid_sucursalCobrarClientesSaldos;
	}

	public void setResaltarid_sucursalCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarid_sucursalCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCobrarClientesSaldos() {
		return this.mostrarid_sucursalCobrarClientesSaldos;
	}

	public void setMostrarid_sucursalCobrarClientesSaldos(Boolean mostrarid_sucursalCobrarClientesSaldos) {
		this.mostrarid_sucursalCobrarClientesSaldos= mostrarid_sucursalCobrarClientesSaldos;
	}

	public Boolean getActivarid_sucursalCobrarClientesSaldos() {
		return this.activarid_sucursalCobrarClientesSaldos;
	}

	public void setActivarid_sucursalCobrarClientesSaldos(Boolean activarid_sucursalCobrarClientesSaldos) {
		this.activarid_sucursalCobrarClientesSaldos= activarid_sucursalCobrarClientesSaldos;
	}

	public Boolean getCargarid_sucursalCobrarClientesSaldos() {
		return this.cargarid_sucursalCobrarClientesSaldos;
	}

	public void setCargarid_sucursalCobrarClientesSaldos(Boolean cargarid_sucursalCobrarClientesSaldos) {
		this.cargarid_sucursalCobrarClientesSaldos= cargarid_sucursalCobrarClientesSaldos;
	}

	public Border setResaltarid_ejercicioCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCobrarClientesSaldos() {
		return this.resaltarid_ejercicioCobrarClientesSaldos;
	}

	public void setResaltarid_ejercicioCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarid_ejercicioCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCobrarClientesSaldos() {
		return this.mostrarid_ejercicioCobrarClientesSaldos;
	}

	public void setMostrarid_ejercicioCobrarClientesSaldos(Boolean mostrarid_ejercicioCobrarClientesSaldos) {
		this.mostrarid_ejercicioCobrarClientesSaldos= mostrarid_ejercicioCobrarClientesSaldos;
	}

	public Boolean getActivarid_ejercicioCobrarClientesSaldos() {
		return this.activarid_ejercicioCobrarClientesSaldos;
	}

	public void setActivarid_ejercicioCobrarClientesSaldos(Boolean activarid_ejercicioCobrarClientesSaldos) {
		this.activarid_ejercicioCobrarClientesSaldos= activarid_ejercicioCobrarClientesSaldos;
	}

	public Boolean getCargarid_ejercicioCobrarClientesSaldos() {
		return this.cargarid_ejercicioCobrarClientesSaldos;
	}

	public void setCargarid_ejercicioCobrarClientesSaldos(Boolean cargarid_ejercicioCobrarClientesSaldos) {
		this.cargarid_ejercicioCobrarClientesSaldos= cargarid_ejercicioCobrarClientesSaldos;
	}

	public Border setResaltarfecha_emision_hastaCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaCobrarClientesSaldos() {
		return this.resaltarfecha_emision_hastaCobrarClientesSaldos;
	}

	public void setResaltarfecha_emision_hastaCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaCobrarClientesSaldos() {
		return this.mostrarfecha_emision_hastaCobrarClientesSaldos;
	}

	public void setMostrarfecha_emision_hastaCobrarClientesSaldos(Boolean mostrarfecha_emision_hastaCobrarClientesSaldos) {
		this.mostrarfecha_emision_hastaCobrarClientesSaldos= mostrarfecha_emision_hastaCobrarClientesSaldos;
	}

	public Boolean getActivarfecha_emision_hastaCobrarClientesSaldos() {
		return this.activarfecha_emision_hastaCobrarClientesSaldos;
	}

	public void setActivarfecha_emision_hastaCobrarClientesSaldos(Boolean activarfecha_emision_hastaCobrarClientesSaldos) {
		this.activarfecha_emision_hastaCobrarClientesSaldos= activarfecha_emision_hastaCobrarClientesSaldos;
	}

	public Border setResaltarcodigoCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarClientesSaldos() {
		return this.resaltarcodigoCobrarClientesSaldos;
	}

	public void setResaltarcodigoCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarcodigoCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarClientesSaldos() {
		return this.mostrarcodigoCobrarClientesSaldos;
	}

	public void setMostrarcodigoCobrarClientesSaldos(Boolean mostrarcodigoCobrarClientesSaldos) {
		this.mostrarcodigoCobrarClientesSaldos= mostrarcodigoCobrarClientesSaldos;
	}

	public Boolean getActivarcodigoCobrarClientesSaldos() {
		return this.activarcodigoCobrarClientesSaldos;
	}

	public void setActivarcodigoCobrarClientesSaldos(Boolean activarcodigoCobrarClientesSaldos) {
		this.activarcodigoCobrarClientesSaldos= activarcodigoCobrarClientesSaldos;
	}

	public Border setResaltarnombre_completoCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarClientesSaldos() {
		return this.resaltarnombre_completoCobrarClientesSaldos;
	}

	public void setResaltarnombre_completoCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarnombre_completoCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarClientesSaldos() {
		return this.mostrarnombre_completoCobrarClientesSaldos;
	}

	public void setMostrarnombre_completoCobrarClientesSaldos(Boolean mostrarnombre_completoCobrarClientesSaldos) {
		this.mostrarnombre_completoCobrarClientesSaldos= mostrarnombre_completoCobrarClientesSaldos;
	}

	public Boolean getActivarnombre_completoCobrarClientesSaldos() {
		return this.activarnombre_completoCobrarClientesSaldos;
	}

	public void setActivarnombre_completoCobrarClientesSaldos(Boolean activarnombre_completoCobrarClientesSaldos) {
		this.activarnombre_completoCobrarClientesSaldos= activarnombre_completoCobrarClientesSaldos;
	}

	public Border setResaltarnombre_comercialCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_comercialCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_comercialCobrarClientesSaldos() {
		return this.resaltarnombre_comercialCobrarClientesSaldos;
	}

	public void setResaltarnombre_comercialCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarnombre_comercialCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_comercialCobrarClientesSaldos() {
		return this.mostrarnombre_comercialCobrarClientesSaldos;
	}

	public void setMostrarnombre_comercialCobrarClientesSaldos(Boolean mostrarnombre_comercialCobrarClientesSaldos) {
		this.mostrarnombre_comercialCobrarClientesSaldos= mostrarnombre_comercialCobrarClientesSaldos;
	}

	public Boolean getActivarnombre_comercialCobrarClientesSaldos() {
		return this.activarnombre_comercialCobrarClientesSaldos;
	}

	public void setActivarnombre_comercialCobrarClientesSaldos(Boolean activarnombre_comercialCobrarClientesSaldos) {
		this.activarnombre_comercialCobrarClientesSaldos= activarnombre_comercialCobrarClientesSaldos;
	}

	public Border setResaltarnombre_garantiaCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarnombre_garantiaCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_garantiaCobrarClientesSaldos() {
		return this.resaltarnombre_garantiaCobrarClientesSaldos;
	}

	public void setResaltarnombre_garantiaCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarnombre_garantiaCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarnombre_garantiaCobrarClientesSaldos() {
		return this.mostrarnombre_garantiaCobrarClientesSaldos;
	}

	public void setMostrarnombre_garantiaCobrarClientesSaldos(Boolean mostrarnombre_garantiaCobrarClientesSaldos) {
		this.mostrarnombre_garantiaCobrarClientesSaldos= mostrarnombre_garantiaCobrarClientesSaldos;
	}

	public Boolean getActivarnombre_garantiaCobrarClientesSaldos() {
		return this.activarnombre_garantiaCobrarClientesSaldos;
	}

	public void setActivarnombre_garantiaCobrarClientesSaldos(Boolean activarnombre_garantiaCobrarClientesSaldos) {
		this.activarnombre_garantiaCobrarClientesSaldos= activarnombre_garantiaCobrarClientesSaldos;
	}

	public Border setResaltarlimite_creditoCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltarlimite_creditoCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlimite_creditoCobrarClientesSaldos() {
		return this.resaltarlimite_creditoCobrarClientesSaldos;
	}

	public void setResaltarlimite_creditoCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarlimite_creditoCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrarlimite_creditoCobrarClientesSaldos() {
		return this.mostrarlimite_creditoCobrarClientesSaldos;
	}

	public void setMostrarlimite_creditoCobrarClientesSaldos(Boolean mostrarlimite_creditoCobrarClientesSaldos) {
		this.mostrarlimite_creditoCobrarClientesSaldos= mostrarlimite_creditoCobrarClientesSaldos;
	}

	public Boolean getActivarlimite_creditoCobrarClientesSaldos() {
		return this.activarlimite_creditoCobrarClientesSaldos;
	}

	public void setActivarlimite_creditoCobrarClientesSaldos(Boolean activarlimite_creditoCobrarClientesSaldos) {
		this.activarlimite_creditoCobrarClientesSaldos= activarlimite_creditoCobrarClientesSaldos;
	}

	public Border setResaltartotal_pedidosCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_pedidosCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_pedidosCobrarClientesSaldos() {
		return this.resaltartotal_pedidosCobrarClientesSaldos;
	}

	public void setResaltartotal_pedidosCobrarClientesSaldos(Border borderResaltar) {
		this.resaltartotal_pedidosCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_pedidosCobrarClientesSaldos() {
		return this.mostrartotal_pedidosCobrarClientesSaldos;
	}

	public void setMostrartotal_pedidosCobrarClientesSaldos(Boolean mostrartotal_pedidosCobrarClientesSaldos) {
		this.mostrartotal_pedidosCobrarClientesSaldos= mostrartotal_pedidosCobrarClientesSaldos;
	}

	public Boolean getActivartotal_pedidosCobrarClientesSaldos() {
		return this.activartotal_pedidosCobrarClientesSaldos;
	}

	public void setActivartotal_pedidosCobrarClientesSaldos(Boolean activartotal_pedidosCobrarClientesSaldos) {
		this.activartotal_pedidosCobrarClientesSaldos= activartotal_pedidosCobrarClientesSaldos;
	}

	public Border setResaltartotal_saldosCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_saldosCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_saldosCobrarClientesSaldos() {
		return this.resaltartotal_saldosCobrarClientesSaldos;
	}

	public void setResaltartotal_saldosCobrarClientesSaldos(Border borderResaltar) {
		this.resaltartotal_saldosCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_saldosCobrarClientesSaldos() {
		return this.mostrartotal_saldosCobrarClientesSaldos;
	}

	public void setMostrartotal_saldosCobrarClientesSaldos(Boolean mostrartotal_saldosCobrarClientesSaldos) {
		this.mostrartotal_saldosCobrarClientesSaldos= mostrartotal_saldosCobrarClientesSaldos;
	}

	public Boolean getActivartotal_saldosCobrarClientesSaldos() {
		return this.activartotal_saldosCobrarClientesSaldos;
	}

	public void setActivartotal_saldosCobrarClientesSaldos(Boolean activartotal_saldosCobrarClientesSaldos) {
		this.activartotal_saldosCobrarClientesSaldos= activartotal_saldosCobrarClientesSaldos;
	}

	public Border setResaltartotal_chequesCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessaldosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSaldos.setBorder(borderResaltar);
		
		this.resaltartotal_chequesCobrarClientesSaldos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_chequesCobrarClientesSaldos() {
		return this.resaltartotal_chequesCobrarClientesSaldos;
	}

	public void setResaltartotal_chequesCobrarClientesSaldos(Border borderResaltar) {
		this.resaltartotal_chequesCobrarClientesSaldos= borderResaltar;
	}

	public Boolean getMostrartotal_chequesCobrarClientesSaldos() {
		return this.mostrartotal_chequesCobrarClientesSaldos;
	}

	public void setMostrartotal_chequesCobrarClientesSaldos(Boolean mostrartotal_chequesCobrarClientesSaldos) {
		this.mostrartotal_chequesCobrarClientesSaldos= mostrartotal_chequesCobrarClientesSaldos;
	}

	public Boolean getActivartotal_chequesCobrarClientesSaldos() {
		return this.activartotal_chequesCobrarClientesSaldos;
	}

	public void setActivartotal_chequesCobrarClientesSaldos(Boolean activartotal_chequesCobrarClientesSaldos) {
		this.activartotal_chequesCobrarClientesSaldos= activartotal_chequesCobrarClientesSaldos;
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
		
		
		this.setMostraridCobrarClientesSaldos(esInicial);
		this.setMostrarid_empresaCobrarClientesSaldos(esInicial);
		this.setMostrarid_sucursalCobrarClientesSaldos(esInicial);
		this.setMostrarid_ejercicioCobrarClientesSaldos(esInicial);
		this.setMostrarfecha_emision_hastaCobrarClientesSaldos(esInicial);
		this.setMostrarcodigoCobrarClientesSaldos(esInicial);
		this.setMostrarnombre_completoCobrarClientesSaldos(esInicial);
		this.setMostrarnombre_comercialCobrarClientesSaldos(esInicial);
		this.setMostrarnombre_garantiaCobrarClientesSaldos(esInicial);
		this.setMostrarlimite_creditoCobrarClientesSaldos(esInicial);
		this.setMostrartotal_pedidosCobrarClientesSaldos(esInicial);
		this.setMostrartotal_saldosCobrarClientesSaldos(esInicial);
		this.setMostrartotal_chequesCobrarClientesSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.ID)) {
				this.setMostraridCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setMostrarnombre_comercialCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA)) {
				this.setMostrarnombre_garantiaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.LIMITECREDITO)) {
				this.setMostrarlimite_creditoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS)) {
				this.setMostrartotal_pedidosCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALSALDOS)) {
				this.setMostrartotal_saldosCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES)) {
				this.setMostrartotal_chequesCobrarClientesSaldos(esAsigna);
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
		
		
		this.setActivaridCobrarClientesSaldos(esInicial);
		this.setActivarid_empresaCobrarClientesSaldos(esInicial);
		this.setActivarid_sucursalCobrarClientesSaldos(esInicial);
		this.setActivarid_ejercicioCobrarClientesSaldos(esInicial);
		this.setActivarfecha_emision_hastaCobrarClientesSaldos(esInicial);
		this.setActivarcodigoCobrarClientesSaldos(esInicial);
		this.setActivarnombre_completoCobrarClientesSaldos(esInicial);
		this.setActivarnombre_comercialCobrarClientesSaldos(esInicial);
		this.setActivarnombre_garantiaCobrarClientesSaldos(esInicial);
		this.setActivarlimite_creditoCobrarClientesSaldos(esInicial);
		this.setActivartotal_pedidosCobrarClientesSaldos(esInicial);
		this.setActivartotal_saldosCobrarClientesSaldos(esInicial);
		this.setActivartotal_chequesCobrarClientesSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.ID)) {
				this.setActivaridCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setActivarnombre_comercialCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA)) {
				this.setActivarnombre_garantiaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.LIMITECREDITO)) {
				this.setActivarlimite_creditoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS)) {
				this.setActivartotal_pedidosCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALSALDOS)) {
				this.setActivartotal_saldosCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES)) {
				this.setActivartotal_chequesCobrarClientesSaldos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarClientesSaldos(esInicial);
		this.setResaltarid_empresaCobrarClientesSaldos(esInicial);
		this.setResaltarid_sucursalCobrarClientesSaldos(esInicial);
		this.setResaltarid_ejercicioCobrarClientesSaldos(esInicial);
		this.setResaltarfecha_emision_hastaCobrarClientesSaldos(esInicial);
		this.setResaltarcodigoCobrarClientesSaldos(esInicial);
		this.setResaltarnombre_completoCobrarClientesSaldos(esInicial);
		this.setResaltarnombre_comercialCobrarClientesSaldos(esInicial);
		this.setResaltarnombre_garantiaCobrarClientesSaldos(esInicial);
		this.setResaltarlimite_creditoCobrarClientesSaldos(esInicial);
		this.setResaltartotal_pedidosCobrarClientesSaldos(esInicial);
		this.setResaltartotal_saldosCobrarClientesSaldos(esInicial);
		this.setResaltartotal_chequesCobrarClientesSaldos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.ID)) {
				this.setResaltaridCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setResaltarnombre_comercialCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.NOMBREGARANTIA)) {
				this.setResaltarnombre_garantiaCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.LIMITECREDITO)) {
				this.setResaltarlimite_creditoCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS)) {
				this.setResaltartotal_pedidosCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALSALDOS)) {
				this.setResaltartotal_saldosCobrarClientesSaldos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES)) {
				this.setResaltartotal_chequesCobrarClientesSaldos(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaCobrarClientesSaldosCobrarClientesSaldos=true;

	public Boolean getMostrarBusquedaCobrarClientesSaldosCobrarClientesSaldos() {
		return this.mostrarBusquedaCobrarClientesSaldosCobrarClientesSaldos;
	}

	public void setMostrarBusquedaCobrarClientesSaldosCobrarClientesSaldos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarClientesSaldosCobrarClientesSaldos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarClientesSaldosCobrarClientesSaldos=true;

	public Boolean getActivarBusquedaCobrarClientesSaldosCobrarClientesSaldos() {
		return this.activarBusquedaCobrarClientesSaldosCobrarClientesSaldos;
	}

	public void setActivarBusquedaCobrarClientesSaldosCobrarClientesSaldos(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarClientesSaldosCobrarClientesSaldos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos=null;

	public Border getResaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos() {
		return this.resaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos;
	}

	public void setResaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos(Border borderResaltar) {
		this.resaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos= borderResaltar;
	}

	public void setResaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSaldosBeanSwingJInternalFrame cobrarclientessaldosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarClientesSaldosCobrarClientesSaldos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}