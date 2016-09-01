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


import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SaldosDiariosBancosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SaldosDiariosBancos";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SaldosDiariosBancos"+SaldosDiariosBancosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SaldosDiariosBancosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SaldosDiariosBancosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SaldosDiariosBancosConstantesFunciones.SCHEMA+"_"+SaldosDiariosBancosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SaldosDiariosBancosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SaldosDiariosBancosConstantesFunciones.SCHEMA+"_"+SaldosDiariosBancosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SaldosDiariosBancosConstantesFunciones.SCHEMA+"_"+SaldosDiariosBancosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SaldosDiariosBancosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SaldosDiariosBancosConstantesFunciones.SCHEMA+"_"+SaldosDiariosBancosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosDiariosBancosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldosDiariosBancosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosDiariosBancosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosDiariosBancosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldosDiariosBancosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosDiariosBancosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SaldosDiariosBancosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SaldosDiariosBancosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SaldosDiariosBancosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SaldosDiariosBancosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Saldos Diarios Bancoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Saldos Diarios Bancos";
	public static final String SCLASSWEBTITULO_LOWER="Saldos Diarios Bancos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SaldosDiariosBancos";
	public static final String OBJECTNAME="saldosdiariosbancos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="saldos_diarios_bancos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select saldosdiariosbancos from "+SaldosDiariosBancosConstantesFunciones.SPERSISTENCENAME+" saldosdiariosbancos";
	public static String QUERYSELECTNATIVE="select "+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".id,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".version_row,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".id_empresa,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".id_ejercicio,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".fecha_desde,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".fecha_hasta,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".codigo_cuenta,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".nombre_banco,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".numero_cuenta,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".nombre_moneda,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".saldo_anterior,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".deposito,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".nc,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".ch_girados,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".nd,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".procedencia,"+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME+".destino from "+SaldosDiariosBancosConstantesFunciones.SCHEMA+"."+SaldosDiariosBancosConstantesFunciones.TABLENAME;//+" as "+SaldosDiariosBancosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGOCUENTA= "codigo_cuenta";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NOMBREMONEDA= "nombre_moneda";
    public static final String SALDOANTERIOR= "saldo_anterior";
    public static final String DEPOSITO= "deposito";
    public static final String NC= "nc";
    public static final String CHGIRADOS= "ch_girados";
    public static final String ND= "nd";
    public static final String PROCEDENCIA= "procedencia";
    public static final String DESTINO= "destino";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGOCUENTA= "Codigo Cuenta";
		public static final String LABEL_CODIGOCUENTA_LOWER= "Codigo Cuenta";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NOMBREMONEDA= "Nombre Moneda";
		public static final String LABEL_NOMBREMONEDA_LOWER= "Nombre Moneda";
    	public static final String LABEL_SALDOANTERIOR= "Saldo Anterior";
		public static final String LABEL_SALDOANTERIOR_LOWER= "Saldo Anterior";
    	public static final String LABEL_DEPOSITO= "Deposito";
		public static final String LABEL_DEPOSITO_LOWER= "Deposito";
    	public static final String LABEL_NC= "Nc";
		public static final String LABEL_NC_LOWER= "Nc";
    	public static final String LABEL_CHGIRADOS= "Ch Girados";
		public static final String LABEL_CHGIRADOS_LOWER= "Ch Girados";
    	public static final String LABEL_ND= "Nd";
		public static final String LABEL_ND_LOWER= "Nd";
    	public static final String LABEL_PROCEDENCIA= "Procedencia";
		public static final String LABEL_PROCEDENCIA_LOWER= "Procedencia";
    	public static final String LABEL_DESTINO= "Destino";
		public static final String LABEL_DESTINO_LOWER= "Destino";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MONEDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MONEDA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXPROCEDENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPROCEDENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSaldosDiariosBancosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.IDEMPRESA)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.FECHADESDE)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.FECHAHASTA)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_CODIGOCUENTA;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.NOMBREBANCO)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREMONEDA;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.DEPOSITO)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.NC)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_NC;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.CHGIRADOS)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.ND)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_ND;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.PROCEDENCIA)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_PROCEDENCIA;}
		if(sNombreColumna.equals(SaldosDiariosBancosConstantesFunciones.DESTINO)) {sLabelColumna=SaldosDiariosBancosConstantesFunciones.LABEL_DESTINO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSaldosDiariosBancosDescripcion(SaldosDiariosBancos saldosdiariosbancos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(saldosdiariosbancos !=null/* && saldosdiariosbancos.getId()!=0*/) {
			sDescripcion=saldosdiariosbancos.getfecha_desde().toString();//saldosdiariosbancossaldosdiariosbancos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSaldosDiariosBancosDescripcionDetallado(SaldosDiariosBancos saldosdiariosbancos) {
		String sDescripcion="";
			
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.ID+"=";
		sDescripcion+=saldosdiariosbancos.getId().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=saldosdiariosbancos.getVersionRow().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=saldosdiariosbancos.getid_empresa().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=saldosdiariosbancos.getid_ejercicio().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=saldosdiariosbancos.getfecha_desde().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=saldosdiariosbancos.getfecha_hasta().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA+"=";
		sDescripcion+=saldosdiariosbancos.getcodigo_cuenta()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=saldosdiariosbancos.getnombre_banco()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=saldosdiariosbancos.getnumero_cuenta()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA+"=";
		sDescripcion+=saldosdiariosbancos.getnombre_moneda()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR+"=";
		sDescripcion+=saldosdiariosbancos.getsaldo_anterior().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.DEPOSITO+"=";
		sDescripcion+=saldosdiariosbancos.getdeposito().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.NC+"=";
		sDescripcion+=saldosdiariosbancos.getnc().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.CHGIRADOS+"=";
		sDescripcion+=saldosdiariosbancos.getch_girados().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.ND+"=";
		sDescripcion+=saldosdiariosbancos.getnd().toString()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.PROCEDENCIA+"=";
		sDescripcion+=saldosdiariosbancos.getprocedencia()+",";
		sDescripcion+=SaldosDiariosBancosConstantesFunciones.DESTINO+"=";
		sDescripcion+=saldosdiariosbancos.getdestino()+",";
			
		return sDescripcion;
	}
	
	public static void setSaldosDiariosBancosDescripcion(SaldosDiariosBancos saldosdiariosbancos,String sValor) throws Exception {			
		if(saldosdiariosbancos !=null) {
			//saldosdiariosbancossaldosdiariosbancos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaSaldosDiariosBancos")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaSaldosDiariosBancos(Long id_ejercicio,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		saldosdiariosbancos.setcodigo_cuenta(saldosdiariosbancos.getcodigo_cuenta().trim());
		saldosdiariosbancos.setnombre_banco(saldosdiariosbancos.getnombre_banco().trim());
		saldosdiariosbancos.setnumero_cuenta(saldosdiariosbancos.getnumero_cuenta().trim());
		saldosdiariosbancos.setnombre_moneda(saldosdiariosbancos.getnombre_moneda().trim());
		saldosdiariosbancos.setprocedencia(saldosdiariosbancos.getprocedencia().trim());
		saldosdiariosbancos.setdestino(saldosdiariosbancos.getdestino().trim());
	}
	
	public static void quitarEspaciosSaldosDiariosBancoss(List<SaldosDiariosBancos> saldosdiariosbancoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldosDiariosBancos saldosdiariosbancos: saldosdiariosbancoss) {
			saldosdiariosbancos.setcodigo_cuenta(saldosdiariosbancos.getcodigo_cuenta().trim());
			saldosdiariosbancos.setnombre_banco(saldosdiariosbancos.getnombre_banco().trim());
			saldosdiariosbancos.setnumero_cuenta(saldosdiariosbancos.getnumero_cuenta().trim());
			saldosdiariosbancos.setnombre_moneda(saldosdiariosbancos.getnombre_moneda().trim());
			saldosdiariosbancos.setprocedencia(saldosdiariosbancos.getprocedencia().trim());
			saldosdiariosbancos.setdestino(saldosdiariosbancos.getdestino().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && saldosdiariosbancos.getConCambioAuxiliar()) {
			saldosdiariosbancos.setIsDeleted(saldosdiariosbancos.getIsDeletedAuxiliar());	
			saldosdiariosbancos.setIsNew(saldosdiariosbancos.getIsNewAuxiliar());	
			saldosdiariosbancos.setIsChanged(saldosdiariosbancos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			saldosdiariosbancos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			saldosdiariosbancos.setIsDeletedAuxiliar(false);	
			saldosdiariosbancos.setIsNewAuxiliar(false);	
			saldosdiariosbancos.setIsChangedAuxiliar(false);
			
			saldosdiariosbancos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldosDiariosBancoss(List<SaldosDiariosBancos> saldosdiariosbancoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SaldosDiariosBancos saldosdiariosbancos : saldosdiariosbancoss) {
			if(conAsignarBase && saldosdiariosbancos.getConCambioAuxiliar()) {
				saldosdiariosbancos.setIsDeleted(saldosdiariosbancos.getIsDeletedAuxiliar());	
				saldosdiariosbancos.setIsNew(saldosdiariosbancos.getIsNewAuxiliar());	
				saldosdiariosbancos.setIsChanged(saldosdiariosbancos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				saldosdiariosbancos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				saldosdiariosbancos.setIsDeletedAuxiliar(false);	
				saldosdiariosbancos.setIsNewAuxiliar(false);	
				saldosdiariosbancos.setIsChangedAuxiliar(false);
				
				saldosdiariosbancos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancos,Boolean conEnteros) throws Exception  {
		saldosdiariosbancos.setsaldo_anterior(0.0);
		saldosdiariosbancos.setdeposito(0.0);
		saldosdiariosbancos.setnc(0.0);
		saldosdiariosbancos.setch_girados(0.0);
		saldosdiariosbancos.setnd(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSaldosDiariosBancoss(List<SaldosDiariosBancos> saldosdiariosbancoss,Boolean conEnteros) throws Exception  {
		
		for(SaldosDiariosBancos saldosdiariosbancos: saldosdiariosbancoss) {
			saldosdiariosbancos.setsaldo_anterior(0.0);
			saldosdiariosbancos.setdeposito(0.0);
			saldosdiariosbancos.setnc(0.0);
			saldosdiariosbancos.setch_girados(0.0);
			saldosdiariosbancos.setnd(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSaldosDiariosBancos(List<SaldosDiariosBancos> saldosdiariosbancoss,SaldosDiariosBancos saldosdiariosbancosAux) throws Exception  {
		SaldosDiariosBancosConstantesFunciones.InicializarValoresSaldosDiariosBancos(saldosdiariosbancosAux,true);
		
		for(SaldosDiariosBancos saldosdiariosbancos: saldosdiariosbancoss) {
			if(saldosdiariosbancos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldosdiariosbancosAux.setsaldo_anterior(saldosdiariosbancosAux.getsaldo_anterior()+saldosdiariosbancos.getsaldo_anterior());			
			saldosdiariosbancosAux.setdeposito(saldosdiariosbancosAux.getdeposito()+saldosdiariosbancos.getdeposito());			
			saldosdiariosbancosAux.setnc(saldosdiariosbancosAux.getnc()+saldosdiariosbancos.getnc());			
			saldosdiariosbancosAux.setch_girados(saldosdiariosbancosAux.getch_girados()+saldosdiariosbancos.getch_girados());			
			saldosdiariosbancosAux.setnd(saldosdiariosbancosAux.getnd()+saldosdiariosbancos.getnd());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosDiariosBancos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SaldosDiariosBancosConstantesFunciones.getArrayColumnasGlobalesSaldosDiariosBancos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosDiariosBancos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldosDiariosBancosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldosDiariosBancosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSaldosDiariosBancos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldosDiariosBancos> saldosdiariosbancoss,SaldosDiariosBancos saldosdiariosbancos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldosDiariosBancos saldosdiariosbancosAux: saldosdiariosbancoss) {
			if(saldosdiariosbancosAux!=null && saldosdiariosbancos!=null) {
				if((saldosdiariosbancosAux.getId()==null && saldosdiariosbancos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(saldosdiariosbancosAux.getId()!=null && saldosdiariosbancos.getId()!=null){
					if(saldosdiariosbancosAux.getId().equals(saldosdiariosbancos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldosDiariosBancos(List<SaldosDiariosBancos> saldosdiariosbancoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldo_anteriorTotal=0.0;
		Double depositoTotal=0.0;
		Double ncTotal=0.0;
		Double ch_giradosTotal=0.0;
		Double ndTotal=0.0;
	
		for(SaldosDiariosBancos saldosdiariosbancos: saldosdiariosbancoss) {			
			if(saldosdiariosbancos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldo_anteriorTotal+=saldosdiariosbancos.getsaldo_anterior();
			depositoTotal+=saldosdiariosbancos.getdeposito();
			ncTotal+=saldosdiariosbancos.getnc();
			ch_giradosTotal+=saldosdiariosbancos.getch_girados();
			ndTotal+=saldosdiariosbancos.getnd();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR);
		datoGeneral.setdValorDouble(saldo_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.DEPOSITO);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO);
		datoGeneral.setdValorDouble(depositoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.NC);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_NC);
		datoGeneral.setdValorDouble(ncTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.CHGIRADOS);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS);
		datoGeneral.setdValorDouble(ch_giradosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.ND);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_ND);
		datoGeneral.setdValorDouble(ndTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSaldosDiariosBancos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_ID, SaldosDiariosBancosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_VERSIONROW, SaldosDiariosBancosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_CODIGOCUENTA, SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREBANCO, SaldosDiariosBancosConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_NUMEROCUENTA, SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREMONEDA, SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR, SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO, SaldosDiariosBancosConstantesFunciones.DEPOSITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_NC, SaldosDiariosBancosConstantesFunciones.NC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS, SaldosDiariosBancosConstantesFunciones.CHGIRADOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_ND, SaldosDiariosBancosConstantesFunciones.ND,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_PROCEDENCIA, SaldosDiariosBancosConstantesFunciones.PROCEDENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosDiariosBancosConstantesFunciones.LABEL_DESTINO, SaldosDiariosBancosConstantesFunciones.DESTINO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSaldosDiariosBancos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.DEPOSITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.NC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.CHGIRADOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.ND;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.PROCEDENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosDiariosBancosConstantesFunciones.DESTINO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosDiariosBancos() throws Exception  {
		return SaldosDiariosBancosConstantesFunciones.getTiposSeleccionarSaldosDiariosBancos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosDiariosBancos(Boolean conFk) throws Exception  {
		return SaldosDiariosBancosConstantesFunciones.getTiposSeleccionarSaldosDiariosBancos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosDiariosBancos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_CODIGOCUENTA);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_CODIGOCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREMONEDA);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_NC);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_NC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_ND);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_ND);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_PROCEDENCIA);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_PROCEDENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosDiariosBancosConstantesFunciones.LABEL_DESTINO);
			reporte.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_DESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSaldosDiariosBancos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancosAux) throws Exception {
		
			saldosdiariosbancosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldosdiariosbancosAux.getEmpresa()));
			saldosdiariosbancosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(saldosdiariosbancosAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSaldosDiariosBancos(List<SaldosDiariosBancos> saldosdiariosbancossTemp) throws Exception {
		for(SaldosDiariosBancos saldosdiariosbancosAux:saldosdiariosbancossTemp) {
			
			saldosdiariosbancosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldosdiariosbancosAux.getEmpresa()));
			saldosdiariosbancosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(saldosdiariosbancosAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSaldosDiariosBancos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSaldosDiariosBancos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldosDiariosBancos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldosDiariosBancosConstantesFunciones.getClassesRelationshipsOfSaldosDiariosBancos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldosDiariosBancos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldosDiariosBancos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldosDiariosBancosConstantesFunciones.getClassesRelationshipsFromStringsOfSaldosDiariosBancos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldosDiariosBancos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SaldosDiariosBancos saldosdiariosbancos,List<SaldosDiariosBancos> saldosdiariosbancoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SaldosDiariosBancos saldosdiariosbancos,List<SaldosDiariosBancos> saldosdiariosbancoss) throws Exception {
		try	{			
			for(SaldosDiariosBancos saldosdiariosbancosLocal:saldosdiariosbancoss) {
				if(saldosdiariosbancosLocal.getId().equals(saldosdiariosbancos.getId())) {
					saldosdiariosbancosLocal.setIsSelected(saldosdiariosbancos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSaldosDiariosBancos(List<SaldosDiariosBancos> saldosdiariosbancossAux) throws Exception {
		//this.saldosdiariosbancossAux=saldosdiariosbancossAux;
		
		for(SaldosDiariosBancos saldosdiariosbancosAux:saldosdiariosbancossAux) {
			if(saldosdiariosbancosAux.getIsChanged()) {
				saldosdiariosbancosAux.setIsChanged(false);
			}		
			
			if(saldosdiariosbancosAux.getIsNew()) {
				saldosdiariosbancosAux.setIsNew(false);
			}	
			
			if(saldosdiariosbancosAux.getIsDeleted()) {
				saldosdiariosbancosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancosAux) throws Exception {
		//this.saldosdiariosbancosAux=saldosdiariosbancosAux;
		
			if(saldosdiariosbancosAux.getIsChanged()) {
				saldosdiariosbancosAux.setIsChanged(false);
			}		
			
			if(saldosdiariosbancosAux.getIsNew()) {
				saldosdiariosbancosAux.setIsNew(false);
			}	
			
			if(saldosdiariosbancosAux.getIsDeleted()) {
				saldosdiariosbancosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SaldosDiariosBancos saldosdiariosbancosAsignar,SaldosDiariosBancos saldosdiariosbancos) throws Exception {
		saldosdiariosbancosAsignar.setId(saldosdiariosbancos.getId());	
		saldosdiariosbancosAsignar.setVersionRow(saldosdiariosbancos.getVersionRow());	
		saldosdiariosbancosAsignar.setcodigo_cuenta(saldosdiariosbancos.getcodigo_cuenta());	
		saldosdiariosbancosAsignar.setnombre_banco(saldosdiariosbancos.getnombre_banco());	
		saldosdiariosbancosAsignar.setnumero_cuenta(saldosdiariosbancos.getnumero_cuenta());	
		saldosdiariosbancosAsignar.setnombre_moneda(saldosdiariosbancos.getnombre_moneda());	
		saldosdiariosbancosAsignar.setsaldo_anterior(saldosdiariosbancos.getsaldo_anterior());	
		saldosdiariosbancosAsignar.setdeposito(saldosdiariosbancos.getdeposito());	
		saldosdiariosbancosAsignar.setnc(saldosdiariosbancos.getnc());	
		saldosdiariosbancosAsignar.setch_girados(saldosdiariosbancos.getch_girados());	
		saldosdiariosbancosAsignar.setnd(saldosdiariosbancos.getnd());	
		saldosdiariosbancosAsignar.setprocedencia(saldosdiariosbancos.getprocedencia());	
		saldosdiariosbancosAsignar.setdestino(saldosdiariosbancos.getdestino());	
	}
	
	public static void inicializarSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancos) throws Exception {
		try {
				saldosdiariosbancos.setId(0L);	
					
				saldosdiariosbancos.setcodigo_cuenta("");	
				saldosdiariosbancos.setnombre_banco("");	
				saldosdiariosbancos.setnumero_cuenta("");	
				saldosdiariosbancos.setnombre_moneda("");	
				saldosdiariosbancos.setsaldo_anterior(0.0);	
				saldosdiariosbancos.setdeposito(0.0);	
				saldosdiariosbancos.setnc(0.0);	
				saldosdiariosbancos.setch_girados(0.0);	
				saldosdiariosbancos.setnd(0.0);	
				saldosdiariosbancos.setprocedencia("");	
				saldosdiariosbancos.setdestino("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSaldosDiariosBancos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_CODIGOCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_NOMBREMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_NC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_ND);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_PROCEDENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosDiariosBancosConstantesFunciones.LABEL_DESTINO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSaldosDiariosBancos(String sTipo,Row row,Workbook workbook,SaldosDiariosBancos saldosdiariosbancos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getcodigo_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getnombre_moneda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getsaldo_anterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getdeposito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getnc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getch_girados());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getnd());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getprocedencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosdiariosbancos.getdestino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySaldosDiariosBancos="";
	
	public String getsFinalQuerySaldosDiariosBancos() {
		return this.sFinalQuerySaldosDiariosBancos;
	}
	
	public void setsFinalQuerySaldosDiariosBancos(String sFinalQuerySaldosDiariosBancos) {
		this.sFinalQuerySaldosDiariosBancos= sFinalQuerySaldosDiariosBancos;
	}
	
	public Border resaltarSeleccionarSaldosDiariosBancos=null;
	
	public Border setResaltarSeleccionarSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSaldosDiariosBancos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSaldosDiariosBancos() {
		return this.resaltarSeleccionarSaldosDiariosBancos;
	}
	
	public void setResaltarSeleccionarSaldosDiariosBancos(Border borderResaltarSeleccionarSaldosDiariosBancos) {
		this.resaltarSeleccionarSaldosDiariosBancos= borderResaltarSeleccionarSaldosDiariosBancos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSaldosDiariosBancos=null;
	public Boolean mostraridSaldosDiariosBancos=true;
	public Boolean activaridSaldosDiariosBancos=true;

	public Border resaltarid_empresaSaldosDiariosBancos=null;
	public Boolean mostrarid_empresaSaldosDiariosBancos=true;
	public Boolean activarid_empresaSaldosDiariosBancos=true;
	public Boolean cargarid_empresaSaldosDiariosBancos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSaldosDiariosBancos=false;//ConEventDepend=true

	public Border resaltarid_ejercicioSaldosDiariosBancos=null;
	public Boolean mostrarid_ejercicioSaldosDiariosBancos=true;
	public Boolean activarid_ejercicioSaldosDiariosBancos=true;
	public Boolean cargarid_ejercicioSaldosDiariosBancos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioSaldosDiariosBancos=false;//ConEventDepend=true

	public Border resaltarfecha_desdeSaldosDiariosBancos=null;
	public Boolean mostrarfecha_desdeSaldosDiariosBancos=true;
	public Boolean activarfecha_desdeSaldosDiariosBancos=true;

	public Border resaltarfecha_hastaSaldosDiariosBancos=null;
	public Boolean mostrarfecha_hastaSaldosDiariosBancos=true;
	public Boolean activarfecha_hastaSaldosDiariosBancos=true;

	public Border resaltarcodigo_cuentaSaldosDiariosBancos=null;
	public Boolean mostrarcodigo_cuentaSaldosDiariosBancos=true;
	public Boolean activarcodigo_cuentaSaldosDiariosBancos=true;

	public Border resaltarnombre_bancoSaldosDiariosBancos=null;
	public Boolean mostrarnombre_bancoSaldosDiariosBancos=true;
	public Boolean activarnombre_bancoSaldosDiariosBancos=true;

	public Border resaltarnumero_cuentaSaldosDiariosBancos=null;
	public Boolean mostrarnumero_cuentaSaldosDiariosBancos=true;
	public Boolean activarnumero_cuentaSaldosDiariosBancos=true;

	public Border resaltarnombre_monedaSaldosDiariosBancos=null;
	public Boolean mostrarnombre_monedaSaldosDiariosBancos=true;
	public Boolean activarnombre_monedaSaldosDiariosBancos=true;

	public Border resaltarsaldo_anteriorSaldosDiariosBancos=null;
	public Boolean mostrarsaldo_anteriorSaldosDiariosBancos=true;
	public Boolean activarsaldo_anteriorSaldosDiariosBancos=true;

	public Border resaltardepositoSaldosDiariosBancos=null;
	public Boolean mostrardepositoSaldosDiariosBancos=true;
	public Boolean activardepositoSaldosDiariosBancos=true;

	public Border resaltarncSaldosDiariosBancos=null;
	public Boolean mostrarncSaldosDiariosBancos=true;
	public Boolean activarncSaldosDiariosBancos=true;

	public Border resaltarch_giradosSaldosDiariosBancos=null;
	public Boolean mostrarch_giradosSaldosDiariosBancos=true;
	public Boolean activarch_giradosSaldosDiariosBancos=true;

	public Border resaltarndSaldosDiariosBancos=null;
	public Boolean mostrarndSaldosDiariosBancos=true;
	public Boolean activarndSaldosDiariosBancos=true;

	public Border resaltarprocedenciaSaldosDiariosBancos=null;
	public Boolean mostrarprocedenciaSaldosDiariosBancos=true;
	public Boolean activarprocedenciaSaldosDiariosBancos=true;

	public Border resaltardestinoSaldosDiariosBancos=null;
	public Boolean mostrardestinoSaldosDiariosBancos=true;
	public Boolean activardestinoSaldosDiariosBancos=true;

	
	

	public Border setResaltaridSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltaridSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSaldosDiariosBancos() {
		return this.resaltaridSaldosDiariosBancos;
	}

	public void setResaltaridSaldosDiariosBancos(Border borderResaltar) {
		this.resaltaridSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostraridSaldosDiariosBancos() {
		return this.mostraridSaldosDiariosBancos;
	}

	public void setMostraridSaldosDiariosBancos(Boolean mostraridSaldosDiariosBancos) {
		this.mostraridSaldosDiariosBancos= mostraridSaldosDiariosBancos;
	}

	public Boolean getActivaridSaldosDiariosBancos() {
		return this.activaridSaldosDiariosBancos;
	}

	public void setActivaridSaldosDiariosBancos(Boolean activaridSaldosDiariosBancos) {
		this.activaridSaldosDiariosBancos= activaridSaldosDiariosBancos;
	}

	public Border setResaltarid_empresaSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarid_empresaSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSaldosDiariosBancos() {
		return this.resaltarid_empresaSaldosDiariosBancos;
	}

	public void setResaltarid_empresaSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarid_empresaSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarid_empresaSaldosDiariosBancos() {
		return this.mostrarid_empresaSaldosDiariosBancos;
	}

	public void setMostrarid_empresaSaldosDiariosBancos(Boolean mostrarid_empresaSaldosDiariosBancos) {
		this.mostrarid_empresaSaldosDiariosBancos= mostrarid_empresaSaldosDiariosBancos;
	}

	public Boolean getActivarid_empresaSaldosDiariosBancos() {
		return this.activarid_empresaSaldosDiariosBancos;
	}

	public void setActivarid_empresaSaldosDiariosBancos(Boolean activarid_empresaSaldosDiariosBancos) {
		this.activarid_empresaSaldosDiariosBancos= activarid_empresaSaldosDiariosBancos;
	}

	public Boolean getCargarid_empresaSaldosDiariosBancos() {
		return this.cargarid_empresaSaldosDiariosBancos;
	}

	public void setCargarid_empresaSaldosDiariosBancos(Boolean cargarid_empresaSaldosDiariosBancos) {
		this.cargarid_empresaSaldosDiariosBancos= cargarid_empresaSaldosDiariosBancos;
	}

	public Border setResaltarid_ejercicioSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioSaldosDiariosBancos() {
		return this.resaltarid_ejercicioSaldosDiariosBancos;
	}

	public void setResaltarid_ejercicioSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarid_ejercicioSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioSaldosDiariosBancos() {
		return this.mostrarid_ejercicioSaldosDiariosBancos;
	}

	public void setMostrarid_ejercicioSaldosDiariosBancos(Boolean mostrarid_ejercicioSaldosDiariosBancos) {
		this.mostrarid_ejercicioSaldosDiariosBancos= mostrarid_ejercicioSaldosDiariosBancos;
	}

	public Boolean getActivarid_ejercicioSaldosDiariosBancos() {
		return this.activarid_ejercicioSaldosDiariosBancos;
	}

	public void setActivarid_ejercicioSaldosDiariosBancos(Boolean activarid_ejercicioSaldosDiariosBancos) {
		this.activarid_ejercicioSaldosDiariosBancos= activarid_ejercicioSaldosDiariosBancos;
	}

	public Boolean getCargarid_ejercicioSaldosDiariosBancos() {
		return this.cargarid_ejercicioSaldosDiariosBancos;
	}

	public void setCargarid_ejercicioSaldosDiariosBancos(Boolean cargarid_ejercicioSaldosDiariosBancos) {
		this.cargarid_ejercicioSaldosDiariosBancos= cargarid_ejercicioSaldosDiariosBancos;
	}

	public Border setResaltarfecha_desdeSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeSaldosDiariosBancos() {
		return this.resaltarfecha_desdeSaldosDiariosBancos;
	}

	public void setResaltarfecha_desdeSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarfecha_desdeSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeSaldosDiariosBancos() {
		return this.mostrarfecha_desdeSaldosDiariosBancos;
	}

	public void setMostrarfecha_desdeSaldosDiariosBancos(Boolean mostrarfecha_desdeSaldosDiariosBancos) {
		this.mostrarfecha_desdeSaldosDiariosBancos= mostrarfecha_desdeSaldosDiariosBancos;
	}

	public Boolean getActivarfecha_desdeSaldosDiariosBancos() {
		return this.activarfecha_desdeSaldosDiariosBancos;
	}

	public void setActivarfecha_desdeSaldosDiariosBancos(Boolean activarfecha_desdeSaldosDiariosBancos) {
		this.activarfecha_desdeSaldosDiariosBancos= activarfecha_desdeSaldosDiariosBancos;
	}

	public Border setResaltarfecha_hastaSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaSaldosDiariosBancos() {
		return this.resaltarfecha_hastaSaldosDiariosBancos;
	}

	public void setResaltarfecha_hastaSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarfecha_hastaSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaSaldosDiariosBancos() {
		return this.mostrarfecha_hastaSaldosDiariosBancos;
	}

	public void setMostrarfecha_hastaSaldosDiariosBancos(Boolean mostrarfecha_hastaSaldosDiariosBancos) {
		this.mostrarfecha_hastaSaldosDiariosBancos= mostrarfecha_hastaSaldosDiariosBancos;
	}

	public Boolean getActivarfecha_hastaSaldosDiariosBancos() {
		return this.activarfecha_hastaSaldosDiariosBancos;
	}

	public void setActivarfecha_hastaSaldosDiariosBancos(Boolean activarfecha_hastaSaldosDiariosBancos) {
		this.activarfecha_hastaSaldosDiariosBancos= activarfecha_hastaSaldosDiariosBancos;
	}

	public Border setResaltarcodigo_cuentaSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuentaSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuentaSaldosDiariosBancos() {
		return this.resaltarcodigo_cuentaSaldosDiariosBancos;
	}

	public void setResaltarcodigo_cuentaSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarcodigo_cuentaSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuentaSaldosDiariosBancos() {
		return this.mostrarcodigo_cuentaSaldosDiariosBancos;
	}

	public void setMostrarcodigo_cuentaSaldosDiariosBancos(Boolean mostrarcodigo_cuentaSaldosDiariosBancos) {
		this.mostrarcodigo_cuentaSaldosDiariosBancos= mostrarcodigo_cuentaSaldosDiariosBancos;
	}

	public Boolean getActivarcodigo_cuentaSaldosDiariosBancos() {
		return this.activarcodigo_cuentaSaldosDiariosBancos;
	}

	public void setActivarcodigo_cuentaSaldosDiariosBancos(Boolean activarcodigo_cuentaSaldosDiariosBancos) {
		this.activarcodigo_cuentaSaldosDiariosBancos= activarcodigo_cuentaSaldosDiariosBancos;
	}

	public Border setResaltarnombre_bancoSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoSaldosDiariosBancos() {
		return this.resaltarnombre_bancoSaldosDiariosBancos;
	}

	public void setResaltarnombre_bancoSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarnombre_bancoSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoSaldosDiariosBancos() {
		return this.mostrarnombre_bancoSaldosDiariosBancos;
	}

	public void setMostrarnombre_bancoSaldosDiariosBancos(Boolean mostrarnombre_bancoSaldosDiariosBancos) {
		this.mostrarnombre_bancoSaldosDiariosBancos= mostrarnombre_bancoSaldosDiariosBancos;
	}

	public Boolean getActivarnombre_bancoSaldosDiariosBancos() {
		return this.activarnombre_bancoSaldosDiariosBancos;
	}

	public void setActivarnombre_bancoSaldosDiariosBancos(Boolean activarnombre_bancoSaldosDiariosBancos) {
		this.activarnombre_bancoSaldosDiariosBancos= activarnombre_bancoSaldosDiariosBancos;
	}

	public Border setResaltarnumero_cuentaSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaSaldosDiariosBancos() {
		return this.resaltarnumero_cuentaSaldosDiariosBancos;
	}

	public void setResaltarnumero_cuentaSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarnumero_cuentaSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaSaldosDiariosBancos() {
		return this.mostrarnumero_cuentaSaldosDiariosBancos;
	}

	public void setMostrarnumero_cuentaSaldosDiariosBancos(Boolean mostrarnumero_cuentaSaldosDiariosBancos) {
		this.mostrarnumero_cuentaSaldosDiariosBancos= mostrarnumero_cuentaSaldosDiariosBancos;
	}

	public Boolean getActivarnumero_cuentaSaldosDiariosBancos() {
		return this.activarnumero_cuentaSaldosDiariosBancos;
	}

	public void setActivarnumero_cuentaSaldosDiariosBancos(Boolean activarnumero_cuentaSaldosDiariosBancos) {
		this.activarnumero_cuentaSaldosDiariosBancos= activarnumero_cuentaSaldosDiariosBancos;
	}

	public Border setResaltarnombre_monedaSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarnombre_monedaSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_monedaSaldosDiariosBancos() {
		return this.resaltarnombre_monedaSaldosDiariosBancos;
	}

	public void setResaltarnombre_monedaSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarnombre_monedaSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarnombre_monedaSaldosDiariosBancos() {
		return this.mostrarnombre_monedaSaldosDiariosBancos;
	}

	public void setMostrarnombre_monedaSaldosDiariosBancos(Boolean mostrarnombre_monedaSaldosDiariosBancos) {
		this.mostrarnombre_monedaSaldosDiariosBancos= mostrarnombre_monedaSaldosDiariosBancos;
	}

	public Boolean getActivarnombre_monedaSaldosDiariosBancos() {
		return this.activarnombre_monedaSaldosDiariosBancos;
	}

	public void setActivarnombre_monedaSaldosDiariosBancos(Boolean activarnombre_monedaSaldosDiariosBancos) {
		this.activarnombre_monedaSaldosDiariosBancos= activarnombre_monedaSaldosDiariosBancos;
	}

	public Border setResaltarsaldo_anteriorSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarsaldo_anteriorSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_anteriorSaldosDiariosBancos() {
		return this.resaltarsaldo_anteriorSaldosDiariosBancos;
	}

	public void setResaltarsaldo_anteriorSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarsaldo_anteriorSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarsaldo_anteriorSaldosDiariosBancos() {
		return this.mostrarsaldo_anteriorSaldosDiariosBancos;
	}

	public void setMostrarsaldo_anteriorSaldosDiariosBancos(Boolean mostrarsaldo_anteriorSaldosDiariosBancos) {
		this.mostrarsaldo_anteriorSaldosDiariosBancos= mostrarsaldo_anteriorSaldosDiariosBancos;
	}

	public Boolean getActivarsaldo_anteriorSaldosDiariosBancos() {
		return this.activarsaldo_anteriorSaldosDiariosBancos;
	}

	public void setActivarsaldo_anteriorSaldosDiariosBancos(Boolean activarsaldo_anteriorSaldosDiariosBancos) {
		this.activarsaldo_anteriorSaldosDiariosBancos= activarsaldo_anteriorSaldosDiariosBancos;
	}

	public Border setResaltardepositoSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltardepositoSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardepositoSaldosDiariosBancos() {
		return this.resaltardepositoSaldosDiariosBancos;
	}

	public void setResaltardepositoSaldosDiariosBancos(Border borderResaltar) {
		this.resaltardepositoSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrardepositoSaldosDiariosBancos() {
		return this.mostrardepositoSaldosDiariosBancos;
	}

	public void setMostrardepositoSaldosDiariosBancos(Boolean mostrardepositoSaldosDiariosBancos) {
		this.mostrardepositoSaldosDiariosBancos= mostrardepositoSaldosDiariosBancos;
	}

	public Boolean getActivardepositoSaldosDiariosBancos() {
		return this.activardepositoSaldosDiariosBancos;
	}

	public void setActivardepositoSaldosDiariosBancos(Boolean activardepositoSaldosDiariosBancos) {
		this.activardepositoSaldosDiariosBancos= activardepositoSaldosDiariosBancos;
	}

	public Border setResaltarncSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarncSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarncSaldosDiariosBancos() {
		return this.resaltarncSaldosDiariosBancos;
	}

	public void setResaltarncSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarncSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarncSaldosDiariosBancos() {
		return this.mostrarncSaldosDiariosBancos;
	}

	public void setMostrarncSaldosDiariosBancos(Boolean mostrarncSaldosDiariosBancos) {
		this.mostrarncSaldosDiariosBancos= mostrarncSaldosDiariosBancos;
	}

	public Boolean getActivarncSaldosDiariosBancos() {
		return this.activarncSaldosDiariosBancos;
	}

	public void setActivarncSaldosDiariosBancos(Boolean activarncSaldosDiariosBancos) {
		this.activarncSaldosDiariosBancos= activarncSaldosDiariosBancos;
	}

	public Border setResaltarch_giradosSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarch_giradosSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarch_giradosSaldosDiariosBancos() {
		return this.resaltarch_giradosSaldosDiariosBancos;
	}

	public void setResaltarch_giradosSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarch_giradosSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarch_giradosSaldosDiariosBancos() {
		return this.mostrarch_giradosSaldosDiariosBancos;
	}

	public void setMostrarch_giradosSaldosDiariosBancos(Boolean mostrarch_giradosSaldosDiariosBancos) {
		this.mostrarch_giradosSaldosDiariosBancos= mostrarch_giradosSaldosDiariosBancos;
	}

	public Boolean getActivarch_giradosSaldosDiariosBancos() {
		return this.activarch_giradosSaldosDiariosBancos;
	}

	public void setActivarch_giradosSaldosDiariosBancos(Boolean activarch_giradosSaldosDiariosBancos) {
		this.activarch_giradosSaldosDiariosBancos= activarch_giradosSaldosDiariosBancos;
	}

	public Border setResaltarndSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarndSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarndSaldosDiariosBancos() {
		return this.resaltarndSaldosDiariosBancos;
	}

	public void setResaltarndSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarndSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarndSaldosDiariosBancos() {
		return this.mostrarndSaldosDiariosBancos;
	}

	public void setMostrarndSaldosDiariosBancos(Boolean mostrarndSaldosDiariosBancos) {
		this.mostrarndSaldosDiariosBancos= mostrarndSaldosDiariosBancos;
	}

	public Boolean getActivarndSaldosDiariosBancos() {
		return this.activarndSaldosDiariosBancos;
	}

	public void setActivarndSaldosDiariosBancos(Boolean activarndSaldosDiariosBancos) {
		this.activarndSaldosDiariosBancos= activarndSaldosDiariosBancos;
	}

	public Border setResaltarprocedenciaSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltarprocedenciaSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprocedenciaSaldosDiariosBancos() {
		return this.resaltarprocedenciaSaldosDiariosBancos;
	}

	public void setResaltarprocedenciaSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarprocedenciaSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrarprocedenciaSaldosDiariosBancos() {
		return this.mostrarprocedenciaSaldosDiariosBancos;
	}

	public void setMostrarprocedenciaSaldosDiariosBancos(Boolean mostrarprocedenciaSaldosDiariosBancos) {
		this.mostrarprocedenciaSaldosDiariosBancos= mostrarprocedenciaSaldosDiariosBancos;
	}

	public Boolean getActivarprocedenciaSaldosDiariosBancos() {
		return this.activarprocedenciaSaldosDiariosBancos;
	}

	public void setActivarprocedenciaSaldosDiariosBancos(Boolean activarprocedenciaSaldosDiariosBancos) {
		this.activarprocedenciaSaldosDiariosBancos= activarprocedenciaSaldosDiariosBancos;
	}

	public Border setResaltardestinoSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosdiariosbancosBeanSwingJInternalFrame.jTtoolBarSaldosDiariosBancos.setBorder(borderResaltar);
		
		this.resaltardestinoSaldosDiariosBancos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardestinoSaldosDiariosBancos() {
		return this.resaltardestinoSaldosDiariosBancos;
	}

	public void setResaltardestinoSaldosDiariosBancos(Border borderResaltar) {
		this.resaltardestinoSaldosDiariosBancos= borderResaltar;
	}

	public Boolean getMostrardestinoSaldosDiariosBancos() {
		return this.mostrardestinoSaldosDiariosBancos;
	}

	public void setMostrardestinoSaldosDiariosBancos(Boolean mostrardestinoSaldosDiariosBancos) {
		this.mostrardestinoSaldosDiariosBancos= mostrardestinoSaldosDiariosBancos;
	}

	public Boolean getActivardestinoSaldosDiariosBancos() {
		return this.activardestinoSaldosDiariosBancos;
	}

	public void setActivardestinoSaldosDiariosBancos(Boolean activardestinoSaldosDiariosBancos) {
		this.activardestinoSaldosDiariosBancos= activardestinoSaldosDiariosBancos;
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
		
		
		this.setMostraridSaldosDiariosBancos(esInicial);
		this.setMostrarid_empresaSaldosDiariosBancos(esInicial);
		this.setMostrarid_ejercicioSaldosDiariosBancos(esInicial);
		this.setMostrarfecha_desdeSaldosDiariosBancos(esInicial);
		this.setMostrarfecha_hastaSaldosDiariosBancos(esInicial);
		this.setMostrarcodigo_cuentaSaldosDiariosBancos(esInicial);
		this.setMostrarnombre_bancoSaldosDiariosBancos(esInicial);
		this.setMostrarnumero_cuentaSaldosDiariosBancos(esInicial);
		this.setMostrarnombre_monedaSaldosDiariosBancos(esInicial);
		this.setMostrarsaldo_anteriorSaldosDiariosBancos(esInicial);
		this.setMostrardepositoSaldosDiariosBancos(esInicial);
		this.setMostrarncSaldosDiariosBancos(esInicial);
		this.setMostrarch_giradosSaldosDiariosBancos(esInicial);
		this.setMostrarndSaldosDiariosBancos(esInicial);
		this.setMostrarprocedenciaSaldosDiariosBancos(esInicial);
		this.setMostrardestinoSaldosDiariosBancos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.ID)) {
				this.setMostraridSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA)) {
				this.setMostrarcodigo_cuentaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA)) {
				this.setMostrarnombre_monedaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR)) {
				this.setMostrarsaldo_anteriorSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.DEPOSITO)) {
				this.setMostrardepositoSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NC)) {
				this.setMostrarncSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.CHGIRADOS)) {
				this.setMostrarch_giradosSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.ND)) {
				this.setMostrarndSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.PROCEDENCIA)) {
				this.setMostrarprocedenciaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.DESTINO)) {
				this.setMostrardestinoSaldosDiariosBancos(esAsigna);
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
		
		
		this.setActivaridSaldosDiariosBancos(esInicial);
		this.setActivarid_empresaSaldosDiariosBancos(esInicial);
		this.setActivarid_ejercicioSaldosDiariosBancos(esInicial);
		this.setActivarfecha_desdeSaldosDiariosBancos(esInicial);
		this.setActivarfecha_hastaSaldosDiariosBancos(esInicial);
		this.setActivarcodigo_cuentaSaldosDiariosBancos(esInicial);
		this.setActivarnombre_bancoSaldosDiariosBancos(esInicial);
		this.setActivarnumero_cuentaSaldosDiariosBancos(esInicial);
		this.setActivarnombre_monedaSaldosDiariosBancos(esInicial);
		this.setActivarsaldo_anteriorSaldosDiariosBancos(esInicial);
		this.setActivardepositoSaldosDiariosBancos(esInicial);
		this.setActivarncSaldosDiariosBancos(esInicial);
		this.setActivarch_giradosSaldosDiariosBancos(esInicial);
		this.setActivarndSaldosDiariosBancos(esInicial);
		this.setActivarprocedenciaSaldosDiariosBancos(esInicial);
		this.setActivardestinoSaldosDiariosBancos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.ID)) {
				this.setActivaridSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA)) {
				this.setActivarcodigo_cuentaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA)) {
				this.setActivarnombre_monedaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR)) {
				this.setActivarsaldo_anteriorSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.DEPOSITO)) {
				this.setActivardepositoSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NC)) {
				this.setActivarncSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.CHGIRADOS)) {
				this.setActivarch_giradosSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.ND)) {
				this.setActivarndSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.PROCEDENCIA)) {
				this.setActivarprocedenciaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.DESTINO)) {
				this.setActivardestinoSaldosDiariosBancos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSaldosDiariosBancos(esInicial);
		this.setResaltarid_empresaSaldosDiariosBancos(esInicial);
		this.setResaltarid_ejercicioSaldosDiariosBancos(esInicial);
		this.setResaltarfecha_desdeSaldosDiariosBancos(esInicial);
		this.setResaltarfecha_hastaSaldosDiariosBancos(esInicial);
		this.setResaltarcodigo_cuentaSaldosDiariosBancos(esInicial);
		this.setResaltarnombre_bancoSaldosDiariosBancos(esInicial);
		this.setResaltarnumero_cuentaSaldosDiariosBancos(esInicial);
		this.setResaltarnombre_monedaSaldosDiariosBancos(esInicial);
		this.setResaltarsaldo_anteriorSaldosDiariosBancos(esInicial);
		this.setResaltardepositoSaldosDiariosBancos(esInicial);
		this.setResaltarncSaldosDiariosBancos(esInicial);
		this.setResaltarch_giradosSaldosDiariosBancos(esInicial);
		this.setResaltarndSaldosDiariosBancos(esInicial);
		this.setResaltarprocedenciaSaldosDiariosBancos(esInicial);
		this.setResaltardestinoSaldosDiariosBancos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.ID)) {
				this.setResaltaridSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.CODIGOCUENTA)) {
				this.setResaltarcodigo_cuentaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NOMBREMONEDA)) {
				this.setResaltarnombre_monedaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR)) {
				this.setResaltarsaldo_anteriorSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.DEPOSITO)) {
				this.setResaltardepositoSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.NC)) {
				this.setResaltarncSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.CHGIRADOS)) {
				this.setResaltarch_giradosSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.ND)) {
				this.setResaltarndSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.PROCEDENCIA)) {
				this.setResaltarprocedenciaSaldosDiariosBancos(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosDiariosBancosConstantesFunciones.DESTINO)) {
				this.setResaltardestinoSaldosDiariosBancos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSaldosDiariosBancosSaldosDiariosBancos=true;

	public Boolean getMostrarBusquedaSaldosDiariosBancosSaldosDiariosBancos() {
		return this.mostrarBusquedaSaldosDiariosBancosSaldosDiariosBancos;
	}

	public void setMostrarBusquedaSaldosDiariosBancosSaldosDiariosBancos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSaldosDiariosBancosSaldosDiariosBancos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSaldosDiariosBancosSaldosDiariosBancos=true;

	public Boolean getActivarBusquedaSaldosDiariosBancosSaldosDiariosBancos() {
		return this.activarBusquedaSaldosDiariosBancosSaldosDiariosBancos;
	}

	public void setActivarBusquedaSaldosDiariosBancosSaldosDiariosBancos(Boolean habilitarResaltar) {
		this.activarBusquedaSaldosDiariosBancosSaldosDiariosBancos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos=null;

	public Border getResaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos() {
		return this.resaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos;
	}

	public void setResaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos(Border borderResaltar) {
		this.resaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos= borderResaltar;
	}

	public void setResaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosDiariosBancosBeanSwingJInternalFrame saldosdiariosbancosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSaldosDiariosBancosSaldosDiariosBancos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}