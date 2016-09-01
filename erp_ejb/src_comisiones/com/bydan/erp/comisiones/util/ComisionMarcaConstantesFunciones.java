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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.ComisionMarcaConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionMarcaParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionMarcaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComisionMarcaConstantesFunciones extends ComisionMarcaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionMarca";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionMarca"+ComisionMarcaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionMarcaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionMarcaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionMarcaConstantesFunciones.SCHEMA+"_"+ComisionMarcaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionMarcaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionMarcaConstantesFunciones.SCHEMA+"_"+ComisionMarcaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionMarcaConstantesFunciones.SCHEMA+"_"+ComisionMarcaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionMarcaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionMarcaConstantesFunciones.SCHEMA+"_"+ComisionMarcaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionMarcaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionMarcaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionMarcaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionMarcaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionMarcaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionMarcaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionMarcaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionMarcaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionMarcaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionMarcaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comision Marcas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comision Marca";
	public static final String SCLASSWEBTITULO_LOWER="Comision Marca";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionMarca";
	public static final String OBJECTNAME="comisionmarca";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_marca";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisionmarca from "+ComisionMarcaConstantesFunciones.SPERSISTENCENAME+" comisionmarca";
	public static String QUERYSELECTNATIVE="select "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".version_row,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_empresa,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea_grupo,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea_categoria,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea_marca,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_estado_comision,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".porcentaje,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".descripcion from "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME;//+" as "+ComisionMarcaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionMarcaConstantesFuncionesAdditional comisionmarcaConstantesFuncionesAdditional=null;
	
	public ComisionMarcaConstantesFuncionesAdditional getComisionMarcaConstantesFuncionesAdditional() {
		return this.comisionmarcaConstantesFuncionesAdditional;
	}
	
	public void setComisionMarcaConstantesFuncionesAdditional(ComisionMarcaConstantesFuncionesAdditional comisionmarcaConstantesFuncionesAdditional) {
		try {
			this.comisionmarcaConstantesFuncionesAdditional=comisionmarcaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCOMISIONCONFIG= "id_comision_config";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDESTADOCOMISION= "id_estado_comision";
    public static final String PORCENTAJE= "porcentaje";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCOMISIONCONFIG= "Configuracion";
		public static final String LABEL_IDCOMISIONCONFIG_LOWER= "Comision Config";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_IDESTADOCOMISION= "Estado";
		public static final String LABEL_IDESTADOCOMISION_LOWER= "Estado Comision";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComisionMarcaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDCOMISIONCONFIG;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDLINEA)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.IDESTADOCOMISION)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_IDESTADOCOMISION;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.PORCENTAJE)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ComisionMarcaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ComisionMarcaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComisionMarcaDescripcion(ComisionMarca comisionmarca) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisionmarca !=null/* && comisionmarca.getId()!=0*/) {
			if(comisionmarca.getId()!=null) {
				sDescripcion=comisionmarca.getId().toString();
			}//comisionmarcacomisionmarca.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionMarcaDescripcionDetallado(ComisionMarca comisionmarca) {
		String sDescripcion="";
			
		sDescripcion+=ComisionMarcaConstantesFunciones.ID+"=";
		sDescripcion+=comisionmarca.getId().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisionmarca.getVersionRow().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisionmarca.getid_empresa().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG+"=";
		sDescripcion+=comisionmarca.getid_comision_config().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=comisionmarca.getid_vendedor().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=comisionmarca.getid_linea().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=comisionmarca.getid_linea_grupo().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=comisionmarca.getid_linea_categoria().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=comisionmarca.getid_linea_marca().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.IDESTADOCOMISION+"=";
		sDescripcion+=comisionmarca.getid_estado_comision().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=comisionmarca.getporcentaje().toString()+",";
		sDescripcion+=ComisionMarcaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=comisionmarca.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionMarcaDescripcion(ComisionMarca comisionmarca,String sValor) throws Exception {			
		if(comisionmarca !=null) {
			//comisionmarcacomisionmarca.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getComisionConfigDescripcion(ComisionConfig comisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(comisionconfig!=null/*&&comisionconfig.getId()>0*/) {
			sDescripcion=ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionconfig);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getEstadoComisionDescripcion(EstadoComision estadocomision) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocomision!=null/*&&estadocomision.getId()>0*/) {
			sDescripcion=EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(estadocomision);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdComisionConfig")) {
			sNombreIndice="Tipo=  Por Configuracion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoComision")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdComisionConfig(Long id_comision_config) {
		String sDetalleIndice=" Parametros->";
		if(id_comision_config!=null) {sDetalleIndice+=" Codigo Unico De Configuracion="+id_comision_config.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoComision(Long id_estado_comision) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_comision!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_comision.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComisionMarca(ComisionMarca comisionmarca,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisionmarca.setdescripcion(comisionmarca.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComisionMarcas(List<ComisionMarca> comisionmarcas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionMarca comisionmarca: comisionmarcas) {
			comisionmarca.setdescripcion(comisionmarca.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionMarca(ComisionMarca comisionmarca,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisionmarca.getConCambioAuxiliar()) {
			comisionmarca.setIsDeleted(comisionmarca.getIsDeletedAuxiliar());	
			comisionmarca.setIsNew(comisionmarca.getIsNewAuxiliar());	
			comisionmarca.setIsChanged(comisionmarca.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisionmarca.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisionmarca.setIsDeletedAuxiliar(false);	
			comisionmarca.setIsNewAuxiliar(false);	
			comisionmarca.setIsChangedAuxiliar(false);
			
			comisionmarca.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionMarcas(List<ComisionMarca> comisionmarcas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionMarca comisionmarca : comisionmarcas) {
			if(conAsignarBase && comisionmarca.getConCambioAuxiliar()) {
				comisionmarca.setIsDeleted(comisionmarca.getIsDeletedAuxiliar());	
				comisionmarca.setIsNew(comisionmarca.getIsNewAuxiliar());	
				comisionmarca.setIsChanged(comisionmarca.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisionmarca.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisionmarca.setIsDeletedAuxiliar(false);	
				comisionmarca.setIsNewAuxiliar(false);	
				comisionmarca.setIsChangedAuxiliar(false);
				
				comisionmarca.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionMarca(ComisionMarca comisionmarca,Boolean conEnteros) throws Exception  {
		comisionmarca.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComisionMarcas(List<ComisionMarca> comisionmarcas,Boolean conEnteros) throws Exception  {
		
		for(ComisionMarca comisionmarca: comisionmarcas) {
			comisionmarca.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionMarca(List<ComisionMarca> comisionmarcas,ComisionMarca comisionmarcaAux) throws Exception  {
		ComisionMarcaConstantesFunciones.InicializarValoresComisionMarca(comisionmarcaAux,true);
		
		for(ComisionMarca comisionmarca: comisionmarcas) {
			if(comisionmarca.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisionmarcaAux.setporcentaje(comisionmarcaAux.getporcentaje()+comisionmarca.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionMarca(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionMarcaConstantesFunciones.getArrayColumnasGlobalesComisionMarca(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionMarca(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionMarcaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionMarcaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionMarca(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionMarca> comisionmarcas,ComisionMarca comisionmarca,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionMarca comisionmarcaAux: comisionmarcas) {
			if(comisionmarcaAux!=null && comisionmarca!=null) {
				if((comisionmarcaAux.getId()==null && comisionmarca.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisionmarcaAux.getId()!=null && comisionmarca.getId()!=null){
					if(comisionmarcaAux.getId().equals(comisionmarca.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionMarca(List<ComisionMarca> comisionmarcas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ComisionMarca comisionmarca: comisionmarcas) {			
			if(comisionmarca.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=comisionmarca.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionMarcaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionMarca() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_ID, ComisionMarcaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_VERSIONROW, ComisionMarcaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDEMPRESA, ComisionMarcaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDCOMISIONCONFIG, ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDVENDEDOR, ComisionMarcaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDLINEA, ComisionMarcaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDLINEAGRUPO, ComisionMarcaConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDLINEACATEGORIA, ComisionMarcaConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDLINEAMARCA, ComisionMarcaConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_IDESTADOCOMISION, ComisionMarcaConstantesFunciones.IDESTADOCOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_PORCENTAJE, ComisionMarcaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionMarcaConstantesFunciones.LABEL_DESCRIPCION, ComisionMarcaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionMarca() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.IDESTADOCOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionMarcaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionMarca() throws Exception  {
		return ComisionMarcaConstantesFunciones.getTiposSeleccionarComisionMarca(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionMarca(Boolean conFk) throws Exception  {
		return ComisionMarcaConstantesFunciones.getTiposSeleccionarComisionMarca(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionMarca(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDCOMISIONCONFIG);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDCOMISIONCONFIG);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_IDESTADOCOMISION);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_IDESTADOCOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionMarcaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ComisionMarcaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionMarca(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionMarca(ComisionMarca comisionmarcaAux) throws Exception {
		
			comisionmarcaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionmarcaAux.getEmpresa()));
			comisionmarcaAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionmarcaAux.getComisionConfig()));
			comisionmarcaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisionmarcaAux.getVendedor()));
			comisionmarcaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLinea()));
			comisionmarcaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLineaGrupo()));
			comisionmarcaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLineaCategoria()));
			comisionmarcaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLineaMarca()));
			comisionmarcaAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisionmarcaAux.getEstadoComision()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionMarca(List<ComisionMarca> comisionmarcasTemp) throws Exception {
		for(ComisionMarca comisionmarcaAux:comisionmarcasTemp) {
			
			comisionmarcaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionmarcaAux.getEmpresa()));
			comisionmarcaAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionmarcaAux.getComisionConfig()));
			comisionmarcaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisionmarcaAux.getVendedor()));
			comisionmarcaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLinea()));
			comisionmarcaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLineaGrupo()));
			comisionmarcaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLineaCategoria()));
			comisionmarcaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisionmarcaAux.getLineaMarca()));
			comisionmarcaAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisionmarcaAux.getEstadoComision()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionMarca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(ComisionConfig.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(EstadoComision.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionConfig.class)) {
						classes.add(new Classe(ComisionConfig.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoComision.class)) {
						classes.add(new Classe(EstadoComision.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionMarca(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(EstadoComision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoComision.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(EstadoComision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoComision.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionMarca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionMarcaConstantesFunciones.getClassesRelationshipsOfComisionMarca(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionMarca(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionMarca(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionMarcaConstantesFunciones.getClassesRelationshipsFromStringsOfComisionMarca(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionMarca(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComisionMarca comisionmarca,List<ComisionMarca> comisionmarcas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionMarca comisionmarcaEncontrado=null;
			
			for(ComisionMarca comisionmarcaLocal:comisionmarcas) {
				if(comisionmarcaLocal.getId().equals(comisionmarca.getId())) {
					comisionmarcaEncontrado=comisionmarcaLocal;
					
					comisionmarcaLocal.setIsChanged(comisionmarca.getIsChanged());
					comisionmarcaLocal.setIsNew(comisionmarca.getIsNew());
					comisionmarcaLocal.setIsDeleted(comisionmarca.getIsDeleted());
					
					comisionmarcaLocal.setGeneralEntityOriginal(comisionmarca.getGeneralEntityOriginal());
					
					comisionmarcaLocal.setId(comisionmarca.getId());	
					comisionmarcaLocal.setVersionRow(comisionmarca.getVersionRow());	
					comisionmarcaLocal.setid_empresa(comisionmarca.getid_empresa());	
					comisionmarcaLocal.setid_comision_config(comisionmarca.getid_comision_config());	
					comisionmarcaLocal.setid_vendedor(comisionmarca.getid_vendedor());	
					comisionmarcaLocal.setid_linea(comisionmarca.getid_linea());	
					comisionmarcaLocal.setid_linea_grupo(comisionmarca.getid_linea_grupo());	
					comisionmarcaLocal.setid_linea_categoria(comisionmarca.getid_linea_categoria());	
					comisionmarcaLocal.setid_linea_marca(comisionmarca.getid_linea_marca());	
					comisionmarcaLocal.setid_estado_comision(comisionmarca.getid_estado_comision());	
					comisionmarcaLocal.setporcentaje(comisionmarca.getporcentaje());	
					comisionmarcaLocal.setdescripcion(comisionmarca.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisionmarca.getIsDeleted()) {
				if(!existe) {
					comisionmarcas.add(comisionmarca);
				}
			} else {
				if(comisionmarcaEncontrado!=null && permiteQuitar)  {
					comisionmarcas.remove(comisionmarcaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionMarca comisionmarca,List<ComisionMarca> comisionmarcas) throws Exception {
		try	{			
			for(ComisionMarca comisionmarcaLocal:comisionmarcas) {
				if(comisionmarcaLocal.getId().equals(comisionmarca.getId())) {
					comisionmarcaLocal.setIsSelected(comisionmarca.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionMarca(List<ComisionMarca> comisionmarcasAux) throws Exception {
		//this.comisionmarcasAux=comisionmarcasAux;
		
		for(ComisionMarca comisionmarcaAux:comisionmarcasAux) {
			if(comisionmarcaAux.getIsChanged()) {
				comisionmarcaAux.setIsChanged(false);
			}		
			
			if(comisionmarcaAux.getIsNew()) {
				comisionmarcaAux.setIsNew(false);
			}	
			
			if(comisionmarcaAux.getIsDeleted()) {
				comisionmarcaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionMarca(ComisionMarca comisionmarcaAux) throws Exception {
		//this.comisionmarcaAux=comisionmarcaAux;
		
			if(comisionmarcaAux.getIsChanged()) {
				comisionmarcaAux.setIsChanged(false);
			}		
			
			if(comisionmarcaAux.getIsNew()) {
				comisionmarcaAux.setIsNew(false);
			}	
			
			if(comisionmarcaAux.getIsDeleted()) {
				comisionmarcaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionMarca comisionmarcaAsignar,ComisionMarca comisionmarca) throws Exception {
		comisionmarcaAsignar.setId(comisionmarca.getId());	
		comisionmarcaAsignar.setVersionRow(comisionmarca.getVersionRow());	
		comisionmarcaAsignar.setid_empresa(comisionmarca.getid_empresa());
		comisionmarcaAsignar.setempresa_descripcion(comisionmarca.getempresa_descripcion());	
		comisionmarcaAsignar.setid_comision_config(comisionmarca.getid_comision_config());
		comisionmarcaAsignar.setcomisionconfig_descripcion(comisionmarca.getcomisionconfig_descripcion());	
		comisionmarcaAsignar.setid_vendedor(comisionmarca.getid_vendedor());
		comisionmarcaAsignar.setvendedor_descripcion(comisionmarca.getvendedor_descripcion());	
		comisionmarcaAsignar.setid_linea(comisionmarca.getid_linea());
		comisionmarcaAsignar.setlinea_descripcion(comisionmarca.getlinea_descripcion());	
		comisionmarcaAsignar.setid_linea_grupo(comisionmarca.getid_linea_grupo());
		comisionmarcaAsignar.setlineagrupo_descripcion(comisionmarca.getlineagrupo_descripcion());	
		comisionmarcaAsignar.setid_linea_categoria(comisionmarca.getid_linea_categoria());
		comisionmarcaAsignar.setlineacategoria_descripcion(comisionmarca.getlineacategoria_descripcion());	
		comisionmarcaAsignar.setid_linea_marca(comisionmarca.getid_linea_marca());
		comisionmarcaAsignar.setlineamarca_descripcion(comisionmarca.getlineamarca_descripcion());	
		comisionmarcaAsignar.setid_estado_comision(comisionmarca.getid_estado_comision());
		comisionmarcaAsignar.setestadocomision_descripcion(comisionmarca.getestadocomision_descripcion());	
		comisionmarcaAsignar.setporcentaje(comisionmarca.getporcentaje());	
		comisionmarcaAsignar.setdescripcion(comisionmarca.getdescripcion());	
	}
	
	public static void inicializarComisionMarca(ComisionMarca comisionmarca) throws Exception {
		try {
				comisionmarca.setId(0L);	
					
				comisionmarca.setid_empresa(-1L);	
				comisionmarca.setid_comision_config(-1L);	
				comisionmarca.setid_vendedor(-1L);	
				comisionmarca.setid_linea(-1L);	
				comisionmarca.setid_linea_grupo(-1L);	
				comisionmarca.setid_linea_categoria(-1L);	
				comisionmarca.setid_linea_marca(-1L);	
				comisionmarca.setid_estado_comision(-1L);	
				comisionmarca.setporcentaje(0.0);	
				comisionmarca.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionMarca(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDCOMISIONCONFIG);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_IDESTADOCOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionMarcaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionMarca(String sTipo,Row row,Workbook workbook,ComisionMarca comisionmarca,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getcomisionconfig_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getestadocomision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionmarca.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionMarca=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionMarca() {
		return this.sFinalQueryComisionMarca;
	}
	
	public void setsFinalQueryComisionMarca(String sFinalQueryComisionMarca) {
		this.sFinalQueryComisionMarca= sFinalQueryComisionMarca;
	}
	
	public Border resaltarSeleccionarComisionMarca=null;
	
	public Border setResaltarSeleccionarComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionMarca= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionMarca() {
		return this.resaltarSeleccionarComisionMarca;
	}
	
	public void setResaltarSeleccionarComisionMarca(Border borderResaltarSeleccionarComisionMarca) {
		this.resaltarSeleccionarComisionMarca= borderResaltarSeleccionarComisionMarca;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionMarca=null;
	public Boolean mostraridComisionMarca=true;
	public Boolean activaridComisionMarca=true;

	public Border resaltarid_empresaComisionMarca=null;
	public Boolean mostrarid_empresaComisionMarca=true;
	public Boolean activarid_empresaComisionMarca=true;
	public Boolean cargarid_empresaComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionMarca=false;//ConEventDepend=true

	public Border resaltarid_comision_configComisionMarca=null;
	public Boolean mostrarid_comision_configComisionMarca=true;
	public Boolean activarid_comision_configComisionMarca=true;
	public Boolean cargarid_comision_configComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_comision_configComisionMarca=false;//ConEventDepend=true

	public Border resaltarid_vendedorComisionMarca=null;
	public Boolean mostrarid_vendedorComisionMarca=true;
	public Boolean activarid_vendedorComisionMarca=true;
	public Boolean cargarid_vendedorComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorComisionMarca=false;//ConEventDepend=true

	public Border resaltarid_lineaComisionMarca=null;
	public Boolean mostrarid_lineaComisionMarca=true;
	public Boolean activarid_lineaComisionMarca=true;
	public Boolean cargarid_lineaComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaComisionMarca=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoComisionMarca=null;
	public Boolean mostrarid_linea_grupoComisionMarca=true;
	public Boolean activarid_linea_grupoComisionMarca=true;
	public Boolean cargarid_linea_grupoComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoComisionMarca=true;//ConEventDepend=true

	public Border resaltarid_linea_categoriaComisionMarca=null;
	public Boolean mostrarid_linea_categoriaComisionMarca=true;
	public Boolean activarid_linea_categoriaComisionMarca=true;
	public Boolean cargarid_linea_categoriaComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaComisionMarca=true;//ConEventDepend=true

	public Border resaltarid_linea_marcaComisionMarca=null;
	public Boolean mostrarid_linea_marcaComisionMarca=true;
	public Boolean activarid_linea_marcaComisionMarca=true;
	public Boolean cargarid_linea_marcaComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaComisionMarca=true;//ConEventDepend=true

	public Border resaltarid_estado_comisionComisionMarca=null;
	public Boolean mostrarid_estado_comisionComisionMarca=true;
	public Boolean activarid_estado_comisionComisionMarca=true;
	public Boolean cargarid_estado_comisionComisionMarca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_comisionComisionMarca=false;//ConEventDepend=true

	public Border resaltarporcentajeComisionMarca=null;
	public Boolean mostrarporcentajeComisionMarca=true;
	public Boolean activarporcentajeComisionMarca=true;

	public Border resaltardescripcionComisionMarca=null;
	public Boolean mostrardescripcionComisionMarca=true;
	public Boolean activardescripcionComisionMarca=true;

	
	

	public Border setResaltaridComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltaridComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionMarca() {
		return this.resaltaridComisionMarca;
	}

	public void setResaltaridComisionMarca(Border borderResaltar) {
		this.resaltaridComisionMarca= borderResaltar;
	}

	public Boolean getMostraridComisionMarca() {
		return this.mostraridComisionMarca;
	}

	public void setMostraridComisionMarca(Boolean mostraridComisionMarca) {
		this.mostraridComisionMarca= mostraridComisionMarca;
	}

	public Boolean getActivaridComisionMarca() {
		return this.activaridComisionMarca;
	}

	public void setActivaridComisionMarca(Boolean activaridComisionMarca) {
		this.activaridComisionMarca= activaridComisionMarca;
	}

	public Border setResaltarid_empresaComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionMarca() {
		return this.resaltarid_empresaComisionMarca;
	}

	public void setResaltarid_empresaComisionMarca(Border borderResaltar) {
		this.resaltarid_empresaComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionMarca() {
		return this.mostrarid_empresaComisionMarca;
	}

	public void setMostrarid_empresaComisionMarca(Boolean mostrarid_empresaComisionMarca) {
		this.mostrarid_empresaComisionMarca= mostrarid_empresaComisionMarca;
	}

	public Boolean getActivarid_empresaComisionMarca() {
		return this.activarid_empresaComisionMarca;
	}

	public void setActivarid_empresaComisionMarca(Boolean activarid_empresaComisionMarca) {
		this.activarid_empresaComisionMarca= activarid_empresaComisionMarca;
	}

	public Boolean getCargarid_empresaComisionMarca() {
		return this.cargarid_empresaComisionMarca;
	}

	public void setCargarid_empresaComisionMarca(Boolean cargarid_empresaComisionMarca) {
		this.cargarid_empresaComisionMarca= cargarid_empresaComisionMarca;
	}

	public Border setResaltarid_comision_configComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_comision_configComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_comision_configComisionMarca() {
		return this.resaltarid_comision_configComisionMarca;
	}

	public void setResaltarid_comision_configComisionMarca(Border borderResaltar) {
		this.resaltarid_comision_configComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_comision_configComisionMarca() {
		return this.mostrarid_comision_configComisionMarca;
	}

	public void setMostrarid_comision_configComisionMarca(Boolean mostrarid_comision_configComisionMarca) {
		this.mostrarid_comision_configComisionMarca= mostrarid_comision_configComisionMarca;
	}

	public Boolean getActivarid_comision_configComisionMarca() {
		return this.activarid_comision_configComisionMarca;
	}

	public void setActivarid_comision_configComisionMarca(Boolean activarid_comision_configComisionMarca) {
		this.activarid_comision_configComisionMarca= activarid_comision_configComisionMarca;
	}

	public Boolean getCargarid_comision_configComisionMarca() {
		return this.cargarid_comision_configComisionMarca;
	}

	public void setCargarid_comision_configComisionMarca(Boolean cargarid_comision_configComisionMarca) {
		this.cargarid_comision_configComisionMarca= cargarid_comision_configComisionMarca;
	}

	public Border setResaltarid_vendedorComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_vendedorComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorComisionMarca() {
		return this.resaltarid_vendedorComisionMarca;
	}

	public void setResaltarid_vendedorComisionMarca(Border borderResaltar) {
		this.resaltarid_vendedorComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_vendedorComisionMarca() {
		return this.mostrarid_vendedorComisionMarca;
	}

	public void setMostrarid_vendedorComisionMarca(Boolean mostrarid_vendedorComisionMarca) {
		this.mostrarid_vendedorComisionMarca= mostrarid_vendedorComisionMarca;
	}

	public Boolean getActivarid_vendedorComisionMarca() {
		return this.activarid_vendedorComisionMarca;
	}

	public void setActivarid_vendedorComisionMarca(Boolean activarid_vendedorComisionMarca) {
		this.activarid_vendedorComisionMarca= activarid_vendedorComisionMarca;
	}

	public Boolean getCargarid_vendedorComisionMarca() {
		return this.cargarid_vendedorComisionMarca;
	}

	public void setCargarid_vendedorComisionMarca(Boolean cargarid_vendedorComisionMarca) {
		this.cargarid_vendedorComisionMarca= cargarid_vendedorComisionMarca;
	}

	public Border setResaltarid_lineaComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_lineaComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaComisionMarca() {
		return this.resaltarid_lineaComisionMarca;
	}

	public void setResaltarid_lineaComisionMarca(Border borderResaltar) {
		this.resaltarid_lineaComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_lineaComisionMarca() {
		return this.mostrarid_lineaComisionMarca;
	}

	public void setMostrarid_lineaComisionMarca(Boolean mostrarid_lineaComisionMarca) {
		this.mostrarid_lineaComisionMarca= mostrarid_lineaComisionMarca;
	}

	public Boolean getActivarid_lineaComisionMarca() {
		return this.activarid_lineaComisionMarca;
	}

	public void setActivarid_lineaComisionMarca(Boolean activarid_lineaComisionMarca) {
		this.activarid_lineaComisionMarca= activarid_lineaComisionMarca;
	}

	public Boolean getCargarid_lineaComisionMarca() {
		return this.cargarid_lineaComisionMarca;
	}

	public void setCargarid_lineaComisionMarca(Boolean cargarid_lineaComisionMarca) {
		this.cargarid_lineaComisionMarca= cargarid_lineaComisionMarca;
	}

	public Border setResaltarid_linea_grupoComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoComisionMarca() {
		return this.resaltarid_linea_grupoComisionMarca;
	}

	public void setResaltarid_linea_grupoComisionMarca(Border borderResaltar) {
		this.resaltarid_linea_grupoComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoComisionMarca() {
		return this.mostrarid_linea_grupoComisionMarca;
	}

	public void setMostrarid_linea_grupoComisionMarca(Boolean mostrarid_linea_grupoComisionMarca) {
		this.mostrarid_linea_grupoComisionMarca= mostrarid_linea_grupoComisionMarca;
	}

	public Boolean getActivarid_linea_grupoComisionMarca() {
		return this.activarid_linea_grupoComisionMarca;
	}

	public void setActivarid_linea_grupoComisionMarca(Boolean activarid_linea_grupoComisionMarca) {
		this.activarid_linea_grupoComisionMarca= activarid_linea_grupoComisionMarca;
	}

	public Boolean getCargarid_linea_grupoComisionMarca() {
		return this.cargarid_linea_grupoComisionMarca;
	}

	public void setCargarid_linea_grupoComisionMarca(Boolean cargarid_linea_grupoComisionMarca) {
		this.cargarid_linea_grupoComisionMarca= cargarid_linea_grupoComisionMarca;
	}

	public Border setResaltarid_linea_categoriaComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaComisionMarca() {
		return this.resaltarid_linea_categoriaComisionMarca;
	}

	public void setResaltarid_linea_categoriaComisionMarca(Border borderResaltar) {
		this.resaltarid_linea_categoriaComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaComisionMarca() {
		return this.mostrarid_linea_categoriaComisionMarca;
	}

	public void setMostrarid_linea_categoriaComisionMarca(Boolean mostrarid_linea_categoriaComisionMarca) {
		this.mostrarid_linea_categoriaComisionMarca= mostrarid_linea_categoriaComisionMarca;
	}

	public Boolean getActivarid_linea_categoriaComisionMarca() {
		return this.activarid_linea_categoriaComisionMarca;
	}

	public void setActivarid_linea_categoriaComisionMarca(Boolean activarid_linea_categoriaComisionMarca) {
		this.activarid_linea_categoriaComisionMarca= activarid_linea_categoriaComisionMarca;
	}

	public Boolean getCargarid_linea_categoriaComisionMarca() {
		return this.cargarid_linea_categoriaComisionMarca;
	}

	public void setCargarid_linea_categoriaComisionMarca(Boolean cargarid_linea_categoriaComisionMarca) {
		this.cargarid_linea_categoriaComisionMarca= cargarid_linea_categoriaComisionMarca;
	}

	public Border setResaltarid_linea_marcaComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaComisionMarca() {
		return this.resaltarid_linea_marcaComisionMarca;
	}

	public void setResaltarid_linea_marcaComisionMarca(Border borderResaltar) {
		this.resaltarid_linea_marcaComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaComisionMarca() {
		return this.mostrarid_linea_marcaComisionMarca;
	}

	public void setMostrarid_linea_marcaComisionMarca(Boolean mostrarid_linea_marcaComisionMarca) {
		this.mostrarid_linea_marcaComisionMarca= mostrarid_linea_marcaComisionMarca;
	}

	public Boolean getActivarid_linea_marcaComisionMarca() {
		return this.activarid_linea_marcaComisionMarca;
	}

	public void setActivarid_linea_marcaComisionMarca(Boolean activarid_linea_marcaComisionMarca) {
		this.activarid_linea_marcaComisionMarca= activarid_linea_marcaComisionMarca;
	}

	public Boolean getCargarid_linea_marcaComisionMarca() {
		return this.cargarid_linea_marcaComisionMarca;
	}

	public void setCargarid_linea_marcaComisionMarca(Boolean cargarid_linea_marcaComisionMarca) {
		this.cargarid_linea_marcaComisionMarca= cargarid_linea_marcaComisionMarca;
	}

	public Border setResaltarid_estado_comisionComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarid_estado_comisionComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_comisionComisionMarca() {
		return this.resaltarid_estado_comisionComisionMarca;
	}

	public void setResaltarid_estado_comisionComisionMarca(Border borderResaltar) {
		this.resaltarid_estado_comisionComisionMarca= borderResaltar;
	}

	public Boolean getMostrarid_estado_comisionComisionMarca() {
		return this.mostrarid_estado_comisionComisionMarca;
	}

	public void setMostrarid_estado_comisionComisionMarca(Boolean mostrarid_estado_comisionComisionMarca) {
		this.mostrarid_estado_comisionComisionMarca= mostrarid_estado_comisionComisionMarca;
	}

	public Boolean getActivarid_estado_comisionComisionMarca() {
		return this.activarid_estado_comisionComisionMarca;
	}

	public void setActivarid_estado_comisionComisionMarca(Boolean activarid_estado_comisionComisionMarca) {
		this.activarid_estado_comisionComisionMarca= activarid_estado_comisionComisionMarca;
	}

	public Boolean getCargarid_estado_comisionComisionMarca() {
		return this.cargarid_estado_comisionComisionMarca;
	}

	public void setCargarid_estado_comisionComisionMarca(Boolean cargarid_estado_comisionComisionMarca) {
		this.cargarid_estado_comisionComisionMarca= cargarid_estado_comisionComisionMarca;
	}

	public Border setResaltarporcentajeComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltarporcentajeComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeComisionMarca() {
		return this.resaltarporcentajeComisionMarca;
	}

	public void setResaltarporcentajeComisionMarca(Border borderResaltar) {
		this.resaltarporcentajeComisionMarca= borderResaltar;
	}

	public Boolean getMostrarporcentajeComisionMarca() {
		return this.mostrarporcentajeComisionMarca;
	}

	public void setMostrarporcentajeComisionMarca(Boolean mostrarporcentajeComisionMarca) {
		this.mostrarporcentajeComisionMarca= mostrarporcentajeComisionMarca;
	}

	public Boolean getActivarporcentajeComisionMarca() {
		return this.activarporcentajeComisionMarca;
	}

	public void setActivarporcentajeComisionMarca(Boolean activarporcentajeComisionMarca) {
		this.activarporcentajeComisionMarca= activarporcentajeComisionMarca;
	}

	public Border setResaltardescripcionComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionmarcaBeanSwingJInternalFrame.jTtoolBarComisionMarca.setBorder(borderResaltar);
		
		this.resaltardescripcionComisionMarca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionComisionMarca() {
		return this.resaltardescripcionComisionMarca;
	}

	public void setResaltardescripcionComisionMarca(Border borderResaltar) {
		this.resaltardescripcionComisionMarca= borderResaltar;
	}

	public Boolean getMostrardescripcionComisionMarca() {
		return this.mostrardescripcionComisionMarca;
	}

	public void setMostrardescripcionComisionMarca(Boolean mostrardescripcionComisionMarca) {
		this.mostrardescripcionComisionMarca= mostrardescripcionComisionMarca;
	}

	public Boolean getActivardescripcionComisionMarca() {
		return this.activardescripcionComisionMarca;
	}

	public void setActivardescripcionComisionMarca(Boolean activardescripcionComisionMarca) {
		this.activardescripcionComisionMarca= activardescripcionComisionMarca;
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
		
		
		this.setMostraridComisionMarca(esInicial);
		this.setMostrarid_empresaComisionMarca(esInicial);
		this.setMostrarid_comision_configComisionMarca(esInicial);
		this.setMostrarid_vendedorComisionMarca(esInicial);
		this.setMostrarid_lineaComisionMarca(esInicial);
		this.setMostrarid_linea_grupoComisionMarca(esInicial);
		this.setMostrarid_linea_categoriaComisionMarca(esInicial);
		this.setMostrarid_linea_marcaComisionMarca(esInicial);
		this.setMostrarid_estado_comisionComisionMarca(esInicial);
		this.setMostrarporcentajeComisionMarca(esInicial);
		this.setMostrardescripcionComisionMarca(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.ID)) {
				this.setMostraridComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setMostrarid_comision_configComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDESTADOCOMISION)) {
				this.setMostrarid_estado_comisionComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionComisionMarca(esAsigna);
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
		
		
		this.setActivaridComisionMarca(esInicial);
		this.setActivarid_empresaComisionMarca(esInicial);
		this.setActivarid_comision_configComisionMarca(esInicial);
		this.setActivarid_vendedorComisionMarca(esInicial);
		this.setActivarid_lineaComisionMarca(esInicial);
		this.setActivarid_linea_grupoComisionMarca(esInicial);
		this.setActivarid_linea_categoriaComisionMarca(esInicial);
		this.setActivarid_linea_marcaComisionMarca(esInicial);
		this.setActivarid_estado_comisionComisionMarca(esInicial);
		this.setActivarporcentajeComisionMarca(esInicial);
		this.setActivardescripcionComisionMarca(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.ID)) {
				this.setActivaridComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setActivarid_comision_configComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDESTADOCOMISION)) {
				this.setActivarid_estado_comisionComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionComisionMarca(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionMarca(esInicial);
		this.setResaltarid_empresaComisionMarca(esInicial);
		this.setResaltarid_comision_configComisionMarca(esInicial);
		this.setResaltarid_vendedorComisionMarca(esInicial);
		this.setResaltarid_lineaComisionMarca(esInicial);
		this.setResaltarid_linea_grupoComisionMarca(esInicial);
		this.setResaltarid_linea_categoriaComisionMarca(esInicial);
		this.setResaltarid_linea_marcaComisionMarca(esInicial);
		this.setResaltarid_estado_comisionComisionMarca(esInicial);
		this.setResaltarporcentajeComisionMarca(esInicial);
		this.setResaltardescripcionComisionMarca(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.ID)) {
				this.setResaltaridComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setResaltarid_comision_configComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.IDESTADOCOMISION)) {
				this.setResaltarid_estado_comisionComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeComisionMarca(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionMarcaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionComisionMarca(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdComisionConfigComisionMarca=true;

	public Boolean getMostrarFK_IdComisionConfigComisionMarca() {
		return this.mostrarFK_IdComisionConfigComisionMarca;
	}

	public void setMostrarFK_IdComisionConfigComisionMarca(Boolean visibilidadResaltar) {
		this.mostrarFK_IdComisionConfigComisionMarca= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaComisionMarca=true;

	public Boolean getMostrarFK_IdEmpresaComisionMarca() {
		return this.mostrarFK_IdEmpresaComisionMarca;
	}

	public void setMostrarFK_IdEmpresaComisionMarca(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionMarca= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdComisionConfigComisionMarca=true;

	public Boolean getActivarFK_IdComisionConfigComisionMarca() {
		return this.activarFK_IdComisionConfigComisionMarca;
	}

	public void setActivarFK_IdComisionConfigComisionMarca(Boolean habilitarResaltar) {
		this.activarFK_IdComisionConfigComisionMarca= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaComisionMarca=true;

	public Boolean getActivarFK_IdEmpresaComisionMarca() {
		return this.activarFK_IdEmpresaComisionMarca;
	}

	public void setActivarFK_IdEmpresaComisionMarca(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionMarca= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdComisionConfigComisionMarca=null;

	public Border getResaltarFK_IdComisionConfigComisionMarca() {
		return this.resaltarFK_IdComisionConfigComisionMarca;
	}

	public void setResaltarFK_IdComisionConfigComisionMarca(Border borderResaltar) {
		this.resaltarFK_IdComisionConfigComisionMarca= borderResaltar;
	}

	public void setResaltarFK_IdComisionConfigComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdComisionConfigComisionMarca= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaComisionMarca=null;

	public Border getResaltarFK_IdEmpresaComisionMarca() {
		return this.resaltarFK_IdEmpresaComisionMarca;
	}

	public void setResaltarFK_IdEmpresaComisionMarca(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionMarca= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionMarca(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionMarcaBeanSwingJInternalFrame comisionmarcaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionMarca= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}