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


import com.bydan.erp.nomina.util.CargaFamiliar_NMConstantesFunciones;
import com.bydan.erp.nomina.util.CargaFamiliar_NMParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargaFamiliar_NMParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CargaFamiliar_NMConstantesFunciones extends CargaFamiliar_NMConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CargaFamiliar_NM";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CargaFamiliar_NM"+CargaFamiliar_NMConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CargaFamiliar_NMHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CargaFamiliar_NMHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CargaFamiliar_NMConstantesFunciones.SCHEMA+"_"+CargaFamiliar_NMConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CargaFamiliar_NMHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CargaFamiliar_NMConstantesFunciones.SCHEMA+"_"+CargaFamiliar_NMConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CargaFamiliar_NMConstantesFunciones.SCHEMA+"_"+CargaFamiliar_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CargaFamiliar_NMHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CargaFamiliar_NMConstantesFunciones.SCHEMA+"_"+CargaFamiliar_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliar_NMConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargaFamiliar_NMHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliar_NMConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliar_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargaFamiliar_NMHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliar_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CargaFamiliar_NMConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CargaFamiliar_NMConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CargaFamiliar_NMConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CargaFamiliar_NMConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Carga Familiar_ N Mes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Carga Familiar_ N M";
	public static final String SCLASSWEBTITULO_LOWER="Carga Familiar_ N M";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CargaFamiliar_NM";
	public static final String OBJECTNAME="cargafamiliar_nm";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="carga_familiar__n_m";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cargafamiliar_nm from "+CargaFamiliar_NMConstantesFunciones.SPERSISTENCENAME+" cargafamiliar_nm";
	public static String QUERYSELECTNATIVE="select "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".version_row,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_empresa,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_empleado,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_tipo_carga_fami,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_tipo_genero,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_estado_civil,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".cedula,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".apellido,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".nombre,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".direccion,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".fecha_nacimiento,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".valor_cupo from "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME;//+" as "+CargaFamiliar_NMConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CargaFamiliar_NMConstantesFuncionesAdditional cargafamiliar_nmConstantesFuncionesAdditional=null;
	
	public CargaFamiliar_NMConstantesFuncionesAdditional getCargaFamiliar_NMConstantesFuncionesAdditional() {
		return this.cargafamiliar_nmConstantesFuncionesAdditional;
	}
	
	public void setCargaFamiliar_NMConstantesFuncionesAdditional(CargaFamiliar_NMConstantesFuncionesAdditional cargafamiliar_nmConstantesFuncionesAdditional) {
		try {
			this.cargafamiliar_nmConstantesFuncionesAdditional=cargafamiliar_nmConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPOCARGAFAMI= "id_tipo_carga_fami";
    public static final String IDTIPOGENERO= "id_tipo_genero";
    public static final String IDESTADOCIVIL= "id_estado_civil";
    public static final String CEDULA= "cedula";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRE= "nombre";
    public static final String DIRECCION= "direccion";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String VALORCUPO= "valor_cupo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPOCARGAFAMI= "Tipo Carga Fami";
		public static final String LABEL_IDTIPOCARGAFAMI_LOWER= "Tipo Carga Fami";
    	public static final String LABEL_IDTIPOGENERO= "Tipo Genero";
		public static final String LABEL_IDTIPOGENERO_LOWER= "Tipo Genero";
    	public static final String LABEL_IDESTADOCIVIL= "Estado Civil";
		public static final String LABEL_IDESTADOCIVIL_LOWER= "Estado Civil";
    	public static final String LABEL_CEDULA= "Cedula";
		public static final String LABEL_CEDULA_LOWER= "Cedula";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_VALORCUPO= "Valor Cupo";
		public static final String LABEL_VALORCUPO_LOWER= "Valor Cupo";
	
		
		
		
		
		
		
		
	public static final String SREGEXCEDULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCEDULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCargaFamiliar_NMLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.IDEMPRESA)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOCARGAFAMI;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOGENERO;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_IDESTADOCIVIL;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.CEDULA)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_CEDULA;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.APELLIDO)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.NOMBRE)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.DIRECCION)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(CargaFamiliar_NMConstantesFunciones.VALORCUPO)) {sLabelColumna=CargaFamiliar_NMConstantesFunciones.LABEL_VALORCUPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCargaFamiliar_NMDescripcion(CargaFamiliar_NM cargafamiliar_nm) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cargafamiliar_nm !=null/* && cargafamiliar_nm.getId()!=0*/) {
			sDescripcion=cargafamiliar_nm.getnombre();//cargafamiliar_nmcargafamiliar_nm.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCargaFamiliar_NMDescripcionDetallado(CargaFamiliar_NM cargafamiliar_nm) {
		String sDescripcion="";
			
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.ID+"=";
		sDescripcion+=cargafamiliar_nm.getId().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cargafamiliar_nm.getVersionRow().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cargafamiliar_nm.getid_empresa().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=cargafamiliar_nm.getid_empleado().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI+"=";
		sDescripcion+=cargafamiliar_nm.getid_tipo_carga_fami().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO+"=";
		sDescripcion+=cargafamiliar_nm.getid_tipo_genero().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL+"=";
		sDescripcion+=cargafamiliar_nm.getid_estado_civil().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.CEDULA+"=";
		sDescripcion+=cargafamiliar_nm.getcedula()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cargafamiliar_nm.getapellido()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cargafamiliar_nm.getnombre()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.DIRECCION+"=";
		sDescripcion+=cargafamiliar_nm.getdireccion()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=cargafamiliar_nm.getfecha_nacimiento().toString()+",";
		sDescripcion+=CargaFamiliar_NMConstantesFunciones.VALORCUPO+"=";
		sDescripcion+=cargafamiliar_nm.getvalor_cupo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCargaFamiliar_NMDescripcion(CargaFamiliar_NM cargafamiliar_nm,String sValor) throws Exception {			
		if(cargafamiliar_nm !=null) {
			cargafamiliar_nm.setnombre(sValor);;//cargafamiliar_nmcargafamiliar_nm.getnombre().trim();
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

	public static String getTipoCargaFamiDescripcion(TipoCargaFami tipocargafami) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocargafami!=null/*&&tipocargafami.getId()>0*/) {
			sDescripcion=TipoCargaFamiConstantesFunciones.getTipoCargaFamiDescripcion(tipocargafami);
		}

		return sDescripcion;
	}

	public static String getTipoGeneroDescripcion(TipoGenero tipogenero) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogenero!=null/*&&tipogenero.getId()>0*/) {
			sDescripcion=TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(tipogenero);
		}

		return sDescripcion;
	}

	public static String getEstadoCivilDescripcion(EstadoCivil estadocivil) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocivil!=null/*&&estadocivil.getId()>0*/) {
			sDescripcion=EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(estadocivil);
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
		} else if(sNombreIndice.equals("FK_IdEstadoCivil")) {
			sNombreIndice="Tipo=  Por Estado Civil";
		} else if(sNombreIndice.equals("FK_IdTipoCargaFami")) {
			sNombreIndice="Tipo=  Por Tipo Carga Fami";
		} else if(sNombreIndice.equals("FK_IdTipoGenero")) {
			sNombreIndice="Tipo=  Por Tipo Genero";
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

	public static String getDetalleIndiceFK_IdEstadoCivil(Long id_estado_civil) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_civil!=null) {sDetalleIndice+=" Codigo Unico De Estado Civil="+id_estado_civil.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCargaFami(Long id_tipo_carga_fami) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_carga_fami!=null) {sDetalleIndice+=" Codigo Unico De Tipo Carga Fami="+id_tipo_carga_fami.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGenero(Long id_tipo_genero) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_genero!=null) {sDetalleIndice+=" Codigo Unico De Tipo Genero="+id_tipo_genero.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nm,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cargafamiliar_nm.setcedula(cargafamiliar_nm.getcedula().trim());
		cargafamiliar_nm.setapellido(cargafamiliar_nm.getapellido().trim());
		cargafamiliar_nm.setnombre(cargafamiliar_nm.getnombre().trim());
		cargafamiliar_nm.setdireccion(cargafamiliar_nm.getdireccion().trim());
	}
	
	public static void quitarEspaciosCargaFamiliar_NMs(List<CargaFamiliar_NM> cargafamiliar_nms,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CargaFamiliar_NM cargafamiliar_nm: cargafamiliar_nms) {
			cargafamiliar_nm.setcedula(cargafamiliar_nm.getcedula().trim());
			cargafamiliar_nm.setapellido(cargafamiliar_nm.getapellido().trim());
			cargafamiliar_nm.setnombre(cargafamiliar_nm.getnombre().trim());
			cargafamiliar_nm.setdireccion(cargafamiliar_nm.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nm,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cargafamiliar_nm.getConCambioAuxiliar()) {
			cargafamiliar_nm.setIsDeleted(cargafamiliar_nm.getIsDeletedAuxiliar());	
			cargafamiliar_nm.setIsNew(cargafamiliar_nm.getIsNewAuxiliar());	
			cargafamiliar_nm.setIsChanged(cargafamiliar_nm.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cargafamiliar_nm.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cargafamiliar_nm.setIsDeletedAuxiliar(false);	
			cargafamiliar_nm.setIsNewAuxiliar(false);	
			cargafamiliar_nm.setIsChangedAuxiliar(false);
			
			cargafamiliar_nm.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargaFamiliar_NMs(List<CargaFamiliar_NM> cargafamiliar_nms,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CargaFamiliar_NM cargafamiliar_nm : cargafamiliar_nms) {
			if(conAsignarBase && cargafamiliar_nm.getConCambioAuxiliar()) {
				cargafamiliar_nm.setIsDeleted(cargafamiliar_nm.getIsDeletedAuxiliar());	
				cargafamiliar_nm.setIsNew(cargafamiliar_nm.getIsNewAuxiliar());	
				cargafamiliar_nm.setIsChanged(cargafamiliar_nm.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cargafamiliar_nm.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cargafamiliar_nm.setIsDeletedAuxiliar(false);	
				cargafamiliar_nm.setIsNewAuxiliar(false);	
				cargafamiliar_nm.setIsChangedAuxiliar(false);
				
				cargafamiliar_nm.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nm,Boolean conEnteros) throws Exception  {
		cargafamiliar_nm.setvalor_cupo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCargaFamiliar_NMs(List<CargaFamiliar_NM> cargafamiliar_nms,Boolean conEnteros) throws Exception  {
		
		for(CargaFamiliar_NM cargafamiliar_nm: cargafamiliar_nms) {
			cargafamiliar_nm.setvalor_cupo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCargaFamiliar_NM(List<CargaFamiliar_NM> cargafamiliar_nms,CargaFamiliar_NM cargafamiliar_nmAux) throws Exception  {
		CargaFamiliar_NMConstantesFunciones.InicializarValoresCargaFamiliar_NM(cargafamiliar_nmAux,true);
		
		for(CargaFamiliar_NM cargafamiliar_nm: cargafamiliar_nms) {
			if(cargafamiliar_nm.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cargafamiliar_nmAux.setvalor_cupo(cargafamiliar_nmAux.getvalor_cupo()+cargafamiliar_nm.getvalor_cupo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCargaFamiliar_NM(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CargaFamiliar_NMConstantesFunciones.getArrayColumnasGlobalesCargaFamiliar_NM(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCargaFamiliar_NM(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CargaFamiliar_NMConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CargaFamiliar_NMConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCargaFamiliar_NM(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CargaFamiliar_NM> cargafamiliar_nms,CargaFamiliar_NM cargafamiliar_nm,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CargaFamiliar_NM cargafamiliar_nmAux: cargafamiliar_nms) {
			if(cargafamiliar_nmAux!=null && cargafamiliar_nm!=null) {
				if((cargafamiliar_nmAux.getId()==null && cargafamiliar_nm.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cargafamiliar_nmAux.getId()!=null && cargafamiliar_nm.getId()!=null){
					if(cargafamiliar_nmAux.getId().equals(cargafamiliar_nm.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCargaFamiliar_NM(List<CargaFamiliar_NM> cargafamiliar_nms) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_cupoTotal=0.0;
	
		for(CargaFamiliar_NM cargafamiliar_nm: cargafamiliar_nms) {			
			if(cargafamiliar_nm.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_cupoTotal+=cargafamiliar_nm.getvalor_cupo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CargaFamiliar_NMConstantesFunciones.VALORCUPO);
		datoGeneral.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_VALORCUPO);
		datoGeneral.setdValorDouble(valor_cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCargaFamiliar_NM() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_ID, CargaFamiliar_NMConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_VERSIONROW, CargaFamiliar_NMConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPRESA, CargaFamiliar_NMConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPLEADO, CargaFamiliar_NMConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOCARGAFAMI, CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOGENERO, CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_IDESTADOCIVIL, CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_CEDULA, CargaFamiliar_NMConstantesFunciones.CEDULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_APELLIDO, CargaFamiliar_NMConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_NOMBRE, CargaFamiliar_NMConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_DIRECCION, CargaFamiliar_NMConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_FECHANACIMIENTO, CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliar_NMConstantesFunciones.LABEL_VALORCUPO, CargaFamiliar_NMConstantesFunciones.VALORCUPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCargaFamiliar_NM() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.CEDULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliar_NMConstantesFunciones.VALORCUPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargaFamiliar_NM() throws Exception  {
		return CargaFamiliar_NMConstantesFunciones.getTiposSeleccionarCargaFamiliar_NM(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargaFamiliar_NM(Boolean conFk) throws Exception  {
		return CargaFamiliar_NMConstantesFunciones.getTiposSeleccionarCargaFamiliar_NM(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargaFamiliar_NM(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOCARGAFAMI);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOCARGAFAMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOGENERO);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOGENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_IDESTADOCIVIL);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_IDESTADOCIVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_CEDULA);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_CEDULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliar_NMConstantesFunciones.LABEL_VALORCUPO);
			reporte.setsDescripcion(CargaFamiliar_NMConstantesFunciones.LABEL_VALORCUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCargaFamiliar_NM(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nmAux) throws Exception {
		
			cargafamiliar_nmAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargafamiliar_nmAux.getEmpresa()));
			cargafamiliar_nmAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(cargafamiliar_nmAux.getEmpleado()));
			cargafamiliar_nmAux.settipocargafami_descripcion(TipoCargaFamiConstantesFunciones.getTipoCargaFamiDescripcion(cargafamiliar_nmAux.getTipoCargaFami()));
			cargafamiliar_nmAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(cargafamiliar_nmAux.getTipoGenero()));
			cargafamiliar_nmAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(cargafamiliar_nmAux.getEstadoCivil()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCargaFamiliar_NM(List<CargaFamiliar_NM> cargafamiliar_nmsTemp) throws Exception {
		for(CargaFamiliar_NM cargafamiliar_nmAux:cargafamiliar_nmsTemp) {
			
			cargafamiliar_nmAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargafamiliar_nmAux.getEmpresa()));
			cargafamiliar_nmAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(cargafamiliar_nmAux.getEmpleado()));
			cargafamiliar_nmAux.settipocargafami_descripcion(TipoCargaFamiConstantesFunciones.getTipoCargaFamiDescripcion(cargafamiliar_nmAux.getTipoCargaFami()));
			cargafamiliar_nmAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(cargafamiliar_nmAux.getTipoGenero()));
			cargafamiliar_nmAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(cargafamiliar_nmAux.getEstadoCivil()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCargaFamiliar_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoCargaFami.class));
				classes.add(new Classe(TipoGenero.class));
				classes.add(new Classe(EstadoCivil.class));
				
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
					if(clas.clas.equals(TipoCargaFami.class)) {
						classes.add(new Classe(TipoCargaFami.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGenero.class)) {
						classes.add(new Classe(TipoGenero.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCivil.class)) {
						classes.add(new Classe(EstadoCivil.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCargaFamiliar_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoCargaFami.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCargaFami.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
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

					if(TipoCargaFami.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCargaFami.class)); continue;
					}

					if(TipoGenero.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGenero.class)); continue;
					}

					if(EstadoCivil.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCivil.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargaFamiliar_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargaFamiliar_NMConstantesFunciones.getClassesRelationshipsOfCargaFamiliar_NM(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargaFamiliar_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargaFamiliar_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargaFamiliar_NMConstantesFunciones.getClassesRelationshipsFromStringsOfCargaFamiliar_NM(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargaFamiliar_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CargaFamiliar_NM cargafamiliar_nm,List<CargaFamiliar_NM> cargafamiliar_nms,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CargaFamiliar_NM cargafamiliar_nmEncontrado=null;
			
			for(CargaFamiliar_NM cargafamiliar_nmLocal:cargafamiliar_nms) {
				if(cargafamiliar_nmLocal.getId().equals(cargafamiliar_nm.getId())) {
					cargafamiliar_nmEncontrado=cargafamiliar_nmLocal;
					
					cargafamiliar_nmLocal.setIsChanged(cargafamiliar_nm.getIsChanged());
					cargafamiliar_nmLocal.setIsNew(cargafamiliar_nm.getIsNew());
					cargafamiliar_nmLocal.setIsDeleted(cargafamiliar_nm.getIsDeleted());
					
					cargafamiliar_nmLocal.setGeneralEntityOriginal(cargafamiliar_nm.getGeneralEntityOriginal());
					
					cargafamiliar_nmLocal.setId(cargafamiliar_nm.getId());	
					cargafamiliar_nmLocal.setVersionRow(cargafamiliar_nm.getVersionRow());	
					cargafamiliar_nmLocal.setid_empresa(cargafamiliar_nm.getid_empresa());	
					cargafamiliar_nmLocal.setid_empleado(cargafamiliar_nm.getid_empleado());	
					cargafamiliar_nmLocal.setid_tipo_carga_fami(cargafamiliar_nm.getid_tipo_carga_fami());	
					cargafamiliar_nmLocal.setid_tipo_genero(cargafamiliar_nm.getid_tipo_genero());	
					cargafamiliar_nmLocal.setid_estado_civil(cargafamiliar_nm.getid_estado_civil());	
					cargafamiliar_nmLocal.setcedula(cargafamiliar_nm.getcedula());	
					cargafamiliar_nmLocal.setapellido(cargafamiliar_nm.getapellido());	
					cargafamiliar_nmLocal.setnombre(cargafamiliar_nm.getnombre());	
					cargafamiliar_nmLocal.setdireccion(cargafamiliar_nm.getdireccion());	
					cargafamiliar_nmLocal.setfecha_nacimiento(cargafamiliar_nm.getfecha_nacimiento());	
					cargafamiliar_nmLocal.setvalor_cupo(cargafamiliar_nm.getvalor_cupo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cargafamiliar_nm.getIsDeleted()) {
				if(!existe) {
					cargafamiliar_nms.add(cargafamiliar_nm);
				}
			} else {
				if(cargafamiliar_nmEncontrado!=null && permiteQuitar)  {
					cargafamiliar_nms.remove(cargafamiliar_nmEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CargaFamiliar_NM cargafamiliar_nm,List<CargaFamiliar_NM> cargafamiliar_nms) throws Exception {
		try	{			
			for(CargaFamiliar_NM cargafamiliar_nmLocal:cargafamiliar_nms) {
				if(cargafamiliar_nmLocal.getId().equals(cargafamiliar_nm.getId())) {
					cargafamiliar_nmLocal.setIsSelected(cargafamiliar_nm.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCargaFamiliar_NM(List<CargaFamiliar_NM> cargafamiliar_nmsAux) throws Exception {
		//this.cargafamiliar_nmsAux=cargafamiliar_nmsAux;
		
		for(CargaFamiliar_NM cargafamiliar_nmAux:cargafamiliar_nmsAux) {
			if(cargafamiliar_nmAux.getIsChanged()) {
				cargafamiliar_nmAux.setIsChanged(false);
			}		
			
			if(cargafamiliar_nmAux.getIsNew()) {
				cargafamiliar_nmAux.setIsNew(false);
			}	
			
			if(cargafamiliar_nmAux.getIsDeleted()) {
				cargafamiliar_nmAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nmAux) throws Exception {
		//this.cargafamiliar_nmAux=cargafamiliar_nmAux;
		
			if(cargafamiliar_nmAux.getIsChanged()) {
				cargafamiliar_nmAux.setIsChanged(false);
			}		
			
			if(cargafamiliar_nmAux.getIsNew()) {
				cargafamiliar_nmAux.setIsNew(false);
			}	
			
			if(cargafamiliar_nmAux.getIsDeleted()) {
				cargafamiliar_nmAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CargaFamiliar_NM cargafamiliar_nmAsignar,CargaFamiliar_NM cargafamiliar_nm) throws Exception {
		cargafamiliar_nmAsignar.setId(cargafamiliar_nm.getId());	
		cargafamiliar_nmAsignar.setVersionRow(cargafamiliar_nm.getVersionRow());	
		cargafamiliar_nmAsignar.setid_empresa(cargafamiliar_nm.getid_empresa());
		cargafamiliar_nmAsignar.setempresa_descripcion(cargafamiliar_nm.getempresa_descripcion());	
		cargafamiliar_nmAsignar.setid_empleado(cargafamiliar_nm.getid_empleado());
		cargafamiliar_nmAsignar.setempleado_descripcion(cargafamiliar_nm.getempleado_descripcion());	
		cargafamiliar_nmAsignar.setid_tipo_carga_fami(cargafamiliar_nm.getid_tipo_carga_fami());
		cargafamiliar_nmAsignar.settipocargafami_descripcion(cargafamiliar_nm.gettipocargafami_descripcion());	
		cargafamiliar_nmAsignar.setid_tipo_genero(cargafamiliar_nm.getid_tipo_genero());
		cargafamiliar_nmAsignar.settipogenero_descripcion(cargafamiliar_nm.gettipogenero_descripcion());	
		cargafamiliar_nmAsignar.setid_estado_civil(cargafamiliar_nm.getid_estado_civil());
		cargafamiliar_nmAsignar.setestadocivil_descripcion(cargafamiliar_nm.getestadocivil_descripcion());	
		cargafamiliar_nmAsignar.setcedula(cargafamiliar_nm.getcedula());	
		cargafamiliar_nmAsignar.setapellido(cargafamiliar_nm.getapellido());	
		cargafamiliar_nmAsignar.setnombre(cargafamiliar_nm.getnombre());	
		cargafamiliar_nmAsignar.setdireccion(cargafamiliar_nm.getdireccion());	
		cargafamiliar_nmAsignar.setfecha_nacimiento(cargafamiliar_nm.getfecha_nacimiento());	
		cargafamiliar_nmAsignar.setvalor_cupo(cargafamiliar_nm.getvalor_cupo());	
	}
	
	public static void inicializarCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nm) throws Exception {
		try {
				cargafamiliar_nm.setId(0L);	
					
				cargafamiliar_nm.setid_empresa(-1L);	
				cargafamiliar_nm.setid_empleado(-1L);	
				cargafamiliar_nm.setid_tipo_carga_fami(-1L);	
				cargafamiliar_nm.setid_tipo_genero(-1L);	
				cargafamiliar_nm.setid_estado_civil(-1L);	
				cargafamiliar_nm.setcedula("");	
				cargafamiliar_nm.setapellido("");	
				cargafamiliar_nm.setnombre("");	
				cargafamiliar_nm.setdireccion("");	
				cargafamiliar_nm.setfecha_nacimiento(new Date());	
				cargafamiliar_nm.setvalor_cupo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCargaFamiliar_NM(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOCARGAFAMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_IDTIPOGENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_IDESTADOCIVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_CEDULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliar_NMConstantesFunciones.LABEL_VALORCUPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCargaFamiliar_NM(String sTipo,Row row,Workbook workbook,CargaFamiliar_NM cargafamiliar_nm,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.gettipocargafami_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.gettipogenero_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getestadocivil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getcedula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar_nm.getvalor_cupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCargaFamiliar_NM=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCargaFamiliar_NM() {
		return this.sFinalQueryCargaFamiliar_NM;
	}
	
	public void setsFinalQueryCargaFamiliar_NM(String sFinalQueryCargaFamiliar_NM) {
		this.sFinalQueryCargaFamiliar_NM= sFinalQueryCargaFamiliar_NM;
	}
	
	public Border resaltarSeleccionarCargaFamiliar_NM=null;
	
	public Border setResaltarSeleccionarCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCargaFamiliar_NM= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCargaFamiliar_NM() {
		return this.resaltarSeleccionarCargaFamiliar_NM;
	}
	
	public void setResaltarSeleccionarCargaFamiliar_NM(Border borderResaltarSeleccionarCargaFamiliar_NM) {
		this.resaltarSeleccionarCargaFamiliar_NM= borderResaltarSeleccionarCargaFamiliar_NM;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCargaFamiliar_NM=null;
	public Boolean mostraridCargaFamiliar_NM=true;
	public Boolean activaridCargaFamiliar_NM=true;

	public Border resaltarid_empresaCargaFamiliar_NM=null;
	public Boolean mostrarid_empresaCargaFamiliar_NM=true;
	public Boolean activarid_empresaCargaFamiliar_NM=true;
	public Boolean cargarid_empresaCargaFamiliar_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCargaFamiliar_NM=false;//ConEventDepend=true

	public Border resaltarid_empleadoCargaFamiliar_NM=null;
	public Boolean mostrarid_empleadoCargaFamiliar_NM=true;
	public Boolean activarid_empleadoCargaFamiliar_NM=true;
	public Boolean cargarid_empleadoCargaFamiliar_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCargaFamiliar_NM=false;//ConEventDepend=true

	public Border resaltarid_tipo_carga_famiCargaFamiliar_NM=null;
	public Boolean mostrarid_tipo_carga_famiCargaFamiliar_NM=true;
	public Boolean activarid_tipo_carga_famiCargaFamiliar_NM=true;
	public Boolean cargarid_tipo_carga_famiCargaFamiliar_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_carga_famiCargaFamiliar_NM=false;//ConEventDepend=true

	public Border resaltarid_tipo_generoCargaFamiliar_NM=null;
	public Boolean mostrarid_tipo_generoCargaFamiliar_NM=true;
	public Boolean activarid_tipo_generoCargaFamiliar_NM=true;
	public Boolean cargarid_tipo_generoCargaFamiliar_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_generoCargaFamiliar_NM=false;//ConEventDepend=true

	public Border resaltarid_estado_civilCargaFamiliar_NM=null;
	public Boolean mostrarid_estado_civilCargaFamiliar_NM=true;
	public Boolean activarid_estado_civilCargaFamiliar_NM=true;
	public Boolean cargarid_estado_civilCargaFamiliar_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_civilCargaFamiliar_NM=false;//ConEventDepend=true

	public Border resaltarcedulaCargaFamiliar_NM=null;
	public Boolean mostrarcedulaCargaFamiliar_NM=true;
	public Boolean activarcedulaCargaFamiliar_NM=true;

	public Border resaltarapellidoCargaFamiliar_NM=null;
	public Boolean mostrarapellidoCargaFamiliar_NM=true;
	public Boolean activarapellidoCargaFamiliar_NM=true;

	public Border resaltarnombreCargaFamiliar_NM=null;
	public Boolean mostrarnombreCargaFamiliar_NM=true;
	public Boolean activarnombreCargaFamiliar_NM=true;

	public Border resaltardireccionCargaFamiliar_NM=null;
	public Boolean mostrardireccionCargaFamiliar_NM=true;
	public Boolean activardireccionCargaFamiliar_NM=true;

	public Border resaltarfecha_nacimientoCargaFamiliar_NM=null;
	public Boolean mostrarfecha_nacimientoCargaFamiliar_NM=true;
	public Boolean activarfecha_nacimientoCargaFamiliar_NM=false;

	public Border resaltarvalor_cupoCargaFamiliar_NM=null;
	public Boolean mostrarvalor_cupoCargaFamiliar_NM=true;
	public Boolean activarvalor_cupoCargaFamiliar_NM=true;

	
	

	public Border setResaltaridCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltaridCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCargaFamiliar_NM() {
		return this.resaltaridCargaFamiliar_NM;
	}

	public void setResaltaridCargaFamiliar_NM(Border borderResaltar) {
		this.resaltaridCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostraridCargaFamiliar_NM() {
		return this.mostraridCargaFamiliar_NM;
	}

	public void setMostraridCargaFamiliar_NM(Boolean mostraridCargaFamiliar_NM) {
		this.mostraridCargaFamiliar_NM= mostraridCargaFamiliar_NM;
	}

	public Boolean getActivaridCargaFamiliar_NM() {
		return this.activaridCargaFamiliar_NM;
	}

	public void setActivaridCargaFamiliar_NM(Boolean activaridCargaFamiliar_NM) {
		this.activaridCargaFamiliar_NM= activaridCargaFamiliar_NM;
	}

	public Border setResaltarid_empresaCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarid_empresaCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCargaFamiliar_NM() {
		return this.resaltarid_empresaCargaFamiliar_NM;
	}

	public void setResaltarid_empresaCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarid_empresaCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarid_empresaCargaFamiliar_NM() {
		return this.mostrarid_empresaCargaFamiliar_NM;
	}

	public void setMostrarid_empresaCargaFamiliar_NM(Boolean mostrarid_empresaCargaFamiliar_NM) {
		this.mostrarid_empresaCargaFamiliar_NM= mostrarid_empresaCargaFamiliar_NM;
	}

	public Boolean getActivarid_empresaCargaFamiliar_NM() {
		return this.activarid_empresaCargaFamiliar_NM;
	}

	public void setActivarid_empresaCargaFamiliar_NM(Boolean activarid_empresaCargaFamiliar_NM) {
		this.activarid_empresaCargaFamiliar_NM= activarid_empresaCargaFamiliar_NM;
	}

	public Boolean getCargarid_empresaCargaFamiliar_NM() {
		return this.cargarid_empresaCargaFamiliar_NM;
	}

	public void setCargarid_empresaCargaFamiliar_NM(Boolean cargarid_empresaCargaFamiliar_NM) {
		this.cargarid_empresaCargaFamiliar_NM= cargarid_empresaCargaFamiliar_NM;
	}

	public Border setResaltarid_empleadoCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCargaFamiliar_NM() {
		return this.resaltarid_empleadoCargaFamiliar_NM;
	}

	public void setResaltarid_empleadoCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarid_empleadoCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCargaFamiliar_NM() {
		return this.mostrarid_empleadoCargaFamiliar_NM;
	}

	public void setMostrarid_empleadoCargaFamiliar_NM(Boolean mostrarid_empleadoCargaFamiliar_NM) {
		this.mostrarid_empleadoCargaFamiliar_NM= mostrarid_empleadoCargaFamiliar_NM;
	}

	public Boolean getActivarid_empleadoCargaFamiliar_NM() {
		return this.activarid_empleadoCargaFamiliar_NM;
	}

	public void setActivarid_empleadoCargaFamiliar_NM(Boolean activarid_empleadoCargaFamiliar_NM) {
		this.activarid_empleadoCargaFamiliar_NM= activarid_empleadoCargaFamiliar_NM;
	}

	public Boolean getCargarid_empleadoCargaFamiliar_NM() {
		return this.cargarid_empleadoCargaFamiliar_NM;
	}

	public void setCargarid_empleadoCargaFamiliar_NM(Boolean cargarid_empleadoCargaFamiliar_NM) {
		this.cargarid_empleadoCargaFamiliar_NM= cargarid_empleadoCargaFamiliar_NM;
	}

	public Border setResaltarid_tipo_carga_famiCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarid_tipo_carga_famiCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_carga_famiCargaFamiliar_NM() {
		return this.resaltarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public void setResaltarid_tipo_carga_famiCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarid_tipo_carga_famiCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarid_tipo_carga_famiCargaFamiliar_NM() {
		return this.mostrarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public void setMostrarid_tipo_carga_famiCargaFamiliar_NM(Boolean mostrarid_tipo_carga_famiCargaFamiliar_NM) {
		this.mostrarid_tipo_carga_famiCargaFamiliar_NM= mostrarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public Boolean getActivarid_tipo_carga_famiCargaFamiliar_NM() {
		return this.activarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public void setActivarid_tipo_carga_famiCargaFamiliar_NM(Boolean activarid_tipo_carga_famiCargaFamiliar_NM) {
		this.activarid_tipo_carga_famiCargaFamiliar_NM= activarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public Boolean getCargarid_tipo_carga_famiCargaFamiliar_NM() {
		return this.cargarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public void setCargarid_tipo_carga_famiCargaFamiliar_NM(Boolean cargarid_tipo_carga_famiCargaFamiliar_NM) {
		this.cargarid_tipo_carga_famiCargaFamiliar_NM= cargarid_tipo_carga_famiCargaFamiliar_NM;
	}

	public Border setResaltarid_tipo_generoCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarid_tipo_generoCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_generoCargaFamiliar_NM() {
		return this.resaltarid_tipo_generoCargaFamiliar_NM;
	}

	public void setResaltarid_tipo_generoCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarid_tipo_generoCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarid_tipo_generoCargaFamiliar_NM() {
		return this.mostrarid_tipo_generoCargaFamiliar_NM;
	}

	public void setMostrarid_tipo_generoCargaFamiliar_NM(Boolean mostrarid_tipo_generoCargaFamiliar_NM) {
		this.mostrarid_tipo_generoCargaFamiliar_NM= mostrarid_tipo_generoCargaFamiliar_NM;
	}

	public Boolean getActivarid_tipo_generoCargaFamiliar_NM() {
		return this.activarid_tipo_generoCargaFamiliar_NM;
	}

	public void setActivarid_tipo_generoCargaFamiliar_NM(Boolean activarid_tipo_generoCargaFamiliar_NM) {
		this.activarid_tipo_generoCargaFamiliar_NM= activarid_tipo_generoCargaFamiliar_NM;
	}

	public Boolean getCargarid_tipo_generoCargaFamiliar_NM() {
		return this.cargarid_tipo_generoCargaFamiliar_NM;
	}

	public void setCargarid_tipo_generoCargaFamiliar_NM(Boolean cargarid_tipo_generoCargaFamiliar_NM) {
		this.cargarid_tipo_generoCargaFamiliar_NM= cargarid_tipo_generoCargaFamiliar_NM;
	}

	public Border setResaltarid_estado_civilCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarid_estado_civilCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_civilCargaFamiliar_NM() {
		return this.resaltarid_estado_civilCargaFamiliar_NM;
	}

	public void setResaltarid_estado_civilCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarid_estado_civilCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarid_estado_civilCargaFamiliar_NM() {
		return this.mostrarid_estado_civilCargaFamiliar_NM;
	}

	public void setMostrarid_estado_civilCargaFamiliar_NM(Boolean mostrarid_estado_civilCargaFamiliar_NM) {
		this.mostrarid_estado_civilCargaFamiliar_NM= mostrarid_estado_civilCargaFamiliar_NM;
	}

	public Boolean getActivarid_estado_civilCargaFamiliar_NM() {
		return this.activarid_estado_civilCargaFamiliar_NM;
	}

	public void setActivarid_estado_civilCargaFamiliar_NM(Boolean activarid_estado_civilCargaFamiliar_NM) {
		this.activarid_estado_civilCargaFamiliar_NM= activarid_estado_civilCargaFamiliar_NM;
	}

	public Boolean getCargarid_estado_civilCargaFamiliar_NM() {
		return this.cargarid_estado_civilCargaFamiliar_NM;
	}

	public void setCargarid_estado_civilCargaFamiliar_NM(Boolean cargarid_estado_civilCargaFamiliar_NM) {
		this.cargarid_estado_civilCargaFamiliar_NM= cargarid_estado_civilCargaFamiliar_NM;
	}

	public Border setResaltarcedulaCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarcedulaCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcedulaCargaFamiliar_NM() {
		return this.resaltarcedulaCargaFamiliar_NM;
	}

	public void setResaltarcedulaCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarcedulaCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarcedulaCargaFamiliar_NM() {
		return this.mostrarcedulaCargaFamiliar_NM;
	}

	public void setMostrarcedulaCargaFamiliar_NM(Boolean mostrarcedulaCargaFamiliar_NM) {
		this.mostrarcedulaCargaFamiliar_NM= mostrarcedulaCargaFamiliar_NM;
	}

	public Boolean getActivarcedulaCargaFamiliar_NM() {
		return this.activarcedulaCargaFamiliar_NM;
	}

	public void setActivarcedulaCargaFamiliar_NM(Boolean activarcedulaCargaFamiliar_NM) {
		this.activarcedulaCargaFamiliar_NM= activarcedulaCargaFamiliar_NM;
	}

	public Border setResaltarapellidoCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarapellidoCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCargaFamiliar_NM() {
		return this.resaltarapellidoCargaFamiliar_NM;
	}

	public void setResaltarapellidoCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarapellidoCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarapellidoCargaFamiliar_NM() {
		return this.mostrarapellidoCargaFamiliar_NM;
	}

	public void setMostrarapellidoCargaFamiliar_NM(Boolean mostrarapellidoCargaFamiliar_NM) {
		this.mostrarapellidoCargaFamiliar_NM= mostrarapellidoCargaFamiliar_NM;
	}

	public Boolean getActivarapellidoCargaFamiliar_NM() {
		return this.activarapellidoCargaFamiliar_NM;
	}

	public void setActivarapellidoCargaFamiliar_NM(Boolean activarapellidoCargaFamiliar_NM) {
		this.activarapellidoCargaFamiliar_NM= activarapellidoCargaFamiliar_NM;
	}

	public Border setResaltarnombreCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarnombreCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCargaFamiliar_NM() {
		return this.resaltarnombreCargaFamiliar_NM;
	}

	public void setResaltarnombreCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarnombreCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarnombreCargaFamiliar_NM() {
		return this.mostrarnombreCargaFamiliar_NM;
	}

	public void setMostrarnombreCargaFamiliar_NM(Boolean mostrarnombreCargaFamiliar_NM) {
		this.mostrarnombreCargaFamiliar_NM= mostrarnombreCargaFamiliar_NM;
	}

	public Boolean getActivarnombreCargaFamiliar_NM() {
		return this.activarnombreCargaFamiliar_NM;
	}

	public void setActivarnombreCargaFamiliar_NM(Boolean activarnombreCargaFamiliar_NM) {
		this.activarnombreCargaFamiliar_NM= activarnombreCargaFamiliar_NM;
	}

	public Border setResaltardireccionCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltardireccionCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionCargaFamiliar_NM() {
		return this.resaltardireccionCargaFamiliar_NM;
	}

	public void setResaltardireccionCargaFamiliar_NM(Border borderResaltar) {
		this.resaltardireccionCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrardireccionCargaFamiliar_NM() {
		return this.mostrardireccionCargaFamiliar_NM;
	}

	public void setMostrardireccionCargaFamiliar_NM(Boolean mostrardireccionCargaFamiliar_NM) {
		this.mostrardireccionCargaFamiliar_NM= mostrardireccionCargaFamiliar_NM;
	}

	public Boolean getActivardireccionCargaFamiliar_NM() {
		return this.activardireccionCargaFamiliar_NM;
	}

	public void setActivardireccionCargaFamiliar_NM(Boolean activardireccionCargaFamiliar_NM) {
		this.activardireccionCargaFamiliar_NM= activardireccionCargaFamiliar_NM;
	}

	public Border setResaltarfecha_nacimientoCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoCargaFamiliar_NM() {
		return this.resaltarfecha_nacimientoCargaFamiliar_NM;
	}

	public void setResaltarfecha_nacimientoCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarfecha_nacimientoCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoCargaFamiliar_NM() {
		return this.mostrarfecha_nacimientoCargaFamiliar_NM;
	}

	public void setMostrarfecha_nacimientoCargaFamiliar_NM(Boolean mostrarfecha_nacimientoCargaFamiliar_NM) {
		this.mostrarfecha_nacimientoCargaFamiliar_NM= mostrarfecha_nacimientoCargaFamiliar_NM;
	}

	public Boolean getActivarfecha_nacimientoCargaFamiliar_NM() {
		return this.activarfecha_nacimientoCargaFamiliar_NM;
	}

	public void setActivarfecha_nacimientoCargaFamiliar_NM(Boolean activarfecha_nacimientoCargaFamiliar_NM) {
		this.activarfecha_nacimientoCargaFamiliar_NM= activarfecha_nacimientoCargaFamiliar_NM;
	}

	public Border setResaltarvalor_cupoCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliar_nmBeanSwingJInternalFrame.jTtoolBarCargaFamiliar_NM.setBorder(borderResaltar);
		
		this.resaltarvalor_cupoCargaFamiliar_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_cupoCargaFamiliar_NM() {
		return this.resaltarvalor_cupoCargaFamiliar_NM;
	}

	public void setResaltarvalor_cupoCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarvalor_cupoCargaFamiliar_NM= borderResaltar;
	}

	public Boolean getMostrarvalor_cupoCargaFamiliar_NM() {
		return this.mostrarvalor_cupoCargaFamiliar_NM;
	}

	public void setMostrarvalor_cupoCargaFamiliar_NM(Boolean mostrarvalor_cupoCargaFamiliar_NM) {
		this.mostrarvalor_cupoCargaFamiliar_NM= mostrarvalor_cupoCargaFamiliar_NM;
	}

	public Boolean getActivarvalor_cupoCargaFamiliar_NM() {
		return this.activarvalor_cupoCargaFamiliar_NM;
	}

	public void setActivarvalor_cupoCargaFamiliar_NM(Boolean activarvalor_cupoCargaFamiliar_NM) {
		this.activarvalor_cupoCargaFamiliar_NM= activarvalor_cupoCargaFamiliar_NM;
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
		
		
		this.setMostraridCargaFamiliar_NM(esInicial);
		this.setMostrarid_empresaCargaFamiliar_NM(esInicial);
		this.setMostrarid_empleadoCargaFamiliar_NM(esInicial);
		this.setMostrarid_tipo_carga_famiCargaFamiliar_NM(esInicial);
		this.setMostrarid_tipo_generoCargaFamiliar_NM(esInicial);
		this.setMostrarid_estado_civilCargaFamiliar_NM(esInicial);
		this.setMostrarcedulaCargaFamiliar_NM(esInicial);
		this.setMostrarapellidoCargaFamiliar_NM(esInicial);
		this.setMostrarnombreCargaFamiliar_NM(esInicial);
		this.setMostrardireccionCargaFamiliar_NM(esInicial);
		this.setMostrarfecha_nacimientoCargaFamiliar_NM(esInicial);
		this.setMostrarvalor_cupoCargaFamiliar_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.ID)) {
				this.setMostraridCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI)) {
				this.setMostrarid_tipo_carga_famiCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO)) {
				this.setMostrarid_tipo_generoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL)) {
				this.setMostrarid_estado_civilCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.CEDULA)) {
				this.setMostrarcedulaCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.VALORCUPO)) {
				this.setMostrarvalor_cupoCargaFamiliar_NM(esAsigna);
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
		
		
		this.setActivaridCargaFamiliar_NM(esInicial);
		this.setActivarid_empresaCargaFamiliar_NM(esInicial);
		this.setActivarid_empleadoCargaFamiliar_NM(esInicial);
		this.setActivarid_tipo_carga_famiCargaFamiliar_NM(esInicial);
		this.setActivarid_tipo_generoCargaFamiliar_NM(esInicial);
		this.setActivarid_estado_civilCargaFamiliar_NM(esInicial);
		this.setActivarcedulaCargaFamiliar_NM(esInicial);
		this.setActivarapellidoCargaFamiliar_NM(esInicial);
		this.setActivarnombreCargaFamiliar_NM(esInicial);
		this.setActivardireccionCargaFamiliar_NM(esInicial);
		this.setActivarfecha_nacimientoCargaFamiliar_NM(esInicial);
		this.setActivarvalor_cupoCargaFamiliar_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.ID)) {
				this.setActivaridCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI)) {
				this.setActivarid_tipo_carga_famiCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO)) {
				this.setActivarid_tipo_generoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL)) {
				this.setActivarid_estado_civilCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.CEDULA)) {
				this.setActivarcedulaCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.DIRECCION)) {
				this.setActivardireccionCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.VALORCUPO)) {
				this.setActivarvalor_cupoCargaFamiliar_NM(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCargaFamiliar_NM(esInicial);
		this.setResaltarid_empresaCargaFamiliar_NM(esInicial);
		this.setResaltarid_empleadoCargaFamiliar_NM(esInicial);
		this.setResaltarid_tipo_carga_famiCargaFamiliar_NM(esInicial);
		this.setResaltarid_tipo_generoCargaFamiliar_NM(esInicial);
		this.setResaltarid_estado_civilCargaFamiliar_NM(esInicial);
		this.setResaltarcedulaCargaFamiliar_NM(esInicial);
		this.setResaltarapellidoCargaFamiliar_NM(esInicial);
		this.setResaltarnombreCargaFamiliar_NM(esInicial);
		this.setResaltardireccionCargaFamiliar_NM(esInicial);
		this.setResaltarfecha_nacimientoCargaFamiliar_NM(esInicial);
		this.setResaltarvalor_cupoCargaFamiliar_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.ID)) {
				this.setResaltaridCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI)) {
				this.setResaltarid_tipo_carga_famiCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO)) {
				this.setResaltarid_tipo_generoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL)) {
				this.setResaltarid_estado_civilCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.CEDULA)) {
				this.setResaltarcedulaCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoCargaFamiliar_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliar_NMConstantesFunciones.VALORCUPO)) {
				this.setResaltarvalor_cupoCargaFamiliar_NM(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoCargaFamiliar_NM=true;

	public Boolean getMostrarFK_IdEmpleadoCargaFamiliar_NM() {
		return this.mostrarFK_IdEmpleadoCargaFamiliar_NM;
	}

	public void setMostrarFK_IdEmpleadoCargaFamiliar_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoCargaFamiliar_NM= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCargaFamiliar_NM=true;

	public Boolean getMostrarFK_IdEmpresaCargaFamiliar_NM() {
		return this.mostrarFK_IdEmpresaCargaFamiliar_NM;
	}

	public void setMostrarFK_IdEmpresaCargaFamiliar_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCargaFamiliar_NM= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCivilCargaFamiliar_NM=true;

	public Boolean getMostrarFK_IdEstadoCivilCargaFamiliar_NM() {
		return this.mostrarFK_IdEstadoCivilCargaFamiliar_NM;
	}

	public void setMostrarFK_IdEstadoCivilCargaFamiliar_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCivilCargaFamiliar_NM= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCargaFamiCargaFamiliar_NM=true;

	public Boolean getMostrarFK_IdTipoCargaFamiCargaFamiliar_NM() {
		return this.mostrarFK_IdTipoCargaFamiCargaFamiliar_NM;
	}

	public void setMostrarFK_IdTipoCargaFamiCargaFamiliar_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCargaFamiCargaFamiliar_NM= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGeneroCargaFamiliar_NM=true;

	public Boolean getMostrarFK_IdTipoGeneroCargaFamiliar_NM() {
		return this.mostrarFK_IdTipoGeneroCargaFamiliar_NM;
	}

	public void setMostrarFK_IdTipoGeneroCargaFamiliar_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGeneroCargaFamiliar_NM= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoCargaFamiliar_NM=true;

	public Boolean getActivarFK_IdEmpleadoCargaFamiliar_NM() {
		return this.activarFK_IdEmpleadoCargaFamiliar_NM;
	}

	public void setActivarFK_IdEmpleadoCargaFamiliar_NM(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoCargaFamiliar_NM= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCargaFamiliar_NM=true;

	public Boolean getActivarFK_IdEmpresaCargaFamiliar_NM() {
		return this.activarFK_IdEmpresaCargaFamiliar_NM;
	}

	public void setActivarFK_IdEmpresaCargaFamiliar_NM(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCargaFamiliar_NM= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCivilCargaFamiliar_NM=true;

	public Boolean getActivarFK_IdEstadoCivilCargaFamiliar_NM() {
		return this.activarFK_IdEstadoCivilCargaFamiliar_NM;
	}

	public void setActivarFK_IdEstadoCivilCargaFamiliar_NM(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCivilCargaFamiliar_NM= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCargaFamiCargaFamiliar_NM=true;

	public Boolean getActivarFK_IdTipoCargaFamiCargaFamiliar_NM() {
		return this.activarFK_IdTipoCargaFamiCargaFamiliar_NM;
	}

	public void setActivarFK_IdTipoCargaFamiCargaFamiliar_NM(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCargaFamiCargaFamiliar_NM= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGeneroCargaFamiliar_NM=true;

	public Boolean getActivarFK_IdTipoGeneroCargaFamiliar_NM() {
		return this.activarFK_IdTipoGeneroCargaFamiliar_NM;
	}

	public void setActivarFK_IdTipoGeneroCargaFamiliar_NM(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGeneroCargaFamiliar_NM= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoCargaFamiliar_NM=null;

	public Border getResaltarFK_IdEmpleadoCargaFamiliar_NM() {
		return this.resaltarFK_IdEmpleadoCargaFamiliar_NM;
	}

	public void setResaltarFK_IdEmpleadoCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoCargaFamiliar_NM= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoCargaFamiliar_NM= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCargaFamiliar_NM=null;

	public Border getResaltarFK_IdEmpresaCargaFamiliar_NM() {
		return this.resaltarFK_IdEmpresaCargaFamiliar_NM;
	}

	public void setResaltarFK_IdEmpresaCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCargaFamiliar_NM= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCargaFamiliar_NM= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCivilCargaFamiliar_NM=null;

	public Border getResaltarFK_IdEstadoCivilCargaFamiliar_NM() {
		return this.resaltarFK_IdEstadoCivilCargaFamiliar_NM;
	}

	public void setResaltarFK_IdEstadoCivilCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarFK_IdEstadoCivilCargaFamiliar_NM= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCivilCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCivilCargaFamiliar_NM= borderResaltar;
	}

	public Border resaltarFK_IdTipoCargaFamiCargaFamiliar_NM=null;

	public Border getResaltarFK_IdTipoCargaFamiCargaFamiliar_NM() {
		return this.resaltarFK_IdTipoCargaFamiCargaFamiliar_NM;
	}

	public void setResaltarFK_IdTipoCargaFamiCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarFK_IdTipoCargaFamiCargaFamiliar_NM= borderResaltar;
	}

	public void setResaltarFK_IdTipoCargaFamiCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCargaFamiCargaFamiliar_NM= borderResaltar;
	}

	public Border resaltarFK_IdTipoGeneroCargaFamiliar_NM=null;

	public Border getResaltarFK_IdTipoGeneroCargaFamiliar_NM() {
		return this.resaltarFK_IdTipoGeneroCargaFamiliar_NM;
	}

	public void setResaltarFK_IdTipoGeneroCargaFamiliar_NM(Border borderResaltar) {
		this.resaltarFK_IdTipoGeneroCargaFamiliar_NM= borderResaltar;
	}

	public void setResaltarFK_IdTipoGeneroCargaFamiliar_NM(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliar_NMBeanSwingJInternalFrame cargafamiliar_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGeneroCargaFamiliar_NM= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}