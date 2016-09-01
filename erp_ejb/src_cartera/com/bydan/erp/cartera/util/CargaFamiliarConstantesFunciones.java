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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.CargaFamiliarConstantesFunciones;
import com.bydan.erp.cartera.util.CargaFamiliarParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CargaFamiliarParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CargaFamiliarConstantesFunciones extends CargaFamiliarConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CargaFamiliar";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CargaFamiliar"+CargaFamiliarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CargaFamiliarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CargaFamiliarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CargaFamiliarConstantesFunciones.SCHEMA+"_"+CargaFamiliarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CargaFamiliarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CargaFamiliarConstantesFunciones.SCHEMA+"_"+CargaFamiliarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CargaFamiliarConstantesFunciones.SCHEMA+"_"+CargaFamiliarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CargaFamiliarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CargaFamiliarConstantesFunciones.SCHEMA+"_"+CargaFamiliarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargaFamiliarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargaFamiliarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargaFamiliarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CargaFamiliarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CargaFamiliarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CargaFamiliarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CargaFamiliarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Carga Familiares";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Carga Familiar";
	public static final String SCLASSWEBTITULO_LOWER="Carga Familiar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CargaFamiliar";
	public static final String OBJECTNAME="cargafamiliar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="carga_familiar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cargafamiliar from "+CargaFamiliarConstantesFunciones.SPERSISTENCENAME+" cargafamiliar";
	public static String QUERYSELECTNATIVE="select "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".version_row,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_empresa,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_cliente,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_tipo_carga_fami,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_tipo_genero,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_estado_civil,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".cedula,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".apellido,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".nombre,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".direccion,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".fecha_nacimiento,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".valor_cupo from "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME;//+" as "+CargaFamiliarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CargaFamiliarConstantesFuncionesAdditional cargafamiliarConstantesFuncionesAdditional=null;
	
	public CargaFamiliarConstantesFuncionesAdditional getCargaFamiliarConstantesFuncionesAdditional() {
		return this.cargafamiliarConstantesFuncionesAdditional;
	}
	
	public void setCargaFamiliarConstantesFuncionesAdditional(CargaFamiliarConstantesFuncionesAdditional cargafamiliarConstantesFuncionesAdditional) {
		try {
			this.cargafamiliarConstantesFuncionesAdditional=cargafamiliarConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
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
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
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
		
		
	
	public static String getCargaFamiliarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.IDEMPRESA)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.IDCLIENTE)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_IDTIPOCARGAFAMI;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.IDTIPOGENERO)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_IDTIPOGENERO;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.IDESTADOCIVIL)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_IDESTADOCIVIL;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.CEDULA)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_CEDULA;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.APELLIDO)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.NOMBRE)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.DIRECCION)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(CargaFamiliarConstantesFunciones.VALORCUPO)) {sLabelColumna=CargaFamiliarConstantesFunciones.LABEL_VALORCUPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCargaFamiliarDescripcion(CargaFamiliar cargafamiliar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cargafamiliar !=null/* && cargafamiliar.getId()!=0*/) {
			sDescripcion=cargafamiliar.getnombre();//cargafamiliarcargafamiliar.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCargaFamiliarDescripcionDetallado(CargaFamiliar cargafamiliar) {
		String sDescripcion="";
			
		sDescripcion+=CargaFamiliarConstantesFunciones.ID+"=";
		sDescripcion+=cargafamiliar.getId().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cargafamiliar.getVersionRow().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cargafamiliar.getid_empresa().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cargafamiliar.getid_cliente().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI+"=";
		sDescripcion+=cargafamiliar.getid_tipo_carga_fami().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.IDTIPOGENERO+"=";
		sDescripcion+=cargafamiliar.getid_tipo_genero().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.IDESTADOCIVIL+"=";
		sDescripcion+=cargafamiliar.getid_estado_civil().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.CEDULA+"=";
		sDescripcion+=cargafamiliar.getcedula()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cargafamiliar.getapellido()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cargafamiliar.getnombre()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.DIRECCION+"=";
		sDescripcion+=cargafamiliar.getdireccion()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=cargafamiliar.getfecha_nacimiento().toString()+",";
		sDescripcion+=CargaFamiliarConstantesFunciones.VALORCUPO+"=";
		sDescripcion+=cargafamiliar.getvalor_cupo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCargaFamiliarDescripcion(CargaFamiliar cargafamiliar,String sValor) throws Exception {			
		if(cargafamiliar !=null) {
			cargafamiliar.setnombre(sValor);;//cargafamiliarcargafamiliar.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosCargaFamiliar(CargaFamiliar cargafamiliar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cargafamiliar.setcedula(cargafamiliar.getcedula().trim());
		cargafamiliar.setapellido(cargafamiliar.getapellido().trim());
		cargafamiliar.setnombre(cargafamiliar.getnombre().trim());
		cargafamiliar.setdireccion(cargafamiliar.getdireccion().trim());
	}
	
	public static void quitarEspaciosCargaFamiliars(List<CargaFamiliar> cargafamiliars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CargaFamiliar cargafamiliar: cargafamiliars) {
			cargafamiliar.setcedula(cargafamiliar.getcedula().trim());
			cargafamiliar.setapellido(cargafamiliar.getapellido().trim());
			cargafamiliar.setnombre(cargafamiliar.getnombre().trim());
			cargafamiliar.setdireccion(cargafamiliar.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargaFamiliar(CargaFamiliar cargafamiliar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cargafamiliar.getConCambioAuxiliar()) {
			cargafamiliar.setIsDeleted(cargafamiliar.getIsDeletedAuxiliar());	
			cargafamiliar.setIsNew(cargafamiliar.getIsNewAuxiliar());	
			cargafamiliar.setIsChanged(cargafamiliar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cargafamiliar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cargafamiliar.setIsDeletedAuxiliar(false);	
			cargafamiliar.setIsNewAuxiliar(false);	
			cargafamiliar.setIsChangedAuxiliar(false);
			
			cargafamiliar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargaFamiliars(List<CargaFamiliar> cargafamiliars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CargaFamiliar cargafamiliar : cargafamiliars) {
			if(conAsignarBase && cargafamiliar.getConCambioAuxiliar()) {
				cargafamiliar.setIsDeleted(cargafamiliar.getIsDeletedAuxiliar());	
				cargafamiliar.setIsNew(cargafamiliar.getIsNewAuxiliar());	
				cargafamiliar.setIsChanged(cargafamiliar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cargafamiliar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cargafamiliar.setIsDeletedAuxiliar(false);	
				cargafamiliar.setIsNewAuxiliar(false);	
				cargafamiliar.setIsChangedAuxiliar(false);
				
				cargafamiliar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCargaFamiliar(CargaFamiliar cargafamiliar,Boolean conEnteros) throws Exception  {
		cargafamiliar.setvalor_cupo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCargaFamiliars(List<CargaFamiliar> cargafamiliars,Boolean conEnteros) throws Exception  {
		
		for(CargaFamiliar cargafamiliar: cargafamiliars) {
			cargafamiliar.setvalor_cupo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCargaFamiliar(List<CargaFamiliar> cargafamiliars,CargaFamiliar cargafamiliarAux) throws Exception  {
		CargaFamiliarConstantesFunciones.InicializarValoresCargaFamiliar(cargafamiliarAux,true);
		
		for(CargaFamiliar cargafamiliar: cargafamiliars) {
			if(cargafamiliar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cargafamiliarAux.setvalor_cupo(cargafamiliarAux.getvalor_cupo()+cargafamiliar.getvalor_cupo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCargaFamiliar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CargaFamiliarConstantesFunciones.getArrayColumnasGlobalesCargaFamiliar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCargaFamiliar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CargaFamiliarConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CargaFamiliarConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCargaFamiliar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CargaFamiliar> cargafamiliars,CargaFamiliar cargafamiliar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CargaFamiliar cargafamiliarAux: cargafamiliars) {
			if(cargafamiliarAux!=null && cargafamiliar!=null) {
				if((cargafamiliarAux.getId()==null && cargafamiliar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cargafamiliarAux.getId()!=null && cargafamiliar.getId()!=null){
					if(cargafamiliarAux.getId().equals(cargafamiliar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCargaFamiliar(List<CargaFamiliar> cargafamiliars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_cupoTotal=0.0;
	
		for(CargaFamiliar cargafamiliar: cargafamiliars) {			
			if(cargafamiliar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_cupoTotal+=cargafamiliar.getvalor_cupo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CargaFamiliarConstantesFunciones.VALORCUPO);
		datoGeneral.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_VALORCUPO);
		datoGeneral.setdValorDouble(valor_cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCargaFamiliar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_ID, CargaFamiliarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_VERSIONROW, CargaFamiliarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_IDEMPRESA, CargaFamiliarConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_IDCLIENTE, CargaFamiliarConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_IDTIPOCARGAFAMI, CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_IDTIPOGENERO, CargaFamiliarConstantesFunciones.IDTIPOGENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_IDESTADOCIVIL, CargaFamiliarConstantesFunciones.IDESTADOCIVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_CEDULA, CargaFamiliarConstantesFunciones.CEDULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_APELLIDO, CargaFamiliarConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_NOMBRE, CargaFamiliarConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_DIRECCION, CargaFamiliarConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_FECHANACIMIENTO, CargaFamiliarConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargaFamiliarConstantesFunciones.LABEL_VALORCUPO, CargaFamiliarConstantesFunciones.VALORCUPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCargaFamiliar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.IDTIPOGENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.IDESTADOCIVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.CEDULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargaFamiliarConstantesFunciones.VALORCUPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargaFamiliar() throws Exception  {
		return CargaFamiliarConstantesFunciones.getTiposSeleccionarCargaFamiliar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargaFamiliar(Boolean conFk) throws Exception  {
		return CargaFamiliarConstantesFunciones.getTiposSeleccionarCargaFamiliar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargaFamiliar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_IDTIPOCARGAFAMI);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_IDTIPOCARGAFAMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_IDTIPOGENERO);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_IDTIPOGENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_IDESTADOCIVIL);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_IDESTADOCIVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_CEDULA);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_CEDULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargaFamiliarConstantesFunciones.LABEL_VALORCUPO);
			reporte.setsDescripcion(CargaFamiliarConstantesFunciones.LABEL_VALORCUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCargaFamiliar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCargaFamiliar(CargaFamiliar cargafamiliarAux) throws Exception {
		
			cargafamiliarAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargafamiliarAux.getEmpresa()));
			cargafamiliarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cargafamiliarAux.getCliente()));
			cargafamiliarAux.settipocargafami_descripcion(TipoCargaFamiConstantesFunciones.getTipoCargaFamiDescripcion(cargafamiliarAux.getTipoCargaFami()));
			cargafamiliarAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(cargafamiliarAux.getTipoGenero()));
			cargafamiliarAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(cargafamiliarAux.getEstadoCivil()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCargaFamiliar(List<CargaFamiliar> cargafamiliarsTemp) throws Exception {
		for(CargaFamiliar cargafamiliarAux:cargafamiliarsTemp) {
			
			cargafamiliarAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargafamiliarAux.getEmpresa()));
			cargafamiliarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cargafamiliarAux.getCliente()));
			cargafamiliarAux.settipocargafami_descripcion(TipoCargaFamiConstantesFunciones.getTipoCargaFamiDescripcion(cargafamiliarAux.getTipoCargaFami()));
			cargafamiliarAux.settipogenero_descripcion(TipoGeneroConstantesFunciones.getTipoGeneroDescripcion(cargafamiliarAux.getTipoGenero()));
			cargafamiliarAux.setestadocivil_descripcion(EstadoCivilConstantesFunciones.getEstadoCivilDescripcion(cargafamiliarAux.getEstadoCivil()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCargaFamiliar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCargaFamiliar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargaFamiliar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargaFamiliarConstantesFunciones.getClassesRelationshipsOfCargaFamiliar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargaFamiliar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargaFamiliar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargaFamiliarConstantesFunciones.getClassesRelationshipsFromStringsOfCargaFamiliar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargaFamiliar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CargaFamiliar cargafamiliar,List<CargaFamiliar> cargafamiliars,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CargaFamiliar cargafamiliarEncontrado=null;
			
			for(CargaFamiliar cargafamiliarLocal:cargafamiliars) {
				if(cargafamiliarLocal.getId().equals(cargafamiliar.getId())) {
					cargafamiliarEncontrado=cargafamiliarLocal;
					
					cargafamiliarLocal.setIsChanged(cargafamiliar.getIsChanged());
					cargafamiliarLocal.setIsNew(cargafamiliar.getIsNew());
					cargafamiliarLocal.setIsDeleted(cargafamiliar.getIsDeleted());
					
					cargafamiliarLocal.setGeneralEntityOriginal(cargafamiliar.getGeneralEntityOriginal());
					
					cargafamiliarLocal.setId(cargafamiliar.getId());	
					cargafamiliarLocal.setVersionRow(cargafamiliar.getVersionRow());	
					cargafamiliarLocal.setid_empresa(cargafamiliar.getid_empresa());	
					cargafamiliarLocal.setid_cliente(cargafamiliar.getid_cliente());	
					cargafamiliarLocal.setid_tipo_carga_fami(cargafamiliar.getid_tipo_carga_fami());	
					cargafamiliarLocal.setid_tipo_genero(cargafamiliar.getid_tipo_genero());	
					cargafamiliarLocal.setid_estado_civil(cargafamiliar.getid_estado_civil());	
					cargafamiliarLocal.setcedula(cargafamiliar.getcedula());	
					cargafamiliarLocal.setapellido(cargafamiliar.getapellido());	
					cargafamiliarLocal.setnombre(cargafamiliar.getnombre());	
					cargafamiliarLocal.setdireccion(cargafamiliar.getdireccion());	
					cargafamiliarLocal.setfecha_nacimiento(cargafamiliar.getfecha_nacimiento());	
					cargafamiliarLocal.setvalor_cupo(cargafamiliar.getvalor_cupo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cargafamiliar.getIsDeleted()) {
				if(!existe) {
					cargafamiliars.add(cargafamiliar);
				}
			} else {
				if(cargafamiliarEncontrado!=null && permiteQuitar)  {
					cargafamiliars.remove(cargafamiliarEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CargaFamiliar cargafamiliar,List<CargaFamiliar> cargafamiliars) throws Exception {
		try	{			
			for(CargaFamiliar cargafamiliarLocal:cargafamiliars) {
				if(cargafamiliarLocal.getId().equals(cargafamiliar.getId())) {
					cargafamiliarLocal.setIsSelected(cargafamiliar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCargaFamiliar(List<CargaFamiliar> cargafamiliarsAux) throws Exception {
		//this.cargafamiliarsAux=cargafamiliarsAux;
		
		for(CargaFamiliar cargafamiliarAux:cargafamiliarsAux) {
			if(cargafamiliarAux.getIsChanged()) {
				cargafamiliarAux.setIsChanged(false);
			}		
			
			if(cargafamiliarAux.getIsNew()) {
				cargafamiliarAux.setIsNew(false);
			}	
			
			if(cargafamiliarAux.getIsDeleted()) {
				cargafamiliarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCargaFamiliar(CargaFamiliar cargafamiliarAux) throws Exception {
		//this.cargafamiliarAux=cargafamiliarAux;
		
			if(cargafamiliarAux.getIsChanged()) {
				cargafamiliarAux.setIsChanged(false);
			}		
			
			if(cargafamiliarAux.getIsNew()) {
				cargafamiliarAux.setIsNew(false);
			}	
			
			if(cargafamiliarAux.getIsDeleted()) {
				cargafamiliarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CargaFamiliar cargafamiliarAsignar,CargaFamiliar cargafamiliar) throws Exception {
		cargafamiliarAsignar.setId(cargafamiliar.getId());	
		cargafamiliarAsignar.setVersionRow(cargafamiliar.getVersionRow());	
		cargafamiliarAsignar.setid_empresa(cargafamiliar.getid_empresa());
		cargafamiliarAsignar.setempresa_descripcion(cargafamiliar.getempresa_descripcion());	
		cargafamiliarAsignar.setid_cliente(cargafamiliar.getid_cliente());
		cargafamiliarAsignar.setcliente_descripcion(cargafamiliar.getcliente_descripcion());	
		cargafamiliarAsignar.setid_tipo_carga_fami(cargafamiliar.getid_tipo_carga_fami());
		cargafamiliarAsignar.settipocargafami_descripcion(cargafamiliar.gettipocargafami_descripcion());	
		cargafamiliarAsignar.setid_tipo_genero(cargafamiliar.getid_tipo_genero());
		cargafamiliarAsignar.settipogenero_descripcion(cargafamiliar.gettipogenero_descripcion());	
		cargafamiliarAsignar.setid_estado_civil(cargafamiliar.getid_estado_civil());
		cargafamiliarAsignar.setestadocivil_descripcion(cargafamiliar.getestadocivil_descripcion());	
		cargafamiliarAsignar.setcedula(cargafamiliar.getcedula());	
		cargafamiliarAsignar.setapellido(cargafamiliar.getapellido());	
		cargafamiliarAsignar.setnombre(cargafamiliar.getnombre());	
		cargafamiliarAsignar.setdireccion(cargafamiliar.getdireccion());	
		cargafamiliarAsignar.setfecha_nacimiento(cargafamiliar.getfecha_nacimiento());	
		cargafamiliarAsignar.setvalor_cupo(cargafamiliar.getvalor_cupo());	
	}
	
	public static void inicializarCargaFamiliar(CargaFamiliar cargafamiliar) throws Exception {
		try {
				cargafamiliar.setId(0L);	
					
				cargafamiliar.setid_empresa(-1L);	
				cargafamiliar.setid_cliente(-1L);	
				cargafamiliar.setid_tipo_carga_fami(-1L);	
				cargafamiliar.setid_tipo_genero(-1L);	
				cargafamiliar.setid_estado_civil(-1L);	
				cargafamiliar.setcedula("");	
				cargafamiliar.setapellido("");	
				cargafamiliar.setnombre("");	
				cargafamiliar.setdireccion("");	
				cargafamiliar.setfecha_nacimiento(new Date());	
				cargafamiliar.setvalor_cupo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCargaFamiliar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_IDTIPOCARGAFAMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_IDTIPOGENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_IDESTADOCIVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_CEDULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargaFamiliarConstantesFunciones.LABEL_VALORCUPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCargaFamiliar(String sTipo,Row row,Workbook workbook,CargaFamiliar cargafamiliar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.gettipocargafami_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.gettipogenero_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getestadocivil_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getcedula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargafamiliar.getvalor_cupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCargaFamiliar=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCargaFamiliar() {
		return this.sFinalQueryCargaFamiliar;
	}
	
	public void setsFinalQueryCargaFamiliar(String sFinalQueryCargaFamiliar) {
		this.sFinalQueryCargaFamiliar= sFinalQueryCargaFamiliar;
	}
	
	public Border resaltarSeleccionarCargaFamiliar=null;
	
	public Border setResaltarSeleccionarCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCargaFamiliar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCargaFamiliar() {
		return this.resaltarSeleccionarCargaFamiliar;
	}
	
	public void setResaltarSeleccionarCargaFamiliar(Border borderResaltarSeleccionarCargaFamiliar) {
		this.resaltarSeleccionarCargaFamiliar= borderResaltarSeleccionarCargaFamiliar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCargaFamiliar=null;
	public Boolean mostraridCargaFamiliar=true;
	public Boolean activaridCargaFamiliar=true;

	public Border resaltarid_empresaCargaFamiliar=null;
	public Boolean mostrarid_empresaCargaFamiliar=true;
	public Boolean activarid_empresaCargaFamiliar=true;
	public Boolean cargarid_empresaCargaFamiliar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCargaFamiliar=false;//ConEventDepend=true

	public Border resaltarid_clienteCargaFamiliar=null;
	public Boolean mostrarid_clienteCargaFamiliar=true;
	public Boolean activarid_clienteCargaFamiliar=true;
	public Boolean cargarid_clienteCargaFamiliar=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCargaFamiliar=false;//ConEventDepend=true

	public Border resaltarid_tipo_carga_famiCargaFamiliar=null;
	public Boolean mostrarid_tipo_carga_famiCargaFamiliar=true;
	public Boolean activarid_tipo_carga_famiCargaFamiliar=true;
	public Boolean cargarid_tipo_carga_famiCargaFamiliar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_carga_famiCargaFamiliar=false;//ConEventDepend=true

	public Border resaltarid_tipo_generoCargaFamiliar=null;
	public Boolean mostrarid_tipo_generoCargaFamiliar=true;
	public Boolean activarid_tipo_generoCargaFamiliar=true;
	public Boolean cargarid_tipo_generoCargaFamiliar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_generoCargaFamiliar=false;//ConEventDepend=true

	public Border resaltarid_estado_civilCargaFamiliar=null;
	public Boolean mostrarid_estado_civilCargaFamiliar=true;
	public Boolean activarid_estado_civilCargaFamiliar=true;
	public Boolean cargarid_estado_civilCargaFamiliar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_civilCargaFamiliar=false;//ConEventDepend=true

	public Border resaltarcedulaCargaFamiliar=null;
	public Boolean mostrarcedulaCargaFamiliar=true;
	public Boolean activarcedulaCargaFamiliar=true;

	public Border resaltarapellidoCargaFamiliar=null;
	public Boolean mostrarapellidoCargaFamiliar=true;
	public Boolean activarapellidoCargaFamiliar=true;

	public Border resaltarnombreCargaFamiliar=null;
	public Boolean mostrarnombreCargaFamiliar=true;
	public Boolean activarnombreCargaFamiliar=true;

	public Border resaltardireccionCargaFamiliar=null;
	public Boolean mostrardireccionCargaFamiliar=true;
	public Boolean activardireccionCargaFamiliar=true;

	public Border resaltarfecha_nacimientoCargaFamiliar=null;
	public Boolean mostrarfecha_nacimientoCargaFamiliar=true;
	public Boolean activarfecha_nacimientoCargaFamiliar=false;

	public Border resaltarvalor_cupoCargaFamiliar=null;
	public Boolean mostrarvalor_cupoCargaFamiliar=true;
	public Boolean activarvalor_cupoCargaFamiliar=true;

	
	

	public Border setResaltaridCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltaridCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCargaFamiliar() {
		return this.resaltaridCargaFamiliar;
	}

	public void setResaltaridCargaFamiliar(Border borderResaltar) {
		this.resaltaridCargaFamiliar= borderResaltar;
	}

	public Boolean getMostraridCargaFamiliar() {
		return this.mostraridCargaFamiliar;
	}

	public void setMostraridCargaFamiliar(Boolean mostraridCargaFamiliar) {
		this.mostraridCargaFamiliar= mostraridCargaFamiliar;
	}

	public Boolean getActivaridCargaFamiliar() {
		return this.activaridCargaFamiliar;
	}

	public void setActivaridCargaFamiliar(Boolean activaridCargaFamiliar) {
		this.activaridCargaFamiliar= activaridCargaFamiliar;
	}

	public Border setResaltarid_empresaCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarid_empresaCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCargaFamiliar() {
		return this.resaltarid_empresaCargaFamiliar;
	}

	public void setResaltarid_empresaCargaFamiliar(Border borderResaltar) {
		this.resaltarid_empresaCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarid_empresaCargaFamiliar() {
		return this.mostrarid_empresaCargaFamiliar;
	}

	public void setMostrarid_empresaCargaFamiliar(Boolean mostrarid_empresaCargaFamiliar) {
		this.mostrarid_empresaCargaFamiliar= mostrarid_empresaCargaFamiliar;
	}

	public Boolean getActivarid_empresaCargaFamiliar() {
		return this.activarid_empresaCargaFamiliar;
	}

	public void setActivarid_empresaCargaFamiliar(Boolean activarid_empresaCargaFamiliar) {
		this.activarid_empresaCargaFamiliar= activarid_empresaCargaFamiliar;
	}

	public Boolean getCargarid_empresaCargaFamiliar() {
		return this.cargarid_empresaCargaFamiliar;
	}

	public void setCargarid_empresaCargaFamiliar(Boolean cargarid_empresaCargaFamiliar) {
		this.cargarid_empresaCargaFamiliar= cargarid_empresaCargaFamiliar;
	}

	public Border setResaltarid_clienteCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarid_clienteCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCargaFamiliar() {
		return this.resaltarid_clienteCargaFamiliar;
	}

	public void setResaltarid_clienteCargaFamiliar(Border borderResaltar) {
		this.resaltarid_clienteCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarid_clienteCargaFamiliar() {
		return this.mostrarid_clienteCargaFamiliar;
	}

	public void setMostrarid_clienteCargaFamiliar(Boolean mostrarid_clienteCargaFamiliar) {
		this.mostrarid_clienteCargaFamiliar= mostrarid_clienteCargaFamiliar;
	}

	public Boolean getActivarid_clienteCargaFamiliar() {
		return this.activarid_clienteCargaFamiliar;
	}

	public void setActivarid_clienteCargaFamiliar(Boolean activarid_clienteCargaFamiliar) {
		this.activarid_clienteCargaFamiliar= activarid_clienteCargaFamiliar;
	}

	public Boolean getCargarid_clienteCargaFamiliar() {
		return this.cargarid_clienteCargaFamiliar;
	}

	public void setCargarid_clienteCargaFamiliar(Boolean cargarid_clienteCargaFamiliar) {
		this.cargarid_clienteCargaFamiliar= cargarid_clienteCargaFamiliar;
	}

	public Border setResaltarid_tipo_carga_famiCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarid_tipo_carga_famiCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_carga_famiCargaFamiliar() {
		return this.resaltarid_tipo_carga_famiCargaFamiliar;
	}

	public void setResaltarid_tipo_carga_famiCargaFamiliar(Border borderResaltar) {
		this.resaltarid_tipo_carga_famiCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_carga_famiCargaFamiliar() {
		return this.mostrarid_tipo_carga_famiCargaFamiliar;
	}

	public void setMostrarid_tipo_carga_famiCargaFamiliar(Boolean mostrarid_tipo_carga_famiCargaFamiliar) {
		this.mostrarid_tipo_carga_famiCargaFamiliar= mostrarid_tipo_carga_famiCargaFamiliar;
	}

	public Boolean getActivarid_tipo_carga_famiCargaFamiliar() {
		return this.activarid_tipo_carga_famiCargaFamiliar;
	}

	public void setActivarid_tipo_carga_famiCargaFamiliar(Boolean activarid_tipo_carga_famiCargaFamiliar) {
		this.activarid_tipo_carga_famiCargaFamiliar= activarid_tipo_carga_famiCargaFamiliar;
	}

	public Boolean getCargarid_tipo_carga_famiCargaFamiliar() {
		return this.cargarid_tipo_carga_famiCargaFamiliar;
	}

	public void setCargarid_tipo_carga_famiCargaFamiliar(Boolean cargarid_tipo_carga_famiCargaFamiliar) {
		this.cargarid_tipo_carga_famiCargaFamiliar= cargarid_tipo_carga_famiCargaFamiliar;
	}

	public Border setResaltarid_tipo_generoCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarid_tipo_generoCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_generoCargaFamiliar() {
		return this.resaltarid_tipo_generoCargaFamiliar;
	}

	public void setResaltarid_tipo_generoCargaFamiliar(Border borderResaltar) {
		this.resaltarid_tipo_generoCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_generoCargaFamiliar() {
		return this.mostrarid_tipo_generoCargaFamiliar;
	}

	public void setMostrarid_tipo_generoCargaFamiliar(Boolean mostrarid_tipo_generoCargaFamiliar) {
		this.mostrarid_tipo_generoCargaFamiliar= mostrarid_tipo_generoCargaFamiliar;
	}

	public Boolean getActivarid_tipo_generoCargaFamiliar() {
		return this.activarid_tipo_generoCargaFamiliar;
	}

	public void setActivarid_tipo_generoCargaFamiliar(Boolean activarid_tipo_generoCargaFamiliar) {
		this.activarid_tipo_generoCargaFamiliar= activarid_tipo_generoCargaFamiliar;
	}

	public Boolean getCargarid_tipo_generoCargaFamiliar() {
		return this.cargarid_tipo_generoCargaFamiliar;
	}

	public void setCargarid_tipo_generoCargaFamiliar(Boolean cargarid_tipo_generoCargaFamiliar) {
		this.cargarid_tipo_generoCargaFamiliar= cargarid_tipo_generoCargaFamiliar;
	}

	public Border setResaltarid_estado_civilCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarid_estado_civilCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_civilCargaFamiliar() {
		return this.resaltarid_estado_civilCargaFamiliar;
	}

	public void setResaltarid_estado_civilCargaFamiliar(Border borderResaltar) {
		this.resaltarid_estado_civilCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarid_estado_civilCargaFamiliar() {
		return this.mostrarid_estado_civilCargaFamiliar;
	}

	public void setMostrarid_estado_civilCargaFamiliar(Boolean mostrarid_estado_civilCargaFamiliar) {
		this.mostrarid_estado_civilCargaFamiliar= mostrarid_estado_civilCargaFamiliar;
	}

	public Boolean getActivarid_estado_civilCargaFamiliar() {
		return this.activarid_estado_civilCargaFamiliar;
	}

	public void setActivarid_estado_civilCargaFamiliar(Boolean activarid_estado_civilCargaFamiliar) {
		this.activarid_estado_civilCargaFamiliar= activarid_estado_civilCargaFamiliar;
	}

	public Boolean getCargarid_estado_civilCargaFamiliar() {
		return this.cargarid_estado_civilCargaFamiliar;
	}

	public void setCargarid_estado_civilCargaFamiliar(Boolean cargarid_estado_civilCargaFamiliar) {
		this.cargarid_estado_civilCargaFamiliar= cargarid_estado_civilCargaFamiliar;
	}

	public Border setResaltarcedulaCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarcedulaCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcedulaCargaFamiliar() {
		return this.resaltarcedulaCargaFamiliar;
	}

	public void setResaltarcedulaCargaFamiliar(Border borderResaltar) {
		this.resaltarcedulaCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarcedulaCargaFamiliar() {
		return this.mostrarcedulaCargaFamiliar;
	}

	public void setMostrarcedulaCargaFamiliar(Boolean mostrarcedulaCargaFamiliar) {
		this.mostrarcedulaCargaFamiliar= mostrarcedulaCargaFamiliar;
	}

	public Boolean getActivarcedulaCargaFamiliar() {
		return this.activarcedulaCargaFamiliar;
	}

	public void setActivarcedulaCargaFamiliar(Boolean activarcedulaCargaFamiliar) {
		this.activarcedulaCargaFamiliar= activarcedulaCargaFamiliar;
	}

	public Border setResaltarapellidoCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarapellidoCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCargaFamiliar() {
		return this.resaltarapellidoCargaFamiliar;
	}

	public void setResaltarapellidoCargaFamiliar(Border borderResaltar) {
		this.resaltarapellidoCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarapellidoCargaFamiliar() {
		return this.mostrarapellidoCargaFamiliar;
	}

	public void setMostrarapellidoCargaFamiliar(Boolean mostrarapellidoCargaFamiliar) {
		this.mostrarapellidoCargaFamiliar= mostrarapellidoCargaFamiliar;
	}

	public Boolean getActivarapellidoCargaFamiliar() {
		return this.activarapellidoCargaFamiliar;
	}

	public void setActivarapellidoCargaFamiliar(Boolean activarapellidoCargaFamiliar) {
		this.activarapellidoCargaFamiliar= activarapellidoCargaFamiliar;
	}

	public Border setResaltarnombreCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarnombreCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCargaFamiliar() {
		return this.resaltarnombreCargaFamiliar;
	}

	public void setResaltarnombreCargaFamiliar(Border borderResaltar) {
		this.resaltarnombreCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarnombreCargaFamiliar() {
		return this.mostrarnombreCargaFamiliar;
	}

	public void setMostrarnombreCargaFamiliar(Boolean mostrarnombreCargaFamiliar) {
		this.mostrarnombreCargaFamiliar= mostrarnombreCargaFamiliar;
	}

	public Boolean getActivarnombreCargaFamiliar() {
		return this.activarnombreCargaFamiliar;
	}

	public void setActivarnombreCargaFamiliar(Boolean activarnombreCargaFamiliar) {
		this.activarnombreCargaFamiliar= activarnombreCargaFamiliar;
	}

	public Border setResaltardireccionCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltardireccionCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionCargaFamiliar() {
		return this.resaltardireccionCargaFamiliar;
	}

	public void setResaltardireccionCargaFamiliar(Border borderResaltar) {
		this.resaltardireccionCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrardireccionCargaFamiliar() {
		return this.mostrardireccionCargaFamiliar;
	}

	public void setMostrardireccionCargaFamiliar(Boolean mostrardireccionCargaFamiliar) {
		this.mostrardireccionCargaFamiliar= mostrardireccionCargaFamiliar;
	}

	public Boolean getActivardireccionCargaFamiliar() {
		return this.activardireccionCargaFamiliar;
	}

	public void setActivardireccionCargaFamiliar(Boolean activardireccionCargaFamiliar) {
		this.activardireccionCargaFamiliar= activardireccionCargaFamiliar;
	}

	public Border setResaltarfecha_nacimientoCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoCargaFamiliar() {
		return this.resaltarfecha_nacimientoCargaFamiliar;
	}

	public void setResaltarfecha_nacimientoCargaFamiliar(Border borderResaltar) {
		this.resaltarfecha_nacimientoCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoCargaFamiliar() {
		return this.mostrarfecha_nacimientoCargaFamiliar;
	}

	public void setMostrarfecha_nacimientoCargaFamiliar(Boolean mostrarfecha_nacimientoCargaFamiliar) {
		this.mostrarfecha_nacimientoCargaFamiliar= mostrarfecha_nacimientoCargaFamiliar;
	}

	public Boolean getActivarfecha_nacimientoCargaFamiliar() {
		return this.activarfecha_nacimientoCargaFamiliar;
	}

	public void setActivarfecha_nacimientoCargaFamiliar(Boolean activarfecha_nacimientoCargaFamiliar) {
		this.activarfecha_nacimientoCargaFamiliar= activarfecha_nacimientoCargaFamiliar;
	}

	public Border setResaltarvalor_cupoCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargafamiliarBeanSwingJInternalFrame.jTtoolBarCargaFamiliar.setBorder(borderResaltar);
		
		this.resaltarvalor_cupoCargaFamiliar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_cupoCargaFamiliar() {
		return this.resaltarvalor_cupoCargaFamiliar;
	}

	public void setResaltarvalor_cupoCargaFamiliar(Border borderResaltar) {
		this.resaltarvalor_cupoCargaFamiliar= borderResaltar;
	}

	public Boolean getMostrarvalor_cupoCargaFamiliar() {
		return this.mostrarvalor_cupoCargaFamiliar;
	}

	public void setMostrarvalor_cupoCargaFamiliar(Boolean mostrarvalor_cupoCargaFamiliar) {
		this.mostrarvalor_cupoCargaFamiliar= mostrarvalor_cupoCargaFamiliar;
	}

	public Boolean getActivarvalor_cupoCargaFamiliar() {
		return this.activarvalor_cupoCargaFamiliar;
	}

	public void setActivarvalor_cupoCargaFamiliar(Boolean activarvalor_cupoCargaFamiliar) {
		this.activarvalor_cupoCargaFamiliar= activarvalor_cupoCargaFamiliar;
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
		
		
		this.setMostraridCargaFamiliar(esInicial);
		this.setMostrarid_empresaCargaFamiliar(esInicial);
		this.setMostrarid_clienteCargaFamiliar(esInicial);
		this.setMostrarid_tipo_carga_famiCargaFamiliar(esInicial);
		this.setMostrarid_tipo_generoCargaFamiliar(esInicial);
		this.setMostrarid_estado_civilCargaFamiliar(esInicial);
		this.setMostrarcedulaCargaFamiliar(esInicial);
		this.setMostrarapellidoCargaFamiliar(esInicial);
		this.setMostrarnombreCargaFamiliar(esInicial);
		this.setMostrardireccionCargaFamiliar(esInicial);
		this.setMostrarfecha_nacimientoCargaFamiliar(esInicial);
		this.setMostrarvalor_cupoCargaFamiliar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.ID)) {
				this.setMostraridCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI)) {
				this.setMostrarid_tipo_carga_famiCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDTIPOGENERO)) {
				this.setMostrarid_tipo_generoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDESTADOCIVIL)) {
				this.setMostrarid_estado_civilCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.CEDULA)) {
				this.setMostrarcedulaCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.VALORCUPO)) {
				this.setMostrarvalor_cupoCargaFamiliar(esAsigna);
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
		
		
		this.setActivaridCargaFamiliar(esInicial);
		this.setActivarid_empresaCargaFamiliar(esInicial);
		this.setActivarid_clienteCargaFamiliar(esInicial);
		this.setActivarid_tipo_carga_famiCargaFamiliar(esInicial);
		this.setActivarid_tipo_generoCargaFamiliar(esInicial);
		this.setActivarid_estado_civilCargaFamiliar(esInicial);
		this.setActivarcedulaCargaFamiliar(esInicial);
		this.setActivarapellidoCargaFamiliar(esInicial);
		this.setActivarnombreCargaFamiliar(esInicial);
		this.setActivardireccionCargaFamiliar(esInicial);
		this.setActivarfecha_nacimientoCargaFamiliar(esInicial);
		this.setActivarvalor_cupoCargaFamiliar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.ID)) {
				this.setActivaridCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI)) {
				this.setActivarid_tipo_carga_famiCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDTIPOGENERO)) {
				this.setActivarid_tipo_generoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDESTADOCIVIL)) {
				this.setActivarid_estado_civilCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.CEDULA)) {
				this.setActivarcedulaCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.DIRECCION)) {
				this.setActivardireccionCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.VALORCUPO)) {
				this.setActivarvalor_cupoCargaFamiliar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCargaFamiliar(esInicial);
		this.setResaltarid_empresaCargaFamiliar(esInicial);
		this.setResaltarid_clienteCargaFamiliar(esInicial);
		this.setResaltarid_tipo_carga_famiCargaFamiliar(esInicial);
		this.setResaltarid_tipo_generoCargaFamiliar(esInicial);
		this.setResaltarid_estado_civilCargaFamiliar(esInicial);
		this.setResaltarcedulaCargaFamiliar(esInicial);
		this.setResaltarapellidoCargaFamiliar(esInicial);
		this.setResaltarnombreCargaFamiliar(esInicial);
		this.setResaltardireccionCargaFamiliar(esInicial);
		this.setResaltarfecha_nacimientoCargaFamiliar(esInicial);
		this.setResaltarvalor_cupoCargaFamiliar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.ID)) {
				this.setResaltaridCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI)) {
				this.setResaltarid_tipo_carga_famiCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDTIPOGENERO)) {
				this.setResaltarid_tipo_generoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.IDESTADOCIVIL)) {
				this.setResaltarid_estado_civilCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.CEDULA)) {
				this.setResaltarcedulaCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoCargaFamiliar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargaFamiliarConstantesFunciones.VALORCUPO)) {
				this.setResaltarvalor_cupoCargaFamiliar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteCargaFamiliar=true;

	public Boolean getMostrarFK_IdClienteCargaFamiliar() {
		return this.mostrarFK_IdClienteCargaFamiliar;
	}

	public void setMostrarFK_IdClienteCargaFamiliar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteCargaFamiliar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCargaFamiliar=true;

	public Boolean getMostrarFK_IdEmpresaCargaFamiliar() {
		return this.mostrarFK_IdEmpresaCargaFamiliar;
	}

	public void setMostrarFK_IdEmpresaCargaFamiliar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCargaFamiliar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCivilCargaFamiliar=true;

	public Boolean getMostrarFK_IdEstadoCivilCargaFamiliar() {
		return this.mostrarFK_IdEstadoCivilCargaFamiliar;
	}

	public void setMostrarFK_IdEstadoCivilCargaFamiliar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCivilCargaFamiliar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCargaFamiCargaFamiliar=true;

	public Boolean getMostrarFK_IdTipoCargaFamiCargaFamiliar() {
		return this.mostrarFK_IdTipoCargaFamiCargaFamiliar;
	}

	public void setMostrarFK_IdTipoCargaFamiCargaFamiliar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCargaFamiCargaFamiliar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGeneroCargaFamiliar=true;

	public Boolean getMostrarFK_IdTipoGeneroCargaFamiliar() {
		return this.mostrarFK_IdTipoGeneroCargaFamiliar;
	}

	public void setMostrarFK_IdTipoGeneroCargaFamiliar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGeneroCargaFamiliar= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteCargaFamiliar=true;

	public Boolean getActivarFK_IdClienteCargaFamiliar() {
		return this.activarFK_IdClienteCargaFamiliar;
	}

	public void setActivarFK_IdClienteCargaFamiliar(Boolean habilitarResaltar) {
		this.activarFK_IdClienteCargaFamiliar= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCargaFamiliar=true;

	public Boolean getActivarFK_IdEmpresaCargaFamiliar() {
		return this.activarFK_IdEmpresaCargaFamiliar;
	}

	public void setActivarFK_IdEmpresaCargaFamiliar(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCargaFamiliar= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCivilCargaFamiliar=true;

	public Boolean getActivarFK_IdEstadoCivilCargaFamiliar() {
		return this.activarFK_IdEstadoCivilCargaFamiliar;
	}

	public void setActivarFK_IdEstadoCivilCargaFamiliar(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCivilCargaFamiliar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCargaFamiCargaFamiliar=true;

	public Boolean getActivarFK_IdTipoCargaFamiCargaFamiliar() {
		return this.activarFK_IdTipoCargaFamiCargaFamiliar;
	}

	public void setActivarFK_IdTipoCargaFamiCargaFamiliar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCargaFamiCargaFamiliar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGeneroCargaFamiliar=true;

	public Boolean getActivarFK_IdTipoGeneroCargaFamiliar() {
		return this.activarFK_IdTipoGeneroCargaFamiliar;
	}

	public void setActivarFK_IdTipoGeneroCargaFamiliar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGeneroCargaFamiliar= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteCargaFamiliar=null;

	public Border getResaltarFK_IdClienteCargaFamiliar() {
		return this.resaltarFK_IdClienteCargaFamiliar;
	}

	public void setResaltarFK_IdClienteCargaFamiliar(Border borderResaltar) {
		this.resaltarFK_IdClienteCargaFamiliar= borderResaltar;
	}

	public void setResaltarFK_IdClienteCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteCargaFamiliar= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCargaFamiliar=null;

	public Border getResaltarFK_IdEmpresaCargaFamiliar() {
		return this.resaltarFK_IdEmpresaCargaFamiliar;
	}

	public void setResaltarFK_IdEmpresaCargaFamiliar(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCargaFamiliar= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCargaFamiliar= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCivilCargaFamiliar=null;

	public Border getResaltarFK_IdEstadoCivilCargaFamiliar() {
		return this.resaltarFK_IdEstadoCivilCargaFamiliar;
	}

	public void setResaltarFK_IdEstadoCivilCargaFamiliar(Border borderResaltar) {
		this.resaltarFK_IdEstadoCivilCargaFamiliar= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCivilCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCivilCargaFamiliar= borderResaltar;
	}

	public Border resaltarFK_IdTipoCargaFamiCargaFamiliar=null;

	public Border getResaltarFK_IdTipoCargaFamiCargaFamiliar() {
		return this.resaltarFK_IdTipoCargaFamiCargaFamiliar;
	}

	public void setResaltarFK_IdTipoCargaFamiCargaFamiliar(Border borderResaltar) {
		this.resaltarFK_IdTipoCargaFamiCargaFamiliar= borderResaltar;
	}

	public void setResaltarFK_IdTipoCargaFamiCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCargaFamiCargaFamiliar= borderResaltar;
	}

	public Border resaltarFK_IdTipoGeneroCargaFamiliar=null;

	public Border getResaltarFK_IdTipoGeneroCargaFamiliar() {
		return this.resaltarFK_IdTipoGeneroCargaFamiliar;
	}

	public void setResaltarFK_IdTipoGeneroCargaFamiliar(Border borderResaltar) {
		this.resaltarFK_IdTipoGeneroCargaFamiliar= borderResaltar;
	}

	public void setResaltarFK_IdTipoGeneroCargaFamiliar(ParametroGeneralUsuario parametroGeneralUsuario/*CargaFamiliarBeanSwingJInternalFrame cargafamiliarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGeneroCargaFamiliar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}