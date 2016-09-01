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


import com.bydan.erp.nomina.util.CursoConstantesFunciones;
import com.bydan.erp.nomina.util.CursoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CursoParameterGeneral;

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
final public class CursoConstantesFunciones extends CursoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Curso";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Curso"+CursoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CursoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CursoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CursoConstantesFunciones.SCHEMA+"_"+CursoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CursoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CursoConstantesFunciones.SCHEMA+"_"+CursoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CursoConstantesFunciones.SCHEMA+"_"+CursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CursoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CursoConstantesFunciones.SCHEMA+"_"+CursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CursoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CursoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CursoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CursoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CursoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CursoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CursoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CursoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CursoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cursos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Curso";
	public static final String SCLASSWEBTITULO_LOWER="Curso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Curso";
	public static final String OBJECTNAME="curso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="curso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select curso from "+CursoConstantesFunciones.SPERSISTENCENAME+" curso";
	public static String QUERYSELECTNATIVE="select "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".version_row,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_empresa,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_empleado,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_tipo_curso,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_tipo_institucion,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".nombre,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".codigo_inscripcion,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".fecha_inicio,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".fecha_fin,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".numero_horas,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".es_aprobado,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".es_auspicio_empresa,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".descripcion from "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME;//+" as "+CursoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CursoConstantesFuncionesAdditional cursoConstantesFuncionesAdditional=null;
	
	public CursoConstantesFuncionesAdditional getCursoConstantesFuncionesAdditional() {
		return this.cursoConstantesFuncionesAdditional;
	}
	
	public void setCursoConstantesFuncionesAdditional(CursoConstantesFuncionesAdditional cursoConstantesFuncionesAdditional) {
		try {
			this.cursoConstantesFuncionesAdditional=cursoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPOCURSO= "id_tipo_curso";
    public static final String IDTIPOINSTITUCION= "id_tipo_institucion";
    public static final String NOMBRE= "nombre";
    public static final String CODIGOINSCRIPCION= "codigo_inscripcion";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NUMEROHORAS= "numero_horas";
    public static final String ESAPROBADO= "es_aprobado";
    public static final String ESAUSPICIOEMPRESA= "es_auspicio_empresa";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPOCURSO= "Tipo Curso";
		public static final String LABEL_IDTIPOCURSO_LOWER= "Tipo Curso";
    	public static final String LABEL_IDTIPOINSTITUCION= "Tipo Institucion";
		public static final String LABEL_IDTIPOINSTITUCION_LOWER= "Tipo Institucion";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOINSCRIPCION= "Codigo Inscripcion";
		public static final String LABEL_CODIGOINSCRIPCION_LOWER= "Codigo Inscripcion";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NUMEROHORAS= "Numero Horas";
		public static final String LABEL_NUMEROHORAS_LOWER= "Numero Horas";
    	public static final String LABEL_ESAPROBADO= "Es Aprobado";
		public static final String LABEL_ESAPROBADO_LOWER= "Es Aprobado";
    	public static final String LABEL_ESAUSPICIOEMPRESA= "Es Auspicio Empresa";
		public static final String LABEL_ESAUSPICIOEMPRESA_LOWER= "Es Auspicio Empresa";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_INSCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_INSCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCursoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CursoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CursoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CursoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CursoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CursoConstantesFunciones.IDTIPOCURSO)) {sLabelColumna=CursoConstantesFunciones.LABEL_IDTIPOCURSO;}
		if(sNombreColumna.equals(CursoConstantesFunciones.IDTIPOINSTITUCION)) {sLabelColumna=CursoConstantesFunciones.LABEL_IDTIPOINSTITUCION;}
		if(sNombreColumna.equals(CursoConstantesFunciones.NOMBRE)) {sLabelColumna=CursoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CursoConstantesFunciones.CODIGOINSCRIPCION)) {sLabelColumna=CursoConstantesFunciones.LABEL_CODIGOINSCRIPCION;}
		if(sNombreColumna.equals(CursoConstantesFunciones.FECHAINICIO)) {sLabelColumna=CursoConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(CursoConstantesFunciones.FECHAFIN)) {sLabelColumna=CursoConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(CursoConstantesFunciones.NUMEROHORAS)) {sLabelColumna=CursoConstantesFunciones.LABEL_NUMEROHORAS;}
		if(sNombreColumna.equals(CursoConstantesFunciones.ESAPROBADO)) {sLabelColumna=CursoConstantesFunciones.LABEL_ESAPROBADO;}
		if(sNombreColumna.equals(CursoConstantesFunciones.ESAUSPICIOEMPRESA)) {sLabelColumna=CursoConstantesFunciones.LABEL_ESAUSPICIOEMPRESA;}
		if(sNombreColumna.equals(CursoConstantesFunciones.DESCRIPCION)) {sLabelColumna=CursoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_aprobadoDescripcion(Curso curso) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!curso.getes_aprobado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_aprobadoHtmlDescripcion(Curso curso) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(curso.getId(),curso.getes_aprobado());

		return sDescripcion;
	}	
		
	public static String getes_auspicio_empresaDescripcion(Curso curso) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!curso.getes_auspicio_empresa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_auspicio_empresaHtmlDescripcion(Curso curso) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(curso.getId(),curso.getes_auspicio_empresa());

		return sDescripcion;
	}	
			
	
	public static String getCursoDescripcion(Curso curso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(curso !=null/* && curso.getId()!=0*/) {
			sDescripcion=curso.getnombre();//cursocurso.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCursoDescripcionDetallado(Curso curso) {
		String sDescripcion="";
			
		sDescripcion+=CursoConstantesFunciones.ID+"=";
		sDescripcion+=curso.getId().toString()+",";
		sDescripcion+=CursoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=curso.getVersionRow().toString()+",";
		sDescripcion+=CursoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=curso.getid_empresa().toString()+",";
		sDescripcion+=CursoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=curso.getid_empleado().toString()+",";
		sDescripcion+=CursoConstantesFunciones.IDTIPOCURSO+"=";
		sDescripcion+=curso.getid_tipo_curso().toString()+",";
		sDescripcion+=CursoConstantesFunciones.IDTIPOINSTITUCION+"=";
		sDescripcion+=curso.getid_tipo_institucion().toString()+",";
		sDescripcion+=CursoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=curso.getnombre()+",";
		sDescripcion+=CursoConstantesFunciones.CODIGOINSCRIPCION+"=";
		sDescripcion+=curso.getcodigo_inscripcion()+",";
		sDescripcion+=CursoConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=curso.getfecha_inicio().toString()+",";
		sDescripcion+=CursoConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=curso.getfecha_fin().toString()+",";
		sDescripcion+=CursoConstantesFunciones.NUMEROHORAS+"=";
		sDescripcion+=curso.getnumero_horas().toString()+",";
		sDescripcion+=CursoConstantesFunciones.ESAPROBADO+"=";
		sDescripcion+=curso.getes_aprobado().toString()+",";
		sDescripcion+=CursoConstantesFunciones.ESAUSPICIOEMPRESA+"=";
		sDescripcion+=curso.getes_auspicio_empresa().toString()+",";
		sDescripcion+=CursoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=curso.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCursoDescripcion(Curso curso,String sValor) throws Exception {			
		if(curso !=null) {
			curso.setnombre(sValor);;//cursocurso.getnombre().trim();
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

	public static String getTipoCursoDescripcion(TipoCurso tipocurso) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocurso!=null/*&&tipocurso.getId()>0*/) {
			sDescripcion=TipoCursoConstantesFunciones.getTipoCursoDescripcion(tipocurso);
		}

		return sDescripcion;
	}

	public static String getTipoInstitucionDescripcion(TipoInstitucion tipoinstitucion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoinstitucion!=null/*&&tipoinstitucion.getId()>0*/) {
			sDescripcion=TipoInstitucionConstantesFunciones.getTipoInstitucionDescripcion(tipoinstitucion);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoCurso")) {
			sNombreIndice="Tipo=  Por Tipo Curso";
		} else if(sNombreIndice.equals("FK_IdTipoInstitucion")) {
			sNombreIndice="Tipo=  Por Tipo Institucion";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCurso(Long id_tipo_curso) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_curso!=null) {sDetalleIndice+=" Codigo Unico De Tipo Curso="+id_tipo_curso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoInstitucion(Long id_tipo_institucion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_institucion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Institucion="+id_tipo_institucion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCurso(Curso curso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		curso.setnombre(curso.getnombre().trim());
		curso.setcodigo_inscripcion(curso.getcodigo_inscripcion().trim());
		curso.setdescripcion(curso.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCursos(List<Curso> cursos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Curso curso: cursos) {
			curso.setnombre(curso.getnombre().trim());
			curso.setcodigo_inscripcion(curso.getcodigo_inscripcion().trim());
			curso.setdescripcion(curso.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCurso(Curso curso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && curso.getConCambioAuxiliar()) {
			curso.setIsDeleted(curso.getIsDeletedAuxiliar());	
			curso.setIsNew(curso.getIsNewAuxiliar());	
			curso.setIsChanged(curso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			curso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			curso.setIsDeletedAuxiliar(false);	
			curso.setIsNewAuxiliar(false);	
			curso.setIsChangedAuxiliar(false);
			
			curso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCursos(List<Curso> cursos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Curso curso : cursos) {
			if(conAsignarBase && curso.getConCambioAuxiliar()) {
				curso.setIsDeleted(curso.getIsDeletedAuxiliar());	
				curso.setIsNew(curso.getIsNewAuxiliar());	
				curso.setIsChanged(curso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				curso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				curso.setIsDeletedAuxiliar(false);	
				curso.setIsNewAuxiliar(false);	
				curso.setIsChangedAuxiliar(false);
				
				curso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCurso(Curso curso,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			curso.setnumero_horas(0);
		}
	}		
	
	public static void InicializarValoresCursos(List<Curso> cursos,Boolean conEnteros) throws Exception  {
		
		for(Curso curso: cursos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				curso.setnumero_horas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCurso(List<Curso> cursos,Curso cursoAux) throws Exception  {
		CursoConstantesFunciones.InicializarValoresCurso(cursoAux,true);
		
		for(Curso curso: cursos) {
			if(curso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cursoAux.setnumero_horas(cursoAux.getnumero_horas()+curso.getnumero_horas());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCurso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CursoConstantesFunciones.getArrayColumnasGlobalesCurso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCurso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CursoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CursoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCurso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Curso> cursos,Curso curso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Curso cursoAux: cursos) {
			if(cursoAux!=null && curso!=null) {
				if((cursoAux.getId()==null && curso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cursoAux.getId()!=null && curso.getId()!=null){
					if(cursoAux.getId().equals(curso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCurso(List<Curso> cursos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Curso curso: cursos) {			
			if(curso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCurso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_ID, CursoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_VERSIONROW, CursoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_IDEMPRESA, CursoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_IDEMPLEADO, CursoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_IDTIPOCURSO, CursoConstantesFunciones.IDTIPOCURSO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_IDTIPOINSTITUCION, CursoConstantesFunciones.IDTIPOINSTITUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_NOMBRE, CursoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_CODIGOINSCRIPCION, CursoConstantesFunciones.CODIGOINSCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_FECHAINICIO, CursoConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_FECHAFIN, CursoConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_NUMEROHORAS, CursoConstantesFunciones.NUMEROHORAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_ESAPROBADO, CursoConstantesFunciones.ESAPROBADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_ESAUSPICIOEMPRESA, CursoConstantesFunciones.ESAUSPICIOEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CursoConstantesFunciones.LABEL_DESCRIPCION, CursoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCurso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.IDTIPOCURSO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.IDTIPOINSTITUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.CODIGOINSCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.NUMEROHORAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.ESAPROBADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.ESAUSPICIOEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CursoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCurso() throws Exception  {
		return CursoConstantesFunciones.getTiposSeleccionarCurso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCurso(Boolean conFk) throws Exception  {
		return CursoConstantesFunciones.getTiposSeleccionarCurso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCurso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_IDTIPOCURSO);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_IDTIPOCURSO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_IDTIPOINSTITUCION);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_IDTIPOINSTITUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_CODIGOINSCRIPCION);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_CODIGOINSCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_NUMEROHORAS);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_NUMEROHORAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_ESAPROBADO);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_ESAPROBADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_ESAUSPICIOEMPRESA);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_ESAUSPICIOEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CursoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CursoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCurso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCurso(Curso cursoAux) throws Exception {
		
			cursoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cursoAux.getEmpresa()));
			cursoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(cursoAux.getEmpleado()));
			cursoAux.settipocurso_descripcion(TipoCursoConstantesFunciones.getTipoCursoDescripcion(cursoAux.getTipoCurso()));
			cursoAux.settipoinstitucion_descripcion(TipoInstitucionConstantesFunciones.getTipoInstitucionDescripcion(cursoAux.getTipoInstitucion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCurso(List<Curso> cursosTemp) throws Exception {
		for(Curso cursoAux:cursosTemp) {
			
			cursoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cursoAux.getEmpresa()));
			cursoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(cursoAux.getEmpleado()));
			cursoAux.settipocurso_descripcion(TipoCursoConstantesFunciones.getTipoCursoDescripcion(cursoAux.getTipoCurso()));
			cursoAux.settipoinstitucion_descripcion(TipoInstitucionConstantesFunciones.getTipoInstitucionDescripcion(cursoAux.getTipoInstitucion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoCurso.class));
				classes.add(new Classe(TipoInstitucion.class));
				
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
					if(clas.clas.equals(TipoCurso.class)) {
						classes.add(new Classe(TipoCurso.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoInstitucion.class)) {
						classes.add(new Classe(TipoInstitucion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoCurso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCurso.class)); continue;
					}

					if(TipoInstitucion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInstitucion.class)); continue;
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

					if(TipoCurso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCurso.class)); continue;
					}

					if(TipoInstitucion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInstitucion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CursoConstantesFunciones.getClassesRelationshipsOfCurso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleCurso.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCurso.class)) {
						classes.add(new Classe(DetalleCurso.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CursoConstantesFunciones.getClassesRelationshipsFromStringsOfCurso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCurso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleCurso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCurso.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleCurso.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCurso.class)); continue;
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
	public static void actualizarLista(Curso curso,List<Curso> cursos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Curso cursoEncontrado=null;
			
			for(Curso cursoLocal:cursos) {
				if(cursoLocal.getId().equals(curso.getId())) {
					cursoEncontrado=cursoLocal;
					
					cursoLocal.setIsChanged(curso.getIsChanged());
					cursoLocal.setIsNew(curso.getIsNew());
					cursoLocal.setIsDeleted(curso.getIsDeleted());
					
					cursoLocal.setGeneralEntityOriginal(curso.getGeneralEntityOriginal());
					
					cursoLocal.setId(curso.getId());	
					cursoLocal.setVersionRow(curso.getVersionRow());	
					cursoLocal.setid_empresa(curso.getid_empresa());	
					cursoLocal.setid_empleado(curso.getid_empleado());	
					cursoLocal.setid_tipo_curso(curso.getid_tipo_curso());	
					cursoLocal.setid_tipo_institucion(curso.getid_tipo_institucion());	
					cursoLocal.setnombre(curso.getnombre());	
					cursoLocal.setcodigo_inscripcion(curso.getcodigo_inscripcion());	
					cursoLocal.setfecha_inicio(curso.getfecha_inicio());	
					cursoLocal.setfecha_fin(curso.getfecha_fin());	
					cursoLocal.setnumero_horas(curso.getnumero_horas());	
					cursoLocal.setes_aprobado(curso.getes_aprobado());	
					cursoLocal.setes_auspicio_empresa(curso.getes_auspicio_empresa());	
					cursoLocal.setdescripcion(curso.getdescripcion());	
					
					
					cursoLocal.setDetalleCursos(curso.getDetalleCursos());
					
					existe=true;
					break;
				}
			}
			
			if(!curso.getIsDeleted()) {
				if(!existe) {
					cursos.add(curso);
				}
			} else {
				if(cursoEncontrado!=null && permiteQuitar)  {
					cursos.remove(cursoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Curso curso,List<Curso> cursos) throws Exception {
		try	{			
			for(Curso cursoLocal:cursos) {
				if(cursoLocal.getId().equals(curso.getId())) {
					cursoLocal.setIsSelected(curso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCurso(List<Curso> cursosAux) throws Exception {
		//this.cursosAux=cursosAux;
		
		for(Curso cursoAux:cursosAux) {
			if(cursoAux.getIsChanged()) {
				cursoAux.setIsChanged(false);
			}		
			
			if(cursoAux.getIsNew()) {
				cursoAux.setIsNew(false);
			}	
			
			if(cursoAux.getIsDeleted()) {
				cursoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCurso(Curso cursoAux) throws Exception {
		//this.cursoAux=cursoAux;
		
			if(cursoAux.getIsChanged()) {
				cursoAux.setIsChanged(false);
			}		
			
			if(cursoAux.getIsNew()) {
				cursoAux.setIsNew(false);
			}	
			
			if(cursoAux.getIsDeleted()) {
				cursoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Curso cursoAsignar,Curso curso) throws Exception {
		cursoAsignar.setId(curso.getId());	
		cursoAsignar.setVersionRow(curso.getVersionRow());	
		cursoAsignar.setid_empresa(curso.getid_empresa());
		cursoAsignar.setempresa_descripcion(curso.getempresa_descripcion());	
		cursoAsignar.setid_empleado(curso.getid_empleado());
		cursoAsignar.setempleado_descripcion(curso.getempleado_descripcion());	
		cursoAsignar.setid_tipo_curso(curso.getid_tipo_curso());
		cursoAsignar.settipocurso_descripcion(curso.gettipocurso_descripcion());	
		cursoAsignar.setid_tipo_institucion(curso.getid_tipo_institucion());
		cursoAsignar.settipoinstitucion_descripcion(curso.gettipoinstitucion_descripcion());	
		cursoAsignar.setnombre(curso.getnombre());	
		cursoAsignar.setcodigo_inscripcion(curso.getcodigo_inscripcion());	
		cursoAsignar.setfecha_inicio(curso.getfecha_inicio());	
		cursoAsignar.setfecha_fin(curso.getfecha_fin());	
		cursoAsignar.setnumero_horas(curso.getnumero_horas());	
		cursoAsignar.setes_aprobado(curso.getes_aprobado());	
		cursoAsignar.setes_auspicio_empresa(curso.getes_auspicio_empresa());	
		cursoAsignar.setdescripcion(curso.getdescripcion());	
	}
	
	public static void inicializarCurso(Curso curso) throws Exception {
		try {
				curso.setId(0L);	
					
				curso.setid_empresa(-1L);	
				curso.setid_empleado(-1L);	
				curso.setid_tipo_curso(-1L);	
				curso.setid_tipo_institucion(-1L);	
				curso.setnombre("");	
				curso.setcodigo_inscripcion("");	
				curso.setfecha_inicio(new Date());	
				curso.setfecha_fin(new Date());	
				curso.setnumero_horas(0);	
				curso.setes_aprobado(false);	
				curso.setes_auspicio_empresa(false);	
				curso.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCurso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_IDTIPOCURSO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_IDTIPOINSTITUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_CODIGOINSCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_NUMEROHORAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_ESAPROBADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_ESAUSPICIOEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CursoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCurso(String sTipo,Row row,Workbook workbook,Curso curso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.gettipocurso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.gettipoinstitucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getcodigo_inscripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getnumero_horas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(curso.getes_aprobado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(curso.getes_auspicio_empresa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(curso.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCurso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCurso() {
		return this.sFinalQueryCurso;
	}
	
	public void setsFinalQueryCurso(String sFinalQueryCurso) {
		this.sFinalQueryCurso= sFinalQueryCurso;
	}
	
	public Border resaltarSeleccionarCurso=null;
	
	public Border setResaltarSeleccionarCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCurso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCurso() {
		return this.resaltarSeleccionarCurso;
	}
	
	public void setResaltarSeleccionarCurso(Border borderResaltarSeleccionarCurso) {
		this.resaltarSeleccionarCurso= borderResaltarSeleccionarCurso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCurso=null;
	public Boolean mostraridCurso=true;
	public Boolean activaridCurso=true;

	public Border resaltarid_empresaCurso=null;
	public Boolean mostrarid_empresaCurso=true;
	public Boolean activarid_empresaCurso=true;
	public Boolean cargarid_empresaCurso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCurso=false;//ConEventDepend=true

	public Border resaltarid_empleadoCurso=null;
	public Boolean mostrarid_empleadoCurso=true;
	public Boolean activarid_empleadoCurso=true;
	public Boolean cargarid_empleadoCurso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCurso=false;//ConEventDepend=true

	public Border resaltarid_tipo_cursoCurso=null;
	public Boolean mostrarid_tipo_cursoCurso=true;
	public Boolean activarid_tipo_cursoCurso=true;
	public Boolean cargarid_tipo_cursoCurso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cursoCurso=false;//ConEventDepend=true

	public Border resaltarid_tipo_institucionCurso=null;
	public Boolean mostrarid_tipo_institucionCurso=true;
	public Boolean activarid_tipo_institucionCurso=true;
	public Boolean cargarid_tipo_institucionCurso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_institucionCurso=false;//ConEventDepend=true

	public Border resaltarnombreCurso=null;
	public Boolean mostrarnombreCurso=true;
	public Boolean activarnombreCurso=true;

	public Border resaltarcodigo_inscripcionCurso=null;
	public Boolean mostrarcodigo_inscripcionCurso=true;
	public Boolean activarcodigo_inscripcionCurso=true;

	public Border resaltarfecha_inicioCurso=null;
	public Boolean mostrarfecha_inicioCurso=true;
	public Boolean activarfecha_inicioCurso=false;

	public Border resaltarfecha_finCurso=null;
	public Boolean mostrarfecha_finCurso=true;
	public Boolean activarfecha_finCurso=false;

	public Border resaltarnumero_horasCurso=null;
	public Boolean mostrarnumero_horasCurso=true;
	public Boolean activarnumero_horasCurso=true;

	public Border resaltares_aprobadoCurso=null;
	public Boolean mostrares_aprobadoCurso=true;
	public Boolean activares_aprobadoCurso=true;

	public Border resaltares_auspicio_empresaCurso=null;
	public Boolean mostrares_auspicio_empresaCurso=true;
	public Boolean activares_auspicio_empresaCurso=true;

	public Border resaltardescripcionCurso=null;
	public Boolean mostrardescripcionCurso=true;
	public Boolean activardescripcionCurso=true;

	
	

	public Border setResaltaridCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltaridCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCurso() {
		return this.resaltaridCurso;
	}

	public void setResaltaridCurso(Border borderResaltar) {
		this.resaltaridCurso= borderResaltar;
	}

	public Boolean getMostraridCurso() {
		return this.mostraridCurso;
	}

	public void setMostraridCurso(Boolean mostraridCurso) {
		this.mostraridCurso= mostraridCurso;
	}

	public Boolean getActivaridCurso() {
		return this.activaridCurso;
	}

	public void setActivaridCurso(Boolean activaridCurso) {
		this.activaridCurso= activaridCurso;
	}

	public Border setResaltarid_empresaCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarid_empresaCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCurso() {
		return this.resaltarid_empresaCurso;
	}

	public void setResaltarid_empresaCurso(Border borderResaltar) {
		this.resaltarid_empresaCurso= borderResaltar;
	}

	public Boolean getMostrarid_empresaCurso() {
		return this.mostrarid_empresaCurso;
	}

	public void setMostrarid_empresaCurso(Boolean mostrarid_empresaCurso) {
		this.mostrarid_empresaCurso= mostrarid_empresaCurso;
	}

	public Boolean getActivarid_empresaCurso() {
		return this.activarid_empresaCurso;
	}

	public void setActivarid_empresaCurso(Boolean activarid_empresaCurso) {
		this.activarid_empresaCurso= activarid_empresaCurso;
	}

	public Boolean getCargarid_empresaCurso() {
		return this.cargarid_empresaCurso;
	}

	public void setCargarid_empresaCurso(Boolean cargarid_empresaCurso) {
		this.cargarid_empresaCurso= cargarid_empresaCurso;
	}

	public Border setResaltarid_empleadoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCurso() {
		return this.resaltarid_empleadoCurso;
	}

	public void setResaltarid_empleadoCurso(Border borderResaltar) {
		this.resaltarid_empleadoCurso= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCurso() {
		return this.mostrarid_empleadoCurso;
	}

	public void setMostrarid_empleadoCurso(Boolean mostrarid_empleadoCurso) {
		this.mostrarid_empleadoCurso= mostrarid_empleadoCurso;
	}

	public Boolean getActivarid_empleadoCurso() {
		return this.activarid_empleadoCurso;
	}

	public void setActivarid_empleadoCurso(Boolean activarid_empleadoCurso) {
		this.activarid_empleadoCurso= activarid_empleadoCurso;
	}

	public Boolean getCargarid_empleadoCurso() {
		return this.cargarid_empleadoCurso;
	}

	public void setCargarid_empleadoCurso(Boolean cargarid_empleadoCurso) {
		this.cargarid_empleadoCurso= cargarid_empleadoCurso;
	}

	public Border setResaltarid_tipo_cursoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cursoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cursoCurso() {
		return this.resaltarid_tipo_cursoCurso;
	}

	public void setResaltarid_tipo_cursoCurso(Border borderResaltar) {
		this.resaltarid_tipo_cursoCurso= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cursoCurso() {
		return this.mostrarid_tipo_cursoCurso;
	}

	public void setMostrarid_tipo_cursoCurso(Boolean mostrarid_tipo_cursoCurso) {
		this.mostrarid_tipo_cursoCurso= mostrarid_tipo_cursoCurso;
	}

	public Boolean getActivarid_tipo_cursoCurso() {
		return this.activarid_tipo_cursoCurso;
	}

	public void setActivarid_tipo_cursoCurso(Boolean activarid_tipo_cursoCurso) {
		this.activarid_tipo_cursoCurso= activarid_tipo_cursoCurso;
	}

	public Boolean getCargarid_tipo_cursoCurso() {
		return this.cargarid_tipo_cursoCurso;
	}

	public void setCargarid_tipo_cursoCurso(Boolean cargarid_tipo_cursoCurso) {
		this.cargarid_tipo_cursoCurso= cargarid_tipo_cursoCurso;
	}

	public Border setResaltarid_tipo_institucionCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarid_tipo_institucionCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_institucionCurso() {
		return this.resaltarid_tipo_institucionCurso;
	}

	public void setResaltarid_tipo_institucionCurso(Border borderResaltar) {
		this.resaltarid_tipo_institucionCurso= borderResaltar;
	}

	public Boolean getMostrarid_tipo_institucionCurso() {
		return this.mostrarid_tipo_institucionCurso;
	}

	public void setMostrarid_tipo_institucionCurso(Boolean mostrarid_tipo_institucionCurso) {
		this.mostrarid_tipo_institucionCurso= mostrarid_tipo_institucionCurso;
	}

	public Boolean getActivarid_tipo_institucionCurso() {
		return this.activarid_tipo_institucionCurso;
	}

	public void setActivarid_tipo_institucionCurso(Boolean activarid_tipo_institucionCurso) {
		this.activarid_tipo_institucionCurso= activarid_tipo_institucionCurso;
	}

	public Boolean getCargarid_tipo_institucionCurso() {
		return this.cargarid_tipo_institucionCurso;
	}

	public void setCargarid_tipo_institucionCurso(Boolean cargarid_tipo_institucionCurso) {
		this.cargarid_tipo_institucionCurso= cargarid_tipo_institucionCurso;
	}

	public Border setResaltarnombreCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarnombreCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCurso() {
		return this.resaltarnombreCurso;
	}

	public void setResaltarnombreCurso(Border borderResaltar) {
		this.resaltarnombreCurso= borderResaltar;
	}

	public Boolean getMostrarnombreCurso() {
		return this.mostrarnombreCurso;
	}

	public void setMostrarnombreCurso(Boolean mostrarnombreCurso) {
		this.mostrarnombreCurso= mostrarnombreCurso;
	}

	public Boolean getActivarnombreCurso() {
		return this.activarnombreCurso;
	}

	public void setActivarnombreCurso(Boolean activarnombreCurso) {
		this.activarnombreCurso= activarnombreCurso;
	}

	public Border setResaltarcodigo_inscripcionCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarcodigo_inscripcionCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_inscripcionCurso() {
		return this.resaltarcodigo_inscripcionCurso;
	}

	public void setResaltarcodigo_inscripcionCurso(Border borderResaltar) {
		this.resaltarcodigo_inscripcionCurso= borderResaltar;
	}

	public Boolean getMostrarcodigo_inscripcionCurso() {
		return this.mostrarcodigo_inscripcionCurso;
	}

	public void setMostrarcodigo_inscripcionCurso(Boolean mostrarcodigo_inscripcionCurso) {
		this.mostrarcodigo_inscripcionCurso= mostrarcodigo_inscripcionCurso;
	}

	public Boolean getActivarcodigo_inscripcionCurso() {
		return this.activarcodigo_inscripcionCurso;
	}

	public void setActivarcodigo_inscripcionCurso(Boolean activarcodigo_inscripcionCurso) {
		this.activarcodigo_inscripcionCurso= activarcodigo_inscripcionCurso;
	}

	public Border setResaltarfecha_inicioCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioCurso() {
		return this.resaltarfecha_inicioCurso;
	}

	public void setResaltarfecha_inicioCurso(Border borderResaltar) {
		this.resaltarfecha_inicioCurso= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioCurso() {
		return this.mostrarfecha_inicioCurso;
	}

	public void setMostrarfecha_inicioCurso(Boolean mostrarfecha_inicioCurso) {
		this.mostrarfecha_inicioCurso= mostrarfecha_inicioCurso;
	}

	public Boolean getActivarfecha_inicioCurso() {
		return this.activarfecha_inicioCurso;
	}

	public void setActivarfecha_inicioCurso(Boolean activarfecha_inicioCurso) {
		this.activarfecha_inicioCurso= activarfecha_inicioCurso;
	}

	public Border setResaltarfecha_finCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarfecha_finCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finCurso() {
		return this.resaltarfecha_finCurso;
	}

	public void setResaltarfecha_finCurso(Border borderResaltar) {
		this.resaltarfecha_finCurso= borderResaltar;
	}

	public Boolean getMostrarfecha_finCurso() {
		return this.mostrarfecha_finCurso;
	}

	public void setMostrarfecha_finCurso(Boolean mostrarfecha_finCurso) {
		this.mostrarfecha_finCurso= mostrarfecha_finCurso;
	}

	public Boolean getActivarfecha_finCurso() {
		return this.activarfecha_finCurso;
	}

	public void setActivarfecha_finCurso(Boolean activarfecha_finCurso) {
		this.activarfecha_finCurso= activarfecha_finCurso;
	}

	public Border setResaltarnumero_horasCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltarnumero_horasCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_horasCurso() {
		return this.resaltarnumero_horasCurso;
	}

	public void setResaltarnumero_horasCurso(Border borderResaltar) {
		this.resaltarnumero_horasCurso= borderResaltar;
	}

	public Boolean getMostrarnumero_horasCurso() {
		return this.mostrarnumero_horasCurso;
	}

	public void setMostrarnumero_horasCurso(Boolean mostrarnumero_horasCurso) {
		this.mostrarnumero_horasCurso= mostrarnumero_horasCurso;
	}

	public Boolean getActivarnumero_horasCurso() {
		return this.activarnumero_horasCurso;
	}

	public void setActivarnumero_horasCurso(Boolean activarnumero_horasCurso) {
		this.activarnumero_horasCurso= activarnumero_horasCurso;
	}

	public Border setResaltares_aprobadoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltares_aprobadoCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_aprobadoCurso() {
		return this.resaltares_aprobadoCurso;
	}

	public void setResaltares_aprobadoCurso(Border borderResaltar) {
		this.resaltares_aprobadoCurso= borderResaltar;
	}

	public Boolean getMostrares_aprobadoCurso() {
		return this.mostrares_aprobadoCurso;
	}

	public void setMostrares_aprobadoCurso(Boolean mostrares_aprobadoCurso) {
		this.mostrares_aprobadoCurso= mostrares_aprobadoCurso;
	}

	public Boolean getActivares_aprobadoCurso() {
		return this.activares_aprobadoCurso;
	}

	public void setActivares_aprobadoCurso(Boolean activares_aprobadoCurso) {
		this.activares_aprobadoCurso= activares_aprobadoCurso;
	}

	public Border setResaltares_auspicio_empresaCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltares_auspicio_empresaCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_auspicio_empresaCurso() {
		return this.resaltares_auspicio_empresaCurso;
	}

	public void setResaltares_auspicio_empresaCurso(Border borderResaltar) {
		this.resaltares_auspicio_empresaCurso= borderResaltar;
	}

	public Boolean getMostrares_auspicio_empresaCurso() {
		return this.mostrares_auspicio_empresaCurso;
	}

	public void setMostrares_auspicio_empresaCurso(Boolean mostrares_auspicio_empresaCurso) {
		this.mostrares_auspicio_empresaCurso= mostrares_auspicio_empresaCurso;
	}

	public Boolean getActivares_auspicio_empresaCurso() {
		return this.activares_auspicio_empresaCurso;
	}

	public void setActivares_auspicio_empresaCurso(Boolean activares_auspicio_empresaCurso) {
		this.activares_auspicio_empresaCurso= activares_auspicio_empresaCurso;
	}

	public Border setResaltardescripcionCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltar);
		
		this.resaltardescripcionCurso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCurso() {
		return this.resaltardescripcionCurso;
	}

	public void setResaltardescripcionCurso(Border borderResaltar) {
		this.resaltardescripcionCurso= borderResaltar;
	}

	public Boolean getMostrardescripcionCurso() {
		return this.mostrardescripcionCurso;
	}

	public void setMostrardescripcionCurso(Boolean mostrardescripcionCurso) {
		this.mostrardescripcionCurso= mostrardescripcionCurso;
	}

	public Boolean getActivardescripcionCurso() {
		return this.activardescripcionCurso;
	}

	public void setActivardescripcionCurso(Boolean activardescripcionCurso) {
		this.activardescripcionCurso= activardescripcionCurso;
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
		
		
		this.setMostraridCurso(esInicial);
		this.setMostrarid_empresaCurso(esInicial);
		this.setMostrarid_empleadoCurso(esInicial);
		this.setMostrarid_tipo_cursoCurso(esInicial);
		this.setMostrarid_tipo_institucionCurso(esInicial);
		this.setMostrarnombreCurso(esInicial);
		this.setMostrarcodigo_inscripcionCurso(esInicial);
		this.setMostrarfecha_inicioCurso(esInicial);
		this.setMostrarfecha_finCurso(esInicial);
		this.setMostrarnumero_horasCurso(esInicial);
		this.setMostrares_aprobadoCurso(esInicial);
		this.setMostrares_auspicio_empresaCurso(esInicial);
		this.setMostrardescripcionCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CursoConstantesFunciones.ID)) {
				this.setMostraridCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDTIPOCURSO)) {
				this.setMostrarid_tipo_cursoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDTIPOINSTITUCION)) {
				this.setMostrarid_tipo_institucionCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.CODIGOINSCRIPCION)) {
				this.setMostrarcodigo_inscripcionCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.NUMEROHORAS)) {
				this.setMostrarnumero_horasCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.ESAPROBADO)) {
				this.setMostrares_aprobadoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.ESAUSPICIOEMPRESA)) {
				this.setMostrares_auspicio_empresaCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCurso(esAsigna);
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
		
		
		this.setActivaridCurso(esInicial);
		this.setActivarid_empresaCurso(esInicial);
		this.setActivarid_empleadoCurso(esInicial);
		this.setActivarid_tipo_cursoCurso(esInicial);
		this.setActivarid_tipo_institucionCurso(esInicial);
		this.setActivarnombreCurso(esInicial);
		this.setActivarcodigo_inscripcionCurso(esInicial);
		this.setActivarfecha_inicioCurso(esInicial);
		this.setActivarfecha_finCurso(esInicial);
		this.setActivarnumero_horasCurso(esInicial);
		this.setActivares_aprobadoCurso(esInicial);
		this.setActivares_auspicio_empresaCurso(esInicial);
		this.setActivardescripcionCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CursoConstantesFunciones.ID)) {
				this.setActivaridCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDTIPOCURSO)) {
				this.setActivarid_tipo_cursoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDTIPOINSTITUCION)) {
				this.setActivarid_tipo_institucionCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.CODIGOINSCRIPCION)) {
				this.setActivarcodigo_inscripcionCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.NUMEROHORAS)) {
				this.setActivarnumero_horasCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.ESAPROBADO)) {
				this.setActivares_aprobadoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.ESAUSPICIOEMPRESA)) {
				this.setActivares_auspicio_empresaCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCurso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCurso(esInicial);
		this.setResaltarid_empresaCurso(esInicial);
		this.setResaltarid_empleadoCurso(esInicial);
		this.setResaltarid_tipo_cursoCurso(esInicial);
		this.setResaltarid_tipo_institucionCurso(esInicial);
		this.setResaltarnombreCurso(esInicial);
		this.setResaltarcodigo_inscripcionCurso(esInicial);
		this.setResaltarfecha_inicioCurso(esInicial);
		this.setResaltarfecha_finCurso(esInicial);
		this.setResaltarnumero_horasCurso(esInicial);
		this.setResaltares_aprobadoCurso(esInicial);
		this.setResaltares_auspicio_empresaCurso(esInicial);
		this.setResaltardescripcionCurso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CursoConstantesFunciones.ID)) {
				this.setResaltaridCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDTIPOCURSO)) {
				this.setResaltarid_tipo_cursoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.IDTIPOINSTITUCION)) {
				this.setResaltarid_tipo_institucionCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.CODIGOINSCRIPCION)) {
				this.setResaltarcodigo_inscripcionCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.NUMEROHORAS)) {
				this.setResaltarnumero_horasCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.ESAPROBADO)) {
				this.setResaltares_aprobadoCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.ESAUSPICIOEMPRESA)) {
				this.setResaltares_auspicio_empresaCurso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CursoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCurso(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleCursoCurso=null;

	public Border getResaltarDetalleCursoCurso() {
		return this.resaltarDetalleCursoCurso;
	}

	public void setResaltarDetalleCursoCurso(Border borderResaltarDetalleCurso) {
		if(borderResaltarDetalleCurso!=null) {
			this.resaltarDetalleCursoCurso= borderResaltarDetalleCurso;
		}
	}

	public Border setResaltarDetalleCursoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleCurso=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cursoBeanSwingJInternalFrame.jTtoolBarCurso.setBorder(borderResaltarDetalleCurso);
			
		this.resaltarDetalleCursoCurso= borderResaltarDetalleCurso;

		 return borderResaltarDetalleCurso;
	}



	public Boolean mostrarDetalleCursoCurso=true;

	public Boolean getMostrarDetalleCursoCurso() {
		return this.mostrarDetalleCursoCurso;
	}

	public void setMostrarDetalleCursoCurso(Boolean visibilidadResaltarDetalleCurso) {
		this.mostrarDetalleCursoCurso= visibilidadResaltarDetalleCurso;
	}



	public Boolean activarDetalleCursoCurso=true;

	public Boolean gethabilitarResaltarDetalleCursoCurso() {
		return this.activarDetalleCursoCurso;
	}

	public void setActivarDetalleCursoCurso(Boolean habilitarResaltarDetalleCurso) {
		this.activarDetalleCursoCurso= habilitarResaltarDetalleCurso;
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

		this.setMostrarDetalleCursoCurso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCurso.class)) {
				this.setMostrarDetalleCursoCurso(esAsigna);
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

		this.setActivarDetalleCursoCurso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCurso.class)) {
				this.setActivarDetalleCursoCurso(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleCursoCurso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCurso.class)) {
				this.setResaltarDetalleCursoCurso(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpleadoCurso=true;

	public Boolean getMostrarFK_IdEmpleadoCurso() {
		return this.mostrarFK_IdEmpleadoCurso;
	}

	public void setMostrarFK_IdEmpleadoCurso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoCurso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCurso=true;

	public Boolean getMostrarFK_IdEmpresaCurso() {
		return this.mostrarFK_IdEmpresaCurso;
	}

	public void setMostrarFK_IdEmpresaCurso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCurso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCursoCurso=true;

	public Boolean getMostrarFK_IdTipoCursoCurso() {
		return this.mostrarFK_IdTipoCursoCurso;
	}

	public void setMostrarFK_IdTipoCursoCurso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCursoCurso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoInstitucionCurso=true;

	public Boolean getMostrarFK_IdTipoInstitucionCurso() {
		return this.mostrarFK_IdTipoInstitucionCurso;
	}

	public void setMostrarFK_IdTipoInstitucionCurso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoInstitucionCurso= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoCurso=true;

	public Boolean getActivarFK_IdEmpleadoCurso() {
		return this.activarFK_IdEmpleadoCurso;
	}

	public void setActivarFK_IdEmpleadoCurso(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoCurso= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCurso=true;

	public Boolean getActivarFK_IdEmpresaCurso() {
		return this.activarFK_IdEmpresaCurso;
	}

	public void setActivarFK_IdEmpresaCurso(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCurso= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCursoCurso=true;

	public Boolean getActivarFK_IdTipoCursoCurso() {
		return this.activarFK_IdTipoCursoCurso;
	}

	public void setActivarFK_IdTipoCursoCurso(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCursoCurso= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoInstitucionCurso=true;

	public Boolean getActivarFK_IdTipoInstitucionCurso() {
		return this.activarFK_IdTipoInstitucionCurso;
	}

	public void setActivarFK_IdTipoInstitucionCurso(Boolean habilitarResaltar) {
		this.activarFK_IdTipoInstitucionCurso= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoCurso=null;

	public Border getResaltarFK_IdEmpleadoCurso() {
		return this.resaltarFK_IdEmpleadoCurso;
	}

	public void setResaltarFK_IdEmpleadoCurso(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoCurso= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoCurso= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCurso=null;

	public Border getResaltarFK_IdEmpresaCurso() {
		return this.resaltarFK_IdEmpresaCurso;
	}

	public void setResaltarFK_IdEmpresaCurso(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCurso= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCurso= borderResaltar;
	}

	public Border resaltarFK_IdTipoCursoCurso=null;

	public Border getResaltarFK_IdTipoCursoCurso() {
		return this.resaltarFK_IdTipoCursoCurso;
	}

	public void setResaltarFK_IdTipoCursoCurso(Border borderResaltar) {
		this.resaltarFK_IdTipoCursoCurso= borderResaltar;
	}

	public void setResaltarFK_IdTipoCursoCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCursoCurso= borderResaltar;
	}

	public Border resaltarFK_IdTipoInstitucionCurso=null;

	public Border getResaltarFK_IdTipoInstitucionCurso() {
		return this.resaltarFK_IdTipoInstitucionCurso;
	}

	public void setResaltarFK_IdTipoInstitucionCurso(Border borderResaltar) {
		this.resaltarFK_IdTipoInstitucionCurso= borderResaltar;
	}

	public void setResaltarFK_IdTipoInstitucionCurso(ParametroGeneralUsuario parametroGeneralUsuario/*CursoBeanSwingJInternalFrame cursoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoInstitucionCurso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}