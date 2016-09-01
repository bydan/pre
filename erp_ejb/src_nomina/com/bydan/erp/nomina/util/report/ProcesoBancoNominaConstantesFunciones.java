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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoBancoNominaConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoBancoNominaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoBancoNominaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoBancoNominaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoBancoNomina";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoBancoNomina"+ProcesoBancoNominaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoBancoNominaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoBancoNominaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoBancoNominaConstantesFunciones.SCHEMA+"_"+ProcesoBancoNominaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoBancoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoBancoNominaConstantesFunciones.SCHEMA+"_"+ProcesoBancoNominaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoBancoNominaConstantesFunciones.SCHEMA+"_"+ProcesoBancoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoBancoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoBancoNominaConstantesFunciones.SCHEMA+"_"+ProcesoBancoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoBancoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoBancoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoBancoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoBancoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoBancoNominaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoBancoNominaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoBancoNominaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoBancoNominaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoBancoNominaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoBancoNominaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Banco Nominas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Banco Nomina";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Banco Nomina";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoBancoNomina";
	public static final String OBJECTNAME="procesobanconomina";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_banco_nomina";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesobanconomina from "+ProcesoBancoNominaConstantesFunciones.SPERSISTENCENAME+" procesobanconomina";
	public static String QUERYSELECTNATIVE="select "+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".id,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".version_row,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".id_banco,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".id_cuenta_banco,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".id_tipo_contrato,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".id_tipo_banco_disco,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".con_otros,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".con_internet,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".fecha,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".numero_secuenciales,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".genera_texto,"+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME+".genera_excel from "+ProcesoBancoNominaConstantesFunciones.SCHEMA+"."+ProcesoBancoNominaConstantesFunciones.TABLENAME;//+" as "+ProcesoBancoNominaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDBANCO= "id_banco";
    public static final String IDCUENTABANCO= "id_cuenta_banco";
    public static final String IDTIPOCONTRATO= "id_tipo_contrato";
    public static final String IDTIPOBANCODISCO= "id_tipo_banco_disco";
    public static final String CONOTROS= "con_otros";
    public static final String CONINTERNET= "con_internet";
    public static final String FECHA= "fecha";
    public static final String NUMEROSECUENCIALES= "numero_secuenciales";
    public static final String GENERATEXTO= "genera_texto";
    public static final String GENERAEXCEL= "genera_excel";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDCUENTABANCO= "Cuenta Banco";
		public static final String LABEL_IDCUENTABANCO_LOWER= "Cuenta Banco";
    	public static final String LABEL_IDTIPOCONTRATO= "Tipo Contrato";
		public static final String LABEL_IDTIPOCONTRATO_LOWER= "Tipo Contrato";
    	public static final String LABEL_IDTIPOBANCODISCO= "Tipo Banco Disco";
		public static final String LABEL_IDTIPOBANCODISCO_LOWER= "Tipo Banco Disco";
    	public static final String LABEL_CONOTROS= "Con Otros";
		public static final String LABEL_CONOTROS_LOWER= "Con Otros";
    	public static final String LABEL_CONINTERNET= "Con Internet";
		public static final String LABEL_CONINTERNET_LOWER= "Con Internet";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMEROSECUENCIALES= "Numero Secuenciales";
		public static final String LABEL_NUMEROSECUENCIALES_LOWER= "Numero Secuenciales";
    	public static final String LABEL_GENERATEXTO= "Genera Texto";
		public static final String LABEL_GENERATEXTO_LOWER= "Genera Texto";
    	public static final String LABEL_GENERAEXCEL= "Genera Excel";
		public static final String LABEL_GENERAEXCEL_LOWER= "Genera Excel";
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getProcesoBancoNominaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.IDBANCO)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_IDCUENTABANCO;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOCONTRATO;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOBANCODISCO;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.CONOTROS)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_CONOTROS;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.CONINTERNET)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_CONINTERNET;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.FECHA)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_NUMEROSECUENCIALES;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.GENERATEXTO)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_GENERATEXTO;}
		if(sNombreColumna.equals(ProcesoBancoNominaConstantesFunciones.GENERAEXCEL)) {sLabelColumna=ProcesoBancoNominaConstantesFunciones.LABEL_GENERAEXCEL;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getcon_otrosDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesobanconomina.getcon_otros()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_otrosHtmlDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesobanconomina.getId(),procesobanconomina.getcon_otros());

		return sDescripcion;
	}	
		
	public static String getcon_internetDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesobanconomina.getcon_internet()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_internetHtmlDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesobanconomina.getId(),procesobanconomina.getcon_internet());

		return sDescripcion;
	}	
			
			
		
	public static String getgenera_textoDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesobanconomina.getgenera_texto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getgenera_textoHtmlDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesobanconomina.getId(),procesobanconomina.getgenera_texto());

		return sDescripcion;
	}	
		
	public static String getgenera_excelDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!procesobanconomina.getgenera_excel()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getgenera_excelHtmlDescripcion(ProcesoBancoNomina procesobanconomina) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(procesobanconomina.getId(),procesobanconomina.getgenera_excel());

		return sDescripcion;
	}	
	
	public static String getProcesoBancoNominaDescripcion(ProcesoBancoNomina procesobanconomina) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesobanconomina !=null/* && procesobanconomina.getId()!=0*/) {
			if(procesobanconomina.getId()!=null) {
				sDescripcion=procesobanconomina.getId().toString();
			}//procesobanconominaprocesobanconomina.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoBancoNominaDescripcionDetallado(ProcesoBancoNomina procesobanconomina) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.ID+"=";
		sDescripcion+=procesobanconomina.getId().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesobanconomina.getVersionRow().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.IDBANCO+"=";
		sDescripcion+=procesobanconomina.getid_banco().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO+"=";
		sDescripcion+=procesobanconomina.getid_cuenta_banco().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO+"=";
		sDescripcion+=procesobanconomina.getid_tipo_contrato().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO+"=";
		sDescripcion+=procesobanconomina.getid_tipo_banco_disco().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.CONOTROS+"=";
		sDescripcion+=procesobanconomina.getcon_otros().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.CONINTERNET+"=";
		sDescripcion+=procesobanconomina.getcon_internet().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.FECHA+"=";
		sDescripcion+=procesobanconomina.getfecha().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES+"=";
		sDescripcion+=procesobanconomina.getnumero_secuenciales().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.GENERATEXTO+"=";
		sDescripcion+=procesobanconomina.getgenera_texto().toString()+",";
		sDescripcion+=ProcesoBancoNominaConstantesFunciones.GENERAEXCEL+"=";
		sDescripcion+=procesobanconomina.getgenera_excel().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoBancoNominaDescripcion(ProcesoBancoNomina procesobanconomina,String sValor) throws Exception {			
		if(procesobanconomina !=null) {
			//procesobanconominaprocesobanconomina.getId().toString();
		}		
	}
	
		

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getCuentaBancoDescripcion(CuentaBanco cuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentabanco!=null/*&&cuentabanco.getId()>0*/) {
			sDescripcion=CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(cuentabanco);
		}

		return sDescripcion;
	}

	public static String getTipoContratoDescripcion(TipoContrato tipocontrato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocontrato!=null/*&&tipocontrato.getId()>0*/) {
			sDescripcion=TipoContratoConstantesFunciones.getTipoContratoDescripcion(tipocontrato);
		}

		return sDescripcion;
	}

	public static String getTipoBancoDiscoDescripcion(TipoBancoDisco tipobancodisco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipobancodisco!=null/*&&tipobancodisco.getId()>0*/) {
			sDescripcion=TipoBancoDiscoConstantesFunciones.getTipoBancoDiscoDescripcion(tipobancodisco);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoBancoNomina")) {
			sNombreIndice="Tipo=  Por Banco Por Cuenta Banco Por Tipo Contrato Por Tipo Banco Disco Por Con Otros Por Con Internet Por Fecha Por Numero Secuenciales Por Genera Texto Por Genera Excel";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCuentaBanco")) {
			sNombreIndice="Tipo=  Por Cuenta Banco";
		} else if(sNombreIndice.equals("FK_IdTipoBancoDisco")) {
			sNombreIndice="Tipo=  Por Tipo Banco Disco";
		} else if(sNombreIndice.equals("FK_IdTipoContrato")) {
			sNombreIndice="Tipo=  Por Tipo Contrato";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoBancoNomina(Long id_banco,Long id_cuenta_banco,Long id_tipo_contrato,Long id_tipo_banco_disco,Boolean con_otros,Boolean con_internet,Date fecha,Integer numero_secuenciales,Boolean genera_texto,Boolean genera_excel) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();}
		if(id_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Banco="+id_cuenta_banco.toString();}
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();}
		if(id_tipo_banco_disco!=null) {sDetalleIndice+=" Codigo Unico De Tipo Banco Disco="+id_tipo_banco_disco.toString();}
		if(con_otros!=null) {sDetalleIndice+=" Con Otros="+con_otros.toString();}
		if(con_internet!=null) {sDetalleIndice+=" Con Internet="+con_internet.toString();}
		if(fecha!=null) {sDetalleIndice+=" Fecha="+fecha.toString();}
		if(numero_secuenciales!=null) {sDetalleIndice+=" Numero Secuenciales="+numero_secuenciales.toString();}
		if(genera_texto!=null) {sDetalleIndice+=" Genera Texto="+genera_texto.toString();}
		if(genera_excel!=null) {sDetalleIndice+=" Genera Excel="+genera_excel.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaBanco(Long id_cuenta_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Banco="+id_cuenta_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoBancoDisco(Long id_tipo_banco_disco) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_banco_disco!=null) {sDetalleIndice+=" Codigo Unico De Tipo Banco Disco="+id_tipo_banco_disco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoContrato(Long id_tipo_contrato) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoBancoNomina(ProcesoBancoNomina procesobanconomina,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoBancoNominas(List<ProcesoBancoNomina> procesobanconominas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoBancoNomina procesobanconomina: procesobanconominas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoBancoNomina(ProcesoBancoNomina procesobanconomina,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesobanconomina.getConCambioAuxiliar()) {
			procesobanconomina.setIsDeleted(procesobanconomina.getIsDeletedAuxiliar());	
			procesobanconomina.setIsNew(procesobanconomina.getIsNewAuxiliar());	
			procesobanconomina.setIsChanged(procesobanconomina.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesobanconomina.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesobanconomina.setIsDeletedAuxiliar(false);	
			procesobanconomina.setIsNewAuxiliar(false);	
			procesobanconomina.setIsChangedAuxiliar(false);
			
			procesobanconomina.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoBancoNominas(List<ProcesoBancoNomina> procesobanconominas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoBancoNomina procesobanconomina : procesobanconominas) {
			if(conAsignarBase && procesobanconomina.getConCambioAuxiliar()) {
				procesobanconomina.setIsDeleted(procesobanconomina.getIsDeletedAuxiliar());	
				procesobanconomina.setIsNew(procesobanconomina.getIsNewAuxiliar());	
				procesobanconomina.setIsChanged(procesobanconomina.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesobanconomina.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesobanconomina.setIsDeletedAuxiliar(false);	
				procesobanconomina.setIsNewAuxiliar(false);	
				procesobanconomina.setIsChangedAuxiliar(false);
				
				procesobanconomina.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoBancoNomina(ProcesoBancoNomina procesobanconomina,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			procesobanconomina.setnumero_secuenciales(0);
		}
	}		
	
	public static void InicializarValoresProcesoBancoNominas(List<ProcesoBancoNomina> procesobanconominas,Boolean conEnteros) throws Exception  {
		
		for(ProcesoBancoNomina procesobanconomina: procesobanconominas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				procesobanconomina.setnumero_secuenciales(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoBancoNomina(List<ProcesoBancoNomina> procesobanconominas,ProcesoBancoNomina procesobanconominaAux) throws Exception  {
		ProcesoBancoNominaConstantesFunciones.InicializarValoresProcesoBancoNomina(procesobanconominaAux,true);
		
		for(ProcesoBancoNomina procesobanconomina: procesobanconominas) {
			if(procesobanconomina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesobanconominaAux.setnumero_secuenciales(procesobanconominaAux.getnumero_secuenciales()+procesobanconomina.getnumero_secuenciales());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoBancoNomina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoBancoNominaConstantesFunciones.getArrayColumnasGlobalesProcesoBancoNomina(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoBancoNomina(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoBancoNomina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoBancoNomina> procesobanconominas,ProcesoBancoNomina procesobanconomina,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoBancoNomina procesobanconominaAux: procesobanconominas) {
			if(procesobanconominaAux!=null && procesobanconomina!=null) {
				if((procesobanconominaAux.getId()==null && procesobanconomina.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesobanconominaAux.getId()!=null && procesobanconomina.getId()!=null){
					if(procesobanconominaAux.getId().equals(procesobanconomina.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoBancoNomina(List<ProcesoBancoNomina> procesobanconominas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoBancoNomina procesobanconomina: procesobanconominas) {			
			if(procesobanconomina.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoBancoNomina() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoBancoNomina() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoBancoNomina() throws Exception  {
		return ProcesoBancoNominaConstantesFunciones.getTiposSeleccionarProcesoBancoNomina(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoBancoNomina(Boolean conFk) throws Exception  {
		return ProcesoBancoNominaConstantesFunciones.getTiposSeleccionarProcesoBancoNomina(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoBancoNomina(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_IDCUENTABANCO);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_IDCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOCONTRATO);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOBANCODISCO);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOBANCODISCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_CONOTROS);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_CONOTROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_CONINTERNET);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_CONINTERNET);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_NUMEROSECUENCIALES);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_NUMEROSECUENCIALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_GENERATEXTO);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_GENERATEXTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoBancoNominaConstantesFunciones.LABEL_GENERAEXCEL);
			reporte.setsDescripcion(ProcesoBancoNominaConstantesFunciones.LABEL_GENERAEXCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoBancoNomina(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoBancoNomina(ProcesoBancoNomina procesobanconominaAux) throws Exception {
		
			procesobanconominaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(procesobanconominaAux.getBanco()));
			procesobanconominaAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(procesobanconominaAux.getCuentaBanco()));
			procesobanconominaAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(procesobanconominaAux.getTipoContrato()));
			procesobanconominaAux.settipobancodisco_descripcion(TipoBancoDiscoConstantesFunciones.getTipoBancoDiscoDescripcion(procesobanconominaAux.getTipoBancoDisco()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoBancoNomina(List<ProcesoBancoNomina> procesobanconominasTemp) throws Exception {
		for(ProcesoBancoNomina procesobanconominaAux:procesobanconominasTemp) {
			
			procesobanconominaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(procesobanconominaAux.getBanco()));
			procesobanconominaAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(procesobanconominaAux.getCuentaBanco()));
			procesobanconominaAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(procesobanconominaAux.getTipoContrato()));
			procesobanconominaAux.settipobancodisco_descripcion(TipoBancoDiscoConstantesFunciones.getTipoBancoDiscoDescripcion(procesobanconominaAux.getTipoBancoDisco()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoBancoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(CuentaBanco.class));
				classes.add(new Classe(TipoContrato.class));
				classes.add(new Classe(TipoBancoDisco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoContrato.class)) {
						classes.add(new Classe(TipoContrato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoBancoDisco.class)) {
						classes.add(new Classe(TipoBancoDisco.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoBancoNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(TipoBancoDisco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBancoDisco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(TipoBancoDisco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBancoDisco.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoBancoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoBancoNominaConstantesFunciones.getClassesRelationshipsOfProcesoBancoNomina(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoBancoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoBancoNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoBancoNominaConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoBancoNomina(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoBancoNomina(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoBancoNomina procesobanconomina,List<ProcesoBancoNomina> procesobanconominas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoBancoNomina procesobanconomina,List<ProcesoBancoNomina> procesobanconominas) throws Exception {
		try	{			
			for(ProcesoBancoNomina procesobanconominaLocal:procesobanconominas) {
				if(procesobanconominaLocal.getId().equals(procesobanconomina.getId())) {
					procesobanconominaLocal.setIsSelected(procesobanconomina.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoBancoNomina(List<ProcesoBancoNomina> procesobanconominasAux) throws Exception {
		//this.procesobanconominasAux=procesobanconominasAux;
		
		for(ProcesoBancoNomina procesobanconominaAux:procesobanconominasAux) {
			if(procesobanconominaAux.getIsChanged()) {
				procesobanconominaAux.setIsChanged(false);
			}		
			
			if(procesobanconominaAux.getIsNew()) {
				procesobanconominaAux.setIsNew(false);
			}	
			
			if(procesobanconominaAux.getIsDeleted()) {
				procesobanconominaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoBancoNomina(ProcesoBancoNomina procesobanconominaAux) throws Exception {
		//this.procesobanconominaAux=procesobanconominaAux;
		
			if(procesobanconominaAux.getIsChanged()) {
				procesobanconominaAux.setIsChanged(false);
			}		
			
			if(procesobanconominaAux.getIsNew()) {
				procesobanconominaAux.setIsNew(false);
			}	
			
			if(procesobanconominaAux.getIsDeleted()) {
				procesobanconominaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoBancoNomina procesobanconominaAsignar,ProcesoBancoNomina procesobanconomina) throws Exception {
		procesobanconominaAsignar.setId(procesobanconomina.getId());	
		procesobanconominaAsignar.setVersionRow(procesobanconomina.getVersionRow());	
		procesobanconominaAsignar.setid_banco(procesobanconomina.getid_banco());
		procesobanconominaAsignar.setbanco_descripcion(procesobanconomina.getbanco_descripcion());	
		procesobanconominaAsignar.setid_cuenta_banco(procesobanconomina.getid_cuenta_banco());
		procesobanconominaAsignar.setcuentabanco_descripcion(procesobanconomina.getcuentabanco_descripcion());	
		procesobanconominaAsignar.setid_tipo_contrato(procesobanconomina.getid_tipo_contrato());
		procesobanconominaAsignar.settipocontrato_descripcion(procesobanconomina.gettipocontrato_descripcion());	
		procesobanconominaAsignar.setid_tipo_banco_disco(procesobanconomina.getid_tipo_banco_disco());
		procesobanconominaAsignar.settipobancodisco_descripcion(procesobanconomina.gettipobancodisco_descripcion());	
		procesobanconominaAsignar.setcon_otros(procesobanconomina.getcon_otros());	
		procesobanconominaAsignar.setcon_internet(procesobanconomina.getcon_internet());	
		procesobanconominaAsignar.setfecha(procesobanconomina.getfecha());	
		procesobanconominaAsignar.setnumero_secuenciales(procesobanconomina.getnumero_secuenciales());	
		procesobanconominaAsignar.setgenera_texto(procesobanconomina.getgenera_texto());	
		procesobanconominaAsignar.setgenera_excel(procesobanconomina.getgenera_excel());	
	}
	
	public static void inicializarProcesoBancoNomina(ProcesoBancoNomina procesobanconomina) throws Exception {
		try {
				procesobanconomina.setId(0L);	
					
				procesobanconomina.setid_banco(-1L);	
				procesobanconomina.setid_cuenta_banco(-1L);	
				procesobanconomina.setid_tipo_contrato(-1L);	
				procesobanconomina.setid_tipo_banco_disco(-1L);	
				procesobanconomina.setcon_otros(false);	
				procesobanconomina.setcon_internet(false);	
				procesobanconomina.setfecha(new Date());	
				procesobanconomina.setnumero_secuenciales(0);	
				procesobanconomina.setgenera_texto(false);	
				procesobanconomina.setgenera_excel(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoBancoNomina(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_IDCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_IDTIPOBANCODISCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_CONOTROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_CONINTERNET);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_NUMEROSECUENCIALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_GENERATEXTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoBancoNominaConstantesFunciones.LABEL_GENERAEXCEL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoBancoNomina(String sTipo,Row row,Workbook workbook,ProcesoBancoNomina procesobanconomina,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesobanconomina.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesobanconomina.getcuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesobanconomina.gettipocontrato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesobanconomina.gettipobancodisco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesobanconomina.getcon_otros()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesobanconomina.getcon_internet()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesobanconomina.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesobanconomina.getnumero_secuenciales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesobanconomina.getgenera_texto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(procesobanconomina.getgenera_excel()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoBancoNomina="";
	
	public String getsFinalQueryProcesoBancoNomina() {
		return this.sFinalQueryProcesoBancoNomina;
	}
	
	public void setsFinalQueryProcesoBancoNomina(String sFinalQueryProcesoBancoNomina) {
		this.sFinalQueryProcesoBancoNomina= sFinalQueryProcesoBancoNomina;
	}
	
	public Border resaltarSeleccionarProcesoBancoNomina=null;
	
	public Border setResaltarSeleccionarProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoBancoNomina= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoBancoNomina() {
		return this.resaltarSeleccionarProcesoBancoNomina;
	}
	
	public void setResaltarSeleccionarProcesoBancoNomina(Border borderResaltarSeleccionarProcesoBancoNomina) {
		this.resaltarSeleccionarProcesoBancoNomina= borderResaltarSeleccionarProcesoBancoNomina;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoBancoNomina=null;
	public Boolean mostraridProcesoBancoNomina=true;
	public Boolean activaridProcesoBancoNomina=true;

	public Border resaltarid_bancoProcesoBancoNomina=null;
	public Boolean mostrarid_bancoProcesoBancoNomina=true;
	public Boolean activarid_bancoProcesoBancoNomina=true;
	public Boolean cargarid_bancoProcesoBancoNomina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoProcesoBancoNomina=false;//ConEventDepend=true

	public Border resaltarid_cuenta_bancoProcesoBancoNomina=null;
	public Boolean mostrarid_cuenta_bancoProcesoBancoNomina=true;
	public Boolean activarid_cuenta_bancoProcesoBancoNomina=true;
	public Boolean cargarid_cuenta_bancoProcesoBancoNomina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_bancoProcesoBancoNomina=false;//ConEventDepend=true

	public Border resaltarid_tipo_contratoProcesoBancoNomina=null;
	public Boolean mostrarid_tipo_contratoProcesoBancoNomina=true;
	public Boolean activarid_tipo_contratoProcesoBancoNomina=true;
	public Boolean cargarid_tipo_contratoProcesoBancoNomina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_contratoProcesoBancoNomina=false;//ConEventDepend=true

	public Border resaltarid_tipo_banco_discoProcesoBancoNomina=null;
	public Boolean mostrarid_tipo_banco_discoProcesoBancoNomina=true;
	public Boolean activarid_tipo_banco_discoProcesoBancoNomina=true;
	public Boolean cargarid_tipo_banco_discoProcesoBancoNomina=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_banco_discoProcesoBancoNomina=false;//ConEventDepend=true

	public Border resaltarcon_otrosProcesoBancoNomina=null;
	public Boolean mostrarcon_otrosProcesoBancoNomina=true;
	public Boolean activarcon_otrosProcesoBancoNomina=true;

	public Border resaltarcon_internetProcesoBancoNomina=null;
	public Boolean mostrarcon_internetProcesoBancoNomina=true;
	public Boolean activarcon_internetProcesoBancoNomina=true;

	public Border resaltarfechaProcesoBancoNomina=null;
	public Boolean mostrarfechaProcesoBancoNomina=true;
	public Boolean activarfechaProcesoBancoNomina=true;

	public Border resaltarnumero_secuencialesProcesoBancoNomina=null;
	public Boolean mostrarnumero_secuencialesProcesoBancoNomina=true;
	public Boolean activarnumero_secuencialesProcesoBancoNomina=true;

	public Border resaltargenera_textoProcesoBancoNomina=null;
	public Boolean mostrargenera_textoProcesoBancoNomina=true;
	public Boolean activargenera_textoProcesoBancoNomina=true;

	public Border resaltargenera_excelProcesoBancoNomina=null;
	public Boolean mostrargenera_excelProcesoBancoNomina=true;
	public Boolean activargenera_excelProcesoBancoNomina=true;

	
	

	public Border setResaltaridProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltaridProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoBancoNomina() {
		return this.resaltaridProcesoBancoNomina;
	}

	public void setResaltaridProcesoBancoNomina(Border borderResaltar) {
		this.resaltaridProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostraridProcesoBancoNomina() {
		return this.mostraridProcesoBancoNomina;
	}

	public void setMostraridProcesoBancoNomina(Boolean mostraridProcesoBancoNomina) {
		this.mostraridProcesoBancoNomina= mostraridProcesoBancoNomina;
	}

	public Boolean getActivaridProcesoBancoNomina() {
		return this.activaridProcesoBancoNomina;
	}

	public void setActivaridProcesoBancoNomina(Boolean activaridProcesoBancoNomina) {
		this.activaridProcesoBancoNomina= activaridProcesoBancoNomina;
	}

	public Border setResaltarid_bancoProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarid_bancoProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoProcesoBancoNomina() {
		return this.resaltarid_bancoProcesoBancoNomina;
	}

	public void setResaltarid_bancoProcesoBancoNomina(Border borderResaltar) {
		this.resaltarid_bancoProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarid_bancoProcesoBancoNomina() {
		return this.mostrarid_bancoProcesoBancoNomina;
	}

	public void setMostrarid_bancoProcesoBancoNomina(Boolean mostrarid_bancoProcesoBancoNomina) {
		this.mostrarid_bancoProcesoBancoNomina= mostrarid_bancoProcesoBancoNomina;
	}

	public Boolean getActivarid_bancoProcesoBancoNomina() {
		return this.activarid_bancoProcesoBancoNomina;
	}

	public void setActivarid_bancoProcesoBancoNomina(Boolean activarid_bancoProcesoBancoNomina) {
		this.activarid_bancoProcesoBancoNomina= activarid_bancoProcesoBancoNomina;
	}

	public Boolean getCargarid_bancoProcesoBancoNomina() {
		return this.cargarid_bancoProcesoBancoNomina;
	}

	public void setCargarid_bancoProcesoBancoNomina(Boolean cargarid_bancoProcesoBancoNomina) {
		this.cargarid_bancoProcesoBancoNomina= cargarid_bancoProcesoBancoNomina;
	}

	public Border setResaltarid_cuenta_bancoProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_bancoProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_bancoProcesoBancoNomina() {
		return this.resaltarid_cuenta_bancoProcesoBancoNomina;
	}

	public void setResaltarid_cuenta_bancoProcesoBancoNomina(Border borderResaltar) {
		this.resaltarid_cuenta_bancoProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_bancoProcesoBancoNomina() {
		return this.mostrarid_cuenta_bancoProcesoBancoNomina;
	}

	public void setMostrarid_cuenta_bancoProcesoBancoNomina(Boolean mostrarid_cuenta_bancoProcesoBancoNomina) {
		this.mostrarid_cuenta_bancoProcesoBancoNomina= mostrarid_cuenta_bancoProcesoBancoNomina;
	}

	public Boolean getActivarid_cuenta_bancoProcesoBancoNomina() {
		return this.activarid_cuenta_bancoProcesoBancoNomina;
	}

	public void setActivarid_cuenta_bancoProcesoBancoNomina(Boolean activarid_cuenta_bancoProcesoBancoNomina) {
		this.activarid_cuenta_bancoProcesoBancoNomina= activarid_cuenta_bancoProcesoBancoNomina;
	}

	public Boolean getCargarid_cuenta_bancoProcesoBancoNomina() {
		return this.cargarid_cuenta_bancoProcesoBancoNomina;
	}

	public void setCargarid_cuenta_bancoProcesoBancoNomina(Boolean cargarid_cuenta_bancoProcesoBancoNomina) {
		this.cargarid_cuenta_bancoProcesoBancoNomina= cargarid_cuenta_bancoProcesoBancoNomina;
	}

	public Border setResaltarid_tipo_contratoProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_contratoProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_contratoProcesoBancoNomina() {
		return this.resaltarid_tipo_contratoProcesoBancoNomina;
	}

	public void setResaltarid_tipo_contratoProcesoBancoNomina(Border borderResaltar) {
		this.resaltarid_tipo_contratoProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_contratoProcesoBancoNomina() {
		return this.mostrarid_tipo_contratoProcesoBancoNomina;
	}

	public void setMostrarid_tipo_contratoProcesoBancoNomina(Boolean mostrarid_tipo_contratoProcesoBancoNomina) {
		this.mostrarid_tipo_contratoProcesoBancoNomina= mostrarid_tipo_contratoProcesoBancoNomina;
	}

	public Boolean getActivarid_tipo_contratoProcesoBancoNomina() {
		return this.activarid_tipo_contratoProcesoBancoNomina;
	}

	public void setActivarid_tipo_contratoProcesoBancoNomina(Boolean activarid_tipo_contratoProcesoBancoNomina) {
		this.activarid_tipo_contratoProcesoBancoNomina= activarid_tipo_contratoProcesoBancoNomina;
	}

	public Boolean getCargarid_tipo_contratoProcesoBancoNomina() {
		return this.cargarid_tipo_contratoProcesoBancoNomina;
	}

	public void setCargarid_tipo_contratoProcesoBancoNomina(Boolean cargarid_tipo_contratoProcesoBancoNomina) {
		this.cargarid_tipo_contratoProcesoBancoNomina= cargarid_tipo_contratoProcesoBancoNomina;
	}

	public Border setResaltarid_tipo_banco_discoProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarid_tipo_banco_discoProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_banco_discoProcesoBancoNomina() {
		return this.resaltarid_tipo_banco_discoProcesoBancoNomina;
	}

	public void setResaltarid_tipo_banco_discoProcesoBancoNomina(Border borderResaltar) {
		this.resaltarid_tipo_banco_discoProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarid_tipo_banco_discoProcesoBancoNomina() {
		return this.mostrarid_tipo_banco_discoProcesoBancoNomina;
	}

	public void setMostrarid_tipo_banco_discoProcesoBancoNomina(Boolean mostrarid_tipo_banco_discoProcesoBancoNomina) {
		this.mostrarid_tipo_banco_discoProcesoBancoNomina= mostrarid_tipo_banco_discoProcesoBancoNomina;
	}

	public Boolean getActivarid_tipo_banco_discoProcesoBancoNomina() {
		return this.activarid_tipo_banco_discoProcesoBancoNomina;
	}

	public void setActivarid_tipo_banco_discoProcesoBancoNomina(Boolean activarid_tipo_banco_discoProcesoBancoNomina) {
		this.activarid_tipo_banco_discoProcesoBancoNomina= activarid_tipo_banco_discoProcesoBancoNomina;
	}

	public Boolean getCargarid_tipo_banco_discoProcesoBancoNomina() {
		return this.cargarid_tipo_banco_discoProcesoBancoNomina;
	}

	public void setCargarid_tipo_banco_discoProcesoBancoNomina(Boolean cargarid_tipo_banco_discoProcesoBancoNomina) {
		this.cargarid_tipo_banco_discoProcesoBancoNomina= cargarid_tipo_banco_discoProcesoBancoNomina;
	}

	public Border setResaltarcon_otrosProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarcon_otrosProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_otrosProcesoBancoNomina() {
		return this.resaltarcon_otrosProcesoBancoNomina;
	}

	public void setResaltarcon_otrosProcesoBancoNomina(Border borderResaltar) {
		this.resaltarcon_otrosProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarcon_otrosProcesoBancoNomina() {
		return this.mostrarcon_otrosProcesoBancoNomina;
	}

	public void setMostrarcon_otrosProcesoBancoNomina(Boolean mostrarcon_otrosProcesoBancoNomina) {
		this.mostrarcon_otrosProcesoBancoNomina= mostrarcon_otrosProcesoBancoNomina;
	}

	public Boolean getActivarcon_otrosProcesoBancoNomina() {
		return this.activarcon_otrosProcesoBancoNomina;
	}

	public void setActivarcon_otrosProcesoBancoNomina(Boolean activarcon_otrosProcesoBancoNomina) {
		this.activarcon_otrosProcesoBancoNomina= activarcon_otrosProcesoBancoNomina;
	}

	public Border setResaltarcon_internetProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarcon_internetProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_internetProcesoBancoNomina() {
		return this.resaltarcon_internetProcesoBancoNomina;
	}

	public void setResaltarcon_internetProcesoBancoNomina(Border borderResaltar) {
		this.resaltarcon_internetProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarcon_internetProcesoBancoNomina() {
		return this.mostrarcon_internetProcesoBancoNomina;
	}

	public void setMostrarcon_internetProcesoBancoNomina(Boolean mostrarcon_internetProcesoBancoNomina) {
		this.mostrarcon_internetProcesoBancoNomina= mostrarcon_internetProcesoBancoNomina;
	}

	public Boolean getActivarcon_internetProcesoBancoNomina() {
		return this.activarcon_internetProcesoBancoNomina;
	}

	public void setActivarcon_internetProcesoBancoNomina(Boolean activarcon_internetProcesoBancoNomina) {
		this.activarcon_internetProcesoBancoNomina= activarcon_internetProcesoBancoNomina;
	}

	public Border setResaltarfechaProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoBancoNomina() {
		return this.resaltarfechaProcesoBancoNomina;
	}

	public void setResaltarfechaProcesoBancoNomina(Border borderResaltar) {
		this.resaltarfechaProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoBancoNomina() {
		return this.mostrarfechaProcesoBancoNomina;
	}

	public void setMostrarfechaProcesoBancoNomina(Boolean mostrarfechaProcesoBancoNomina) {
		this.mostrarfechaProcesoBancoNomina= mostrarfechaProcesoBancoNomina;
	}

	public Boolean getActivarfechaProcesoBancoNomina() {
		return this.activarfechaProcesoBancoNomina;
	}

	public void setActivarfechaProcesoBancoNomina(Boolean activarfechaProcesoBancoNomina) {
		this.activarfechaProcesoBancoNomina= activarfechaProcesoBancoNomina;
	}

	public Border setResaltarnumero_secuencialesProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialesProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialesProcesoBancoNomina() {
		return this.resaltarnumero_secuencialesProcesoBancoNomina;
	}

	public void setResaltarnumero_secuencialesProcesoBancoNomina(Border borderResaltar) {
		this.resaltarnumero_secuencialesProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialesProcesoBancoNomina() {
		return this.mostrarnumero_secuencialesProcesoBancoNomina;
	}

	public void setMostrarnumero_secuencialesProcesoBancoNomina(Boolean mostrarnumero_secuencialesProcesoBancoNomina) {
		this.mostrarnumero_secuencialesProcesoBancoNomina= mostrarnumero_secuencialesProcesoBancoNomina;
	}

	public Boolean getActivarnumero_secuencialesProcesoBancoNomina() {
		return this.activarnumero_secuencialesProcesoBancoNomina;
	}

	public void setActivarnumero_secuencialesProcesoBancoNomina(Boolean activarnumero_secuencialesProcesoBancoNomina) {
		this.activarnumero_secuencialesProcesoBancoNomina= activarnumero_secuencialesProcesoBancoNomina;
	}

	public Border setResaltargenera_textoProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltargenera_textoProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargenera_textoProcesoBancoNomina() {
		return this.resaltargenera_textoProcesoBancoNomina;
	}

	public void setResaltargenera_textoProcesoBancoNomina(Border borderResaltar) {
		this.resaltargenera_textoProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrargenera_textoProcesoBancoNomina() {
		return this.mostrargenera_textoProcesoBancoNomina;
	}

	public void setMostrargenera_textoProcesoBancoNomina(Boolean mostrargenera_textoProcesoBancoNomina) {
		this.mostrargenera_textoProcesoBancoNomina= mostrargenera_textoProcesoBancoNomina;
	}

	public Boolean getActivargenera_textoProcesoBancoNomina() {
		return this.activargenera_textoProcesoBancoNomina;
	}

	public void setActivargenera_textoProcesoBancoNomina(Boolean activargenera_textoProcesoBancoNomina) {
		this.activargenera_textoProcesoBancoNomina= activargenera_textoProcesoBancoNomina;
	}

	public Border setResaltargenera_excelProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesobanconominaBeanSwingJInternalFrame.jTtoolBarProcesoBancoNomina.setBorder(borderResaltar);
		
		this.resaltargenera_excelProcesoBancoNomina= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargenera_excelProcesoBancoNomina() {
		return this.resaltargenera_excelProcesoBancoNomina;
	}

	public void setResaltargenera_excelProcesoBancoNomina(Border borderResaltar) {
		this.resaltargenera_excelProcesoBancoNomina= borderResaltar;
	}

	public Boolean getMostrargenera_excelProcesoBancoNomina() {
		return this.mostrargenera_excelProcesoBancoNomina;
	}

	public void setMostrargenera_excelProcesoBancoNomina(Boolean mostrargenera_excelProcesoBancoNomina) {
		this.mostrargenera_excelProcesoBancoNomina= mostrargenera_excelProcesoBancoNomina;
	}

	public Boolean getActivargenera_excelProcesoBancoNomina() {
		return this.activargenera_excelProcesoBancoNomina;
	}

	public void setActivargenera_excelProcesoBancoNomina(Boolean activargenera_excelProcesoBancoNomina) {
		this.activargenera_excelProcesoBancoNomina= activargenera_excelProcesoBancoNomina;
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
		
		
		this.setMostraridProcesoBancoNomina(esInicial);
		this.setMostrarid_bancoProcesoBancoNomina(esInicial);
		this.setMostrarid_cuenta_bancoProcesoBancoNomina(esInicial);
		this.setMostrarid_tipo_contratoProcesoBancoNomina(esInicial);
		this.setMostrarid_tipo_banco_discoProcesoBancoNomina(esInicial);
		this.setMostrarcon_otrosProcesoBancoNomina(esInicial);
		this.setMostrarcon_internetProcesoBancoNomina(esInicial);
		this.setMostrarfechaProcesoBancoNomina(esInicial);
		this.setMostrarnumero_secuencialesProcesoBancoNomina(esInicial);
		this.setMostrargenera_textoProcesoBancoNomina(esInicial);
		this.setMostrargenera_excelProcesoBancoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.ID)) {
				this.setMostraridProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO)) {
				this.setMostrarid_cuenta_bancoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO)) {
				this.setMostrarid_tipo_contratoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO)) {
				this.setMostrarid_tipo_banco_discoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.CONOTROS)) {
				this.setMostrarcon_otrosProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.CONINTERNET)) {
				this.setMostrarcon_internetProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES)) {
				this.setMostrarnumero_secuencialesProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.GENERATEXTO)) {
				this.setMostrargenera_textoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.GENERAEXCEL)) {
				this.setMostrargenera_excelProcesoBancoNomina(esAsigna);
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
		
		
		this.setActivaridProcesoBancoNomina(esInicial);
		this.setActivarid_bancoProcesoBancoNomina(esInicial);
		this.setActivarid_cuenta_bancoProcesoBancoNomina(esInicial);
		this.setActivarid_tipo_contratoProcesoBancoNomina(esInicial);
		this.setActivarid_tipo_banco_discoProcesoBancoNomina(esInicial);
		this.setActivarcon_otrosProcesoBancoNomina(esInicial);
		this.setActivarcon_internetProcesoBancoNomina(esInicial);
		this.setActivarfechaProcesoBancoNomina(esInicial);
		this.setActivarnumero_secuencialesProcesoBancoNomina(esInicial);
		this.setActivargenera_textoProcesoBancoNomina(esInicial);
		this.setActivargenera_excelProcesoBancoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.ID)) {
				this.setActivaridProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO)) {
				this.setActivarid_cuenta_bancoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO)) {
				this.setActivarid_tipo_contratoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO)) {
				this.setActivarid_tipo_banco_discoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.CONOTROS)) {
				this.setActivarcon_otrosProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.CONINTERNET)) {
				this.setActivarcon_internetProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES)) {
				this.setActivarnumero_secuencialesProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.GENERATEXTO)) {
				this.setActivargenera_textoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.GENERAEXCEL)) {
				this.setActivargenera_excelProcesoBancoNomina(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoBancoNomina(esInicial);
		this.setResaltarid_bancoProcesoBancoNomina(esInicial);
		this.setResaltarid_cuenta_bancoProcesoBancoNomina(esInicial);
		this.setResaltarid_tipo_contratoProcesoBancoNomina(esInicial);
		this.setResaltarid_tipo_banco_discoProcesoBancoNomina(esInicial);
		this.setResaltarcon_otrosProcesoBancoNomina(esInicial);
		this.setResaltarcon_internetProcesoBancoNomina(esInicial);
		this.setResaltarfechaProcesoBancoNomina(esInicial);
		this.setResaltarnumero_secuencialesProcesoBancoNomina(esInicial);
		this.setResaltargenera_textoProcesoBancoNomina(esInicial);
		this.setResaltargenera_excelProcesoBancoNomina(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.ID)) {
				this.setResaltaridProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDCUENTABANCO)) {
				this.setResaltarid_cuenta_bancoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOCONTRATO)) {
				this.setResaltarid_tipo_contratoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.IDTIPOBANCODISCO)) {
				this.setResaltarid_tipo_banco_discoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.CONOTROS)) {
				this.setResaltarcon_otrosProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.CONINTERNET)) {
				this.setResaltarcon_internetProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.NUMEROSECUENCIALES)) {
				this.setResaltarnumero_secuencialesProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.GENERATEXTO)) {
				this.setResaltargenera_textoProcesoBancoNomina(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoBancoNominaConstantesFunciones.GENERAEXCEL)) {
				this.setResaltargenera_excelProcesoBancoNomina(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoBancoNominaProcesoBancoNomina=true;

	public Boolean getMostrarBusquedaProcesoBancoNominaProcesoBancoNomina() {
		return this.mostrarBusquedaProcesoBancoNominaProcesoBancoNomina;
	}

	public void setMostrarBusquedaProcesoBancoNominaProcesoBancoNomina(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoBancoNominaProcesoBancoNomina= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoBancoNominaProcesoBancoNomina=true;

	public Boolean getActivarBusquedaProcesoBancoNominaProcesoBancoNomina() {
		return this.activarBusquedaProcesoBancoNominaProcesoBancoNomina;
	}

	public void setActivarBusquedaProcesoBancoNominaProcesoBancoNomina(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoBancoNominaProcesoBancoNomina= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoBancoNominaProcesoBancoNomina=null;

	public Border getResaltarBusquedaProcesoBancoNominaProcesoBancoNomina() {
		return this.resaltarBusquedaProcesoBancoNominaProcesoBancoNomina;
	}

	public void setResaltarBusquedaProcesoBancoNominaProcesoBancoNomina(Border borderResaltar) {
		this.resaltarBusquedaProcesoBancoNominaProcesoBancoNomina= borderResaltar;
	}

	public void setResaltarBusquedaProcesoBancoNominaProcesoBancoNomina(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoBancoNominaBeanSwingJInternalFrame procesobanconominaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoBancoNominaProcesoBancoNomina= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}