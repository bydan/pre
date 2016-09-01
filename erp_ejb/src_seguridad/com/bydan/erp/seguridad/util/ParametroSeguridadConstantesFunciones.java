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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.ParametroSeguridadConstantesFunciones;
import com.bydan.erp.seguridad.util.ParametroSeguridadParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParametroSeguridadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroSeguridadConstantesFunciones extends ParametroSeguridadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroSeguridad";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroSeguridad"+ParametroSeguridadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroSeguridadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroSeguridadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroSeguridadConstantesFunciones.SCHEMA+"_"+ParametroSeguridadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroSeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroSeguridadConstantesFunciones.SCHEMA+"_"+ParametroSeguridadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroSeguridadConstantesFunciones.SCHEMA+"_"+ParametroSeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroSeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroSeguridadConstantesFunciones.SCHEMA+"_"+ParametroSeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroSeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroSeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroSeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroSeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroSeguridadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroSeguridadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroSeguridadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroSeguridadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroSeguridadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroSeguridadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Seguridades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro Seguridad";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Seguridad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroSeguridad";
	public static final String OBJECTNAME="parametroseguridad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="parametro_seguridad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroseguridad from "+ParametroSeguridadConstantesFunciones.SPERSISTENCENAME+" parametroseguridad";
	public static String QUERYSELECTNATIVE="select "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".id,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".version_row,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".id_empresa,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_cartera,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_copiar_clientes,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_copiar_proveedores,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_generar_cliente_prove,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".cliente_con_secuencial_auto,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".cliente_num_maximo_iniciales,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".prove_con_secuencial_auto,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".prove_num_maximo_iniciales,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_validar_grupos,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".acti_fijo_con_secuencial_auto from "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME;//+" as "+ParametroSeguridadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroSeguridadConstantesFuncionesAdditional parametroseguridadConstantesFuncionesAdditional=null;
	
	public ParametroSeguridadConstantesFuncionesAdditional getParametroSeguridadConstantesFuncionesAdditional() {
		return this.parametroseguridadConstantesFuncionesAdditional;
	}
	
	public void setParametroSeguridadConstantesFuncionesAdditional(ParametroSeguridadConstantesFuncionesAdditional parametroseguridadConstantesFuncionesAdditional) {
		try {
			this.parametroseguridadConstantesFuncionesAdditional=parametroseguridadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CONCARTERA= "con_cartera";
    public static final String CONCOPIARCLIENTES= "con_copiar_clientes";
    public static final String CONCOPIARPROVEEDORES= "con_copiar_proveedores";
    public static final String CONGENERARCLIENTEPROVE= "con_generar_cliente_prove";
    public static final String CLIENTECONSECUENCIALAUTO= "cliente_con_secuencial_auto";
    public static final String CLIENTENUMMAXIMOINICIALES= "cliente_num_maximo_iniciales";
    public static final String PROVECONSECUENCIALAUTO= "prove_con_secuencial_auto";
    public static final String PROVENUMMAXIMOINICIALES= "prove_num_maximo_iniciales";
    public static final String CONVALIDARGRUPOS= "con_validar_grupos";
    public static final String ACTIFIJOCONSECUENCIALAUTO= "acti_fijo_con_secuencial_auto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CONCARTERA= "Cartera";
		public static final String LABEL_CONCARTERA_LOWER= "Con Cartera";
    	public static final String LABEL_CONCOPIARCLIENTES= "Copiar Clientes";
		public static final String LABEL_CONCOPIARCLIENTES_LOWER= "Con Copiar Clientes";
    	public static final String LABEL_CONCOPIARPROVEEDORES= "Copiar Proveedores";
		public static final String LABEL_CONCOPIARPROVEEDORES_LOWER= "Con Copiar Proveedores";
    	public static final String LABEL_CONGENERARCLIENTEPROVE= "Generar Clientes-Proveedores";
		public static final String LABEL_CONGENERARCLIENTEPROVE_LOWER= "Con Generar Cliente Prove";
    	public static final String LABEL_CLIENTECONSECUENCIALAUTO= "Secuencial Automa.";
		public static final String LABEL_CLIENTECONSECUENCIALAUTO_LOWER= "Cliente Con Secuencial Auto";
    	public static final String LABEL_CLIENTENUMMAXIMOINICIALES= "Numero Maximo Iniciales";
		public static final String LABEL_CLIENTENUMMAXIMOINICIALES_LOWER= "Cliente Num Maximo Iniciales";
    	public static final String LABEL_PROVECONSECUENCIALAUTO= "Secuencial Automatico";
		public static final String LABEL_PROVECONSECUENCIALAUTO_LOWER= "Prove Con Secuencial Auto";
    	public static final String LABEL_PROVENUMMAXIMOINICIALES= "Numero Maximo Iniciales.";
		public static final String LABEL_PROVENUMMAXIMOINICIALES_LOWER= "Prove Num Maximo Iniciales";
    	public static final String LABEL_CONVALIDARGRUPOS= "Validar Grupos";
		public static final String LABEL_CONVALIDARGRUPOS_LOWER= "Con Validar Grupos";
    	public static final String LABEL_ACTIFIJOCONSECUENCIALAUTO= "Activos Fijos Sec. Autom.";
		public static final String LABEL_ACTIFIJOCONSECUENCIALAUTO_LOWER= "Acti Fijo Con Secuencial Auto";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroSeguridadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CONCARTERA)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CONCARTERA;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARCLIENTES;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARPROVEEDORES;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CONGENERARCLIENTEPROVE;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CLIENTECONSECUENCIALAUTO;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CLIENTENUMMAXIMOINICIALES;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_PROVECONSECUENCIALAUTO;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_PROVENUMMAXIMOINICIALES;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_CONVALIDARGRUPOS;}
		if(sNombreColumna.equals(ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO)) {sLabelColumna=ParametroSeguridadConstantesFunciones.LABEL_ACTIFIJOCONSECUENCIALAUTO;}
		
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
	
	
	
			
			
			
		
	public static String getcon_carteraDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getcon_cartera()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_carteraHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getcon_cartera());

		return sDescripcion;
	}	
		
	public static String getcon_copiar_clientesDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getcon_copiar_clientes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_copiar_clientesHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getcon_copiar_clientes());

		return sDescripcion;
	}	
		
	public static String getcon_copiar_proveedoresDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getcon_copiar_proveedores()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_copiar_proveedoresHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getcon_copiar_proveedores());

		return sDescripcion;
	}	
		
	public static String getcon_generar_cliente_proveDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getcon_generar_cliente_prove()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_generar_cliente_proveHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getcon_generar_cliente_prove());

		return sDescripcion;
	}	
		
	public static String getcliente_con_secuencial_autoDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getcliente_con_secuencial_auto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcliente_con_secuencial_autoHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getcliente_con_secuencial_auto());

		return sDescripcion;
	}	
			
		
	public static String getprove_con_secuencial_autoDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getprove_con_secuencial_auto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getprove_con_secuencial_autoHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getprove_con_secuencial_auto());

		return sDescripcion;
	}	
			
		
	public static String getcon_validar_gruposDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getcon_validar_grupos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_validar_gruposHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getcon_validar_grupos());

		return sDescripcion;
	}	
		
	public static String getacti_fijo_con_secuencial_autoDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroseguridad.getacti_fijo_con_secuencial_auto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getacti_fijo_con_secuencial_autoHtmlDescripcion(ParametroSeguridad parametroseguridad) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroseguridad.getId(),parametroseguridad.getacti_fijo_con_secuencial_auto());

		return sDescripcion;
	}	
	
	public static String getParametroSeguridadDescripcion(ParametroSeguridad parametroseguridad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroseguridad !=null/* && parametroseguridad.getId()!=0*/) {
			if(parametroseguridad.getId()!=null) {
				sDescripcion=parametroseguridad.getId().toString();
			}//parametroseguridadparametroseguridad.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroSeguridadDescripcionDetallado(ParametroSeguridad parametroseguridad) {
		String sDescripcion="";
			
		sDescripcion+=ParametroSeguridadConstantesFunciones.ID+"=";
		sDescripcion+=parametroseguridad.getId().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroseguridad.getVersionRow().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroseguridad.getid_empresa().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CONCARTERA+"=";
		sDescripcion+=parametroseguridad.getcon_cartera().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES+"=";
		sDescripcion+=parametroseguridad.getcon_copiar_clientes().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES+"=";
		sDescripcion+=parametroseguridad.getcon_copiar_proveedores().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE+"=";
		sDescripcion+=parametroseguridad.getcon_generar_cliente_prove().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO+"=";
		sDescripcion+=parametroseguridad.getcliente_con_secuencial_auto().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES+"=";
		sDescripcion+=parametroseguridad.getcliente_num_maximo_iniciales().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO+"=";
		sDescripcion+=parametroseguridad.getprove_con_secuencial_auto().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES+"=";
		sDescripcion+=parametroseguridad.getprove_num_maximo_iniciales().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS+"=";
		sDescripcion+=parametroseguridad.getcon_validar_grupos().toString()+",";
		sDescripcion+=ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO+"=";
		sDescripcion+=parametroseguridad.getacti_fijo_con_secuencial_auto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroSeguridadDescripcion(ParametroSeguridad parametroseguridad,String sValor) throws Exception {			
		if(parametroseguridad !=null) {
			//parametroseguridadparametroseguridad.getId().toString();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroSeguridad(ParametroSeguridad parametroseguridad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroSeguridads(List<ParametroSeguridad> parametroseguridads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroSeguridad parametroseguridad: parametroseguridads) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroSeguridad(ParametroSeguridad parametroseguridad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroseguridad.getConCambioAuxiliar()) {
			parametroseguridad.setIsDeleted(parametroseguridad.getIsDeletedAuxiliar());	
			parametroseguridad.setIsNew(parametroseguridad.getIsNewAuxiliar());	
			parametroseguridad.setIsChanged(parametroseguridad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroseguridad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroseguridad.setIsDeletedAuxiliar(false);	
			parametroseguridad.setIsNewAuxiliar(false);	
			parametroseguridad.setIsChangedAuxiliar(false);
			
			parametroseguridad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroSeguridads(List<ParametroSeguridad> parametroseguridads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroSeguridad parametroseguridad : parametroseguridads) {
			if(conAsignarBase && parametroseguridad.getConCambioAuxiliar()) {
				parametroseguridad.setIsDeleted(parametroseguridad.getIsDeletedAuxiliar());	
				parametroseguridad.setIsNew(parametroseguridad.getIsNewAuxiliar());	
				parametroseguridad.setIsChanged(parametroseguridad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroseguridad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroseguridad.setIsDeletedAuxiliar(false);	
				parametroseguridad.setIsNewAuxiliar(false);	
				parametroseguridad.setIsChangedAuxiliar(false);
				
				parametroseguridad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroSeguridad(ParametroSeguridad parametroseguridad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametroseguridad.setcliente_num_maximo_iniciales(0);
			parametroseguridad.setprove_num_maximo_iniciales(0);
		}
	}		
	
	public static void InicializarValoresParametroSeguridads(List<ParametroSeguridad> parametroseguridads,Boolean conEnteros) throws Exception  {
		
		for(ParametroSeguridad parametroseguridad: parametroseguridads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametroseguridad.setcliente_num_maximo_iniciales(0);
				parametroseguridad.setprove_num_maximo_iniciales(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroSeguridad(List<ParametroSeguridad> parametroseguridads,ParametroSeguridad parametroseguridadAux) throws Exception  {
		ParametroSeguridadConstantesFunciones.InicializarValoresParametroSeguridad(parametroseguridadAux,true);
		
		for(ParametroSeguridad parametroseguridad: parametroseguridads) {
			if(parametroseguridad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametroseguridadAux.setcliente_num_maximo_iniciales(parametroseguridadAux.getcliente_num_maximo_iniciales()+parametroseguridad.getcliente_num_maximo_iniciales());			
			parametroseguridadAux.setprove_num_maximo_iniciales(parametroseguridadAux.getprove_num_maximo_iniciales()+parametroseguridad.getprove_num_maximo_iniciales());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroSeguridad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroSeguridadConstantesFunciones.getArrayColumnasGlobalesParametroSeguridad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroSeguridad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroSeguridadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroSeguridadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroSeguridad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroSeguridad> parametroseguridads,ParametroSeguridad parametroseguridad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroSeguridad parametroseguridadAux: parametroseguridads) {
			if(parametroseguridadAux!=null && parametroseguridad!=null) {
				if((parametroseguridadAux.getId()==null && parametroseguridad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroseguridadAux.getId()!=null && parametroseguridad.getId()!=null){
					if(parametroseguridadAux.getId().equals(parametroseguridad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroSeguridad(List<ParametroSeguridad> parametroseguridads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroSeguridad parametroseguridad: parametroseguridads) {			
			if(parametroseguridad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroSeguridad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_ID, ParametroSeguridadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_VERSIONROW, ParametroSeguridadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_IDEMPRESA, ParametroSeguridadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CONCARTERA, ParametroSeguridadConstantesFunciones.CONCARTERA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARCLIENTES, ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARPROVEEDORES, ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CONGENERARCLIENTEPROVE, ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CLIENTECONSECUENCIALAUTO, ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CLIENTENUMMAXIMOINICIALES, ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_PROVECONSECUENCIALAUTO, ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_PROVENUMMAXIMOINICIALES, ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_CONVALIDARGRUPOS, ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroSeguridadConstantesFunciones.LABEL_ACTIFIJOCONSECUENCIALAUTO, ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroSeguridad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CONCARTERA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroSeguridad() throws Exception  {
		return ParametroSeguridadConstantesFunciones.getTiposSeleccionarParametroSeguridad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroSeguridad(Boolean conFk) throws Exception  {
		return ParametroSeguridadConstantesFunciones.getTiposSeleccionarParametroSeguridad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroSeguridad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CONCARTERA);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CONCARTERA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARCLIENTES);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARCLIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARPROVEEDORES);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARPROVEEDORES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CONGENERARCLIENTEPROVE);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CONGENERARCLIENTEPROVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CLIENTECONSECUENCIALAUTO);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CLIENTECONSECUENCIALAUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CLIENTENUMMAXIMOINICIALES);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CLIENTENUMMAXIMOINICIALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_PROVECONSECUENCIALAUTO);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_PROVECONSECUENCIALAUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_PROVENUMMAXIMOINICIALES);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_PROVENUMMAXIMOINICIALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_CONVALIDARGRUPOS);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_CONVALIDARGRUPOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroSeguridadConstantesFunciones.LABEL_ACTIFIJOCONSECUENCIALAUTO);
			reporte.setsDescripcion(ParametroSeguridadConstantesFunciones.LABEL_ACTIFIJOCONSECUENCIALAUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroSeguridad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroSeguridad(ParametroSeguridad parametroseguridadAux) throws Exception {
		
			parametroseguridadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroseguridadAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroSeguridad(List<ParametroSeguridad> parametroseguridadsTemp) throws Exception {
		for(ParametroSeguridad parametroseguridadAux:parametroseguridadsTemp) {
			
			parametroseguridadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroseguridadAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroSeguridad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroSeguridadConstantesFunciones.getClassesRelationshipsOfParametroSeguridad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroSeguridad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroSeguridadConstantesFunciones.getClassesRelationshipsFromStringsOfParametroSeguridad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroSeguridad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroSeguridad parametroseguridad,List<ParametroSeguridad> parametroseguridads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroSeguridad parametroseguridadEncontrado=null;
			
			for(ParametroSeguridad parametroseguridadLocal:parametroseguridads) {
				if(parametroseguridadLocal.getId().equals(parametroseguridad.getId())) {
					parametroseguridadEncontrado=parametroseguridadLocal;
					
					parametroseguridadLocal.setIsChanged(parametroseguridad.getIsChanged());
					parametroseguridadLocal.setIsNew(parametroseguridad.getIsNew());
					parametroseguridadLocal.setIsDeleted(parametroseguridad.getIsDeleted());
					
					parametroseguridadLocal.setGeneralEntityOriginal(parametroseguridad.getGeneralEntityOriginal());
					
					parametroseguridadLocal.setId(parametroseguridad.getId());	
					parametroseguridadLocal.setVersionRow(parametroseguridad.getVersionRow());	
					parametroseguridadLocal.setid_empresa(parametroseguridad.getid_empresa());	
					parametroseguridadLocal.setcon_cartera(parametroseguridad.getcon_cartera());	
					parametroseguridadLocal.setcon_copiar_clientes(parametroseguridad.getcon_copiar_clientes());	
					parametroseguridadLocal.setcon_copiar_proveedores(parametroseguridad.getcon_copiar_proveedores());	
					parametroseguridadLocal.setcon_generar_cliente_prove(parametroseguridad.getcon_generar_cliente_prove());	
					parametroseguridadLocal.setcliente_con_secuencial_auto(parametroseguridad.getcliente_con_secuencial_auto());	
					parametroseguridadLocal.setcliente_num_maximo_iniciales(parametroseguridad.getcliente_num_maximo_iniciales());	
					parametroseguridadLocal.setprove_con_secuencial_auto(parametroseguridad.getprove_con_secuencial_auto());	
					parametroseguridadLocal.setprove_num_maximo_iniciales(parametroseguridad.getprove_num_maximo_iniciales());	
					parametroseguridadLocal.setcon_validar_grupos(parametroseguridad.getcon_validar_grupos());	
					parametroseguridadLocal.setacti_fijo_con_secuencial_auto(parametroseguridad.getacti_fijo_con_secuencial_auto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroseguridad.getIsDeleted()) {
				if(!existe) {
					parametroseguridads.add(parametroseguridad);
				}
			} else {
				if(parametroseguridadEncontrado!=null && permiteQuitar)  {
					parametroseguridads.remove(parametroseguridadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroSeguridad parametroseguridad,List<ParametroSeguridad> parametroseguridads) throws Exception {
		try	{			
			for(ParametroSeguridad parametroseguridadLocal:parametroseguridads) {
				if(parametroseguridadLocal.getId().equals(parametroseguridad.getId())) {
					parametroseguridadLocal.setIsSelected(parametroseguridad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroSeguridad(List<ParametroSeguridad> parametroseguridadsAux) throws Exception {
		//this.parametroseguridadsAux=parametroseguridadsAux;
		
		for(ParametroSeguridad parametroseguridadAux:parametroseguridadsAux) {
			if(parametroseguridadAux.getIsChanged()) {
				parametroseguridadAux.setIsChanged(false);
			}		
			
			if(parametroseguridadAux.getIsNew()) {
				parametroseguridadAux.setIsNew(false);
			}	
			
			if(parametroseguridadAux.getIsDeleted()) {
				parametroseguridadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroSeguridad(ParametroSeguridad parametroseguridadAux) throws Exception {
		//this.parametroseguridadAux=parametroseguridadAux;
		
			if(parametroseguridadAux.getIsChanged()) {
				parametroseguridadAux.setIsChanged(false);
			}		
			
			if(parametroseguridadAux.getIsNew()) {
				parametroseguridadAux.setIsNew(false);
			}	
			
			if(parametroseguridadAux.getIsDeleted()) {
				parametroseguridadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroSeguridad parametroseguridadAsignar,ParametroSeguridad parametroseguridad) throws Exception {
		parametroseguridadAsignar.setId(parametroseguridad.getId());	
		parametroseguridadAsignar.setVersionRow(parametroseguridad.getVersionRow());	
		parametroseguridadAsignar.setid_empresa(parametroseguridad.getid_empresa());
		parametroseguridadAsignar.setempresa_descripcion(parametroseguridad.getempresa_descripcion());	
		parametroseguridadAsignar.setcon_cartera(parametroseguridad.getcon_cartera());	
		parametroseguridadAsignar.setcon_copiar_clientes(parametroseguridad.getcon_copiar_clientes());	
		parametroseguridadAsignar.setcon_copiar_proveedores(parametroseguridad.getcon_copiar_proveedores());	
		parametroseguridadAsignar.setcon_generar_cliente_prove(parametroseguridad.getcon_generar_cliente_prove());	
		parametroseguridadAsignar.setcliente_con_secuencial_auto(parametroseguridad.getcliente_con_secuencial_auto());	
		parametroseguridadAsignar.setcliente_num_maximo_iniciales(parametroseguridad.getcliente_num_maximo_iniciales());	
		parametroseguridadAsignar.setprove_con_secuencial_auto(parametroseguridad.getprove_con_secuencial_auto());	
		parametroseguridadAsignar.setprove_num_maximo_iniciales(parametroseguridad.getprove_num_maximo_iniciales());	
		parametroseguridadAsignar.setcon_validar_grupos(parametroseguridad.getcon_validar_grupos());	
		parametroseguridadAsignar.setacti_fijo_con_secuencial_auto(parametroseguridad.getacti_fijo_con_secuencial_auto());	
	}
	
	public static void inicializarParametroSeguridad(ParametroSeguridad parametroseguridad) throws Exception {
		try {
				parametroseguridad.setId(0L);	
					
				parametroseguridad.setid_empresa(-1L);	
				parametroseguridad.setcon_cartera(false);	
				parametroseguridad.setcon_copiar_clientes(false);	
				parametroseguridad.setcon_copiar_proveedores(false);	
				parametroseguridad.setcon_generar_cliente_prove(false);	
				parametroseguridad.setcliente_con_secuencial_auto(false);	
				parametroseguridad.setcliente_num_maximo_iniciales(0);	
				parametroseguridad.setprove_con_secuencial_auto(false);	
				parametroseguridad.setprove_num_maximo_iniciales(0);	
				parametroseguridad.setcon_validar_grupos(false);	
				parametroseguridad.setacti_fijo_con_secuencial_auto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroSeguridad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CONCARTERA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARCLIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CONCOPIARPROVEEDORES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CONGENERARCLIENTEPROVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CLIENTECONSECUENCIALAUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CLIENTENUMMAXIMOINICIALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_PROVECONSECUENCIALAUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_PROVENUMMAXIMOINICIALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_CONVALIDARGRUPOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroSeguridadConstantesFunciones.LABEL_ACTIFIJOCONSECUENCIALAUTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroSeguridad(String sTipo,Row row,Workbook workbook,ParametroSeguridad parametroseguridad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroseguridad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getcon_cartera()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getcon_copiar_clientes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getcon_copiar_proveedores()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getcon_generar_cliente_prove()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getcliente_con_secuencial_auto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroseguridad.getcliente_num_maximo_iniciales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getprove_con_secuencial_auto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroseguridad.getprove_num_maximo_iniciales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getcon_validar_grupos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroseguridad.getacti_fijo_con_secuencial_auto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroSeguridad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroSeguridad() {
		return this.sFinalQueryParametroSeguridad;
	}
	
	public void setsFinalQueryParametroSeguridad(String sFinalQueryParametroSeguridad) {
		this.sFinalQueryParametroSeguridad= sFinalQueryParametroSeguridad;
	}
	
	public Border resaltarSeleccionarParametroSeguridad=null;
	
	public Border setResaltarSeleccionarParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroSeguridad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroSeguridad() {
		return this.resaltarSeleccionarParametroSeguridad;
	}
	
	public void setResaltarSeleccionarParametroSeguridad(Border borderResaltarSeleccionarParametroSeguridad) {
		this.resaltarSeleccionarParametroSeguridad= borderResaltarSeleccionarParametroSeguridad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroSeguridad=null;
	public Boolean mostraridParametroSeguridad=true;
	public Boolean activaridParametroSeguridad=true;

	public Border resaltarid_empresaParametroSeguridad=null;
	public Boolean mostrarid_empresaParametroSeguridad=true;
	public Boolean activarid_empresaParametroSeguridad=true;
	public Boolean cargarid_empresaParametroSeguridad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroSeguridad=false;//ConEventDepend=true

	public Border resaltarcon_carteraParametroSeguridad=null;
	public Boolean mostrarcon_carteraParametroSeguridad=true;
	public Boolean activarcon_carteraParametroSeguridad=true;

	public Border resaltarcon_copiar_clientesParametroSeguridad=null;
	public Boolean mostrarcon_copiar_clientesParametroSeguridad=true;
	public Boolean activarcon_copiar_clientesParametroSeguridad=true;

	public Border resaltarcon_copiar_proveedoresParametroSeguridad=null;
	public Boolean mostrarcon_copiar_proveedoresParametroSeguridad=true;
	public Boolean activarcon_copiar_proveedoresParametroSeguridad=true;

	public Border resaltarcon_generar_cliente_proveParametroSeguridad=null;
	public Boolean mostrarcon_generar_cliente_proveParametroSeguridad=true;
	public Boolean activarcon_generar_cliente_proveParametroSeguridad=true;

	public Border resaltarcliente_con_secuencial_autoParametroSeguridad=null;
	public Boolean mostrarcliente_con_secuencial_autoParametroSeguridad=true;
	public Boolean activarcliente_con_secuencial_autoParametroSeguridad=true;

	public Border resaltarcliente_num_maximo_inicialesParametroSeguridad=null;
	public Boolean mostrarcliente_num_maximo_inicialesParametroSeguridad=true;
	public Boolean activarcliente_num_maximo_inicialesParametroSeguridad=true;

	public Border resaltarprove_con_secuencial_autoParametroSeguridad=null;
	public Boolean mostrarprove_con_secuencial_autoParametroSeguridad=true;
	public Boolean activarprove_con_secuencial_autoParametroSeguridad=true;

	public Border resaltarprove_num_maximo_inicialesParametroSeguridad=null;
	public Boolean mostrarprove_num_maximo_inicialesParametroSeguridad=true;
	public Boolean activarprove_num_maximo_inicialesParametroSeguridad=true;

	public Border resaltarcon_validar_gruposParametroSeguridad=null;
	public Boolean mostrarcon_validar_gruposParametroSeguridad=true;
	public Boolean activarcon_validar_gruposParametroSeguridad=true;

	public Border resaltaracti_fijo_con_secuencial_autoParametroSeguridad=null;
	public Boolean mostraracti_fijo_con_secuencial_autoParametroSeguridad=true;
	public Boolean activaracti_fijo_con_secuencial_autoParametroSeguridad=true;

	
	

	public Border setResaltaridParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltaridParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroSeguridad() {
		return this.resaltaridParametroSeguridad;
	}

	public void setResaltaridParametroSeguridad(Border borderResaltar) {
		this.resaltaridParametroSeguridad= borderResaltar;
	}

	public Boolean getMostraridParametroSeguridad() {
		return this.mostraridParametroSeguridad;
	}

	public void setMostraridParametroSeguridad(Boolean mostraridParametroSeguridad) {
		this.mostraridParametroSeguridad= mostraridParametroSeguridad;
	}

	public Boolean getActivaridParametroSeguridad() {
		return this.activaridParametroSeguridad;
	}

	public void setActivaridParametroSeguridad(Boolean activaridParametroSeguridad) {
		this.activaridParametroSeguridad= activaridParametroSeguridad;
	}

	public Border setResaltarid_empresaParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroSeguridad() {
		return this.resaltarid_empresaParametroSeguridad;
	}

	public void setResaltarid_empresaParametroSeguridad(Border borderResaltar) {
		this.resaltarid_empresaParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroSeguridad() {
		return this.mostrarid_empresaParametroSeguridad;
	}

	public void setMostrarid_empresaParametroSeguridad(Boolean mostrarid_empresaParametroSeguridad) {
		this.mostrarid_empresaParametroSeguridad= mostrarid_empresaParametroSeguridad;
	}

	public Boolean getActivarid_empresaParametroSeguridad() {
		return this.activarid_empresaParametroSeguridad;
	}

	public void setActivarid_empresaParametroSeguridad(Boolean activarid_empresaParametroSeguridad) {
		this.activarid_empresaParametroSeguridad= activarid_empresaParametroSeguridad;
	}

	public Boolean getCargarid_empresaParametroSeguridad() {
		return this.cargarid_empresaParametroSeguridad;
	}

	public void setCargarid_empresaParametroSeguridad(Boolean cargarid_empresaParametroSeguridad) {
		this.cargarid_empresaParametroSeguridad= cargarid_empresaParametroSeguridad;
	}

	public Border setResaltarcon_carteraParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcon_carteraParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_carteraParametroSeguridad() {
		return this.resaltarcon_carteraParametroSeguridad;
	}

	public void setResaltarcon_carteraParametroSeguridad(Border borderResaltar) {
		this.resaltarcon_carteraParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcon_carteraParametroSeguridad() {
		return this.mostrarcon_carteraParametroSeguridad;
	}

	public void setMostrarcon_carteraParametroSeguridad(Boolean mostrarcon_carteraParametroSeguridad) {
		this.mostrarcon_carteraParametroSeguridad= mostrarcon_carteraParametroSeguridad;
	}

	public Boolean getActivarcon_carteraParametroSeguridad() {
		return this.activarcon_carteraParametroSeguridad;
	}

	public void setActivarcon_carteraParametroSeguridad(Boolean activarcon_carteraParametroSeguridad) {
		this.activarcon_carteraParametroSeguridad= activarcon_carteraParametroSeguridad;
	}

	public Border setResaltarcon_copiar_clientesParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcon_copiar_clientesParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_copiar_clientesParametroSeguridad() {
		return this.resaltarcon_copiar_clientesParametroSeguridad;
	}

	public void setResaltarcon_copiar_clientesParametroSeguridad(Border borderResaltar) {
		this.resaltarcon_copiar_clientesParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcon_copiar_clientesParametroSeguridad() {
		return this.mostrarcon_copiar_clientesParametroSeguridad;
	}

	public void setMostrarcon_copiar_clientesParametroSeguridad(Boolean mostrarcon_copiar_clientesParametroSeguridad) {
		this.mostrarcon_copiar_clientesParametroSeguridad= mostrarcon_copiar_clientesParametroSeguridad;
	}

	public Boolean getActivarcon_copiar_clientesParametroSeguridad() {
		return this.activarcon_copiar_clientesParametroSeguridad;
	}

	public void setActivarcon_copiar_clientesParametroSeguridad(Boolean activarcon_copiar_clientesParametroSeguridad) {
		this.activarcon_copiar_clientesParametroSeguridad= activarcon_copiar_clientesParametroSeguridad;
	}

	public Border setResaltarcon_copiar_proveedoresParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcon_copiar_proveedoresParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_copiar_proveedoresParametroSeguridad() {
		return this.resaltarcon_copiar_proveedoresParametroSeguridad;
	}

	public void setResaltarcon_copiar_proveedoresParametroSeguridad(Border borderResaltar) {
		this.resaltarcon_copiar_proveedoresParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcon_copiar_proveedoresParametroSeguridad() {
		return this.mostrarcon_copiar_proveedoresParametroSeguridad;
	}

	public void setMostrarcon_copiar_proveedoresParametroSeguridad(Boolean mostrarcon_copiar_proveedoresParametroSeguridad) {
		this.mostrarcon_copiar_proveedoresParametroSeguridad= mostrarcon_copiar_proveedoresParametroSeguridad;
	}

	public Boolean getActivarcon_copiar_proveedoresParametroSeguridad() {
		return this.activarcon_copiar_proveedoresParametroSeguridad;
	}

	public void setActivarcon_copiar_proveedoresParametroSeguridad(Boolean activarcon_copiar_proveedoresParametroSeguridad) {
		this.activarcon_copiar_proveedoresParametroSeguridad= activarcon_copiar_proveedoresParametroSeguridad;
	}

	public Border setResaltarcon_generar_cliente_proveParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcon_generar_cliente_proveParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_generar_cliente_proveParametroSeguridad() {
		return this.resaltarcon_generar_cliente_proveParametroSeguridad;
	}

	public void setResaltarcon_generar_cliente_proveParametroSeguridad(Border borderResaltar) {
		this.resaltarcon_generar_cliente_proveParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcon_generar_cliente_proveParametroSeguridad() {
		return this.mostrarcon_generar_cliente_proveParametroSeguridad;
	}

	public void setMostrarcon_generar_cliente_proveParametroSeguridad(Boolean mostrarcon_generar_cliente_proveParametroSeguridad) {
		this.mostrarcon_generar_cliente_proveParametroSeguridad= mostrarcon_generar_cliente_proveParametroSeguridad;
	}

	public Boolean getActivarcon_generar_cliente_proveParametroSeguridad() {
		return this.activarcon_generar_cliente_proveParametroSeguridad;
	}

	public void setActivarcon_generar_cliente_proveParametroSeguridad(Boolean activarcon_generar_cliente_proveParametroSeguridad) {
		this.activarcon_generar_cliente_proveParametroSeguridad= activarcon_generar_cliente_proveParametroSeguridad;
	}

	public Border setResaltarcliente_con_secuencial_autoParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcliente_con_secuencial_autoParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcliente_con_secuencial_autoParametroSeguridad() {
		return this.resaltarcliente_con_secuencial_autoParametroSeguridad;
	}

	public void setResaltarcliente_con_secuencial_autoParametroSeguridad(Border borderResaltar) {
		this.resaltarcliente_con_secuencial_autoParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcliente_con_secuencial_autoParametroSeguridad() {
		return this.mostrarcliente_con_secuencial_autoParametroSeguridad;
	}

	public void setMostrarcliente_con_secuencial_autoParametroSeguridad(Boolean mostrarcliente_con_secuencial_autoParametroSeguridad) {
		this.mostrarcliente_con_secuencial_autoParametroSeguridad= mostrarcliente_con_secuencial_autoParametroSeguridad;
	}

	public Boolean getActivarcliente_con_secuencial_autoParametroSeguridad() {
		return this.activarcliente_con_secuencial_autoParametroSeguridad;
	}

	public void setActivarcliente_con_secuencial_autoParametroSeguridad(Boolean activarcliente_con_secuencial_autoParametroSeguridad) {
		this.activarcliente_con_secuencial_autoParametroSeguridad= activarcliente_con_secuencial_autoParametroSeguridad;
	}

	public Border setResaltarcliente_num_maximo_inicialesParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcliente_num_maximo_inicialesParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcliente_num_maximo_inicialesParametroSeguridad() {
		return this.resaltarcliente_num_maximo_inicialesParametroSeguridad;
	}

	public void setResaltarcliente_num_maximo_inicialesParametroSeguridad(Border borderResaltar) {
		this.resaltarcliente_num_maximo_inicialesParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcliente_num_maximo_inicialesParametroSeguridad() {
		return this.mostrarcliente_num_maximo_inicialesParametroSeguridad;
	}

	public void setMostrarcliente_num_maximo_inicialesParametroSeguridad(Boolean mostrarcliente_num_maximo_inicialesParametroSeguridad) {
		this.mostrarcliente_num_maximo_inicialesParametroSeguridad= mostrarcliente_num_maximo_inicialesParametroSeguridad;
	}

	public Boolean getActivarcliente_num_maximo_inicialesParametroSeguridad() {
		return this.activarcliente_num_maximo_inicialesParametroSeguridad;
	}

	public void setActivarcliente_num_maximo_inicialesParametroSeguridad(Boolean activarcliente_num_maximo_inicialesParametroSeguridad) {
		this.activarcliente_num_maximo_inicialesParametroSeguridad= activarcliente_num_maximo_inicialesParametroSeguridad;
	}

	public Border setResaltarprove_con_secuencial_autoParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarprove_con_secuencial_autoParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprove_con_secuencial_autoParametroSeguridad() {
		return this.resaltarprove_con_secuencial_autoParametroSeguridad;
	}

	public void setResaltarprove_con_secuencial_autoParametroSeguridad(Border borderResaltar) {
		this.resaltarprove_con_secuencial_autoParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarprove_con_secuencial_autoParametroSeguridad() {
		return this.mostrarprove_con_secuencial_autoParametroSeguridad;
	}

	public void setMostrarprove_con_secuencial_autoParametroSeguridad(Boolean mostrarprove_con_secuencial_autoParametroSeguridad) {
		this.mostrarprove_con_secuencial_autoParametroSeguridad= mostrarprove_con_secuencial_autoParametroSeguridad;
	}

	public Boolean getActivarprove_con_secuencial_autoParametroSeguridad() {
		return this.activarprove_con_secuencial_autoParametroSeguridad;
	}

	public void setActivarprove_con_secuencial_autoParametroSeguridad(Boolean activarprove_con_secuencial_autoParametroSeguridad) {
		this.activarprove_con_secuencial_autoParametroSeguridad= activarprove_con_secuencial_autoParametroSeguridad;
	}

	public Border setResaltarprove_num_maximo_inicialesParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarprove_num_maximo_inicialesParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprove_num_maximo_inicialesParametroSeguridad() {
		return this.resaltarprove_num_maximo_inicialesParametroSeguridad;
	}

	public void setResaltarprove_num_maximo_inicialesParametroSeguridad(Border borderResaltar) {
		this.resaltarprove_num_maximo_inicialesParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarprove_num_maximo_inicialesParametroSeguridad() {
		return this.mostrarprove_num_maximo_inicialesParametroSeguridad;
	}

	public void setMostrarprove_num_maximo_inicialesParametroSeguridad(Boolean mostrarprove_num_maximo_inicialesParametroSeguridad) {
		this.mostrarprove_num_maximo_inicialesParametroSeguridad= mostrarprove_num_maximo_inicialesParametroSeguridad;
	}

	public Boolean getActivarprove_num_maximo_inicialesParametroSeguridad() {
		return this.activarprove_num_maximo_inicialesParametroSeguridad;
	}

	public void setActivarprove_num_maximo_inicialesParametroSeguridad(Boolean activarprove_num_maximo_inicialesParametroSeguridad) {
		this.activarprove_num_maximo_inicialesParametroSeguridad= activarprove_num_maximo_inicialesParametroSeguridad;
	}

	public Border setResaltarcon_validar_gruposParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltarcon_validar_gruposParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_validar_gruposParametroSeguridad() {
		return this.resaltarcon_validar_gruposParametroSeguridad;
	}

	public void setResaltarcon_validar_gruposParametroSeguridad(Border borderResaltar) {
		this.resaltarcon_validar_gruposParametroSeguridad= borderResaltar;
	}

	public Boolean getMostrarcon_validar_gruposParametroSeguridad() {
		return this.mostrarcon_validar_gruposParametroSeguridad;
	}

	public void setMostrarcon_validar_gruposParametroSeguridad(Boolean mostrarcon_validar_gruposParametroSeguridad) {
		this.mostrarcon_validar_gruposParametroSeguridad= mostrarcon_validar_gruposParametroSeguridad;
	}

	public Boolean getActivarcon_validar_gruposParametroSeguridad() {
		return this.activarcon_validar_gruposParametroSeguridad;
	}

	public void setActivarcon_validar_gruposParametroSeguridad(Boolean activarcon_validar_gruposParametroSeguridad) {
		this.activarcon_validar_gruposParametroSeguridad= activarcon_validar_gruposParametroSeguridad;
	}

	public Border setResaltaracti_fijo_con_secuencial_autoParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroseguridadBeanSwingJInternalFrame.jTtoolBarParametroSeguridad.setBorder(borderResaltar);
		
		this.resaltaracti_fijo_con_secuencial_autoParametroSeguridad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracti_fijo_con_secuencial_autoParametroSeguridad() {
		return this.resaltaracti_fijo_con_secuencial_autoParametroSeguridad;
	}

	public void setResaltaracti_fijo_con_secuencial_autoParametroSeguridad(Border borderResaltar) {
		this.resaltaracti_fijo_con_secuencial_autoParametroSeguridad= borderResaltar;
	}

	public Boolean getMostraracti_fijo_con_secuencial_autoParametroSeguridad() {
		return this.mostraracti_fijo_con_secuencial_autoParametroSeguridad;
	}

	public void setMostraracti_fijo_con_secuencial_autoParametroSeguridad(Boolean mostraracti_fijo_con_secuencial_autoParametroSeguridad) {
		this.mostraracti_fijo_con_secuencial_autoParametroSeguridad= mostraracti_fijo_con_secuencial_autoParametroSeguridad;
	}

	public Boolean getActivaracti_fijo_con_secuencial_autoParametroSeguridad() {
		return this.activaracti_fijo_con_secuencial_autoParametroSeguridad;
	}

	public void setActivaracti_fijo_con_secuencial_autoParametroSeguridad(Boolean activaracti_fijo_con_secuencial_autoParametroSeguridad) {
		this.activaracti_fijo_con_secuencial_autoParametroSeguridad= activaracti_fijo_con_secuencial_autoParametroSeguridad;
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
		
		
		this.setMostraridParametroSeguridad(esInicial);
		this.setMostrarid_empresaParametroSeguridad(esInicial);
		this.setMostrarcon_carteraParametroSeguridad(esInicial);
		this.setMostrarcon_copiar_clientesParametroSeguridad(esInicial);
		this.setMostrarcon_copiar_proveedoresParametroSeguridad(esInicial);
		this.setMostrarcon_generar_cliente_proveParametroSeguridad(esInicial);
		this.setMostrarcliente_con_secuencial_autoParametroSeguridad(esInicial);
		this.setMostrarcliente_num_maximo_inicialesParametroSeguridad(esInicial);
		this.setMostrarprove_con_secuencial_autoParametroSeguridad(esInicial);
		this.setMostrarprove_num_maximo_inicialesParametroSeguridad(esInicial);
		this.setMostrarcon_validar_gruposParametroSeguridad(esInicial);
		this.setMostraracti_fijo_con_secuencial_autoParametroSeguridad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.ID)) {
				this.setMostraridParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCARTERA)) {
				this.setMostrarcon_carteraParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES)) {
				this.setMostrarcon_copiar_clientesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES)) {
				this.setMostrarcon_copiar_proveedoresParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE)) {
				this.setMostrarcon_generar_cliente_proveParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO)) {
				this.setMostrarcliente_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES)) {
				this.setMostrarcliente_num_maximo_inicialesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO)) {
				this.setMostrarprove_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES)) {
				this.setMostrarprove_num_maximo_inicialesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS)) {
				this.setMostrarcon_validar_gruposParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO)) {
				this.setMostraracti_fijo_con_secuencial_autoParametroSeguridad(esAsigna);
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
		
		
		this.setActivaridParametroSeguridad(esInicial);
		this.setActivarid_empresaParametroSeguridad(esInicial);
		this.setActivarcon_carteraParametroSeguridad(esInicial);
		this.setActivarcon_copiar_clientesParametroSeguridad(esInicial);
		this.setActivarcon_copiar_proveedoresParametroSeguridad(esInicial);
		this.setActivarcon_generar_cliente_proveParametroSeguridad(esInicial);
		this.setActivarcliente_con_secuencial_autoParametroSeguridad(esInicial);
		this.setActivarcliente_num_maximo_inicialesParametroSeguridad(esInicial);
		this.setActivarprove_con_secuencial_autoParametroSeguridad(esInicial);
		this.setActivarprove_num_maximo_inicialesParametroSeguridad(esInicial);
		this.setActivarcon_validar_gruposParametroSeguridad(esInicial);
		this.setActivaracti_fijo_con_secuencial_autoParametroSeguridad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.ID)) {
				this.setActivaridParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCARTERA)) {
				this.setActivarcon_carteraParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES)) {
				this.setActivarcon_copiar_clientesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES)) {
				this.setActivarcon_copiar_proveedoresParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE)) {
				this.setActivarcon_generar_cliente_proveParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO)) {
				this.setActivarcliente_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES)) {
				this.setActivarcliente_num_maximo_inicialesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO)) {
				this.setActivarprove_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES)) {
				this.setActivarprove_num_maximo_inicialesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS)) {
				this.setActivarcon_validar_gruposParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO)) {
				this.setActivaracti_fijo_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroSeguridad(esInicial);
		this.setResaltarid_empresaParametroSeguridad(esInicial);
		this.setResaltarcon_carteraParametroSeguridad(esInicial);
		this.setResaltarcon_copiar_clientesParametroSeguridad(esInicial);
		this.setResaltarcon_copiar_proveedoresParametroSeguridad(esInicial);
		this.setResaltarcon_generar_cliente_proveParametroSeguridad(esInicial);
		this.setResaltarcliente_con_secuencial_autoParametroSeguridad(esInicial);
		this.setResaltarcliente_num_maximo_inicialesParametroSeguridad(esInicial);
		this.setResaltarprove_con_secuencial_autoParametroSeguridad(esInicial);
		this.setResaltarprove_num_maximo_inicialesParametroSeguridad(esInicial);
		this.setResaltarcon_validar_gruposParametroSeguridad(esInicial);
		this.setResaltaracti_fijo_con_secuencial_autoParametroSeguridad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.ID)) {
				this.setResaltaridParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCARTERA)) {
				this.setResaltarcon_carteraParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES)) {
				this.setResaltarcon_copiar_clientesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES)) {
				this.setResaltarcon_copiar_proveedoresParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE)) {
				this.setResaltarcon_generar_cliente_proveParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO)) {
				this.setResaltarcliente_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES)) {
				this.setResaltarcliente_num_maximo_inicialesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO)) {
				this.setResaltarprove_con_secuencial_autoParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES)) {
				this.setResaltarprove_num_maximo_inicialesParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS)) {
				this.setResaltarcon_validar_gruposParametroSeguridad(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO)) {
				this.setResaltaracti_fijo_con_secuencial_autoParametroSeguridad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroSeguridad=true;

	public Boolean getMostrarFK_IdEmpresaParametroSeguridad() {
		return this.mostrarFK_IdEmpresaParametroSeguridad;
	}

	public void setMostrarFK_IdEmpresaParametroSeguridad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroSeguridad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroSeguridad=true;

	public Boolean getActivarFK_IdEmpresaParametroSeguridad() {
		return this.activarFK_IdEmpresaParametroSeguridad;
	}

	public void setActivarFK_IdEmpresaParametroSeguridad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroSeguridad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroSeguridad=null;

	public Border getResaltarFK_IdEmpresaParametroSeguridad() {
		return this.resaltarFK_IdEmpresaParametroSeguridad;
	}

	public void setResaltarFK_IdEmpresaParametroSeguridad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroSeguridad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroSeguridad(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroSeguridadBeanSwingJInternalFrame parametroseguridadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroSeguridad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}