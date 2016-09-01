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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.RubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEmpleaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RubroEmpleaConstantesFunciones extends RubroEmpleaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RubroEmplea";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RubroEmplea"+RubroEmpleaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RubroEmpleaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RubroEmpleaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RubroEmpleaConstantesFunciones.SCHEMA+"_"+RubroEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RubroEmpleaConstantesFunciones.SCHEMA+"_"+RubroEmpleaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RubroEmpleaConstantesFunciones.SCHEMA+"_"+RubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RubroEmpleaConstantesFunciones.SCHEMA+"_"+RubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RubroEmpleaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RubroEmpleaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RubroEmpleaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RubroEmpleaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RubroEmpleaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RubroEmpleaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rubro Empleas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Rubro Emplea";
	public static final String SCLASSWEBTITULO_LOWER="Rubro Emplea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RubroEmplea";
	public static final String OBJECTNAME="rubroemplea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rubro_emplea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rubroemplea from "+RubroEmpleaConstantesFunciones.SPERSISTENCENAME+" rubroemplea";
	public static String QUERYSELECTNATIVE="select "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_empresa,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_tipo_calculo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_tipo_rubro_emplea,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".id_tipo_grupo_rubro_emplea,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".codigo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".nombre,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".formula,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".alias,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".secuencial,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_rol_pagos,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_sueldo,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_vacaciones,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_impuesto_renta,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_seguro_social,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_provisiones,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_utilidades,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".para_rubro_iess,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".es_fondo_reserva,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".es_decimo_tercero,"+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME+".es_decimo_cuarto from "+RubroEmpleaConstantesFunciones.SCHEMA+"."+RubroEmpleaConstantesFunciones.TABLENAME;//+" as "+RubroEmpleaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RubroEmpleaConstantesFuncionesAdditional rubroempleaConstantesFuncionesAdditional=null;
	
	public RubroEmpleaConstantesFuncionesAdditional getRubroEmpleaConstantesFuncionesAdditional() {
		return this.rubroempleaConstantesFuncionesAdditional;
	}
	
	public void setRubroEmpleaConstantesFuncionesAdditional(RubroEmpleaConstantesFuncionesAdditional rubroempleaConstantesFuncionesAdditional) {
		try {
			this.rubroempleaConstantesFuncionesAdditional=rubroempleaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOCALCULO= "id_tipo_calculo";
    public static final String IDTIPORUBROEMPLEA= "id_tipo_rubro_emplea";
    public static final String IDTIPOGRUPORUBROEMPLEA= "id_tipo_grupo_rubro_emplea";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FORMULA= "formula";
    public static final String ALIAS= "alias";
    public static final String SECUENCIAL= "secuencial";
    public static final String PARAROLPAGOS= "para_rol_pagos";
    public static final String PARASUELDO= "para_sueldo";
    public static final String PARAVACACIONES= "para_vacaciones";
    public static final String PARAIMPUESTORENTA= "para_impuesto_renta";
    public static final String PARASEGUROSOCIAL= "para_seguro_social";
    public static final String PARAPROVISIONES= "para_provisiones";
    public static final String PARAUTILIDADES= "para_utilidades";
    public static final String PARARUBROIESS= "para_rubro_iess";
    public static final String ESFONDORESERVA= "es_fondo_reserva";
    public static final String ESDECIMOTERCERO= "es_decimo_tercero";
    public static final String ESDECIMOCUARTO= "es_decimo_cuarto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOCALCULO= "Tipo Calculo";
		public static final String LABEL_IDTIPOCALCULO_LOWER= "Tipo Calculo";
    	public static final String LABEL_IDTIPORUBROEMPLEA= "Tipo Rubro Emplea";
		public static final String LABEL_IDTIPORUBROEMPLEA_LOWER= "Tipo Rubro Emplea";
    	public static final String LABEL_IDTIPOGRUPORUBROEMPLEA= "Tipo Grupo Rubro Emplea";
		public static final String LABEL_IDTIPOGRUPORUBROEMPLEA_LOWER= "Tipo Grupo Rubro Emplea";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_FORMULA= "Formula";
		public static final String LABEL_FORMULA_LOWER= "Formula";
    	public static final String LABEL_ALIAS= "Alias";
		public static final String LABEL_ALIAS_LOWER= "Alias";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_PARAROLPAGOS= "Para Rol Pagos";
		public static final String LABEL_PARAROLPAGOS_LOWER= "Para Rol Pagos";
    	public static final String LABEL_PARASUELDO= "Para Sueldo";
		public static final String LABEL_PARASUELDO_LOWER= "Para Sueldo";
    	public static final String LABEL_PARAVACACIONES= "Para Vacaciones";
		public static final String LABEL_PARAVACACIONES_LOWER= "Para Vacaciones";
    	public static final String LABEL_PARAIMPUESTORENTA= "Para Impuesto Renta";
		public static final String LABEL_PARAIMPUESTORENTA_LOWER= "Para Impuesto Renta";
    	public static final String LABEL_PARASEGUROSOCIAL= "Para Seguro Social";
		public static final String LABEL_PARASEGUROSOCIAL_LOWER= "Para Seguro Social";
    	public static final String LABEL_PARAPROVISIONES= "Para Provisiones";
		public static final String LABEL_PARAPROVISIONES_LOWER= "Para Provisiones";
    	public static final String LABEL_PARAUTILIDADES= "Para Utilades";
		public static final String LABEL_PARAUTILIDADES_LOWER= "Para Utilidades";
    	public static final String LABEL_PARARUBROIESS= "Pararubro Iess";
		public static final String LABEL_PARARUBROIESS_LOWER= "para Rubro Iess";
    	public static final String LABEL_ESFONDORESERVA= "Es Fondo Reserva";
		public static final String LABEL_ESFONDORESERVA_LOWER= "Es Fondo Reserva";
    	public static final String LABEL_ESDECIMOTERCERO= "Es Decimo Tercero";
		public static final String LABEL_ESDECIMOTERCERO_LOWER= "Es Decimo Tercero";
    	public static final String LABEL_ESDECIMOCUARTO= "Es Decimo Cuarto";
		public static final String LABEL_ESDECIMOCUARTO_LOWER= "Es Decimo Cuarto";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFORMULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXALIAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXALIAS=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getRubroEmpleaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.IDEMPRESA)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.IDTIPOCALCULO)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_IDTIPOCALCULO;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_IDTIPORUBROEMPLEA;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_IDTIPOGRUPORUBROEMPLEA;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.CODIGO)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.NOMBRE)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.FORMULA)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_FORMULA;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.ALIAS)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_ALIAS;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.SECUENCIAL)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARAROLPAGOS)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARAROLPAGOS;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARASUELDO)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARASUELDO;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARAVACACIONES)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARAVACACIONES;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARAIMPUESTORENTA;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARASEGUROSOCIAL;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARAPROVISIONES)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARAPROVISIONES;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARAUTILIDADES)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARAUTILIDADES;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.PARARUBROIESS)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_PARARUBROIESS;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.ESFONDORESERVA)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_ESFONDORESERVA;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.ESDECIMOTERCERO)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_ESDECIMOTERCERO;}
		if(sNombreColumna.equals(RubroEmpleaConstantesFunciones.ESDECIMOCUARTO)) {sLabelColumna=RubroEmpleaConstantesFunciones.LABEL_ESDECIMOCUARTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getpara_rol_pagosDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_rol_pagos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_rol_pagosHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_rol_pagos());

		return sDescripcion;
	}	
		
	public static String getpara_sueldoDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_sueldo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_sueldoHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_sueldo());

		return sDescripcion;
	}	
		
	public static String getpara_vacacionesDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_vacaciones()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_vacacionesHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_vacaciones());

		return sDescripcion;
	}	
		
	public static String getpara_impuesto_rentaDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_impuesto_renta()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_impuesto_rentaHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_impuesto_renta());

		return sDescripcion;
	}	
		
	public static String getpara_seguro_socialDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_seguro_social()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_seguro_socialHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_seguro_social());

		return sDescripcion;
	}	
		
	public static String getpara_provisionesDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_provisiones()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_provisionesHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_provisiones());

		return sDescripcion;
	}	
		
	public static String getpara_utilidadesDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_utilidades()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_utilidadesHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_utilidades());

		return sDescripcion;
	}	
		
	public static String getpara_rubro_iessDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getpara_rubro_iess()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_rubro_iessHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getpara_rubro_iess());

		return sDescripcion;
	}	
		
	public static String getes_fondo_reservaDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getes_fondo_reserva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_fondo_reservaHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getes_fondo_reserva());

		return sDescripcion;
	}	
		
	public static String getes_decimo_terceroDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getes_decimo_tercero()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_decimo_terceroHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getes_decimo_tercero());

		return sDescripcion;
	}	
		
	public static String getes_decimo_cuartoDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!rubroemplea.getes_decimo_cuarto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_decimo_cuartoHtmlDescripcion(RubroEmplea rubroemplea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(rubroemplea.getId(),rubroemplea.getes_decimo_cuarto());

		return sDescripcion;
	}	
	
	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rubroemplea !=null/* && rubroemplea.getId()!=0*/) {
			sDescripcion=rubroemplea.getcodigo()+"-"+rubroemplea.getnombre();//rubroemplearubroemplea.getcodigo().trim()+"-"+rubroemplea.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRubroEmpleaDescripcionDetallado(RubroEmplea rubroemplea) {
		String sDescripcion="";
			
		sDescripcion+=RubroEmpleaConstantesFunciones.ID+"=";
		sDescripcion+=rubroemplea.getId().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rubroemplea.getVersionRow().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rubroemplea.getid_empresa().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.IDTIPOCALCULO+"=";
		sDescripcion+=rubroemplea.getid_tipo_calculo().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA+"=";
		sDescripcion+=rubroemplea.getid_tipo_rubro_emplea().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA+"=";
		sDescripcion+=rubroemplea.getid_tipo_grupo_rubro_emplea().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.CODIGO+"=";
		sDescripcion+=rubroemplea.getcodigo()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=rubroemplea.getnombre()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.FORMULA+"=";
		sDescripcion+=rubroemplea.getformula()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.ALIAS+"=";
		sDescripcion+=rubroemplea.getalias()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=rubroemplea.getsecuencial().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARAROLPAGOS+"=";
		sDescripcion+=rubroemplea.getpara_rol_pagos().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARASUELDO+"=";
		sDescripcion+=rubroemplea.getpara_sueldo().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARAVACACIONES+"=";
		sDescripcion+=rubroemplea.getpara_vacaciones().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA+"=";
		sDescripcion+=rubroemplea.getpara_impuesto_renta().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL+"=";
		sDescripcion+=rubroemplea.getpara_seguro_social().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARAPROVISIONES+"=";
		sDescripcion+=rubroemplea.getpara_provisiones().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARAUTILIDADES+"=";
		sDescripcion+=rubroemplea.getpara_utilidades().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.PARARUBROIESS+"=";
		sDescripcion+=rubroemplea.getpara_rubro_iess().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.ESFONDORESERVA+"=";
		sDescripcion+=rubroemplea.getes_fondo_reserva().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.ESDECIMOTERCERO+"=";
		sDescripcion+=rubroemplea.getes_decimo_tercero().toString()+",";
		sDescripcion+=RubroEmpleaConstantesFunciones.ESDECIMOCUARTO+"=";
		sDescripcion+=rubroemplea.getes_decimo_cuarto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRubroEmpleaDescripcion(RubroEmplea rubroemplea,String sValor) throws Exception {			
		if(rubroemplea !=null) {
			rubroemplea.setcodigo(sValor);
rubroemplea.setnombre(sValor);;//rubroemplearubroemplea.getcodigo().trim()+"-"+rubroemplea.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoCalculoDescripcion(TipoCalculo tipocalculo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocalculo!=null/*&&tipocalculo.getId()>0*/) {
			sDescripcion=TipoCalculoConstantesFunciones.getTipoCalculoDescripcion(tipocalculo);
		}

		return sDescripcion;
	}

	public static String getTipoRubroEmpleaDescripcion(TipoRubroEmplea tiporubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporubroemplea!=null/*&&tiporubroemplea.getId()>0*/) {
			sDescripcion=TipoRubroEmpleaConstantesFunciones.getTipoRubroEmpleaDescripcion(tiporubroemplea);
		}

		return sDescripcion;
	}

	public static String getTipoGrupoRubroEmpleaDescripcion(TipoGrupoRubroEmplea tipogruporubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogruporubroemplea!=null/*&&tipogruporubroemplea.getId()>0*/) {
			sDescripcion=TipoGrupoRubroEmpleaConstantesFunciones.getTipoGrupoRubroEmpleaDescripcion(tipogruporubroemplea);
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
		} else if(sNombreIndice.equals("FK_IdTipoCalculo")) {
			sNombreIndice="Tipo=  Por Tipo Calculo";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoRubroEmplea")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Rubro Emplea";
		} else if(sNombreIndice.equals("FK_IdTipoRubroEmplea")) {
			sNombreIndice="Tipo=  Por Tipo Rubro Emplea";
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

	public static String getDetalleIndiceFK_IdTipoCalculo(Long id_tipo_calculo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_calculo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Calculo="+id_tipo_calculo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoRubroEmplea(Long id_tipo_grupo_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Rubro Emplea="+id_tipo_grupo_rubro_emplea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRubroEmplea(Long id_tipo_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Tipo Rubro Emplea="+id_tipo_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRubroEmplea(RubroEmplea rubroemplea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		rubroemplea.setcodigo(rubroemplea.getcodigo().trim());
		rubroemplea.setnombre(rubroemplea.getnombre().trim());
		rubroemplea.setformula(rubroemplea.getformula().trim());
		rubroemplea.setalias(rubroemplea.getalias().trim());
	}
	
	public static void quitarEspaciosRubroEmpleas(List<RubroEmplea> rubroempleas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RubroEmplea rubroemplea: rubroempleas) {
			rubroemplea.setcodigo(rubroemplea.getcodigo().trim());
			rubroemplea.setnombre(rubroemplea.getnombre().trim());
			rubroemplea.setformula(rubroemplea.getformula().trim());
			rubroemplea.setalias(rubroemplea.getalias().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEmplea(RubroEmplea rubroemplea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rubroemplea.getConCambioAuxiliar()) {
			rubroemplea.setIsDeleted(rubroemplea.getIsDeletedAuxiliar());	
			rubroemplea.setIsNew(rubroemplea.getIsNewAuxiliar());	
			rubroemplea.setIsChanged(rubroemplea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rubroemplea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rubroemplea.setIsDeletedAuxiliar(false);	
			rubroemplea.setIsNewAuxiliar(false);	
			rubroemplea.setIsChangedAuxiliar(false);
			
			rubroemplea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRubroEmpleas(List<RubroEmplea> rubroempleas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RubroEmplea rubroemplea : rubroempleas) {
			if(conAsignarBase && rubroemplea.getConCambioAuxiliar()) {
				rubroemplea.setIsDeleted(rubroemplea.getIsDeletedAuxiliar());	
				rubroemplea.setIsNew(rubroemplea.getIsNewAuxiliar());	
				rubroemplea.setIsChanged(rubroemplea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rubroemplea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rubroemplea.setIsDeletedAuxiliar(false);	
				rubroemplea.setIsNewAuxiliar(false);	
				rubroemplea.setIsChangedAuxiliar(false);
				
				rubroemplea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRubroEmplea(RubroEmplea rubroemplea,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			rubroemplea.setsecuencial(0);
		}
	}		
	
	public static void InicializarValoresRubroEmpleas(List<RubroEmplea> rubroempleas,Boolean conEnteros) throws Exception  {
		
		for(RubroEmplea rubroemplea: rubroempleas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				rubroemplea.setsecuencial(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaRubroEmplea(List<RubroEmplea> rubroempleas,RubroEmplea rubroempleaAux) throws Exception  {
		RubroEmpleaConstantesFunciones.InicializarValoresRubroEmplea(rubroempleaAux,true);
		
		for(RubroEmplea rubroemplea: rubroempleas) {
			if(rubroemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rubroempleaAux.setsecuencial(rubroempleaAux.getsecuencial()+rubroemplea.getsecuencial());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RubroEmpleaConstantesFunciones.getArrayColumnasGlobalesRubroEmplea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RubroEmpleaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RubroEmpleaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRubroEmplea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RubroEmplea> rubroempleas,RubroEmplea rubroemplea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RubroEmplea rubroempleaAux: rubroempleas) {
			if(rubroempleaAux!=null && rubroemplea!=null) {
				if((rubroempleaAux.getId()==null && rubroemplea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rubroempleaAux.getId()!=null && rubroemplea.getId()!=null){
					if(rubroempleaAux.getId().equals(rubroemplea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRubroEmplea(List<RubroEmplea> rubroempleas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RubroEmplea rubroemplea: rubroempleas) {			
			if(rubroemplea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRubroEmplea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_ID, RubroEmpleaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_VERSIONROW, RubroEmpleaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_IDEMPRESA, RubroEmpleaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_IDTIPOCALCULO, RubroEmpleaConstantesFunciones.IDTIPOCALCULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_IDTIPORUBROEMPLEA, RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_IDTIPOGRUPORUBROEMPLEA, RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_CODIGO, RubroEmpleaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_NOMBRE, RubroEmpleaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_FORMULA, RubroEmpleaConstantesFunciones.FORMULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_ALIAS, RubroEmpleaConstantesFunciones.ALIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_SECUENCIAL, RubroEmpleaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARAROLPAGOS, RubroEmpleaConstantesFunciones.PARAROLPAGOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARASUELDO, RubroEmpleaConstantesFunciones.PARASUELDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARAVACACIONES, RubroEmpleaConstantesFunciones.PARAVACACIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARAIMPUESTORENTA, RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARASEGUROSOCIAL, RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARAPROVISIONES, RubroEmpleaConstantesFunciones.PARAPROVISIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARAUTILIDADES, RubroEmpleaConstantesFunciones.PARAUTILIDADES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_PARARUBROIESS, RubroEmpleaConstantesFunciones.PARARUBROIESS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_ESFONDORESERVA, RubroEmpleaConstantesFunciones.ESFONDORESERVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_ESDECIMOTERCERO, RubroEmpleaConstantesFunciones.ESDECIMOTERCERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RubroEmpleaConstantesFunciones.LABEL_ESDECIMOCUARTO, RubroEmpleaConstantesFunciones.ESDECIMOCUARTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRubroEmplea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.IDTIPOCALCULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.FORMULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.ALIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARAROLPAGOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARASUELDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARAVACACIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARAPROVISIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARAUTILIDADES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.PARARUBROIESS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.ESFONDORESERVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.ESDECIMOTERCERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RubroEmpleaConstantesFunciones.ESDECIMOCUARTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmplea() throws Exception  {
		return RubroEmpleaConstantesFunciones.getTiposSeleccionarRubroEmplea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmplea(Boolean conFk) throws Exception  {
		return RubroEmpleaConstantesFunciones.getTiposSeleccionarRubroEmplea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRubroEmplea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_IDTIPOCALCULO);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_IDTIPOCALCULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_IDTIPORUBROEMPLEA);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_IDTIPORUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_IDTIPOGRUPORUBROEMPLEA);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_IDTIPOGRUPORUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_FORMULA);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_FORMULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_ALIAS);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_ALIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARAROLPAGOS);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARAROLPAGOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARASUELDO);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARASUELDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARAVACACIONES);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARAVACACIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARAIMPUESTORENTA);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARAIMPUESTORENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARASEGUROSOCIAL);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARASEGUROSOCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARAPROVISIONES);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARAPROVISIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARAUTILIDADES);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARAUTILIDADES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_PARARUBROIESS);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_PARARUBROIESS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_ESFONDORESERVA);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_ESFONDORESERVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_ESDECIMOTERCERO);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_ESDECIMOTERCERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RubroEmpleaConstantesFunciones.LABEL_ESDECIMOCUARTO);
			reporte.setsDescripcion(RubroEmpleaConstantesFunciones.LABEL_ESDECIMOCUARTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRubroEmplea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEmplea(RubroEmplea rubroempleaAux) throws Exception {
		
			rubroempleaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroempleaAux.getEmpresa()));
			rubroempleaAux.settipocalculo_descripcion(TipoCalculoConstantesFunciones.getTipoCalculoDescripcion(rubroempleaAux.getTipoCalculo()));
			rubroempleaAux.settiporubroemplea_descripcion(TipoRubroEmpleaConstantesFunciones.getTipoRubroEmpleaDescripcion(rubroempleaAux.getTipoRubroEmplea()));
			rubroempleaAux.settipogruporubroemplea_descripcion(TipoGrupoRubroEmpleaConstantesFunciones.getTipoGrupoRubroEmpleaDescripcion(rubroempleaAux.getTipoGrupoRubroEmplea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRubroEmplea(List<RubroEmplea> rubroempleasTemp) throws Exception {
		for(RubroEmplea rubroempleaAux:rubroempleasTemp) {
			
			rubroempleaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rubroempleaAux.getEmpresa()));
			rubroempleaAux.settipocalculo_descripcion(TipoCalculoConstantesFunciones.getTipoCalculoDescripcion(rubroempleaAux.getTipoCalculo()));
			rubroempleaAux.settiporubroemplea_descripcion(TipoRubroEmpleaConstantesFunciones.getTipoRubroEmpleaDescripcion(rubroempleaAux.getTipoRubroEmplea()));
			rubroempleaAux.settipogruporubroemplea_descripcion(TipoGrupoRubroEmpleaConstantesFunciones.getTipoGrupoRubroEmpleaDescripcion(rubroempleaAux.getTipoGrupoRubroEmplea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoCalculo.class));
				classes.add(new Classe(TipoRubroEmplea.class));
				classes.add(new Classe(TipoGrupoRubroEmplea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCalculo.class)) {
						classes.add(new Classe(TipoCalculo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRubroEmplea.class)) {
						classes.add(new Classe(TipoRubroEmplea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
						classes.add(new Classe(TipoGrupoRubroEmplea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoCalculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCalculo.class)); continue;
					}

					if(TipoRubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRubroEmplea.class)); continue;
					}

					if(TipoGrupoRubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoRubroEmplea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoCalculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCalculo.class)); continue;
					}

					if(TipoRubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRubroEmplea.class)); continue;
					}

					if(TipoGrupoRubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoRubroEmplea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEmpleaConstantesFunciones.getClassesRelationshipsOfRubroEmplea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(HistorialPagoNomi.class));
				classes.add(new Classe(RubroEstructura.class));
				classes.add(new Classe(DefiProvisionEmpleado.class));
				classes.add(new Classe(EmpleadoPagoRubro.class));
				classes.add(new Classe(HistorialPagoMesNomi.class));
				classes.add(new Classe(RubroEmpleado.class));
				classes.add(new Classe(ValorRubroVariable.class));
				classes.add(new Classe(TipoPrestamo.class));
				classes.add(new Classe(RubroEmpleaCuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialPagoNomi.class)) {
						classes.add(new Classe(HistorialPagoNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEstructura.class)) {
						classes.add(new Classe(RubroEstructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DefiProvisionEmpleado.class)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoPagoRubro.class)) {
						classes.add(new Classe(EmpleadoPagoRubro.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialPagoMesNomi.class)) {
						classes.add(new Classe(HistorialPagoMesNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmpleado.class)) {
						classes.add(new Classe(RubroEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ValorRubroVariable.class)) {
						classes.add(new Classe(ValorRubroVariable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrestamo.class)) {
						classes.add(new Classe(TipoPrestamo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmpleaCuentaContable.class)) {
						classes.add(new Classe(RubroEmpleaCuentaContable.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RubroEmpleaConstantesFunciones.getClassesRelationshipsFromStringsOfRubroEmplea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRubroEmplea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(HistorialPagoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoNomi.class)); continue;
					}

					if(RubroEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEstructura.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
					}

					if(EmpleadoPagoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoPagoRubro.class)); continue;
					}

					if(HistorialPagoMesNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoMesNomi.class)); continue;
					}

					if(RubroEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleado.class)); continue;
					}

					if(ValorRubroVariable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ValorRubroVariable.class)); continue;
					}

					if(TipoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrestamo.class)); continue;
					}

					if(RubroEmpleaCuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleaCuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(HistorialPagoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoNomi.class)); continue;
					}

					if(RubroEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEstructura.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
					}

					if(EmpleadoPagoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoPagoRubro.class)); continue;
					}

					if(HistorialPagoMesNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoMesNomi.class)); continue;
					}

					if(RubroEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleado.class)); continue;
					}

					if(ValorRubroVariable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ValorRubroVariable.class)); continue;
					}

					if(TipoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrestamo.class)); continue;
					}

					if(RubroEmpleaCuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleaCuentaContable.class)); continue;
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
	public static void actualizarLista(RubroEmplea rubroemplea,List<RubroEmplea> rubroempleas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RubroEmplea rubroempleaEncontrado=null;
			
			for(RubroEmplea rubroempleaLocal:rubroempleas) {
				if(rubroempleaLocal.getId().equals(rubroemplea.getId())) {
					rubroempleaEncontrado=rubroempleaLocal;
					
					rubroempleaLocal.setIsChanged(rubroemplea.getIsChanged());
					rubroempleaLocal.setIsNew(rubroemplea.getIsNew());
					rubroempleaLocal.setIsDeleted(rubroemplea.getIsDeleted());
					
					rubroempleaLocal.setGeneralEntityOriginal(rubroemplea.getGeneralEntityOriginal());
					
					rubroempleaLocal.setId(rubroemplea.getId());	
					rubroempleaLocal.setVersionRow(rubroemplea.getVersionRow());	
					rubroempleaLocal.setid_empresa(rubroemplea.getid_empresa());	
					rubroempleaLocal.setid_tipo_calculo(rubroemplea.getid_tipo_calculo());	
					rubroempleaLocal.setid_tipo_rubro_emplea(rubroemplea.getid_tipo_rubro_emplea());	
					rubroempleaLocal.setid_tipo_grupo_rubro_emplea(rubroemplea.getid_tipo_grupo_rubro_emplea());	
					rubroempleaLocal.setcodigo(rubroemplea.getcodigo());	
					rubroempleaLocal.setnombre(rubroemplea.getnombre());	
					rubroempleaLocal.setformula(rubroemplea.getformula());	
					rubroempleaLocal.setalias(rubroemplea.getalias());	
					rubroempleaLocal.setsecuencial(rubroemplea.getsecuencial());	
					rubroempleaLocal.setpara_rol_pagos(rubroemplea.getpara_rol_pagos());	
					rubroempleaLocal.setpara_sueldo(rubroemplea.getpara_sueldo());	
					rubroempleaLocal.setpara_vacaciones(rubroemplea.getpara_vacaciones());	
					rubroempleaLocal.setpara_impuesto_renta(rubroemplea.getpara_impuesto_renta());	
					rubroempleaLocal.setpara_seguro_social(rubroemplea.getpara_seguro_social());	
					rubroempleaLocal.setpara_provisiones(rubroemplea.getpara_provisiones());	
					rubroempleaLocal.setpara_utilidades(rubroemplea.getpara_utilidades());	
					rubroempleaLocal.setpara_rubro_iess(rubroemplea.getpara_rubro_iess());	
					rubroempleaLocal.setes_fondo_reserva(rubroemplea.getes_fondo_reserva());	
					rubroempleaLocal.setes_decimo_tercero(rubroemplea.getes_decimo_tercero());	
					rubroempleaLocal.setes_decimo_cuarto(rubroemplea.getes_decimo_cuarto());	
					
					
					rubroempleaLocal.setHistorialPagoNomis(rubroemplea.getHistorialPagoNomis());
					rubroempleaLocal.setRubroEstructuras(rubroemplea.getRubroEstructuras());
					rubroempleaLocal.setDefiProvisionEmpleados(rubroemplea.getDefiProvisionEmpleados());
					rubroempleaLocal.setEmpleadoPagoRubros(rubroemplea.getEmpleadoPagoRubros());
					rubroempleaLocal.setHistorialPagoMesNomis(rubroemplea.getHistorialPagoMesNomis());
					rubroempleaLocal.setRubroEmpleados(rubroemplea.getRubroEmpleados());
					rubroempleaLocal.setValorRubroVariables(rubroemplea.getValorRubroVariables());
					rubroempleaLocal.setTipoPrestamos(rubroemplea.getTipoPrestamos());
					rubroempleaLocal.setRubroEmpleaCuentaContables(rubroemplea.getRubroEmpleaCuentaContables());
					
					existe=true;
					break;
				}
			}
			
			if(!rubroemplea.getIsDeleted()) {
				if(!existe) {
					rubroempleas.add(rubroemplea);
				}
			} else {
				if(rubroempleaEncontrado!=null && permiteQuitar)  {
					rubroempleas.remove(rubroempleaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RubroEmplea rubroemplea,List<RubroEmplea> rubroempleas) throws Exception {
		try	{			
			for(RubroEmplea rubroempleaLocal:rubroempleas) {
				if(rubroempleaLocal.getId().equals(rubroemplea.getId())) {
					rubroempleaLocal.setIsSelected(rubroemplea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRubroEmplea(List<RubroEmplea> rubroempleasAux) throws Exception {
		//this.rubroempleasAux=rubroempleasAux;
		
		for(RubroEmplea rubroempleaAux:rubroempleasAux) {
			if(rubroempleaAux.getIsChanged()) {
				rubroempleaAux.setIsChanged(false);
			}		
			
			if(rubroempleaAux.getIsNew()) {
				rubroempleaAux.setIsNew(false);
			}	
			
			if(rubroempleaAux.getIsDeleted()) {
				rubroempleaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRubroEmplea(RubroEmplea rubroempleaAux) throws Exception {
		//this.rubroempleaAux=rubroempleaAux;
		
			if(rubroempleaAux.getIsChanged()) {
				rubroempleaAux.setIsChanged(false);
			}		
			
			if(rubroempleaAux.getIsNew()) {
				rubroempleaAux.setIsNew(false);
			}	
			
			if(rubroempleaAux.getIsDeleted()) {
				rubroempleaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RubroEmplea rubroempleaAsignar,RubroEmplea rubroemplea) throws Exception {
		rubroempleaAsignar.setId(rubroemplea.getId());	
		rubroempleaAsignar.setVersionRow(rubroemplea.getVersionRow());	
		rubroempleaAsignar.setid_empresa(rubroemplea.getid_empresa());
		rubroempleaAsignar.setempresa_descripcion(rubroemplea.getempresa_descripcion());	
		rubroempleaAsignar.setid_tipo_calculo(rubroemplea.getid_tipo_calculo());
		rubroempleaAsignar.settipocalculo_descripcion(rubroemplea.gettipocalculo_descripcion());	
		rubroempleaAsignar.setid_tipo_rubro_emplea(rubroemplea.getid_tipo_rubro_emplea());
		rubroempleaAsignar.settiporubroemplea_descripcion(rubroemplea.gettiporubroemplea_descripcion());	
		rubroempleaAsignar.setid_tipo_grupo_rubro_emplea(rubroemplea.getid_tipo_grupo_rubro_emplea());
		rubroempleaAsignar.settipogruporubroemplea_descripcion(rubroemplea.gettipogruporubroemplea_descripcion());	
		rubroempleaAsignar.setcodigo(rubroemplea.getcodigo());	
		rubroempleaAsignar.setnombre(rubroemplea.getnombre());	
		rubroempleaAsignar.setformula(rubroemplea.getformula());	
		rubroempleaAsignar.setalias(rubroemplea.getalias());	
		rubroempleaAsignar.setsecuencial(rubroemplea.getsecuencial());	
		rubroempleaAsignar.setpara_rol_pagos(rubroemplea.getpara_rol_pagos());	
		rubroempleaAsignar.setpara_sueldo(rubroemplea.getpara_sueldo());	
		rubroempleaAsignar.setpara_vacaciones(rubroemplea.getpara_vacaciones());	
		rubroempleaAsignar.setpara_impuesto_renta(rubroemplea.getpara_impuesto_renta());	
		rubroempleaAsignar.setpara_seguro_social(rubroemplea.getpara_seguro_social());	
		rubroempleaAsignar.setpara_provisiones(rubroemplea.getpara_provisiones());	
		rubroempleaAsignar.setpara_utilidades(rubroemplea.getpara_utilidades());	
		rubroempleaAsignar.setpara_rubro_iess(rubroemplea.getpara_rubro_iess());	
		rubroempleaAsignar.setes_fondo_reserva(rubroemplea.getes_fondo_reserva());	
		rubroempleaAsignar.setes_decimo_tercero(rubroemplea.getes_decimo_tercero());	
		rubroempleaAsignar.setes_decimo_cuarto(rubroemplea.getes_decimo_cuarto());	
	}
	
	public static void inicializarRubroEmplea(RubroEmplea rubroemplea) throws Exception {
		try {
				rubroemplea.setId(0L);	
					
				rubroemplea.setid_empresa(-1L);	
				rubroemplea.setid_tipo_calculo(-1L);	
				rubroemplea.setid_tipo_rubro_emplea(-1L);	
				rubroemplea.setid_tipo_grupo_rubro_emplea(-1L);	
				rubroemplea.setcodigo("");	
				rubroemplea.setnombre("");	
				rubroemplea.setformula("");	
				rubroemplea.setalias("");	
				rubroemplea.setsecuencial(0);	
				rubroemplea.setpara_rol_pagos(false);	
				rubroemplea.setpara_sueldo(false);	
				rubroemplea.setpara_vacaciones(false);	
				rubroemplea.setpara_impuesto_renta(false);	
				rubroemplea.setpara_seguro_social(false);	
				rubroemplea.setpara_provisiones(false);	
				rubroemplea.setpara_utilidades(false);	
				rubroemplea.setpara_rubro_iess(false);	
				rubroemplea.setes_fondo_reserva(false);	
				rubroemplea.setes_decimo_tercero(false);	
				rubroemplea.setes_decimo_cuarto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRubroEmplea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_IDTIPOCALCULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_IDTIPORUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_IDTIPOGRUPORUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_FORMULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_ALIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARAROLPAGOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARASUELDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARAVACACIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARAIMPUESTORENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARASEGUROSOCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARAPROVISIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARAUTILIDADES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_PARARUBROIESS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_ESFONDORESERVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_ESDECIMOTERCERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RubroEmpleaConstantesFunciones.LABEL_ESDECIMOCUARTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRubroEmplea(String sTipo,Row row,Workbook workbook,RubroEmplea rubroemplea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.gettipocalculo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.gettiporubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.gettipogruporubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.getformula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.getalias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rubroemplea.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_rol_pagos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_sueldo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_vacaciones()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_impuesto_renta()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_seguro_social()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_provisiones()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_utilidades()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getpara_rubro_iess()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getes_fondo_reserva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getes_decimo_tercero()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(rubroemplea.getes_decimo_cuarto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRubroEmplea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRubroEmplea() {
		return this.sFinalQueryRubroEmplea;
	}
	
	public void setsFinalQueryRubroEmplea(String sFinalQueryRubroEmplea) {
		this.sFinalQueryRubroEmplea= sFinalQueryRubroEmplea;
	}
	
	public Border resaltarSeleccionarRubroEmplea=null;
	
	public Border setResaltarSeleccionarRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRubroEmplea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRubroEmplea() {
		return this.resaltarSeleccionarRubroEmplea;
	}
	
	public void setResaltarSeleccionarRubroEmplea(Border borderResaltarSeleccionarRubroEmplea) {
		this.resaltarSeleccionarRubroEmplea= borderResaltarSeleccionarRubroEmplea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRubroEmplea=null;
	public Boolean mostraridRubroEmplea=true;
	public Boolean activaridRubroEmplea=true;

	public Border resaltarid_empresaRubroEmplea=null;
	public Boolean mostrarid_empresaRubroEmplea=true;
	public Boolean activarid_empresaRubroEmplea=true;
	public Boolean cargarid_empresaRubroEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRubroEmplea=false;//ConEventDepend=true

	public Border resaltarid_tipo_calculoRubroEmplea=null;
	public Boolean mostrarid_tipo_calculoRubroEmplea=true;
	public Boolean activarid_tipo_calculoRubroEmplea=true;
	public Boolean cargarid_tipo_calculoRubroEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_calculoRubroEmplea=false;//ConEventDepend=true

	public Border resaltarid_tipo_rubro_empleaRubroEmplea=null;
	public Boolean mostrarid_tipo_rubro_empleaRubroEmplea=true;
	public Boolean activarid_tipo_rubro_empleaRubroEmplea=true;
	public Boolean cargarid_tipo_rubro_empleaRubroEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_rubro_empleaRubroEmplea=false;//ConEventDepend=true

	public Border resaltarid_tipo_grupo_rubro_empleaRubroEmplea=null;
	public Boolean mostrarid_tipo_grupo_rubro_empleaRubroEmplea=true;
	public Boolean activarid_tipo_grupo_rubro_empleaRubroEmplea=true;
	public Boolean cargarid_tipo_grupo_rubro_empleaRubroEmplea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_rubro_empleaRubroEmplea=false;//ConEventDepend=true

	public Border resaltarcodigoRubroEmplea=null;
	public Boolean mostrarcodigoRubroEmplea=true;
	public Boolean activarcodigoRubroEmplea=true;

	public Border resaltarnombreRubroEmplea=null;
	public Boolean mostrarnombreRubroEmplea=true;
	public Boolean activarnombreRubroEmplea=true;

	public Border resaltarformulaRubroEmplea=null;
	public Boolean mostrarformulaRubroEmplea=true;
	public Boolean activarformulaRubroEmplea=true;

	public Border resaltaraliasRubroEmplea=null;
	public Boolean mostraraliasRubroEmplea=true;
	public Boolean activaraliasRubroEmplea=true;

	public Border resaltarsecuencialRubroEmplea=null;
	public Boolean mostrarsecuencialRubroEmplea=true;
	public Boolean activarsecuencialRubroEmplea=true;

	public Border resaltarpara_rol_pagosRubroEmplea=null;
	public Boolean mostrarpara_rol_pagosRubroEmplea=true;
	public Boolean activarpara_rol_pagosRubroEmplea=true;

	public Border resaltarpara_sueldoRubroEmplea=null;
	public Boolean mostrarpara_sueldoRubroEmplea=true;
	public Boolean activarpara_sueldoRubroEmplea=true;

	public Border resaltarpara_vacacionesRubroEmplea=null;
	public Boolean mostrarpara_vacacionesRubroEmplea=true;
	public Boolean activarpara_vacacionesRubroEmplea=true;

	public Border resaltarpara_impuesto_rentaRubroEmplea=null;
	public Boolean mostrarpara_impuesto_rentaRubroEmplea=true;
	public Boolean activarpara_impuesto_rentaRubroEmplea=true;

	public Border resaltarpara_seguro_socialRubroEmplea=null;
	public Boolean mostrarpara_seguro_socialRubroEmplea=true;
	public Boolean activarpara_seguro_socialRubroEmplea=true;

	public Border resaltarpara_provisionesRubroEmplea=null;
	public Boolean mostrarpara_provisionesRubroEmplea=true;
	public Boolean activarpara_provisionesRubroEmplea=true;

	public Border resaltarpara_utilidadesRubroEmplea=null;
	public Boolean mostrarpara_utilidadesRubroEmplea=true;
	public Boolean activarpara_utilidadesRubroEmplea=true;

	public Border resaltarpara_rubro_iessRubroEmplea=null;
	public Boolean mostrarpara_rubro_iessRubroEmplea=true;
	public Boolean activarpara_rubro_iessRubroEmplea=true;

	public Border resaltares_fondo_reservaRubroEmplea=null;
	public Boolean mostrares_fondo_reservaRubroEmplea=true;
	public Boolean activares_fondo_reservaRubroEmplea=true;

	public Border resaltares_decimo_terceroRubroEmplea=null;
	public Boolean mostrares_decimo_terceroRubroEmplea=true;
	public Boolean activares_decimo_terceroRubroEmplea=true;

	public Border resaltares_decimo_cuartoRubroEmplea=null;
	public Boolean mostrares_decimo_cuartoRubroEmplea=true;
	public Boolean activares_decimo_cuartoRubroEmplea=true;

	
	

	public Border setResaltaridRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltaridRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRubroEmplea() {
		return this.resaltaridRubroEmplea;
	}

	public void setResaltaridRubroEmplea(Border borderResaltar) {
		this.resaltaridRubroEmplea= borderResaltar;
	}

	public Boolean getMostraridRubroEmplea() {
		return this.mostraridRubroEmplea;
	}

	public void setMostraridRubroEmplea(Boolean mostraridRubroEmplea) {
		this.mostraridRubroEmplea= mostraridRubroEmplea;
	}

	public Boolean getActivaridRubroEmplea() {
		return this.activaridRubroEmplea;
	}

	public void setActivaridRubroEmplea(Boolean activaridRubroEmplea) {
		this.activaridRubroEmplea= activaridRubroEmplea;
	}

	public Border setResaltarid_empresaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarid_empresaRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRubroEmplea() {
		return this.resaltarid_empresaRubroEmplea;
	}

	public void setResaltarid_empresaRubroEmplea(Border borderResaltar) {
		this.resaltarid_empresaRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarid_empresaRubroEmplea() {
		return this.mostrarid_empresaRubroEmplea;
	}

	public void setMostrarid_empresaRubroEmplea(Boolean mostrarid_empresaRubroEmplea) {
		this.mostrarid_empresaRubroEmplea= mostrarid_empresaRubroEmplea;
	}

	public Boolean getActivarid_empresaRubroEmplea() {
		return this.activarid_empresaRubroEmplea;
	}

	public void setActivarid_empresaRubroEmplea(Boolean activarid_empresaRubroEmplea) {
		this.activarid_empresaRubroEmplea= activarid_empresaRubroEmplea;
	}

	public Boolean getCargarid_empresaRubroEmplea() {
		return this.cargarid_empresaRubroEmplea;
	}

	public void setCargarid_empresaRubroEmplea(Boolean cargarid_empresaRubroEmplea) {
		this.cargarid_empresaRubroEmplea= cargarid_empresaRubroEmplea;
	}

	public Border setResaltarid_tipo_calculoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarid_tipo_calculoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_calculoRubroEmplea() {
		return this.resaltarid_tipo_calculoRubroEmplea;
	}

	public void setResaltarid_tipo_calculoRubroEmplea(Border borderResaltar) {
		this.resaltarid_tipo_calculoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarid_tipo_calculoRubroEmplea() {
		return this.mostrarid_tipo_calculoRubroEmplea;
	}

	public void setMostrarid_tipo_calculoRubroEmplea(Boolean mostrarid_tipo_calculoRubroEmplea) {
		this.mostrarid_tipo_calculoRubroEmplea= mostrarid_tipo_calculoRubroEmplea;
	}

	public Boolean getActivarid_tipo_calculoRubroEmplea() {
		return this.activarid_tipo_calculoRubroEmplea;
	}

	public void setActivarid_tipo_calculoRubroEmplea(Boolean activarid_tipo_calculoRubroEmplea) {
		this.activarid_tipo_calculoRubroEmplea= activarid_tipo_calculoRubroEmplea;
	}

	public Boolean getCargarid_tipo_calculoRubroEmplea() {
		return this.cargarid_tipo_calculoRubroEmplea;
	}

	public void setCargarid_tipo_calculoRubroEmplea(Boolean cargarid_tipo_calculoRubroEmplea) {
		this.cargarid_tipo_calculoRubroEmplea= cargarid_tipo_calculoRubroEmplea;
	}

	public Border setResaltarid_tipo_rubro_empleaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarid_tipo_rubro_empleaRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_rubro_empleaRubroEmplea() {
		return this.resaltarid_tipo_rubro_empleaRubroEmplea;
	}

	public void setResaltarid_tipo_rubro_empleaRubroEmplea(Border borderResaltar) {
		this.resaltarid_tipo_rubro_empleaRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarid_tipo_rubro_empleaRubroEmplea() {
		return this.mostrarid_tipo_rubro_empleaRubroEmplea;
	}

	public void setMostrarid_tipo_rubro_empleaRubroEmplea(Boolean mostrarid_tipo_rubro_empleaRubroEmplea) {
		this.mostrarid_tipo_rubro_empleaRubroEmplea= mostrarid_tipo_rubro_empleaRubroEmplea;
	}

	public Boolean getActivarid_tipo_rubro_empleaRubroEmplea() {
		return this.activarid_tipo_rubro_empleaRubroEmplea;
	}

	public void setActivarid_tipo_rubro_empleaRubroEmplea(Boolean activarid_tipo_rubro_empleaRubroEmplea) {
		this.activarid_tipo_rubro_empleaRubroEmplea= activarid_tipo_rubro_empleaRubroEmplea;
	}

	public Boolean getCargarid_tipo_rubro_empleaRubroEmplea() {
		return this.cargarid_tipo_rubro_empleaRubroEmplea;
	}

	public void setCargarid_tipo_rubro_empleaRubroEmplea(Boolean cargarid_tipo_rubro_empleaRubroEmplea) {
		this.cargarid_tipo_rubro_empleaRubroEmplea= cargarid_tipo_rubro_empleaRubroEmplea;
	}

	public Border setResaltarid_tipo_grupo_rubro_empleaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_rubro_empleaRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_rubro_empleaRubroEmplea() {
		return this.resaltarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public void setResaltarid_tipo_grupo_rubro_empleaRubroEmplea(Border borderResaltar) {
		this.resaltarid_tipo_grupo_rubro_empleaRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_rubro_empleaRubroEmplea() {
		return this.mostrarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public void setMostrarid_tipo_grupo_rubro_empleaRubroEmplea(Boolean mostrarid_tipo_grupo_rubro_empleaRubroEmplea) {
		this.mostrarid_tipo_grupo_rubro_empleaRubroEmplea= mostrarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public Boolean getActivarid_tipo_grupo_rubro_empleaRubroEmplea() {
		return this.activarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public void setActivarid_tipo_grupo_rubro_empleaRubroEmplea(Boolean activarid_tipo_grupo_rubro_empleaRubroEmplea) {
		this.activarid_tipo_grupo_rubro_empleaRubroEmplea= activarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public Boolean getCargarid_tipo_grupo_rubro_empleaRubroEmplea() {
		return this.cargarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public void setCargarid_tipo_grupo_rubro_empleaRubroEmplea(Boolean cargarid_tipo_grupo_rubro_empleaRubroEmplea) {
		this.cargarid_tipo_grupo_rubro_empleaRubroEmplea= cargarid_tipo_grupo_rubro_empleaRubroEmplea;
	}

	public Border setResaltarcodigoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarcodigoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoRubroEmplea() {
		return this.resaltarcodigoRubroEmplea;
	}

	public void setResaltarcodigoRubroEmplea(Border borderResaltar) {
		this.resaltarcodigoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarcodigoRubroEmplea() {
		return this.mostrarcodigoRubroEmplea;
	}

	public void setMostrarcodigoRubroEmplea(Boolean mostrarcodigoRubroEmplea) {
		this.mostrarcodigoRubroEmplea= mostrarcodigoRubroEmplea;
	}

	public Boolean getActivarcodigoRubroEmplea() {
		return this.activarcodigoRubroEmplea;
	}

	public void setActivarcodigoRubroEmplea(Boolean activarcodigoRubroEmplea) {
		this.activarcodigoRubroEmplea= activarcodigoRubroEmplea;
	}

	public Border setResaltarnombreRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarnombreRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreRubroEmplea() {
		return this.resaltarnombreRubroEmplea;
	}

	public void setResaltarnombreRubroEmplea(Border borderResaltar) {
		this.resaltarnombreRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarnombreRubroEmplea() {
		return this.mostrarnombreRubroEmplea;
	}

	public void setMostrarnombreRubroEmplea(Boolean mostrarnombreRubroEmplea) {
		this.mostrarnombreRubroEmplea= mostrarnombreRubroEmplea;
	}

	public Boolean getActivarnombreRubroEmplea() {
		return this.activarnombreRubroEmplea;
	}

	public void setActivarnombreRubroEmplea(Boolean activarnombreRubroEmplea) {
		this.activarnombreRubroEmplea= activarnombreRubroEmplea;
	}

	public Border setResaltarformulaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarformulaRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarformulaRubroEmplea() {
		return this.resaltarformulaRubroEmplea;
	}

	public void setResaltarformulaRubroEmplea(Border borderResaltar) {
		this.resaltarformulaRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarformulaRubroEmplea() {
		return this.mostrarformulaRubroEmplea;
	}

	public void setMostrarformulaRubroEmplea(Boolean mostrarformulaRubroEmplea) {
		this.mostrarformulaRubroEmplea= mostrarformulaRubroEmplea;
	}

	public Boolean getActivarformulaRubroEmplea() {
		return this.activarformulaRubroEmplea;
	}

	public void setActivarformulaRubroEmplea(Boolean activarformulaRubroEmplea) {
		this.activarformulaRubroEmplea= activarformulaRubroEmplea;
	}

	public Border setResaltaraliasRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltaraliasRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraliasRubroEmplea() {
		return this.resaltaraliasRubroEmplea;
	}

	public void setResaltaraliasRubroEmplea(Border borderResaltar) {
		this.resaltaraliasRubroEmplea= borderResaltar;
	}

	public Boolean getMostraraliasRubroEmplea() {
		return this.mostraraliasRubroEmplea;
	}

	public void setMostraraliasRubroEmplea(Boolean mostraraliasRubroEmplea) {
		this.mostraraliasRubroEmplea= mostraraliasRubroEmplea;
	}

	public Boolean getActivaraliasRubroEmplea() {
		return this.activaraliasRubroEmplea;
	}

	public void setActivaraliasRubroEmplea(Boolean activaraliasRubroEmplea) {
		this.activaraliasRubroEmplea= activaraliasRubroEmplea;
	}

	public Border setResaltarsecuencialRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarsecuencialRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialRubroEmplea() {
		return this.resaltarsecuencialRubroEmplea;
	}

	public void setResaltarsecuencialRubroEmplea(Border borderResaltar) {
		this.resaltarsecuencialRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarsecuencialRubroEmplea() {
		return this.mostrarsecuencialRubroEmplea;
	}

	public void setMostrarsecuencialRubroEmplea(Boolean mostrarsecuencialRubroEmplea) {
		this.mostrarsecuencialRubroEmplea= mostrarsecuencialRubroEmplea;
	}

	public Boolean getActivarsecuencialRubroEmplea() {
		return this.activarsecuencialRubroEmplea;
	}

	public void setActivarsecuencialRubroEmplea(Boolean activarsecuencialRubroEmplea) {
		this.activarsecuencialRubroEmplea= activarsecuencialRubroEmplea;
	}

	public Border setResaltarpara_rol_pagosRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_rol_pagosRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_rol_pagosRubroEmplea() {
		return this.resaltarpara_rol_pagosRubroEmplea;
	}

	public void setResaltarpara_rol_pagosRubroEmplea(Border borderResaltar) {
		this.resaltarpara_rol_pagosRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_rol_pagosRubroEmplea() {
		return this.mostrarpara_rol_pagosRubroEmplea;
	}

	public void setMostrarpara_rol_pagosRubroEmplea(Boolean mostrarpara_rol_pagosRubroEmplea) {
		this.mostrarpara_rol_pagosRubroEmplea= mostrarpara_rol_pagosRubroEmplea;
	}

	public Boolean getActivarpara_rol_pagosRubroEmplea() {
		return this.activarpara_rol_pagosRubroEmplea;
	}

	public void setActivarpara_rol_pagosRubroEmplea(Boolean activarpara_rol_pagosRubroEmplea) {
		this.activarpara_rol_pagosRubroEmplea= activarpara_rol_pagosRubroEmplea;
	}

	public Border setResaltarpara_sueldoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_sueldoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_sueldoRubroEmplea() {
		return this.resaltarpara_sueldoRubroEmplea;
	}

	public void setResaltarpara_sueldoRubroEmplea(Border borderResaltar) {
		this.resaltarpara_sueldoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_sueldoRubroEmplea() {
		return this.mostrarpara_sueldoRubroEmplea;
	}

	public void setMostrarpara_sueldoRubroEmplea(Boolean mostrarpara_sueldoRubroEmplea) {
		this.mostrarpara_sueldoRubroEmplea= mostrarpara_sueldoRubroEmplea;
	}

	public Boolean getActivarpara_sueldoRubroEmplea() {
		return this.activarpara_sueldoRubroEmplea;
	}

	public void setActivarpara_sueldoRubroEmplea(Boolean activarpara_sueldoRubroEmplea) {
		this.activarpara_sueldoRubroEmplea= activarpara_sueldoRubroEmplea;
	}

	public Border setResaltarpara_vacacionesRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_vacacionesRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_vacacionesRubroEmplea() {
		return this.resaltarpara_vacacionesRubroEmplea;
	}

	public void setResaltarpara_vacacionesRubroEmplea(Border borderResaltar) {
		this.resaltarpara_vacacionesRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_vacacionesRubroEmplea() {
		return this.mostrarpara_vacacionesRubroEmplea;
	}

	public void setMostrarpara_vacacionesRubroEmplea(Boolean mostrarpara_vacacionesRubroEmplea) {
		this.mostrarpara_vacacionesRubroEmplea= mostrarpara_vacacionesRubroEmplea;
	}

	public Boolean getActivarpara_vacacionesRubroEmplea() {
		return this.activarpara_vacacionesRubroEmplea;
	}

	public void setActivarpara_vacacionesRubroEmplea(Boolean activarpara_vacacionesRubroEmplea) {
		this.activarpara_vacacionesRubroEmplea= activarpara_vacacionesRubroEmplea;
	}

	public Border setResaltarpara_impuesto_rentaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_impuesto_rentaRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_impuesto_rentaRubroEmplea() {
		return this.resaltarpara_impuesto_rentaRubroEmplea;
	}

	public void setResaltarpara_impuesto_rentaRubroEmplea(Border borderResaltar) {
		this.resaltarpara_impuesto_rentaRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_impuesto_rentaRubroEmplea() {
		return this.mostrarpara_impuesto_rentaRubroEmplea;
	}

	public void setMostrarpara_impuesto_rentaRubroEmplea(Boolean mostrarpara_impuesto_rentaRubroEmplea) {
		this.mostrarpara_impuesto_rentaRubroEmplea= mostrarpara_impuesto_rentaRubroEmplea;
	}

	public Boolean getActivarpara_impuesto_rentaRubroEmplea() {
		return this.activarpara_impuesto_rentaRubroEmplea;
	}

	public void setActivarpara_impuesto_rentaRubroEmplea(Boolean activarpara_impuesto_rentaRubroEmplea) {
		this.activarpara_impuesto_rentaRubroEmplea= activarpara_impuesto_rentaRubroEmplea;
	}

	public Border setResaltarpara_seguro_socialRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_seguro_socialRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_seguro_socialRubroEmplea() {
		return this.resaltarpara_seguro_socialRubroEmplea;
	}

	public void setResaltarpara_seguro_socialRubroEmplea(Border borderResaltar) {
		this.resaltarpara_seguro_socialRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_seguro_socialRubroEmplea() {
		return this.mostrarpara_seguro_socialRubroEmplea;
	}

	public void setMostrarpara_seguro_socialRubroEmplea(Boolean mostrarpara_seguro_socialRubroEmplea) {
		this.mostrarpara_seguro_socialRubroEmplea= mostrarpara_seguro_socialRubroEmplea;
	}

	public Boolean getActivarpara_seguro_socialRubroEmplea() {
		return this.activarpara_seguro_socialRubroEmplea;
	}

	public void setActivarpara_seguro_socialRubroEmplea(Boolean activarpara_seguro_socialRubroEmplea) {
		this.activarpara_seguro_socialRubroEmplea= activarpara_seguro_socialRubroEmplea;
	}

	public Border setResaltarpara_provisionesRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_provisionesRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_provisionesRubroEmplea() {
		return this.resaltarpara_provisionesRubroEmplea;
	}

	public void setResaltarpara_provisionesRubroEmplea(Border borderResaltar) {
		this.resaltarpara_provisionesRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_provisionesRubroEmplea() {
		return this.mostrarpara_provisionesRubroEmplea;
	}

	public void setMostrarpara_provisionesRubroEmplea(Boolean mostrarpara_provisionesRubroEmplea) {
		this.mostrarpara_provisionesRubroEmplea= mostrarpara_provisionesRubroEmplea;
	}

	public Boolean getActivarpara_provisionesRubroEmplea() {
		return this.activarpara_provisionesRubroEmplea;
	}

	public void setActivarpara_provisionesRubroEmplea(Boolean activarpara_provisionesRubroEmplea) {
		this.activarpara_provisionesRubroEmplea= activarpara_provisionesRubroEmplea;
	}

	public Border setResaltarpara_utilidadesRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_utilidadesRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_utilidadesRubroEmplea() {
		return this.resaltarpara_utilidadesRubroEmplea;
	}

	public void setResaltarpara_utilidadesRubroEmplea(Border borderResaltar) {
		this.resaltarpara_utilidadesRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_utilidadesRubroEmplea() {
		return this.mostrarpara_utilidadesRubroEmplea;
	}

	public void setMostrarpara_utilidadesRubroEmplea(Boolean mostrarpara_utilidadesRubroEmplea) {
		this.mostrarpara_utilidadesRubroEmplea= mostrarpara_utilidadesRubroEmplea;
	}

	public Boolean getActivarpara_utilidadesRubroEmplea() {
		return this.activarpara_utilidadesRubroEmplea;
	}

	public void setActivarpara_utilidadesRubroEmplea(Boolean activarpara_utilidadesRubroEmplea) {
		this.activarpara_utilidadesRubroEmplea= activarpara_utilidadesRubroEmplea;
	}

	public Border setResaltarpara_rubro_iessRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltarpara_rubro_iessRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_rubro_iessRubroEmplea() {
		return this.resaltarpara_rubro_iessRubroEmplea;
	}

	public void setResaltarpara_rubro_iessRubroEmplea(Border borderResaltar) {
		this.resaltarpara_rubro_iessRubroEmplea= borderResaltar;
	}

	public Boolean getMostrarpara_rubro_iessRubroEmplea() {
		return this.mostrarpara_rubro_iessRubroEmplea;
	}

	public void setMostrarpara_rubro_iessRubroEmplea(Boolean mostrarpara_rubro_iessRubroEmplea) {
		this.mostrarpara_rubro_iessRubroEmplea= mostrarpara_rubro_iessRubroEmplea;
	}

	public Boolean getActivarpara_rubro_iessRubroEmplea() {
		return this.activarpara_rubro_iessRubroEmplea;
	}

	public void setActivarpara_rubro_iessRubroEmplea(Boolean activarpara_rubro_iessRubroEmplea) {
		this.activarpara_rubro_iessRubroEmplea= activarpara_rubro_iessRubroEmplea;
	}

	public Border setResaltares_fondo_reservaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltares_fondo_reservaRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_fondo_reservaRubroEmplea() {
		return this.resaltares_fondo_reservaRubroEmplea;
	}

	public void setResaltares_fondo_reservaRubroEmplea(Border borderResaltar) {
		this.resaltares_fondo_reservaRubroEmplea= borderResaltar;
	}

	public Boolean getMostrares_fondo_reservaRubroEmplea() {
		return this.mostrares_fondo_reservaRubroEmplea;
	}

	public void setMostrares_fondo_reservaRubroEmplea(Boolean mostrares_fondo_reservaRubroEmplea) {
		this.mostrares_fondo_reservaRubroEmplea= mostrares_fondo_reservaRubroEmplea;
	}

	public Boolean getActivares_fondo_reservaRubroEmplea() {
		return this.activares_fondo_reservaRubroEmplea;
	}

	public void setActivares_fondo_reservaRubroEmplea(Boolean activares_fondo_reservaRubroEmplea) {
		this.activares_fondo_reservaRubroEmplea= activares_fondo_reservaRubroEmplea;
	}

	public Border setResaltares_decimo_terceroRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltares_decimo_terceroRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_decimo_terceroRubroEmplea() {
		return this.resaltares_decimo_terceroRubroEmplea;
	}

	public void setResaltares_decimo_terceroRubroEmplea(Border borderResaltar) {
		this.resaltares_decimo_terceroRubroEmplea= borderResaltar;
	}

	public Boolean getMostrares_decimo_terceroRubroEmplea() {
		return this.mostrares_decimo_terceroRubroEmplea;
	}

	public void setMostrares_decimo_terceroRubroEmplea(Boolean mostrares_decimo_terceroRubroEmplea) {
		this.mostrares_decimo_terceroRubroEmplea= mostrares_decimo_terceroRubroEmplea;
	}

	public Boolean getActivares_decimo_terceroRubroEmplea() {
		return this.activares_decimo_terceroRubroEmplea;
	}

	public void setActivares_decimo_terceroRubroEmplea(Boolean activares_decimo_terceroRubroEmplea) {
		this.activares_decimo_terceroRubroEmplea= activares_decimo_terceroRubroEmplea;
	}

	public Border setResaltares_decimo_cuartoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltar);
		
		this.resaltares_decimo_cuartoRubroEmplea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_decimo_cuartoRubroEmplea() {
		return this.resaltares_decimo_cuartoRubroEmplea;
	}

	public void setResaltares_decimo_cuartoRubroEmplea(Border borderResaltar) {
		this.resaltares_decimo_cuartoRubroEmplea= borderResaltar;
	}

	public Boolean getMostrares_decimo_cuartoRubroEmplea() {
		return this.mostrares_decimo_cuartoRubroEmplea;
	}

	public void setMostrares_decimo_cuartoRubroEmplea(Boolean mostrares_decimo_cuartoRubroEmplea) {
		this.mostrares_decimo_cuartoRubroEmplea= mostrares_decimo_cuartoRubroEmplea;
	}

	public Boolean getActivares_decimo_cuartoRubroEmplea() {
		return this.activares_decimo_cuartoRubroEmplea;
	}

	public void setActivares_decimo_cuartoRubroEmplea(Boolean activares_decimo_cuartoRubroEmplea) {
		this.activares_decimo_cuartoRubroEmplea= activares_decimo_cuartoRubroEmplea;
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
		
		
		this.setMostraridRubroEmplea(esInicial);
		this.setMostrarid_empresaRubroEmplea(esInicial);
		this.setMostrarid_tipo_calculoRubroEmplea(esInicial);
		this.setMostrarid_tipo_rubro_empleaRubroEmplea(esInicial);
		this.setMostrarid_tipo_grupo_rubro_empleaRubroEmplea(esInicial);
		this.setMostrarcodigoRubroEmplea(esInicial);
		this.setMostrarnombreRubroEmplea(esInicial);
		this.setMostrarformulaRubroEmplea(esInicial);
		this.setMostraraliasRubroEmplea(esInicial);
		this.setMostrarsecuencialRubroEmplea(esInicial);
		this.setMostrarpara_rol_pagosRubroEmplea(esInicial);
		this.setMostrarpara_sueldoRubroEmplea(esInicial);
		this.setMostrarpara_vacacionesRubroEmplea(esInicial);
		this.setMostrarpara_impuesto_rentaRubroEmplea(esInicial);
		this.setMostrarpara_seguro_socialRubroEmplea(esInicial);
		this.setMostrarpara_provisionesRubroEmplea(esInicial);
		this.setMostrarpara_utilidadesRubroEmplea(esInicial);
		this.setMostrarpara_rubro_iessRubroEmplea(esInicial);
		this.setMostrares_fondo_reservaRubroEmplea(esInicial);
		this.setMostrares_decimo_terceroRubroEmplea(esInicial);
		this.setMostrares_decimo_cuartoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ID)) {
				this.setMostraridRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPOCALCULO)) {
				this.setMostrarid_tipo_calculoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA)) {
				this.setMostrarid_tipo_rubro_empleaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA)) {
				this.setMostrarid_tipo_grupo_rubro_empleaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.FORMULA)) {
				this.setMostrarformulaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ALIAS)) {
				this.setMostraraliasRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAROLPAGOS)) {
				this.setMostrarpara_rol_pagosRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARASUELDO)) {
				this.setMostrarpara_sueldoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAVACACIONES)) {
				this.setMostrarpara_vacacionesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA)) {
				this.setMostrarpara_impuesto_rentaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL)) {
				this.setMostrarpara_seguro_socialRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAPROVISIONES)) {
				this.setMostrarpara_provisionesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAUTILIDADES)) {
				this.setMostrarpara_utilidadesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARARUBROIESS)) {
				this.setMostrarpara_rubro_iessRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESFONDORESERVA)) {
				this.setMostrares_fondo_reservaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESDECIMOTERCERO)) {
				this.setMostrares_decimo_terceroRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESDECIMOCUARTO)) {
				this.setMostrares_decimo_cuartoRubroEmplea(esAsigna);
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
		
		
		this.setActivaridRubroEmplea(esInicial);
		this.setActivarid_empresaRubroEmplea(esInicial);
		this.setActivarid_tipo_calculoRubroEmplea(esInicial);
		this.setActivarid_tipo_rubro_empleaRubroEmplea(esInicial);
		this.setActivarid_tipo_grupo_rubro_empleaRubroEmplea(esInicial);
		this.setActivarcodigoRubroEmplea(esInicial);
		this.setActivarnombreRubroEmplea(esInicial);
		this.setActivarformulaRubroEmplea(esInicial);
		this.setActivaraliasRubroEmplea(esInicial);
		this.setActivarsecuencialRubroEmplea(esInicial);
		this.setActivarpara_rol_pagosRubroEmplea(esInicial);
		this.setActivarpara_sueldoRubroEmplea(esInicial);
		this.setActivarpara_vacacionesRubroEmplea(esInicial);
		this.setActivarpara_impuesto_rentaRubroEmplea(esInicial);
		this.setActivarpara_seguro_socialRubroEmplea(esInicial);
		this.setActivarpara_provisionesRubroEmplea(esInicial);
		this.setActivarpara_utilidadesRubroEmplea(esInicial);
		this.setActivarpara_rubro_iessRubroEmplea(esInicial);
		this.setActivares_fondo_reservaRubroEmplea(esInicial);
		this.setActivares_decimo_terceroRubroEmplea(esInicial);
		this.setActivares_decimo_cuartoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ID)) {
				this.setActivaridRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPOCALCULO)) {
				this.setActivarid_tipo_calculoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA)) {
				this.setActivarid_tipo_rubro_empleaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA)) {
				this.setActivarid_tipo_grupo_rubro_empleaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.FORMULA)) {
				this.setActivarformulaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ALIAS)) {
				this.setActivaraliasRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAROLPAGOS)) {
				this.setActivarpara_rol_pagosRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARASUELDO)) {
				this.setActivarpara_sueldoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAVACACIONES)) {
				this.setActivarpara_vacacionesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA)) {
				this.setActivarpara_impuesto_rentaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL)) {
				this.setActivarpara_seguro_socialRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAPROVISIONES)) {
				this.setActivarpara_provisionesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAUTILIDADES)) {
				this.setActivarpara_utilidadesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARARUBROIESS)) {
				this.setActivarpara_rubro_iessRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESFONDORESERVA)) {
				this.setActivares_fondo_reservaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESDECIMOTERCERO)) {
				this.setActivares_decimo_terceroRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESDECIMOCUARTO)) {
				this.setActivares_decimo_cuartoRubroEmplea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRubroEmplea(esInicial);
		this.setResaltarid_empresaRubroEmplea(esInicial);
		this.setResaltarid_tipo_calculoRubroEmplea(esInicial);
		this.setResaltarid_tipo_rubro_empleaRubroEmplea(esInicial);
		this.setResaltarid_tipo_grupo_rubro_empleaRubroEmplea(esInicial);
		this.setResaltarcodigoRubroEmplea(esInicial);
		this.setResaltarnombreRubroEmplea(esInicial);
		this.setResaltarformulaRubroEmplea(esInicial);
		this.setResaltaraliasRubroEmplea(esInicial);
		this.setResaltarsecuencialRubroEmplea(esInicial);
		this.setResaltarpara_rol_pagosRubroEmplea(esInicial);
		this.setResaltarpara_sueldoRubroEmplea(esInicial);
		this.setResaltarpara_vacacionesRubroEmplea(esInicial);
		this.setResaltarpara_impuesto_rentaRubroEmplea(esInicial);
		this.setResaltarpara_seguro_socialRubroEmplea(esInicial);
		this.setResaltarpara_provisionesRubroEmplea(esInicial);
		this.setResaltarpara_utilidadesRubroEmplea(esInicial);
		this.setResaltarpara_rubro_iessRubroEmplea(esInicial);
		this.setResaltares_fondo_reservaRubroEmplea(esInicial);
		this.setResaltares_decimo_terceroRubroEmplea(esInicial);
		this.setResaltares_decimo_cuartoRubroEmplea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ID)) {
				this.setResaltaridRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPOCALCULO)) {
				this.setResaltarid_tipo_calculoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA)) {
				this.setResaltarid_tipo_rubro_empleaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA)) {
				this.setResaltarid_tipo_grupo_rubro_empleaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.FORMULA)) {
				this.setResaltarformulaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ALIAS)) {
				this.setResaltaraliasRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAROLPAGOS)) {
				this.setResaltarpara_rol_pagosRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARASUELDO)) {
				this.setResaltarpara_sueldoRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAVACACIONES)) {
				this.setResaltarpara_vacacionesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA)) {
				this.setResaltarpara_impuesto_rentaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL)) {
				this.setResaltarpara_seguro_socialRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAPROVISIONES)) {
				this.setResaltarpara_provisionesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARAUTILIDADES)) {
				this.setResaltarpara_utilidadesRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.PARARUBROIESS)) {
				this.setResaltarpara_rubro_iessRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESFONDORESERVA)) {
				this.setResaltares_fondo_reservaRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESDECIMOTERCERO)) {
				this.setResaltares_decimo_terceroRubroEmplea(esAsigna);
				continue;
			}

			if(campo.clase.equals(RubroEmpleaConstantesFunciones.ESDECIMOCUARTO)) {
				this.setResaltares_decimo_cuartoRubroEmplea(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarHistorialPagoNomiRubroEmplea=null;

	public Border getResaltarHistorialPagoNomiRubroEmplea() {
		return this.resaltarHistorialPagoNomiRubroEmplea;
	}

	public void setResaltarHistorialPagoNomiRubroEmplea(Border borderResaltarHistorialPagoNomi) {
		if(borderResaltarHistorialPagoNomi!=null) {
			this.resaltarHistorialPagoNomiRubroEmplea= borderResaltarHistorialPagoNomi;
		}
	}

	public Border setResaltarHistorialPagoNomiRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarHistorialPagoNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarHistorialPagoNomi);
			
		this.resaltarHistorialPagoNomiRubroEmplea= borderResaltarHistorialPagoNomi;

		 return borderResaltarHistorialPagoNomi;
	}



	public Boolean mostrarHistorialPagoNomiRubroEmplea=true;

	public Boolean getMostrarHistorialPagoNomiRubroEmplea() {
		return this.mostrarHistorialPagoNomiRubroEmplea;
	}

	public void setMostrarHistorialPagoNomiRubroEmplea(Boolean visibilidadResaltarHistorialPagoNomi) {
		this.mostrarHistorialPagoNomiRubroEmplea= visibilidadResaltarHistorialPagoNomi;
	}



	public Boolean activarHistorialPagoNomiRubroEmplea=true;

	public Boolean gethabilitarResaltarHistorialPagoNomiRubroEmplea() {
		return this.activarHistorialPagoNomiRubroEmplea;
	}

	public void setActivarHistorialPagoNomiRubroEmplea(Boolean habilitarResaltarHistorialPagoNomi) {
		this.activarHistorialPagoNomiRubroEmplea= habilitarResaltarHistorialPagoNomi;
	}


	public Border resaltarRubroEstructuraRubroEmplea=null;

	public Border getResaltarRubroEstructuraRubroEmplea() {
		return this.resaltarRubroEstructuraRubroEmplea;
	}

	public void setResaltarRubroEstructuraRubroEmplea(Border borderResaltarRubroEstructura) {
		if(borderResaltarRubroEstructura!=null) {
			this.resaltarRubroEstructuraRubroEmplea= borderResaltarRubroEstructura;
		}
	}

	public Border setResaltarRubroEstructuraRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarRubroEstructura);
			
		this.resaltarRubroEstructuraRubroEmplea= borderResaltarRubroEstructura;

		 return borderResaltarRubroEstructura;
	}



	public Boolean mostrarRubroEstructuraRubroEmplea=true;

	public Boolean getMostrarRubroEstructuraRubroEmplea() {
		return this.mostrarRubroEstructuraRubroEmplea;
	}

	public void setMostrarRubroEstructuraRubroEmplea(Boolean visibilidadResaltarRubroEstructura) {
		this.mostrarRubroEstructuraRubroEmplea= visibilidadResaltarRubroEstructura;
	}



	public Boolean activarRubroEstructuraRubroEmplea=true;

	public Boolean gethabilitarResaltarRubroEstructuraRubroEmplea() {
		return this.activarRubroEstructuraRubroEmplea;
	}

	public void setActivarRubroEstructuraRubroEmplea(Boolean habilitarResaltarRubroEstructura) {
		this.activarRubroEstructuraRubroEmplea= habilitarResaltarRubroEstructura;
	}


	public Border resaltarDefiProvisionEmpleadoRubroEmplea=null;

	public Border getResaltarDefiProvisionEmpleadoRubroEmplea() {
		return this.resaltarDefiProvisionEmpleadoRubroEmplea;
	}

	public void setResaltarDefiProvisionEmpleadoRubroEmplea(Border borderResaltarDefiProvisionEmpleado) {
		if(borderResaltarDefiProvisionEmpleado!=null) {
			this.resaltarDefiProvisionEmpleadoRubroEmplea= borderResaltarDefiProvisionEmpleado;
		}
	}

	public Border setResaltarDefiProvisionEmpleadoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarDefiProvisionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarDefiProvisionEmpleado);
			
		this.resaltarDefiProvisionEmpleadoRubroEmplea= borderResaltarDefiProvisionEmpleado;

		 return borderResaltarDefiProvisionEmpleado;
	}



	public Boolean mostrarDefiProvisionEmpleadoRubroEmplea=true;

	public Boolean getMostrarDefiProvisionEmpleadoRubroEmplea() {
		return this.mostrarDefiProvisionEmpleadoRubroEmplea;
	}

	public void setMostrarDefiProvisionEmpleadoRubroEmplea(Boolean visibilidadResaltarDefiProvisionEmpleado) {
		this.mostrarDefiProvisionEmpleadoRubroEmplea= visibilidadResaltarDefiProvisionEmpleado;
	}



	public Boolean activarDefiProvisionEmpleadoRubroEmplea=true;

	public Boolean gethabilitarResaltarDefiProvisionEmpleadoRubroEmplea() {
		return this.activarDefiProvisionEmpleadoRubroEmplea;
	}

	public void setActivarDefiProvisionEmpleadoRubroEmplea(Boolean habilitarResaltarDefiProvisionEmpleado) {
		this.activarDefiProvisionEmpleadoRubroEmplea= habilitarResaltarDefiProvisionEmpleado;
	}


	public Border resaltarEmpleadoPagoRubroRubroEmplea=null;

	public Border getResaltarEmpleadoPagoRubroRubroEmplea() {
		return this.resaltarEmpleadoPagoRubroRubroEmplea;
	}

	public void setResaltarEmpleadoPagoRubroRubroEmplea(Border borderResaltarEmpleadoPagoRubro) {
		if(borderResaltarEmpleadoPagoRubro!=null) {
			this.resaltarEmpleadoPagoRubroRubroEmplea= borderResaltarEmpleadoPagoRubro;
		}
	}

	public Border setResaltarEmpleadoPagoRubroRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoPagoRubro=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarEmpleadoPagoRubro);
			
		this.resaltarEmpleadoPagoRubroRubroEmplea= borderResaltarEmpleadoPagoRubro;

		 return borderResaltarEmpleadoPagoRubro;
	}



	public Boolean mostrarEmpleadoPagoRubroRubroEmplea=true;

	public Boolean getMostrarEmpleadoPagoRubroRubroEmplea() {
		return this.mostrarEmpleadoPagoRubroRubroEmplea;
	}

	public void setMostrarEmpleadoPagoRubroRubroEmplea(Boolean visibilidadResaltarEmpleadoPagoRubro) {
		this.mostrarEmpleadoPagoRubroRubroEmplea= visibilidadResaltarEmpleadoPagoRubro;
	}



	public Boolean activarEmpleadoPagoRubroRubroEmplea=true;

	public Boolean gethabilitarResaltarEmpleadoPagoRubroRubroEmplea() {
		return this.activarEmpleadoPagoRubroRubroEmplea;
	}

	public void setActivarEmpleadoPagoRubroRubroEmplea(Boolean habilitarResaltarEmpleadoPagoRubro) {
		this.activarEmpleadoPagoRubroRubroEmplea= habilitarResaltarEmpleadoPagoRubro;
	}


	public Border resaltarHistorialPagoMesNomiRubroEmplea=null;

	public Border getResaltarHistorialPagoMesNomiRubroEmplea() {
		return this.resaltarHistorialPagoMesNomiRubroEmplea;
	}

	public void setResaltarHistorialPagoMesNomiRubroEmplea(Border borderResaltarHistorialPagoMesNomi) {
		if(borderResaltarHistorialPagoMesNomi!=null) {
			this.resaltarHistorialPagoMesNomiRubroEmplea= borderResaltarHistorialPagoMesNomi;
		}
	}

	public Border setResaltarHistorialPagoMesNomiRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarHistorialPagoMesNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarHistorialPagoMesNomi);
			
		this.resaltarHistorialPagoMesNomiRubroEmplea= borderResaltarHistorialPagoMesNomi;

		 return borderResaltarHistorialPagoMesNomi;
	}



	public Boolean mostrarHistorialPagoMesNomiRubroEmplea=true;

	public Boolean getMostrarHistorialPagoMesNomiRubroEmplea() {
		return this.mostrarHistorialPagoMesNomiRubroEmplea;
	}

	public void setMostrarHistorialPagoMesNomiRubroEmplea(Boolean visibilidadResaltarHistorialPagoMesNomi) {
		this.mostrarHistorialPagoMesNomiRubroEmplea= visibilidadResaltarHistorialPagoMesNomi;
	}



	public Boolean activarHistorialPagoMesNomiRubroEmplea=true;

	public Boolean gethabilitarResaltarHistorialPagoMesNomiRubroEmplea() {
		return this.activarHistorialPagoMesNomiRubroEmplea;
	}

	public void setActivarHistorialPagoMesNomiRubroEmplea(Boolean habilitarResaltarHistorialPagoMesNomi) {
		this.activarHistorialPagoMesNomiRubroEmplea= habilitarResaltarHistorialPagoMesNomi;
	}


	public Border resaltarRubroEmpleadoRubroEmplea=null;

	public Border getResaltarRubroEmpleadoRubroEmplea() {
		return this.resaltarRubroEmpleadoRubroEmplea;
	}

	public void setResaltarRubroEmpleadoRubroEmplea(Border borderResaltarRubroEmpleado) {
		if(borderResaltarRubroEmpleado!=null) {
			this.resaltarRubroEmpleadoRubroEmplea= borderResaltarRubroEmpleado;
		}
	}

	public Border setResaltarRubroEmpleadoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarRubroEmpleado);
			
		this.resaltarRubroEmpleadoRubroEmplea= borderResaltarRubroEmpleado;

		 return borderResaltarRubroEmpleado;
	}



	public Boolean mostrarRubroEmpleadoRubroEmplea=true;

	public Boolean getMostrarRubroEmpleadoRubroEmplea() {
		return this.mostrarRubroEmpleadoRubroEmplea;
	}

	public void setMostrarRubroEmpleadoRubroEmplea(Boolean visibilidadResaltarRubroEmpleado) {
		this.mostrarRubroEmpleadoRubroEmplea= visibilidadResaltarRubroEmpleado;
	}



	public Boolean activarRubroEmpleadoRubroEmplea=true;

	public Boolean gethabilitarResaltarRubroEmpleadoRubroEmplea() {
		return this.activarRubroEmpleadoRubroEmplea;
	}

	public void setActivarRubroEmpleadoRubroEmplea(Boolean habilitarResaltarRubroEmpleado) {
		this.activarRubroEmpleadoRubroEmplea= habilitarResaltarRubroEmpleado;
	}


	public Border resaltarValorRubroVariableRubroEmplea=null;

	public Border getResaltarValorRubroVariableRubroEmplea() {
		return this.resaltarValorRubroVariableRubroEmplea;
	}

	public void setResaltarValorRubroVariableRubroEmplea(Border borderResaltarValorRubroVariable) {
		if(borderResaltarValorRubroVariable!=null) {
			this.resaltarValorRubroVariableRubroEmplea= borderResaltarValorRubroVariable;
		}
	}

	public Border setResaltarValorRubroVariableRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarValorRubroVariable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarValorRubroVariable);
			
		this.resaltarValorRubroVariableRubroEmplea= borderResaltarValorRubroVariable;

		 return borderResaltarValorRubroVariable;
	}



	public Boolean mostrarValorRubroVariableRubroEmplea=true;

	public Boolean getMostrarValorRubroVariableRubroEmplea() {
		return this.mostrarValorRubroVariableRubroEmplea;
	}

	public void setMostrarValorRubroVariableRubroEmplea(Boolean visibilidadResaltarValorRubroVariable) {
		this.mostrarValorRubroVariableRubroEmplea= visibilidadResaltarValorRubroVariable;
	}



	public Boolean activarValorRubroVariableRubroEmplea=true;

	public Boolean gethabilitarResaltarValorRubroVariableRubroEmplea() {
		return this.activarValorRubroVariableRubroEmplea;
	}

	public void setActivarValorRubroVariableRubroEmplea(Boolean habilitarResaltarValorRubroVariable) {
		this.activarValorRubroVariableRubroEmplea= habilitarResaltarValorRubroVariable;
	}


	public Border resaltarTipoPrestamoRubroEmplea=null;

	public Border getResaltarTipoPrestamoRubroEmplea() {
		return this.resaltarTipoPrestamoRubroEmplea;
	}

	public void setResaltarTipoPrestamoRubroEmplea(Border borderResaltarTipoPrestamo) {
		if(borderResaltarTipoPrestamo!=null) {
			this.resaltarTipoPrestamoRubroEmplea= borderResaltarTipoPrestamo;
		}
	}

	public Border setResaltarTipoPrestamoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarTipoPrestamo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarTipoPrestamo);
			
		this.resaltarTipoPrestamoRubroEmplea= borderResaltarTipoPrestamo;

		 return borderResaltarTipoPrestamo;
	}



	public Boolean mostrarTipoPrestamoRubroEmplea=true;

	public Boolean getMostrarTipoPrestamoRubroEmplea() {
		return this.mostrarTipoPrestamoRubroEmplea;
	}

	public void setMostrarTipoPrestamoRubroEmplea(Boolean visibilidadResaltarTipoPrestamo) {
		this.mostrarTipoPrestamoRubroEmplea= visibilidadResaltarTipoPrestamo;
	}



	public Boolean activarTipoPrestamoRubroEmplea=true;

	public Boolean gethabilitarResaltarTipoPrestamoRubroEmplea() {
		return this.activarTipoPrestamoRubroEmplea;
	}

	public void setActivarTipoPrestamoRubroEmplea(Boolean habilitarResaltarTipoPrestamo) {
		this.activarTipoPrestamoRubroEmplea= habilitarResaltarTipoPrestamo;
	}


	public Border resaltarRubroEmpleaCuentaContableRubroEmplea=null;

	public Border getResaltarRubroEmpleaCuentaContableRubroEmplea() {
		return this.resaltarRubroEmpleaCuentaContableRubroEmplea;
	}

	public void setResaltarRubroEmpleaCuentaContableRubroEmplea(Border borderResaltarRubroEmpleaCuentaContable) {
		if(borderResaltarRubroEmpleaCuentaContable!=null) {
			this.resaltarRubroEmpleaCuentaContableRubroEmplea= borderResaltarRubroEmpleaCuentaContable;
		}
	}

	public Border setResaltarRubroEmpleaCuentaContableRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEmpleaCuentaContable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rubroempleaBeanSwingJInternalFrame.jTtoolBarRubroEmplea.setBorder(borderResaltarRubroEmpleaCuentaContable);
			
		this.resaltarRubroEmpleaCuentaContableRubroEmplea= borderResaltarRubroEmpleaCuentaContable;

		 return borderResaltarRubroEmpleaCuentaContable;
	}



	public Boolean mostrarRubroEmpleaCuentaContableRubroEmplea=true;

	public Boolean getMostrarRubroEmpleaCuentaContableRubroEmplea() {
		return this.mostrarRubroEmpleaCuentaContableRubroEmplea;
	}

	public void setMostrarRubroEmpleaCuentaContableRubroEmplea(Boolean visibilidadResaltarRubroEmpleaCuentaContable) {
		this.mostrarRubroEmpleaCuentaContableRubroEmplea= visibilidadResaltarRubroEmpleaCuentaContable;
	}



	public Boolean activarRubroEmpleaCuentaContableRubroEmplea=true;

	public Boolean gethabilitarResaltarRubroEmpleaCuentaContableRubroEmplea() {
		return this.activarRubroEmpleaCuentaContableRubroEmplea;
	}

	public void setActivarRubroEmpleaCuentaContableRubroEmplea(Boolean habilitarResaltarRubroEmpleaCuentaContable) {
		this.activarRubroEmpleaCuentaContableRubroEmplea= habilitarResaltarRubroEmpleaCuentaContable;
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

		this.setMostrarHistorialPagoNomiRubroEmplea(esInicial);
		this.setMostrarRubroEstructuraRubroEmplea(esInicial);
		this.setMostrarDefiProvisionEmpleadoRubroEmplea(esInicial);
		this.setMostrarEmpleadoPagoRubroRubroEmplea(esInicial);
		this.setMostrarHistorialPagoMesNomiRubroEmplea(esInicial);
		this.setMostrarRubroEmpleadoRubroEmplea(esInicial);
		this.setMostrarValorRubroVariableRubroEmplea(esInicial);
		this.setMostrarTipoPrestamoRubroEmplea(esInicial);
		this.setMostrarRubroEmpleaCuentaContableRubroEmplea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(HistorialPagoNomi.class)) {
				this.setMostrarHistorialPagoNomiRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEstructura.class)) {
				this.setMostrarRubroEstructuraRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DefiProvisionEmpleado.class)) {
				this.setMostrarDefiProvisionEmpleadoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoPagoRubro.class)) {
				this.setMostrarEmpleadoPagoRubroRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoMesNomi.class)) {
				this.setMostrarHistorialPagoMesNomiRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setMostrarRubroEmpleadoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ValorRubroVariable.class)) {
				this.setMostrarValorRubroVariableRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoPrestamo.class)) {
				this.setMostrarTipoPrestamoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleaCuentaContable.class)) {
				this.setMostrarRubroEmpleaCuentaContableRubroEmplea(esAsigna);
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

		this.setActivarHistorialPagoNomiRubroEmplea(esInicial);
		this.setActivarRubroEstructuraRubroEmplea(esInicial);
		this.setActivarDefiProvisionEmpleadoRubroEmplea(esInicial);
		this.setActivarEmpleadoPagoRubroRubroEmplea(esInicial);
		this.setActivarHistorialPagoMesNomiRubroEmplea(esInicial);
		this.setActivarRubroEmpleadoRubroEmplea(esInicial);
		this.setActivarValorRubroVariableRubroEmplea(esInicial);
		this.setActivarTipoPrestamoRubroEmplea(esInicial);
		this.setActivarRubroEmpleaCuentaContableRubroEmplea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(HistorialPagoNomi.class)) {
				this.setActivarHistorialPagoNomiRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEstructura.class)) {
				this.setActivarRubroEstructuraRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DefiProvisionEmpleado.class)) {
				this.setActivarDefiProvisionEmpleadoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoPagoRubro.class)) {
				this.setActivarEmpleadoPagoRubroRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoMesNomi.class)) {
				this.setActivarHistorialPagoMesNomiRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setActivarRubroEmpleadoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ValorRubroVariable.class)) {
				this.setActivarValorRubroVariableRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoPrestamo.class)) {
				this.setActivarTipoPrestamoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleaCuentaContable.class)) {
				this.setActivarRubroEmpleaCuentaContableRubroEmplea(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarHistorialPagoNomiRubroEmplea(esInicial);
		this.setResaltarRubroEstructuraRubroEmplea(esInicial);
		this.setResaltarDefiProvisionEmpleadoRubroEmplea(esInicial);
		this.setResaltarEmpleadoPagoRubroRubroEmplea(esInicial);
		this.setResaltarHistorialPagoMesNomiRubroEmplea(esInicial);
		this.setResaltarRubroEmpleadoRubroEmplea(esInicial);
		this.setResaltarValorRubroVariableRubroEmplea(esInicial);
		this.setResaltarTipoPrestamoRubroEmplea(esInicial);
		this.setResaltarRubroEmpleaCuentaContableRubroEmplea(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(HistorialPagoNomi.class)) {
				this.setResaltarHistorialPagoNomiRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEstructura.class)) {
				this.setResaltarRubroEstructuraRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(DefiProvisionEmpleado.class)) {
				this.setResaltarDefiProvisionEmpleadoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoPagoRubro.class)) {
				this.setResaltarEmpleadoPagoRubroRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoMesNomi.class)) {
				this.setResaltarHistorialPagoMesNomiRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setResaltarRubroEmpleadoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(ValorRubroVariable.class)) {
				this.setResaltarValorRubroVariableRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoPrestamo.class)) {
				this.setResaltarTipoPrestamoRubroEmplea(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleaCuentaContable.class)) {
				this.setResaltarRubroEmpleaCuentaContableRubroEmplea(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaRubroEmplea=true;

	public Boolean getMostrarFK_IdEmpresaRubroEmplea() {
		return this.mostrarFK_IdEmpresaRubroEmplea;
	}

	public void setMostrarFK_IdEmpresaRubroEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRubroEmplea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCalculoRubroEmplea=true;

	public Boolean getMostrarFK_IdTipoCalculoRubroEmplea() {
		return this.mostrarFK_IdTipoCalculoRubroEmplea;
	}

	public void setMostrarFK_IdTipoCalculoRubroEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCalculoRubroEmplea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGrupoRubroEmpleaRubroEmplea=true;

	public Boolean getMostrarFK_IdTipoGrupoRubroEmpleaRubroEmplea() {
		return this.mostrarFK_IdTipoGrupoRubroEmpleaRubroEmplea;
	}

	public void setMostrarFK_IdTipoGrupoRubroEmpleaRubroEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGrupoRubroEmpleaRubroEmplea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRubroEmpleaRubroEmplea=true;

	public Boolean getMostrarFK_IdTipoRubroEmpleaRubroEmplea() {
		return this.mostrarFK_IdTipoRubroEmpleaRubroEmplea;
	}

	public void setMostrarFK_IdTipoRubroEmpleaRubroEmplea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRubroEmpleaRubroEmplea= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRubroEmplea=true;

	public Boolean getActivarFK_IdEmpresaRubroEmplea() {
		return this.activarFK_IdEmpresaRubroEmplea;
	}

	public void setActivarFK_IdEmpresaRubroEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRubroEmplea= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCalculoRubroEmplea=true;

	public Boolean getActivarFK_IdTipoCalculoRubroEmplea() {
		return this.activarFK_IdTipoCalculoRubroEmplea;
	}

	public void setActivarFK_IdTipoCalculoRubroEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCalculoRubroEmplea= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGrupoRubroEmpleaRubroEmplea=true;

	public Boolean getActivarFK_IdTipoGrupoRubroEmpleaRubroEmplea() {
		return this.activarFK_IdTipoGrupoRubroEmpleaRubroEmplea;
	}

	public void setActivarFK_IdTipoGrupoRubroEmpleaRubroEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGrupoRubroEmpleaRubroEmplea= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRubroEmpleaRubroEmplea=true;

	public Boolean getActivarFK_IdTipoRubroEmpleaRubroEmplea() {
		return this.activarFK_IdTipoRubroEmpleaRubroEmplea;
	}

	public void setActivarFK_IdTipoRubroEmpleaRubroEmplea(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRubroEmpleaRubroEmplea= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRubroEmplea=null;

	public Border getResaltarFK_IdEmpresaRubroEmplea() {
		return this.resaltarFK_IdEmpresaRubroEmplea;
	}

	public void setResaltarFK_IdEmpresaRubroEmplea(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRubroEmplea= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRubroEmplea= borderResaltar;
	}

	public Border resaltarFK_IdTipoCalculoRubroEmplea=null;

	public Border getResaltarFK_IdTipoCalculoRubroEmplea() {
		return this.resaltarFK_IdTipoCalculoRubroEmplea;
	}

	public void setResaltarFK_IdTipoCalculoRubroEmplea(Border borderResaltar) {
		this.resaltarFK_IdTipoCalculoRubroEmplea= borderResaltar;
	}

	public void setResaltarFK_IdTipoCalculoRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCalculoRubroEmplea= borderResaltar;
	}

	public Border resaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea=null;

	public Border getResaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea() {
		return this.resaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea;
	}

	public void setResaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea(Border borderResaltar) {
		this.resaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea= borderResaltar;
	}

	public void setResaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGrupoRubroEmpleaRubroEmplea= borderResaltar;
	}

	public Border resaltarFK_IdTipoRubroEmpleaRubroEmplea=null;

	public Border getResaltarFK_IdTipoRubroEmpleaRubroEmplea() {
		return this.resaltarFK_IdTipoRubroEmpleaRubroEmplea;
	}

	public void setResaltarFK_IdTipoRubroEmpleaRubroEmplea(Border borderResaltar) {
		this.resaltarFK_IdTipoRubroEmpleaRubroEmplea= borderResaltar;
	}

	public void setResaltarFK_IdTipoRubroEmpleaRubroEmplea(ParametroGeneralUsuario parametroGeneralUsuario/*RubroEmpleaBeanSwingJInternalFrame rubroempleaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRubroEmpleaRubroEmplea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}