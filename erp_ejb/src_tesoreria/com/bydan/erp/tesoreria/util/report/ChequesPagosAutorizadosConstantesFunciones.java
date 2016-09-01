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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ChequesPagosAutorizadosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ChequesPagosAutorizados";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ChequesPagosAutorizados"+ChequesPagosAutorizadosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ChequesPagosAutorizadosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ChequesPagosAutorizadosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"_"+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ChequesPagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"_"+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"_"+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ChequesPagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"_"+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ChequesPagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ChequesPagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ChequesPagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ChequesPagosAutorizadosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ChequesPagosAutorizadosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ChequesPagosAutorizadosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ChequesPagosAutorizadosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cheques Pagos Autorizadoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cheques Pagos Autorizados";
	public static final String SCLASSWEBTITULO_LOWER="Cheques Pagos Autorizados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ChequesPagosAutorizados";
	public static final String OBJECTNAME="chequespagosautorizados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="cheques_pagos_autorizados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select chequespagosautorizados from "+ChequesPagosAutorizadosConstantesFunciones.SPERSISTENCENAME+" chequespagosautorizados";
	public static String QUERYSELECTNATIVE="select "+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".id,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".version_row,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".id_empresa,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".fecha_desde,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".fecha_hasta,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".nombre_cliente,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".numero_factura,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".debito_mone_local,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".fecha,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".nombre_banco,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".valor,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".numero_cheque,"+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME+".numero_cuenta from "+ChequesPagosAutorizadosConstantesFunciones.SCHEMA+"."+ChequesPagosAutorizadosConstantesFunciones.TABLENAME;//+" as "+ChequesPagosAutorizadosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String FECHA= "fecha";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String VALOR= "valor";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String NUMEROCUENTA= "numero_cuenta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getChequesPagosAutorizadosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.FECHADESDE)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.FECHAHASTA)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.FECHA)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.VALOR)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getChequesPagosAutorizadosDescripcion(ChequesPagosAutorizados chequespagosautorizados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(chequespagosautorizados !=null/* && chequespagosautorizados.getId()!=0*/) {
			sDescripcion=chequespagosautorizados.getfecha_hasta().toString();//chequespagosautorizadoschequespagosautorizados.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getChequesPagosAutorizadosDescripcionDetallado(ChequesPagosAutorizados chequespagosautorizados) {
		String sDescripcion="";
			
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.ID+"=";
		sDescripcion+=chequespagosautorizados.getId().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=chequespagosautorizados.getVersionRow().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=chequespagosautorizados.getid_empresa().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=chequespagosautorizados.getfecha_desde().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=chequespagosautorizados.getfecha_hasta().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=chequespagosautorizados.getnombre_cliente()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=chequespagosautorizados.getnumero_factura()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=chequespagosautorizados.getdebito_mone_local().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.FECHA+"=";
		sDescripcion+=chequespagosautorizados.getfecha().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=chequespagosautorizados.getnombre_banco()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.VALOR+"=";
		sDescripcion+=chequespagosautorizados.getvalor().toString()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=chequespagosautorizados.getnumero_cheque()+",";
		sDescripcion+=ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=chequespagosautorizados.getnumero_cuenta()+",";
			
		return sDescripcion;
	}
	
	public static void setChequesPagosAutorizadosDescripcion(ChequesPagosAutorizados chequespagosautorizados,String sValor) throws Exception {			
		if(chequespagosautorizados !=null) {
			//chequespagosautorizadoschequespagosautorizados.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaChequesPagosAutorizados")) {
			sNombreIndice="Tipo=  Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaChequesPagosAutorizados(Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		chequespagosautorizados.setnombre_cliente(chequespagosautorizados.getnombre_cliente().trim());
		chequespagosautorizados.setnumero_factura(chequespagosautorizados.getnumero_factura().trim());
		chequespagosautorizados.setnombre_banco(chequespagosautorizados.getnombre_banco().trim());
		chequespagosautorizados.setnumero_cheque(chequespagosautorizados.getnumero_cheque().trim());
		chequespagosautorizados.setnumero_cuenta(chequespagosautorizados.getnumero_cuenta().trim());
	}
	
	public static void quitarEspaciosChequesPagosAutorizadoss(List<ChequesPagosAutorizados> chequespagosautorizadoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ChequesPagosAutorizados chequespagosautorizados: chequespagosautorizadoss) {
			chequespagosautorizados.setnombre_cliente(chequespagosautorizados.getnombre_cliente().trim());
			chequespagosautorizados.setnumero_factura(chequespagosautorizados.getnumero_factura().trim());
			chequespagosautorizados.setnombre_banco(chequespagosautorizados.getnombre_banco().trim());
			chequespagosautorizados.setnumero_cheque(chequespagosautorizados.getnumero_cheque().trim());
			chequespagosautorizados.setnumero_cuenta(chequespagosautorizados.getnumero_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && chequespagosautorizados.getConCambioAuxiliar()) {
			chequespagosautorizados.setIsDeleted(chequespagosautorizados.getIsDeletedAuxiliar());	
			chequespagosautorizados.setIsNew(chequespagosautorizados.getIsNewAuxiliar());	
			chequespagosautorizados.setIsChanged(chequespagosautorizados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			chequespagosautorizados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			chequespagosautorizados.setIsDeletedAuxiliar(false);	
			chequespagosautorizados.setIsNewAuxiliar(false);	
			chequespagosautorizados.setIsChangedAuxiliar(false);
			
			chequespagosautorizados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresChequesPagosAutorizadoss(List<ChequesPagosAutorizados> chequespagosautorizadoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ChequesPagosAutorizados chequespagosautorizados : chequespagosautorizadoss) {
			if(conAsignarBase && chequespagosautorizados.getConCambioAuxiliar()) {
				chequespagosautorizados.setIsDeleted(chequespagosautorizados.getIsDeletedAuxiliar());	
				chequespagosautorizados.setIsNew(chequespagosautorizados.getIsNewAuxiliar());	
				chequespagosautorizados.setIsChanged(chequespagosautorizados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				chequespagosautorizados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				chequespagosautorizados.setIsDeletedAuxiliar(false);	
				chequespagosautorizados.setIsNewAuxiliar(false);	
				chequespagosautorizados.setIsChangedAuxiliar(false);
				
				chequespagosautorizados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizados,Boolean conEnteros) throws Exception  {
		chequespagosautorizados.setdebito_mone_local(0.0);
		chequespagosautorizados.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresChequesPagosAutorizadoss(List<ChequesPagosAutorizados> chequespagosautorizadoss,Boolean conEnteros) throws Exception  {
		
		for(ChequesPagosAutorizados chequespagosautorizados: chequespagosautorizadoss) {
			chequespagosautorizados.setdebito_mone_local(0.0);
			chequespagosautorizados.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaChequesPagosAutorizados(List<ChequesPagosAutorizados> chequespagosautorizadoss,ChequesPagosAutorizados chequespagosautorizadosAux) throws Exception  {
		ChequesPagosAutorizadosConstantesFunciones.InicializarValoresChequesPagosAutorizados(chequespagosautorizadosAux,true);
		
		for(ChequesPagosAutorizados chequespagosautorizados: chequespagosautorizadoss) {
			if(chequespagosautorizados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			chequespagosautorizadosAux.setdebito_mone_local(chequespagosautorizadosAux.getdebito_mone_local()+chequespagosautorizados.getdebito_mone_local());			
			chequespagosautorizadosAux.setvalor(chequespagosautorizadosAux.getvalor()+chequespagosautorizados.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesChequesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ChequesPagosAutorizadosConstantesFunciones.getArrayColumnasGlobalesChequesPagosAutorizados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesChequesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoChequesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ChequesPagosAutorizados> chequespagosautorizadoss,ChequesPagosAutorizados chequespagosautorizados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ChequesPagosAutorizados chequespagosautorizadosAux: chequespagosautorizadoss) {
			if(chequespagosautorizadosAux!=null && chequespagosautorizados!=null) {
				if((chequespagosautorizadosAux.getId()==null && chequespagosautorizados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(chequespagosautorizadosAux.getId()!=null && chequespagosautorizados.getId()!=null){
					if(chequespagosautorizadosAux.getId().equals(chequespagosautorizados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaChequesPagosAutorizados(List<ChequesPagosAutorizados> chequespagosautorizadoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double valorTotal=0.0;
	
		for(ChequesPagosAutorizados chequespagosautorizados: chequespagosautorizadoss) {			
			if(chequespagosautorizados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=chequespagosautorizados.getdebito_mone_local();
			valorTotal+=chequespagosautorizados.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaChequesPagosAutorizados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_ID, ChequesPagosAutorizadosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_VERSIONROW, ChequesPagosAutorizadosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE, ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA, ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL, ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHA, ChequesPagosAutorizadosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO, ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR, ChequesPagosAutorizadosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCHEQUE, ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA, ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasChequesPagosAutorizados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarChequesPagosAutorizados() throws Exception  {
		return ChequesPagosAutorizadosConstantesFunciones.getTiposSeleccionarChequesPagosAutorizados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarChequesPagosAutorizados(Boolean conFk) throws Exception  {
		return ChequesPagosAutorizadosConstantesFunciones.getTiposSeleccionarChequesPagosAutorizados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarChequesPagosAutorizados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesChequesPagosAutorizados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizadosAux) throws Exception {
		
			chequespagosautorizadosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(chequespagosautorizadosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesChequesPagosAutorizados(List<ChequesPagosAutorizados> chequespagosautorizadossTemp) throws Exception {
		for(ChequesPagosAutorizados chequespagosautorizadosAux:chequespagosautorizadossTemp) {
			
			chequespagosautorizadosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(chequespagosautorizadosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfChequesPagosAutorizados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfChequesPagosAutorizados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfChequesPagosAutorizados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ChequesPagosAutorizadosConstantesFunciones.getClassesRelationshipsOfChequesPagosAutorizados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfChequesPagosAutorizados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfChequesPagosAutorizados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ChequesPagosAutorizadosConstantesFunciones.getClassesRelationshipsFromStringsOfChequesPagosAutorizados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfChequesPagosAutorizados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ChequesPagosAutorizados chequespagosautorizados,List<ChequesPagosAutorizados> chequespagosautorizadoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ChequesPagosAutorizados chequespagosautorizados,List<ChequesPagosAutorizados> chequespagosautorizadoss) throws Exception {
		try	{			
			for(ChequesPagosAutorizados chequespagosautorizadosLocal:chequespagosautorizadoss) {
				if(chequespagosautorizadosLocal.getId().equals(chequespagosautorizados.getId())) {
					chequespagosautorizadosLocal.setIsSelected(chequespagosautorizados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesChequesPagosAutorizados(List<ChequesPagosAutorizados> chequespagosautorizadossAux) throws Exception {
		//this.chequespagosautorizadossAux=chequespagosautorizadossAux;
		
		for(ChequesPagosAutorizados chequespagosautorizadosAux:chequespagosautorizadossAux) {
			if(chequespagosautorizadosAux.getIsChanged()) {
				chequespagosautorizadosAux.setIsChanged(false);
			}		
			
			if(chequespagosautorizadosAux.getIsNew()) {
				chequespagosautorizadosAux.setIsNew(false);
			}	
			
			if(chequespagosautorizadosAux.getIsDeleted()) {
				chequespagosautorizadosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizadosAux) throws Exception {
		//this.chequespagosautorizadosAux=chequespagosautorizadosAux;
		
			if(chequespagosautorizadosAux.getIsChanged()) {
				chequespagosautorizadosAux.setIsChanged(false);
			}		
			
			if(chequespagosautorizadosAux.getIsNew()) {
				chequespagosautorizadosAux.setIsNew(false);
			}	
			
			if(chequespagosautorizadosAux.getIsDeleted()) {
				chequespagosautorizadosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ChequesPagosAutorizados chequespagosautorizadosAsignar,ChequesPagosAutorizados chequespagosautorizados) throws Exception {
		chequespagosautorizadosAsignar.setId(chequespagosautorizados.getId());	
		chequespagosautorizadosAsignar.setVersionRow(chequespagosautorizados.getVersionRow());	
		chequespagosautorizadosAsignar.setnombre_cliente(chequespagosautorizados.getnombre_cliente());	
		chequespagosautorizadosAsignar.setnumero_factura(chequespagosautorizados.getnumero_factura());	
		chequespagosautorizadosAsignar.setdebito_mone_local(chequespagosautorizados.getdebito_mone_local());	
		chequespagosautorizadosAsignar.setfecha(chequespagosautorizados.getfecha());	
		chequespagosautorizadosAsignar.setnombre_banco(chequespagosautorizados.getnombre_banco());	
		chequespagosautorizadosAsignar.setvalor(chequespagosautorizados.getvalor());	
		chequespagosautorizadosAsignar.setnumero_cheque(chequespagosautorizados.getnumero_cheque());	
		chequespagosautorizadosAsignar.setnumero_cuenta(chequespagosautorizados.getnumero_cuenta());	
	}
	
	public static void inicializarChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizados) throws Exception {
		try {
				chequespagosautorizados.setId(0L);	
					
				chequespagosautorizados.setnombre_cliente("");	
				chequespagosautorizados.setnumero_factura("");	
				chequespagosautorizados.setdebito_mone_local(0.0);	
				chequespagosautorizados.setfecha(new Date());	
				chequespagosautorizados.setnombre_banco("");	
				chequespagosautorizados.setvalor(0.0);	
				chequespagosautorizados.setnumero_cheque("");	
				chequespagosautorizados.setnumero_cuenta("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderChequesPagosAutorizados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ChequesPagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataChequesPagosAutorizados(String sTipo,Row row,Workbook workbook,ChequesPagosAutorizados chequespagosautorizados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(chequespagosautorizados.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryChequesPagosAutorizados="";
	
	public String getsFinalQueryChequesPagosAutorizados() {
		return this.sFinalQueryChequesPagosAutorizados;
	}
	
	public void setsFinalQueryChequesPagosAutorizados(String sFinalQueryChequesPagosAutorizados) {
		this.sFinalQueryChequesPagosAutorizados= sFinalQueryChequesPagosAutorizados;
	}
	
	public Border resaltarSeleccionarChequesPagosAutorizados=null;
	
	public Border setResaltarSeleccionarChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarChequesPagosAutorizados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarChequesPagosAutorizados() {
		return this.resaltarSeleccionarChequesPagosAutorizados;
	}
	
	public void setResaltarSeleccionarChequesPagosAutorizados(Border borderResaltarSeleccionarChequesPagosAutorizados) {
		this.resaltarSeleccionarChequesPagosAutorizados= borderResaltarSeleccionarChequesPagosAutorizados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridChequesPagosAutorizados=null;
	public Boolean mostraridChequesPagosAutorizados=true;
	public Boolean activaridChequesPagosAutorizados=true;

	public Border resaltarid_empresaChequesPagosAutorizados=null;
	public Boolean mostrarid_empresaChequesPagosAutorizados=true;
	public Boolean activarid_empresaChequesPagosAutorizados=true;
	public Boolean cargarid_empresaChequesPagosAutorizados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaChequesPagosAutorizados=false;//ConEventDepend=true

	public Border resaltarfecha_desdeChequesPagosAutorizados=null;
	public Boolean mostrarfecha_desdeChequesPagosAutorizados=true;
	public Boolean activarfecha_desdeChequesPagosAutorizados=true;

	public Border resaltarfecha_hastaChequesPagosAutorizados=null;
	public Boolean mostrarfecha_hastaChequesPagosAutorizados=true;
	public Boolean activarfecha_hastaChequesPagosAutorizados=true;

	public Border resaltarnombre_clienteChequesPagosAutorizados=null;
	public Boolean mostrarnombre_clienteChequesPagosAutorizados=true;
	public Boolean activarnombre_clienteChequesPagosAutorizados=true;

	public Border resaltarnumero_facturaChequesPagosAutorizados=null;
	public Boolean mostrarnumero_facturaChequesPagosAutorizados=true;
	public Boolean activarnumero_facturaChequesPagosAutorizados=true;

	public Border resaltardebito_mone_localChequesPagosAutorizados=null;
	public Boolean mostrardebito_mone_localChequesPagosAutorizados=true;
	public Boolean activardebito_mone_localChequesPagosAutorizados=true;

	public Border resaltarfechaChequesPagosAutorizados=null;
	public Boolean mostrarfechaChequesPagosAutorizados=true;
	public Boolean activarfechaChequesPagosAutorizados=true;

	public Border resaltarnombre_bancoChequesPagosAutorizados=null;
	public Boolean mostrarnombre_bancoChequesPagosAutorizados=true;
	public Boolean activarnombre_bancoChequesPagosAutorizados=true;

	public Border resaltarvalorChequesPagosAutorizados=null;
	public Boolean mostrarvalorChequesPagosAutorizados=true;
	public Boolean activarvalorChequesPagosAutorizados=true;

	public Border resaltarnumero_chequeChequesPagosAutorizados=null;
	public Boolean mostrarnumero_chequeChequesPagosAutorizados=true;
	public Boolean activarnumero_chequeChequesPagosAutorizados=true;

	public Border resaltarnumero_cuentaChequesPagosAutorizados=null;
	public Boolean mostrarnumero_cuentaChequesPagosAutorizados=true;
	public Boolean activarnumero_cuentaChequesPagosAutorizados=true;

	
	

	public Border setResaltaridChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltaridChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridChequesPagosAutorizados() {
		return this.resaltaridChequesPagosAutorizados;
	}

	public void setResaltaridChequesPagosAutorizados(Border borderResaltar) {
		this.resaltaridChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostraridChequesPagosAutorizados() {
		return this.mostraridChequesPagosAutorizados;
	}

	public void setMostraridChequesPagosAutorizados(Boolean mostraridChequesPagosAutorizados) {
		this.mostraridChequesPagosAutorizados= mostraridChequesPagosAutorizados;
	}

	public Boolean getActivaridChequesPagosAutorizados() {
		return this.activaridChequesPagosAutorizados;
	}

	public void setActivaridChequesPagosAutorizados(Boolean activaridChequesPagosAutorizados) {
		this.activaridChequesPagosAutorizados= activaridChequesPagosAutorizados;
	}

	public Border setResaltarid_empresaChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarid_empresaChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaChequesPagosAutorizados() {
		return this.resaltarid_empresaChequesPagosAutorizados;
	}

	public void setResaltarid_empresaChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarid_empresaChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarid_empresaChequesPagosAutorizados() {
		return this.mostrarid_empresaChequesPagosAutorizados;
	}

	public void setMostrarid_empresaChequesPagosAutorizados(Boolean mostrarid_empresaChequesPagosAutorizados) {
		this.mostrarid_empresaChequesPagosAutorizados= mostrarid_empresaChequesPagosAutorizados;
	}

	public Boolean getActivarid_empresaChequesPagosAutorizados() {
		return this.activarid_empresaChequesPagosAutorizados;
	}

	public void setActivarid_empresaChequesPagosAutorizados(Boolean activarid_empresaChequesPagosAutorizados) {
		this.activarid_empresaChequesPagosAutorizados= activarid_empresaChequesPagosAutorizados;
	}

	public Boolean getCargarid_empresaChequesPagosAutorizados() {
		return this.cargarid_empresaChequesPagosAutorizados;
	}

	public void setCargarid_empresaChequesPagosAutorizados(Boolean cargarid_empresaChequesPagosAutorizados) {
		this.cargarid_empresaChequesPagosAutorizados= cargarid_empresaChequesPagosAutorizados;
	}

	public Border setResaltarfecha_desdeChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeChequesPagosAutorizados() {
		return this.resaltarfecha_desdeChequesPagosAutorizados;
	}

	public void setResaltarfecha_desdeChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarfecha_desdeChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeChequesPagosAutorizados() {
		return this.mostrarfecha_desdeChequesPagosAutorizados;
	}

	public void setMostrarfecha_desdeChequesPagosAutorizados(Boolean mostrarfecha_desdeChequesPagosAutorizados) {
		this.mostrarfecha_desdeChequesPagosAutorizados= mostrarfecha_desdeChequesPagosAutorizados;
	}

	public Boolean getActivarfecha_desdeChequesPagosAutorizados() {
		return this.activarfecha_desdeChequesPagosAutorizados;
	}

	public void setActivarfecha_desdeChequesPagosAutorizados(Boolean activarfecha_desdeChequesPagosAutorizados) {
		this.activarfecha_desdeChequesPagosAutorizados= activarfecha_desdeChequesPagosAutorizados;
	}

	public Border setResaltarfecha_hastaChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaChequesPagosAutorizados() {
		return this.resaltarfecha_hastaChequesPagosAutorizados;
	}

	public void setResaltarfecha_hastaChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarfecha_hastaChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaChequesPagosAutorizados() {
		return this.mostrarfecha_hastaChequesPagosAutorizados;
	}

	public void setMostrarfecha_hastaChequesPagosAutorizados(Boolean mostrarfecha_hastaChequesPagosAutorizados) {
		this.mostrarfecha_hastaChequesPagosAutorizados= mostrarfecha_hastaChequesPagosAutorizados;
	}

	public Boolean getActivarfecha_hastaChequesPagosAutorizados() {
		return this.activarfecha_hastaChequesPagosAutorizados;
	}

	public void setActivarfecha_hastaChequesPagosAutorizados(Boolean activarfecha_hastaChequesPagosAutorizados) {
		this.activarfecha_hastaChequesPagosAutorizados= activarfecha_hastaChequesPagosAutorizados;
	}

	public Border setResaltarnombre_clienteChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteChequesPagosAutorizados() {
		return this.resaltarnombre_clienteChequesPagosAutorizados;
	}

	public void setResaltarnombre_clienteChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarnombre_clienteChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteChequesPagosAutorizados() {
		return this.mostrarnombre_clienteChequesPagosAutorizados;
	}

	public void setMostrarnombre_clienteChequesPagosAutorizados(Boolean mostrarnombre_clienteChequesPagosAutorizados) {
		this.mostrarnombre_clienteChequesPagosAutorizados= mostrarnombre_clienteChequesPagosAutorizados;
	}

	public Boolean getActivarnombre_clienteChequesPagosAutorizados() {
		return this.activarnombre_clienteChequesPagosAutorizados;
	}

	public void setActivarnombre_clienteChequesPagosAutorizados(Boolean activarnombre_clienteChequesPagosAutorizados) {
		this.activarnombre_clienteChequesPagosAutorizados= activarnombre_clienteChequesPagosAutorizados;
	}

	public Border setResaltarnumero_facturaChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaChequesPagosAutorizados() {
		return this.resaltarnumero_facturaChequesPagosAutorizados;
	}

	public void setResaltarnumero_facturaChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarnumero_facturaChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaChequesPagosAutorizados() {
		return this.mostrarnumero_facturaChequesPagosAutorizados;
	}

	public void setMostrarnumero_facturaChequesPagosAutorizados(Boolean mostrarnumero_facturaChequesPagosAutorizados) {
		this.mostrarnumero_facturaChequesPagosAutorizados= mostrarnumero_facturaChequesPagosAutorizados;
	}

	public Boolean getActivarnumero_facturaChequesPagosAutorizados() {
		return this.activarnumero_facturaChequesPagosAutorizados;
	}

	public void setActivarnumero_facturaChequesPagosAutorizados(Boolean activarnumero_facturaChequesPagosAutorizados) {
		this.activarnumero_facturaChequesPagosAutorizados= activarnumero_facturaChequesPagosAutorizados;
	}

	public Border setResaltardebito_mone_localChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localChequesPagosAutorizados() {
		return this.resaltardebito_mone_localChequesPagosAutorizados;
	}

	public void setResaltardebito_mone_localChequesPagosAutorizados(Border borderResaltar) {
		this.resaltardebito_mone_localChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localChequesPagosAutorizados() {
		return this.mostrardebito_mone_localChequesPagosAutorizados;
	}

	public void setMostrardebito_mone_localChequesPagosAutorizados(Boolean mostrardebito_mone_localChequesPagosAutorizados) {
		this.mostrardebito_mone_localChequesPagosAutorizados= mostrardebito_mone_localChequesPagosAutorizados;
	}

	public Boolean getActivardebito_mone_localChequesPagosAutorizados() {
		return this.activardebito_mone_localChequesPagosAutorizados;
	}

	public void setActivardebito_mone_localChequesPagosAutorizados(Boolean activardebito_mone_localChequesPagosAutorizados) {
		this.activardebito_mone_localChequesPagosAutorizados= activardebito_mone_localChequesPagosAutorizados;
	}

	public Border setResaltarfechaChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfechaChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaChequesPagosAutorizados() {
		return this.resaltarfechaChequesPagosAutorizados;
	}

	public void setResaltarfechaChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarfechaChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfechaChequesPagosAutorizados() {
		return this.mostrarfechaChequesPagosAutorizados;
	}

	public void setMostrarfechaChequesPagosAutorizados(Boolean mostrarfechaChequesPagosAutorizados) {
		this.mostrarfechaChequesPagosAutorizados= mostrarfechaChequesPagosAutorizados;
	}

	public Boolean getActivarfechaChequesPagosAutorizados() {
		return this.activarfechaChequesPagosAutorizados;
	}

	public void setActivarfechaChequesPagosAutorizados(Boolean activarfechaChequesPagosAutorizados) {
		this.activarfechaChequesPagosAutorizados= activarfechaChequesPagosAutorizados;
	}

	public Border setResaltarnombre_bancoChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoChequesPagosAutorizados() {
		return this.resaltarnombre_bancoChequesPagosAutorizados;
	}

	public void setResaltarnombre_bancoChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarnombre_bancoChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoChequesPagosAutorizados() {
		return this.mostrarnombre_bancoChequesPagosAutorizados;
	}

	public void setMostrarnombre_bancoChequesPagosAutorizados(Boolean mostrarnombre_bancoChequesPagosAutorizados) {
		this.mostrarnombre_bancoChequesPagosAutorizados= mostrarnombre_bancoChequesPagosAutorizados;
	}

	public Boolean getActivarnombre_bancoChequesPagosAutorizados() {
		return this.activarnombre_bancoChequesPagosAutorizados;
	}

	public void setActivarnombre_bancoChequesPagosAutorizados(Boolean activarnombre_bancoChequesPagosAutorizados) {
		this.activarnombre_bancoChequesPagosAutorizados= activarnombre_bancoChequesPagosAutorizados;
	}

	public Border setResaltarvalorChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarvalorChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorChequesPagosAutorizados() {
		return this.resaltarvalorChequesPagosAutorizados;
	}

	public void setResaltarvalorChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarvalorChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarvalorChequesPagosAutorizados() {
		return this.mostrarvalorChequesPagosAutorizados;
	}

	public void setMostrarvalorChequesPagosAutorizados(Boolean mostrarvalorChequesPagosAutorizados) {
		this.mostrarvalorChequesPagosAutorizados= mostrarvalorChequesPagosAutorizados;
	}

	public Boolean getActivarvalorChequesPagosAutorizados() {
		return this.activarvalorChequesPagosAutorizados;
	}

	public void setActivarvalorChequesPagosAutorizados(Boolean activarvalorChequesPagosAutorizados) {
		this.activarvalorChequesPagosAutorizados= activarvalorChequesPagosAutorizados;
	}

	public Border setResaltarnumero_chequeChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeChequesPagosAutorizados() {
		return this.resaltarnumero_chequeChequesPagosAutorizados;
	}

	public void setResaltarnumero_chequeChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarnumero_chequeChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeChequesPagosAutorizados() {
		return this.mostrarnumero_chequeChequesPagosAutorizados;
	}

	public void setMostrarnumero_chequeChequesPagosAutorizados(Boolean mostrarnumero_chequeChequesPagosAutorizados) {
		this.mostrarnumero_chequeChequesPagosAutorizados= mostrarnumero_chequeChequesPagosAutorizados;
	}

	public Boolean getActivarnumero_chequeChequesPagosAutorizados() {
		return this.activarnumero_chequeChequesPagosAutorizados;
	}

	public void setActivarnumero_chequeChequesPagosAutorizados(Boolean activarnumero_chequeChequesPagosAutorizados) {
		this.activarnumero_chequeChequesPagosAutorizados= activarnumero_chequeChequesPagosAutorizados;
	}

	public Border setResaltarnumero_cuentaChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//chequespagosautorizadosBeanSwingJInternalFrame.jTtoolBarChequesPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaChequesPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaChequesPagosAutorizados() {
		return this.resaltarnumero_cuentaChequesPagosAutorizados;
	}

	public void setResaltarnumero_cuentaChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarnumero_cuentaChequesPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaChequesPagosAutorizados() {
		return this.mostrarnumero_cuentaChequesPagosAutorizados;
	}

	public void setMostrarnumero_cuentaChequesPagosAutorizados(Boolean mostrarnumero_cuentaChequesPagosAutorizados) {
		this.mostrarnumero_cuentaChequesPagosAutorizados= mostrarnumero_cuentaChequesPagosAutorizados;
	}

	public Boolean getActivarnumero_cuentaChequesPagosAutorizados() {
		return this.activarnumero_cuentaChequesPagosAutorizados;
	}

	public void setActivarnumero_cuentaChequesPagosAutorizados(Boolean activarnumero_cuentaChequesPagosAutorizados) {
		this.activarnumero_cuentaChequesPagosAutorizados= activarnumero_cuentaChequesPagosAutorizados;
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
		
		
		this.setMostraridChequesPagosAutorizados(esInicial);
		this.setMostrarid_empresaChequesPagosAutorizados(esInicial);
		this.setMostrarfecha_desdeChequesPagosAutorizados(esInicial);
		this.setMostrarfecha_hastaChequesPagosAutorizados(esInicial);
		this.setMostrarnombre_clienteChequesPagosAutorizados(esInicial);
		this.setMostrarnumero_facturaChequesPagosAutorizados(esInicial);
		this.setMostrardebito_mone_localChequesPagosAutorizados(esInicial);
		this.setMostrarfechaChequesPagosAutorizados(esInicial);
		this.setMostrarnombre_bancoChequesPagosAutorizados(esInicial);
		this.setMostrarvalorChequesPagosAutorizados(esInicial);
		this.setMostrarnumero_chequeChequesPagosAutorizados(esInicial);
		this.setMostrarnumero_cuentaChequesPagosAutorizados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.ID)) {
				this.setMostraridChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHA)) {
				this.setMostrarfechaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.VALOR)) {
				this.setMostrarvalorChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaChequesPagosAutorizados(esAsigna);
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
		
		
		this.setActivaridChequesPagosAutorizados(esInicial);
		this.setActivarid_empresaChequesPagosAutorizados(esInicial);
		this.setActivarfecha_desdeChequesPagosAutorizados(esInicial);
		this.setActivarfecha_hastaChequesPagosAutorizados(esInicial);
		this.setActivarnombre_clienteChequesPagosAutorizados(esInicial);
		this.setActivarnumero_facturaChequesPagosAutorizados(esInicial);
		this.setActivardebito_mone_localChequesPagosAutorizados(esInicial);
		this.setActivarfechaChequesPagosAutorizados(esInicial);
		this.setActivarnombre_bancoChequesPagosAutorizados(esInicial);
		this.setActivarvalorChequesPagosAutorizados(esInicial);
		this.setActivarnumero_chequeChequesPagosAutorizados(esInicial);
		this.setActivarnumero_cuentaChequesPagosAutorizados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.ID)) {
				this.setActivaridChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHA)) {
				this.setActivarfechaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.VALOR)) {
				this.setActivarvalorChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaChequesPagosAutorizados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridChequesPagosAutorizados(esInicial);
		this.setResaltarid_empresaChequesPagosAutorizados(esInicial);
		this.setResaltarfecha_desdeChequesPagosAutorizados(esInicial);
		this.setResaltarfecha_hastaChequesPagosAutorizados(esInicial);
		this.setResaltarnombre_clienteChequesPagosAutorizados(esInicial);
		this.setResaltarnumero_facturaChequesPagosAutorizados(esInicial);
		this.setResaltardebito_mone_localChequesPagosAutorizados(esInicial);
		this.setResaltarfechaChequesPagosAutorizados(esInicial);
		this.setResaltarnombre_bancoChequesPagosAutorizados(esInicial);
		this.setResaltarvalorChequesPagosAutorizados(esInicial);
		this.setResaltarnumero_chequeChequesPagosAutorizados(esInicial);
		this.setResaltarnumero_cuentaChequesPagosAutorizados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.ID)) {
				this.setResaltaridChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.FECHA)) {
				this.setResaltarfechaChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.VALOR)) {
				this.setResaltarvalorChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeChequesPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(ChequesPagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaChequesPagosAutorizados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaChequesPagosAutorizadosChequesPagosAutorizados=true;

	public Boolean getMostrarBusquedaChequesPagosAutorizadosChequesPagosAutorizados() {
		return this.mostrarBusquedaChequesPagosAutorizadosChequesPagosAutorizados;
	}

	public void setMostrarBusquedaChequesPagosAutorizadosChequesPagosAutorizados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaChequesPagosAutorizadosChequesPagosAutorizados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaChequesPagosAutorizadosChequesPagosAutorizados=true;

	public Boolean getActivarBusquedaChequesPagosAutorizadosChequesPagosAutorizados() {
		return this.activarBusquedaChequesPagosAutorizadosChequesPagosAutorizados;
	}

	public void setActivarBusquedaChequesPagosAutorizadosChequesPagosAutorizados(Boolean habilitarResaltar) {
		this.activarBusquedaChequesPagosAutorizadosChequesPagosAutorizados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados=null;

	public Border getResaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados() {
		return this.resaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados;
	}

	public void setResaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados(Border borderResaltar) {
		this.resaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados= borderResaltar;
	}

	public void setResaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*ChequesPagosAutorizadosBeanSwingJInternalFrame chequespagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaChequesPagosAutorizadosChequesPagosAutorizados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}