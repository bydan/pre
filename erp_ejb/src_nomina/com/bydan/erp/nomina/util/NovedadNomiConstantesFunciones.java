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


import com.bydan.erp.nomina.util.NovedadNomiConstantesFunciones;
import com.bydan.erp.nomina.util.NovedadNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.NovedadNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NovedadNomiConstantesFunciones extends NovedadNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NovedadNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NovedadNomi"+NovedadNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NovedadNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NovedadNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NovedadNomiConstantesFunciones.SCHEMA+"_"+NovedadNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NovedadNomiConstantesFunciones.SCHEMA+"_"+NovedadNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NovedadNomiConstantesFunciones.SCHEMA+"_"+NovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NovedadNomiConstantesFunciones.SCHEMA+"_"+NovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NovedadNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NovedadNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NovedadNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NovedadNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Novedad Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Novedad Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Novedad Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NovedadNomi";
	public static final String OBJECTNAME="novedadnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="novedad_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select novedadnomi from "+NovedadNomiConstantesFunciones.SPERSISTENCENAME+" novedadnomi";
	public static String QUERYSELECTNATIVE="select "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".version_row,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_empresa,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_empleado,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_empleado_autoriza,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_tipo_novedad_nomi,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_estado_novedad_nomi,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".fecha,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".numero_hora,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".numero_minuto,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".numero_jornada_trabajo,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".anio_vacacion,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".descripcion from "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME;//+" as "+NovedadNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NovedadNomiConstantesFuncionesAdditional novedadnomiConstantesFuncionesAdditional=null;
	
	public NovedadNomiConstantesFuncionesAdditional getNovedadNomiConstantesFuncionesAdditional() {
		return this.novedadnomiConstantesFuncionesAdditional;
	}
	
	public void setNovedadNomiConstantesFuncionesAdditional(NovedadNomiConstantesFuncionesAdditional novedadnomiConstantesFuncionesAdditional) {
		try {
			this.novedadnomiConstantesFuncionesAdditional=novedadnomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEMPLEADOAUTORIZA= "id_empleado_autoriza";
    public static final String IDTIPONOVEDADNOMI= "id_tipo_novedad_nomi";
    public static final String IDESTADONOVEDADNOMI= "id_estado_novedad_nomi";
    public static final String FECHA= "fecha";
    public static final String NUMEROHORA= "numero_hora";
    public static final String NUMEROMINUTO= "numero_minuto";
    public static final String NUMEROJORNADATRABAJO= "numero_jornada_trabajo";
    public static final String ANIOVACACION= "anio_vacacion";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEMPLEADOAUTORIZA= "Empleado Autoriza";
		public static final String LABEL_IDEMPLEADOAUTORIZA_LOWER= "Empleado Autoriza";
    	public static final String LABEL_IDTIPONOVEDADNOMI= "Tipo Novedad Nomi";
		public static final String LABEL_IDTIPONOVEDADNOMI_LOWER= "Tipo Novedad Nomi";
    	public static final String LABEL_IDESTADONOVEDADNOMI= "Estado Novedad Nomi";
		public static final String LABEL_IDESTADONOVEDADNOMI_LOWER= "Estado Novedad Nomi";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMEROHORA= "Numero Hora";
		public static final String LABEL_NUMEROHORA_LOWER= "Numero Hora";
    	public static final String LABEL_NUMEROMINUTO= "Numero Minuto";
		public static final String LABEL_NUMEROMINUTO_LOWER= "Numero Minuto";
    	public static final String LABEL_NUMEROJORNADATRABAJO= "Numero Jornada Trabajo";
		public static final String LABEL_NUMEROJORNADATRABAJO_LOWER= "Numero Jornada Trabajo";
    	public static final String LABEL_ANIOVACACION= "Anio Vacacion";
		public static final String LABEL_ANIOVACACION_LOWER= "Anio Vacacion";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNovedadNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.IDEMPLEADO)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_IDEMPLEADOAUTORIZA;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_IDTIPONOVEDADNOMI;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_IDESTADONOVEDADNOMI;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.FECHA)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.NUMEROHORA)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_NUMEROHORA;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.NUMEROMINUTO)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_NUMEROMINUTO;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_NUMEROJORNADATRABAJO;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.ANIOVACACION)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_ANIOVACACION;}
		if(sNombreColumna.equals(NovedadNomiConstantesFunciones.DESCRIPCION)) {sLabelColumna=NovedadNomiConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getNovedadNomiDescripcion(NovedadNomi novedadnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(novedadnomi !=null/* && novedadnomi.getId()!=0*/) {
			if(novedadnomi.getId()!=null) {
				sDescripcion=novedadnomi.getId().toString();
			}//novedadnominovedadnomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNovedadNomiDescripcionDetallado(NovedadNomi novedadnomi) {
		String sDescripcion="";
			
		sDescripcion+=NovedadNomiConstantesFunciones.ID+"=";
		sDescripcion+=novedadnomi.getId().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=novedadnomi.getVersionRow().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=novedadnomi.getid_empresa().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=novedadnomi.getid_empleado().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA+"=";
		sDescripcion+=novedadnomi.getid_empleado_autoriza().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI+"=";
		sDescripcion+=novedadnomi.getid_tipo_novedad_nomi().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI+"=";
		sDescripcion+=novedadnomi.getid_estado_novedad_nomi().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.FECHA+"=";
		sDescripcion+=novedadnomi.getfecha().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.NUMEROHORA+"=";
		sDescripcion+=novedadnomi.getnumero_hora().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.NUMEROMINUTO+"=";
		sDescripcion+=novedadnomi.getnumero_minuto().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO+"=";
		sDescripcion+=novedadnomi.getnumero_jornada_trabajo().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.ANIOVACACION+"=";
		sDescripcion+=novedadnomi.getanio_vacacion().toString()+",";
		sDescripcion+=NovedadNomiConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=novedadnomi.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setNovedadNomiDescripcion(NovedadNomi novedadnomi,String sValor) throws Exception {			
		if(novedadnomi !=null) {
			//novedadnominovedadnomi.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEmpleadoAutorizaDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getTipoNovedadNomiDescripcion(TipoNovedadNomi tiponovedadnomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiponovedadnomi!=null/*&&tiponovedadnomi.getId()>0*/) {
			sDescripcion=TipoNovedadNomiConstantesFunciones.getTipoNovedadNomiDescripcion(tiponovedadnomi);
		}

		return sDescripcion;
	}

	public static String getEstadoNovedadNomiDescripcion(EstadoNovedadNomi estadonovedadnomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadonovedadnomi!=null/*&&estadonovedadnomi.getId()>0*/) {
			sDescripcion=EstadoNovedadNomiConstantesFunciones.getEstadoNovedadNomiDescripcion(estadonovedadnomi);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleadoAutoriza")) {
			sNombreIndice="Tipo=  Por Empleado Autoriza";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoNovedadNomi")) {
			sNombreIndice="Tipo=  Por Estado Novedad Nomi";
		} else if(sNombreIndice.equals("FK_IdTipoNovedadNomi")) {
			sNombreIndice="Tipo=  Por Tipo Novedad Nomi";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoAutoriza(Long id_empleado_autoriza) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_autoriza!=null) {sDetalleIndice+=" Codigo Unico De Empleado Autoriza="+id_empleado_autoriza.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoNovedadNomi(Long id_estado_novedad_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_novedad_nomi!=null) {sDetalleIndice+=" Codigo Unico De Estado Novedad Nomi="+id_estado_novedad_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoNovedadNomi(Long id_tipo_novedad_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_novedad_nomi!=null) {sDetalleIndice+=" Codigo Unico De Tipo Novedad Nomi="+id_tipo_novedad_nomi.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosNovedadNomi(NovedadNomi novedadnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		novedadnomi.setdescripcion(novedadnomi.getdescripcion().trim());
	}
	
	public static void quitarEspaciosNovedadNomis(List<NovedadNomi> novedadnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NovedadNomi novedadnomi: novedadnomis) {
			novedadnomi.setdescripcion(novedadnomi.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedadNomi(NovedadNomi novedadnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && novedadnomi.getConCambioAuxiliar()) {
			novedadnomi.setIsDeleted(novedadnomi.getIsDeletedAuxiliar());	
			novedadnomi.setIsNew(novedadnomi.getIsNewAuxiliar());	
			novedadnomi.setIsChanged(novedadnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			novedadnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			novedadnomi.setIsDeletedAuxiliar(false);	
			novedadnomi.setIsNewAuxiliar(false);	
			novedadnomi.setIsChangedAuxiliar(false);
			
			novedadnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedadNomis(List<NovedadNomi> novedadnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NovedadNomi novedadnomi : novedadnomis) {
			if(conAsignarBase && novedadnomi.getConCambioAuxiliar()) {
				novedadnomi.setIsDeleted(novedadnomi.getIsDeletedAuxiliar());	
				novedadnomi.setIsNew(novedadnomi.getIsNewAuxiliar());	
				novedadnomi.setIsChanged(novedadnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				novedadnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				novedadnomi.setIsDeletedAuxiliar(false);	
				novedadnomi.setIsNewAuxiliar(false);	
				novedadnomi.setIsChangedAuxiliar(false);
				
				novedadnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNovedadNomi(NovedadNomi novedadnomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			novedadnomi.setnumero_hora(0);
			novedadnomi.setnumero_minuto(0);
			novedadnomi.setnumero_jornada_trabajo(0);
			novedadnomi.setanio_vacacion(0);
		}
	}		
	
	public static void InicializarValoresNovedadNomis(List<NovedadNomi> novedadnomis,Boolean conEnteros) throws Exception  {
		
		for(NovedadNomi novedadnomi: novedadnomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				novedadnomi.setnumero_hora(0);
				novedadnomi.setnumero_minuto(0);
				novedadnomi.setnumero_jornada_trabajo(0);
				novedadnomi.setanio_vacacion(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaNovedadNomi(List<NovedadNomi> novedadnomis,NovedadNomi novedadnomiAux) throws Exception  {
		NovedadNomiConstantesFunciones.InicializarValoresNovedadNomi(novedadnomiAux,true);
		
		for(NovedadNomi novedadnomi: novedadnomis) {
			if(novedadnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			novedadnomiAux.setnumero_hora(novedadnomiAux.getnumero_hora()+novedadnomi.getnumero_hora());			
			novedadnomiAux.setnumero_minuto(novedadnomiAux.getnumero_minuto()+novedadnomi.getnumero_minuto());			
			novedadnomiAux.setnumero_jornada_trabajo(novedadnomiAux.getnumero_jornada_trabajo()+novedadnomi.getnumero_jornada_trabajo());			
			novedadnomiAux.setanio_vacacion(novedadnomiAux.getanio_vacacion()+novedadnomi.getanio_vacacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NovedadNomiConstantesFunciones.getArrayColumnasGlobalesNovedadNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadNomiConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNovedadNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NovedadNomi> novedadnomis,NovedadNomi novedadnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NovedadNomi novedadnomiAux: novedadnomis) {
			if(novedadnomiAux!=null && novedadnomi!=null) {
				if((novedadnomiAux.getId()==null && novedadnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(novedadnomiAux.getId()!=null && novedadnomi.getId()!=null){
					if(novedadnomiAux.getId().equals(novedadnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNovedadNomi(List<NovedadNomi> novedadnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NovedadNomi novedadnomi: novedadnomis) {			
			if(novedadnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNovedadNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_ID, NovedadNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_VERSIONROW, NovedadNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_IDEMPRESA, NovedadNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_IDEMPLEADO, NovedadNomiConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_IDEMPLEADOAUTORIZA, NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_IDTIPONOVEDADNOMI, NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_IDESTADONOVEDADNOMI, NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_FECHA, NovedadNomiConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_NUMEROHORA, NovedadNomiConstantesFunciones.NUMEROHORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_NUMEROMINUTO, NovedadNomiConstantesFunciones.NUMEROMINUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_NUMEROJORNADATRABAJO, NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_ANIOVACACION, NovedadNomiConstantesFunciones.ANIOVACACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadNomiConstantesFunciones.LABEL_DESCRIPCION, NovedadNomiConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNovedadNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.NUMEROHORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.NUMEROMINUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.ANIOVACACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadNomiConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadNomi() throws Exception  {
		return NovedadNomiConstantesFunciones.getTiposSeleccionarNovedadNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadNomi(Boolean conFk) throws Exception  {
		return NovedadNomiConstantesFunciones.getTiposSeleccionarNovedadNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_IDEMPLEADOAUTORIZA);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_IDEMPLEADOAUTORIZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_IDTIPONOVEDADNOMI);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_IDTIPONOVEDADNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_IDESTADONOVEDADNOMI);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_IDESTADONOVEDADNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_NUMEROHORA);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_NUMEROHORA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_NUMEROMINUTO);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_NUMEROMINUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_NUMEROJORNADATRABAJO);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_NUMEROJORNADATRABAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_ANIOVACACION);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_ANIOVACACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadNomiConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NovedadNomiConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNovedadNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNovedadNomi(NovedadNomi novedadnomiAux) throws Exception {
		
			novedadnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadnomiAux.getEmpresa()));
			novedadnomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(novedadnomiAux.getEmpleado()));
			novedadnomiAux.setempleadoautoriza_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(novedadnomiAux.getEmpleadoAutoriza()));
			novedadnomiAux.settiponovedadnomi_descripcion(TipoNovedadNomiConstantesFunciones.getTipoNovedadNomiDescripcion(novedadnomiAux.getTipoNovedadNomi()));
			novedadnomiAux.setestadonovedadnomi_descripcion(EstadoNovedadNomiConstantesFunciones.getEstadoNovedadNomiDescripcion(novedadnomiAux.getEstadoNovedadNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNovedadNomi(List<NovedadNomi> novedadnomisTemp) throws Exception {
		for(NovedadNomi novedadnomiAux:novedadnomisTemp) {
			
			novedadnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadnomiAux.getEmpresa()));
			novedadnomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(novedadnomiAux.getEmpleado()));
			novedadnomiAux.setempleadoautoriza_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(novedadnomiAux.getEmpleadoAutoriza()));
			novedadnomiAux.settiponovedadnomi_descripcion(TipoNovedadNomiConstantesFunciones.getTipoNovedadNomiDescripcion(novedadnomiAux.getTipoNovedadNomi()));
			novedadnomiAux.setestadonovedadnomi_descripcion(EstadoNovedadNomiConstantesFunciones.getEstadoNovedadNomiDescripcion(novedadnomiAux.getEstadoNovedadNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoNovedadNomi.class));
				classes.add(new Classe(EstadoNovedadNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoNovedadNomi.class)) {
						classes.add(new Classe(TipoNovedadNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoNovedadNomi.class)) {
						classes.add(new Classe(EstadoNovedadNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoNovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNovedadNomi.class)); continue;
					}

					if(EstadoNovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNovedadNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoNovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoNovedadNomi.class)); continue;
					}

					if(EstadoNovedadNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNovedadNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadNomiConstantesFunciones.getClassesRelationshipsOfNovedadNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadNomiConstantesFunciones.getClassesRelationshipsFromStringsOfNovedadNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedadNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NovedadNomi novedadnomi,List<NovedadNomi> novedadnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NovedadNomi novedadnomiEncontrado=null;
			
			for(NovedadNomi novedadnomiLocal:novedadnomis) {
				if(novedadnomiLocal.getId().equals(novedadnomi.getId())) {
					novedadnomiEncontrado=novedadnomiLocal;
					
					novedadnomiLocal.setIsChanged(novedadnomi.getIsChanged());
					novedadnomiLocal.setIsNew(novedadnomi.getIsNew());
					novedadnomiLocal.setIsDeleted(novedadnomi.getIsDeleted());
					
					novedadnomiLocal.setGeneralEntityOriginal(novedadnomi.getGeneralEntityOriginal());
					
					novedadnomiLocal.setId(novedadnomi.getId());	
					novedadnomiLocal.setVersionRow(novedadnomi.getVersionRow());	
					novedadnomiLocal.setid_empresa(novedadnomi.getid_empresa());	
					novedadnomiLocal.setid_empleado(novedadnomi.getid_empleado());	
					novedadnomiLocal.setid_empleado_autoriza(novedadnomi.getid_empleado_autoriza());	
					novedadnomiLocal.setid_tipo_novedad_nomi(novedadnomi.getid_tipo_novedad_nomi());	
					novedadnomiLocal.setid_estado_novedad_nomi(novedadnomi.getid_estado_novedad_nomi());	
					novedadnomiLocal.setfecha(novedadnomi.getfecha());	
					novedadnomiLocal.setnumero_hora(novedadnomi.getnumero_hora());	
					novedadnomiLocal.setnumero_minuto(novedadnomi.getnumero_minuto());	
					novedadnomiLocal.setnumero_jornada_trabajo(novedadnomi.getnumero_jornada_trabajo());	
					novedadnomiLocal.setanio_vacacion(novedadnomi.getanio_vacacion());	
					novedadnomiLocal.setdescripcion(novedadnomi.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!novedadnomi.getIsDeleted()) {
				if(!existe) {
					novedadnomis.add(novedadnomi);
				}
			} else {
				if(novedadnomiEncontrado!=null && permiteQuitar)  {
					novedadnomis.remove(novedadnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NovedadNomi novedadnomi,List<NovedadNomi> novedadnomis) throws Exception {
		try	{			
			for(NovedadNomi novedadnomiLocal:novedadnomis) {
				if(novedadnomiLocal.getId().equals(novedadnomi.getId())) {
					novedadnomiLocal.setIsSelected(novedadnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNovedadNomi(List<NovedadNomi> novedadnomisAux) throws Exception {
		//this.novedadnomisAux=novedadnomisAux;
		
		for(NovedadNomi novedadnomiAux:novedadnomisAux) {
			if(novedadnomiAux.getIsChanged()) {
				novedadnomiAux.setIsChanged(false);
			}		
			
			if(novedadnomiAux.getIsNew()) {
				novedadnomiAux.setIsNew(false);
			}	
			
			if(novedadnomiAux.getIsDeleted()) {
				novedadnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNovedadNomi(NovedadNomi novedadnomiAux) throws Exception {
		//this.novedadnomiAux=novedadnomiAux;
		
			if(novedadnomiAux.getIsChanged()) {
				novedadnomiAux.setIsChanged(false);
			}		
			
			if(novedadnomiAux.getIsNew()) {
				novedadnomiAux.setIsNew(false);
			}	
			
			if(novedadnomiAux.getIsDeleted()) {
				novedadnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NovedadNomi novedadnomiAsignar,NovedadNomi novedadnomi) throws Exception {
		novedadnomiAsignar.setId(novedadnomi.getId());	
		novedadnomiAsignar.setVersionRow(novedadnomi.getVersionRow());	
		novedadnomiAsignar.setid_empresa(novedadnomi.getid_empresa());
		novedadnomiAsignar.setempresa_descripcion(novedadnomi.getempresa_descripcion());	
		novedadnomiAsignar.setid_empleado(novedadnomi.getid_empleado());
		novedadnomiAsignar.setempleado_descripcion(novedadnomi.getempleado_descripcion());	
		novedadnomiAsignar.setid_empleado_autoriza(novedadnomi.getid_empleado_autoriza());
		novedadnomiAsignar.setempleadoautoriza_descripcion(novedadnomi.getempleadoautoriza_descripcion());	
		novedadnomiAsignar.setid_tipo_novedad_nomi(novedadnomi.getid_tipo_novedad_nomi());
		novedadnomiAsignar.settiponovedadnomi_descripcion(novedadnomi.gettiponovedadnomi_descripcion());	
		novedadnomiAsignar.setid_estado_novedad_nomi(novedadnomi.getid_estado_novedad_nomi());
		novedadnomiAsignar.setestadonovedadnomi_descripcion(novedadnomi.getestadonovedadnomi_descripcion());	
		novedadnomiAsignar.setfecha(novedadnomi.getfecha());	
		novedadnomiAsignar.setnumero_hora(novedadnomi.getnumero_hora());	
		novedadnomiAsignar.setnumero_minuto(novedadnomi.getnumero_minuto());	
		novedadnomiAsignar.setnumero_jornada_trabajo(novedadnomi.getnumero_jornada_trabajo());	
		novedadnomiAsignar.setanio_vacacion(novedadnomi.getanio_vacacion());	
		novedadnomiAsignar.setdescripcion(novedadnomi.getdescripcion());	
	}
	
	public static void inicializarNovedadNomi(NovedadNomi novedadnomi) throws Exception {
		try {
				novedadnomi.setId(0L);	
					
				novedadnomi.setid_empresa(-1L);	
				novedadnomi.setid_empleado(-1L);	
				novedadnomi.setid_empleado_autoriza(-1L);	
				novedadnomi.setid_tipo_novedad_nomi(-1L);	
				novedadnomi.setid_estado_novedad_nomi(-1L);	
				novedadnomi.setfecha(new Date());	
				novedadnomi.setnumero_hora(0);	
				novedadnomi.setnumero_minuto(0);	
				novedadnomi.setnumero_jornada_trabajo(0);	
				novedadnomi.setanio_vacacion(0);	
				novedadnomi.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNovedadNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_IDEMPLEADOAUTORIZA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_IDTIPONOVEDADNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_IDESTADONOVEDADNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_NUMEROHORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_NUMEROMINUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_NUMEROJORNADATRABAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_ANIOVACACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadNomiConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNovedadNomi(String sTipo,Row row,Workbook workbook,NovedadNomi novedadnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getempleadoautoriza_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.gettiponovedadnomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getestadonovedadnomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getnumero_hora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getnumero_minuto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getnumero_jornada_trabajo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getanio_vacacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadnomi.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNovedadNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNovedadNomi() {
		return this.sFinalQueryNovedadNomi;
	}
	
	public void setsFinalQueryNovedadNomi(String sFinalQueryNovedadNomi) {
		this.sFinalQueryNovedadNomi= sFinalQueryNovedadNomi;
	}
	
	public Border resaltarSeleccionarNovedadNomi=null;
	
	public Border setResaltarSeleccionarNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNovedadNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNovedadNomi() {
		return this.resaltarSeleccionarNovedadNomi;
	}
	
	public void setResaltarSeleccionarNovedadNomi(Border borderResaltarSeleccionarNovedadNomi) {
		this.resaltarSeleccionarNovedadNomi= borderResaltarSeleccionarNovedadNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNovedadNomi=null;
	public Boolean mostraridNovedadNomi=true;
	public Boolean activaridNovedadNomi=true;

	public Border resaltarid_empresaNovedadNomi=null;
	public Boolean mostrarid_empresaNovedadNomi=true;
	public Boolean activarid_empresaNovedadNomi=true;
	public Boolean cargarid_empresaNovedadNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNovedadNomi=false;//ConEventDepend=true

	public Border resaltarid_empleadoNovedadNomi=null;
	public Boolean mostrarid_empleadoNovedadNomi=true;
	public Boolean activarid_empleadoNovedadNomi=true;
	public Boolean cargarid_empleadoNovedadNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoNovedadNomi=false;//ConEventDepend=true

	public Border resaltarid_empleado_autorizaNovedadNomi=null;
	public Boolean mostrarid_empleado_autorizaNovedadNomi=true;
	public Boolean activarid_empleado_autorizaNovedadNomi=true;
	public Boolean cargarid_empleado_autorizaNovedadNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_autorizaNovedadNomi=false;//ConEventDepend=true

	public Border resaltarid_tipo_novedad_nomiNovedadNomi=null;
	public Boolean mostrarid_tipo_novedad_nomiNovedadNomi=true;
	public Boolean activarid_tipo_novedad_nomiNovedadNomi=true;
	public Boolean cargarid_tipo_novedad_nomiNovedadNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_novedad_nomiNovedadNomi=false;//ConEventDepend=true

	public Border resaltarid_estado_novedad_nomiNovedadNomi=null;
	public Boolean mostrarid_estado_novedad_nomiNovedadNomi=true;
	public Boolean activarid_estado_novedad_nomiNovedadNomi=true;
	public Boolean cargarid_estado_novedad_nomiNovedadNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_novedad_nomiNovedadNomi=false;//ConEventDepend=true

	public Border resaltarfechaNovedadNomi=null;
	public Boolean mostrarfechaNovedadNomi=true;
	public Boolean activarfechaNovedadNomi=false;

	public Border resaltarnumero_horaNovedadNomi=null;
	public Boolean mostrarnumero_horaNovedadNomi=true;
	public Boolean activarnumero_horaNovedadNomi=true;

	public Border resaltarnumero_minutoNovedadNomi=null;
	public Boolean mostrarnumero_minutoNovedadNomi=true;
	public Boolean activarnumero_minutoNovedadNomi=true;

	public Border resaltarnumero_jornada_trabajoNovedadNomi=null;
	public Boolean mostrarnumero_jornada_trabajoNovedadNomi=true;
	public Boolean activarnumero_jornada_trabajoNovedadNomi=true;

	public Border resaltaranio_vacacionNovedadNomi=null;
	public Boolean mostraranio_vacacionNovedadNomi=true;
	public Boolean activaranio_vacacionNovedadNomi=true;

	public Border resaltardescripcionNovedadNomi=null;
	public Boolean mostrardescripcionNovedadNomi=true;
	public Boolean activardescripcionNovedadNomi=true;

	
	

	public Border setResaltaridNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltaridNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNovedadNomi() {
		return this.resaltaridNovedadNomi;
	}

	public void setResaltaridNovedadNomi(Border borderResaltar) {
		this.resaltaridNovedadNomi= borderResaltar;
	}

	public Boolean getMostraridNovedadNomi() {
		return this.mostraridNovedadNomi;
	}

	public void setMostraridNovedadNomi(Boolean mostraridNovedadNomi) {
		this.mostraridNovedadNomi= mostraridNovedadNomi;
	}

	public Boolean getActivaridNovedadNomi() {
		return this.activaridNovedadNomi;
	}

	public void setActivaridNovedadNomi(Boolean activaridNovedadNomi) {
		this.activaridNovedadNomi= activaridNovedadNomi;
	}

	public Border setResaltarid_empresaNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNovedadNomi() {
		return this.resaltarid_empresaNovedadNomi;
	}

	public void setResaltarid_empresaNovedadNomi(Border borderResaltar) {
		this.resaltarid_empresaNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaNovedadNomi() {
		return this.mostrarid_empresaNovedadNomi;
	}

	public void setMostrarid_empresaNovedadNomi(Boolean mostrarid_empresaNovedadNomi) {
		this.mostrarid_empresaNovedadNomi= mostrarid_empresaNovedadNomi;
	}

	public Boolean getActivarid_empresaNovedadNomi() {
		return this.activarid_empresaNovedadNomi;
	}

	public void setActivarid_empresaNovedadNomi(Boolean activarid_empresaNovedadNomi) {
		this.activarid_empresaNovedadNomi= activarid_empresaNovedadNomi;
	}

	public Boolean getCargarid_empresaNovedadNomi() {
		return this.cargarid_empresaNovedadNomi;
	}

	public void setCargarid_empresaNovedadNomi(Boolean cargarid_empresaNovedadNomi) {
		this.cargarid_empresaNovedadNomi= cargarid_empresaNovedadNomi;
	}

	public Border setResaltarid_empleadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarid_empleadoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoNovedadNomi() {
		return this.resaltarid_empleadoNovedadNomi;
	}

	public void setResaltarid_empleadoNovedadNomi(Border borderResaltar) {
		this.resaltarid_empleadoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarid_empleadoNovedadNomi() {
		return this.mostrarid_empleadoNovedadNomi;
	}

	public void setMostrarid_empleadoNovedadNomi(Boolean mostrarid_empleadoNovedadNomi) {
		this.mostrarid_empleadoNovedadNomi= mostrarid_empleadoNovedadNomi;
	}

	public Boolean getActivarid_empleadoNovedadNomi() {
		return this.activarid_empleadoNovedadNomi;
	}

	public void setActivarid_empleadoNovedadNomi(Boolean activarid_empleadoNovedadNomi) {
		this.activarid_empleadoNovedadNomi= activarid_empleadoNovedadNomi;
	}

	public Boolean getCargarid_empleadoNovedadNomi() {
		return this.cargarid_empleadoNovedadNomi;
	}

	public void setCargarid_empleadoNovedadNomi(Boolean cargarid_empleadoNovedadNomi) {
		this.cargarid_empleadoNovedadNomi= cargarid_empleadoNovedadNomi;
	}

	public Border setResaltarid_empleado_autorizaNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarid_empleado_autorizaNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_autorizaNovedadNomi() {
		return this.resaltarid_empleado_autorizaNovedadNomi;
	}

	public void setResaltarid_empleado_autorizaNovedadNomi(Border borderResaltar) {
		this.resaltarid_empleado_autorizaNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarid_empleado_autorizaNovedadNomi() {
		return this.mostrarid_empleado_autorizaNovedadNomi;
	}

	public void setMostrarid_empleado_autorizaNovedadNomi(Boolean mostrarid_empleado_autorizaNovedadNomi) {
		this.mostrarid_empleado_autorizaNovedadNomi= mostrarid_empleado_autorizaNovedadNomi;
	}

	public Boolean getActivarid_empleado_autorizaNovedadNomi() {
		return this.activarid_empleado_autorizaNovedadNomi;
	}

	public void setActivarid_empleado_autorizaNovedadNomi(Boolean activarid_empleado_autorizaNovedadNomi) {
		this.activarid_empleado_autorizaNovedadNomi= activarid_empleado_autorizaNovedadNomi;
	}

	public Boolean getCargarid_empleado_autorizaNovedadNomi() {
		return this.cargarid_empleado_autorizaNovedadNomi;
	}

	public void setCargarid_empleado_autorizaNovedadNomi(Boolean cargarid_empleado_autorizaNovedadNomi) {
		this.cargarid_empleado_autorizaNovedadNomi= cargarid_empleado_autorizaNovedadNomi;
	}

	public Border setResaltarid_tipo_novedad_nomiNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarid_tipo_novedad_nomiNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_novedad_nomiNovedadNomi() {
		return this.resaltarid_tipo_novedad_nomiNovedadNomi;
	}

	public void setResaltarid_tipo_novedad_nomiNovedadNomi(Border borderResaltar) {
		this.resaltarid_tipo_novedad_nomiNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarid_tipo_novedad_nomiNovedadNomi() {
		return this.mostrarid_tipo_novedad_nomiNovedadNomi;
	}

	public void setMostrarid_tipo_novedad_nomiNovedadNomi(Boolean mostrarid_tipo_novedad_nomiNovedadNomi) {
		this.mostrarid_tipo_novedad_nomiNovedadNomi= mostrarid_tipo_novedad_nomiNovedadNomi;
	}

	public Boolean getActivarid_tipo_novedad_nomiNovedadNomi() {
		return this.activarid_tipo_novedad_nomiNovedadNomi;
	}

	public void setActivarid_tipo_novedad_nomiNovedadNomi(Boolean activarid_tipo_novedad_nomiNovedadNomi) {
		this.activarid_tipo_novedad_nomiNovedadNomi= activarid_tipo_novedad_nomiNovedadNomi;
	}

	public Boolean getCargarid_tipo_novedad_nomiNovedadNomi() {
		return this.cargarid_tipo_novedad_nomiNovedadNomi;
	}

	public void setCargarid_tipo_novedad_nomiNovedadNomi(Boolean cargarid_tipo_novedad_nomiNovedadNomi) {
		this.cargarid_tipo_novedad_nomiNovedadNomi= cargarid_tipo_novedad_nomiNovedadNomi;
	}

	public Border setResaltarid_estado_novedad_nomiNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarid_estado_novedad_nomiNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_novedad_nomiNovedadNomi() {
		return this.resaltarid_estado_novedad_nomiNovedadNomi;
	}

	public void setResaltarid_estado_novedad_nomiNovedadNomi(Border borderResaltar) {
		this.resaltarid_estado_novedad_nomiNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarid_estado_novedad_nomiNovedadNomi() {
		return this.mostrarid_estado_novedad_nomiNovedadNomi;
	}

	public void setMostrarid_estado_novedad_nomiNovedadNomi(Boolean mostrarid_estado_novedad_nomiNovedadNomi) {
		this.mostrarid_estado_novedad_nomiNovedadNomi= mostrarid_estado_novedad_nomiNovedadNomi;
	}

	public Boolean getActivarid_estado_novedad_nomiNovedadNomi() {
		return this.activarid_estado_novedad_nomiNovedadNomi;
	}

	public void setActivarid_estado_novedad_nomiNovedadNomi(Boolean activarid_estado_novedad_nomiNovedadNomi) {
		this.activarid_estado_novedad_nomiNovedadNomi= activarid_estado_novedad_nomiNovedadNomi;
	}

	public Boolean getCargarid_estado_novedad_nomiNovedadNomi() {
		return this.cargarid_estado_novedad_nomiNovedadNomi;
	}

	public void setCargarid_estado_novedad_nomiNovedadNomi(Boolean cargarid_estado_novedad_nomiNovedadNomi) {
		this.cargarid_estado_novedad_nomiNovedadNomi= cargarid_estado_novedad_nomiNovedadNomi;
	}

	public Border setResaltarfechaNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarfechaNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaNovedadNomi() {
		return this.resaltarfechaNovedadNomi;
	}

	public void setResaltarfechaNovedadNomi(Border borderResaltar) {
		this.resaltarfechaNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarfechaNovedadNomi() {
		return this.mostrarfechaNovedadNomi;
	}

	public void setMostrarfechaNovedadNomi(Boolean mostrarfechaNovedadNomi) {
		this.mostrarfechaNovedadNomi= mostrarfechaNovedadNomi;
	}

	public Boolean getActivarfechaNovedadNomi() {
		return this.activarfechaNovedadNomi;
	}

	public void setActivarfechaNovedadNomi(Boolean activarfechaNovedadNomi) {
		this.activarfechaNovedadNomi= activarfechaNovedadNomi;
	}

	public Border setResaltarnumero_horaNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarnumero_horaNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_horaNovedadNomi() {
		return this.resaltarnumero_horaNovedadNomi;
	}

	public void setResaltarnumero_horaNovedadNomi(Border borderResaltar) {
		this.resaltarnumero_horaNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarnumero_horaNovedadNomi() {
		return this.mostrarnumero_horaNovedadNomi;
	}

	public void setMostrarnumero_horaNovedadNomi(Boolean mostrarnumero_horaNovedadNomi) {
		this.mostrarnumero_horaNovedadNomi= mostrarnumero_horaNovedadNomi;
	}

	public Boolean getActivarnumero_horaNovedadNomi() {
		return this.activarnumero_horaNovedadNomi;
	}

	public void setActivarnumero_horaNovedadNomi(Boolean activarnumero_horaNovedadNomi) {
		this.activarnumero_horaNovedadNomi= activarnumero_horaNovedadNomi;
	}

	public Border setResaltarnumero_minutoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarnumero_minutoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_minutoNovedadNomi() {
		return this.resaltarnumero_minutoNovedadNomi;
	}

	public void setResaltarnumero_minutoNovedadNomi(Border borderResaltar) {
		this.resaltarnumero_minutoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarnumero_minutoNovedadNomi() {
		return this.mostrarnumero_minutoNovedadNomi;
	}

	public void setMostrarnumero_minutoNovedadNomi(Boolean mostrarnumero_minutoNovedadNomi) {
		this.mostrarnumero_minutoNovedadNomi= mostrarnumero_minutoNovedadNomi;
	}

	public Boolean getActivarnumero_minutoNovedadNomi() {
		return this.activarnumero_minutoNovedadNomi;
	}

	public void setActivarnumero_minutoNovedadNomi(Boolean activarnumero_minutoNovedadNomi) {
		this.activarnumero_minutoNovedadNomi= activarnumero_minutoNovedadNomi;
	}

	public Border setResaltarnumero_jornada_trabajoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltarnumero_jornada_trabajoNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_jornada_trabajoNovedadNomi() {
		return this.resaltarnumero_jornada_trabajoNovedadNomi;
	}

	public void setResaltarnumero_jornada_trabajoNovedadNomi(Border borderResaltar) {
		this.resaltarnumero_jornada_trabajoNovedadNomi= borderResaltar;
	}

	public Boolean getMostrarnumero_jornada_trabajoNovedadNomi() {
		return this.mostrarnumero_jornada_trabajoNovedadNomi;
	}

	public void setMostrarnumero_jornada_trabajoNovedadNomi(Boolean mostrarnumero_jornada_trabajoNovedadNomi) {
		this.mostrarnumero_jornada_trabajoNovedadNomi= mostrarnumero_jornada_trabajoNovedadNomi;
	}

	public Boolean getActivarnumero_jornada_trabajoNovedadNomi() {
		return this.activarnumero_jornada_trabajoNovedadNomi;
	}

	public void setActivarnumero_jornada_trabajoNovedadNomi(Boolean activarnumero_jornada_trabajoNovedadNomi) {
		this.activarnumero_jornada_trabajoNovedadNomi= activarnumero_jornada_trabajoNovedadNomi;
	}

	public Border setResaltaranio_vacacionNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltaranio_vacacionNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranio_vacacionNovedadNomi() {
		return this.resaltaranio_vacacionNovedadNomi;
	}

	public void setResaltaranio_vacacionNovedadNomi(Border borderResaltar) {
		this.resaltaranio_vacacionNovedadNomi= borderResaltar;
	}

	public Boolean getMostraranio_vacacionNovedadNomi() {
		return this.mostraranio_vacacionNovedadNomi;
	}

	public void setMostraranio_vacacionNovedadNomi(Boolean mostraranio_vacacionNovedadNomi) {
		this.mostraranio_vacacionNovedadNomi= mostraranio_vacacionNovedadNomi;
	}

	public Boolean getActivaranio_vacacionNovedadNomi() {
		return this.activaranio_vacacionNovedadNomi;
	}

	public void setActivaranio_vacacionNovedadNomi(Boolean activaranio_vacacionNovedadNomi) {
		this.activaranio_vacacionNovedadNomi= activaranio_vacacionNovedadNomi;
	}

	public Border setResaltardescripcionNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadnomiBeanSwingJInternalFrame.jTtoolBarNovedadNomi.setBorder(borderResaltar);
		
		this.resaltardescripcionNovedadNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNovedadNomi() {
		return this.resaltardescripcionNovedadNomi;
	}

	public void setResaltardescripcionNovedadNomi(Border borderResaltar) {
		this.resaltardescripcionNovedadNomi= borderResaltar;
	}

	public Boolean getMostrardescripcionNovedadNomi() {
		return this.mostrardescripcionNovedadNomi;
	}

	public void setMostrardescripcionNovedadNomi(Boolean mostrardescripcionNovedadNomi) {
		this.mostrardescripcionNovedadNomi= mostrardescripcionNovedadNomi;
	}

	public Boolean getActivardescripcionNovedadNomi() {
		return this.activardescripcionNovedadNomi;
	}

	public void setActivardescripcionNovedadNomi(Boolean activardescripcionNovedadNomi) {
		this.activardescripcionNovedadNomi= activardescripcionNovedadNomi;
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
		
		
		this.setMostraridNovedadNomi(esInicial);
		this.setMostrarid_empresaNovedadNomi(esInicial);
		this.setMostrarid_empleadoNovedadNomi(esInicial);
		this.setMostrarid_empleado_autorizaNovedadNomi(esInicial);
		this.setMostrarid_tipo_novedad_nomiNovedadNomi(esInicial);
		this.setMostrarid_estado_novedad_nomiNovedadNomi(esInicial);
		this.setMostrarfechaNovedadNomi(esInicial);
		this.setMostrarnumero_horaNovedadNomi(esInicial);
		this.setMostrarnumero_minutoNovedadNomi(esInicial);
		this.setMostrarnumero_jornada_trabajoNovedadNomi(esInicial);
		this.setMostraranio_vacacionNovedadNomi(esInicial);
		this.setMostrardescripcionNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadNomiConstantesFunciones.ID)) {
				this.setMostraridNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA)) {
				this.setMostrarid_empleado_autorizaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI)) {
				this.setMostrarid_tipo_novedad_nomiNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI)) {
				this.setMostrarid_estado_novedad_nomiNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.FECHA)) {
				this.setMostrarfechaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROHORA)) {
				this.setMostrarnumero_horaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROMINUTO)) {
				this.setMostrarnumero_minutoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO)) {
				this.setMostrarnumero_jornada_trabajoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.ANIOVACACION)) {
				this.setMostraranio_vacacionNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNovedadNomi(esAsigna);
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
		
		
		this.setActivaridNovedadNomi(esInicial);
		this.setActivarid_empresaNovedadNomi(esInicial);
		this.setActivarid_empleadoNovedadNomi(esInicial);
		this.setActivarid_empleado_autorizaNovedadNomi(esInicial);
		this.setActivarid_tipo_novedad_nomiNovedadNomi(esInicial);
		this.setActivarid_estado_novedad_nomiNovedadNomi(esInicial);
		this.setActivarfechaNovedadNomi(esInicial);
		this.setActivarnumero_horaNovedadNomi(esInicial);
		this.setActivarnumero_minutoNovedadNomi(esInicial);
		this.setActivarnumero_jornada_trabajoNovedadNomi(esInicial);
		this.setActivaranio_vacacionNovedadNomi(esInicial);
		this.setActivardescripcionNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadNomiConstantesFunciones.ID)) {
				this.setActivaridNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA)) {
				this.setActivarid_empleado_autorizaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI)) {
				this.setActivarid_tipo_novedad_nomiNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI)) {
				this.setActivarid_estado_novedad_nomiNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.FECHA)) {
				this.setActivarfechaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROHORA)) {
				this.setActivarnumero_horaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROMINUTO)) {
				this.setActivarnumero_minutoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO)) {
				this.setActivarnumero_jornada_trabajoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.ANIOVACACION)) {
				this.setActivaranio_vacacionNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNovedadNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNovedadNomi(esInicial);
		this.setResaltarid_empresaNovedadNomi(esInicial);
		this.setResaltarid_empleadoNovedadNomi(esInicial);
		this.setResaltarid_empleado_autorizaNovedadNomi(esInicial);
		this.setResaltarid_tipo_novedad_nomiNovedadNomi(esInicial);
		this.setResaltarid_estado_novedad_nomiNovedadNomi(esInicial);
		this.setResaltarfechaNovedadNomi(esInicial);
		this.setResaltarnumero_horaNovedadNomi(esInicial);
		this.setResaltarnumero_minutoNovedadNomi(esInicial);
		this.setResaltarnumero_jornada_trabajoNovedadNomi(esInicial);
		this.setResaltaranio_vacacionNovedadNomi(esInicial);
		this.setResaltardescripcionNovedadNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadNomiConstantesFunciones.ID)) {
				this.setResaltaridNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA)) {
				this.setResaltarid_empleado_autorizaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI)) {
				this.setResaltarid_tipo_novedad_nomiNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI)) {
				this.setResaltarid_estado_novedad_nomiNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.FECHA)) {
				this.setResaltarfechaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROHORA)) {
				this.setResaltarnumero_horaNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROMINUTO)) {
				this.setResaltarnumero_minutoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO)) {
				this.setResaltarnumero_jornada_trabajoNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.ANIOVACACION)) {
				this.setResaltaranio_vacacionNovedadNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadNomiConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNovedadNomi(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoNovedadNomi=true;

	public Boolean getMostrarFK_IdEmpleadoNovedadNomi() {
		return this.mostrarFK_IdEmpleadoNovedadNomi;
	}

	public void setMostrarFK_IdEmpleadoNovedadNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoNovedadNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoAutorizaNovedadNomi=true;

	public Boolean getMostrarFK_IdEmpleadoAutorizaNovedadNomi() {
		return this.mostrarFK_IdEmpleadoAutorizaNovedadNomi;
	}

	public void setMostrarFK_IdEmpleadoAutorizaNovedadNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAutorizaNovedadNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNovedadNomi=true;

	public Boolean getMostrarFK_IdEmpresaNovedadNomi() {
		return this.mostrarFK_IdEmpresaNovedadNomi;
	}

	public void setMostrarFK_IdEmpresaNovedadNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNovedadNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoNovedadNomiNovedadNomi=true;

	public Boolean getMostrarFK_IdEstadoNovedadNomiNovedadNomi() {
		return this.mostrarFK_IdEstadoNovedadNomiNovedadNomi;
	}

	public void setMostrarFK_IdEstadoNovedadNomiNovedadNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoNovedadNomiNovedadNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoNovedadNomiNovedadNomi=true;

	public Boolean getMostrarFK_IdTipoNovedadNomiNovedadNomi() {
		return this.mostrarFK_IdTipoNovedadNomiNovedadNomi;
	}

	public void setMostrarFK_IdTipoNovedadNomiNovedadNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoNovedadNomiNovedadNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoNovedadNomi=true;

	public Boolean getActivarFK_IdEmpleadoNovedadNomi() {
		return this.activarFK_IdEmpleadoNovedadNomi;
	}

	public void setActivarFK_IdEmpleadoNovedadNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoNovedadNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoAutorizaNovedadNomi=true;

	public Boolean getActivarFK_IdEmpleadoAutorizaNovedadNomi() {
		return this.activarFK_IdEmpleadoAutorizaNovedadNomi;
	}

	public void setActivarFK_IdEmpleadoAutorizaNovedadNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAutorizaNovedadNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNovedadNomi=true;

	public Boolean getActivarFK_IdEmpresaNovedadNomi() {
		return this.activarFK_IdEmpresaNovedadNomi;
	}

	public void setActivarFK_IdEmpresaNovedadNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNovedadNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoNovedadNomiNovedadNomi=true;

	public Boolean getActivarFK_IdEstadoNovedadNomiNovedadNomi() {
		return this.activarFK_IdEstadoNovedadNomiNovedadNomi;
	}

	public void setActivarFK_IdEstadoNovedadNomiNovedadNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoNovedadNomiNovedadNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoNovedadNomiNovedadNomi=true;

	public Boolean getActivarFK_IdTipoNovedadNomiNovedadNomi() {
		return this.activarFK_IdTipoNovedadNomiNovedadNomi;
	}

	public void setActivarFK_IdTipoNovedadNomiNovedadNomi(Boolean habilitarResaltar) {
		this.activarFK_IdTipoNovedadNomiNovedadNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoNovedadNomi=null;

	public Border getResaltarFK_IdEmpleadoNovedadNomi() {
		return this.resaltarFK_IdEmpleadoNovedadNomi;
	}

	public void setResaltarFK_IdEmpleadoNovedadNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoNovedadNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoNovedadNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoAutorizaNovedadNomi=null;

	public Border getResaltarFK_IdEmpleadoAutorizaNovedadNomi() {
		return this.resaltarFK_IdEmpleadoAutorizaNovedadNomi;
	}

	public void setResaltarFK_IdEmpleadoAutorizaNovedadNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAutorizaNovedadNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAutorizaNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAutorizaNovedadNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNovedadNomi=null;

	public Border getResaltarFK_IdEmpresaNovedadNomi() {
		return this.resaltarFK_IdEmpresaNovedadNomi;
	}

	public void setResaltarFK_IdEmpresaNovedadNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNovedadNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNovedadNomi= borderResaltar;
	}

	public Border resaltarFK_IdEstadoNovedadNomiNovedadNomi=null;

	public Border getResaltarFK_IdEstadoNovedadNomiNovedadNomi() {
		return this.resaltarFK_IdEstadoNovedadNomiNovedadNomi;
	}

	public void setResaltarFK_IdEstadoNovedadNomiNovedadNomi(Border borderResaltar) {
		this.resaltarFK_IdEstadoNovedadNomiNovedadNomi= borderResaltar;
	}

	public void setResaltarFK_IdEstadoNovedadNomiNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoNovedadNomiNovedadNomi= borderResaltar;
	}

	public Border resaltarFK_IdTipoNovedadNomiNovedadNomi=null;

	public Border getResaltarFK_IdTipoNovedadNomiNovedadNomi() {
		return this.resaltarFK_IdTipoNovedadNomiNovedadNomi;
	}

	public void setResaltarFK_IdTipoNovedadNomiNovedadNomi(Border borderResaltar) {
		this.resaltarFK_IdTipoNovedadNomiNovedadNomi= borderResaltar;
	}

	public void setResaltarFK_IdTipoNovedadNomiNovedadNomi(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadNomiBeanSwingJInternalFrame novedadnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoNovedadNomiNovedadNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}