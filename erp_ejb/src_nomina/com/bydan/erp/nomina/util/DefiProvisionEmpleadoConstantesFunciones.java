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


import com.bydan.erp.nomina.util.DefiProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.DefiProvisionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DefiProvisionEmpleadoParameterGeneral;

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
final public class DefiProvisionEmpleadoConstantesFunciones extends DefiProvisionEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DefiProvisionEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DefiProvisionEmpleado"+DefiProvisionEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DefiProvisionEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DefiProvisionEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DefiProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DefiProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"_"+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DefiProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DefiProvisionEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DefiProvisionEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DefiProvisionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DefiProvisionEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DefiProvisionEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DefiProvisionEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Defi Provision Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Defi Provision Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Defi Provision Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DefiProvisionEmpleado";
	public static final String OBJECTNAME="defiprovisionempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="defi_provision_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select defiprovisionempleado from "+DefiProvisionEmpleadoConstantesFunciones.SPERSISTENCENAME+" defiprovisionempleado";
	public static String QUERYSELECTNATIVE="select "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_rubro_emplea,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_formato,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".nombre,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".dia_inicial,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_mes_inicial,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".dia_final,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_mes_final,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".para_liquidacion,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".descripcion from "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+DefiProvisionEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DefiProvisionEmpleadoConstantesFuncionesAdditional defiprovisionempleadoConstantesFuncionesAdditional=null;
	
	public DefiProvisionEmpleadoConstantesFuncionesAdditional getDefiProvisionEmpleadoConstantesFuncionesAdditional() {
		return this.defiprovisionempleadoConstantesFuncionesAdditional;
	}
	
	public void setDefiProvisionEmpleadoConstantesFuncionesAdditional(DefiProvisionEmpleadoConstantesFuncionesAdditional defiprovisionempleadoConstantesFuncionesAdditional) {
		try {
			this.defiprovisionempleadoConstantesFuncionesAdditional=defiprovisionempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDFORMATO= "id_formato";
    public static final String NOMBRE= "nombre";
    public static final String DIAINICIAL= "dia_inicial";
    public static final String IDMESINICIAL= "id_mes_inicial";
    public static final String DIAFINAL= "dia_final";
    public static final String IDMESFINAL= "id_mes_final";
    public static final String PARALIQUIDACION= "para_liquidacion";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIAINICIAL= "Dia Inicial";
		public static final String LABEL_DIAINICIAL_LOWER= "Dia Inicial";
    	public static final String LABEL_IDMESINICIAL= "Mes Inicial";
		public static final String LABEL_IDMESINICIAL_LOWER= "Mes Inicial";
    	public static final String LABEL_DIAFINAL= "Dia Final";
		public static final String LABEL_DIAFINAL_LOWER= "Dia Final";
    	public static final String LABEL_IDMESFINAL= "Mes Final";
		public static final String LABEL_IDMESFINAL_LOWER= "Mes Final";
    	public static final String LABEL_PARALIQUIDACION= "Para Liquacion";
		public static final String LABEL_PARALIQUIDACION_LOWER= "Para Liquidacion";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDefiProvisionEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.IDFORMATO)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.NOMBRE)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAINICIAL;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESINICIAL;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.DIAFINAL)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAFINAL;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESFINAL;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_PARALIQUIDACION;}
		if(sNombreColumna.equals(DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DefiProvisionEmpleadoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getpara_liquidacionDescripcion(DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!defiprovisionempleado.getpara_liquidacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpara_liquidacionHtmlDescripcion(DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(defiprovisionempleado.getId(),defiprovisionempleado.getpara_liquidacion());

		return sDescripcion;
	}	
			
	
	public static String getDefiProvisionEmpleadoDescripcion(DefiProvisionEmpleado defiprovisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(defiprovisionempleado !=null/* && defiprovisionempleado.getId()!=0*/) {
			sDescripcion=defiprovisionempleado.getnombre();//defiprovisionempleadodefiprovisionempleado.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDefiProvisionEmpleadoDescripcionDetallado(DefiProvisionEmpleado defiprovisionempleado) {
		String sDescripcion="";
			
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=defiprovisionempleado.getId().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=defiprovisionempleado.getVersionRow().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=defiprovisionempleado.getid_empresa().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=defiprovisionempleado.getid_rubro_emplea().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=defiprovisionempleado.getid_formato().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=defiprovisionempleado.getnombre()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL+"=";
		sDescripcion+=defiprovisionempleado.getdia_inicial().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL+"=";
		sDescripcion+=defiprovisionempleado.getid_mes_inicial().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.DIAFINAL+"=";
		sDescripcion+=defiprovisionempleado.getdia_final().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL+"=";
		sDescripcion+=defiprovisionempleado.getid_mes_final().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION+"=";
		sDescripcion+=defiprovisionempleado.getpara_liquidacion().toString()+",";
		sDescripcion+=DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=defiprovisionempleado.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDefiProvisionEmpleadoDescripcion(DefiProvisionEmpleado defiprovisionempleado,String sValor) throws Exception {			
		if(defiprovisionempleado !=null) {
			defiprovisionempleado.setnombre(sValor);;//defiprovisionempleadodefiprovisionempleado.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rubroemplea!=null/*&&rubroemplea.getId()>0*/) {
			sDescripcion=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroemplea);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getMesInicialDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getMesFinalDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
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
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMesFinal")) {
			sNombreIndice="Tipo=  Por Mes Final";
		} else if(sNombreIndice.equals("FK_IdMesInicial")) {
			sNombreIndice="Tipo=  Por Mes Inicial";
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
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

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesFinal(Long id_mes_final) {
		String sDetalleIndice=" Parametros->";
		if(id_mes_final!=null) {sDetalleIndice+=" Codigo Unico De Mes Final="+id_mes_final.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesInicial(Long id_mes_inicial) {
		String sDetalleIndice=" Parametros->";
		if(id_mes_inicial!=null) {sDetalleIndice+=" Codigo Unico De Mes Inicial="+id_mes_inicial.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		defiprovisionempleado.setnombre(defiprovisionempleado.getnombre().trim());
		defiprovisionempleado.setdescripcion(defiprovisionempleado.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDefiProvisionEmpleados(List<DefiProvisionEmpleado> defiprovisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DefiProvisionEmpleado defiprovisionempleado: defiprovisionempleados) {
			defiprovisionempleado.setnombre(defiprovisionempleado.getnombre().trim());
			defiprovisionempleado.setdescripcion(defiprovisionempleado.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && defiprovisionempleado.getConCambioAuxiliar()) {
			defiprovisionempleado.setIsDeleted(defiprovisionempleado.getIsDeletedAuxiliar());	
			defiprovisionempleado.setIsNew(defiprovisionempleado.getIsNewAuxiliar());	
			defiprovisionempleado.setIsChanged(defiprovisionempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			defiprovisionempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			defiprovisionempleado.setIsDeletedAuxiliar(false);	
			defiprovisionempleado.setIsNewAuxiliar(false);	
			defiprovisionempleado.setIsChangedAuxiliar(false);
			
			defiprovisionempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDefiProvisionEmpleados(List<DefiProvisionEmpleado> defiprovisionempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DefiProvisionEmpleado defiprovisionempleado : defiprovisionempleados) {
			if(conAsignarBase && defiprovisionempleado.getConCambioAuxiliar()) {
				defiprovisionempleado.setIsDeleted(defiprovisionempleado.getIsDeletedAuxiliar());	
				defiprovisionempleado.setIsNew(defiprovisionempleado.getIsNewAuxiliar());	
				defiprovisionempleado.setIsChanged(defiprovisionempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				defiprovisionempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				defiprovisionempleado.setIsDeletedAuxiliar(false);	
				defiprovisionempleado.setIsNewAuxiliar(false);	
				defiprovisionempleado.setIsChangedAuxiliar(false);
				
				defiprovisionempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			defiprovisionempleado.setdia_inicial(0);
			defiprovisionempleado.setdia_final(0);
		}
	}		
	
	public static void InicializarValoresDefiProvisionEmpleados(List<DefiProvisionEmpleado> defiprovisionempleados,Boolean conEnteros) throws Exception  {
		
		for(DefiProvisionEmpleado defiprovisionempleado: defiprovisionempleados) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				defiprovisionempleado.setdia_inicial(0);
				defiprovisionempleado.setdia_final(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDefiProvisionEmpleado(List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleado defiprovisionempleadoAux) throws Exception  {
		DefiProvisionEmpleadoConstantesFunciones.InicializarValoresDefiProvisionEmpleado(defiprovisionempleadoAux,true);
		
		for(DefiProvisionEmpleado defiprovisionempleado: defiprovisionempleados) {
			if(defiprovisionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			defiprovisionempleadoAux.setdia_inicial(defiprovisionempleadoAux.getdia_inicial()+defiprovisionempleado.getdia_inicial());			
			defiprovisionempleadoAux.setdia_final(defiprovisionempleadoAux.getdia_final()+defiprovisionempleado.getdia_final());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDefiProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DefiProvisionEmpleadoConstantesFunciones.getArrayColumnasGlobalesDefiProvisionEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDefiProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDefiProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleado defiprovisionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DefiProvisionEmpleado defiprovisionempleadoAux: defiprovisionempleados) {
			if(defiprovisionempleadoAux!=null && defiprovisionempleado!=null) {
				if((defiprovisionempleadoAux.getId()==null && defiprovisionempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(defiprovisionempleadoAux.getId()!=null && defiprovisionempleado.getId()!=null){
					if(defiprovisionempleadoAux.getId().equals(defiprovisionempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDefiProvisionEmpleado(List<DefiProvisionEmpleado> defiprovisionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DefiProvisionEmpleado defiprovisionempleado: defiprovisionempleados) {			
			if(defiprovisionempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDefiProvisionEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_ID, DefiProvisionEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_VERSIONROW, DefiProvisionEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA, DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA, DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_IDFORMATO, DefiProvisionEmpleadoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE, DefiProvisionEmpleadoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAINICIAL, DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESINICIAL, DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAFINAL, DefiProvisionEmpleadoConstantesFunciones.DIAFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESFINAL, DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_PARALIQUIDACION, DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DefiProvisionEmpleadoConstantesFunciones.LABEL_DESCRIPCION, DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDefiProvisionEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.DIAFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDefiProvisionEmpleado() throws Exception  {
		return DefiProvisionEmpleadoConstantesFunciones.getTiposSeleccionarDefiProvisionEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDefiProvisionEmpleado(Boolean conFk) throws Exception  {
		return DefiProvisionEmpleadoConstantesFunciones.getTiposSeleccionarDefiProvisionEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDefiProvisionEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAINICIAL);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESINICIAL);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAFINAL);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESFINAL);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_PARALIQUIDACION);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_PARALIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DefiProvisionEmpleadoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DefiProvisionEmpleadoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDefiProvisionEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleadoAux) throws Exception {
		
			defiprovisionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(defiprovisionempleadoAux.getEmpresa()));
			defiprovisionempleadoAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(defiprovisionempleadoAux.getRubroEmplea()));
			defiprovisionempleadoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(defiprovisionempleadoAux.getFormato()));
			defiprovisionempleadoAux.setmesinicial_descripcion(MesConstantesFunciones.getMesDescripcion(defiprovisionempleadoAux.getMesInicial()));
			defiprovisionempleadoAux.setmesfinal_descripcion(MesConstantesFunciones.getMesDescripcion(defiprovisionempleadoAux.getMesFinal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDefiProvisionEmpleado(List<DefiProvisionEmpleado> defiprovisionempleadosTemp) throws Exception {
		for(DefiProvisionEmpleado defiprovisionempleadoAux:defiprovisionempleadosTemp) {
			
			defiprovisionempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(defiprovisionempleadoAux.getEmpresa()));
			defiprovisionempleadoAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(defiprovisionempleadoAux.getRubroEmplea()));
			defiprovisionempleadoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(defiprovisionempleadoAux.getFormato()));
			defiprovisionempleadoAux.setmesinicial_descripcion(MesConstantesFunciones.getMesDescripcion(defiprovisionempleadoAux.getMesInicial()));
			defiprovisionempleadoAux.setmesfinal_descripcion(MesConstantesFunciones.getMesDescripcion(defiprovisionempleadoAux.getMesFinal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDefiProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDefiProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDefiProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DefiProvisionEmpleadoConstantesFunciones.getClassesRelationshipsOfDefiProvisionEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDefiProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProvisionEmpleado.class));
				classes.add(new Classe(Cuota.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProvisionEmpleado.class)) {
						classes.add(new Classe(ProvisionEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cuota.class)) {
						classes.add(new Classe(Cuota.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDefiProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DefiProvisionEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfDefiProvisionEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDefiProvisionEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProvisionEmpleado.class)); continue;
					}

					if(Cuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cuota.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProvisionEmpleado.class)); continue;
					}

					if(Cuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cuota.class)); continue;
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
	public static void actualizarLista(DefiProvisionEmpleado defiprovisionempleado,List<DefiProvisionEmpleado> defiprovisionempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DefiProvisionEmpleado defiprovisionempleadoEncontrado=null;
			
			for(DefiProvisionEmpleado defiprovisionempleadoLocal:defiprovisionempleados) {
				if(defiprovisionempleadoLocal.getId().equals(defiprovisionempleado.getId())) {
					defiprovisionempleadoEncontrado=defiprovisionempleadoLocal;
					
					defiprovisionempleadoLocal.setIsChanged(defiprovisionempleado.getIsChanged());
					defiprovisionempleadoLocal.setIsNew(defiprovisionempleado.getIsNew());
					defiprovisionempleadoLocal.setIsDeleted(defiprovisionempleado.getIsDeleted());
					
					defiprovisionempleadoLocal.setGeneralEntityOriginal(defiprovisionempleado.getGeneralEntityOriginal());
					
					defiprovisionempleadoLocal.setId(defiprovisionempleado.getId());	
					defiprovisionempleadoLocal.setVersionRow(defiprovisionempleado.getVersionRow());	
					defiprovisionempleadoLocal.setid_empresa(defiprovisionempleado.getid_empresa());	
					defiprovisionempleadoLocal.setid_rubro_emplea(defiprovisionempleado.getid_rubro_emplea());	
					defiprovisionempleadoLocal.setid_formato(defiprovisionempleado.getid_formato());	
					defiprovisionempleadoLocal.setnombre(defiprovisionempleado.getnombre());	
					defiprovisionempleadoLocal.setdia_inicial(defiprovisionempleado.getdia_inicial());	
					defiprovisionempleadoLocal.setid_mes_inicial(defiprovisionempleado.getid_mes_inicial());	
					defiprovisionempleadoLocal.setdia_final(defiprovisionempleado.getdia_final());	
					defiprovisionempleadoLocal.setid_mes_final(defiprovisionempleado.getid_mes_final());	
					defiprovisionempleadoLocal.setpara_liquidacion(defiprovisionempleado.getpara_liquidacion());	
					defiprovisionempleadoLocal.setdescripcion(defiprovisionempleado.getdescripcion());	
					
					
					defiprovisionempleadoLocal.setProvisionEmpleados(defiprovisionempleado.getProvisionEmpleados());
					defiprovisionempleadoLocal.setCuotas(defiprovisionempleado.getCuotas());
					
					existe=true;
					break;
				}
			}
			
			if(!defiprovisionempleado.getIsDeleted()) {
				if(!existe) {
					defiprovisionempleados.add(defiprovisionempleado);
				}
			} else {
				if(defiprovisionempleadoEncontrado!=null && permiteQuitar)  {
					defiprovisionempleados.remove(defiprovisionempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DefiProvisionEmpleado defiprovisionempleado,List<DefiProvisionEmpleado> defiprovisionempleados) throws Exception {
		try	{			
			for(DefiProvisionEmpleado defiprovisionempleadoLocal:defiprovisionempleados) {
				if(defiprovisionempleadoLocal.getId().equals(defiprovisionempleado.getId())) {
					defiprovisionempleadoLocal.setIsSelected(defiprovisionempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDefiProvisionEmpleado(List<DefiProvisionEmpleado> defiprovisionempleadosAux) throws Exception {
		//this.defiprovisionempleadosAux=defiprovisionempleadosAux;
		
		for(DefiProvisionEmpleado defiprovisionempleadoAux:defiprovisionempleadosAux) {
			if(defiprovisionempleadoAux.getIsChanged()) {
				defiprovisionempleadoAux.setIsChanged(false);
			}		
			
			if(defiprovisionempleadoAux.getIsNew()) {
				defiprovisionempleadoAux.setIsNew(false);
			}	
			
			if(defiprovisionempleadoAux.getIsDeleted()) {
				defiprovisionempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleadoAux) throws Exception {
		//this.defiprovisionempleadoAux=defiprovisionempleadoAux;
		
			if(defiprovisionempleadoAux.getIsChanged()) {
				defiprovisionempleadoAux.setIsChanged(false);
			}		
			
			if(defiprovisionempleadoAux.getIsNew()) {
				defiprovisionempleadoAux.setIsNew(false);
			}	
			
			if(defiprovisionempleadoAux.getIsDeleted()) {
				defiprovisionempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DefiProvisionEmpleado defiprovisionempleadoAsignar,DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		defiprovisionempleadoAsignar.setId(defiprovisionempleado.getId());	
		defiprovisionempleadoAsignar.setVersionRow(defiprovisionempleado.getVersionRow());	
		defiprovisionempleadoAsignar.setid_empresa(defiprovisionempleado.getid_empresa());
		defiprovisionempleadoAsignar.setempresa_descripcion(defiprovisionempleado.getempresa_descripcion());	
		defiprovisionempleadoAsignar.setid_rubro_emplea(defiprovisionempleado.getid_rubro_emplea());
		defiprovisionempleadoAsignar.setrubroemplea_descripcion(defiprovisionempleado.getrubroemplea_descripcion());	
		defiprovisionempleadoAsignar.setid_formato(defiprovisionempleado.getid_formato());
		defiprovisionempleadoAsignar.setformato_descripcion(defiprovisionempleado.getformato_descripcion());	
		defiprovisionempleadoAsignar.setnombre(defiprovisionempleado.getnombre());	
		defiprovisionempleadoAsignar.setdia_inicial(defiprovisionempleado.getdia_inicial());	
		defiprovisionempleadoAsignar.setid_mes_inicial(defiprovisionempleado.getid_mes_inicial());
		defiprovisionempleadoAsignar.setmesinicial_descripcion(defiprovisionempleado.getmesinicial_descripcion());	
		defiprovisionempleadoAsignar.setdia_final(defiprovisionempleado.getdia_final());	
		defiprovisionempleadoAsignar.setid_mes_final(defiprovisionempleado.getid_mes_final());
		defiprovisionempleadoAsignar.setmesfinal_descripcion(defiprovisionempleado.getmesfinal_descripcion());	
		defiprovisionempleadoAsignar.setpara_liquidacion(defiprovisionempleado.getpara_liquidacion());	
		defiprovisionempleadoAsignar.setdescripcion(defiprovisionempleado.getdescripcion());	
	}
	
	public static void inicializarDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		try {
				defiprovisionempleado.setId(0L);	
					
				defiprovisionempleado.setid_empresa(-1L);	
				defiprovisionempleado.setid_rubro_emplea(-1L);	
				defiprovisionempleado.setid_formato(-1L);	
				defiprovisionempleado.setnombre("");	
				defiprovisionempleado.setdia_inicial(0);	
				defiprovisionempleado.setid_mes_inicial(-1L);	
				defiprovisionempleado.setdia_final(0);	
				defiprovisionempleado.setid_mes_final(-1L);	
				defiprovisionempleado.setpara_liquidacion(false);	
				defiprovisionempleado.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDefiProvisionEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_DIAFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_IDMESFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_PARALIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DefiProvisionEmpleadoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDefiProvisionEmpleado(String sTipo,Row row,Workbook workbook,DefiProvisionEmpleado defiprovisionempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getdia_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getmesinicial_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getdia_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getmesfinal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(defiprovisionempleado.getpara_liquidacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(defiprovisionempleado.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDefiProvisionEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDefiProvisionEmpleado() {
		return this.sFinalQueryDefiProvisionEmpleado;
	}
	
	public void setsFinalQueryDefiProvisionEmpleado(String sFinalQueryDefiProvisionEmpleado) {
		this.sFinalQueryDefiProvisionEmpleado= sFinalQueryDefiProvisionEmpleado;
	}
	
	public Border resaltarSeleccionarDefiProvisionEmpleado=null;
	
	public Border setResaltarSeleccionarDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDefiProvisionEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDefiProvisionEmpleado() {
		return this.resaltarSeleccionarDefiProvisionEmpleado;
	}
	
	public void setResaltarSeleccionarDefiProvisionEmpleado(Border borderResaltarSeleccionarDefiProvisionEmpleado) {
		this.resaltarSeleccionarDefiProvisionEmpleado= borderResaltarSeleccionarDefiProvisionEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDefiProvisionEmpleado=null;
	public Boolean mostraridDefiProvisionEmpleado=true;
	public Boolean activaridDefiProvisionEmpleado=true;

	public Border resaltarid_empresaDefiProvisionEmpleado=null;
	public Boolean mostrarid_empresaDefiProvisionEmpleado=true;
	public Boolean activarid_empresaDefiProvisionEmpleado=true;
	public Boolean cargarid_empresaDefiProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDefiProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaDefiProvisionEmpleado=null;
	public Boolean mostrarid_rubro_empleaDefiProvisionEmpleado=true;
	public Boolean activarid_rubro_empleaDefiProvisionEmpleado=true;
	public Boolean cargarid_rubro_empleaDefiProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaDefiProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarid_formatoDefiProvisionEmpleado=null;
	public Boolean mostrarid_formatoDefiProvisionEmpleado=true;
	public Boolean activarid_formatoDefiProvisionEmpleado=true;
	public Boolean cargarid_formatoDefiProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoDefiProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarnombreDefiProvisionEmpleado=null;
	public Boolean mostrarnombreDefiProvisionEmpleado=true;
	public Boolean activarnombreDefiProvisionEmpleado=true;

	public Border resaltardia_inicialDefiProvisionEmpleado=null;
	public Boolean mostrardia_inicialDefiProvisionEmpleado=true;
	public Boolean activardia_inicialDefiProvisionEmpleado=true;

	public Border resaltarid_mes_inicialDefiProvisionEmpleado=null;
	public Boolean mostrarid_mes_inicialDefiProvisionEmpleado=true;
	public Boolean activarid_mes_inicialDefiProvisionEmpleado=true;
	public Boolean cargarid_mes_inicialDefiProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mes_inicialDefiProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltardia_finalDefiProvisionEmpleado=null;
	public Boolean mostrardia_finalDefiProvisionEmpleado=true;
	public Boolean activardia_finalDefiProvisionEmpleado=true;

	public Border resaltarid_mes_finalDefiProvisionEmpleado=null;
	public Boolean mostrarid_mes_finalDefiProvisionEmpleado=true;
	public Boolean activarid_mes_finalDefiProvisionEmpleado=true;
	public Boolean cargarid_mes_finalDefiProvisionEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mes_finalDefiProvisionEmpleado=false;//ConEventDepend=true

	public Border resaltarpara_liquidacionDefiProvisionEmpleado=null;
	public Boolean mostrarpara_liquidacionDefiProvisionEmpleado=true;
	public Boolean activarpara_liquidacionDefiProvisionEmpleado=true;

	public Border resaltardescripcionDefiProvisionEmpleado=null;
	public Boolean mostrardescripcionDefiProvisionEmpleado=true;
	public Boolean activardescripcionDefiProvisionEmpleado=true;

	
	

	public Border setResaltaridDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltaridDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDefiProvisionEmpleado() {
		return this.resaltaridDefiProvisionEmpleado;
	}

	public void setResaltaridDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltaridDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostraridDefiProvisionEmpleado() {
		return this.mostraridDefiProvisionEmpleado;
	}

	public void setMostraridDefiProvisionEmpleado(Boolean mostraridDefiProvisionEmpleado) {
		this.mostraridDefiProvisionEmpleado= mostraridDefiProvisionEmpleado;
	}

	public Boolean getActivaridDefiProvisionEmpleado() {
		return this.activaridDefiProvisionEmpleado;
	}

	public void setActivaridDefiProvisionEmpleado(Boolean activaridDefiProvisionEmpleado) {
		this.activaridDefiProvisionEmpleado= activaridDefiProvisionEmpleado;
	}

	public Border setResaltarid_empresaDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDefiProvisionEmpleado() {
		return this.resaltarid_empresaDefiProvisionEmpleado;
	}

	public void setResaltarid_empresaDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_empresaDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaDefiProvisionEmpleado() {
		return this.mostrarid_empresaDefiProvisionEmpleado;
	}

	public void setMostrarid_empresaDefiProvisionEmpleado(Boolean mostrarid_empresaDefiProvisionEmpleado) {
		this.mostrarid_empresaDefiProvisionEmpleado= mostrarid_empresaDefiProvisionEmpleado;
	}

	public Boolean getActivarid_empresaDefiProvisionEmpleado() {
		return this.activarid_empresaDefiProvisionEmpleado;
	}

	public void setActivarid_empresaDefiProvisionEmpleado(Boolean activarid_empresaDefiProvisionEmpleado) {
		this.activarid_empresaDefiProvisionEmpleado= activarid_empresaDefiProvisionEmpleado;
	}

	public Boolean getCargarid_empresaDefiProvisionEmpleado() {
		return this.cargarid_empresaDefiProvisionEmpleado;
	}

	public void setCargarid_empresaDefiProvisionEmpleado(Boolean cargarid_empresaDefiProvisionEmpleado) {
		this.cargarid_empresaDefiProvisionEmpleado= cargarid_empresaDefiProvisionEmpleado;
	}

	public Border setResaltarid_rubro_empleaDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaDefiProvisionEmpleado() {
		return this.resaltarid_rubro_empleaDefiProvisionEmpleado;
	}

	public void setResaltarid_rubro_empleaDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_rubro_empleaDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaDefiProvisionEmpleado() {
		return this.mostrarid_rubro_empleaDefiProvisionEmpleado;
	}

	public void setMostrarid_rubro_empleaDefiProvisionEmpleado(Boolean mostrarid_rubro_empleaDefiProvisionEmpleado) {
		this.mostrarid_rubro_empleaDefiProvisionEmpleado= mostrarid_rubro_empleaDefiProvisionEmpleado;
	}

	public Boolean getActivarid_rubro_empleaDefiProvisionEmpleado() {
		return this.activarid_rubro_empleaDefiProvisionEmpleado;
	}

	public void setActivarid_rubro_empleaDefiProvisionEmpleado(Boolean activarid_rubro_empleaDefiProvisionEmpleado) {
		this.activarid_rubro_empleaDefiProvisionEmpleado= activarid_rubro_empleaDefiProvisionEmpleado;
	}

	public Boolean getCargarid_rubro_empleaDefiProvisionEmpleado() {
		return this.cargarid_rubro_empleaDefiProvisionEmpleado;
	}

	public void setCargarid_rubro_empleaDefiProvisionEmpleado(Boolean cargarid_rubro_empleaDefiProvisionEmpleado) {
		this.cargarid_rubro_empleaDefiProvisionEmpleado= cargarid_rubro_empleaDefiProvisionEmpleado;
	}

	public Border setResaltarid_formatoDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_formatoDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoDefiProvisionEmpleado() {
		return this.resaltarid_formatoDefiProvisionEmpleado;
	}

	public void setResaltarid_formatoDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_formatoDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_formatoDefiProvisionEmpleado() {
		return this.mostrarid_formatoDefiProvisionEmpleado;
	}

	public void setMostrarid_formatoDefiProvisionEmpleado(Boolean mostrarid_formatoDefiProvisionEmpleado) {
		this.mostrarid_formatoDefiProvisionEmpleado= mostrarid_formatoDefiProvisionEmpleado;
	}

	public Boolean getActivarid_formatoDefiProvisionEmpleado() {
		return this.activarid_formatoDefiProvisionEmpleado;
	}

	public void setActivarid_formatoDefiProvisionEmpleado(Boolean activarid_formatoDefiProvisionEmpleado) {
		this.activarid_formatoDefiProvisionEmpleado= activarid_formatoDefiProvisionEmpleado;
	}

	public Boolean getCargarid_formatoDefiProvisionEmpleado() {
		return this.cargarid_formatoDefiProvisionEmpleado;
	}

	public void setCargarid_formatoDefiProvisionEmpleado(Boolean cargarid_formatoDefiProvisionEmpleado) {
		this.cargarid_formatoDefiProvisionEmpleado= cargarid_formatoDefiProvisionEmpleado;
	}

	public Border setResaltarnombreDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarnombreDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDefiProvisionEmpleado() {
		return this.resaltarnombreDefiProvisionEmpleado;
	}

	public void setResaltarnombreDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarnombreDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarnombreDefiProvisionEmpleado() {
		return this.mostrarnombreDefiProvisionEmpleado;
	}

	public void setMostrarnombreDefiProvisionEmpleado(Boolean mostrarnombreDefiProvisionEmpleado) {
		this.mostrarnombreDefiProvisionEmpleado= mostrarnombreDefiProvisionEmpleado;
	}

	public Boolean getActivarnombreDefiProvisionEmpleado() {
		return this.activarnombreDefiProvisionEmpleado;
	}

	public void setActivarnombreDefiProvisionEmpleado(Boolean activarnombreDefiProvisionEmpleado) {
		this.activarnombreDefiProvisionEmpleado= activarnombreDefiProvisionEmpleado;
	}

	public Border setResaltardia_inicialDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltardia_inicialDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_inicialDefiProvisionEmpleado() {
		return this.resaltardia_inicialDefiProvisionEmpleado;
	}

	public void setResaltardia_inicialDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltardia_inicialDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrardia_inicialDefiProvisionEmpleado() {
		return this.mostrardia_inicialDefiProvisionEmpleado;
	}

	public void setMostrardia_inicialDefiProvisionEmpleado(Boolean mostrardia_inicialDefiProvisionEmpleado) {
		this.mostrardia_inicialDefiProvisionEmpleado= mostrardia_inicialDefiProvisionEmpleado;
	}

	public Boolean getActivardia_inicialDefiProvisionEmpleado() {
		return this.activardia_inicialDefiProvisionEmpleado;
	}

	public void setActivardia_inicialDefiProvisionEmpleado(Boolean activardia_inicialDefiProvisionEmpleado) {
		this.activardia_inicialDefiProvisionEmpleado= activardia_inicialDefiProvisionEmpleado;
	}

	public Border setResaltarid_mes_inicialDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_mes_inicialDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mes_inicialDefiProvisionEmpleado() {
		return this.resaltarid_mes_inicialDefiProvisionEmpleado;
	}

	public void setResaltarid_mes_inicialDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_mes_inicialDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_mes_inicialDefiProvisionEmpleado() {
		return this.mostrarid_mes_inicialDefiProvisionEmpleado;
	}

	public void setMostrarid_mes_inicialDefiProvisionEmpleado(Boolean mostrarid_mes_inicialDefiProvisionEmpleado) {
		this.mostrarid_mes_inicialDefiProvisionEmpleado= mostrarid_mes_inicialDefiProvisionEmpleado;
	}

	public Boolean getActivarid_mes_inicialDefiProvisionEmpleado() {
		return this.activarid_mes_inicialDefiProvisionEmpleado;
	}

	public void setActivarid_mes_inicialDefiProvisionEmpleado(Boolean activarid_mes_inicialDefiProvisionEmpleado) {
		this.activarid_mes_inicialDefiProvisionEmpleado= activarid_mes_inicialDefiProvisionEmpleado;
	}

	public Boolean getCargarid_mes_inicialDefiProvisionEmpleado() {
		return this.cargarid_mes_inicialDefiProvisionEmpleado;
	}

	public void setCargarid_mes_inicialDefiProvisionEmpleado(Boolean cargarid_mes_inicialDefiProvisionEmpleado) {
		this.cargarid_mes_inicialDefiProvisionEmpleado= cargarid_mes_inicialDefiProvisionEmpleado;
	}

	public Border setResaltardia_finalDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltardia_finalDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_finalDefiProvisionEmpleado() {
		return this.resaltardia_finalDefiProvisionEmpleado;
	}

	public void setResaltardia_finalDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltardia_finalDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrardia_finalDefiProvisionEmpleado() {
		return this.mostrardia_finalDefiProvisionEmpleado;
	}

	public void setMostrardia_finalDefiProvisionEmpleado(Boolean mostrardia_finalDefiProvisionEmpleado) {
		this.mostrardia_finalDefiProvisionEmpleado= mostrardia_finalDefiProvisionEmpleado;
	}

	public Boolean getActivardia_finalDefiProvisionEmpleado() {
		return this.activardia_finalDefiProvisionEmpleado;
	}

	public void setActivardia_finalDefiProvisionEmpleado(Boolean activardia_finalDefiProvisionEmpleado) {
		this.activardia_finalDefiProvisionEmpleado= activardia_finalDefiProvisionEmpleado;
	}

	public Border setResaltarid_mes_finalDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_mes_finalDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mes_finalDefiProvisionEmpleado() {
		return this.resaltarid_mes_finalDefiProvisionEmpleado;
	}

	public void setResaltarid_mes_finalDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarid_mes_finalDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_mes_finalDefiProvisionEmpleado() {
		return this.mostrarid_mes_finalDefiProvisionEmpleado;
	}

	public void setMostrarid_mes_finalDefiProvisionEmpleado(Boolean mostrarid_mes_finalDefiProvisionEmpleado) {
		this.mostrarid_mes_finalDefiProvisionEmpleado= mostrarid_mes_finalDefiProvisionEmpleado;
	}

	public Boolean getActivarid_mes_finalDefiProvisionEmpleado() {
		return this.activarid_mes_finalDefiProvisionEmpleado;
	}

	public void setActivarid_mes_finalDefiProvisionEmpleado(Boolean activarid_mes_finalDefiProvisionEmpleado) {
		this.activarid_mes_finalDefiProvisionEmpleado= activarid_mes_finalDefiProvisionEmpleado;
	}

	public Boolean getCargarid_mes_finalDefiProvisionEmpleado() {
		return this.cargarid_mes_finalDefiProvisionEmpleado;
	}

	public void setCargarid_mes_finalDefiProvisionEmpleado(Boolean cargarid_mes_finalDefiProvisionEmpleado) {
		this.cargarid_mes_finalDefiProvisionEmpleado= cargarid_mes_finalDefiProvisionEmpleado;
	}

	public Border setResaltarpara_liquidacionDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltarpara_liquidacionDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_liquidacionDefiProvisionEmpleado() {
		return this.resaltarpara_liquidacionDefiProvisionEmpleado;
	}

	public void setResaltarpara_liquidacionDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarpara_liquidacionDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrarpara_liquidacionDefiProvisionEmpleado() {
		return this.mostrarpara_liquidacionDefiProvisionEmpleado;
	}

	public void setMostrarpara_liquidacionDefiProvisionEmpleado(Boolean mostrarpara_liquidacionDefiProvisionEmpleado) {
		this.mostrarpara_liquidacionDefiProvisionEmpleado= mostrarpara_liquidacionDefiProvisionEmpleado;
	}

	public Boolean getActivarpara_liquidacionDefiProvisionEmpleado() {
		return this.activarpara_liquidacionDefiProvisionEmpleado;
	}

	public void setActivarpara_liquidacionDefiProvisionEmpleado(Boolean activarpara_liquidacionDefiProvisionEmpleado) {
		this.activarpara_liquidacionDefiProvisionEmpleado= activarpara_liquidacionDefiProvisionEmpleado;
	}

	public Border setResaltardescripcionDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltar);
		
		this.resaltardescripcionDefiProvisionEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDefiProvisionEmpleado() {
		return this.resaltardescripcionDefiProvisionEmpleado;
	}

	public void setResaltardescripcionDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltardescripcionDefiProvisionEmpleado= borderResaltar;
	}

	public Boolean getMostrardescripcionDefiProvisionEmpleado() {
		return this.mostrardescripcionDefiProvisionEmpleado;
	}

	public void setMostrardescripcionDefiProvisionEmpleado(Boolean mostrardescripcionDefiProvisionEmpleado) {
		this.mostrardescripcionDefiProvisionEmpleado= mostrardescripcionDefiProvisionEmpleado;
	}

	public Boolean getActivardescripcionDefiProvisionEmpleado() {
		return this.activardescripcionDefiProvisionEmpleado;
	}

	public void setActivardescripcionDefiProvisionEmpleado(Boolean activardescripcionDefiProvisionEmpleado) {
		this.activardescripcionDefiProvisionEmpleado= activardescripcionDefiProvisionEmpleado;
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
		
		
		this.setMostraridDefiProvisionEmpleado(esInicial);
		this.setMostrarid_empresaDefiProvisionEmpleado(esInicial);
		this.setMostrarid_rubro_empleaDefiProvisionEmpleado(esInicial);
		this.setMostrarid_formatoDefiProvisionEmpleado(esInicial);
		this.setMostrarnombreDefiProvisionEmpleado(esInicial);
		this.setMostrardia_inicialDefiProvisionEmpleado(esInicial);
		this.setMostrarid_mes_inicialDefiProvisionEmpleado(esInicial);
		this.setMostrardia_finalDefiProvisionEmpleado(esInicial);
		this.setMostrarid_mes_finalDefiProvisionEmpleado(esInicial);
		this.setMostrarpara_liquidacionDefiProvisionEmpleado(esInicial);
		this.setMostrardescripcionDefiProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.ID)) {
				this.setMostraridDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL)) {
				this.setMostrardia_inicialDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL)) {
				this.setMostrarid_mes_inicialDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DIAFINAL)) {
				this.setMostrardia_finalDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL)) {
				this.setMostrarid_mes_finalDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION)) {
				this.setMostrarpara_liquidacionDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDefiProvisionEmpleado(esAsigna);
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
		
		
		this.setActivaridDefiProvisionEmpleado(esInicial);
		this.setActivarid_empresaDefiProvisionEmpleado(esInicial);
		this.setActivarid_rubro_empleaDefiProvisionEmpleado(esInicial);
		this.setActivarid_formatoDefiProvisionEmpleado(esInicial);
		this.setActivarnombreDefiProvisionEmpleado(esInicial);
		this.setActivardia_inicialDefiProvisionEmpleado(esInicial);
		this.setActivarid_mes_inicialDefiProvisionEmpleado(esInicial);
		this.setActivardia_finalDefiProvisionEmpleado(esInicial);
		this.setActivarid_mes_finalDefiProvisionEmpleado(esInicial);
		this.setActivarpara_liquidacionDefiProvisionEmpleado(esInicial);
		this.setActivardescripcionDefiProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.ID)) {
				this.setActivaridDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL)) {
				this.setActivardia_inicialDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL)) {
				this.setActivarid_mes_inicialDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DIAFINAL)) {
				this.setActivardia_finalDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL)) {
				this.setActivarid_mes_finalDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION)) {
				this.setActivarpara_liquidacionDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDefiProvisionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDefiProvisionEmpleado(esInicial);
		this.setResaltarid_empresaDefiProvisionEmpleado(esInicial);
		this.setResaltarid_rubro_empleaDefiProvisionEmpleado(esInicial);
		this.setResaltarid_formatoDefiProvisionEmpleado(esInicial);
		this.setResaltarnombreDefiProvisionEmpleado(esInicial);
		this.setResaltardia_inicialDefiProvisionEmpleado(esInicial);
		this.setResaltarid_mes_inicialDefiProvisionEmpleado(esInicial);
		this.setResaltardia_finalDefiProvisionEmpleado(esInicial);
		this.setResaltarid_mes_finalDefiProvisionEmpleado(esInicial);
		this.setResaltarpara_liquidacionDefiProvisionEmpleado(esInicial);
		this.setResaltardescripcionDefiProvisionEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL)) {
				this.setResaltardia_inicialDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL)) {
				this.setResaltarid_mes_inicialDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DIAFINAL)) {
				this.setResaltardia_finalDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL)) {
				this.setResaltarid_mes_finalDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION)) {
				this.setResaltarpara_liquidacionDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDefiProvisionEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProvisionEmpleadoDefiProvisionEmpleado=null;

	public Border getResaltarProvisionEmpleadoDefiProvisionEmpleado() {
		return this.resaltarProvisionEmpleadoDefiProvisionEmpleado;
	}

	public void setResaltarProvisionEmpleadoDefiProvisionEmpleado(Border borderResaltarProvisionEmpleado) {
		if(borderResaltarProvisionEmpleado!=null) {
			this.resaltarProvisionEmpleadoDefiProvisionEmpleado= borderResaltarProvisionEmpleado;
		}
	}

	public Border setResaltarProvisionEmpleadoDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarProvisionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltarProvisionEmpleado);
			
		this.resaltarProvisionEmpleadoDefiProvisionEmpleado= borderResaltarProvisionEmpleado;

		 return borderResaltarProvisionEmpleado;
	}



	public Boolean mostrarProvisionEmpleadoDefiProvisionEmpleado=true;

	public Boolean getMostrarProvisionEmpleadoDefiProvisionEmpleado() {
		return this.mostrarProvisionEmpleadoDefiProvisionEmpleado;
	}

	public void setMostrarProvisionEmpleadoDefiProvisionEmpleado(Boolean visibilidadResaltarProvisionEmpleado) {
		this.mostrarProvisionEmpleadoDefiProvisionEmpleado= visibilidadResaltarProvisionEmpleado;
	}



	public Boolean activarProvisionEmpleadoDefiProvisionEmpleado=true;

	public Boolean gethabilitarResaltarProvisionEmpleadoDefiProvisionEmpleado() {
		return this.activarProvisionEmpleadoDefiProvisionEmpleado;
	}

	public void setActivarProvisionEmpleadoDefiProvisionEmpleado(Boolean habilitarResaltarProvisionEmpleado) {
		this.activarProvisionEmpleadoDefiProvisionEmpleado= habilitarResaltarProvisionEmpleado;
	}


	public Border resaltarCuotaDefiProvisionEmpleado=null;

	public Border getResaltarCuotaDefiProvisionEmpleado() {
		return this.resaltarCuotaDefiProvisionEmpleado;
	}

	public void setResaltarCuotaDefiProvisionEmpleado(Border borderResaltarCuota) {
		if(borderResaltarCuota!=null) {
			this.resaltarCuotaDefiProvisionEmpleado= borderResaltarCuota;
		}
	}

	public Border setResaltarCuotaDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuota=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//defiprovisionempleadoBeanSwingJInternalFrame.jTtoolBarDefiProvisionEmpleado.setBorder(borderResaltarCuota);
			
		this.resaltarCuotaDefiProvisionEmpleado= borderResaltarCuota;

		 return borderResaltarCuota;
	}



	public Boolean mostrarCuotaDefiProvisionEmpleado=true;

	public Boolean getMostrarCuotaDefiProvisionEmpleado() {
		return this.mostrarCuotaDefiProvisionEmpleado;
	}

	public void setMostrarCuotaDefiProvisionEmpleado(Boolean visibilidadResaltarCuota) {
		this.mostrarCuotaDefiProvisionEmpleado= visibilidadResaltarCuota;
	}



	public Boolean activarCuotaDefiProvisionEmpleado=true;

	public Boolean gethabilitarResaltarCuotaDefiProvisionEmpleado() {
		return this.activarCuotaDefiProvisionEmpleado;
	}

	public void setActivarCuotaDefiProvisionEmpleado(Boolean habilitarResaltarCuota) {
		this.activarCuotaDefiProvisionEmpleado= habilitarResaltarCuota;
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

		this.setMostrarProvisionEmpleadoDefiProvisionEmpleado(esInicial);
		this.setMostrarCuotaDefiProvisionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setMostrarProvisionEmpleadoDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cuota.class)) {
				this.setMostrarCuotaDefiProvisionEmpleado(esAsigna);
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

		this.setActivarProvisionEmpleadoDefiProvisionEmpleado(esInicial);
		this.setActivarCuotaDefiProvisionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setActivarProvisionEmpleadoDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cuota.class)) {
				this.setActivarCuotaDefiProvisionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProvisionEmpleadoDefiProvisionEmpleado(esInicial);
		this.setResaltarCuotaDefiProvisionEmpleado(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setResaltarProvisionEmpleadoDefiProvisionEmpleado(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cuota.class)) {
				this.setResaltarCuotaDefiProvisionEmpleado(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaDefiProvisionEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaDefiProvisionEmpleado() {
		return this.mostrarFK_IdEmpresaDefiProvisionEmpleado;
	}

	public void setMostrarFK_IdEmpresaDefiProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDefiProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoDefiProvisionEmpleado=true;

	public Boolean getMostrarFK_IdFormatoDefiProvisionEmpleado() {
		return this.mostrarFK_IdFormatoDefiProvisionEmpleado;
	}

	public void setMostrarFK_IdFormatoDefiProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoDefiProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesFinalDefiProvisionEmpleado=true;

	public Boolean getMostrarFK_IdMesFinalDefiProvisionEmpleado() {
		return this.mostrarFK_IdMesFinalDefiProvisionEmpleado;
	}

	public void setMostrarFK_IdMesFinalDefiProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesFinalDefiProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesInicialDefiProvisionEmpleado=true;

	public Boolean getMostrarFK_IdMesInicialDefiProvisionEmpleado() {
		return this.mostrarFK_IdMesInicialDefiProvisionEmpleado;
	}

	public void setMostrarFK_IdMesInicialDefiProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesInicialDefiProvisionEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaDefiProvisionEmpleado=true;

	public Boolean getMostrarFK_IdRubroEmpleaDefiProvisionEmpleado() {
		return this.mostrarFK_IdRubroEmpleaDefiProvisionEmpleado;
	}

	public void setMostrarFK_IdRubroEmpleaDefiProvisionEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaDefiProvisionEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaDefiProvisionEmpleado=true;

	public Boolean getActivarFK_IdEmpresaDefiProvisionEmpleado() {
		return this.activarFK_IdEmpresaDefiProvisionEmpleado;
	}

	public void setActivarFK_IdEmpresaDefiProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDefiProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoDefiProvisionEmpleado=true;

	public Boolean getActivarFK_IdFormatoDefiProvisionEmpleado() {
		return this.activarFK_IdFormatoDefiProvisionEmpleado;
	}

	public void setActivarFK_IdFormatoDefiProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoDefiProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdMesFinalDefiProvisionEmpleado=true;

	public Boolean getActivarFK_IdMesFinalDefiProvisionEmpleado() {
		return this.activarFK_IdMesFinalDefiProvisionEmpleado;
	}

	public void setActivarFK_IdMesFinalDefiProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdMesFinalDefiProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdMesInicialDefiProvisionEmpleado=true;

	public Boolean getActivarFK_IdMesInicialDefiProvisionEmpleado() {
		return this.activarFK_IdMesInicialDefiProvisionEmpleado;
	}

	public void setActivarFK_IdMesInicialDefiProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdMesInicialDefiProvisionEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaDefiProvisionEmpleado=true;

	public Boolean getActivarFK_IdRubroEmpleaDefiProvisionEmpleado() {
		return this.activarFK_IdRubroEmpleaDefiProvisionEmpleado;
	}

	public void setActivarFK_IdRubroEmpleaDefiProvisionEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaDefiProvisionEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaDefiProvisionEmpleado=null;

	public Border getResaltarFK_IdEmpresaDefiProvisionEmpleado() {
		return this.resaltarFK_IdEmpresaDefiProvisionEmpleado;
	}

	public void setResaltarFK_IdEmpresaDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDefiProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDefiProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdFormatoDefiProvisionEmpleado=null;

	public Border getResaltarFK_IdFormatoDefiProvisionEmpleado() {
		return this.resaltarFK_IdFormatoDefiProvisionEmpleado;
	}

	public void setResaltarFK_IdFormatoDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdFormatoDefiProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdFormatoDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoDefiProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdMesFinalDefiProvisionEmpleado=null;

	public Border getResaltarFK_IdMesFinalDefiProvisionEmpleado() {
		return this.resaltarFK_IdMesFinalDefiProvisionEmpleado;
	}

	public void setResaltarFK_IdMesFinalDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdMesFinalDefiProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdMesFinalDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesFinalDefiProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdMesInicialDefiProvisionEmpleado=null;

	public Border getResaltarFK_IdMesInicialDefiProvisionEmpleado() {
		return this.resaltarFK_IdMesInicialDefiProvisionEmpleado;
	}

	public void setResaltarFK_IdMesInicialDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdMesInicialDefiProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdMesInicialDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesInicialDefiProvisionEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaDefiProvisionEmpleado=null;

	public Border getResaltarFK_IdRubroEmpleaDefiProvisionEmpleado() {
		return this.resaltarFK_IdRubroEmpleaDefiProvisionEmpleado;
	}

	public void setResaltarFK_IdRubroEmpleaDefiProvisionEmpleado(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaDefiProvisionEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaDefiProvisionEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DefiProvisionEmpleadoBeanSwingJInternalFrame defiprovisionempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaDefiProvisionEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}